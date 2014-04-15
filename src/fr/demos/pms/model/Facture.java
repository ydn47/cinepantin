package fr.demos.pms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Facture {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long idFacture;
	private Date dateFacture;
	
	
	protected Facture(){}


	public long getIdFacture() {
		return idFacture;
	}


	public Date getDateFacture() {
		return dateFacture;
	}
	
	
}
