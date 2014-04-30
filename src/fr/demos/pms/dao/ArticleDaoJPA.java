package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.model.Article;
import fr.demos.pms.model.Categorie;
import fr.demos.pms.model.Client;
/**
 * 
 * @author Yann-Dara Nong
 *
 */
@Dao
public class ArticleDaoJPA implements ArticleDao {

	@PersistenceContext
	private EntityManager em;
	@Resource
	private UserTransaction ut;

	/**
	 * Renvoie une liste des 5 premiers articles les plus vendus
	 * 
	 * @return une liste d'objets Article
	 */
	@Override
	public Collection<Article> showMainArticles() {
		// TODO : modifier la requête afin que seuls les premiers articles

		String query = "SELECT a FROM Article a";
		TypedQuery<Article> q = em.createQuery(query, Article.class);
		//q.setParameter(1, login);
		//q.setParameter(2, mdp);
		Collection<Article> listeArticle = q.getResultList();

		return listeArticle;

	}

	@Override
	public Article findByShortDesc(String shortDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article findByLongDesc(String longDesc) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Insère un article dont les propriétés sont sérialisés
	 * @param un article
	 */
	@Override
	public void create(Article a) throws DAOException {
		try {
			ut.begin();
			em.persist(a);
			ut.commit();
		 } catch (RollbackException ex) {
	           // Log something
	    } catch (HeuristicMixedException ex) {
	           // Log something
	    } catch (HeuristicRollbackException ex) {
	           // Log something
	    } catch (SecurityException ex) {
	           // Log something
	    } catch (IllegalStateException ex) {
	           // Log something
	    } catch (NotSupportedException ex) {
	           // Log something
	    } catch (SystemException ex) {
	           // Log something
	    }
	}
		

	@Override
	public Article findById(long idArticle) {

		Article article = null;
		String query = "SELECT a FROM Article a WHERE a.idArticle =?1" ;
		TypedQuery<Article> q = em.createQuery(query, Article.class);
		q.setParameter(1, idArticle);
		Collection<Article> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (Article a : list) {
				article = a;
				break;
			}
		} 
		return article;
	}

	/**
	 * Retrouve des articles à partir du nom 
	 * @return une liste d'articles contenant le nom recherché
	 */
	@Override
	public Collection<Article> findByNom(String nomArticle) {
		String query = "SELECT a FROM Article a WHERE UPPER(a.nomArticle) LIKE UPPER(?1)";
		TypedQuery<Article> q = em.createQuery(query, Article.class);
		q.setParameter(1, "%" + nomArticle + "%");
		Collection<Article> listeArticle = q.getResultList();
		
		return listeArticle;
	}

	/**
	 * Retrouve des articles à partir du nom et de leurs catégories
	 * @return renvoie le ou les articles recherchés
	 */
	@Override
	public Collection<Article> findByNom(String nomArticle, List<Categorie> categories) {
		Collection<Article> listeArticle = null;
		
		String query = "SELECT a FROM Article a WHERE UPPER(a.nomArticle) LIKE UPPER(?1) "
				+ "AND a.categorie IN ?2";
		TypedQuery<Article> q = em.createQuery(query, Article.class);
		q.setParameter(1, "%" + nomArticle + "%");
		q.setParameter(2, categories);
		listeArticle = q.getResultList();
		return listeArticle;
	}

}
