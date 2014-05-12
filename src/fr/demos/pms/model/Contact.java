package fr.demos.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idContact")
	private long idContact;
	private String demande;
	private String nom;
	private String email;
	
	protected Contact(){
		
	}

	
	public Contact(String demande, String nom, String email) {
		super();
		this.demande = demande;
		this.nom = nom;
		this.email = email;
	}


	public String getDemande() {
		return demande;
	}

	public void setDemande(String demande) {
		this.demande = demande;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
