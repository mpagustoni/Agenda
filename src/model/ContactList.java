package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ContactList {

	
	private String path = "data";
	private String filename = "contacts.adb";
	
	public ContactList() {
		File f = new File(this.path + "/" + filename);
		if (!f.exists()) {
			new File(this.path).mkdirs();
			
			ArrayList<Contact> cl =  new ArrayList<Contact>();
			this.saveContacts(cl);
		}
	}
	
	public ArrayList<Contact> getContacts(){
        try {
        	FileInputStream fis = new FileInputStream(this.path + "/" + this.filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Contact> contactList = (ArrayList<Contact>) ois.readObject();
			ois.close();
			return contactList;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void saveContacts(ArrayList <Contact> contactList) {
		try {
			FileOutputStream fos = new FileOutputStream(path +"/" + filename);
			ObjectOutputStream oos = new ObjectOutputStream (fos);  
			oos.writeObject (contactList);  
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addContact(String name, String phone, String address) {
		ArrayList<Contact> contactList = this.getContacts();
		Contact newContact = new Contact(name, address, phone);
		contactList.add(newContact);
		this.saveContacts(contactList);
	}
	
	public void removeContact(int index) {
		ArrayList <Contact>contactList = this.getContacts();
		try {
			contactList.remove(index);
			this.saveContacts(contactList);
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}
	
}
