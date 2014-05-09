package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import fr.demos.pms.model.Article;
import fr.demos.pms.model.Categorie;
import fr.demos.pms.model.Client;

public interface ArticleDao {
	Collection<Article> showMainArticles();
	Collection<Article> showArticleByCategory(long idCategorie);
	Article findById(long idArticle);
	Collection<Article> findByNom(String nomArticle);
	Collection<Article> findByNom(String nomArticle, List<Categorie> categories);
	//TODO : les méthodes find by desc
	Article findByShortDesc(String shortDesc);
	Article findByLongDesc(String longDesc);
	//TODO : Article findByProperties() - rechercher un article via ses propriétés
	void create(Article a) throws DAOException;
	
	List<Integer> countArticlesByCategory();
	
	Article update(Article a) throws DAOException;
}
