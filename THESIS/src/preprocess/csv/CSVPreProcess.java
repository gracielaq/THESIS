package preprocess.csv;

import java.io.*;
import java.util.Collections;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class CSVPreProcess {

    public static int testid=0;
    public static int trainid=0;
    public static List<String[]> processCSV(File csvFile){
        List myEntries;
        try {
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            myEntries = reader.readAll();
        } catch (IOException e) {
            e.printStackTrace();
            myEntries=null;
        }
        return myEntries;
    }
    public static void main(String args[]){
        createTrainingFile(new File("TrainingSet.csv"));
        createTestFiles(new File("Data Sheet.csv"));
    }

    public static void createTestFiles(File testCSVFile){
        String testFilePath="ModelAndTrain/dev";
        List<String[]> testList = processCSV(testCSVFile);

        //Skip the first line
        for (int currentRow = 1; currentRow < testList.size(); currentRow++) {
            File file = new File(testFilePath+"/"+(++testid)+".txt");
            FileWriter fileWriter;
            try {
                fileWriter = new FileWriter(file);
                fileWriter.append(testList.get(currentRow)[1]);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public static void createTrainingFile(File trainingCSVFile){
        String trainingFilePath="ModelAndTrain/training";
        List<String[]> trainingList = processCSV(trainingCSVFile);

        //skip the first line
        for (int currentRow = 1; currentRow <trainingList.size() ; currentRow++) {
            String category = trainingList.get(currentRow)[1];
            File file = new File(trainingFilePath+"/"+category+"/"+(++trainid)+".txt");
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.append("USER:").append(trainingList.get(currentRow)[0]).append(" ");
                fileWriter.append(trainingList.get(currentRow)[2]);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




}
