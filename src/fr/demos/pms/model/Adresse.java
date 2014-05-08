package fr.demos.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Classe de gestion des adresses client
 * 
 * @author Yann-Dara Nong
 * 
 */
@Entity
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdresse;
	private String pays;
	private String ville;
	private String rue;
	private String codepostal;
	private String telephone;
	private String nom;
	private String prenom;
	
	
	
	/**
	 * Constructeur vide pour entité JPA
	 */
	
	protected Adresse() {
	}

	public Adresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}
	
	public Adresse(String pays, String ville, String rue, String codepostal,
			String telephone, String nom, String prenom) {
		super();
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.codepostal = codepostal;
		this.telephone = telephone;
		this.nom = nom;
		this.prenom = prenom;
	}
	


	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((codepostal == null) ? 0 : codepostal.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((pays == null) ? 0 : pays.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result
				+ ((telephone == null) ? 0 : telephone.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (codepostal == null) {
			if (other.codepostal != null)
				return false;
		} else if (!codepostal.equals(other.codepostal))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (pays == null) {
			if (other.pays != null)
				return false;
		} else if (!pays.equals(other.pays))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (telephone == null) {
			if (other.telephone != null)
				return false;
		} else if (!telephone.equals(other.telephone))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setIdAdresse(long idAdresse) {
		this.idAdresse = idAdresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public long getIdAdresse() {
		return idAdresse;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", pays=" + pays
				+ ", ville=" + ville + ", rue=" + rue + ", codepostal="
				+ codepostal + ", telephone=" + telephone + "]";
	}

}	