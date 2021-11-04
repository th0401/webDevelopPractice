package model.board123;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class JPABoard123DAO {
	@PersistenceContext
	private EntityManager em;
	
	public void insertBoard123(Board123JPAVO vo) {
		em.persist(vo);
	}
	public void updateBoard123(Board123JPAVO vo) {
		em.merge(vo);
	}
	public void deleteBoard123(Board123JPAVO vo) {
		em.remove(em.find(Board123JPAVO.class, vo.getId()));
	}
	public Board123JPAVO getBoard123(Board123JPAVO vo) {
		return (Board123JPAVO)em.find(Board123JPAVO.class, vo.getId());
	}
	public List<Board123JPAVO> getBoard123List(Board123JPAVO vo){
		System.out.println("JPA 스프링 연동실습중!!!!!");
		//System.out.println(vo.getCondition()+" "+vo.getKeyword());
		return em.createQuery("select b from Board b",Board123JPAVO.class).getResultList();
	}
}
