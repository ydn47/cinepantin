package fr.demos.pms.model;

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
	private double prixUnitArticle;
	private int qteStock;
	@JoinColumn(name = "idCategorie")
	@ManyToOne()
	private Categorie categorie;
	@JoinColumn(name = "idPlageDePrix")
	@ManyToOne()
	private PlageDePrix plagePrixArticle;

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
			Categorie categorie, PlageDePrix plagePrixArticle) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.shortDescArticle = shortDescArticle;
		this.longDescArticle = longDescArticle;
		this.prixUnitArticle = prixUnitArticle;
		this.qteStock = qteStock;
		this.categorie = categorie;
		this.plagePrixArticle = plagePrixArticle;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nomArticle=" + nomArticle
				+ ", shortDescArticle=" + shortDescArticle
				+ ", longDescArticle=" + longDescArticle + ", prixUnitArticle="
				+ prixUnitArticle + ", qteStock=" + qteStock + ", categorie="
				+ categorie + ", plagePrixArticle=" + plagePrixArticle + "]";
	}

	// TODO : générer méthodes equals et hashcode
}
