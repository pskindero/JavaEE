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

public class MainClass {

	private static final String XML_PATH = "./target/book.xml";
	private JAXBContext context;
	private Class xmlClass;
	
	public MainClass(Class c) throws JAXBException {
		xmlClass = c;
		context = JAXBContext.newInstance(xmlClass);
	}
	
	public static void main(String[] args) throws JAXBException, FileNotFoundException {
		
		MainClass m = new MainClass(Book.class);
		
		System.out.println("Object to XML: \n");
		File out = m.marshallSaveAndPrint(getData());
		System.out.println("\n================================\n");
		Book b = (Book) m.unmarshall(out);
		System.out.println(b);
	}

	public File marshallSaveAndPrint(Object b) throws JAXBException {
		Marshaller m = context.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		File created_xml = new File(XML_PATH);
		created_xml.deleteOnExit();
		m.marshal(b, created_xml);
		m.marshal(b, System.out);
		return created_xml;
	}

	public Object unmarshall(File f) throws JAXBException, FileNotFoundException {
		Unmarshaller um = context.createUnmarshaller();
		return um.unmarshal(new FileReader(f));
	}
	
	private static Book getData() {
		Person cHorstmann = new Person("Cay", "Horstmann", new Date(1955, 2, 2));
		Person gCornell = new Person("Gary", "Cornell", new Date(1963, 5, 8));

		List<Person> authors = new ArrayList<Person>();
		authors.add(cHorstmann);
		authors.add(gCornell);

		Book jat = new Book("Java: Advanced Features", authors, 2004, "Prentice Hall");
		return jat;
	}
}
