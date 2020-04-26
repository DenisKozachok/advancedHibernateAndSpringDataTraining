package org.it.discovery.training.jpa.bootstrap;

import org.it.discovery.training.hibernate.model.Book;
import org.it.discovery.training.hibernate.model.Hit;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.it.discovery.training.hibernate.repository.jpa.JpaPublisherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JPAStarter {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
		try {
			PublisherRepository repository = new JpaPublisherRepository(emf);
			Publisher publisher = new Publisher();
			publisher.setName("Packt");
			publisher.setCreated(LocalDateTime.now());

			Book book = new Book();
			book.setName("Hibernate");
			publisher.addBook(book);

			Hit hit = new Hit();
			hit.setViewed(LocalDateTime.now());
			hit.setBrowser("Chrome");
			hit.setIp("localhost");
			book.addHit(hit);
			repository.save(publisher);

			System.out.println(publisher);

			System.out.println(repository.findById(publisher.getId()));
		} finally {
			 emf.close();
		}

	}

}
