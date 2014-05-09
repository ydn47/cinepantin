package fr.demos.pms.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategorie;
	private String nomCategorie;
	private String descriptionCategorie;

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}

	public long getIdCategorie() {
		return idCategorie;
	}

	protected Categorie() {
		
	}
	
	
	/**
	 * Constructeur par idCategorie
	 * @param idCategorie
	 */
	public Categorie(long idCategorie) {
		super();
		this.idCategorie = idCategorie;
	}

	public Categorie(String nomCategorie,
			String descriptionCategorie) {
		super();
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie="
				+ nomCategorie + ", descriptionCategorie="
				+ descriptionCategorie + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((descriptionCategorie == null) ? 0 : descriptionCategorie
						.hashCode());
		result = prime * result + (int) (idCategorie ^ (idCategorie >>> 32));
		result = prime * result
				+ ((nomCategorie == null) ? 0 : nomCategorie.hashCode());
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
		Categorie other = (Categorie) obj;
		if (descriptionCategorie == null) {
			if (other.descriptionCategorie != null)
				return false;
		} else if (!descriptionCategorie.equals(other.descriptionCategorie))
			return false;
		if (idCategorie != other.idCategorie)
			return false;
		if (nomCategorie == null) {
			if (other.nomCategorie != null)
				return false;
		} else if (!nomCategorie.equals(other.nomCategorie))
			return false;
		return true;
	}

	
}
