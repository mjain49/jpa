package com.cg.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Author1")
public class Author {
	
	@Id
	private Integer id;
	
	private String name;
	
	@ManyToMany(targetEntity=Book.class)
	private List book;

	
	public Author() {
		// TODO Auto-generated constructor stub
	}
	public Author(int id, String name, List book) {
		super();
		this.id = id;
		this.name = name;
		book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getBook() {
		return book;
	}

	public void setBook(List book) {
		book = book;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", book=" + book + "]";
	}
	
	
}
