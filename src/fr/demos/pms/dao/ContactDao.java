package fr.demos.pms.dao;

import fr.demos.pms.model.Contact;;

public interface ContactDao {
	
	void create(Contact a) throws DAOException;

}
