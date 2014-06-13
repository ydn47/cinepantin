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
		String query = "SELECT a FROM Article a";
		TypedQuery<Article> q = em.createQuery(query, Article.class).setMaxResults(9);
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
		System.out.println("Article ***************************************"+a);
		try {
			ut.begin();
			em.persist(a);
			ut.commit();
		 } catch (DAOException | NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
			 e.printStackTrace();
			 throw new DAOException("Pb création article" + a.getIdArticle());
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

	/**
	 * Affiche tous les articles d'une catégorie passée en paramètre
	 * @param l'id de la catégorie
	 */
	@Override
	public Collection<Article> showArticleByCategory(long idCategorie) {
		String query = "SELECT a FROM Article a WHERE a.categorie.idCategorie = ?1";
		TypedQuery<Article> q = em.createQuery(query, Article.class);
		q.setParameter(1, idCategorie);
		Collection<Article> listeArticle = q.getResultList();
		return listeArticle;	
	}

	/**
	 * Affiche le total des articles disponibles pour chaque catégorie
	 * @param l'id de la catégorie
	 */
	@Override
	public List<Integer> countArticlesByCategory() {
		String query = "SELECT COUNT(a) FROM Article a GROUP BY a.categorie.idCategorie";
		TypedQuery<Integer> tq = em.createQuery(query, Integer.class);
		List<Integer> listeTotaux = tq.getResultList();
		
		return listeTotaux;
	}

	@Override
	public Article update(Article a) throws DAOException {
		Article article = null;
		try {
		ut.begin();
		article = em.merge(a);
		ut.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb update article : " + a.getNomArticle(), e);		
		}
		System.out.print("update article :"+article);
		return article;
	}

}
