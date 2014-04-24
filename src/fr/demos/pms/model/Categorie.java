package fr.demos.pms.model;

import javax.persistence.Entity;
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

	public Categorie(long idCategorie, String nomCategorie,
			String descriptionCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie="
				+ nomCategorie + ", descriptionCategorie="
				+ descriptionCategorie + "]";
	}

}
