package com.test.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.test.config.DBConfig;
import com.test.dao.BookDao;
import com.test.model.Book;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DBConfig.class);
		BookDao dao= ctx.getBean(BookDao.class);
		Book book = new Book();
		book.setB_id(102);
		book.setB_name("somethin interesting");
		book.setB_author("sushanth");
		book.setB_price(124);
//		dao.saveBooks(book);
	//	dao.updateBooks(book);
		//dao.deleteBook(book);
		
		List<Book> list =dao.getAllBooks();
		list.forEach(System.out::println);
		System.out.println("Done");
	}
}
