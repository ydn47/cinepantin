package fr.demos.pms.dao;


import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;


import fr.demos.pms.model.Client;

public class ClientDaoJPA implements ClientDao {
	
		@PersistenceContext 
		private EntityManager em;
		@Resource 
		private UserTransaction ut;

	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public Client findByParam(String login, String mdp) {
		Client user = null;
		String query = "select u from client u where u.login = ?1 and u.mdp = ?2";
		TypedQuery<Client> q = em.createQuery(query,Client.class);
		q.setParameter(1,login);
		q.setParameter(2,mdp);
		Collection<Client> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (Client user2 : list) {
				user = user2;
				break;
			}
		} 
		return user;
	}



	@Override
	public Client findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void create(Client c) throws DAOException {
		try {
			ut.begin();
			em.persist(c);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb création compte : " + c.getLogin(), e);		
		}	
		
	}

	

}
