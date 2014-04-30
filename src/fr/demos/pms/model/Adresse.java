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
	
	public String getPays() {
		return pays;
	}

	/**
	 * Constructeur vide pour entité JPA
	 */
	protected Adresse() {
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

	public Adresse(long idAdresse, String pays, String ville, String rue,
			String codepostal, String telephone) {
		super();
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.codepostal = codepostal;
		this.telephone = telephone;
	}
	
	/**
	 * Génère une adresse 
	 * @param pays
	 * @param ville
	 * @param rue
	 * @param codepostal
	 * @param telephone
	 */
	public Adresse(String pays, String ville, String rue,
			String codepostal, String telephone) {
		super();
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.codepostal = codepostal;
		this.telephone = telephone;
	}
}
