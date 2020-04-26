package org.it.discovery.training.hibernate.repository;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
public class JpqlPersonRepository implements PersonRepository {
    private final EntityManagerFactory emf;

    @Override
    public List<Person> findPersonWithoutBooks() {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            //TODO optimize query to use outer join
            TypedQuery<Person> query = em.createQuery("FROM Person p WHERE p.books is empty", Person.class);
            return query.getResultList();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }

        }
    }

    @Override
    public Person findMostEfficientAuthor() {
        return null;
    }

    @Override
    public List<Person> findPersonsByBook(String name) {
        return null;
    }

    @Override
    public List<Person> findPersonsOfPublisher(int publisherId) {
        return null;
    }

    @Override
    public List<Person> findTopAuthors(int limit) {
        return null;
    }
}
