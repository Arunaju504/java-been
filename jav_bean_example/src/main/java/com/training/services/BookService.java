package com.training.services;

import java.sql.Connection;
import java.util.List;

import com.book.repository.DbBookRepository;
import com.javatraining.model.Book;

import com.training.iface.CrudRepositary;

public class BookService {

	private CrudRepositary<Book> repo;
	private Connection con;

	public BookService(Connection con) {
		super();
		this.con = con;
//		this.bookList=Arrays.asList(new Book(1010,"Head First Java","Kathy Steera",450),
//				                    new Book(1011,"Thinking in Java","Bruce Erekal",750)
//				                    );
		this.repo = new DbBookRepository(con);
	}

	public List<Book> findAll() {
//		return this.bookList;
		// this.repo.add(new Book (101,"java","kathy",450));
		return this.repo.findAll();
	}

	public Book add(Book entity) {
		return this.repo.add(entity);
	}

	public Book findBookByName(String bookName) {
		return this.repo.findByName(bookName);
	}

	public Book remove(int id) {
		return this.repo.removeById(id);
	}

	public Book update(Book entity) {
		return this.repo.updateBook(entity);
	}
	public Book findById(int id) {
		return this.repo.findById(id);
	}

}
