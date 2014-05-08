package fr.demos.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idLigneCommande;
	private int qteCommandee;
	
	@JoinColumn(name="idArticle")  //le nom de la colone dans la table DVD
	@ManyToOne()
	private Article article;
	
	@JoinColumn(name="idCommande")  //le nom de la colone dans la table commande
	@ManyToOne()
	private Commande commande;
	
	

}
