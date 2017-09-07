package dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Member;
import model.Mood;

@Singleton
public class MoodDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Mood u) {
		em.persist(u);
	}
	
	public Mood findOne(Long id) {
		return em.find(Mood.class, id);
	}
	
	public List<Mood> findAll() {
		String query = " FROM Mood";
		return em.createQuery(query).getResultList();
	}
	
	public void delete() {
		String queryDelete = " FROM Mood WHERE id = 1";//+ u.getId();
		em.createQuery(queryDelete);
	}
	
	public int count() {
		String queryCount = "SELECT COUNT(*) FROM Mood ";
		return em.createQuery(queryCount).getFirstResult();
	}

}
