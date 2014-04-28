package fr.demos.pms.model;

public class PanierFactory {
	 static long _currentId = 1;
	  
	   public static Panier getNewPanier(){
	    Panier l = new Panier(_currentId);
	    _currentId += 1;
	    return l;
	  }

}
