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
	
	public List<Mood> moodStat() {
		String query = " SELECT month,year FROM Mood GROUP BY month,year";
		return em.createQuery(query).getResultList();
	}
	
	public List<Mood> moodComment() {
		String query = " FROM Mood WHERE freetopublic=1";
		return em.createQuery(query).getResultList();
	}
	
	public List<Mood> moodCommentStat(String month,int year) {
		String query = " FROM Mood WHERE freetopublic=1 AND  year= "+year+" AND month= '"+ month+"'";
		return em.createQuery(query).getResultList();
	}
	
	
	public void delete() {
		String queryDelete = " FROM Mood WHERE id = 1";//+ u.getId();
		em.createQuery(queryDelete);
	}
	
	public long count() {
		String queryCount = "SELECT COUNT(*) FROM Mood ";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
	
	public long countMoodEver(int mood) {
		String queryCountmood = "SELECT COUNT(*) FROM Mood WHERE mood = "+ mood;
		return (long)em.createQuery(queryCountmood).getSingleResult();
	}
	
	public long countMoodMonthTot(String month) {
		String queryCount = "SELECT COUNT(*) FROM Mood WHERE month= '"+ month+"'";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
	
	public long countMoodMonth(int mood,String month) {
		String queryCount = "SELECT COUNT(*) FROM Mood WHERE mood= "+mood+" AND month= '"+ month+"'";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
	
	public long countMoodStat(int mood,String month,int year) {
		String queryCount = "SELECT COUNT(*) FROM Mood WHERE mood= "+mood+" AND year= "+year+" AND month= '"+ month+"'";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
	
	public long countMoodStatTot(String month,int year) {
		String queryCount = "SELECT COUNT(*) FROM Mood WHERE year= "+year+" AND month= '"+ month+"'";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
}
