package fr.demos.pms.serial;

import java.io.IOException;
import java.util.HashMap;

/**
 * Interface regroupant les m�thodes de s�rialisation en BDD des articles 
 * 
 * @author Yann-Dara Nong
 *
 */
public interface SerialArticle {
	/**
	 * M�thode de s�rialisation des propri�t�s d'un article
	 * @param un HashMap contenant les propri�t�s de l'article
	 * @return un tableau d'octets contenant l'objet s�rialis�
	 */
	public byte[] serialize(HashMap<?,?> hashmap) throws IOException;
	
	/**
	 * M�thode de d�s�rialisation des propri�t�s d'un article
	 * @param l'objet � d�s�rialiser
	 * @return un hashmap contenant les propri�t�s de l'objet
	 */
	public HashMap<?,?> deserialize(byte[] bytes) throws IOException;
}
