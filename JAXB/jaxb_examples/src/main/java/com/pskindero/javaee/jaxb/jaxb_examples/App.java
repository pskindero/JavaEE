package com.pskindero.javaee.jaxb.jaxb_examples;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.pskindero.javaee.jaxb.jaxb_examples.model.Book;
import com.pskindero.javaee.jaxb.jaxb_examples.model.Person;

public class App {

	private static final String XML_PATH = "book.xml";
	private static File created_xml;

	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		Person cHorstmann = new Person("Cay", "Horstmann", new Date(1955, 2, 2));
		Person gCornell = new Person("Gary", "Cornell", new Date(1963, 5, 8));

		List<Person> authors = new ArrayList<Person>();
		authors.add(cHorstmann);
		authors.add(gCornell);

		Book jat = new Book("Java: Advanced Features", authors, 2004, "Prentice Hall");
		System.out.println("Object to XML: \n");
		marshallSaveAndPrint(jat);
		System.out.println("\n================================\n");
		unmarshallAndPrint();
	}

	public static void marshallSaveAndPrint(Book b) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Book.class);
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		created_xml = new File(XML_PATH);
		m.marshal(b, created_xml);
		m.marshal(b, System.out);
	}

	public static void unmarshallAndPrint() throws JAXBException, FileNotFoundException {
		Unmarshaller um = JAXBContext.newInstance(Book.class).createUnmarshaller();
		Book book = (Book) um.unmarshal(new FileReader(created_xml));
		System.out.println("Unmarshalled: \n" + book);
	}

}
