package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "findAllBook", query = "SELECT r FROM Book r"),
		@NamedQuery(name = "deleteAllBook", query = "DELETE FROM Book"),
		@NamedQuery(name = "findBookByID", query = "SELECT b FROM Book b where b.id = :id"),
		@NamedQuery(name = "updateBookByID", query = "UPDATE Book b SET b.status = 1 where b.id = :id ") })

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 256)
	private String name;

	@Column(nullable = true, length = 256)
	private String author;

	@Column
	private int status;// 1=is not on the bookshelf,0 is on the bookshelf

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		// null値なら0を返すこと
		return (id != null ? id.hashCode() : 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Book)) {
			return false;
		}
		// idはLongなので==で比較できない点に注意
		if ((id == null && ((Book) obj).id != null) || (id != null && !id.equals(((Book) obj).id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		// TODO: StringBuilderに書き換え
		return "entity.Book[id=" + id + " name=" + name + "author=" + author + " bookStatus=" + status + "]";
	}
}
