package ner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

import support.model.Sentence;
import support.model.Token;

/**
 * Uses SOMIDIA's gazetteer to implement the NER
 * 
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
				} else if (line.contains("MONTH")) {
					category = "month";
				} else if (line.contains("DAY")) {
					category = "day";
				} else if (token.getWord().equalsIgnoreCase(line.toString())) {
					token.setNERTag(category);
					tweet.replaceToken(i, token);
				}else if(Pattern.matches("\\d+\\s([a-z]*\\s)*(namatay|patay|nasawi)"
						,token.getWord())){
					token.setNERTag("NUMOFDEATHS");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\d+\\s([a-z]*\\s)*(sugatan)"
						,token.getWord())){
					token.setNERTag("NUMOFINJURIES");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\d+\\s([a-z]*\\s)*(nawawala)"
						,token.getWord())){
					token.setNERTag("NUMOFMISSING");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(#)*(((B|b)agyong)|(T|t)yphoon)(\\s#*(P|p)apangalanang)*\\s'*(([A-Za-z]+'*)|('*#([A-Za-z])+'*))"
						,token.getWord())){
					token.setNERTag("TYPHOON-NAME");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\s*((\\d)|(\\d.\\d))*\\s(([Mm]agnitude)|([Mm]ag))\\s((\\d.\\d)|(\\d))*"
						,token.getWord())){
					token.setNERTag("MAGNITUDE");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(\\b[Ss]ignal)\\s((#(\\s)*\\d)|([Nn]o(.)*\\d))"
						,token.getWord())){
					token.setNERTag("SIGNAL");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(([Mm]ar(ch)*)|(Marso))\\s\\d{1,2},\\s(\\d{4}|\\d{2})"
						,token.getWord())){
					token.setNERTag("PETSA");
					tweet.replaceToken(i, token);
					break;
				}
			}

			s.close();
		}

		return tweet;
	}

}
