package fr.demos.pms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.model.Categorie;

/**
 * 
 * @author Yann-Dara Nong
 *
 */
@Dao
public class CategorieDaoJPA implements CategorieDao {
	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	/**
	 * retourne toute les cat�gories pr�sentes en base de donn�es
	 * @return une collection de cat�gorie
	 */
	@Override
	public Collection<Categorie> findAllCategories() {
		Collection<Categorie> listeCategories = new ArrayList<Categorie>();
		String query = "SELECT cat FROM Categorie cat";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		listeCategories = q.getResultList();
		
		if (listeCategories != null)
			return listeCategories;
		else return null;
	}

	/**
	 * Retrouve le nom stock� en base de la cat�gorie via son id
	 * @param l'id de la cat�gorie
	 */
	@Override
	public String findNomById(long idCategorie) {
		List<Categorie> listeCategories = null;
		String query = "SELECT cat FROM Categorie cat WHERE cat.idCategorie = ?1";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		q.setParameter(1, idCategorie);
		listeCategories = q.getResultList();
		
		if (listeCategories != null && !listeCategories.isEmpty()) {
			return listeCategories.get(0).getNomCategorie();
		}
		else 
		{
			return null;
		}
	}

	/**
	 * Retrouve l'id d'une cat�gorie via son nom
	 * @param le nom de la cat�gorie
	 */
	@Override
	public long findIdByNom(String nomCategorie) {
		String query = "SELECT cat FROM Categorie cat WHERE UPPER(cat.nomCategorie) LIKE UPPER(?1)";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		q.setParameter(1, nomCategorie);
		List<Categorie> cat = q.getResultList();
		if (cat != null && !cat.isEmpty())
		{
			return cat.get(0).getIdCategorie();
		}
		else 
		{
			return 0;
		}
	}
	
	
}
