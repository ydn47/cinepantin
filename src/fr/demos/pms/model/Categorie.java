package fr.demos.pms.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Categorie  {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idCategorie;
	private String nomCategorie;
	@Lob
	private byte[] descriptionCategorie;

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public byte[] getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(byte[] descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}

	public long getIdCategorie() {
		return idCategorie;
	}

	protected Categorie() {

	}

	/**
	 * Constructeur par idCategorie
	 * 
	 * @param idCategorie
	 */
	public Categorie(int idCategorie) {
		super();
		this.idCategorie = idCategorie;
	}

	/*
	 * public Categorie(String nomCategorie, String descriptionCategorie) {
	 * super(); this.nomCategorie = nomCategorie; this.descriptionCategorie =
	 * descriptionCategorie; }
	 */

	public Categorie(String nomCategorie, byte[] descriptionCategorie) {
		super();
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}

	/**
	 * Constructeur d'une catégorie. la colonne mappée ave descriptionCatégorie
	 * doit être de type blob.
	 * 
	 * @param idCategorie
	 * @param nomCategorie
	 * @param descriptionCategorie
	 *            : les propriétés sérialisées d'une catégorie
	 */
	public Categorie(long idCategorie, String nomCategorie,
			byte[] descriptionCategorie) {
			this.idCategorie  = idCategorie;
			this.nomCategorie = nomCategorie;
			this.descriptionCategorie = descriptionCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie="
				+ nomCategorie + ", descriptionCategorie="
				+ descriptionCategorie + "]";
	}

	
	public static byte[] serialize(List<?> list) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(list);
		} catch (IOException ioex) {
			throw new IOException("Erreur de sérialisation" + ioex);
		}
		byte buf[] = bos.toByteArray();
		return buf;
	}
	
	public static List<String> deserialize(byte[] buf) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		ObjectInputStream ois;
		
		List<String> list = null;
		try {
			ois = new ObjectInputStream(bis);
			list = (List<String>) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(descriptionCategorie);
		result = prime * result + (int) (idCategorie ^ (idCategorie >>> 32));
		result = prime * result
				+ ((nomCategorie == null) ? 0 : nomCategorie.hashCode());
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
		Categorie other = (Categorie) obj;
		if (!Arrays.equals(descriptionCategorie, other.descriptionCategorie))
			return false;
		if (idCategorie != other.idCategorie)
			return false;
		if (nomCategorie == null) {
			if (other.nomCategorie != null)
				return false;
		} else if (!nomCategorie.equals(other.nomCategorie))
			return false;
		return true;
	}
	
	
}
