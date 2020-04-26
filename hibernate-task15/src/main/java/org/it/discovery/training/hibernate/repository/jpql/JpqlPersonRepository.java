package org.it.discovery.training.hibernate.repository.jpql;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Person;
import org.it.discovery.training.hibernate.repository.PersonRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class JpqlPersonRepository implements PersonRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Person> findPersonWithoutBooks() {
        //TODO optimize query to use outer join
        TypedQuery<Person> query = em.createQuery("FROM Person p WHERE p.books is empty", Person.class);
        return query.getResultList();
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
