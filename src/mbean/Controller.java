package mbean;

import entity.Book;
import entity.Borrow;
import session.LibraryEJB;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;

@ManagedBean(name = "Controller")
@RequestScoped
public class Controller {

	// 情報保持用
	private Book book = new Book();

	private List<Book> bookList = new ArrayList<Book>();

	private Borrow borrow = new Borrow();

	private List<Borrow> borrowList = new ArrayList<Borrow>();

	public Controller() {
	}

	@EJB
	private LibraryEJB LibraryEJB;

	public Book getBook() {
		return book;
	}

	public void setBook(Book r) {
		book = r;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> l) {
		bookList = l;
	}

	public Borrow getBorrow() {
		return borrow;
	}

	public void setBorrow(Borrow b) {
		borrow = b;
	}

	public List<Borrow> getBorrowList() {
		return borrowList;
	}

	public void setBorrowList(List<Borrow> b) {
		borrowList = b;
	}

	// action="#{Controller.doNew}
	public String doNew() {
		return "createBook.xhtml"; // 入力後 doCreateBook()
	}

	// action="#{Controller.doCreateBook}
	public String doCreateBook() {
		book = LibraryEJB.createBook(book);
		return doListBook(); // 自動的に一覧表示
	}

	// action="#{Controller.doListBook}
	public String doListBook() {
		bookList = LibraryEJB.findAllBooks();
		return "listBooks.xhtml";
	}

	public String doDeleteAll() {
		int c = LibraryEJB.deleteAllBooks();
		return "listBooks.xhtml";
	}

	public String doNewBorrow() {
		return "createBorrow.xhtml";
	}
	
	public String doCreateBorrow() {
		borrow = LibraryEJB.createBorrow(borrow);
		// LibraryEJB.updateStatusById(borrow.getBookId());
		if(borrow==null){
			return "error1";
		}
		return doListBorrow();
		
	}

	// action="#{BookController.doListBorrow}
	public String doListBorrow() {
		borrowList = LibraryEJB.finAllBorrow();
		return "listBorrow.xhtml";
	}
	
	public String doDeleteBorrowAll() {
		int c = LibraryEJB.deleteAllBorrow();
		return "listBorrow.xhtml";
	}
}
