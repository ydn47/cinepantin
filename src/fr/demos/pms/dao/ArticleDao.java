package fr.demos.pms.dao;

import java.util.List;

import fr.demos.pms.model.Article;

public interface ArticleDao {
	List<Article> showMainArticles();
	Article findByNom(String nomArticle);
	Article findByShortDesc(String shortDesc);
	Article findByLongDesc(String longDesc);
	void create(Article a) throws DAOException;
}
