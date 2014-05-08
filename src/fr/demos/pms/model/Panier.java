
package fr.demos.pms.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPanier;

	@JoinColumn(name = "idClient")
	@OneToOne()
	private Client client;
	@Temporal(TemporalType.DATE)
	private Date datePanier;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE}, fetch=FetchType.EAGER)
	private ArrayList<LignePanier> lignesPanier ;
	
	protected Panier() {
		
	}
	

	public Panier(long idPanier) {
		super();
		this.idPanier = idPanier;
		lignesPanier = new ArrayList<LignePanier>();
	}


	public Panier (ArrayList<LignePanier> lignesPanier) {
		
		this.lignesPanier = lignesPanier;
	}

	public Panier(int idPanier, Client client, Date datePanier) {
		super();
		this.idPanier = idPanier;
		this.client = client;
		this.datePanier = datePanier;
	}


	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", client=" + client
				+ ", datePanier=" + datePanier + ", lignesPanier="
				+ lignesPanier + "]";
	}




	public ArrayList<LignePanier> getLignesPanier() {
		return lignesPanier;
	}




	public void setLignesPanier(ArrayList<LignePanier> lignesPanier) {
		this.lignesPanier = lignesPanier;
	}




	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}




	/**
	* on verifie le stock sans retirer
	* si on cherche � ajouter un article deja pr�sent, on augmente la quantite
	* 
	* @param LignePanier
	*/
	
	public void ajouter(Article article, int qte) throws ExceptionStock {
		//System.out.print("isArticleInCart" +isArticleInCart(article));
		if (article.isInStock(qte)){  //la qte demande est disponible
		
			if (isArticleInCart(article)){ //si l'article est deja pr�sent, on agit sur la quantite
				for (LignePanier ligne : lignesPanier) {
					if (ligne.getArticle().equals(article)){
						//System.out.print("isArticleInCart" +article.getIdArticle());
						ligne.setQteCommande(ligne.getQteCommande()+qte);
					}
				}
				
			}else{	 //on ajoute une ligne panier
				LignePanier lp = LignePanierFactory.getNewLignePanier();
				lp.setQteCommande(qte);
				lp.setArticle(article);
				lp.setPanier(this);
				lignesPanier.add(lp);
			}
	
		}else{
			throw new ExceptionStock(article, article.getQteStock(), qte);
		}
	
	}
	public boolean isArticleInCart(Article article) {
		
		boolean res = false;
		if (lignesPanier != null){
			for (LignePanier ligne : lignesPanier) {
				if (ligne.getArticle().equals(article)){
					res = true; break;
				}
			}
		}	
		return res;
	}

	/**
	* Pour simplifier: pas d'exception ou de r�sultat
	* pour indiquer qu'on cherche � supprimer une ligne non pr�sente
	* dans le Panier.
	* @param livre
	*/
	public void retirer(LignePanier ligne) {
	   lignesPanier.remove(ligne);
	      // ligne.getArticle().rajouterAuStock(ligne.getQteCommande());            
	   
	}

	/**
	* typiquement le montant total est un "attribut calcul�".
	* @return
	*/
	public double getMontantTotalHT() {
	   double res = 0. ;
	   for(LignePanier ligne: this.lignesPanier) {
	       res += ligne.getArticle().getPrixUnitArticle() * ligne.getQteCommande();
	   }
	   return res ;
	}
	
	public double getMontantTotalTTC() {
		   double res = 0. ;
		   for(LignePanier ligne: this.lignesPanier) {
		       res += ligne.getArticle().getPrixUnitArticleTTC() * ligne.getQteCommande();
		   }
		   return res ;
		}
	
	public String getMontantTotalTTCFormat() {
		  return Prix.formatPrix(getMontantTotalTTC());
		}
	
	public String getMontantTotalHTFormat() {
		  return Prix.formatPrix(getMontantTotalHT());
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

public long getIdPanier() {
	return idPanier;
}

public void retirer(Article article) {
	System.out.print("isArticleInCart" +isArticleInCart(article));
	if (isArticleInCart(article)){ //si l'article est deja pr�sent, on agit sur la quantite
		for (LignePanier ligne : lignesPanier) {
			if (ligne.getArticle().equals(article)){
				lignesPanier.remove(ligne); break; //
			}
		}
	}else{
		System.out.print("Article n'existe pas ds le pannier");
	}	
}



}


