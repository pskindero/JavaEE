package com.pskindero.javaee.jaxb.jaxb_examples;

import java.awt.print.Book;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.pskindero.javaee.jaxb.jaxb_examples.model.Person;

public class App  {
	
    public static void main( String[] args ) throws JAXBException{
        Person p1 = new Person("Henryk", "Sienkiewicz", new Date(1888, 3, 3));

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        // Write to System.out
        m.marshal(p1, System.out);

        // get variables from our xml file, created before
        System.out.println();
        System.out.println("Output from our XML File: ");
     
//        Unmarshaller um = context.createUnmarshaller();
//        Bookstore bookstore2 = (Bookstore) um.unmarshal(new FileReader(
//                        BOOKSTORE_XML));
//        ArrayList<Book> list = bookstore2.getBooksList();
//        for (Book book : list) {
//                System.out.println("Book: " + book.getName() + " from "
//                                + book.getAuthor());
//        }

    }
}
