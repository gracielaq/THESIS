package template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import support.model.Sentence;
import support.model.Token;

public class TemplateModule {

	
	//TEST
	public static void main(String args[]){
		ArrayList<Token> testTokens = new ArrayList<Token>();
		Token token = new Token();
		token.setWord("ANTIPOLO");
		token.setNERTag(tempBean.LOCATION_TAG);
		Token token2= new Token(); 
		token2.setWord("ABRIL 29");
		token2.setNERTag(tempBean.PETSA_TAG);
		
		testTokens.add(token);
		testTokens.add(token2);
	
		tempBean temp = tempBean.createTempBean(testTokens);
		
		String result = Earthquake(temp);
		System.out.println(result);
		
		createEarthquakeFile(result);
		createTyphoonFile(result);
		createFloodFile(result);
	}

	public static String convertDate(String getPetsa){
		String original[] = getPetsa.split("/");
		String converted = "";

		if(original[2].matches("\\d\\d")){
			original[2] = "20" + original[2];
		}

		switch (original[0]){
			case "1":
				converted = "January " + original[1] + ", " + original[2];
				break;
			case "2":
				converted = "February " + original[1] + ", " + original[2];
				break;
			case "3":
				converted = "March " + original[1] + ", " + original[2];
				break;
			case "4":
				converted = "April " + original[1] + ", " + original[2];
				break;
			case "5":
				converted = "May " + original[1] + ", " + original[2];
				break;
			case "6":
				converted = "June " + original[1] + ", " + original[2];
				break;
			case "7":
				converted = "July " + original[1] + ", " + original[2];
				break;
			case "8":
				converted = "August " + original[1] + ", " + original[2];
				break;
			case "9":
				converted = "September " + original[1] + ", " + original[2];
				break;
			case "10":
				converted = "October " + original[1] + ", " + original[2];
				break;
			case "11":
				converted = "November " + original[1] + ", " + original[2];
				break;
			case "12":
				converted = "December " + original[1] + ", " + original[2];
				break;
		}
		return converted;
	}

	//Typhoon Template
public static String Typhoon(tempBean temp){
	//tempBean temp = new tempBean();
    if(temp.getBilangNgNawawala() != null & temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
        return temp.getBilangNgNawawala() + " at " + temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + temp.getPetsa();
    } else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNawawala() + " at " + temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + temp.getPetsa();
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgNawawala() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + temp.getPetsa();
	} else if(temp.getBilangNgNamatay()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + temp.getPetsa();
	} else if(temp.getSignal()!=null & temp.getLugar() != null){
        return " Nasa ilalaim ng " + temp.getSignal() + " ang " + temp.getLugar();
    } else if ((((temp.getBilangNgNamatay()!=null)|(temp.getBilangNgSugatan()!=null)|(temp.getBilangNgNawawala()!=null)) & temp.getPangalanNgBagyo()!=null & temp.getLugar() !=null & temp.getPetsa()!=null)){
        return temp.getBilangNgNamatay() +" matapos hagupitin ng Bagyong " +temp.getPangalanNgBagyo()+" ang "+temp.getLugar()+" noong "+convertDate(temp.getPetsa());
    } else{
		return "";
	}
	
}
    //Earthquake Templates
