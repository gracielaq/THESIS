package main;

import Classifier.SVM.Test;
import Classifier.SVM.Train;
import liblinear.InvalidInputDataException;
import preprocess.csv.CSVPreProcess;

import java.io.File;
import java.io.IOException;

/**
 * Created by jude8 on 9/3/2016.
 */
public class RevisedMain {
    final static String testSetCSV = "Data Sheet.csv";
    final static String trainingSetCSV="TrainingSet.csv";
    public static void main(String args[]){
        //comment if there are new testFiles
        CSVPreProcess.createTestFiles(new File(testSetCSV));
        CSVPreProcess.createTrainingFile(new File(trainingSetCSV));

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
