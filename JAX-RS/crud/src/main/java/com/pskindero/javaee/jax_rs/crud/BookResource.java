
package com.pskindero.javaee.jax_rs.crud;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.pskindero.javaee.jax_rs.crud.Book;
import com.pskindero.javaee.jax_rs.crud.MockDb;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * REST URL: http://localhost:8080/crud/shop/books/
 */
@Path("/books")
public class BookResource {

	private static final Logger LOGGER = LogManager.getLogger(BookResource.class);

	// @Inject
	private static MockDb db = new MockDb();

	@GET
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Book> findBookWithTitle(@DefaultValue("") @QueryParam("title") String title) {
		LOGGER.info("findBooks with query: {}", title);
		List<Book> result;
		
		if (title.equals("")) {
			result = db.getAll();	
		} else {
			result = new ArrayList<Book>();
			for (Book b : db.getAll()) {
				if (b.getTitle().contains(title)) {
					result.add(b);
					break;
				}
			}
		}
		LOGGER.info("findBookWithTitle result: {}", result);
		return result;
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book findById(@PathParam("id") Long id) {
		LOGGER.info("findById with id: {}", id);
		Book result = db.get(id);
		LOGGER.info("findById result: {}", result);
		return result;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book create(Book book) {
		LOGGER.info("create book: {}", book);
		Book result = db.add(book);
		return result;
	}

	@PUT
	@Path("/{id}")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Book update(@PathParam("id") Long id, Book book) {
		LOGGER.info("update book id: {} with book", book);
		Book result = db.update(id, book);
		return result;
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(@PathParam("id") Long id) {
		LOGGER.info("delete id: {}", id);
		db.delete(id);
	}

}
