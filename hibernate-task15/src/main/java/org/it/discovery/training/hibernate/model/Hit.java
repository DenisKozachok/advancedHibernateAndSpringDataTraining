package org.it.discovery.training.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Table
@Entity
@Getter
@Setter
public class Hit extends BaseEntity {
	private String ip;

	private String browser;

	private LocalDateTime viewed;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;

}
