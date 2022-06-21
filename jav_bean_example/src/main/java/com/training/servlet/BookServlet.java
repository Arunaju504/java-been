package com.training.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatraining.model.Book;
import com.javatraining.util.ConnectionFactory;
import com.training.services.BookService;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Connection con=null;
       private BookService service;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init()  {
		// TODO Auto-generated method stub
		con=ConnectionFactory.getPostgresConnection();
		service =new BookService(con);
		System.out.println("Connection:= "+con);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String key =request.getServletPath();
		
		switch (key) {
		case "/findAll":
			handleFinalAll(request,response);
			break;
		case "/delete":
			handleRemove(request,response);
			break;
		case "/edit":
			handleEdit(request,response);
			break;
		case "/update":
			handleUpdate(request,response);
			break;
			
		
		default:
			break;
		}
		
	}

	private void handleUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strBookNumber = request.getParameter("bookNumber");
		int bookNumber=Integer.parseInt(strBookNumber);
		String bookName = request.getParameter("bookName");
		String authorName = request.getParameter("authorName");
		String strPrice = request.getParameter("price");
		double price = Double.parseDouble(strPrice);
		Book entity = new Book(bookNumber, bookName, authorName, price);
		Book updateBook=service.update(entity);
	
		request.setAttribute("update", updateBook);

		// TO DO
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findAll");
		dispatcher.forward(request, response);
		
	}

	private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		Book bookToEdit =service.findById(id);
		request.setAttribute("bookToEdit", bookToEdit);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add.jsp");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String strbookNumber=request.getParameter("bookNumber");
		int bookNumber=Integer.parseInt(strbookNumber);
		String bookName=request.getParameter("bookName");
		String authorName=request.getParameter("authorName");
		String strprice=request.getParameter("price");
		double price= Double.parseDouble(strprice);
		Book entity =new Book(bookNumber,bookName,authorName,price);
		Book addedBook =service.add(entity);
		request.setAttribute("added",addedBook);
		request.setAttribute("message", "one book added");
		RequestDispatcher dispatcher =request.getRequestDispatcher("/add.jsp");
		dispatcher.forward(request, response);
	}
	public void handleRemove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strId=request.getParameter("id");
		int id=Integer.parseInt(strId);
		Book book=service.remove(id);
		List<Book> books =service.findAll();
		request.setAttribute("books", books);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/showBooks.jsp");
		dispatcher.forward(request, response);
	}
	public void handleFinalAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> books =service.findAll();
		request.setAttribute("books", books);
		RequestDispatcher dispatcher =request.getRequestDispatcher("/showBooks.jsp");
		dispatcher.forward(request, response);
	}
	

}
