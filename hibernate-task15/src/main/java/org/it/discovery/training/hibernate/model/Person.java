package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Person who can write books, for example
 *
 * @author admin
 */
@Table
@Entity
@Getter
@Setter
public class Person extends BaseEntity {
	private String name;

	/**
	 * Books that person has written
	 */
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public void addBook(Book book) {
		if (books == null) {
			books = new ArrayList<>();
		}
		books.add(book);
		book.setAuthor(this);
	}

}
