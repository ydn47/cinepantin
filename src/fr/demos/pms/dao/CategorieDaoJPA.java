package fr.demos.pms.dao;

import java.io.IOException;
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
	 * 
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
		else
			return null;
	}

	/**
	 * Retrouve le nom stock� en base de la cat�gorie via son id
	 * 
	 * @param l
	 *            'id de la cat�gorie
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
		} else {
			return null;
		}
	}

	/**
	 * Retrouve l'id d'une cat�gorie via son nom
	 * 
	 * @param le
	 *            nom de la cat�gorie
	 */
	@Override
	public int findIdByNom(String nomCategorie) {
		String query = "SELECT cat FROM Categorie cat WHERE UPPER(cat.nomCategorie) LIKE UPPER(?1)";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		q.setParameter(1, nomCategorie);
		List<Categorie> cat = q.getResultList();
		if (cat != null && !cat.isEmpty()) {
			return (int) cat.get(0).getIdCategorie();
		} else {
			return 0;
		}
	}

	@Override
	public void create(Categorie c) throws DAOException {
		try {
			ut.begin();
			em.persist(c);
			ut.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb creation cat�gorie : "
					+ c.getIdCategorie(), e);
		}

	}

	/**
	 * Retrouve les propri�t�s d'une cat�gorie donn�e
	 * @param l'id de la cat�gorie
	 */
	@Override
	public List<String> getProprietes(long idCategorie) {
		String query = "SELECT cat FROM Categorie cat WHERE cat.idCategorie = ?1";
		TypedQuery<Categorie> q = em.createQuery(query, Categorie.class);
		q.setParameter(1, idCategorie);
		List<Categorie> lst = q.getResultList();
		
		if (lst != null && !lst.isEmpty())
		{
			List<String> res = new ArrayList<>();
			Categorie c = lst.get(0);
			try {
				res = Categorie.deserialize(c.getDescriptionCategorie());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return res;
		}
		else return null;
	}

	/**
	 * Retourne le dernier id en base de la cat�gorie
	 */
	@Override
	public long getLastId() {
		String query = "SELECT COUNT(c) FROM Categorie c";
		TypedQuery<Long> q = em.createQuery(query, Long.class);
		long lastId = q.getSingleResult();
	
		return lastId;
	}

}
