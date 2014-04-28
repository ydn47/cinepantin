package fr.demos.pms.serial;

import java.io.IOException;
import java.util.HashMap;

/**
 * Interface regroupant les méthodes de sérialisation en BDD des articles 
 * 
 * @author Yann-Dara Nong
 *
 */
public interface SerialArticle {
	/**
	 * Méthode de sérialisation des propriétés d'un article
	 * @param un HashMap contenant les propriétés de l'article
	 * @return un tableau d'octets contenant l'objet sérialisé
	 */
	public byte[] serialize(HashMap<?,?> hashmap) throws IOException;
	
	/**
	 * Méthode de désérialisation des propriétés d'un article
	 * @param l'objet à désérialiser
	 * @return un hashmap contenant les propriétés de l'objet
	 */
	public HashMap<?,?> deserialize(byte[] bytes) throws IOException;
}
