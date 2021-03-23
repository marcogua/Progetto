package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Interfaccie.ControlloreInterfaccia;

import java.awt.Component;
import javax.swing.Box;

public class ListaProdotti extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableListaProdotti;
	private ControlloreInterfaccia controll;
	

	/**
	 * Launch the application.
	 */
	
	/*
	public static void main(String[] args) {
		try {
			ListaProdotti dialog = new ListaProdotti();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public ListaProdotti() {
		setBounds(100, 100, 801, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		controll.visualizzaListaProdotti(tableListaProdotti, "");//Bisogna inserire l'idLista passato dalla homegui
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblIdLista = new JLabel("IdLista :");
				lblIdLista.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel.add(lblIdLista);
			}
			{
				JLabel lblValoreIdLista = new JLabel("Null");
				lblValoreIdLista.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel.add(lblValoreIdLista);
			}
		}
		{
			JScrollPane scrollPaneListaProdotti = new JScrollPane();
			contentPanel.add(scrollPaneListaProdotti, BorderLayout.CENTER);
			{
				tableListaProdotti = new JTable();
				tableListaProdotti.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Quantita", "Descrizione", "CodiceProdotto"
					}
				));
				scrollPaneListaProdotti.setViewportView(tableListaProdotti);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		//controll.visualizzaListaProdotti(tableListaProdotti, idLista);
	}

}
