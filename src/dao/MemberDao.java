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
	
	public Member findOne(long id) {
		return em.find(Member.class, id);
	}
	
	public List<Member> findAll() {
		String query = " FROM Member";
		return em.createQuery(query).getResultList();
	}
	
	public void delete(String id) {
		String queryDelete = " DELETE FROM Member WHERE id = '"+id+"'";
		em.createQuery(queryDelete).executeUpdate();
	}
	
	public void update(long id,String name, String mail, String birth) {
		Member u = em.find(Member.class, id);
		u.setName(name);
		u.setMail(mail);
		u.setBirth(birth);
		/*String queryUpdate = " UPDATE member SET name = '"+name+"', mail = '"+mail+"', birth = '"+birth+"' WHERE id = '"+id+"'";
		em.createQuery(queryUpdate).executeUpdate();*/
	}
	
	public long count() {
		String queryCount = "SELECT COUNT(*) FROM Member";
		return (long)em.createQuery(queryCount).getSingleResult();
	}
	
}
