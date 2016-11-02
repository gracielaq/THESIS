package ner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
				if (line.contains("LOCATION")) {
					category = "LOCATION";
				}else if (token.getWord().equalsIgnoreCase(line.toString())) {
					token.setNERTag(category);
					tweet.replaceToken(i, token);
				}else if(Pattern.matches("\\d+,?\\s([a-z]*,?\\s)*#*([Nn]amatay|[Pp]atay|[Nn]asawi|[Dd]ead)"
						,token.getWord())){
					token.setNERTag("NUMOFDEATHS");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\d+\\s([a-z]*\\s)*#*([Ss]ugatan|[Ii]njured)"
						,token.getWord())){
					token.setNERTag("NUMOFINJURIES");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\d+\\s([a-z]*\\s)*#*(([Nn]asalanta)|([Nn]aapektuhan))"
                        ,token.getWord())){
                    token.setNERTag("NUMOFAFFECTED");
                    tweet.replaceToken(i, token);
                    break;
                }else if(Pattern.matches("\\d+\\s([a-z]*\\s)*#*([Nn]awawala)|([Mm]issing)"
						,token.getWord())){
					token.setNERTag("NUMOFMISSING");
					tweet.replaceToken(i, token);
					break;
				} else if(token.getWord().startsWith("#") && !token.getWord().startsWith("Earthquake", 1) && token.getWord().endsWith("PH")){
					String name = token.getWord().replace("PH", "");
					token.setWord(name);
					token.setNERTag("TYPHOON-NAME");
					tweet.replaceToken(i, token);
					break;
				} else if(Pattern.matches("(#)*(((B|b)agyong)|(T|t)yphoon)(\\s#*(P|p)apangalanang)*\\s?('*([A-Za-z]+'*)|('*#([A-Za-z])+'*))"
						,token.getWord())){
					token.setNERTag("TYPHOON-NAME");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(([Mm]agnitude\\s?[^a-zA-Z^0-9]\\s?\\d(.\\d)?)|(\\d(.\\d)?\\s?[^a-zA-Z^0-9]\\s?[Mm]agnitude))"
						,token.getWord())){
					token.setNERTag("MAGNITUDE");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(\\b[Ss]ignal)\\s?((#(\\s)?\\d)|([Nn]o(.)*\\d)|\\d)"
						,token.getWord())){
					token.setNERTag("SIGNAL");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(\\d+:\\d+\\s*([A|a|P|p][M|m])*)|(\\d+([Aa]|[Pp])[Mm])"
						,token.getWord())){
					token.setNERTag("TIME");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(((([Jj]an(uary)?) |([Ee]nero))| (([Ff]eb(ruary)?)|([Pp]ebrero))|" +
								"(([Mm]ar(ch)?)|([Mm]arso)) | (([Aa]pr(il)?)|([Aa]bril))|" +
								"([Mm]ay(o)?) | (([Jj]un(e)?)|([Hh]unyo))|" +
								"(([Jj]ul(y)?)|([Hh]ulyo)) | (([Aa]ug(ust)?)|([Aa]gosto))|" +
								"(([Ss]ept(ember)?)|([Ss]etyembre)) | (([Oo]ct(ober)?)|([Oo]ktubre))|" +
								"(([Nn]ov(ember)?)|([Nn]obyembre)) | (([Dd]ec(ember)?)|([Dd]isyembre)))" +
								"\\s\\d{1,2}(,\\s(\\d{4}|\\d{2}))*)"
						,token.getWord())){
					token.setNERTag("DATE");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(\\d{1,2}[/]\\d{1,2}[/](\\d{4}|\\d{2}))"
						,token.getWord())){
					token.setNERTag("DATE");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("\\d+\\s((kph)|(kmph))"
						,token.getWord())){
					token.setNERTag("KMPH");
					tweet.replaceToken(i, token);
					break;
				}else if(Pattern.matches("(([A-Za-z]+(\\s)*(-)*(deep))|(lagpas-tao))"
                        ,token.getWord())){
                    token.setNERTag("WATERLEVEL");
                    tweet.replaceToken(i, token);
                    break;
                }
			}
			s.close();
		}
		return tweet;
	}

}