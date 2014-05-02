package fr.demos.pms.model;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idClient")
	private long idClient;

	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private int newsletter;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Adresse adresseFacturation;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Adresse adresseLivraison;

	protected Client() {}

	public Client(long idClient, String login, String mdp, String nom,
			String prenom, int newsletter, Adresse adresseFacturation,
			Adresse adresseLivraison) {
		super();
		this.idClient = idClient;
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.newsletter = newsletter;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public Client(String nom, String prenom, String login, String mdp,
			int newsletter) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.newsletter = newsletter;
	}
	
	/**
	 * Constructeur ajoutant les addresses de livraison et de facturation
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param mdp
	 * @param newsletter
	 * @param adresseFacturation
	 * @param adresseLivraison
	 */
	public Client(String nom, String prenom, String login, String mdp,
			int newsletter, Adresse adresseFacturation,
			Adresse adresseLivraison ) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.newsletter = newsletter;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
	}

	public long getIdClient() {
		return idClient;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public int getNewsletter() {
		return newsletter;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", login=" + login + ", mdp="
				+ mdp + ", nom=" + nom + ", prenom=" + prenom + ", newsletter="
				+ newsletter + ", adresseFacturation=" + adresseFacturation
				+ ", adresseLivraison=" + adresseLivraison + "]";
	}

	public Adresse getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(Adresse adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public Adresse getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(Adresse adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

}
