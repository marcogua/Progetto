package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllore.Controllore;
import Classi.GenerateCode;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class AggiungiClienteGUI extends JDialog {

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
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			AggiungiClienteGUI dialog = new AggiungiClienteGUI();
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
	public AggiungiClienteGUI(Controllore ctrl) {
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
				JLabel labelAggiungiCliente = new JLabel("Aggiungi un cliente");
				panelTop.add(labelAggiungiCliente);
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
			textFieldCodiceCliente.setEditable(false);
			textFieldCodiceCliente.setColumns(10);
			
			
			JLabel labelCodiceTessera = new JLabel("Codice tessera");
			
			textFieldCodiceTessera = new JTextField();
			textFieldCodiceTessera.setEditable(false);
			textFieldCodiceTessera.setColumns(10);
			
			JButton buttonCodici = new JButton("Genera Codici");
			buttonCodici.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GenerateCode clientCode = new GenerateCode();
					textFieldCodiceTessera.setText(clientCode.generatoreCodiceTessera());
					textFieldCodiceCliente.setText(clientCode.generatoreCodiceCliente());
				}
			});
			buttonCodici.setBackground(new Color(204, 204, 204));
			buttonCodici.setBorderPainted(false);
			buttonCodici.setFocusPainted(false);
			
			GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
			gl_panelCentral.setHorizontalGroup(
				gl_panelCentral.createParallelGroup(Alignment.LEADING)
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
					.addGroup(Alignment.TRAILING, gl_panelCentral.createSequentialGroup()
						.addContainerGap(378, Short.MAX_VALUE)
						.addComponent(buttonCodici)
						.addGap(307))
			);
			gl_panelCentral.setVerticalGroup(
				gl_panelCentral.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panelCentral.createSequentialGroup()
						.addContainerGap(113, Short.MAX_VALUE)
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
						.addGap(37)
						.addComponent(buttonCodici)
						.addContainerGap())
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
							controll.salvaCliente( textFieldCodiceCliente, textFieldNome,
									textFieldCognome, textFieldEmail, textFieldCodiceTessera);
							dispose();
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
}
