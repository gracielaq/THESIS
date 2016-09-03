package main;

import Classifier.SVM.Test;
import Classifier.SVM.Train;
import liblinear.InvalidInputDataException;
import preprocess.csv.CSVPreProcess;

import java.io.File;
import java.io.IOException;

public class RevisedMain {
    final static String testSetCSV = "Data Sheet.csv";
    final static String trainingSetCSV="TrainingSet.csv";
    public static void main(String args[]){
    	CSVPreProcess.createTestFiles(new File(testSetCSV));
        CSVPreProcess.createTrainingFile(new File(trainingSetCSV));
    	/* SVM CLASSIFIER
         * To add more classes, go to ModelAndTrain and add in Category.txt
         * also add a folder in training in ModelAndTrain
         * and update dev_label.txt
         * */
        String[] TrainArgs = {"ModelAndTrain/Category.txt","ModelAndTrain/training"};

        try {
            Train.main(TrainArgs);
        } catch (IOException | InvalidInputDataException e) {
            e.printStackTrace();
        }

        String[] testArgs ={"ModelAndTrain/dev_label.txt","ModelAndTrain/dev"};

        try {
            Test.main(testArgs);
        } catch (IOException | InvalidInputDataException e) {
            e.printStackTrace();
        }
        
    }
}
