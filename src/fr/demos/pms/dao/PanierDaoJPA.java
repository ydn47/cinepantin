package fr.demos.pms.dao;

import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.pms.model.Client;
import fr.demos.pms.model.Panier;

public class PanierDaoJPA implements PanierDao {
	
	@PersistenceContext 
	private EntityManager em;
	@Resource 
	private UserTransaction ut;

	@Override
	public Panier findByClient(Client client) {
		Panier panier = null;
		String query = "select  from Panier p where p.client = ?1 "; //le nom de la classe
		TypedQuery<Panier> q = em.createQuery(query,Panier.class);
		q.setParameter(1,client);

		Collection<Panier> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (Panier p : list) {
				panier = p;
				break;
			}
		} 
		return panier;
	}

	@Override
	public void create(Panier p) throws DAOException {
		try {
			ut.begin();
			em.persist(p);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb création panier du client : " + p.getClient().getLogin(), e);		
		}	
		
	}

}
