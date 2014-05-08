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
	private long idLignePanier;
	private int qteCommande;
	
	@JoinColumn(name = "idArticle")
	@ManyToOne()
	private Article article;
	
	@JoinColumn(name = "idPanier")
	@ManyToOne()
	private Panier Panier;
	
	

	protected LignePanier() {
		
	}

	
	

	public LignePanier(int qteCommande, Article article,Panier panier) {
		super();
		this.qteCommande = qteCommande;
		this.article = article;
		Panier = panier;
	}




	public LignePanier(long idLignePanier) {
		super();
		this.idLignePanier = idLignePanier;
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

	public long getIdLignePanier() {
		return idLignePanier;
	}
	
	public double getTotalTTC() {
		return article.getPrixUnitArticleTTC() * getQteCommande();
		}
	public String getTotalTTCFormat() {
		return Prix.formatPrix(getTotalTTC());
		}
	@Override
	public String toString() {
		return "LignePanier [idLignePanier=" + idLignePanier + ", article="
				+ article.getIdArticle() + ", Panier=" + Panier.getIdPanier() + ", qteCommande="
				+ qteCommande + "]";
	}




	




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LignePanier other = (LignePanier) obj;
		if (Panier == null) {
			if (other.Panier != null)
				return false;
		} else if (!Panier.equals(other.Panier))
			return false;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (idLignePanier != other.idLignePanier)
			return false;
		return true;
	}
	

	
}


