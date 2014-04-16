package fr.demos.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LignePanier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLignePanier;
	@JoinColumn(name = "idArticle")
	@ManyToOne()
	private Article article;
	@JoinColumn(name = "idPanier")
	@ManyToOne()
	private Panier Panier;
	
	private int qteCommande;

	protected LignePanier() {
		
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Panier getPanier() {
		return Panier;
	}

	public void setPanier(Panier panier) {
		Panier = panier;
	}

	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	public int getIdLignePanier() {
		return idLignePanier;
	}

	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", article="
				+ article + ", Panier=" + Panier + ", qteCommande="
				+ qteCommande + "]";
	}
	
	

	
}
