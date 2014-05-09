package fr.demos.pms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idFacture;
	@Temporal(TemporalType.DATE)
	private Date dateFacture;
	
	@JoinColumn(name="idClient")  //le nom de la colone dans la table DVD
	@OneToOne()
	private Client client;
	
	@JoinColumn(name="idCommande")  //le nom de la colone dans la table DVD
	@OneToOne()
	private Commande commande;
	private double totalTTC;
	private double totalHT;
	private double totalTVA;
	
	
	protected Facture(){}


	public long getIdFacture() {
		return idFacture;
	}


	public Date getDateFacture() {
		return dateFacture;
	}
	
	
}
