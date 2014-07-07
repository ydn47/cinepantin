package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import fr.demos.pms.model.Categorie;


/**
 * @author Yann-Dara Nong
 */
public interface CategorieDao {
	Collection<Categorie> findAllCategories();
	String findNomById(long idCategorie);
	int findIdByNom(String nomCategorie);
	void create(Categorie c) throws DAOException;
	List<String> getProprietes(long idCategorie);
	long getLastId();
}
