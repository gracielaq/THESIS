package ner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import support.model.Sentence;
import support.model.Token;

/**
 * Uses SOMIDIA's gazetteer to implement the NER
 * @author Vilson
 *
 */
public class SomidiaNERImpl implements NERInterface {

	@Override
	public Sentence execute(Sentence tweet) {
		// TODO Auto-generated method stub
		File file = new File("ModelAndTrain/NamedEntityRecognizerDictModel");
		Scanner s = null;

		for (int i = 0; i < tweet.getLength(); i++) {
			Token token = tweet.getToken(i);
			String category = null;
			try {
				s = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			while (s.hasNextLine()) {
				String line = s.nextLine().trim();
				if (line.contains("DISASTER")) {
					category = "disaster";
				} else if (line.contains("LOCATION")) {
					category = "location";
				} else if(line.contains("MONTH")){
					category = "month";
				} else if (token.getWord().equalsIgnoreCase(line.toString())) {
					token.setNERTag(category);
					tweet.replaceToken(i, token);
				}
			}

			s.close();
		}

		return tweet;
	}

}
