package fr.demos.pms.dao;

import java.util.Collection;

import fr.demos.pms.model.Article;

public interface ArticleDao {
	Collection<Article> showMainArticles();
	Collection<Article> findByNom(String nomArticle, long idCategorie);
	//TODO
	Article findByShortDesc(String shortDesc);
	Article findByLongDesc(String longDesc);
	//TODO : Article findByProperties() - rechercher un article via ses propriétés
	void create(Article a) throws DAOException;
}
