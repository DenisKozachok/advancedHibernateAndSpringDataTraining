package org.it.discovery.training.hibernate.repository;

import org.it.discovery.training.hibernate.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

	/**
	 * Returns all the books with exact name
	 *
	 * @param name
	 * @return
	 */
	List<Book> findByName(String name);

	/**
	 * Returns all the books that has at least one hit
	 *
	 * @return
	 */
	//List<Book> findWithHits();

	/**
	 * Returns all the books where number of pages is greater than pages parameter
	 *
	 * @param pages
	 * @return
	 */
	List<Book> findByPagesGreaterThan(int pages);

	/**
	 * Returns overall number of pages for all the books
	 *
	 * @return
	 */
	//int findTotalPages();

	/**
	 * Returns all the books sorted by name
	 *
	 * @return
	 */
	//List<Book> findSortedBooks();

	/**
	 * @return
	 */
	//LibraryInfo findLibraryInfo();

	//BookInfo findBookInfo(int bookId);

}
