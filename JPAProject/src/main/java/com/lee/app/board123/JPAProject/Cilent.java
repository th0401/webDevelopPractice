package com.lee.app.board123.JPAProject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Cilent {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager(); // DAO클래스 생성파트
		
		// 트랜젝션
		EntityTransaction et = em.getTransaction();
		
		
		try {
		
			et.begin();
			
			Board123 board123 = new Board123();
			
			board123.setTitle("JPA실습3");
			board123.setWriter("J");
			board123.setContent("PA3");
			
			em.persist(board123); // insert구문을 생성
			
			et.commit();
			
			// JPQL : sql문들의 표준. JPA구현체가 읽어들여서 해당 DBMS의 sql문으로 처리
			String jpql="select b from Board123 b";
			List<Board123> datas = em.createQuery(jpql,Board123.class).getResultList();
			for(Board123 v:datas) {
				System.out.println(v);
			}
			
			
			
			
		}catch(Exception e) {
			et.rollback();
		}
		finally {
			em.close();
			emf.close();
		}
		
		
		
		
		
		
		
		
	}

}
