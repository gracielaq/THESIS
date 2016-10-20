package preprocess.csv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

;

public class CSVPreProcess {

    public static int testid=0;
    public static int trainid=0;
    public static int counterEarthquake=0,counterFlood=0,counterTyphoon=0;
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
  

    public static void createTestFiles(File testCSVFile){
        String testFilePath="ModelAndTrain/dev";
        List<String[]> testList = processCSV(testCSVFile);
        try{
            BufferedReader b =new BufferedReader(new FileReader("result.txt"));
            testid=0;
            //Skip the first line
            for (int currentRow = 1; currentRow < testList.size(); currentRow++) {
                String result=b.readLine();
                String[] s=result.split(" ");

                //create test files in dev/Earthquake
                if(s[1].equals("0")){
                    File file = new File(testFilePath+"/"+"Earthquake"+"/"+(++testid)+".txt");
                    FileWriter fileWriter;
                    counterEarthquake++;
                    try {
                        fileWriter = new FileWriter(file);
                        // System.out.println("CREATE TEST "+file.getPath());
                        fileWriter.append(testList.get(currentRow)[1]);
                        fileWriter.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //create test files in dev/Flood
                else if(s[1].equals("1")){
                    File file = new File(testFilePath+"/"+"Flood"+"/"+(++testid)+".txt");
                    FileWriter fileWriter;
                    counterFlood++;
                    try {
                        fileWriter = new FileWriter(file);
                        // System.out.println("CREATE TEST "+file.getPath());
                        fileWriter.append(testList.get(currentRow)[1]);
                        fileWriter.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //create test files for dev/Typhoon
                else if(s[1].equals("2")){
                    File file = new File(testFilePath+"/"+"Typhoon"+"/"+(++testid)+".txt");
                    FileWriter fileWriter;

                    counterTyphoon++;

                    try {
                        fileWriter = new FileWriter(file);
                        // System.out.println("CREATE TEST "+file.getPath());
                        fileWriter.append(testList.get(currentRow)[1]);
                        fileWriter.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //create test files for dev/Others
                else{
                    File file = new File(testFilePath+"/"+"Others"+"/"+(++testid)+".txt");
                    FileWriter fileWriter;

                    try {
                        fileWriter = new FileWriter(file);
                        // System.out.println("CREATE TEST "+file.getPath());
                        fileWriter.append(testList.get(currentRow)[1]);
                        fileWriter.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for (int currentRow = 1; currentRow <testList.size() ; currentRow++) {
            File file = new File(testFilePath+"/"+(++trainid)+".txt");
            try {
                FileWriter fileWriter = new FileWriter(file);
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
                fileWriter.append("USER: ").append(trainingList.get(currentRow)[0]).append("TIME: ").append(trainingList.get(currentRow)[3]).append(" ");
                fileWriter.append(trainingList.get(currentRow)[2]);
               // System.out.println("CREATE TEST "+file.getPath());

                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createWekaFile(File testFile, File outputFile){
        //File outputFile = new File("testWekaFile1.arff");
        try {
            FileWriter fileWriter = new FileWriter(outputFile, false);

            fileWriter.append("@relation DISASTER\n\n")
                    .append("@attribute category {0,1,2,3}\n");
            int numberOfUniqueWords = getNumberOfUniqueWords();
            for(int x=1;x<numberOfUniqueWords;x++){
                fileWriter.append("@attribute word").append(x+" {TRUE,FALSE}\n");
            }
            fileWriter.append("\n@data\n");

            BufferedReader bufferedReader = new BufferedReader(new FileReader(testFile));
            String line;
            while((line=bufferedReader.readLine())!=null){
                Map<Integer, Integer> map = getMap(line);

                fileWriter.append(""+map.get(0));
                for (int index = 1; index < numberOfUniqueWords; index++) {
                    fileWriter.append(",");
                    if(map.containsKey(index)){
                        fileWriter.append("TRUE");
                    }else{
                        fileWriter.append("FALSE");
                    }
                }
                fileWriter.append("\n");
            }


            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int getNumberOfUniqueWords(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("unique_words.txt"));
            return bufferedReader.readLine().split(",").length;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static Map<Integer, Integer> getMap(String line){
        String[] data = line.split(" ");

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,Integer.parseInt(data[0]));

        //skip the first element kasi yun yung category
        for (int index = 1; index < data.length; index++) {
            String[] keyAndValue = data[index].split(":");
            map.put(Integer.parseInt(keyAndValue[0]),(int)(Math.round(Double.parseDouble(keyAndValue[1]))));
        }

        return map;

    }

}
