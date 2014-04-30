package fr.demos.pms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idCommande;
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@JoinColumn(name="idClient")  //le nom de la colone dans la table DVD
	@ManyToOne()
	private Client client;
	
	
	protected Commande(){}

}
