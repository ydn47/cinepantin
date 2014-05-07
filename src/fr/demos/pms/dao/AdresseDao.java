package fr.demos.pms.dao;



import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Article;

public interface AdresseDao {
	Adresse find(Adresse a);
	void create(Adresse a) throws DAOException;
	void update(Adresse a) throws DAOException;

}
