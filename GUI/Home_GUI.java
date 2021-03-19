package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Classi.Prodotto;
import Interfaccie.ControlloreInterfaccia;

import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Home_GUI extends JFrame {

	private JPanel contentPane;
	private ControlloreInterfaccia controll;
	private JTable tableCliente;
	private JTextField textFieldCerca;
	private JTextField textFieldCarta;
	private JTable tableTesseraPunti;
	private JTextField textField;
	private JTable tableMagazzino;
	private JTextField textField_2;
	private JTable tableRegistro;
	private JTable tableCarrello;
	private JTextField textFieldCercaFruttaPer;
	private JTextField textFieldCercaVerduraPer;
	private JTextField textFieldCercaFarinaceiPer;
	private JTextField textFieldCercaLatticiniPer;
	private JTextField textFieldCercaUovaPer;
	private JTextField textFieldCercaConfezionatiPer;
	private JTextField textFieldQuantitaFrutta;
	private JTable tableFrutta;
	private JTable tableVerdura;
	private JTextField textFieldQuantitaVerdura;
	private JTable tableFarinacei;
	private JTextField textFieldQuantitaFarinacei;
	private JTable tableLatticini;
	private JTextField textFieldQuantitaLatticini;
	private JTable tableUova;
	private JTextField textFieldQuantitaUova;
	private JTextField textFieldQuantitaConfezionati;
	private JTable tableConfezionati;
	private JLabel lblTotaleNumero;
	private ArrayList<Prodotto> carrelloArrayList = new ArrayList<Prodotto>();


	/**
	 * Create the frame.
	 */
	public Home_GUI(ControlloreInterfaccia ctrl) {
		controll = ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1400, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setMinimumSize(new Dimension(1400, 720));
		setContentPane(contentPane);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setBackground(new Color(153, 153, 153));
		contentPane.add(TopPanel, BorderLayout.NORTH);
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane, BorderLayout.CENTER);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel prodottiPanel = new JPanel();
		layeredPane.add(prodottiPanel, "name_97844091228400");
		prodottiPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelProdottiMain = new JPanel();
		prodottiPanel.add(panelProdottiMain, BorderLayout.CENTER);
		panelProdottiMain.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCarrello = new JPanel();
		panelProdottiMain.add(panelCarrello, BorderLayout.EAST);
		panelCarrello.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(153, 153, 153));
		panelCarrello.add(panel_7, BorderLayout.SOUTH);
		
		
		JPanel BotPanrl = new JPanel();
		
		JLabel lblNewLabel = new JLabel("Fruttierbivendolo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		TopPanel.add(lblNewLabel);

		FlowLayout flowLayout = (FlowLayout) BotPanrl.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		BotPanrl.setBackground(new Color(153, 153, 153));
		contentPane.add(BotPanrl, BorderLayout.SOUTH);
		
		lblTotaleNumero = new JLabel("0");
		
		JButton ButtonPaga = new JButton("Pagamento");
		ButtonPaga.setHorizontalAlignment(SwingConstants.RIGHT);
		ButtonPaga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.Pagamento_GUI(controll.prelevaTotale(lblTotaleNumero));
				//controll.pagameto_GUI();
			}
		});
		ButtonPaga.setBackground(new Color(204, 204, 204));
		ButtonPaga.setBorderPainted(false);
		ButtonPaga.setFocusPainted(false);
		BotPanrl.add(ButtonPaga);
		
		JPanel LeftPanel = new JPanel();
		LeftPanel.setBackground(new Color(153, 153, 153));
		contentPane.add(LeftPanel, BorderLayout.WEST);
		
		JLabel jLabelTotale = new JLabel("Totale: ");
		jLabelTotale.setForeground(Color.WHITE);
		panel_7.add(jLabelTotale);
		
		lblTotaleNumero.setForeground(new Color(255, 255, 255));
		lblTotaleNumero.setBackground(new Color(255, 255, 255));
		panel_7.add(lblTotaleNumero);
		
		JPanel panelButtonsCarrello = new JPanel();
		panelButtonsCarrello.setBackground(new Color(153, 153, 153));
		panelCarrello.add(panelButtonsCarrello, BorderLayout.NORTH);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panelButtonsCarrello.add(horizontalStrut_5);
		
		JButton btnRimuoviDalCarello = new JButton("Rimuovi dal carello");
		btnRimuoviDalCarello.setBackground(new Color(204, 204, 204));
		btnRimuoviDalCarello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.rimuoviProdottoCarrello(tableCarrello, carrelloArrayList, lblTotaleNumero);
			}
		});
		panelButtonsCarrello.add(btnRimuoviDalCarello);
		
		Component horizontalStrut_8 = Box.createHorizontalStrut(20);
		panelButtonsCarrello.add(horizontalStrut_8);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panelButtonsCarrello.add(horizontalStrut_7);
		
		Component horizontalStrut_11 = Box.createHorizontalStrut(20);
		panelButtonsCarrello.add(horizontalStrut_11);
		
		JButton btnSvuotaCarello = new JButton("Svuota carello");
		btnSvuotaCarello.setBackground(new Color(204, 204, 204));
		btnSvuotaCarello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.svuotaCarello(tableCarrello, carrelloArrayList, lblTotaleNumero);
			}
		});
		panelButtonsCarrello.add(btnSvuotaCarello);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panelButtonsCarrello.add(horizontalStrut_6);
		
		JScrollPane scrollPaneCarello = new JScrollPane();
		panelCarrello.add(scrollPaneCarello, BorderLayout.CENTER);
		
		tableCarrello = new JTable();
		tableCarrello.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Descrizione", "Quantita", "Iva", "Prezzo"
			}
		));
		scrollPaneCarello.setViewportView(tableCarrello);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		scrollPaneCarello.setColumnHeaderView(verticalStrut);
		
		Component verticalStrut_1 = Box.createVerticalStrut(25);
		panel_7.add(verticalStrut_1);
		
		JLayeredPane layeredPaneGruttpoProdotti = new JLayeredPane();
		panelProdottiMain.add(layeredPaneGruttpoProdotti, BorderLayout.CENTER);
		layeredPaneGruttpoProdotti.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPaneRicerche = new JLayeredPane();
		layeredPaneGruttpoProdotti.add(layeredPaneRicerche, BorderLayout.NORTH);
		layeredPaneRicerche.setLayout(new CardLayout(0, 0));
		
		JPanel panelRicercaFrutta = new JPanel();
		panelRicercaFrutta.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaFrutta, "name_1146399486892000");
		
		JLabel lblCercaFruttaPer = new JLabel("Cerca per");
		lblCercaFruttaPer.setForeground(new Color(255, 255, 255));
		panelRicercaFrutta.add(lblCercaFruttaPer);
		
		JComboBox comboBoxCercaFruttaPer = new JComboBox();
		comboBoxCercaFruttaPer.setBackground(new Color(204, 204, 204));
		comboBoxCercaFruttaPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data raccolata"}));
		panelRicercaFrutta.add(comboBoxCercaFruttaPer);
		
		textFieldCercaFruttaPer = new JTextField();
		panelRicercaFrutta.add(textFieldCercaFruttaPer);
		textFieldCercaFruttaPer.setColumns(10);
		
		JButton btnCercaFruttaPer = new JButton("Cerca");
		btnCercaFruttaPer.setBackground(new Color(204, 204, 204));
		btnCercaFruttaPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBoxCercaFruttaPer.getSelectedItem().toString().compareTo("Codice prodotto")) == 0){
					controll.visualizzaTabellaFruttaCercaCodiceProdotto(tableFrutta, textFieldCercaFruttaPer.getText());
				}else if ((comboBoxCercaFruttaPer.getSelectedItem().toString().compareTo("Descrizione")) == 0) {
					controll.visualizzaTabellaFruttaCercaDescrizione(tableFrutta, textFieldCercaFruttaPer.getText());
				}else if((comboBoxCercaFruttaPer.getSelectedItem().toString().compareTo("Produttore/Fornitore")) == 0) {
					controll.visualizzaTabellaFruttaCercaProduttoreFornitore(tableFrutta, textFieldCercaFruttaPer.getText());
				}else if((comboBoxCercaFruttaPer.getSelectedItem().toString().compareTo("Provenienza")) == 0) {
					controll.visualizzaTabellaFruttaCercaProvenienza(tableFrutta, textFieldCercaFruttaPer.getText());
				}else if((comboBoxCercaFruttaPer.getSelectedItem().toString().compareTo("Data raccolata")) == 0) {
					controll.visualizzaTabellaFruttaCercaDataRaccolta(tableFrutta, textFieldCercaFruttaPer.getText());
				}
			}
		});
		panelRicercaFrutta.add(btnCercaFruttaPer);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panelRicercaFrutta.add(horizontalStrut_4);
		
		JLabel lblOrdinaFruttaPer = new JLabel("Ordina per");
		lblOrdinaFruttaPer.setForeground(new Color(255, 255, 255));
		panelRicercaFrutta.add(lblOrdinaFruttaPer);
		
		JComboBox comboBoxOrdinaFruttaPer = new JComboBox();
		comboBoxOrdinaFruttaPer.setBackground(new Color(204, 204, 204));
		comboBoxOrdinaFruttaPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaFruttaOrdinaCodiceProdottoAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaFruttaOrdinaDescrizioneAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaFruttaOrdinaProduttoreFornitoreAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaFruttaOrdinaProvenienzaAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Data raccolata") == 0) {
					controll.visualizzaTabellaFruttaOrdinaDataRaccoltaAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Quantita") == 0) {
					controll.visualizzaTabellaFruttaOrdinaQuantitaAsc(tableFrutta);
				}else if(comboBoxOrdinaFruttaPer.getSelectedItem().toString().compareTo("Prezzo") == 0) {
					controll.visualizzaTabellaFruttaOrdinaPrezzoAsc(tableFrutta);
				}
			}
		});
		comboBoxOrdinaFruttaPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data raccolata", "Quantita", "Prezzo"}));
		panelRicercaFrutta.add(comboBoxOrdinaFruttaPer);
		
		JPanel panelRicercaVerdura = new JPanel();
		panelRicercaVerdura.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaVerdura, "name_1147742836131600");
		
		JLabel lblCercaVerduraPer = new JLabel("Cerca per");
		lblCercaVerduraPer.setForeground(new Color(255, 255, 255));
		panelRicercaVerdura.add(lblCercaVerduraPer);
		
		JComboBox comboBoxCercaVerduraPer = new JComboBox();
		comboBoxCercaVerduraPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Porduttore/Fornitore", "Provenienza", "Data raccolta"}));
		panelRicercaVerdura.add(comboBoxCercaVerduraPer);
		
		textFieldCercaVerduraPer = new JTextField();
		textFieldCercaVerduraPer.setColumns(10);
		panelRicercaVerdura.add(textFieldCercaVerduraPer);
		
		JButton btnCercaVerduraPer = new JButton("Cerca");
		btnCercaVerduraPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((comboBoxCercaVerduraPer.getSelectedItem().toString().compareTo("Codice prodotto")) == 0){
					controll.visualizzaTabellaVerduraCercaCodiceProdotto(tableVerdura, textFieldCercaVerduraPer.getText());
				}else if ((comboBoxCercaVerduraPer.getSelectedItem().toString().compareTo("Descrizione")) == 0) {
					controll.visualizzaTabellaVerduraCercaDescrizione(tableVerdura, textFieldCercaVerduraPer.getText());
				}else if((comboBoxCercaVerduraPer.getSelectedItem().toString().compareTo("Produttore/Fornitore")) == 0) {
					controll.visualizzaTabellaVerduraCercaProduttoreFornitore(tableVerdura, textFieldCercaVerduraPer.getText());
				}else if((comboBoxCercaVerduraPer.getSelectedItem().toString().compareTo("Provenienza")) == 0) {
					controll.visualizzaTabellaVerduraCercaProvenienza(tableVerdura, textFieldCercaVerduraPer.getText());
				}else if((comboBoxCercaVerduraPer.getSelectedItem().toString().compareTo("Data raccolata")) == 0) {
					controll.visualizzaTabellaVerduraCercaDataRaccolta(tableVerdura, textFieldCercaVerduraPer.getText());
				}
			}
		});
		panelRicercaVerdura.add(btnCercaVerduraPer);
		
		Component horizontalStrut_4_1 = Box.createHorizontalStrut(20);
		panelRicercaVerdura.add(horizontalStrut_4_1);
		
		JLabel lblOrdinaVerduraPer = new JLabel("Ordina per");
		lblOrdinaVerduraPer.setForeground(new Color(255, 255, 255));
		panelRicercaVerdura.add(lblOrdinaVerduraPer);
		
		JComboBox comboBoxOrdinaVerduraPer = new JComboBox();
		comboBoxOrdinaVerduraPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaVerduraOrdinaCodiceProdottoAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaVerduraOrdinaDescrizioneAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaVerduraOrdinaProduttoreFornitoreAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaVerduraOrdinaProvenienzaAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Data raccolta") == 0) {
					controll.visualizzaTabellaVerduraOrdinaDataRaccoltaAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Quantita") == 0) {
					controll.visualizzaTabellaVerduraOrdinaQuantitaAsc(tableVerdura);
				}else if(comboBoxOrdinaVerduraPer.getSelectedItem().toString().compareTo("Prezzo") == 0) {
					controll.visualizzaTabellaVerduraOrdinaPrezzoAsc(tableVerdura);
				}
			}
		});
		comboBoxOrdinaVerduraPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data raccolta", "Quantita", "Prezzo"}));
		panelRicercaVerdura.add(comboBoxOrdinaVerduraPer);
		
		JPanel panelRicercaFarinacei = new JPanel();
		panelRicercaFarinacei.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaFarinacei, "name_1147849884309500");
		
		JLabel lblCercaFarinceiPer = new JLabel("Cerca per");
		lblCercaFarinceiPer.setForeground(new Color(255, 255, 255));
		panelRicercaFarinacei.add(lblCercaFarinceiPer);
		
		JComboBox comboBoxCercaFarinaceiPer = new JComboBox();
		comboBoxCercaFarinaceiPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data scadenza"}));
		panelRicercaFarinacei.add(comboBoxCercaFarinaceiPer);
		
		textFieldCercaFarinaceiPer = new JTextField();
		textFieldCercaFarinaceiPer.setColumns(10);
		panelRicercaFarinacei.add(textFieldCercaFarinaceiPer);
		
		JButton btnCercaFarinaceiPer = new JButton("Cerca");
		btnCercaFarinaceiPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxCercaFarinaceiPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaFarinaceiCercaCodiceProdotto(tableFarinacei, textFieldCercaFarinaceiPer.getText());
				}else if(comboBoxCercaFarinaceiPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaFarinaceiCercaDescrizione(tableFarinacei, textFieldCercaFarinaceiPer.getText());
				}else if(comboBoxCercaFarinaceiPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaFarinaceiCercaProduttoreFornitore(tableFarinacei, textFieldCercaFarinaceiPer.getText());
				}else if(comboBoxCercaFarinaceiPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaFarinaceiCercaProvenienza(tableFarinacei, textFieldCercaFarinaceiPer.getText());
				}else if(comboBoxCercaFarinaceiPer.getSelectedItem().toString().compareTo("Data scadenza") == 0) {
					controll.visualizzaTabellaFarinaceiCercaDataScadenza(tableFarinacei, textFieldCercaFarinaceiPer.getText());
				}
			}
		});
		panelRicercaFarinacei.add(btnCercaFarinaceiPer);
		
		Component horizontalStrut_4_2 = Box.createHorizontalStrut(20);
		panelRicercaFarinacei.add(horizontalStrut_4_2);
		
		JLabel lblOrdinaFarinaceiPer = new JLabel("Ordina per");
		lblOrdinaFarinaceiPer.setForeground(new Color(255, 255, 255));
		panelRicercaFarinacei.add(lblOrdinaFarinaceiPer);
		
		JComboBox comboBoxOrdinaFarinaceiPer = new JComboBox();
		comboBoxOrdinaFarinaceiPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaCodiceProdottoAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaDescrizioneAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaProvenienzaAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Data scadenza") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaDataScadenzaAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Qunatita") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaQuantitaAsc(tableFarinacei);
				}else if(comboBoxOrdinaFarinaceiPer.getSelectedItem().toString().compareTo("Prezzo") == 0) {
					controll.visualizzaTabellaFarinaceiOrdinaPrezzoAsc(tableFarinacei);
				}
			}
		});
		
		comboBoxOrdinaFarinaceiPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data scadenza", "Qunatita", "Prezzo"}));
		panelRicercaFarinacei.add(comboBoxOrdinaFarinaceiPer);
		
		JPanel panelRicercaLatticini = new JPanel();
		panelRicercaLatticini.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaLatticini, "name_1147965490570100");
		
		JLabel lblCercaLatticiniPer = new JLabel("Cerca per");
		lblCercaLatticiniPer.setForeground(new Color(255, 255, 255));
		panelRicercaLatticini.add(lblCercaLatticiniPer);
		
		JComboBox comboBoxCercaLatticiniPer = new JComboBox();
		comboBoxCercaLatticiniPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data mungitura", "Data produzione"}));
		panelRicercaLatticini.add(comboBoxCercaLatticiniPer);
		
		textFieldCercaLatticiniPer = new JTextField();
		textFieldCercaLatticiniPer.setColumns(10);
		panelRicercaLatticini.add(textFieldCercaLatticiniPer);
		
		JButton btnCercaLatticiniPer = new JButton("Cerca");
		btnCercaLatticiniPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaLatticiniCercaCodiceProdotto(tableLatticini, textFieldCercaLatticiniPer.getText());
				}else if(comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaLatticiniCercaDescrizione(tableLatticini, textFieldCercaLatticiniPer.getText());
				}else if(comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaLatticiniCercaProduttoreFornitore(tableLatticini, textFieldCercaLatticiniPer.getText());
				}else if(comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaLatticiniCercaProvenienza(tableLatticini, textFieldCercaLatticiniPer.getText());
				}else if(comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Data mungitura") == 0) {
					controll.visualizzaTabellaLatticiniCercaDataMungitura(tableLatticini, textFieldCercaLatticiniPer.getText());
				}else if(comboBoxCercaLatticiniPer.getSelectedItem().toString().compareTo("Data produzione") == 0) {
					controll.visualizzaTabellaLatticiniCercaDataProduzione(tableLatticini, textFieldCercaLatticiniPer.getText());
				}
			}
		});
		panelRicercaLatticini.add(btnCercaLatticiniPer);
		
		Component horizontalStrut_4_3 = Box.createHorizontalStrut(20);
		panelRicercaLatticini.add(horizontalStrut_4_3);
		
		JLabel lblOrdinaLatticiniPer = new JLabel("Ordina per");
		lblOrdinaLatticiniPer.setForeground(new Color(255, 255, 255));
		panelRicercaLatticini.add(lblOrdinaLatticiniPer);
		
		JComboBox comboBoxOrdinaLatticiniPer = new JComboBox();
		comboBoxOrdinaLatticiniPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaLatticiniOrdinaCodiceProdottoAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Descrizione") == 0){
					controll.visualizzaTabellaLatticiniOrdinaDescrizioneAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0){
					controll.visualizzaTabellaLatticiniOrdinaProduttoreFronitoreAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Provenienza") == 0){
					controll.visualizzaTabellaLatticiniOrdinaProvenienzaAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Data mungitura") == 0){
					controll.visualizzaTabellaLatticiniOrdinaDataMungituraAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Data produzione") == 0){
					controll.visualizzaTabellaLatticiniOrdinaDataProduzioneAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Senza lattosio") == 0){
					controll.visualizzaTabellaLatticiniOrdinaSenzaLattosioAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Quantita") == 0){
					controll.visualizzaTabellaLatticiniOrdinaQuantitaAsc(tableLatticini);
				}else if(comboBoxOrdinaLatticiniPer.getSelectedItem().toString().compareTo("Prezzo") == 0){
					controll.visualizzaTabellaLatticiniOrdinaPrezzoAsc(tableLatticini);
				}
			}
		});
		comboBoxOrdinaLatticiniPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data mungitura", "Data produzione", "Senza lattosio", "Quantita", "Prezzo"}));
		panelRicercaLatticini.add(comboBoxOrdinaLatticiniPer);
		
		JPanel panelRicercaUova = new JPanel();
		panelRicercaUova.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaUova, "name_1148219325429300");
		
		JLabel lblCercaUovaPer = new JLabel("Cerca per");
		lblCercaUovaPer.setForeground(new Color(255, 255, 255));
		panelRicercaUova.add(lblCercaUovaPer);
		
		JComboBox comboBoxCercaUovaPer = new JComboBox();
		comboBoxCercaUovaPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data confezionamento", "Categoria uova", "Classe peso"}));
		panelRicercaUova.add(comboBoxCercaUovaPer);
		
		textFieldCercaUovaPer = new JTextField();
		textFieldCercaUovaPer.setColumns(10);
		panelRicercaUova.add(textFieldCercaUovaPer);
		
		JButton btnCercaUovaPer = new JButton("Cerca");
		btnCercaUovaPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaUovaCercaCodiceProdotto(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaUovaCercaDescrizione(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaUovaCercaProduttoreFornitore(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaUovaCercaProvenienza(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Data confezionamento") == 0) {
					controll.visualizzaTabellaUovaCercaDataConfezionamento(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Categoria uova") == 0) {
					controll.visualizzaTabellaUovaCercaCategoriaUova(tableUova, textFieldCercaUovaPer.getText());
				}else if(comboBoxCercaUovaPer.getSelectedItem().toString().compareTo("Classe peso") == 0) {
					controll.visualizzaTabellaUovaCercaClassePeso(tableUova, textFieldCercaUovaPer.getText());
				}
			}
		});
		panelRicercaUova.add(btnCercaUovaPer);
		
		Component horizontalStrut_4_4 = Box.createHorizontalStrut(20);
		panelRicercaUova.add(horizontalStrut_4_4);
		
		JLabel lblOrdinaUovaPer = new JLabel("Ordina per");
		lblOrdinaUovaPer.setForeground(new Color(255, 255, 255));
		panelRicercaUova.add(lblOrdinaUovaPer);
		
		JComboBox comboBoxOrdinaUovaPer = new JComboBox();
		comboBoxOrdinaUovaPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaUovaOrdinaCodiceProdottoAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaUovaOrdinaDescrizioneAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaUovaOrdinaProduttoreFornitoreAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaUovaOrdinaProvenienzaAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Data confezionamento") == 0) {
					controll.visualizzaTabellaUovaOrdinaDataConfezionamentoAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Categoria uova") == 0) {
					controll.visualizzaTabellaUovaOrdinaCategoriaUovaAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Classe peso") == 0) {
					controll.visualizzaTabellaUovaOrdinaClassePesoAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Quantita") == 0) {
					controll.visualizzaTabellaUovaOrdinaQuantitaAsc(tableUova);
				}else if(comboBoxOrdinaUovaPer.getSelectedItem().toString().compareTo("Prezzo") == 0) {
					controll.visualizzaTabellaUovaOrdinaPrezzoAsc(tableUova);
				}
			}
		});
		comboBoxOrdinaUovaPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data confezionamento", "Categoria uova", "Classe peso", "Quantita", "Prezzo"}));
		panelRicercaUova.add(comboBoxOrdinaUovaPer);
		
		JPanel panelRicercaConfezionati = new JPanel();
		panelRicercaConfezionati.setBackground(new Color(153, 153, 153));
		layeredPaneRicerche.add(panelRicercaConfezionati, "name_1148429510864500");
		
		JLabel lblCercaConfezionatiPer = new JLabel("Cerca per");
		lblCercaConfezionatiPer.setForeground(new Color(255, 255, 255));
		panelRicercaConfezionati.add(lblCercaConfezionatiPer);
		
		JComboBox comboBoxCercaConfezionatiPer = new JComboBox();
		comboBoxCercaConfezionatiPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data confezion", "Data scadenza"}));
		panelRicercaConfezionati.add(comboBoxCercaConfezionatiPer);
		
		textFieldCercaConfezionatiPer = new JTextField();
		textFieldCercaConfezionatiPer.setColumns(10);
		panelRicercaConfezionati.add(textFieldCercaConfezionatiPer);
		
		JButton btnCercaConfezionatiPer = new JButton("Cerca");
		btnCercaConfezionatiPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaConfezionatiCercaCodiceProdotto(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}else if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaConfezionatiCercaDescrizione(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}else if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaConfezionatiCercaProduttoreFornitore(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}else if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaConfezionatiCercaProvenienza(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}else if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Data confezion") == 0) {
					controll.visualizzaTabellaConfezionatiCercaDataConfezionamento(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}else if(comboBoxCercaConfezionatiPer.getSelectedItem().toString().compareTo("Data scadenza") == 0) {
					controll.visualizzaTabellaConfezionatiCercaDescrizione(tableConfezionati, textFieldCercaConfezionatiPer.getText());
				}
			}
		});
		panelRicercaConfezionati.add(btnCercaConfezionatiPer);
		
		JLabel lblOrdinaConfezionatiPer = new JLabel("Ordina per");
		lblOrdinaConfezionatiPer.setForeground(new Color(255, 255, 255));
		panelRicercaConfezionati.add(lblOrdinaConfezionatiPer);
		
		JComboBox comboBoxOrdinaConfezionatiPer = new JComboBox();
		comboBoxOrdinaConfezionatiPer.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Codice prodotto") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaCodiceProdottoAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Descrizione") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaDescrizioneAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Produttore/Fornitore") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Provenienza") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaProvenienzaAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Data confezionamento") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaDataConfezionametoAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Data scadenza") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaDataScadenzaAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Qunatita") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaQuantitaAsc(tableConfezionati);
				}else if (comboBoxOrdinaConfezionatiPer.getSelectedItem().toString().compareTo("Prezzo") == 0) {
					controll.visualizzaTabellaConfezionatiOrdinaPrezzoAsc(tableConfezionati);
				}
			}
		});
		comboBoxOrdinaConfezionatiPer.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione",
				"Produttore/Fornitore", "Provenienza", "Data confezionamento", "Data scadenza", "Qunatita", "Prezzo"}));
		panelRicercaConfezionati.add(comboBoxOrdinaConfezionatiPer);
		
		JPanel panelButtonsTipi = new JPanel();
		layeredPaneGruttpoProdotti.add(panelButtonsTipi, BorderLayout.CENTER);
		panelButtonsTipi.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtonsTipis = new JPanel();
		panelButtonsTipis.setBackground(new Color(153, 153, 153));
		panelButtonsTipi.add(panelButtonsTipis, BorderLayout.NORTH);
		
		JButton btnFrutta = new JButton("Frutta");
		btnFrutta.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnFrutta);
		
		JButton btnVerdura = new JButton("Verdura");
		btnVerdura.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnVerdura);
		
		JButton btnFarinacei = new JButton("Farinacei");
		btnFarinacei.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnFarinacei);
		
		JButton btnLatticini = new JButton("Latticini");
		btnLatticini.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnLatticini);
		
		JButton btnUova = new JButton("Uova");
		btnUova.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnUova);
		
		JButton btnConfezionati = new JButton("Confezionati");
		btnConfezionati.setBackground(new Color(204, 204, 204));
		panelButtonsTipis.add(btnConfezionati);
		
		JLayeredPane layeredPaneTabelle = new JLayeredPane();
		panelButtonsTipi.add(layeredPaneTabelle, BorderLayout.CENTER);
		layeredPaneTabelle.setLayout(new CardLayout(0, 0));
		
		JPanel panelTabellaFrutta = new JPanel();
		panelTabellaFrutta.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaFrutta, "name_1146501900051500");
		panelTabellaFrutta.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBottomButton = new JPanel();
		panelBottomButton.setBackground(new Color(153, 153, 153));
		panelTabellaFrutta.add(panelBottomButton, BorderLayout.SOUTH);
		
		JLabel lblInserisciQuantitaFrutta = new JLabel("Inserire la quanita desiderata");
		lblInserisciQuantitaFrutta.setForeground(new Color(255, 255, 255));
		lblInserisciQuantitaFrutta.setBackground(new Color(255, 255, 255));
		panelBottomButton.add(lblInserisciQuantitaFrutta);
		
		textFieldQuantitaFrutta = new JTextField();
		panelBottomButton.add(textFieldQuantitaFrutta);
		textFieldQuantitaFrutta.setColumns(10);
		
		JButton btnAggiungiAlCarelloFrutta = new JButton("Aggiungi al Carrello");
		btnAggiungiAlCarelloFrutta.setBackground(new Color(204, 204, 204));
		btnAggiungiAlCarelloFrutta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloFrutta(tableFrutta, Double.parseDouble(textFieldQuantitaFrutta.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaFrutta.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
			}
		});
		panelBottomButton.add(btnAggiungiAlCarelloFrutta);
		
		JScrollPane scrollPaneFrutta = new JScrollPane();
		panelTabellaFrutta.add(scrollPaneFrutta, BorderLayout.CENTER);
		
		tableFrutta = new JTable();
		tableFrutta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenineza", "Data raccolata", "Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneFrutta.setViewportView(tableFrutta);
		
		JPanel panelTabellaVerdura = new JPanel();
		panelTabellaVerdura.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaVerdura, "name_1148821146773600");
		panelTabellaVerdura.setLayout(new BorderLayout(0, 0));
		
		JPanel panelInserisciVerduraCarrello = new JPanel();
		panelInserisciVerduraCarrello.setBackground(new Color(153, 153, 153));
		panelTabellaVerdura.add(panelInserisciVerduraCarrello, BorderLayout.SOUTH);
		
		JLabel lblQuantitaVerdura = new JLabel("Inserisci la quantita desiderata");
		lblQuantitaVerdura.setForeground(new Color(255, 255, 255));
		panelInserisciVerduraCarrello.add(lblQuantitaVerdura);
		
		textFieldQuantitaVerdura = new JTextField();
		panelInserisciVerduraCarrello.add(textFieldQuantitaVerdura);
		textFieldQuantitaVerdura.setColumns(10);
		
		JButton btnAggiungiAlCarrelloVerdura = new JButton("Aggiungi al carrello");
		btnAggiungiAlCarrelloVerdura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloVerdura(tableVerdura, Double.parseDouble(textFieldQuantitaVerdura.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaVerdura.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
			}
		});
		panelInserisciVerduraCarrello.add(btnAggiungiAlCarrelloVerdura);
		
		JScrollPane scrollPaneVerdura = new JScrollPane();
		panelTabellaVerdura.add(scrollPaneVerdura, BorderLayout.CENTER);
		
		tableVerdura = new JTable();
		tableVerdura.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data raccolta", "Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneVerdura.setViewportView(tableVerdura);
		
		JPanel panelTabellaFarinacei = new JPanel();
		panelTabellaFarinacei.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaFarinacei, "name_1148940772328000");
		panelTabellaFarinacei.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAggiungiFarinaceiCarrello = new JPanel();
		panelAggiungiFarinaceiCarrello.setBackground(new Color(153, 153, 153));
		panelTabellaFarinacei.add(panelAggiungiFarinaceiCarrello, BorderLayout.SOUTH);
		
		JLabel lblInserisciQuantitaFarinacei = new JLabel("Inserisci la quantita desiderata");
		lblInserisciQuantitaFarinacei.setForeground(new Color(255, 255, 255));
		panelAggiungiFarinaceiCarrello.add(lblInserisciQuantitaFarinacei);
		
		textFieldQuantitaFarinacei = new JTextField();
		panelAggiungiFarinaceiCarrello.add(textFieldQuantitaFarinacei);
		textFieldQuantitaFarinacei.setColumns(10);
		
		JButton btnAggiungiFarinaceiCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiFarinaceiCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloFarinacei(tableFarinacei, Double.parseDouble(textFieldQuantitaFarinacei.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaFarinacei.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
			}
		});
		panelAggiungiFarinaceiCarrello.add(btnAggiungiFarinaceiCarrello);
		
		JScrollPane scrollPaneFarinacei = new JScrollPane();
		panelTabellaFarinacei.add(scrollPaneFarinacei, BorderLayout.CENTER);
		
		tableFarinacei = new JTable();
		tableFarinacei.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data scadenza", "Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneFarinacei.setViewportView(tableFarinacei);
		
		JPanel panelTabellaLatticini = new JPanel();
		panelTabellaLatticini.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaLatticini, "name_1148959902004100");
		panelTabellaLatticini.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAggiungiLatticiniCarrello = new JPanel();
		panelAggiungiLatticiniCarrello.setBackground(new Color(153, 153, 153));
		panelTabellaLatticini.add(panelAggiungiLatticiniCarrello, BorderLayout.SOUTH);
		
		JLabel lblQunaitaLatticini = new JLabel("Inserire la quantita desiderata");
		lblQunaitaLatticini.setForeground(new Color(255, 255, 255));
		panelAggiungiLatticiniCarrello.add(lblQunaitaLatticini);
		
		textFieldQuantitaLatticini = new JTextField();
		panelAggiungiLatticiniCarrello.add(textFieldQuantitaLatticini);
		textFieldQuantitaLatticini.setColumns(10);
		
		JButton btnAggiungiLatticiniCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiLatticiniCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloLatticini(tableLatticini, Double.parseDouble(textFieldQuantitaLatticini.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaLatticini.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
			}
		});
		panelAggiungiLatticiniCarrello.add(btnAggiungiLatticiniCarrello);
		
		JScrollPane scrollPaneLatticini = new JScrollPane();
		panelTabellaLatticini.add(scrollPaneLatticini, BorderLayout.CENTER);
		
		tableLatticini = new JTable();
		tableLatticini.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data mungitura", "Data produzione",
					"Senza lattosio", "Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneLatticini.setViewportView(tableLatticini);
		
		JPanel panelTabellaUova = new JPanel();
		panelTabellaUova.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaUova, "name_1148976633726200");
		panelTabellaUova.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAggiungiUovaCarrello = new JPanel();
		panelAggiungiUovaCarrello.setBackground(new Color(153, 153, 153));
		panelTabellaUova.add(panelAggiungiUovaCarrello, BorderLayout.SOUTH);
		
		JLabel lblQuanitaUova = new JLabel("Inserire la quanita desiderata");
		lblQuanitaUova.setForeground(new Color(255, 255, 255));
		panelAggiungiUovaCarrello.add(lblQuanitaUova);
		
		textFieldQuantitaUova = new JTextField();
		panelAggiungiUovaCarrello.add(textFieldQuantitaUova);
		textFieldQuantitaUova.setColumns(10);
		
		JButton btnAggiungiUovaCarrello = new JButton("Aggiungi al carrello");
		btnAggiungiUovaCarrello.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloUova(tableUova, Double.parseDouble(textFieldQuantitaUova.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaUova.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
			}
		});
		panelAggiungiUovaCarrello.add(btnAggiungiUovaCarrello);
		
		JScrollPane scrollPaneUova = new JScrollPane();
		panelTabellaUova.add(scrollPaneUova, BorderLayout.CENTER);
		
		tableUova = new JTable();
		tableUova.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data confezionamento", "Categoria peso",
					"Classe peso", "Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneUova.setViewportView(tableUova);
		
		JPanel panelTabellaConfezionati = new JPanel();
		panelTabellaConfezionati.setBackground(new Color(153, 153, 153));
		layeredPaneTabelle.add(panelTabellaConfezionati, "name_1149013889330500");
		panelTabellaConfezionati.setLayout(new BorderLayout(0, 0));
		
		JPanel panelConfezionatiAggiungiCarrello = new JPanel();
		panelConfezionatiAggiungiCarrello.setBackground(new Color(153, 153, 153));
		panelTabellaConfezionati.add(panelConfezionatiAggiungiCarrello, BorderLayout.SOUTH);
		
		JLabel lblQuantitaConfezionati = new JLabel("Inserire la qunatita desiderata");
		lblQuantitaConfezionati.setForeground(new Color(255, 255, 255));
		panelConfezionatiAggiungiCarrello.add(lblQuantitaConfezionati);
		
		textFieldQuantitaConfezionati = new JTextField();
		panelConfezionatiAggiungiCarrello.add(textFieldQuantitaConfezionati);
		textFieldQuantitaConfezionati.setColumns(10);
		
		JButton btnNewButton = new JButton("Aggiungi al carrello");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.aggiungiAlCarelloConfezionati(tableConfezionati, Double.parseDouble(textFieldQuantitaConfezionati.getText()), tableCarrello, carrelloArrayList);
				textFieldQuantitaConfezionati.setText("");
				controll.calcolaSubTotale(carrelloArrayList, lblTotaleNumero);
				
			}
		});
		panelConfezionatiAggiungiCarrello.add(btnNewButton);
		
		JScrollPane scrollPaneConfezionati = new JScrollPane();
		panelTabellaConfezionati.add(scrollPaneConfezionati, BorderLayout.CENTER);
		
		tableConfezionati = new JTable();
		tableConfezionati.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codice prodotto", "Descrizione", "Produttore/Fornitore", "Provenienza", "Data confezionamento", "Data scadenza",
					"Quantita", "Unita", "Prezzo", "Iva"
			}
		));
		scrollPaneConfezionati.setViewportView(tableConfezionati);
		
		btnFrutta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaFrutta);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaFrutta);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaFrutta(tableFrutta);
			}
		});
		
		btnVerdura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaVerdura);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaVerdura);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaVerdura(tableVerdura);
			}
		});
		
		btnFarinacei.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaFarinacei);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaFarinacei);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaFarinacei(tableFarinacei);
			}
		});
		
		btnLatticini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaLatticini);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaLatticini);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaLatticini(tableLatticini);
			}
		});
		
		btnUova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaUova);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaUova);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaUova(tableUova);
			}
		});
		
		btnConfezionati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPaneRicerche.removeAll();
				layeredPaneRicerche.add(panelRicercaConfezionati);
				layeredPaneRicerche.repaint();
				layeredPaneRicerche.revalidate();
				layeredPaneTabelle.removeAll();
				layeredPaneTabelle.add(panelTabellaConfezionati);
				layeredPaneTabelle.repaint();
				layeredPaneTabelle.revalidate();
				controll.visualizzaTabellaConfezionati(tableConfezionati);
			}
		});
		
		JPanel clientiPanel = new JPanel();
		clientiPanel.setBackground(new Color(153, 153, 153));
		layeredPane.add(clientiPanel, "name_97848382304700");
		clientiPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel cercaPanel = new JPanel();
		cercaPanel.setBackground(new Color(153, 153, 153));
		clientiPanel.add(cercaPanel, BorderLayout.NORTH);
		
		JLabel labelCercaPersona = new JLabel("Cerca Per ");
		cercaPanel.add(labelCercaPersona);
		
		JComboBox comboBoxCercaPersona =  new JComboBox();
		comboBoxCercaPersona.setBackground(new Color(204, 204, 204));
		comboBoxCercaPersona.setModel(new DefaultComboBoxModel(new String[] {"Nome", "Cognome", "Email", "Codice cliente", "Codice tessera"}));
		cercaPanel.add(comboBoxCercaPersona);
		
		Component horizontalStrut_9 = Box.createHorizontalStrut(20);
		cercaPanel.add(horizontalStrut_9);
		
		textFieldCerca = new JTextField();
		textFieldCerca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					controll.verificaCerca(comboBoxCercaPersona, tableCliente, textFieldCerca);
			}
		});
		cercaPanel.add(textFieldCerca);
		textFieldCerca.setColumns(10);
		
		JButton buttonCercaPersona = new JButton("Cerca");
		buttonCercaPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.verificaCerca(comboBoxCercaPersona, tableCliente, textFieldCerca);
			}
		});
		buttonCercaPersona.setBackground(new Color(204, 204, 204));
		buttonCercaPersona.setFocusPainted(false);
		buttonCercaPersona.setBorderPainted(false);
		cercaPanel.add(buttonCercaPersona);
		
		JPanel panel_3 = new JPanel();
		clientiPanel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtonCerca = new JPanel();
		panelButtonCerca.setBackground(new Color(153, 153, 153));
		panel_3.add(panelButtonCerca, BorderLayout.NORTH);
		
		JButton buttonAggiungiCliente = new JButton("Aggiungi Cliente");
		buttonAggiungiCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.addClienti_GUI();
			}
		});
		buttonAggiungiCliente.setBackground(new Color(204, 204, 204));
		panelButtonCerca.add(buttonAggiungiCliente);
		buttonAggiungiCliente.setFocusPainted(false);
		buttonAggiungiCliente.setBorderPainted(false);
		
		JButton buttonModifica = new JButton("Modifica Cliente");
		buttonModifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controll.modifica_GUI(controll.prelevaSelezionato(tableCliente));
				} catch (Exception e1) {
					controll.error_GUI();
				}
			}
		});
		buttonModifica.setBackground(new Color(204, 204, 204));
		panelButtonCerca.add(buttonModifica);
		buttonModifica.setFocusPainted(false);
		buttonModifica.setBorderPainted(false);
		
		JButton buttonElimina = new JButton("Elimina Cliente");
		buttonElimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.rimuoviClienteTabella(controll.prelevaSelezionato(tableCliente).getCodiceCliente());
				controll.mostraClienti(tableCliente);
			}
		});
		buttonElimina.setBackground(new Color(204, 204, 204));
		panelButtonCerca.add(buttonElimina);
		buttonElimina.setFocusPainted(false);
		buttonElimina.setBorderPainted(false);
		
		Component horizontalStrut_10 = Box.createHorizontalStrut(180);
		panelButtonCerca.add(horizontalStrut_10);
		
		JLabel labelOrdinaCliente = new JLabel("Ordina per ");
		panelButtonCerca.add(labelOrdinaCliente);
		
		JComboBox comboBoxOrdinaCliente = new JComboBox();
		comboBoxOrdinaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.ordina(comboBoxOrdinaCliente, tableCliente);
			}
		});
		comboBoxOrdinaCliente.setBackground(new Color(204, 204, 204));
		comboBoxOrdinaCliente.setModel(new DefaultComboBoxModel(new String[] {"Nessun ordinamento", "Nome", "Cognome", 
				"Email", "Codice cliente", "Codice tessera"}));
		panelButtonCerca.add(comboBoxOrdinaCliente);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_3.add(scrollPane_3, BorderLayout.CENTER);
		
		tableCliente = new JTable();
		tableCliente.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				controll.mostraClienti(tableCliente);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tableCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Codice clienti", "Nome", "Cognome", "Email", "Codice Tessera"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCliente.getColumnModel().getColumn(0).setResizable(false);
		tableCliente.getColumnModel().getColumn(1).setResizable(false);
		tableCliente.getColumnModel().getColumn(3).setResizable(false);
		tableCliente.getColumnModel().getColumn(4).setResizable(false);
		tableCliente.getColumnModel().getColumn(4).setPreferredWidth(112);
		scrollPane_3.setViewportView(tableCliente);
		
		JPanel cartePanel = new JPanel();
		layeredPane.add(cartePanel, "name_28299282453000");
		cartePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopCarta = new JPanel();
		panelTopCarta.setBackground(new Color(153, 153, 153));
		cartePanel.add(panelTopCarta, BorderLayout.NORTH);
		
		JLabel buttonCercaInCarta = new JLabel("Cerca Per ");
		panelTopCarta.add(buttonCercaInCarta);
		
		JComboBox comboBoxCarta = new JComboBox();
		comboBoxCarta.setBackground(new Color(204, 204, 204));
		comboBoxCarta.setModel(new DefaultComboBoxModel(new String[] {"Codice tessera", "Nome intestatario",
				"Codice cliente"}));
		panelTopCarta.add(comboBoxCarta);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelTopCarta.add(horizontalStrut);
		
		textFieldCarta = new JTextField();
		textFieldCarta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					controll.verificaCercaTessera(comboBoxCarta,tableTesseraPunti, textFieldCarta );
			}
		});
		panelTopCarta.add(textFieldCarta);
		textFieldCarta.setColumns(10);
		
		JButton buttonCercaCarta = new JButton("Cerca");
		buttonCercaCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.verificaCercaTessera(comboBoxCarta,tableTesseraPunti, textFieldCarta );
			}
		});
		buttonCercaCarta.setBackground(new Color(204, 204, 204));
		panelTopCarta.add(buttonCercaCarta);
		
		JPanel panel = new JPanel();
		cartePanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 153, 153));
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel labelOrdina = new JLabel("Ordina per ");
		panel_1.add(labelOrdina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.ordinaTessrea(comboBox, tableTesseraPunti);
			}
		});
		comboBox.setBackground(new Color(204, 204, 204));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nome intestatario A-Z", 
				"Codice tessera", "Codice cliente"}));
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 153, 153));
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		tableTesseraPunti = new JTable();
		tableTesseraPunti.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				controll.mostraTessera(tableTesseraPunti);
			}
			public void ancestorMoved(AncestorEvent event) {
			}
			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		tableTesseraPunti.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Codice Tessera", "Codice Cliente", "Nome Intestatario", "Punti Frutta",
				"Punti Verdura", "Punti Confezionati",
				"Punti Farinacei", "Punti Latticini", "Punti Uova", "Saldo punti"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableTesseraPunti.getColumnModel().getColumn(0).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(0).setPreferredWidth(112);
		tableTesseraPunti.getColumnModel().getColumn(1).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(1).setPreferredWidth(109);
		tableTesseraPunti.getColumnModel().getColumn(2).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(2).setPreferredWidth(99);
		tableTesseraPunti.getColumnModel().getColumn(3).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(4).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(5).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(5).setPreferredWidth(101);
		tableTesseraPunti.getColumnModel().getColumn(6).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(6).setPreferredWidth(81);
		tableTesseraPunti.getColumnModel().getColumn(7).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(8).setResizable(false);
		tableTesseraPunti.getColumnModel().getColumn(9).setResizable(false);
		scrollPane.setViewportView(tableTesseraPunti);
		
		JPanel registroPanel = new JPanel();
		layeredPane.add(registroPanel, "name_28367495489300");
		registroPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(153, 153, 153));
		registroPanel.add(panel_5, BorderLayout.NORTH);
		
		JLabel labelOrdinaRegistro = new JLabel("Ordina per");
		panel_5.add(labelOrdinaRegistro);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBackground(new Color(204, 204, 204));
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Numero ordine", "Totale ordine ", "Data registrazione ",  
				"Soldi ricevuti ",  "Codice carta ",  "Tipo pagamento ", "Codice cliente "}));
		panel_5.add(comboBox_4);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_5.add(horizontalStrut_3);
		
		textField_2 = new JTextField();
		panel_5.add(textField_2);
		textField_2.setColumns(13);
		
		JButton buttonCercaRegistro = new JButton("Cerca");
		buttonCercaRegistro.setBackground(new Color(204, 204, 204));
		buttonCercaRegistro.setFocusPainted(false);
		buttonCercaRegistro.setFocusPainted(false);
		panel_5.add(buttonCercaRegistro);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(153, 153, 153));
		registroPanel.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_6.add(scrollPane_2, BorderLayout.CENTER);
		
		tableRegistro = new JTable();
		tableRegistro.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},

			},
			new String[] {
				"Numero Ordini", "Data registrazioni", "Totale ordine", "Lista Prodotti",
				"Soldi Ricevuti", "Codice Carta", 
				"Banca Ricevente", "Tipo Pagamento", "Codice Cliente"
			}
		));
		scrollPane_2.setViewportView(tableRegistro);
		
		JPanel Magazzinopanel = new JPanel();
		layeredPane.add(Magazzinopanel, "name_177644219078600");
		Magazzinopanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTopMagazzino = new JPanel();
		panelTopMagazzino.setBackground(new Color(153, 153, 153));
		Magazzinopanel.add(panelTopMagazzino, BorderLayout.NORTH);
		
		JLabel labelCercaMagazzino = new JLabel("Cerca Per");
		panelTopMagazzino.add(labelCercaMagazzino);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBackground(new Color(204, 204, 204));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione",
				"Provenienza", "Produttore/Fornitore"}));
		panelTopMagazzino.add(comboBox_2);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panelTopMagazzino.add(horizontalStrut_1);
		
		textField = new JTextField();
		panelTopMagazzino.add(textField);
		textField.setColumns(13);
		
		JButton buttonCercaInMagazino = new JButton("Cerca");
		buttonCercaInMagazino.setBackground(new Color(204, 204, 204));
		panelTopMagazzino.add(buttonCercaInMagazino);
		
		JPanel panelCenterMagazzino = new JPanel();
		panelCenterMagazzino.setBackground(new Color(153, 153, 153));
		Magazzinopanel.add(panelCenterMagazzino, BorderLayout.CENTER);
		panelCenterMagazzino.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(153, 153, 153));
		panelCenterMagazzino.add(panel_4, BorderLayout.NORTH);
		
		JButton buttonAggiungiProdotto = new JButton("Aggiungi Prodotto");
		buttonAggiungiProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.addProdotto_GUI();
			}
		});
		buttonAggiungiProdotto.setBackground(new Color(204, 204, 204));
		buttonAggiungiProdotto.setBorderPainted(false);
		buttonAggiungiProdotto.setFocusPainted(false);
		panel_4.add(buttonAggiungiProdotto);
		
		JButton buttonModificaProdotto = new JButton("Modifica Prodotto");
		buttonModificaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controll.modificaProdotto_GUI(controll.prelevaProdottoSelezionato(tableMagazzino));
				} catch (Exception e1) {
					controll.error_GUI();
				}
			}
		});
		buttonModificaProdotto.setBackground(new Color(204, 204, 204));
		buttonModificaProdotto.setBorderPainted(false);
		buttonModificaProdotto.setFocusPainted(false);
		panel_4.add(buttonModificaProdotto);
		
		JButton buttonEliminaProdotto = new JButton("Elimina Prodotto");
		buttonEliminaProdotto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controll.rimuoviProdottoTabella(controll.prelevaProdottoSelezionato(tableMagazzino).getCodiceProdotto());
				controll.leggiProdotto(tableMagazzino);
			}
		});
		buttonEliminaProdotto.setBackground(new Color(204, 204, 204));
		buttonEliminaProdotto.setBorderPainted(false);
		buttonEliminaProdotto.setFocusPainted(false);
		panel_4.add(buttonEliminaProdotto);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(35);
		panel_4.add(horizontalStrut_2);
		
		JLabel labelOrdinaMagazzino = new JLabel("Ordina Per ");
		panel_4.add(labelOrdinaMagazzino);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBackground(new Color(204, 204, 204));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Codice prodotto", "Descrizione ", "Prezzo  ",
				"Provenienza ", "Produttore"}));
		panel_4.add(comboBox_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panelCenterMagazzino.add(scrollPane_1, BorderLayout.CENTER);
		
		tableMagazzino = new JTable();
		tableMagazzino.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Codice Prodotto", "Descrizione", "Pezzo", "Provenienza", "Produttore", "Quantit\u00E0", "Unit\u00E0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableMagazzino.getColumnModel().getColumn(0).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(0).setPreferredWidth(87);
		tableMagazzino.getColumnModel().getColumn(1).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(2).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(3).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(4).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(4).setPreferredWidth(82);
		tableMagazzino.getColumnModel().getColumn(5).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(5).setPreferredWidth(85);
		tableMagazzino.getColumnModel().getColumn(6).setResizable(false);
		tableMagazzino.getColumnModel().getColumn(6).setPreferredWidth(92);
		scrollPane_1.setViewportView(tableMagazzino);
		
		JButton ButtonProdotti = new JButton("Prodotti");
		ButtonProdotti.setBackground(new Color(204, 204, 204));
		ButtonProdotti.setFocusPainted(false);
		ButtonProdotti.setBorderPainted(false);
		ButtonProdotti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(prodottiPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
			} 
		});
		
		JButton ButtonClienti = new JButton("Clienti");
		ButtonClienti.setBackground(new Color(204, 204, 204));
		ButtonClienti.setFocusPainted(false);
		ButtonClienti.setBorderPainted(false);
		ButtonClienti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(clientiPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
			}
		});
		
		JButton ButtonCarta = new JButton("Carta fedelt\u00E0");
		ButtonCarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(cartePanel);
                layeredPane.repaint();
                layeredPane.revalidate();
                controll.mostraTessera(tableTesseraPunti);
			}
		});
		ButtonCarta.setBackground(new Color(204, 204, 204));
		ButtonCarta.setFocusPainted(false);
		ButtonCarta.setBorderPainted(false);
		
		JButton ButtonMagazzino = new JButton("Magazzino\r\n");
		ButtonMagazzino.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(Magazzinopanel);
                layeredPane.repaint();
                layeredPane.revalidate();
                controll.leggiProdotto(tableMagazzino);
			}
		});
		ButtonMagazzino.setBackground(new Color(204, 204, 204));
		ButtonMagazzino.setFocusPainted(false);
		ButtonMagazzino.setBorderPainted(false);
		
		JButton buttonRegistro = new JButton("Registro Transazioni\r\n");
		buttonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
                layeredPane.add(registroPanel);
                layeredPane.repaint();
                layeredPane.revalidate();
			}
		});
		buttonRegistro.setBackground(new Color(204, 204, 204));
		buttonRegistro.setBorderPainted(false);
		buttonRegistro.setFocusPainted(false);
		
		GroupLayout gl_LeftPanel = new GroupLayout(LeftPanel);
		gl_LeftPanel.setHorizontalGroup(
			gl_LeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeftPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_LeftPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(ButtonProdotti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ButtonClienti, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ButtonCarta, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ButtonMagazzino, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonRegistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_LeftPanel.setVerticalGroup(
			gl_LeftPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_LeftPanel.createSequentialGroup()
					.addGap(92)
					.addComponent(ButtonProdotti, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(43)
					.addComponent(ButtonClienti, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(52)
					.addComponent(ButtonCarta, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(56)
					.addComponent(ButtonMagazzino, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(48)
					.addComponent(buttonRegistro, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(230))
		);
		LeftPanel.setLayout(gl_LeftPanel);
		
		
	}
}


