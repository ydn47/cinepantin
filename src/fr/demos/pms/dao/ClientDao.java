package fr.demos.pms.dao;

import java.util.List;

import fr.demos.pms.dao.DAOException;
import fr.demos.pms.model.Client;



public interface ClientDao {
	
	
	List<Client> findAll();
	Client findByParam (String login, String mpd);
	Client findByLogin (String login);
	void create(Client a) throws DAOException;
	
}
