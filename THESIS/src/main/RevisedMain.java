package main;

import Classifier.SVM.Test;
import Classifier.SVM.Train;
import com.sun.nio.sctp.SctpSocketOption;
import gnu.trove.impl.sync.TSynchronizedShortObjectMap;
import liblinear.InvalidInputDataException;
import ner.SomidiaNERImpl;
import ner.Twokenizer;
import org.apache.commons.io.FileUtils;
import preprocess.csv.CSVPreProcess;
import support.model.Sentence;
import support.model.Token;
import template.TemplateModule;
import template.tempBean;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RevisedMain {
	final static String testSetCSV = "Data Sheets/Data Sheet.csv";
	final static String trainingSetCSV = "TrainingSet.csv";
	static String fileCSV="";
	static String fileCSV70="Data Sheet with 30% unrelated tweets.csv";
	static String fileCSV50="Data Sheet with 50% unrelated tweets.csv";
	public static int counterEarthquake,counterTyphoon,counterFlood=0;

	public static void main(String args[]) {


		try {
			FileUtils.cleanDirectory(new File("ModelAndTrain/dev"));
			FileUtils.cleanDirectory(new File("ModelAndTrain/training/Earthquake"));
			FileUtils.cleanDirectory(new File("ModelAndTrain/training/Typhoon"));
			FileUtils.cleanDirectory(new File("ModelAndTrain/training/Flood"));
		} catch (IOException e) {
			e.printStackTrace();
		}


		CSVPreProcess.createTestFiles(new File(fileCSV));
		CSVPreProcess.createTrainingFile(new File(trainingSetCSV));
		//System.out.println("===============" + fileCSV + "===============");

		/*
		 * SVM CLASSIFIER To add more classes, go to ModelAndTrain and add in
		 * Category.txt also add a folder in training in ModelAndTrain and
		 * update dev_label.txt
		 */
		// Train SVM
		String[] TrainArgs = {"ModelAndTrain/Category.txt",
				"ModelAndTrain/training"};

		try {
			Train.main(TrainArgs);
		} catch (IOException | InvalidInputDataException e) {
			e.printStackTrace();
		}


		//File file = getFolderPath();
		// Test SVM
		if(fileCSV50.equals(new File(fileCSV).getName())){
			String[] testArgs = { "ModelAndTrain/dev_label_50.txt",
					"ModelAndTrain/dev" };
			//System.out.println("==========="+testArgs[0]+"=============");
			try {
				Test.main(testArgs);
			} catch (IOException | InvalidInputDataException e) {
				e.printStackTrace();
			}
		}
		else if(fileCSV70.equals(new File(fileCSV).getName())){
			String[] testArgs = { "ModelAndTrain/dev_label_70.txt",
					"ModelAndTrain/dev" };
			//System.out.println("==========="+testArgs[0]+"=============");
			try {
				Test.main(testArgs);
			} catch (IOException | InvalidInputDataException e) {
				e.printStackTrace();
			}
		}
		else{
			String[] testArgs = { "ModelAndTrain/dev_label.txt",
					"ModelAndTrain/dev" };
			//System.out.println("==========="+testArgs[0]+"=============");
			try {
				Test.main(testArgs);
			} catch (IOException | InvalidInputDataException e) {
				e.printStackTrace();
			}
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
			counterTyphoon++;
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
			//System.out.println("====================="+temp.getLugar());
			String news = TemplateModule.Typhoon(temp);
			System.out.println("NEWS: "+news);
			
			TemplateModule.createTyphoonFile(news);

		}
/*
		// Earthquake
		ArrayList<ArrayList<String>> preNER2 = Twokenizer.tokenizeFile(new File(
				"ModelAndTrain/training/Earthquake"));

		ArrayList<Sentence> postNER2 = new ArrayList<>();
		for (ArrayList<String> tweet : preNER2) {

			//NER PROCESS
			SomidiaNERImpl ner2 = new SomidiaNERImpl();
			Sentence NamedEntities2 = ner2.execute(new Sentence(tweet));

			System.out.println(NamedEntities2);
			postNER2.add(NamedEntities2);

			//get the tokens na may tag
			ArrayList<Token> tokenList2 = TemplateModule.processSentence(NamedEntities2);

			//printing tokens na may tag
			for(Token token :tokenList2){
				token.PrintToken();
				System.out.print("\n");
			}

			//nilalagay sa bean yung mga entity
			tempBean temp2 = tempBean.createTempBean(tokenList2);

			//ginagawa yung news based sa bean
			String news2 = TemplateModule.Earthquake(temp2);

			System.out.println("NEWS: "+news2);

			//dito yung paggawa ng file..
			TemplateModule.createEarthquakeFile(news2);

		}
		
		//Flood
		ArrayList<ArrayList<String>> preNER3 = Twokenizer.tokenizeFile(new File(
				"ModelAndTrain/training/Flood"));

		ArrayList<Sentence> postNER3 = new ArrayList<>();
		for (ArrayList<String> tweet : preNER3) {
			SomidiaNERImpl ner3 = new SomidiaNERImpl();
			Sentence NamedEntities3 = ner3.execute(new Sentence(tweet));
			
			System.out.println(NamedEntities3);
			postNER3.add(NamedEntities3);

			ArrayList<Token> tokenList3 = TemplateModule.processSentence(NamedEntities3);
			for(Token token :tokenList3){
				token.PrintToken();
				System.out.print("\n");
			}
			
			tempBean temp3 = tempBean.createTempBean(tokenList3);
			
			String news3 = TemplateModule.Flood(temp3);
			System.out.println("NEWS: "+news3);
			
			TemplateModule.createFloodFile(news3);

		}*/
	}
	public String getFile(File file){
		fileCSV=file+"";
		return fileCSV;
	}


	public static File getFolderPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showDialog(new JFrame(), "SELECT FOLDER") == JFileChooser.APPROVE_OPTION) {
			return chooser.getSelectedFile();
		} else {
			return null;
		}
	}
}
