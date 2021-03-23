package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Pagamento;
import Classi.Prodotto;
import Interfaccie.ControlloreInterfaccia;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PagamentoGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNomeIntestatario;
	private JTextField textFieldNumeroCarta;
	private JTextField textFieldCvv;
	private JTextField textFieldPin;
	private JPanel panelMetodoPagamento;
	private JPanel panelPagamentoCarta;
	private JTextField textFieldTesseraFedelta;
	private JTextField textFieldContantiDati;
	private JTextField textFieldNomeIntesta;
	private JPanel panelPagamentoContanti;
	private JTextField textFieldTesseraFedeltaCarta;
	private JTextPane textPaneTotaleCatra;
	private ArrayList<Prodotto> listaProdotti;
	private ControlloreInterfaccia controll;

	public ArrayList<Prodotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	/**
	 * Create the dialog.
	 */
	public PagamentoGUI(ControlloreInterfaccia ctrl) {
		controll = ctrl;
		setBounds(203, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(153, 153, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(153, 153, 153));
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel labelPagamento = new JLabel("Pagamento");
				labelPagamento.setFont(new Font("Tahoma", Font.BOLD, 20));
				panel.add(labelPagamento);
			}
		}
		{
			JLayeredPane layeredPane = new JLayeredPane();
			contentPanel.add(layeredPane, BorderLayout.CENTER);
			layeredPane.setLayout(new CardLayout(0, 0));
			{
				panelMetodoPagamento = new JPanel();
				panelMetodoPagamento.setBackground(new Color(153, 153, 153));
				layeredPane.add(panelMetodoPagamento, "name_161436958481200");
				
				JButton buttonCarta = new JButton("");
				buttonCarta.setBackground(new Color(153, 153, 153));
				buttonCarta.setIcon(new ImageIcon(PagamentoGUI.class.getResource("/IMM/Prepagata.png")));
				buttonCarta.setBorderPainted(false);
				buttonCarta.setFocusPainted(false);
				buttonCarta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(panelPagamentoCarta);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				});
				
				JButton buttonContanti = new JButton("Contanti");
				buttonContanti.setForeground(Color.GRAY);
				buttonContanti.setIcon(new ImageIcon(PagamentoGUI.class.getResource("/IMM/Contanti.png")));
				buttonContanti.setBackground(new Color(153, 153, 153));
				buttonContanti.setBorderPainted(false);
				buttonContanti.setFocusPainted(false);
				buttonContanti.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(panelPagamentoContanti);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				});
				GroupLayout gl_panelMetodoPagamento = new GroupLayout(panelMetodoPagamento);
				gl_panelMetodoPagamento.setHorizontalGroup(
					gl_panelMetodoPagamento.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelMetodoPagamento.createSequentialGroup()
							.addGap(61)
							.addComponent(buttonCarta, GroupLayout.PREFERRED_SIZE, 277, Short.MAX_VALUE)
							.addGap(103)
							.addComponent(buttonContanti, GroupLayout.PREFERRED_SIZE, 276, Short.MAX_VALUE)
							.addGap(57))
				);
				gl_panelMetodoPagamento.setVerticalGroup(
					gl_panelMetodoPagamento.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelMetodoPagamento.createSequentialGroup()
							.addGap(94)
							.addGroup(gl_panelMetodoPagamento.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonCarta, GroupLayout.PREFERRED_SIZE, 256, Short.MAX_VALUE)
								.addComponent(buttonContanti, GroupLayout.PREFERRED_SIZE, 256, Short.MAX_VALUE))
							.addGap(133))
				);
				panelMetodoPagamento.setLayout(gl_panelMetodoPagamento);
			}
			{
				panelPagamentoCarta = new JPanel();
				panelPagamentoCarta.setBackground(new Color(153, 153, 153));
				layeredPane.add(panelPagamentoCarta, "name_161439237694900");
				
				JLabel labelNomeIntestatario = new JLabel("Nome intestatario");
				
				textFieldNomeIntestatario = new JTextField();
				textFieldNomeIntestatario.setColumns(10);
				
				
				JLabel labelNumeroCarta = new JLabel("Numero carta");
				
				textFieldNumeroCarta = new JTextField();
				textFieldNumeroCarta.setColumns(10);
				
				JLabel labelCvv = new JLabel("CVV");
				
				textFieldCvv = new JTextField();
				textFieldCvv.setColumns(10);
				
				JLabel labelPin = new JLabel("Pin");
				
				textFieldPin = new JTextField();
				textFieldPin.setColumns(10);
				
				JLabel labelMeseGiornoScadenza = new JLabel("Data validit\u00E0");
				
				JComboBox comboBoxMese = new JComboBox();
				comboBoxMese.setBackground(new Color(204, 204, 204));
				comboBoxMese.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
				
				JComboBox comboBoxAnno = new JComboBox();
				comboBoxAnno.setBackground(new Color(204, 204, 204));
				comboBoxAnno.setModel(new DefaultComboBoxModel(new String[] {"2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"}));
				
				JButton buttonIndietro = new JButton("Indietro");
				buttonIndietro.setBackground(new Color(204, 204, 204));
				buttonIndietro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						layeredPane.removeAll();
						layeredPane.add(panelMetodoPagamento);
						layeredPane.repaint();
						layeredPane.revalidate();
					}
				});
				
				JButton buttonPaga = new JButton("Paga");
				buttonPaga.setBackground(new Color(204, 204, 204));
				
				buttonPaga.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						controll.generaOrdineCarta(textPaneTotaleCatra, textFieldNumeroCarta, textFieldTesseraFedeltaCarta, listaProdotti);
						setVisible(false);
					}
				});
				
				JLabel labelRiepilogoOrdine = new JLabel("Riepilogo ordine");
				
				JLabel labelTotale = new JLabel("Totale");
				
				JLabel labelIva = new JLabel("Di cui IVA");
				
				textPaneTotaleCatra = new JTextPane();
				
				
				JTextPane textPaneIvaCarta = new JTextPane();
				
				JLabel labelTesseraFedelta = new JLabel("Tessera fedelt\u00E0");
				
				textFieldTesseraFedeltaCarta = new JTextField();
				textFieldTesseraFedeltaCarta.setColumns(10);
				GroupLayout gl_panelPagamentoCarta = new GroupLayout(panelPagamentoCarta);
				gl_panelPagamentoCarta.setHorizontalGroup(
					gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
							.addGap(100)
							.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
								.addComponent(buttonIndietro, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
										.addComponent(labelNomeIntestatario)
										.addComponent(labelNumeroCarta)
										.addComponent(labelCvv)
										.addComponent(labelPin)
										.addComponent(labelMeseGiornoScadenza)
										.addComponent(labelTesseraFedelta))
									.addGap(18)
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textFieldTesseraFedeltaCarta)
										.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
											.addComponent(comboBoxMese, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(comboBoxAnno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(textFieldPin)
										.addComponent(textFieldCvv)
										.addComponent(textFieldNumeroCarta)
										.addComponent(textFieldNomeIntestatario, GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
											.addGap(108)
											.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
												.addComponent(labelTotale)
												.addComponent(labelIva))
											.addGap(50)
											.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
												.addComponent(textPaneIvaCarta, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
												.addComponent(textPaneTotaleCatra, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
												.addComponent(buttonPaga, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
											.addGap(158)
											.addComponent(labelRiepilogoOrdine)))))
							.addGap(153))
				);
				gl_panelPagamentoCarta.setVerticalGroup(
					gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelNomeIntestatario)
								.addComponent(textFieldNomeIntestatario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelRiepilogoOrdine))
							.addGap(18)
							.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelNumeroCarta)
										.addComponent(textFieldNumeroCarta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelTotale))
									.addGap(18)
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelCvv)
										.addComponent(textFieldCvv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(labelIva))
									.addGap(18)
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelPin)
										.addComponent(textFieldPin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelMeseGiornoScadenza)
										.addComponent(comboBoxAnno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxMese, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_panelPagamentoCarta.createSequentialGroup()
									.addComponent(textPaneTotaleCatra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textPaneIvaCarta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
								.addComponent(labelTesseraFedelta)
								.addComponent(textFieldTesseraFedeltaCarta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(117)
							.addGroup(gl_panelPagamentoCarta.createParallelGroup(Alignment.BASELINE)
								.addComponent(buttonIndietro, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
								.addComponent(buttonPaga, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(66, Short.MAX_VALUE))
				);
				panelPagamentoCarta.setLayout(gl_panelPagamentoCarta);
			}
			
			panelPagamentoContanti = new JPanel();
			panelPagamentoContanti.setBackground(new Color(153, 153, 153));
			layeredPane.add(panelPagamentoContanti, "name_221156625432800");
			
			JButton buttonIndietro = new JButton("Indietro");
			buttonIndietro.setBackground(new Color(204, 204, 204));
			buttonIndietro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					layeredPane.removeAll();
					layeredPane.add(panelMetodoPagamento);
					layeredPane.repaint();
					layeredPane.revalidate();
				}
			});
			
			JLabel labelNomeIntestatario = new JLabel("Nome intestatario");
			
			JLabel labelContatniDati = new JLabel("Contanti dati");
			
			JLabel labelCodiceTesseraFedelta = new JLabel("Tessera fedelt\u00E0");
			
			textFieldTesseraFedelta = new JTextField();
			textFieldTesseraFedelta.setColumns(10);
			
			textFieldContantiDati = new JTextField();
			textFieldContantiDati.setColumns(10);
			
			textFieldNomeIntesta = new JTextField();
			textFieldNomeIntesta.setColumns(10);
			
			JLabel labelTotale = new JLabel("Totale");
			
			JLabel labelIva = new JLabel("Di cui IVA");
			
			JTextPane textPaneIvaCarta = new JTextPane();
			
			JTextPane textPaneTotaleContanti = new JTextPane();
			
			JButton buttonPaga = new JButton("Paga");
			buttonPaga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controll.generaOrdineContanti(listaProdotti, textFieldContantiDati, textPaneTotaleContanti, textFieldTesseraFedelta);
					controll.generaPunti(textFieldTesseraFedelta, textPaneTotaleContanti, listaProdotti);
					controll.sottraiQuantitaProdottiVenduti(listaProdotti);
					setVisible(false);
				}
			});
			buttonPaga.setBackground(new Color(204, 204, 204));
			
			JLabel labelRiepilogoOrdine = new JLabel("Riepilogo ordine");
			GroupLayout gl_panelPagamentoContanti = new GroupLayout(panelPagamentoContanti);
			gl_panelPagamentoContanti.setHorizontalGroup(
				gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
						.addGap(100)
						.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
							.addComponent(buttonIndietro, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
								.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
									.addComponent(labelNomeIntestatario)
									.addComponent(labelContatniDati)
									.addComponent(labelCodiceTesseraFedelta))
								.addGap(41)
								.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
									.addComponent(textFieldTesseraFedelta, 113, 113, 113)
									.addComponent(textFieldContantiDati, 113, 113, 113)
									.addComponent(textFieldNomeIntesta, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
								.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
										.addGap(108)
										.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
											.addComponent(labelTotale)
											.addComponent(labelIva))
										.addGap(50)
										.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
											.addComponent(textPaneIvaCarta, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addComponent(textPaneTotaleContanti, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
											.addComponent(buttonPaga, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
										.addGap(158)
										.addComponent(labelRiepilogoOrdine)))))
						.addGap(153))
			);
			gl_panelPagamentoContanti.setVerticalGroup(
				gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
						.addGap(67)
						.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.BASELINE)
							.addComponent(labelNomeIntestatario)
							.addComponent(textFieldNomeIntesta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(labelRiepilogoOrdine))
						.addGap(18)
						.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
								.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.BASELINE)
									.addComponent(labelContatniDati)
									.addComponent(textFieldContantiDati, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelTotale))
								.addGap(18)
								.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.BASELINE)
									.addComponent(labelCodiceTesseraFedelta)
									.addComponent(textFieldTesseraFedelta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(labelIva)))
							.addGroup(gl_panelPagamentoContanti.createSequentialGroup()
								.addComponent(textPaneTotaleContanti, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textPaneIvaCarta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGap(227)
						.addGroup(gl_panelPagamentoContanti.createParallelGroup(Alignment.BASELINE)
							.addComponent(buttonIndietro, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addComponent(buttonPaga, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(70, Short.MAX_VALUE))
			);
			panelPagamentoContanti.setLayout(gl_panelPagamentoContanti);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 153, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton buttonAnulla = new JButton("Anulla");
				buttonAnulla.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				buttonAnulla.setBackground(new Color(204, 204, 204));
				buttonAnulla.setActionCommand("Cancel");
				buttonPane.add(buttonAnulla);
			}
		}
	}
	
	public void riceviTortale(Pagamento Pagamento, ArrayList<Prodotto> prodotto) {
		
		controll.leggiVal(Pagamento, textPaneTotaleCatra);
		this.listaProdotti = prodotto;
}
}
