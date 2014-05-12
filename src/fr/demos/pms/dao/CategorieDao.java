package fr.demos.pms.dao;

import java.util.Collection;

import fr.demos.pms.model.Categorie;
import fr.demos.pms.model.Client;

/**
 * @author Yann-Dara Nong
 */
public interface CategorieDao {
	Collection<Categorie> findAllCategories();
	String findNomById(long idCategorie);
	long findIdByNom(String nomCategorie);
	void create(Categorie c) throws DAOException;
}
