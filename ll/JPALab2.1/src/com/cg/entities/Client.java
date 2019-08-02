package com.cg.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Client {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		
//		
//		ArrayList<Author> al1= new ArrayList<Author>();
//		ArrayList<Author> al2= new ArrayList<Author>();
//		
//		Book book1 = new Book(101,"Title1",400,al1);
//		Book book2 = new Book(102,"Title2",600,al2);
//		
//		ArrayList<Book> al3= new ArrayList<Book>();
//		ArrayList<Book> al4= new ArrayList<Book>();
//		al3.add(book1);
//		al4.add(book2);
//		
//		Author author1=new Author(1,"A1",al3);
//		Author author2=new Author(2,"A2",al4);
//		
//		al1.add(author1);
//		al2.add(author2);
//		
//		em.persist(author1);
//		em.persist(author2);
//		
//		em.persist(book1);
//		em.persist(book2);

		System.out.println("All Book Titles");
		Query query=em.createQuery("select m.title from Book m");
		List<String> list = query.getResultList();
		
		for(String m:list) {  
            System.out.println(m);    
        } 
		//System.out.println(list);
		String name="A1";
		System.out.println("All Book Titles whose author name=A1");
		Query query1=em.createQuery("select b from Book b Join b.author a where a.name=:name");
		query1.setParameter("name", "A1");
		List<String> list1 = query1.getResultList();
		
		System.out.println(list1); 
		
		System.out.println("================Price Range=================");
		Query query2=em.createQuery("select b from Book b where b.price BETWEEN 500 AND 1000");
		List<String> list2=query2.getResultList();
		System.out.println(list2);
		
		System.out.println("================Author Name=================");
		//Query query3=em.createQuery("select a from Author a Join a.book b where b.isbn=:name1");
		Query query3=em.createQuery("select a.name from Book b Join b.author a where b.isbn=:name1");
		query3.setParameter("name1", 101);
		List<String> list3=query3.getResultList();
		System.out.println(list3);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		//To Fetch The Record Back
		//System.out.println(em.find(Book.class, 101));
		
		//System.out.println(em.find(Author.class,2));
	}

}
