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
	
	public String [][] getContactByArray(){
		ArrayList<Contact> alc  = this.getContacts();
		String [][] contacts = new String[alc.size()][3];
		for(Contact c: alc) {
			int i = alc.indexOf(c);
			contacts[i][0] = c.getName();
			contacts[i][1] = c.getPhone();
			contacts[i][2] = c.getAddress();
		}
		return contacts;
	}
}
