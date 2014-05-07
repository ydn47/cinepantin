package fr.demos.pms.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idCommande;
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	private double totalTTC;
	private String commentaire;
	private String typePaiement;
	
	@JoinColumn(name="idClient")  //le nom de la colone dans la table DVD
	@ManyToOne()
	private Client client;
	
	private ArrayList<LigneCommande> lignesCommande ;
	
	public double getTotalTTC() {
		return totalTTC;
	}


	public void setTotalTTC(double totalTTC) {
		this.totalTTC = totalTTC;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}


	public String getTypePaiement() {
		return typePaiement;
	}


	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}


	public ArrayList<LigneCommande> getLignesCommande() {
		return lignesCommande;
	}


	public void setLignesCommande(ArrayList<LigneCommande> lignesCommande) {
		this.lignesCommande = lignesCommande;
	}


	protected Commande(){}

	
	public Commande(Date dateCommande, Client client) {
		super();
		
		this.dateCommande = dateCommande;
		this.client = client;
	}


	public long getIdCommande() {
		return idCommande;
	}


	public void setIdCommande(long idCommande) {
		this.idCommande = idCommande;
	}


	public Date getDateCommande() {
		return dateCommande;
	}


	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	

}
