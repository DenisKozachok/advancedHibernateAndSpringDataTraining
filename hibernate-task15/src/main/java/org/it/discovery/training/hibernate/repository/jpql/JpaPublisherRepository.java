package org.it.discovery.training.hibernate.repository.jpql;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Transactional
public class JpaPublisherRepository implements PublisherRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Publisher publisher) {
        em.persist(publisher);
    }

    @Override
    public void saveAll(List<Publisher> publishers) {

    }

    @Override
    public void delete(int publisherId) {

    }

    @Override
    @Transactional(readOnly = true)
    public Publisher findById(int publisherId) {
        return em.find(Publisher.class, publisherId);
    }
}
