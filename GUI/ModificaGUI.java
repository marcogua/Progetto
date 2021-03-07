package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import Classi.Cliente;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class ModificaGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNome;
	private JTextField textFieldCognome;
	private JTextField textFieldEmail;
	private JTextField textFieldCodiceCliente;
	private JTextField textFieldCodiceTessera;
	private JButton buttonAggiungi;
	private JButton buttonAnnulla;
	private Controllore controll;
	
	/**
	 * Create the dialog.
	 */
	public ModificaGUI(Controllore ctrl, Cliente client) {
		controll = ctrl;
		setBounds(100, 100, 800, 480);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panelTop = new JPanel();
			panelTop.setBackground(new Color(153, 153, 153));
			contentPanel.add(panelTop, BorderLayout.NORTH);
			{
				JLabel labelModifcaCliente = new JLabel("Modifica un cliente");
				labelModifcaCliente.setForeground(Color.WHITE);
				labelModifcaCliente.setBackground(Color.WHITE);
				panelTop.add(labelModifcaCliente);
			}
		}
		{
			JPanel panelCentral = new JPanel();
			panelCentral.setBackground(new Color(153, 153, 153));
			contentPanel.add(panelCentral, BorderLayout.CENTER);
			
			JLabel labelNome = new JLabel("Nome");
			
			textFieldNome = new JTextField();
			textFieldNome.setColumns(10);
			
			JLabel labelCognome = new JLabel("Cognome");
			
			textFieldCognome = new JTextField();
			textFieldCognome.setColumns(10);
			
			JLabel labelEmail = new JLabel("Email");
			
			textFieldEmail = new JTextField();
			textFieldEmail.setColumns(10);
			
			JLabel labelCodiceCliente = new JLabel("Codice cliente");
			
			textFieldCodiceCliente = new JTextField();
			textFieldCodiceCliente.setColumns(10);
			
			
			JLabel labelCodiceTessera = new JLabel("Codice tessera");
			
			textFieldCodiceTessera = new JTextField();
			textFieldCodiceTessera.setColumns(10);
			
			GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
			gl_panelCentral.setHorizontalGroup(
				gl_panelCentral.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelCentral.createSequentialGroup()
						.addGap(151)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelCentral.createSequentialGroup()
								.addComponent(labelCodiceTessera)
								.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
								.addComponent(textFieldCodiceTessera, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelCentral.createSequentialGroup()
								.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
									.addComponent(labelCognome, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
									.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(labelEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(labelCodiceCliente))
									.addComponent(labelNome, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
								.addGap(23)
								.addGroup(gl_panelCentral.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelCentral.createSequentialGroup()
											.addGap(23)
											.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldCognome, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
										.addComponent(textFieldNome, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
									.addComponent(textFieldCodiceCliente, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))))
						.addGap(172))
			);
			gl_panelCentral.setVerticalGroup(
				gl_panelCentral.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelCentral.createSequentialGroup()
						.addContainerGap(114, Short.MAX_VALUE)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelNome)
							.addComponent(textFieldNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelCognome)
							.addComponent(textFieldCognome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelEmail)
							.addComponent(textFieldEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(24)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelCodiceCliente)
							.addComponent(textFieldCodiceCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(21)
						.addGroup(gl_panelCentral.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelCodiceTessera)
							.addComponent(textFieldCodiceTessera, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(70))
			);
			panelCentral.setLayout(gl_panelCentral);
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(new Color(153, 153, 153));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				buttonAggiungi = new JButton("Aggiungi");
				buttonAggiungi.setBackground(Color.GREEN);
				buttonAggiungi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							controll.rimuoviClienteTabella(textFieldCodiceCliente.getText());
							controll.salvaCliente( textFieldCodiceCliente, textFieldNome, 
									textFieldCognome, textFieldEmail, textFieldCodiceTessera);
							dispose();
						} catch (Exception e1) {
						
						}
					}
				});
				buttonAggiungi.setActionCommand("OK");
				getRootPane().setDefaultButton(buttonAggiungi);
			}
			{
				buttonAnnulla = new JButton("Annulla");
				buttonAnnulla.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
						
					}
				});
				buttonAnnulla.setBackground(Color.RED);
				buttonAnnulla.setActionCommand("Cancel");
			}
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
			buttonPanel.add(buttonAggiungi);
			buttonPanel.add(buttonAnnulla);
		}
	}

	public void riceviCliente(Cliente client) {
	
				controll.Leggi(client, this.textFieldCodiceCliente, this.textFieldNome, 
						this.textFieldCognome, this.textFieldEmail, this.textFieldCodiceTessera);
			
	}

}
