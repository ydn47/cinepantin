package fr.demos.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlageDePrix {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idPlageDePrix;
	private double prixMin; 
	private double prixMax;
	
	protected PlageDePrix() {
		// hibernate
	}

	public double getPrixMin() {
		return prixMin;
	}

	public void setPrixMin(double prixMin) {
		this.prixMin = prixMin;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public long getIdPlageDePrix() {
		return idPlageDePrix;
	}

	
	public PlageDePrix(long idPlageDePrix, double prixMin, double prixMax) {
		super();
		this.idPlageDePrix = idPlageDePrix;
		// on vérifie si le prix min est inférieur au prix max
		if (prixMin <= prixMax)
		{
			this.prixMin = prixMin;
			this.prixMax = prixMax;
		}
		else // valeurs incohérentes
		{
			// TODO: à voir
		}

	}

	@Override
	public String toString() {
		return "PlageDePrix [idPlageDePrix=" + idPlageDePrix + ", prixMin="
				+ prixMin + ", prixMax=" + prixMax + "]";
	}
	
	
}
