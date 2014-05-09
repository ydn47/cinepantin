package fr.demos.pms.dao;

import java.util.List;

import fr.demos.pms.model.Client;
import fr.demos.pms.model.Commande;

public interface CommandeDao {
	
	List<Commande> findAllByClient (Client client);
	void create(Commande c) throws DAOException;
	
	
}
