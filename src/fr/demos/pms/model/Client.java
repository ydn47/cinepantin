package fr.demos.pms.model;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="idClient")
	private long idClient;
	
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	
	protected Client(){}

	
	public Client(String login, String mdp, String nom, String prenom) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
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

	
}
