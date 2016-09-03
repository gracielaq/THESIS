package preprocess.Tokenizer;

//import java.util.HashMap;

public class Tokenizer {
	public void TokenizeStopWords(String postStopWords) {
		String[] x = postStopWords.split(" ");
		
		//HashMap<Integer, String> hash = new HashMap<Integer,String>();
		
		for (int i = 0; i < x.length; i++) {

			if (x[i].isEmpty()) {
				i++;
			}
			if (x[i].startsWith("https") || x[i].startsWith("http")) {
				i++;
			}
			if (x[i].equals("|") || x[i].equals("|via")) {
				i++;
			}
			if (x[i].equals("via")) {
				i++;
			}
			if (x[i].equals("-") || x[i].equals("=")) {
				i++;
			}

			x[i] = x[i].replace(",", "");
			if (x[i].endsWith(":")) {
				x[i] = x[i].replace(":", "");
			}
			if (x[i].endsWith(".")) {
				x[i] = x[i].replace(".", "");
			}
			if (x[i].endsWith("!")) {
				x[i] = x[i].replace("!", "");
			}
			if (x[i].endsWith("-")) {
				x[i] = x[i].replace("-", "");
			}
			x[i] = x[i].replace(" ", "");
			x[i] = x[i].replace(";", "");
			x[i] = x[i].replace("(", "");
			x[i] = x[i].replace(")", "");

			System.out.println("-" + x[i]);
			//hash.put(i, x[i]);
		}
	}
}
