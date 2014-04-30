package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import fr.demos.pms.model.Article;
import fr.demos.pms.model.Categorie;

public interface ArticleDao {
	Collection<Article> showMainArticles();

	Article findById(long idArticle);
	Collection<Article> findByNom(String nomArticle);
	Collection<Article> findByNom(String nomArticle, List<Categorie> categories);
	//TODO : les m�thodes find by desc
	Article findByShortDesc(String shortDesc);
	Article findByLongDesc(String longDesc);
	//TODO : Article findByProperties() - rechercher un article via ses propri�t�s
	void create(Article a) throws DAOException;
}
