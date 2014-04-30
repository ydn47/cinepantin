package fr.demos.pms.model;

public class LignePanierFactory {
	 static long _currentId = 1;
	  
	   public static LignePanier getNewLignePanier(){
	    LignePanier l = new LignePanier(_currentId);
	    _currentId += 1;
	    return l;
	  }

}
