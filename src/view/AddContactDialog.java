package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Controller;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AddContactDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldAddress;
	private final Action actionAdd = new SwingActionAddContact();
	private final Action actionCancelAdd = new SwingActionCancelAddContact();


	/**
	 * Create the dialog.
	 */
	public AddContactDialog() {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNome = new JLabel("Nome:");
			lblNome.setBounds(12, 13, 31, 14);
			contentPanel.add(lblNome);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setBounds(48, 10, 164, 20);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			JLabel lblTelefone = new JLabel("Telefone:");
			lblTelefone.setBounds(222, 13, 46, 14);
			contentPanel.add(lblTelefone);
		}
		{
			textFieldPhone = new JTextField();
			textFieldPhone.setBounds(278, 10, 146, 20);
			contentPanel.add(textFieldPhone);
			textFieldPhone.setColumns(10);
		}
		{
			JLabel lblEndereo = new JLabel("Endere\u00E7o:");
			lblEndereo.setBounds(12, 41, 49, 14);
			contentPanel.add(lblEndereo);
		}
		{
			textFieldAddress = new JTextField();
			textFieldAddress.setBounds(68, 41, 356, 20);
			contentPanel.add(textFieldAddress);
			textFieldAddress.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton AddButton = new JButton("Adicionar");
				AddButton.setAction(actionAdd);
				AddButton.setActionCommand("Add");
				buttonPane.add(AddButton);
				getRootPane().setDefaultButton(AddButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setAction(actionCancelAdd);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private class SwingActionAddContact extends AbstractAction {
		public SwingActionAddContact() {
			putValue(NAME, "Adicionar");
		}
		public void actionPerformed(ActionEvent e) {
			new Controller().addContact(textFieldName.getText(), textFieldPhone.getText(), textFieldAddress.getText());
			dispose();
		}
	}
	private class SwingActionCancelAddContact extends AbstractAction {
		public SwingActionCancelAddContact() {
			putValue(NAME, "Cancelar");
			
		}
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	}
}
