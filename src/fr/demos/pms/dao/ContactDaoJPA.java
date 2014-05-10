package fr.demos.pms.dao;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.model.Contact;
@Dao
public class ContactDaoJPA implements ContactDao{
	
	@PersistenceContext 
	private EntityManager em;
	@Resource 
	private UserTransaction ut;
	
	@Override
	public void create(Contact c) throws DAOException {
		try {
			ut.begin();
			em.persist(c);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb creation contact de la part de : " + c.getNom(), e);		
		}	
		
	}

	

}
