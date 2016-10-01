package template;

import java.util.ArrayList;
import support.model.Sentence;
import support.model.Token;

public class TemplateModule {

	
	//TEST
	public static void main(String args[]){
		ArrayList<Token> testTokens = new ArrayList<Token>();
		Token token = new Token();
		token.setWord("BAHAY NI JUDE");
		token.setNERTag(tempBean.LOCATION_TAG);
		
		testTokens.add(token);
		
		tempBean temp = tempBean.createTempBean(testTokens);
		
		String result = Typhoon(temp);
		System.out.println(result);
		
	}
	
	//Typhoon Template
public static String Typhoon(tempBean temp){
	//tempBean temp = new tempBean();
	if ((temp.getBilangNgNamatay()!=null & temp.getPangalanNgBagyo()!=null &temp.getLugar() !=null&temp.getPetsa()!=null)){
				return(temp.getBilangNgNamatay() +"ang naitalang patay matapos hagupitin ng Bagyong"
						+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	}
	else if ((temp.getBilangNgSugatan()!=null &temp.getPangalanNgBagyo()!=null &temp.getLugar()!=null &temp.getPetsa()!=null)){
				return(temp.getBilangNgSugatan() +"ang kumpirmadoong sugatan matapos hagupitin ng Bagyong"
					+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	}
	else if((temp.getBilangNgNawawala()!=null &temp.getPangalanNgBagyo()!=null &temp.getLugar()!=null &temp.getPetsa()!=null)){
				return(temp.getBilangNgNawawala() +"ang nawawala matapos hagupitin ng Bagyong"
					+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	}
	else if((temp.getBilangNgNamatay()!=null &temp.getBilangNgNawawala()!=null &temp.getBilangNgSugatan()!=null &temp.getPangalanNgBagyo()!=null &temp.getLugar()!=null &temp.getPetsa()!=null)){
				return(temp.getBilangNgNamatay() +"ang naitalang patay," +temp.getBilangNgNawawala()+ 
					"ang nawawala at"+temp.getBilangNgSugatan()+"ang kumpirmadong sugatan matapos hagupitin ng Bagyong"
					+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	}
	else if(temp.getLugar()!=null){
		return("Nasa ilalim ng Signal #1 ang" +temp.getLugar()+ ", Signal #2 ang "+temp.getLugar()+
			"at ang" +temp.getLugar()+"ay signal #3");
	}
	else if(temp.getPera()!=null){
		return("Umabot sa" +temp.getPera()+ "ang halaga ng nasirang ari-arian at imprastruktura ");
	}
	else if(temp.getKmph()!=null){
		return("Ang nasabing bagyo ay may lakas ng hanging umaabot sa" +temp.getKmph());
	}
	else{
		return "";
	}
	
}
//Earthquake Templates
public static String Earthquake(tempBean temp){
	//tempBean temp = new tempBean();
	if((temp.getLugar()!=null&temp.getPetsa()!=null)){
			return("Isang malakas na lindol ang yumanig sa" +temp.getLugar()+ " noong" +temp.getPetsa());
	}
	else if((temp.getOras()!=null &temp.getMagnitude()!=null &temp.getIntensity()!=null)){
			return("Naitala ang pagyanig noong" +temp.getOras()+ " at may lakas na " +temp.getMagnitude() + 
					"magnitude at intensity na" + temp.getIntensity());
	}
	else if((temp.getBilangNgNamatay()!=null&temp.getMagnitude()!=null&temp.getLugar()!=null)){
				return("Ayon sa reports, may " +temp.getBilangNgNamatay()+ " katao ang nasawi sa" +
						temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	}
	else if((temp.getBilangNgNawawala()!=null &temp.getMagnitude()!=null &temp.getLugar()!=null)){
				return("Ayon sa reports, may " +temp.getBilangNgNawawala()+ " katao ang nawawala sa" +
						temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	}
	else if((temp.getBilangNgSugatan()!=null&temp.getMagnitude()!=null&temp.getLugar()!=null)){
				return("Ayon sa reports, may " +temp.getBilangNgSugatan()+ " katao ang nasugatan sa" +
						temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	}
	else if((temp.getBilangNgNamatay()!=null &temp.getBilangNgNawawala()!=null &temp.getBilangNgSugatan()!=null &temp.getMagnitude()!=null &temp.getLugar()!=null)){
	return("Ayon sa reports, may " +temp.getBilangNgNamatay()+" katao ang nasawi at" 
			+temp.getBilangNgNawawala()+ "ang nawawala at"+temp.getBilangNgSugatan()+ " ang sugatan "
					+ "sa naitalang lindol na may" +temp.getMagnitude() + "magnitude sa " + temp.getLugar());
	}
	else if((temp.getBilangNgAfterShocks()!=null &temp.getMagnitude()!=null & temp.getLugar()!=null)){
	return(temp.getBilangNgAfterShocks()+"aftershocks naman ang naitala mula nang maganap ang lindol na may "
			+temp.getMagnitude()+ " magnitude sa" +temp.getLugar());
	}
	else if((temp.getBilangNgNaapektuhan()!=null &temp.getMagnitude()!=null &temp.getLugar()!=null)){
		return(temp.getBilangNgNaapektuhan()+"ang nasirang ari-arian, gumuhong gusali aat imprastruktura ng "
			+temp.getMagnitude()+ " na lindol sa" +temp.getLugar());
	}
	else{
		return "";
	}
}
//Flood Templates
public static String Flood(tempBean temp){
	//tempBean temp = new tempBean();
	if((temp.getLugar()!=null &temp.getPetsa()!=null)){
		return("Binaha ang ilang parte ng " +temp.getLugar() + "matapos ang matinding buhos ng ulan ngayong "+temp.getPetsa());
	}
	else if((temp.getLebelNgTubig()!=null &temp.getLugar()!=null)){
		return(temp.getLebelNgTubig() + "ang natitalang lalim ng tubig sa "+temp.getLugar()+ "at mga karatig lugar nito");
	}
	else if((temp.getBilangNgNaapektuhan()!=null &temp.getLugar()!=null)){
		return(temp.getBilangNgNaapektuhan() + "katao ang inilikas dahil sa nangyaring pagbaha sa " + temp.getLugar() + "at mga karatig lugar nito");
	}
	else if((temp.getBilangNgNamatay() !=null&temp.getLugar()!=null)){
		return(temp.getBilangNgNamatay() + "ang naitalang namatay dahil sa nangyaring pagbaha sa " + temp.getLugar() + "at mga karatig lugar nito");
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
		if(token.getNERTag()!=null)tokenList.add(token);
	}
	return tokenList;

}





}


