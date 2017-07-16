package controller;
import java.util.ArrayList;
import model.Contact;
import model.ContactList;

public class Controller {
	
	
	ContactList cl;
	
	public Controller() {
		cl = new ContactList();
		
	}
	public ArrayList<Contact> getContacts() {
		return cl.getContacts();
	}
	
	public void addContact(String name, String address, String phone) {
		cl.addContact(name, address, phone);
	}
	
	public void removeContact(int index) {
		cl.removeContact(index);
	}
	
}
