package fr.demos.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	private String numero;
	private String codepostal;
	private String telephone;
	@JoinColumn(name = "idClient")
	@ManyToOne
	private Client client;

	public String getPays() {
		return pays;
	}

	/**
	 * Constructeur vide pour entité JPA
	 */
	protected Adresse() {}

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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public long getIdAdresse() {
		return idAdresse;
	}

	public Adresse(long idAdresse, String pays, String ville, String rue,
			String numero, String codepostal, String telephone, Client client) {
		super();
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.codepostal = codepostal;
		this.telephone = telephone;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Adresse [idAdresse=" + idAdresse + ", pays=" + pays
				+ ", ville=" + ville + ", rue=" + rue + ", numero=" + numero
				+ ", codepostal=" + codepostal + ", telephone=" + telephone
				+ ", client=" + client + "]";
	}
}
