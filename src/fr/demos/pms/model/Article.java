package fr.demos.pms.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArticle;
	private String nomArticle;
	private String shortDescArticle;
	private String longDescArticle;
	/// Commentaire bidon
	private double prixUnitArticle;
	private int qteStock;
	private String urlImage;
	@JoinColumn(name = "idCategorie")
	@ManyToOne()
	private Categorie categorie;
	@JoinColumn(name = "idPlageDePrix")
	@ManyToOne()
	private PlageDePrix plagePrixArticle;
	
	private HashMap<String, String> proprietes ; //a serialiser
	protected Article() {
		// pour Hibernate
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getShortDescArticle() {
		return shortDescArticle;
	}

	public void setShortDescArticle(String shortDescArticle) {
		this.shortDescArticle = shortDescArticle;
	}

	public String getLongDescArticle() {
		return longDescArticle;
	}

	public void setLongDescArticle(String longDescArticle) {
		this.longDescArticle = longDescArticle;
	}

	public double getPrixUnitArticle() {
		return prixUnitArticle;
	}

	public void setPrixUnitArticle(double prixUnitArticle) {
		this.prixUnitArticle = prixUnitArticle;
	}

	public int getQteStock() {
		return qteStock;
	}

	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}

	public long getIdArticle() {
		return idArticle;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public PlageDePrix getPlagePrixArticle() {
		return plagePrixArticle;
	}

	public void setPlagePrixArticle(PlageDePrix plagePrixArticle) {
		this.plagePrixArticle = plagePrixArticle;
	}



	public Article(long idArticle, String nomArticle, String shortDescArticle,
			String longDescArticle, double prixUnitArticle, int qteStock,
			String urlImage, Categorie categorie, PlageDePrix plagePrixArticle,
			HashMap<String, String> proprietes) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.shortDescArticle = shortDescArticle;
		this.longDescArticle = longDescArticle;
		this.prixUnitArticle = prixUnitArticle;
		this.qteStock = qteStock;
		this.urlImage = urlImage;
		this.categorie = categorie;
		this.plagePrixArticle = plagePrixArticle;
		this.proprietes = proprietes;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle
				+ ", shortDescArticle=" + shortDescArticle
				+ ", longDescArticle=" + longDescArticle + ", prixUnitArticle="
				+ prixUnitArticle + ", qteStock=" + qteStock + ", urlImage="
				+ urlImage + ", categorie=" + categorie + ", plagePrixArticle="
				+ plagePrixArticle + ", proprietes=" + proprietes + "]";
	}
	

	// TODO : générer méthodes equals et hashcode
}
