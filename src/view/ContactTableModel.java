package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import controller.Controller;
import model.Contact;

public class ContactTableModel extends AbstractTableModel {
	private final int COL_NAME = 0;
	private final int COL_PHONE = 1;
	private final int COL_ADDRESS = 2;
	private final int COL_CHECK = 3;
	private final int COL_COUNT = 4;
	private ArrayList<Contact> contactList;
	
	
	public ContactTableModel() {
		 contactList = new Controller().getContacts();
	}
	@Override
	public int getColumnCount() {
		return COL_COUNT;
	}

	@Override
	public int getRowCount() {
		return contactList.size();
	}
	
	public String getColumnName(int columnIndex) {
		switch(columnIndex) {
		case COL_NAME:
			return "Nome";
		case COL_PHONE:
			return "Telefone";
		case COL_ADDRESS:
			return "Endereço";
		default:
			return  "";
		}
	}
	
	public Class<?> getColumnClass(int columnIndex){
		switch(columnIndex) {
		case COL_NAME:
		case COL_PHONE:
		case COL_ADDRESS:
			return String.class;
		case COL_CHECK:
			return Boolean.class;
		default:
			return null;
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case COL_NAME:
			return contactList.get(rowIndex).getName();
		case COL_PHONE:
			return contactList.get(rowIndex).getPhone();
		case COL_ADDRESS:
			return contactList.get(rowIndex).getAddress();
		case COL_CHECK:
			return new Boolean(false);
		default:
			return null;
		}
	}
	
	public boolean isCellEditable(int ronIndex, int columnIndex) {
		switch(columnIndex) {
		case COL_NAME:
		case COL_PHONE:
		case COL_ADDRESS:
			return false;
		case COL_CHECK:
			return true;
		default:
			return false;
		}
	}

}
