package fr.demos.pms.model;

/**
 * Gestion des exceptions de prix
 * @author Yann-Dara Nong
 *
 */
public class ExceptionPrix extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String chaine;

	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;
	}

	public ExceptionPrix(String chaine) {
		super();
		this.chaine = chaine;
	}
	
}
