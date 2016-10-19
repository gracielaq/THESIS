package Classifier.SVM;

import java.io.IOException;

import liblinear.InvalidInputDataException;
import liblinear.Linear;
import liblinear.Predict;

public class Test
{
	public static void main( String[] args ) throws IOException, InvalidInputDataException
	{
		if ( args.length != 2 )
		{
			System.out.println( "Please pass file path of class_name.txt and training folder" );
			return;
		}

		long start = System.currentTimeMillis();
		Classifier classifier = new Classifier();
		classifier.buildTestFile( args[ 0 ], args[ 1 ] );
		long end = System.currentTimeMillis();
		//buildTestTime(end,start);

		start = System.currentTimeMillis();
		Linear.disableDebugOutput();
		String[] param = new String[ 3 ];
		param[ 0 ] = classifier.OUTPUT_TEST_FILE;
		param[ 1 ] = classifier.OUTPUT_MODEL_FILE;
		param[ 2 ] = classifier.OUTPUT_RESULT_FILE;
		Linear.enableDebugOutput();
		Predict.main( param );
		end = System.currentTimeMillis();
		//classifyTime(end,start);
		classifier.writeResultFile();
	}

	public static String buildTestTime(long end, long start){
		return "Time taken to build test file= " + (end - start) + " msec";
	}
	public static String classifyTime(long end, long start){
		return "Time taken to classify = " + (end - start) + " msec";
	}
}