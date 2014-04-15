package fr.demos.pms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idCommande;
	private Date dateCommande;
	
	private Client client;
	
	
	protected Commande(){}

}
