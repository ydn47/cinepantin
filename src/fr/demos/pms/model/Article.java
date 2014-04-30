package fr.demos.pms.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import fr.demos.pms.serial.SerialArticle;

@Entity
public class Article implements SerialArticle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArticle;
	private String nomArticle;
	private String shortDescArticle;
	private String longDescArticle;
	// / Commentaire bidon
	private double prixUnitArticle;
	@Enumerated(EnumType.STRING)
	private Tva tva;

	private int qteStock;
	private String urlImage;
	@JoinColumn(name = "idCategorie")
	@ManyToOne()
	private Categorie categorie;
	@JoinColumn(name = "idPlageDePrix")
	@ManyToOne()
	private PlageDePrix plagePrixArticle;

	// private HashMap<String, String> proprietes; // a serialiser
	@Lob
	private byte[] serialProprietes;

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
			// throw new ExceptionStock(this, qteStock, nb);
			return false;
		} else
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

	/**
	 * Constructeur qui prend un hashmap en tant que propriétés
	 * 
	 * @return un article créé avec un HashMap
	 */
	public Article(long idArticle, String nomArticle, String shortDescArticle,
			String longDescArticle, double prixUnitArticle, Tva tva,
			int qteStock, String urlImage, Categorie categorie,
			PlageDePrix plagePrixArticle, HashMap<String, String> proprietes) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.shortDescArticle = shortDescArticle;
		this.longDescArticle = longDescArticle;
		this.prixUnitArticle = prixUnitArticle;
		this.tva = tva;
		this.qteStock = qteStock;
		this.urlImage = urlImage;
		this.categorie = categorie;
		this.plagePrixArticle = plagePrixArticle;
		try {
			this.serialProprietes = serialize(proprietes);
		} catch (IOException e) {
			System.err.println("Erreur de conversion du HashMap");
		}
	}

	public Article(long idArticle, String nomArticle, String shortDescArticle,
			String longDescArticle, double prixUnitArticle, Tva tva,
			int qteStock, String urlImage, Categorie categorie,
			PlageDePrix plagePrixArticle, byte[] serialProprietes) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.shortDescArticle = shortDescArticle;
		this.longDescArticle = longDescArticle;
		this.prixUnitArticle = prixUnitArticle;
		this.tva = tva;
		this.qteStock = qteStock;
		this.urlImage = urlImage;
		this.categorie = categorie;
		this.plagePrixArticle = plagePrixArticle;
		this.serialProprietes = serialProprietes;
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
				+ ", longDescArticle=" + longDescArticle
				+ ", prixUnitArticle="
				+ prixUnitArticle
				+ ", "
				// + "tva=" + tva.valeur + ","
				+ " qteStock=" + qteStock + ", urlImage=" + urlImage
				+ ", categorie=" + categorie + ", plagePrixArticle="
				+ plagePrixArticle + ", serialProprietes="
				+ Arrays.toString(serialProprietes) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categorie == null) ? 0 : categorie.hashCode());
		result = prime * result + (int) (idArticle ^ (idArticle >>> 32));
		result = prime * result
				+ ((longDescArticle == null) ? 0 : longDescArticle.hashCode());
		result = prime * result
				+ ((nomArticle == null) ? 0 : nomArticle.hashCode());
		result = prime
				* result
				+ ((plagePrixArticle == null) ? 0 : plagePrixArticle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prixUnitArticle);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + qteStock;
		result = prime * result + Arrays.hashCode(serialProprietes);
		result = prime
				* result
				+ ((shortDescArticle == null) ? 0 : shortDescArticle.hashCode());
		result = prime * result + ((tva == null) ? 0 : tva.hashCode());
		result = prime * result
				+ ((urlImage == null) ? 0 : urlImage.hashCode());
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
		if (longDescArticle == null) {
			if (other.longDescArticle != null)
				return false;
		} else if (!longDescArticle.equals(other.longDescArticle))
			return false;
		if (nomArticle == null) {
			if (other.nomArticle != null)
				return false;
		} else if (!nomArticle.equals(other.nomArticle))
			return false;
		if (plagePrixArticle == null) {
			if (other.plagePrixArticle != null)
				return false;
		} else if (!plagePrixArticle.equals(other.plagePrixArticle))
			return false;
		if (Double.doubleToLongBits(prixUnitArticle) != Double
				.doubleToLongBits(other.prixUnitArticle))
			return false;
		if (qteStock != other.qteStock)
			return false;
		if (!Arrays.equals(serialProprietes, other.serialProprietes))
			return false;
		if (shortDescArticle == null) {
			if (other.shortDescArticle != null)
				return false;
		} else if (!shortDescArticle.equals(other.shortDescArticle))
			return false;
		if (tva != other.tva)
			return false;
		if (urlImage == null) {
			if (other.urlImage != null)
				return false;
		} else if (!urlImage.equals(other.urlImage))
			return false;
		return true;
	}

	public Tva getTva() {
		return tva;
	}

	public void setTva(Tva tva) {
		this.tva = tva;
	}

	@Override
	public byte[] serialize(HashMap<?, ?> hashmap) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(hashmap);
		} catch (IOException ioex) {
			throw new IOException("Erreur de sérialisation" + ioex);
		}
		byte buf[] = bos.toByteArray();
		return buf;
	}

	@Override
	public HashMap<String, String> deserialize(byte[] bytes) {
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		ObjectInputStream ois;

		HashMap<String, String> hm = null;
		try {
			ois = new ObjectInputStream(bis);
			hm = (HashMap<String, String>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		return hm;
	}

	/**
	 * Retourne les propriétés sérialisées de l'article
	 * 
	 * @return les propriétés sérialisées de l'article
	 */
	public byte[] getSerialProprietes() {
		return serialProprietes;
	}

	/**
	 * Méthode qui renvoie les propriétés désérialisées d'un article
	 * 
	 * @return toutes les proprietes d'un article
	 */
	public HashMap<String, String> getProprietes() {
		// on vérifier qu'il existe des propriétés sérialisées
		return (this.getSerialProprietes() == null) ? null : deserialize(this.getSerialProprietes());
	}
}
