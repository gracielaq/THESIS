package template;
import java.util.ArrayList;
import java.util.Date;

//copy1
import support.model.*;

public class tempBean {
	private String bilangNgNamatay;
	private String bilangNgSugatan;
	private String bilangNgNawawala;
	private String pangalanNgBagyo;
	private String lugar;
	private String pera;
	private String kmph;
	private String petsa;
	private String magnitude;
	private String intensity;
	private String bilangNgAfterShocks;
	private String bilangNgNaapektuhan;
	private String lebelNgTubig;
	private String oras;
	
	
	
	//TEMPORARY NER TAGS, MODIFY AFTER basta nakumpirma kung ano yung tags talaga
	//hahaha
	final static String NUMBER_OF_DEATHS_TAG="NUMOFDEATHS";
	final static String NUMBER_OF_INJURIES ="NUMOFINJURIES";
	final static String NUMBER_OF_MISSING ="NUMOFMISSING";
	final static String TYPHOON_NAME_TAG = "TYPHOONNAME";
	final static String LOCATION_TAG="LOCATION";
	final static String MONEY_TAG="MONEY";
	final static String KMPH_TAG="KMPH";
	final static String PETSA_TAG="PETSA";
	final static String MAGNITUDE_TAG="MAGNITUDE";
	final static String INTENSITY_TAG="INTENSITY";
	final static String NUMBER_OF_AFTERSHOCKS_TAG="NUMOFAFTERSHOCKS";
	final static String NUMBER_OF_NAAPEKTUHAN_TAG ="NUMOFAFFECTED";
	final static String WATER_LEVEL_TAG ="WATERLEVEL";
	final static String TIME_TAG ="TIME";

	
	
	
	/**
	 * function na nagrereturn ng tempBean na lang wew
	 * @param tokenList a list of Tokens within a tweet with an NER tag
	 * @return a tempBean
	 */
	public static tempBean createTempBean(ArrayList<Token> tokenList){
		tempBean templateBean = new tempBean();
		for(Token token :tokenList){
			//tinitignan ang ner tag ng token at ilalagay sa tempBean 
			//hirap mag-ingles beh
			//hirap kaya magdocument besh, pano nahuhuhu
			switch(token.getNERTag()){
				case NUMBER_OF_DEATHS_TAG:
					templateBean.setBilangNgNamatay(token.getWord());
				break;
				case LOCATION_TAG:
					templateBean.setLugar(token.getWord());
					break;
				case NUMBER_OF_INJURIES:
					templateBean.setBilangNgSugatan(token.getWord());
					break;
				case NUMBER_OF_MISSING:
					templateBean.setBilangNgNawawala(token.getWord());
					break;
				case TYPHOON_NAME_TAG:
					templateBean.setPangalanNgBagyo(token.getWord());
					break;
				case MONEY_TAG:
					templateBean.setPera(token.getWord());
					break;
				case KMPH_TAG:
					templateBean.setKmph(token.getWord());
					break;
				case PETSA_TAG:
					templateBean.setPetsa(token.getWord());
					break;
				case MAGNITUDE_TAG:
					templateBean.setMagnitude(token.getWord());
					break;
				case INTENSITY_TAG:
					templateBean.setIntensity(token.getWord());
					break;
				case NUMBER_OF_AFTERSHOCKS_TAG:
					templateBean.setBilangNgAfterShocks(token.getWord());
					break;
				case NUMBER_OF_NAAPEKTUHAN_TAG:
					templateBean.setBilangNgNaapektuhan(token.getWord());
					break;
				case WATER_LEVEL_TAG:
					templateBean.setLebelNgTubig(token.getWord());
					break;
				case TIME_TAG:
					templateBean.setOras(token.getWord());
					break;
					
				
			}
		}
		return templateBean;
	}
	
	public String getBilangNgNamatay() {
		return bilangNgNamatay;
	}
	public void setBilangNgNamatay(String bilangNgNamatay) {
		this.bilangNgNamatay = bilangNgNamatay;
	}
	public String getBilangNgSugatan() {
		return bilangNgSugatan;
	}
	public void setBilangNgSugatan(String bilangNgSugatan) {
		this.bilangNgSugatan = bilangNgSugatan;
	}
	public String getBilangNgNawawala() {
		return bilangNgNawawala;
	}
	public void setBilangNgNawawala(String bilangNgNawawala) {
		this.bilangNgNawawala = bilangNgNawawala;
	}
	public String getPangalanNgBagyo() {
		return pangalanNgBagyo;
	}
	public void setPangalanNgBagyo(String pangalanNgBagyo) {
		this.pangalanNgBagyo = pangalanNgBagyo;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getPera() {
		return pera;
	}
	public void setPera(String pera) {
		this.pera = pera;
	}
	public String getKmph() {
		return kmph;
	}
	public void setKmph(String kmph) {
		this.kmph = kmph;
	}
	public String getPetsa() {
		return petsa;
	}
	public void setPetsa(String petsa) {
		this.petsa = petsa;
	}
	public String getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(String magnitude) {
		this.magnitude = magnitude;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public String getBilangNgAfterShocks() {
		return bilangNgAfterShocks;
	}
	public void setBilangNgAfterShocks(String bilangNgAfterShocks) {
		this.bilangNgAfterShocks = bilangNgAfterShocks;
	}
	public String getBilangNgNaapektuhan() {
		return bilangNgNaapektuhan;
	}
	public void setBilangNgNaapektuhan(String bilangNgNaapektuhan) {
		this.bilangNgNaapektuhan = bilangNgNaapektuhan;
	}
	public String getLebelNgTubig() {
		return lebelNgTubig;
	}
	public void setLebelNgTubig(String lebelNgTubig) {
		this.lebelNgTubig = lebelNgTubig;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	
	
	
	
	
}
