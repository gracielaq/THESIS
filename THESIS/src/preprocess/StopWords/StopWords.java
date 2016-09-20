package preprocess.StopWords;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StopWords {
	public String StopWordsRemoval(String input) {

		String[] words = input.split(" ");
		ArrayList<String> wordsList = new ArrayList<>();
		Set<String> stopWordsSet = new HashSet<>();
		String postStopWords = "";

		stopWordsSet.add("NA");
		stopWordsSet.add("NG");
		stopWordsSet.add("ANG");
		stopWordsSet.add("MGA");
		stopWordsSet.add("SA");
		stopWordsSet.add("KAY");
		stopWordsSet.add("NI");
		stopWordsSet.add("SI");
		stopWordsSet.add("KINA");
		stopWordsSet.add("NINA");
		stopWordsSet.add("SINA");
		stopWordsSet.add("AT");
		stopWordsSet.add("KAYA");
		stopWordsSet.add("PATI");
		stopWordsSet.add("SAKA");
		stopWordsSet.add("MAGING");
		stopWordsSet.add("MAN");
		stopWordsSet.add("O");
		stopWordsSet.add("KAPAG");
		stopWordsSet.add("KUNG");
		stopWordsSet.add("SAKALI");
		stopWordsSet.add("DATAPWAT");
		stopWordsSet.add("KAHIT");
		stopWordsSet.add("NGUNIT");
		stopWordsSet.add("SAMANTALA");
		stopWordsSet.add("SUBALIT");
		stopWordsSet.add("DAHIL");
		stopWordsSet.add("SAPAGKAT");
		stopWordsSet.add("PARA");
		stopWordsSet.add("UPANG");
		stopWordsSet.add("NANG");
		stopWordsSet.add("ILAMIM");
		stopWordsSet.add("KINAROROONAN");
		stopWordsSet.add("LIKOD");
		stopWordsSet.add("TAAS");
		stopWordsSet.add("NASA");
		stopWordsSet.add("MULA");
		stopWordsSet.add("HANGGANG");
		stopWordsSet.add("PARA");
		stopWordsSet.add("ALINSUNOD");
		stopWordsSet.add("AYON");
		stopWordsSet.add("HINGGIL");
		stopWordsSet.add("PATUNGKOL");
		stopWordsSet.add("TANONG");
		stopWordsSet.add("TUNGKOL");
		stopWordsSet.add("UKOL");
		stopWordsSet.add("WIKA");
		stopWordsSet.add("PAYAG");
		stopWordsSet.add("SANG-AYON");
		stopWordsSet.add("LABAG");
		stopWordsSet.add("LABAN");
		stopWordsSet.add("PAMAMAGITAN");
		stopWordsSet.add("TULONG");

		for (String word : words) {
			String wordCompare = word.toUpperCase();
			if (!stopWordsSet.contains(wordCompare)) {
				wordsList.add(word);
			}
		}

		for (String str : wordsList) {
			postStopWords += str + " ";
			// System.out.print(str+" ");
		}

		return postStopWords;
	}
}
