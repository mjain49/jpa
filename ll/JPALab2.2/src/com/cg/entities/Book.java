package com.cg.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Book60")
public class Book {
	@Id
	private Integer isbn;
	private String title;
	private Integer price;
	
	@ManyToMany(targetEntity=Author.class)  
	private List author;  
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public Book(int isbn, String title, int price, List author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.author = author;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price
				+ ", author=" + author + "]";
	}
	
	
	

}
