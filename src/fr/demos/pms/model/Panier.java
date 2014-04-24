package fr.demos.pms.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPanier;

	@JoinColumn(name = "idClient")
	@OneToOne()
	private Client client;
	@Temporal(TemporalType.DATE)
	private Date datePanier;
	private ArrayList<LignePanier> lignesPanier ;
	
	public Panier() {
		
	}
	
	
	
	
	public Panier(int idPanier, Client client, Date datePanier,
			ArrayList<LignePanier> lignesPanier) {
		super();
		this.idPanier = idPanier;
		this.client = client;
		this.datePanier = datePanier;
		this.lignesPanier = lignesPanier;
	}




	/**
	* on verifie le stock sans retirer
	* si on cherche à ajouter un article deja présent, on augmente la quantite
	* 
	* @param LignePanier
	*/
	
	public void ajouter(Article article, int qte) throws ExceptionStock {
		
		if (article.isInStock(qte)){  //la qte demande est disponible
		
			if (isArticleInCart(article)){ //si l'article est deja présent, on agit sur la quantite
				for (LignePanier ligne : lignesPanier) {
					if (ligne.getArticle().equals(article)){
						ligne.setQteCommande(qte);
					}
				}
				
			}else{	 //on ajoute une ligne panier
				LignePanier lp = new LignePanier(qte, article, this);
				lignesPanier.add(lp);
			}
	
		}else{
			throw new ExceptionStock(article, article.getQteStock(), qte);
		}
	
	}
	public boolean isArticleInCart(Article article) {
		
		boolean res = false;
		for (LignePanier ligne : lignesPanier) {
			if (ligne.getArticle().equals(article)){
				res = true; break;
			}
		}
		return res;
	}

	/**
	* Pour simplifier: pas d'exception ou de résultat
	* pour indiquer qu'on cherche à supprimer une ligne non présente
	* dans le Panier.
	* @param livre
	*/
	public void retirer(LignePanier ligne) {
	   lignesPanier.remove(ligne);
	      // ligne.getArticle().rajouterAuStock(ligne.getQteCommande());            
	   
	}

	/**
	* typiquement le montant total est un "attribut calculé".
	* @return
	*/
	public double getMontantTotalHT() {
	   double res = 0. ;
	   for(LignePanier ligne: this.lignesPanier) {
	       res += ligne.getArticle().getPrixUnitArticle() * ligne.getQteCommande();
	   }
	   return res ;
	}

public Client getClient() {
	return client;
}



public void setClient(Client client) {
	this.client = client;
}



public Date getDatePanier() {
	return datePanier;
}

public void setDatePanier(Date datePanier) {
	this.datePanier = datePanier;
}

public int getIdPanier() {
	return idPanier;
}

public Panier(int idPanier, int idClient, Date datePanier) {
	super();
	this.idPanier = idPanier;
	this.client = client;
	this.datePanier = datePanier;
}

@Override
public String toString() {
	return "Panier [idPanier=" + idPanier + ", idClient=" + client.getIdClient()
			+ ", datePanier=" + datePanier + "]";
}

}
