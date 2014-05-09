package fr.demos.pms.dao;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Commande;

@Dao
public class CommandeDaoJPA implements CommandeDao{
	@PersistenceContext 
	private EntityManager em;
	@Resource 
	private UserTransaction ut;
	
	

	@Override
	public void create(Commande c) throws DAOException {
		try {
			ut.begin();
			em.persist(c);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb création commande :"+c.getIdCommande()+" du client : " + c.getClient().getLogin(), e);		
		}	
		
	}



	@Override
	public List<Commande> findAllByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}
