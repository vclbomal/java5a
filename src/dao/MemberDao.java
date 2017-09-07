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

}