public static String Earthquake(tempBean temp){
	//tempBean temp = new tempBean();
	if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgNamatay()+", " +temp.getBilangNgNawawala()+ " at "+temp.getBilangNgSugatan() + " sa lindol na may naitalang lakas na " +temp.getMagnitude() + " sa " + temp.getLugar());
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " + temp.getBilangNgNawawala()+ " at "+temp.getBilangNgSugatan() + " sa lindol na may naitalang lakas na " +temp.getMagnitude() + " sa " + temp.getLugar());
    } else if(temp.getBilangNgSugatan()!=null & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " at "+temp.getBilangNgSugatan() + " sa lindol na may naitalang lakas na " +temp.getMagnitude() + " sa " + temp.getLugar());
    } else if(temp.getBilangNgNawawala()!=null  & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " at " +temp.getBilangNgNawawala() + " sa lindol na may naitalang lakas na " +temp.getMagnitude() + " sa " + temp.getLugar());
    } else if(temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " dahil sa " +temp.getMagnitude() + " na lindol na tumama sa " + temp.getLugar());
    } else if(temp.getBilangNgSugatan()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgSugatan() + " dahil sa " +temp.getMagnitude() + " na lindol na tumama sa " + temp.getLugar());
    } else if(temp.getBilangNgNawawala()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
        return("Ayon sa reports, may " +temp.getBilangNgNawawala() + " dahil sa " +temp.getMagnitude() + " na lindol na tumama sa " + temp.getLugar());
    } if(temp.getPetsa()!=null & temp.getOras()!=null & temp.getMagnitude()!=null){
        return "Naitala ang pagyanig noong " + temp.getPetsa() + ", " + temp.getOras() + " at may lakas na " + temp.getMagnitude();
    } else if(temp.getLugar()!=null & temp.getPetsa()!=null){
        return "Isang malakas na lindol ang tumama sa " + temp.getLugar() + " noong " + temp.getPetsa();
    }
	else{
		return "";
	}
}
//Flood Templates
public static String Flood(tempBean temp){
	//tempBean temp = new tempBean();
	if(temp.getLebelNgTubig()!=null & temp.getLugar()!=null){
        return temp.getLebelNgTubig() + " ang naitalang lalim ng tubig sa " + temp.getLugar() + " at mga karatig na lugar nito.";
    } else if(temp.getLugar()!=null & temp.getPetsa()!=null){
        return "Binaha ang ilang parte ng " + temp.getLugar() + " matapos ang matinding buhos ng ulan ngayong " + temp.getPetsa();
    }
	else{
		return "";
	}
}


/**
 * The method thart =osafjjsdbfj buibjhfsuhsdfnsdiof
 * @param sentence the sendihsadf jposajdf;
 * @return aiorhaornklcjasndjashjkdasbuiasbd
 */
public static ArrayList<Token> processSentence(Sentence sentence){
	
	ArrayList<Token> tokenList = new ArrayList<>();
	for(Token token:sentence.getSentence()){

		//if hindi null yung tag, named entite siya
		if(token.getNERTag()!=null)tokenList.add(token);
	}
	return tokenList;

}

static int counterEarthquake = 0;
public static void createEarthquakeFile(String news){
	File file = new File("EarthquakeNewsReport");
	file.mkdir();
	File textFile = new File(file.getPath()+File.separator+"Earthquake News Report"+ (++counterEarthquake)+".txt");
	try{
	FileWriter fw = new FileWriter(textFile);
	fw.append(news);
	fw.close();
	System.out.println("FILE CREATED: " +textFile.getName());
	}catch(Exception e){
		System.out.println("ERROR IN CREATING TEXTFILE");
		e.printStackTrace();
	}
}

static int counterTyphoon = 0;
public static void createTyphoonFile(String news){
	
	
	File file = new File("TyphoonNewsReport");
	file.mkdir();
	File textFile = new File(file.getPath()+File.separator+"Typhoon News Report"+ (++counterTyphoon)+".txt");
	try{
	FileWriter fw = new FileWriter(textFile);
	fw.append(news);
	fw.close();
	System.out.println("FILE CREATED: "+textFile.getName());
	}catch(Exception e){
		System.out.println("ERROR IN CREATING TEXTFILE");
		e.printStackTrace();
	}
}

static int counterFlood = 0;
public static void createFloodFile(String news){
	File file = new File("FloodNewsReport");
	file.mkdir();
	File textFile = new File(file.getPath()+File.separator+"Flood News Report"+ (++counterFlood)+".txt");
	try{
	FileWriter fw = new FileWriter(textFile);
	fw.append(news);
	fw.close();
	System.out.println("FILE CREATED: "+textFile.getName());
	}catch(Exception e){
		System.out.println("ERROR IN CREATING TEXTFILE");
		e.printStackTrace();
	}
}
}