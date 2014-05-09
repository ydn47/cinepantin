package fr.demos.pms.dao;

import java.util.Collection;

import fr.demos.pms.model.Categorie;

/**
 * @author Yann-Dara Nong
 */
public interface CategorieDao {
	Collection<Categorie> findAllCategories();
	String findNomById(long idCategorie);
	long findIdByNom(String nomCategorie);
}
