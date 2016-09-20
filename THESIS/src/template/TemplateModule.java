package template;

import java.util.ArrayList;

import support.model.Sentence;
import support.model.Token;

public class TemplateModule {

	int bilangNgNamatay, 
	bilangNgSugatan, 
	bilangNgNawawala,
	pera, 
	kmph,
	magnitude, 
	intensity,
	bilangNgAfterShocks,
	bilangNgNaapektuhan,
	lebelNgTubig,
	petsa;
	
	String pangalanNgBagyo, lugar; 


public static void main(String args[]) {
	tempBean temp = new tempBean();
	
	//Typhoon Template
	//if(temp.getBilangNgNamatay()&&temp)
	System.out.println(+temp.getBilangNgNamatay() +"ang naitalang patay matapos hagupitin ng Bagyong"
	+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	
	System.out.println(+temp.getBilangNgSugatan() +"ang kumpirmadoong sugatan matapos hagupitin ng Bagyong"
			+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	
	System.out.println(+temp.getBilangNgNamatay() +"ang naitalang patay matapos hagupitin ng Bagyong"
			+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	
	System.out.println(+temp.getBilangNgNawawala() +"ang nawawala matapos hagupitin ng Bagyong"
			+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	
	System.out.println(+temp.getBilangNgNamatay() +"ang naitalang patay," +temp.getBilangNgNawawala()+ 
			"ang nawawala at"+temp.getBilangNgSugatan()+"ang kumpirmadong sugatan matapos hagupitin ng Bagyong"
			+temp.getPangalanNgBagyo()+"ang"+temp.getLugar()+"noong"+temp.getPetsa());
	
	System.out.println("Nasa ilalim ng Signal #1 ang" +temp.getLugar()+ ", Signal #2 ang "+temp.getLugar()+
			"at ang" +temp.getLugar()+"ay signal #3");
	
	System.out.println("Umabot sa" +temp.getPera()+ "ang halaga ng nasirang ari-arian at imprastruktura ");
	
	System.out.println("Ang nasabing bagyo ay may lakas ng hanging umaabot sa" +temp.getKmph());
	
	//Earthquake Templates
	System.out.println("Isang malakas na lindol ang yumanig sa" +temp.getLugar()+ " noong" +temp.getPetsa());
	
	System.out.println("Naitala ang pagyanig noong" +temp.getOras()+ " at may lakas na " +temp.getMagnitude() + 
			"magnitude at intensity na" + temp.getIntensity());
	
	System.out.println("Ayon sa reports, may " +temp.getBilangNgNamatay()+ " katao ang nasawi sa" +
	temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	
	System.out.println("Ayon sa reports, may " +temp.getBilangNgNawawala()+ " katao ang nawawala sa" +
			temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	
	System.out.println("Ayon sa reports, may " +temp.getBilangNgSugatan()+ " katao ang nasugatan sa" +
			temp.getMagnitude() + "magnitude na lindol sa " + temp.getLugar());
	
	System.out.println("Ayon sa reports, may " +temp.getBilangNgNamatay()+" katao ang nasawi at" 
			+temp.getBilangNgNawawala()+ "ang nawawala at"+temp.getBilangNgSugatan()+ " ang sugatan "
					+ "sa naitalang lindol na may" +temp.getMagnitude() + "magnitude sa " + temp.getLugar());
	
	System.out.println(temp.getBilangNgAfterShocks()+"aftershocks naman ang naitala mula nang maganap ang lindol na may "+temp.getMagnitude()+ " magnitude sa" +temp.getLugar());
	
	System.out.println(temp.getBilangNgNaapektuhan()+"ang nasirang ari-arian, gumuhong gusali aat imprastruktura ng "
			+temp.getMagnitude()+ " na lindol sa" +temp.getLugar());
	
	//Flood Templates
	System.out.println("Binaha ang ilang parte ng " +temp.getLugar() + "matapos ang matinding buhos ng ulan ngayong "+temp.getPetsa());
	
	System.out.println(temp.getLebelNgTubig() + "ang natitalang lalim ng tubig sa "+temp.getLugar()+ "at mga karatig lugar nito");
	
	System.out.println(temp.getBilangNgNaapektuhan() + "katao ang inilikas dahil sa nangyaring pagbaha sa " + temp.getLugar() + "at mga karatig lugar nito");
	
	System.out.println(temp.getBilangNgNamatay() + "ang naitalang namatay dahil sa nangyaring pagbaha sa " + temp.getLugar() + "at mga karatig lugar nito");
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


