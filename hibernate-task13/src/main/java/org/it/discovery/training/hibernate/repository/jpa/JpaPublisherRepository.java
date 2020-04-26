package org.it.discovery.training.hibernate.repository.jpa;

import lombok.RequiredArgsConstructor;
import org.it.discovery.training.hibernate.model.Publisher;
import org.it.discovery.training.hibernate.repository.PublisherRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@RequiredArgsConstructor
public class JpaPublisherRepository implements PublisherRepository {
    private final EntityManagerFactory emf;

    @Override
    public void save(Publisher publisher) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(publisher);

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em != null) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void saveAll(List<Publisher> publishers) {

    }

    @Override
    public void delete(int publisherId) {

    }

    @Override
    public Publisher findById(int publisherId) {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            return em.find(Publisher.class, publisherId);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }

        }
    }
}
