package fr.demos.pms.dao;

import java.util.Collection;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.UserTransaction;

import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;

public class AdresseDaoJPA implements AdresseDao {
	@PersistenceContext 
	private EntityManager em;
	@Resource 
	private UserTransaction ut;


	@Override
	public void create(Adresse a) throws DAOException {
		try {
			ut.begin();
			em.persist(a);
			ut.commit(); //le commit entraine le flush
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Pb creation compte : " + a.getIdAdresse(), e);		
		}	
		
	}


	@Override
	public void update(Adresse a) throws DAOException { //je passe un objet avec un cle
		
		/*Adresse adr = (Adresse) em.find(Adresse.class ,a.getIdAdresse());
		adr.setCodepostal(a.getCodepostal());
		adr.setNom(a.getNom());
		adr.setPrenom(a.getPrenom());
		adr.setVille(a.getVille());
		adr.setPays(a.getPays());
		adr.setRue(a.getRue());
		adr.setTelephone(a.getTelephone());
		System.out.print("Adr update :" + adr); */
		em.getTransaction().begin();
		Adresse adr = em.merge(a);
		em.getTransaction().commit();
		
		
	}


	@Override
	public Adresse find(Adresse a) {
		Adresse adr =null;
		String query = "select a from Adresse a where a.idAdresse = ?1 "; 
		TypedQuery<Adresse> q = em.createQuery(query,Adresse.class);
		q.setParameter(1,a.getIdAdresse());
		Collection<Adresse> list = q.getResultList();
		int n = list.size();
		if ( n==1 ){
			for (Adresse adresse : list) {
				adr = adresse;
				break;
			}
		} 
		return adr;
	}
}
