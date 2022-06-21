package com.training.iface;

import java.util.List;

import com.javatraining.model.Book;

public interface CrudRepositary<T> {

	public T add(T t);
	
	public List<T> findAll();
	
	public Book findByName(String bookName);
	public T removeById(int id);
	public T updateBook(T t);
	public T findById(int id);

	
}
