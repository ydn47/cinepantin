package fr.demos.pms.model;

public enum Devise {
	EUR ("€"), USD("$"), GBP ("£");
	
	private String symbole; //€
	
	Devise (String s){
		symbole = s;
	}
	
	public String getSymbole() {
	    return symbole;
	    }
}
