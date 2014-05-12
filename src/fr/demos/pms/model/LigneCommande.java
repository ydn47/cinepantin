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
	
	//@JoinColumn(name="idCommande")  //le nom de la colone dans la table commande
	//@ManyToOne()
	private Commande commande;

	protected LigneCommande(){
		
	}
	
	
	public LigneCommande(int qteCommandee, Article article, Commande commande) {
		super();
		this.qteCommandee = qteCommandee;
		this.article = article;
		this.commande = commande;
	}


	public long getIdLigneCommande() {
		return idLigneCommande;
	}

	public void setIdLigneCommande(long idLigneCommande) {
		this.idLigneCommande = idLigneCommande;
	}

	public int getQteCommandee() {
		return qteCommandee;
	}

	public void setQteCommandee(int qteCommandee) {
		this.qteCommandee = qteCommandee;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	

}
