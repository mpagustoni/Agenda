package view;

import java.util.ArrayList;
import java.util.Arrays;

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
	private Boolean[] checkList;
	
	
	public ContactTableModel() {
		 contactList = new Controller().getContacts();
		 checkList = new Boolean[contactList.size()];
		 Arrays.fill(checkList, new Boolean(false));
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
			return  "Selecionar";
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
			return checkList[rowIndex].booleanValue();
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
	
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		checkList[rowIndex] = (Boolean)aValue;
        fireTableDataChanged();
    }
	
	public void removeSelectedItems() {
		ArrayList<Integer> indexList = new ArrayList<Integer>();

		for(int i = 0; i < checkList.length; i++) {
			if(checkList[i].booleanValue()) {
				indexList.add(new Integer(i));
			}
		}	
		indexList.trimToSize();
		new Controller().removeContacts(indexList);
	}
}
