package main;

import Classifier.SVM.Test;
import Classifier.SVM.Train;
import au.com.bytecode.opencsv.CSVWriter;
import liblinear.InvalidInputDataException;
import ner.SomidiaNERImpl;
import ner.Twokenizer;
import preprocess.csv.CSVPreProcess;
import support.model.Sentence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RevisedMain {
	final static String testSetCSV = "Data Sheet.csv";
	final static String trainingSetCSV = "TrainingSet.csv";

	public static void main(String args[]) {
		CSVPreProcess.createTestFiles(new File(testSetCSV));
		CSVPreProcess.createTrainingFile(new File(trainingSetCSV));
		/*
		 * SVM CLASSIFIER To add more classes, go to ModelAndTrain and add in
		 * Category.txt also add a folder in training in ModelAndTrain and
		 * update dev_label.txt
		 */
		// Train SVM
		String[] TrainArgs = { "ModelAndTrain/Category.txt", "ModelAndTrain/training" };

		try {
			Train.main(TrainArgs);
		} catch (IOException | InvalidInputDataException e) {
			e.printStackTrace();
		}
		// Test SVM
		String[] testArgs = { "ModelAndTrain/dev_label.txt", "ModelAndTrain/dev" };

		try {
			Test.main(testArgs);
		} catch (IOException | InvalidInputDataException e) {
			e.printStackTrace();
		}
		// convert unique_words.txt to csv headers
		/*CONVERT TO WEKA RESOURCES*/
		try {
			// read unique_words.txt
			BufferedReader br = new BufferedReader(new FileReader("unique_words.txt"));

			String words = br.readLine();

			String csv = "./WekaResources/DataSet.csv";
			CSVWriter writer = new CSVWriter(new FileWriter(csv));

			String[] header = words.split(",");
			writer.writeNext(header);
			List<String[]> allData = new ArrayList<String[]>();
			for (int i = 0; i < 3; i++) {
				String[] data = new String[] { "Blogger" + i, "20" + i, "20.0002", i + " World Wide Web" };
				allData.add(data);
			}

			writer.writeAll(allData);
			writer.close();

			System.out.println("Finished writing Weka DataSet - " + csv);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//Start NER
		//start twokenizer
		
		ArrayList<String> preNER=Twokenizer.tokenizeFile(new File("ModelAndTrain/training/Earthquake"));
		SomidiaNERImpl ner=new SomidiaNERImpl();
		ner.execute(new Sentence(preNER));

	}
}
