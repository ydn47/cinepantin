package fr.demos.pms.model;

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
	
	protected Panier() {
		
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
