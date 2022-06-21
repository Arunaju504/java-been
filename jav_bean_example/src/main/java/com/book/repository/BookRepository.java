//package com.book.repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import com.javatraining.model.Book;
//import com.training.iface.CrudRepositary;
//
//public class BookRepository implements CrudRepositary<Book>{
//	private List<Book> bookList;
//	
//	public BookRepository() {
//		super();
//		this.bookList =new ArrayList<Book> ();
//	}
//	
//	@Override
//	public Book add(Book t) {
//		boolean isAdded =this.bookList.add(t);
//		if(isAdded) {
//			return t;
//		}
//		else {
//			return null;
//		}
//		
//	}
//
//	@Override
//	public List<Book> findAll() {
//		return this.bookList;
//	}
//
//	@Override
//	public Book findByName(String bookName) {
//		Optional<Book>  found =this.bookList.stream().filter(e -> e.getBookName().equals(bookName)).findFirst();
//
//		return found.get();
//	}
//
//	@Override
//	public Book removeById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//
//}
