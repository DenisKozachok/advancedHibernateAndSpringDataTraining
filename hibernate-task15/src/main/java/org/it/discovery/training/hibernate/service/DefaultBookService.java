package org.it.discovery.training.hibernate.service;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.repository.BookRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> searchBooks(String name, int pages) {
        Book book = new Book();
        book.setName(name);
        if (pages > 0) {
            book.setPages(pages);
        }
        return bookRepository.findAll(Example.of(book));
    }
}
