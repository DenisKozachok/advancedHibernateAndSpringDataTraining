package org.it.discovery.training.hibernate;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PersonRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final PublisherRepository repository;

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {
        Publisher publisher = new Publisher();
        publisher.setName("Packt");
        publisher.setCreated(LocalDateTime.now());

        Book book = new Book();
        book.setName("Hibernate");
        publisher.addBook(book);

        Person author = new Person();
        author.setName("Gavin King");
        author.addBook(book);

        Hit hit = new Hit();
        hit.setViewed(LocalDateTime.now());
        hit.setBrowser("Chrome");
        hit.setIp("localhost");
        book.addHit(hit);
        repository.save(publisher);

        System.out.println(publisher);

        System.out.println(repository.findById(publisher.getId()));

        System.out.println("Authors without books = " + personRepository.findPersonWithoutBooks());
    }
}
