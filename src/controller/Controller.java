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
	
	public void addContact(String name, String phone, String address ) {
		cl.addContact(name, phone, address);
	}
	
	public void removeContacts(ArrayList<Integer> indexList) {
			cl.removeContact(indexList);
	}
	
}
