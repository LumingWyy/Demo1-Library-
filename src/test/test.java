package test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.Book;
import entity.Borrow;

public class test {
	@PersistenceContext(unitName = "pu")

	private EntityManager em;
	private EntityTransaction transaction;

//	@Before
//	public void init() {
//		transaction = em.getTransaction();
//		transaction.begin();
//	}

//	@After
//	public void destory() {
//		transaction.commit();
//		em.close();
//	}

	@SuppressWarnings("unchecked")

	@Test
	public void testFindAllBook() {
		Query query = em.createNamedQuery("findAllBook");
		List<Book> booklist = query.getResultList();
		booklist.forEach(a -> System.out.println(a));
	}

	@Test
	public void insertBook() {
		em.createQuery("insert into book values(252,'webapp','tester1',0)").executeUpdate();
		Query query = em.createNamedQuery("findAllBook");
		List<Book> booklist = query.getResultList();
		booklist.forEach(a -> System.out.println(a));

	}

	@Test
	public void testDeleteBook() {
		em.createNamedQuery("deleteAllBook").executeUpdate();
		Query query = em.createNamedQuery("findAllBook");
		List<Book> booklist = query.getResultList();
		booklist.forEach(a -> System.out.println(a));
	}

	@Test
	public void testUpdateBookById() {
		em.createNamedQuery("updateBookByID").setParameter("id", 251).executeUpdate();
		Query query = em.createNamedQuery("findAllBook");
		List<Book> booklist = query.getResultList();
		booklist.forEach(a -> System.out.println(a));
	}

	@Test
	public void testFindAllBorrow() {
		Query query = em.createNamedQuery("findAllBorrow");
		List<Borrow> borrowlist = query.getResultList();
		borrowlist.forEach(b -> System.out.println(b));
	}

	@Test
	public void testInsertBorrow() {
		em.createQuery("insert into borrow values('20190101',151111,'john',252,'webapp')").executeUpdate();
		Query query = em.createNamedQuery("findAllBorrow");
		List<Borrow> borrowlist = query.getResultList();
		borrowlist.forEach(b -> System.out.println(b));
	}

}
