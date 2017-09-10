package dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Member;

@Singleton
public class MemberDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Member u) {
		em.persist(u);
	}
	
	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll() {
		String query = " FROM Member";
		return em.createQuery(query).getResultList();
	}
	
	public void delete(String mail) {
		String queryDelete = " DELETE FROM Member WHERE mail = '"+mail+"'";//+ u.getId();
		int result= em.createQuery(queryDelete).executeUpdate();
		/*Member member = em.find(Member.class, 1);
		em.getTransaction().begin();
		em.remove(member);
		em.getTransaction().commit();*/
	}
	
	public long count() {
		String queryCount = "SELECT COUNT(*) FROM Member";
		return (long)em.createQuery(queryCount).getSingleResult();
	}

}
