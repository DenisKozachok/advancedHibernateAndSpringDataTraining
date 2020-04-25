package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table
@Entity
@Getter @Setter
public class Hit {
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;

	@Id
	@GeneratedValue
	private int id;
	
	private LocalDateTime created;
	
	private LocalDateTime modified;
	
	public Book getBook() {
		return book;
	}

}
