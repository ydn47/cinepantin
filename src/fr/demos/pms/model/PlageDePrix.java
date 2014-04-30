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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (idPlageDePrix ^ (idPlageDePrix >>> 32));
		long temp;
		temp = Double.doubleToLongBits(prixMax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(prixMin);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlageDePrix other = (PlageDePrix) obj;
		if (idPlageDePrix != other.idPlageDePrix)
			return false;
		if (Double.doubleToLongBits(prixMax) != Double
				.doubleToLongBits(other.prixMax))
			return false;
		if (Double.doubleToLongBits(prixMin) != Double
				.doubleToLongBits(other.prixMin))
			return false;
		return true;
	}
	
	
}
