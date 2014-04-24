package fr.demos.pms.model;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.demos.pms.model.ExceptionStock;

@Entity
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArticle;
	private String nomArticle;
	private String shortDescArticle;
	private String longDescArticle;
	// / Commentaire bidon
	private double prixUnitArticle;
	private int qteStock;
	private String urlImage;
	@JoinColumn(name = "idCategorie")
	@ManyToOne()
	private Categorie categorie;
	@JoinColumn(name = "idPlageDePrix")
	@ManyToOne()
	private PlageDePrix plagePrixArticle;

	private HashMap<String, String> proprietes; // a serialiser

	protected Article() {
		// pour Hibernate
	}

	public void retirerDuStock(int nb) throws ExceptionStock {
		if (nb > this.qteStock) {
			throw new ExceptionStock(this, qteStock, nb);
		}
		this.qteStock -= nb;
	}
	
	public boolean isInStock(int nb) {
		if (nb > this.qteStock) {
			//throw new ExceptionStock(this, qteStock, nb);
			return false;
		}else
			return true;
	}

	public void rajouterAuStock(int nb) {
		this.qteStock += nb;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + (int) (idArticle ^ (idArticle >>> 32));
		long temp;
		temp = Double.doubleToLongBits(prixUnitArticle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((proprietes == null) ? 0 : proprietes.hashCode());
		result = prime * result + qteStock;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		if (categorie == null) {
			if (other.categorie != null)
				return false;
		} else if (!categorie.equals(other.categorie))
			return false;
		if (idArticle != other.idArticle)
			return false;
		if (Double.doubleToLongBits(prixUnitArticle) != Double
				.doubleToLongBits(other.prixUnitArticle))
			return false;
		if (proprietes == null) {
			if (other.proprietes != null)
				return false;
		} else if (!proprietes.equals(other.proprietes))
			return false;
		if (qteStock != other.qteStock)
			return false;
		return true;
	}

	
}
