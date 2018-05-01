package com.org.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ResultCheckStyle;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="book")
@Where(clause = "deleted = false")
@SQLDelete(sql = "UPDATE book SET deleted = 1 WHERE id = ?", check = ResultCheckStyle.COUNT)
public class Book extends Auditable<String>{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	private String name;
	
	@OneToOne
	@JoinColumn(foreignKey=@ForeignKey(name="FK_book_author_id"))
	private Author author;
	
	public Book() {
	}

	public Book(Long id, String name, Author author) {
		this.id = id;
		this.name = name;
		this.author = author;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}



	
}
