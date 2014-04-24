package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
		// TODO : modifier la requ�te afin que seuls les premiers articles

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

	@Override
	public void create(Article a) throws DAOException {
		// TODO Auto-generated method stub
		
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
	 * Retrouve des articles � partir du nom 
	 * @return une liste d'articles contenant le nom recherch�
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
	 * Retrouve des articles � partir du nom et de leurs cat�gories
	 * @return renvoie le ou les articles recherch�s
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
