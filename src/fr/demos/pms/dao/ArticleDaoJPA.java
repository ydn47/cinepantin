package fr.demos.pms.dao;

import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.model.Article;
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
	public Article findByNom(String nomArticle) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void create(Article a) throws DAOException {
		// TODO Auto-generated method stub

	}

}
