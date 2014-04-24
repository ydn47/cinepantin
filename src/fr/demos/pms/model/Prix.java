package fr.demos.pms.model;

public class Prix {
	
	private double valeur ;
	private Devise devise;
	
	private Tva tva;
	public double getValeur() {
		return valeur;
	}
	
	
	public Prix(double valeur, Devise devise, Tva tva) {
		super();
		this.valeur = valeur;
		this.devise = devise;
		this.tva = tva;
	}
	


	public Prix(double valeur) {
		super();
		this.valeur = valeur;
		this.devise = Devise.EUR;  // 
		this.tva = Tva.NORMAL;	
	}
	
	public double getPrixTTC (double prix){
		
		return valeur *(1 +tva.getValeur())/100.;
		
	}


	public void setValeur(double valeur) {
		this.valeur = valeur;
	}
	public Devise getDevise() {
		return devise;
	}
	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	public Tva getTva() {
		return tva;
	}
	public void setTva(Tva tva) {
		this.tva = tva;
	}
	
	/*n'est pas negatif, 
	2 chiffre apres la virgue,
	 devise : en Euros
		TVA HT et TTC
	*/
	
}
