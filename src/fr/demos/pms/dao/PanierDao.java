package fr.demos.pms.dao;

import java.util.List;

import fr.demos.pms.model.Client;
import fr.demos.pms.model.Panier;

public interface PanierDao {
	
	Panier findByClient (Client client);
	void create(Panier p) throws DAOException;
	
	
}
