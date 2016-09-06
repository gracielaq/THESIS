package preprocess.Tokenizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TokenizerNER {
	private static Scanner s;

	public void Tokenize() {
		File folder = new File("ModelAndTrain/training/Earthquake");

		for (File file : folder.listFiles()) {
			try {
				s = new Scanner(file);
				System.out.println(s.nextLine());
				
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}