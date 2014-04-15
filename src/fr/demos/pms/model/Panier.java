package fr.demos.pms.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Panier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPanier;

	@JoinColumn(name = "idClient")
	@OneToOne()
	private int idClient;

	private Date datePanier;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
		this.idClient = idClient;
		this.datePanier = datePanier;
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", idClient=" + idClient
				+ ", datePanier=" + datePanier + "]";
	}

}
