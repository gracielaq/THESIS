package main;

import Classifier.SVM.Test;
import Classifier.SVM.Train;
import liblinear.InvalidInputDataException;
import ner.SomidiaNERImpl;
import ner.Twokenizer;
import preprocess.csv.CSVPreProcess;
import support.model.Sentence;
import support.model.Token;
import template.TemplateModule;
import template.tempBean;

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
		String[] TrainArgs = { "ModelAndTrain/Category.txt",
				"ModelAndTrain/training" };

		try {
			Train.main(TrainArgs);
		} catch (IOException | InvalidInputDataException e) {
			e.printStackTrace();
		}
		// Test SVM
		String[] testArgs = { "ModelAndTrain/dev_label.txt",
				"ModelAndTrain/dev" };

		try {
			Test.main(testArgs);
		} catch (IOException | InvalidInputDataException e) {
			e.printStackTrace();
		}
        //CHANGE TO WEKA RESOURCES 
        CSVPreProcess.createWekaFile(new File("train.txt"),new File("wekatrain.arff"));
        CSVPreProcess.createWekaFile(new File("test.txt"),new File("wekatest.arff"));
		
        // Start NER
		// Typhoon
		ArrayList<ArrayList<String>> preNER = Twokenizer.tokenizeFile(new File(
				"ModelAndTrain/training/Typhoon"));

		ArrayList<Sentence> postNER = new ArrayList<>();
		for (ArrayList<String> tweet : preNER) {
			SomidiaNERImpl ner = new SomidiaNERImpl();
			Sentence NamedEntities = ner.execute(new Sentence(tweet));
			
			System.out.println(NamedEntities);
			postNER.add(NamedEntities);

			ArrayList<Token> tokenList = TemplateModule.processSentence(NamedEntities);
			for(Token token :tokenList){
				token.PrintToken();
				System.out.print("\n");
			}
			
			tempBean temp = tempBean.createTempBean(tokenList);
			
			String news = TemplateModule.Typhoon(temp);
			System.out.println("NEWS:   "+news);
			
			TemplateModule.createTyphoonFile(news);

		}
		/*
		// Earthquake
		 ArrayList<ArrayList<String>> preNER2=Twokenizer.tokenizeFile(new
		 File("ModelAndTrain/training/Earthquake"));
		  
		  
		 ArrayList<Sentence> postNER2 = new ArrayList<>();
		 
		 for(ArrayList<String> tweet:preNER2){ 
		 
		 	SomidiaNERImpl ner2=new SomidiaNERImpl(); 
		 
		 	Sentence NamedEntities=ner2.execute(new Sentence(tweet)); 
		 
		 	System.out.println(NamedEntities);
		 
		 	postNER2.add(NamedEntities); 
		 
		 }
		
		//Flood
		ArrayList<ArrayList<String>> preNER3 = Twokenizer.tokenizeFile(new File(
				"ModelAndTrain/training/Flood"));

		ArrayList<Sentence> postNER3 = new ArrayList<>();
		for (ArrayList<String> tweet : preNER3) {
			SomidiaNERImpl ner3 = new SomidiaNERImpl();
			Sentence NamedEntities = ner3.execute(new Sentence(tweet));
			
			System.out.println(NamedEntities);
			postNER3.add(NamedEntities);

			ArrayList<Token> tokenList3 = TemplateModule.processSentence(NamedEntities);
			for(Token token :tokenList3){
				token.PrintToken();
				System.out.print("\n");
			}
			
			tempBean temp3 = tempBean.createTempBean(tokenList3);
			
			String news3 = TemplateModule.Flood(temp3);
			System.out.println("NEWS:   "+news3);
			
			TemplateModule.createFloodFile(news3);

		}
		  *
		 */
	}
}
