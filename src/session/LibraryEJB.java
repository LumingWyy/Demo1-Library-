package session;

import entity.Book;
import entity.Borrow;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

@Stateless

public class LibraryEJB {

	@PersistenceContext(unitName = "pu")
	private EntityManager em;

	public List<Book> findAllBooks() {
		Query query = em.createNamedQuery("findAllBook");
		return (List<Book>) query.getResultList();
	}

	public int deleteAllBooks() {
		int c = em.createNamedQuery("deleteAllBook").executeUpdate();
		return c;
	}

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	@Transactional
	public Borrow createBorrow(Borrow borrow) {
		em.persist(borrow);
		// if
		// (borrow.getBookId().equals(findBookById(borrow.getBookId()).getId()))
		// {
		 updateStatusById(borrow.getBookId());
		// Book book = findBookById(borrow.getBookId());
		// book.setStatus(1);
		// em.merge(book);
		return borrow;
		// } else {
		// return null;
		// }
	}

	

	public List<Borrow> finAllBorrow() {
		Query query = em.createNamedQuery("findAllBorrow");
		return (List<Borrow>) query.getResultList();
	}

	@Transactional
	public void updateStatusById(Long id) {
		int c = em.createNamedQuery("updateBookByID").setParameter("id", id).executeUpdate();
		
	}

	public int deleteAllBorrow() {
		int c = em.createNamedQuery("deleteAllBorrow").executeUpdate();
		return c;
	}

}

