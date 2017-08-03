package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;

public class Principal {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 802, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setEnabled(false);
		updateTable();
		frame.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		
		JButton btnAddContact = new JButton("Adicionar");
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AddContactDialog dialog = new AddContactDialog();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				updateTable();
			}
		});
		panel.setLayout(new MigLayout("", "[88px]", "[26px][]"));
		panel.add(btnAddContact, "cell 0 0,alignx left,aligny top");
		
		JButton btnRemoveContact = new JButton("Remover");
		panel.add(btnRemoveContact, "cell 0 1,alignx left,aligny top");
	}
	
	private void updateTable() {
		table.setModel(new DefaultTableModel(
				new Controller().getContactByArray(),
			new String[] {
				"Nome", "Telefone", "Endereço"
			}
		));
	}
}
