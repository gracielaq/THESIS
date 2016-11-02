package template;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import support.model.Sentence;
import support.model.Token;

public class TemplateModule {

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
	if(temp.getBilangNgNamatay() != null & temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + ", " + temp.getBilangNgNawawala()+ " at " + temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNamatay() != null & temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + ", " + temp.getBilangNgNawawala()+ " at " + temp.getBilangNgSugatan() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgSugatan() + " at " + temp.getBilangNgNawawala() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgSugatan() + " at " + temp.getBilangNgNawawala() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo()  + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgNawawala() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgNawawala() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNamatay()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNamatay()!=null & temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " at " + temp.getBilangNgSugatan() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgNamatay() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgNawawala() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgNawawala()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgNawawala() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getLugar() != null & temp.getPetsa() != null){
		return temp.getBilangNgSugatan() + " matapos hagupitin ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getBilangNgSugatan()!=null & temp.getPangalanNgBagyo()!=null & temp.getPetsa() != null){
		return temp.getBilangNgSugatan() + " matapos ang paghagupit ng " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getSignal()!=null & temp.getLugar() != null){
		return " Nasa ilalim ng " + temp.getSignal() + " ang " + temp.getLugar();
	}  else if(temp.getPangalanNgBagyo()!=null & temp.getLugar()!=null & temp.getPetsa()!=null){
		return "Tinamaan ng " + temp.getPangalanNgBagyo() + " ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getLugar()!=null & temp.getPetsa()!=null){
		return "Tinamaan ng bagyo ang " + temp.getLugar() + " noong " + convertDate(temp.getPetsa());
	} else if(temp.getPangalanNgBagyo()!=null & temp.getPetsa()!=null){
		return "Namataan sa loob ng Philippine Area of Responsibility ang " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
	} else{
		return "";
	}

}
	//Earthquake Templates
	public static String Earthquake(tempBean temp){
		//tempBean temp = new tempBean();
		if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgNamatay()+", " +temp.getBilangNgSugatan()+ " at "+temp.getBilangNgNawawala() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgNawawala()!=null & temp.getBilangNgSugatan()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " + temp.getBilangNgNawawala()+ " at "+temp.getBilangNgSugatan() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgSugatan()!=null & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " at "+temp.getBilangNgSugatan() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgNawawala()!=null  & temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " at " +temp.getBilangNgNawawala() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgNamatay()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgNamatay() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgSugatan()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgSugatan() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getBilangNgNawawala()!=null & temp.getMagnitude()!=null & temp.getLugar()!=null){
			return("Ayon sa reports, may " +temp.getBilangNgNawawala() + " matapos tumama ang " +temp.getMagnitude() + " na lindol sa " + temp.getLugar()) + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		} else if(temp.getLugar()!=null & temp.getMagnitude()!=null & temp.getPetsa()!=null){
			return "Lindol na may lakas na " + temp.getMagnitude() + " tumama sa " + temp.getLugar() + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
		}else if(temp.getPetsa()!=null & temp.getOras()!=null & temp.getMagnitude()!=null){
			return "Naitala ang pagyanig noong " + temp.getPetsa() + ", " + temp.getOras() + " at may lakas na " + temp.getMagnitude();
		} else if(temp.getLugar()!=null){
			return "Isang malakas na lindol ang tumama sa " + temp.getLugar() + " noong " + convertDate(temp.getPetsa()) + ", " + temp.getOras();
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
		} else if(temp.getPangalanNgBagyo()!=null & temp.getLugar()!=null){
			return "Binaha ang ilang parte ng " + temp.getLugar() + " matapos ang matinding buhos ng ulan dahil sa " + temp.getPangalanNgBagyo() + " noong " + convertDate(temp.getPetsa());
		} else if(temp.getLugar()!=null & temp.getPetsa()!=null){
			return "Binaha ang ilang parte ng " + temp.getLugar() + " matapos ang matinding buhos ng ulan noong " + convertDate(temp.getPetsa());
		} else if(temp.getLugar()!=null & temp.getPetsa()!=null){
			return "May pagbaha sa ibang lugar noong " + convertDate(temp.getPetsa()) + " dahil sa tuloy tuloy na pagbuhos ng ulan";
		} else{
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
    if (news != "") {
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
}

static int counterTyphoon = 0;
public static void createTyphoonFile(String news){
	if(news!=""){
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
}

static int counterFlood = 0;
public static void createFloodFile(String news){
    if(news!=""){
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
}