package fr.demos.pms.dao;

import java.util.Collection;

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
		String query = "SELECT cat FROM Categorie cat";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		Collection<Categorie> listeCategories = q.getResultList();
		
		return listeCategories;
	}

}
