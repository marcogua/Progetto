package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Controllore.Controllore;
import Interfaccie.ControlloreInterfaccia;

import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListaProdottiGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableListaProdotti;
	private Controllore controll;
	private String idLista;
	private JLabel lblValoreIdLista;
	

	/**
	 * Create the dialog.
	 */
	public ListaProdottiGUI(Controllore ctr) {
		controll = ctr;
		setBounds(100, 100, 801, 574);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		//controll.visualizzaListaProdotti(tableListaProdotti, "LPAZ193PBC5S8FLK");//Bisogna inserire l'idLista passato dalla homegui
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 153, 153));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblIdLista = new JLabel("IdLista :");
				lblIdLista.setFont(new Font("Tahoma", Font.BOLD, 15));
				panel.add(lblIdLista);
			}
			{
				lblValoreIdLista = new JLabel("Null");
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
						{null, null, null},
					},
					new String[] {
						"Codice Prodotto", "Descrizione", "Quantit\u00E0"
					}
				));
				scrollPaneListaProdotti.setViewportView(tableListaProdotti);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 153, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(204, 204, 204));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setFont(new Font("Tahoma", Font.BOLD, 20));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		//controll.visualizzaListaProdotti(tableListaProdotti, idLista);
	}
	
	public void rceviIdLista(String idLista) {
		lblValoreIdLista.setText(idLista);
		controll.visualizzaListaProdotti(tableListaProdotti, idLista);
	}

}
