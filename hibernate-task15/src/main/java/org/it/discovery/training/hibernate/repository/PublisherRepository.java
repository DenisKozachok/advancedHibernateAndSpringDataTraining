package org.it.discovery.training.hibernate.repository;

import org.it.discovery.training.hibernate.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {

}
