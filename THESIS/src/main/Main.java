package main;

import java.io.*;
import java.util.HashMap;

import Classifier.SVM.Train;
import preprocess.CSVReader.CsvReader;
import preprocess.StopWords.StopWords;
import preprocess.Tokenizer.Tokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		
		try{
			CsvReader tweet = new CsvReader("Data Sheet.csv");
            StopWords stop= new StopWords();
            Tokenizer tokenize=new Tokenizer();
            HashMap<Integer, String> hash = new HashMap<Integer, String>();
            
            tweet.readHeaders();
            
            while(tweet.readRecord()){
                String date = tweet.get("Date");
                String tw = tweet.get("Tweet");
                String mention = tweet.get("Mention");
                
                /*
                CSV READER
                    Returns SOP of tweets in data sheet
                */
                //System.out.println(date + " " + tw + " " + mention );
                
                /*
                Stop Words Removal
                   Returns SOP of whole tweet without Stop Words 
                */
                String postStopWords= stop.StopWordsRemoval(date + " " + tw + " " + mention +"\n");
                tokenize.TokenizeStopWords(postStopWords);
               // hash.put(1, "#EarthquakePH");
               // System.out.println("key: 1 " + "value: " + hash.get(1));
                
                /*Train Files*/
                String[] train={"ModelAndTrain/Category.txt","ModelAndTrain/Train"};
                System.out.println(train[0]+ " " + train[1]);
                Train.main(train);
            }
            
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();    
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
