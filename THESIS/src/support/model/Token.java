package support.model;

public class Token {
	private String Word;
	private String POSTag;
	private String NERTag;
	
	/**
	 * @return the word
	 */
	public String getWord() {
		return Word;
	}
	/**
	 * @param word the word to set
	 */
	public void setWord(String word) {
		//System.out.println("TOKEN:"+word);
		Word = word;
	}
	/**
	 * @return the pOSTag
	 */
	public String getPOSTag() {
		return POSTag;
	}
	/**
	 * @param pOSTag the pOSTag to set
	 */
	public void setPOSTag(String pOSTag) {
		POSTag = pOSTag;
	}
	/**
	 * @return the nERTag
	 */
	public String getNERTag() {
		return NERTag;
	}
	/**
	 * @param nERTag the nERTag to set
	 */
	public void setNERTag(String nERTag) {
		NERTag = nERTag;
	}
	
	public void PrintToken(){
		String word = this.Word;
		
		if(this.POSTag != null){
			word = word + "_" + this.POSTag;
		}
		
		if(this.NERTag != null){
			word += "<"+this.NERTag+":"+word + "/>";
		}	
	
		System.out.print("\""+word+"\",");
	}

}
