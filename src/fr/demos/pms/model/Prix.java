package fr.demos.pms.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * @author Yann-Dara Nong
 */
@Entity
public class Prix {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPrix;
	private double valeur;
	private Devise devise;

	public double getValeur() {
		return valeur;
	}

	public Prix(double valeur) {
		this(String.valueOf(valeur));
	}
	
	/**
	 * Construit le prix d'un article. La valeur est d'abord v�rifi�e
	 * @param la valeur entr�e en tant que String
	 */
	public Prix(String valeur) {
		super();
		// on v�rifie le format de la valeur entr�e
		try {
			if (checkValeur(valeur))
			{
				// on supprime les z�ros en d�but de cha�ne, sauf s'il n'y en a qu'un seul avant la virgule
				valeur.replaceAll("^0+", "");
				// on remplace la virgule par un point
				valeur.replace(",",".");
				this.valeur = Double.parseDouble(valeur);
			}
		} catch (ExceptionPrix e) {
			System.err.println("Exception Prix" + e);
		} catch (NumberFormatException nbf) {
			System.err.println("Erreur de conversion de format" + nbf);
		}
		this.devise = Devise.EUR;
	}

	/*
	public double getPrixTTC(double prix) {

		return valeur * (1 + tva.getValeur()) / 100.;

	}*/
	
	/**
	 * V�rifie le format du prix
	 * Format : une suite de chiffres , ne commen�ant pas par 0, pouvant contenir une virgule ou un point, 
	 * suivi de 2 d�cimales. Il faut au moins un chiffre avant la virgule, pouvant �tre �gal � 0.
	 * @param la cha�ne de caract�res contenant la valeur
	 * @return vrai si la valeur est correctement format�e, faux sinon
	 * @throws un objet ExceptionPrix
	 */
	public boolean checkValeur(String valeur) throws ExceptionPrix
	{
		boolean res = true;
		// explication du pattern: au moins 1 chiffre, 1 virgule ou 1 point, puis de 0 � 2 chiffres
		final Pattern pattern = Pattern.compile("\\d{1,}(,|\\.){1}\\d{,2}"); 
		Matcher matcher = pattern.matcher(valeur);
		if (!matcher.find()) 
		{
			res = false;
			throw new ExceptionPrix("Format de prix invalide");
		}
		return res;
	}

	/**
	 * Conversion d'un double en cha�ne de caract�re
	 * @param la valeur en double
	 * @return une cha�ne de caract�re repr�sentant le prix
	 */
	public static String formatPrix(double valeur) {
		// on arrondit la valeur � 2 chiffres apr�s la virgule
		double valeurArrondie = Math.round(valeur * 100) / 100.0;
		
		// on formate le prix en pla�ant des points tous les milliers, et une virgule pour s�parer des centimes
		// DecimalFormat formatter = new DecimalFormat("###,###0.00");
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		DecimalFormat formatter = new DecimalFormat("###,###0.00", dfs);
		String res = formatter.format(valeurArrondie);
		return res;
	}
	
	public void setValeur(double valeur) {
		this.valeur = valeur;
	}

	public Devise getDevise() {
		return devise;
	}

	/*
	 * n'est pas negatif, 2 chiffre apres la virgue, devise : en Euros TVA HT et
	 * TTC
	 */
	
}
