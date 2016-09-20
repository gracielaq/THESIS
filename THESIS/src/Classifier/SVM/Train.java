package Classifier.SVM;

import java.io.File;
import java.io.IOException;

import liblinear.InvalidInputDataException;
import liblinear.Linear;
import liblinear.Model;
import liblinear.Parameter;
import liblinear.Problem;
import liblinear.SolverType;

public class Train
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
		classifier.buildTrainData( args[ 0 ], args[ 1 ] );

		long end = System.currentTimeMillis();
		System.out.println( "Time taken to build train file = " + (end - start) + " msec" );
		Linear.disableDebugOutput();
		start = System.currentTimeMillis();
		File file = new File( classifier.OUTPUT_TRAIN_FILE );
		Problem prob = Problem.readFromFile( file, 1 );

		SolverType solver = SolverType.L2R_L2LOSS_SVC; // -s 0
		double C = 0.006;// cost of constraints violation
		double eps = 0.001; // stopping criteria

		Parameter parameter = new Parameter( solver, C, eps );
		Model model = Linear.train( prob, parameter );
		File modelFile = new File( classifier.OUTPUT_MODEL_FILE );
		model.save( modelFile );
		System.out.println( "Finished writing model file - " + classifier.OUTPUT_MODEL_FILE );
		end = System.currentTimeMillis();
		System.out.println( "Time taken to train SVM = " + (end - start) + " msec" );
	}

}
