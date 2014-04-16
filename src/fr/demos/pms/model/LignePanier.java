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
	private int idArticle;
	@JoinColumn(name = "idPanier")
	@ManyToOne()
	private int idPanier;
	private int qteCommande;

	protected LignePanier() {
		
	}
	
	public int getIdLignePanier() {
		return idLignePanier;
	}

	public void setIdLignePanier(int idLignePanier) {
		this.idLignePanier = idLignePanier;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public int getIdArticle() {
		return idArticle;
	}


	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	public LignePanier(int idLignePanier, int idArticle, int idPanier,
			int qteCommande) {
		super();
		this.idLignePanier = idLignePanier;
		this.idArticle = idArticle;
		this.idPanier = idPanier;
		this.qteCommande = qteCommande;
	}

	@Override
	public String toString() {
		return "lignePanier [idLignePanier=" + idLignePanier + ", idArticle="
				+ idArticle + ", idPanier=" + idPanier + ", qteCommande="
				+ qteCommande + "]";
	}

	
}
