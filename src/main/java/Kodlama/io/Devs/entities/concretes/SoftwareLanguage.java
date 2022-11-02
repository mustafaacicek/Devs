package Kodlama.io.Devs.entities.concretes;



public class SoftwareLanguage extends Entity { // Pojo


	private String languageName;
	
	public SoftwareLanguage() {

	}
	public SoftwareLanguage(int id, String languageName) {
		super(id);
		this.languageName = languageName;
	}
	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
}
