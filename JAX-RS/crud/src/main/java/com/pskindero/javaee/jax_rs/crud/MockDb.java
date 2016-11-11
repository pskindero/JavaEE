package com.pskindero.javaee.jax_rs.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MockDb {

	private static final Logger LOGGER = LogManager.getLogger(MockDb.class);
	private Map<Long, Book> dbBooks;
	
	public MockDb() {
		LOGGER.info("Init DB");
		dbBooks = new HashMap<Long, Book>();
		LOGGER.info("DB init successful.");
		add(new Book("Lalka", "Boleslaw Prus", 25));
		add(new Book("Potop", "Henryk Sienkiewicz", 39));
		add(new Book("Nad Niemnem", "Eliza Orzeszkowa", 9.99));
	}
	
	public Book add(Book b) {
		LOGGER.info("Add book: {}", b);
		dbBooks.put(b.getId(), b);
		return b;
	}
	
	public Book get(Long id) {
		LOGGER.info("Get book id: {}", id);
		Book b = dbBooks.get(id);
		return b;
	}
	
	public List<Book> getAll() {
		LOGGER.info("Get all books");
		return new ArrayList<Book>(dbBooks.values()); 
	}
	
	public Book update(Long id, Book b) {
		LOGGER.info("Update book id: {} with values: {}", id, b);
		dbBooks.put(id, b);
		return b;
	}
	
	public Book delete(Long id) {
		LOGGER.info("Delete book id: {}", id);
		return dbBooks.remove(id);
	}
}
