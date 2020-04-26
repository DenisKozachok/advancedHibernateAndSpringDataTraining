package org.it.discovery.training.hibernate.service;

import org.it.discovery.training.hibernate.model.Book;

import java.util.List;

public interface BookService {

    /**
     * Returns all the books with specified name or pages.
     * Both parameters are optional. If name is null or pages = 0 we should
     * ignore them
     *
     * @param name
     * @param pages
     * @return
     */
    List<Book> searchBooks(String name, int pages);
}
