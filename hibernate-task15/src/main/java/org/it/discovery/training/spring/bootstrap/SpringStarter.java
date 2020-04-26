package org.it.discovery.training.spring.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PersonRepository;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.spring.config.PersistenceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class SpringStarter {

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context =
					 new AnnotationConfigApplicationContext(
							 PersistenceConfig.class)) {
			var repository = context.getBean(PublisherRepository.class);
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

			var personRepository = context.getBean(PersonRepository.class);
			System.out.println("Authors without books = " + personRepository.findPersonWithoutBooks());
		}
	}

}
