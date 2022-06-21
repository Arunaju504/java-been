package com.training.services;

import java.util.Arrays;
import java.util.List;

import com.book.repository.BookRepository;
import  com.jstl.servlet.*;
import com.training.iface.CrudRepositary;
public class BookService {

	private CrudRepositary<Book> repo;

	public BookService() {
		super();
//		this.bookList=Arrays.asList(new Book(1010,"Head First Java","Kathy Steera",450),
//				                    new Book(1011,"Thinking in Java","Bruce Erekal",750)
//				                    );
		this.repo=new BookRepository();
	}
	
	public List<Book> findAll(){
//		return this.bookList;
		return this.repo.findAll();
	}
	
	public Book add(Book entity) {
		return this.repo.add(entity);
	}
	
	
	
}
