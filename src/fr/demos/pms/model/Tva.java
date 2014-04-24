package fr.demos.pms.model;

public enum Tva {
	 REDUIT(5.5), NORMAL(20.0), LUXE(33.3);
	   
	   final double valeur;
	   
	   Tva (double v) {
	       this.valeur = v;
	   }
	   public double getValeur() {
	       return this.valeur;
	   }

}
