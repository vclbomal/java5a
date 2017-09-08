package dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Motm;

@Singleton
public class MotmDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Motm f) {
		em.persist(f);
	}
	
	 
}


