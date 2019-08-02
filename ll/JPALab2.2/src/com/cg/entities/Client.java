package com.cg.entities;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Author author1=new Author(1,"A1",null);
		Author author2=new Author(2,"A2",null);
		em.persist(author1);
		em.persist(author2);
		
		ArrayList<Author> al1= new ArrayList<Author>();
		ArrayList<Author> al2= new ArrayList<Author>();
		
		al1.add(author1);
		al2.add(author2);
		
		Book book1 = new Book(101,"Title1",500,al1);
		Book book2 = new Book(102,"Title2",600,al2);
		
		em.persist(book1);
		em.persist(book2);

		em.getTransaction().commit();
		em.close();
		emf.close();
		
		//To Fetch The Record Back
		//System.out.println(em.find(Book.class, 101));
		
		//System.out.println(em.find(Author.class,2));
	}

}
