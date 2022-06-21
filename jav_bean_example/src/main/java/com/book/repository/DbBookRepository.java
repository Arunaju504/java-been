package com.book.repository;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.javatraining.model.Book;
import com.training.iface.CrudRepositary;

public class DbBookRepository implements CrudRepositary<Book> {

	private Connection con;

	public DbBookRepository(Connection con) {
		super();
		this.con = con;
	}

	@Override
	public Book add(Book t) {
		String sql = "insert into book values(?,?,?,?)";
		int rowAdded = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, t.getBookNumber());
			pstmt.setString(2, t.getBookName());
			pstmt.setString(3, t.getAuthorName());
			pstmt.setDouble(4, t.getPrice());
			rowAdded = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rowAdded == 1 ? t : null;
	}

	@Override
	public List<Book> findAll() {
		String sql = "select * from book";
		List<Book> bookList = new ArrayList();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int bookNumber = rs.getInt("id");
				String bookName = rs.getString("name");
				String authorName = rs.getString("author");
				double price = rs.getDouble("price");
				Book eachBook = new Book(bookNumber, bookName, authorName, price);
				bookList.add(eachBook);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}

	@Override
	public Book findByName(String bookName) {

		return null;
	}

	public Book findById(int id) {

		String sql = "select * from book where id=?";
		Book foundBook = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int bookNumber = rs.getInt("id");
				String bookName = rs.getString("name");
				String authorName = rs.getString("author");
				double price = rs.getDouble("price");
				foundBook = new Book(bookNumber, bookName, authorName, price);

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return foundBook;
	}

	@Override
	public Book removeById(int id) {
		String sql = "delete from book where id=?";
		int rowDeleted = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);

			rowDeleted = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowDeleted == 1 ? findById(id) : null;

	}

	

	@Override
	public Book updateBook(Book t) {
		String sql = "update book set name=?,author=?,price=? where id=?";
		int rowUpdated=0 ;
		try {
			PreparedStatement pstmt =con.prepareStatement(sql);
			pstmt.setString(1, t.getBookName());
			pstmt.setString(2, t.getAuthorName());
			pstmt.setDouble(3, t.getPrice());
			pstmt.setInt(4, t.getBookNumber());
			rowUpdated =pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return rowUpdated==1?t:null;
		
	}
}
