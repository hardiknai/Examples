package com.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE author SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
@Table(name="author")
public class Author extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	private String name;
	

	boolean deleted;
	
//	@ManyToOne
//	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
//	private Book book;
//	
//	public Book getBook() {
//		return book;
//	}
//
//	public void setBook(Book book) {
//		this.book = book;
//	}

	public Author() {
	}
	
	public Author(Long id, String name) {
		this.id = id;
		this.name = name;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
