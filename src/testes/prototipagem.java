package testes;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import controller.Controller;
import model.Contact;
import model.ContactList;

public class prototipagem {

	//@Test
	public void date() throws InterruptedException {
		Contact c = new Contact("mauricio","aqui","123");
		System.out.println(c.getDate());
	}
	
	//@Test
	public void contactListConstructor() {
		ContactList cl = new ContactList();
		File f = new File("./data/contacts.adb");
			assertTrue(f.exists());	
	}

	
	//@Test
	public void insertionTest() {
		ContactList cl = new ContactList();
		ArrayList<Contact> alc = cl.getContacts();
		String n = new Integer(alc.size()).toString();
		for(int i = 0; i < 50; i++) {
			cl.addContact(n, n, n);
		}
		alc = cl.getContacts();
		
		for (Contact a: alc) {
			System.out.println(a.getName() + " " + a.getAddress() + " " + a.getPhone());
		}
	}
	
	//@Test
	public void fillList() {
		ContactList cl = new ContactList();
		ArrayList<Contact> c = cl.getContacts();
		
		for (Contact a: c) {
			System.out.println(a.getName() + " " + a.getAddress() + " " + a.getPhone());
		}
	}
}
