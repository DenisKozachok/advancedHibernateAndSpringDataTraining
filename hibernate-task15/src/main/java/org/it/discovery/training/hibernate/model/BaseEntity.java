package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue
	private Integer id;

	private LocalDateTime created;

	private LocalDateTime modified;

	@PrePersist
	public void onInsert() {
		created = LocalDateTime.now();
	}

	@PreUpdate
	public void onUpdate() {
		modified = LocalDateTime.now();
	}

}
