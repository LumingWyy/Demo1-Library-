package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "findAllBorrow", query = "SELECT b FROM Borrow b"),
		@NamedQuery(name = "deleteAllBorrow", query = "DELETE FROM Borrow") })
public class Borrow implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "borrow_date")
	// @Temporal(value = TemporalType.DATE)
	private String borrowDate;

	@Column(name = "student_id")
	private Long studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "book_id")
	private Long bookId;
	@Column(name = "book_name")
	private String bookName;

	/**
	 * @return the borrowDate
	 */
	public String getBorrowDate() {
		return borrowDate;
	}

	/**
	 * @param borrowDate
	 *            the borrowDate to set
	 */
	public void setBorrowDate(String borrowDate) {
		this.borrowDate = borrowDate;
	}

	/**
	 * @return the studentId
	 */
	public Long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId
	 *            the studentId to set
	 */
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName
	 *            the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the bookId
	 */
	public Long getBookId() {
		return bookId;
	}

	/**
	 * @param bookId
	 *            the bookId to set
	 */
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName
	 *            the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Borrow [borrowDate=" + borrowDate + ", studentId=" + studentId + ", studentName=" + studentName
				+ ", bookId=" + bookId + ", bookName=" + bookName + "]";
	}

}
