package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ContactDB {

	
	private String path = "data";
	private String filename = "contacts";
	
	public ArrayList<Contact> getContacts(){
        try {
        	FileInputStream arq = new FileInputStream(path +"/" + filename);
            ObjectInputStream obj = new ObjectInputStream(arq);
            ArrayList<Contact> contactList = (ArrayList<Contact>) obj.readObject();
			obj.close();
			return contactList;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	public void saveContacts(ArrayList <Contact> contactList) {
		try {
			FileOutputStream arq = new FileOutputStream(path +"/" + filename);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
