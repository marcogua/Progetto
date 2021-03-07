package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Cliente;
import Classi.GenerateId;
import Classi.Prodotto;
import Interfaccie.ControlloreInterfaccia;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;

public class ModificaProdottoGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ControlloreInterfaccia controll;
	private JTextField textFieldCodiceprodotto;
	private JTextField textFieldDescrizione;
	private JTextField textFieldProvenienza;
	private JTextField textFieldProduttore;
	private JTextField textFieldPrezzo;
	private JTextField textFieldQuantita;
	private JTextField textFieldIva;
	private JComboBox comboBoxUnita;

	/**
	 * Create the dialog.
	 */
	public ModificaProdottoGUI(ControlloreInterfaccia ctrl) {
		setResizable(false);
		controll = ctrl;
		setBounds(100, 55, 865, 660);
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
				JLabel jlabelModificaProdotto = new JLabel("Modifica Prodotto\r\n");
				jlabelModificaProdotto.setFont(new Font("Tahoma", Font.BOLD, 16));
				jlabelModificaProdotto.setForeground(new Color(255, 255, 255));
				panelTop.add(jlabelModificaProdotto);
			}
		}

		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(153, 153, 153));
		contentPanel.add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));

		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(new Color(153, 153, 153));
		panelCenter.add(panelLeft, BorderLayout.WEST);

		JLabel JlabelTipoProdotto = new JLabel("Tipo Prodotto");


		JPanel panelCenterLayered = new JPanel();
		panelCenter.add(panelCenterLayered, BorderLayout.CENTER);
		panelCenterLayered.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPaneAggiungiProdotto = new JLayeredPane();
		panelCenterLayered.add(layeredPaneAggiungiProdotto, "name_353151854570800");
		layeredPaneAggiungiProdotto.setLayout(new CardLayout(0, 0));

		JPanel panelFrutta = new JPanel();
		panelFrutta.setBackground(new Color(153, 153, 153));
		layeredPaneAggiungiProdotto.add(panelFrutta, "name_353415779550600");

		JPanel panelUova = new JPanel();
		panelUova.setBackground(new Color(153, 153, 153));
		layeredPaneAggiungiProdotto.add(panelUova, "name_355365650453600");
		panelUova.setLayout(null);

		JPanel panelLatticini = new JPanel();
		panelLatticini.setBackground(new Color(153, 153, 153));

		JPanel panelFarinacei = new JPanel();
		panelFarinacei.setBackground(new Color(153, 153, 153));

		JPanel panelConfezionati = new JPanel();
		panelConfezionati.setBackground(new Color(153, 153, 153));

		JLabel jlabelClasseUova = new JLabel("Classe Uova\r\n");
		jlabelClasseUova.setBounds(124, 72, 93, 14);
		panelUova.add(jlabelClasseUova);

		JComboBox comboBoxClasseUova = new JComboBox();
		comboBoxClasseUova.setModel(new DefaultComboBoxModel(new String[] {"Seleziona classe", "XL", "L", "M", "S"}));
		comboBoxClasseUova.setBounds(227, 68, 214, 22);
		panelUova.add(comboBoxClasseUova);

		JLabel jlabelCategoria = new JLabel("Categoria");
		jlabelCategoria.setBounds(124, 153, 68, 14);
		panelUova.add(jlabelCategoria);

		JComboBox comboBoxCategoriaU = new JComboBox();
		comboBoxCategoriaU.setModel(new DefaultComboBoxModel(new String[] {"Seleziona categoria", "A", "B", "C"}));
		comboBoxCategoriaU.setBounds(227, 153, 214, 22);
		panelUova.add(comboBoxCategoriaU);

		JLabel jlabelDataraccolta = new JLabel("Data Raccolta\r\n");
		jlabelDataraccolta.setBounds(124, 241, 80, 14);
		panelUova.add(jlabelDataraccolta);

		JComboBox comboBoxGiornoU = new JComboBox();
		comboBoxGiornoU.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoU.setBounds(227, 237, 53, 22);
		panelUova.add(comboBoxGiornoU);

		JComboBox comboBoxMeseU = new JComboBox();
		comboBoxMeseU.setModel(new DefaultComboBoxModel(new String[] {"MM", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxMeseU.setBounds(305, 237, 53, 22);
		panelUova.add(comboBoxMeseU);

		JComboBox comboBoxAnnoU = new JComboBox();
		comboBoxAnnoU.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoU.setBounds(379, 237, 62, 22);
		panelUova.add(comboBoxAnnoU);

		JPanel panelVerdura = new JPanel();
		panelVerdura.setBackground(new Color(153, 153, 153));
		layeredPaneAggiungiProdotto.add(panelVerdura, "name_353424508556700");

		JComboBox comboBoxTipo = new JComboBox();
		comboBoxTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sceltaCombo = (String)comboBoxTipo.getSelectedItem();

				if(sceltaCombo.equalsIgnoreCase("Frutta")) {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelFrutta);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}
				else if(sceltaCombo.equalsIgnoreCase("Verdura")) {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelVerdura);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}
				else if(sceltaCombo.equalsIgnoreCase("Uova")) {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelUova);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}
				else if(sceltaCombo.equalsIgnoreCase("Farinacei")) {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelFarinacei);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}
				else if(sceltaCombo.equalsIgnoreCase("Latticini")) {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelLatticini);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}
				else {
					layeredPaneAggiungiProdotto.removeAll();
					layeredPaneAggiungiProdotto.add(panelConfezionati);
					layeredPaneAggiungiProdotto.repaint();
					layeredPaneAggiungiProdotto.revalidate();
				}

			}
		});
		comboBoxTipo.setBackground(new Color(204, 204, 204));
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Seleziona Prodotto", "Frutta", "Verdura", "Uova", "Latticini", "Farinacei", "Confezionati"}));

		textFieldCodiceprodotto = new JTextField();
		textFieldCodiceprodotto.setEditable(false);
		textFieldCodiceprodotto.setColumns(10);

		JLabel JlabelCodiceProdotto = new JLabel("Codice Prodotto");

		JLabel jlabelDescrizione = new JLabel("Descrizione");

		textFieldDescrizione = new JTextField();
		textFieldDescrizione.setColumns(10);

		JLabel jlabelProvenienza = new JLabel("Provenienza");

		textFieldProvenienza = new JTextField();
		textFieldProvenienza.setColumns(10);

		JLabel jlabelProduttore = new JLabel("Produttore");

		textFieldProduttore = new JTextField();
		textFieldProduttore.setColumns(10);

		JLabel jlabelPrezzo = new JLabel("Prezzo");

		textFieldPrezzo = new JTextField();
		textFieldPrezzo.setColumns(10);

		JLabel jlabelQuantita = new JLabel("Quantit\u00E0");

		textFieldQuantita = new JTextField();
		textFieldQuantita.setColumns(10);

		JLabel jlabelUnita = new JLabel("Unit\u00E0");

		comboBoxUnita = new JComboBox();
		comboBoxUnita.setBackground(new Color(204, 204, 204));
		comboBoxUnita.setModel(new DefaultComboBoxModel(new String[] {"KG", "PZ", "L"}));

		JButton buttonGenera = new JButton("Genera Codice\r\n");
		buttonGenera.setBackground(new Color(240, 240, 240));
		buttonGenera.setFocusPainted(false);
		buttonGenera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sc = (String)comboBoxTipo.getSelectedItem();
				if(sc.equalsIgnoreCase("Frutta")){
					textFieldCodiceprodotto.setText(GenerateId.generatoreFrutta());
				}
				else if(sc.equalsIgnoreCase("Verdura")){
					textFieldCodiceprodotto.setText(GenerateId.generatoreVerdura());
				}
				else if(sc.equalsIgnoreCase("Uova")){
					textFieldCodiceprodotto.setText(GenerateId.generatoreUova());
				}
				else if(sc.equalsIgnoreCase("Latticini")){
					textFieldCodiceprodotto.setText(GenerateId.generatoreLatticini());
				}
				else if(sc.equalsIgnoreCase("Farinacei")){
					textFieldCodiceprodotto.setText(GenerateId.generatoreFarinacei());
				}
				else{
					textFieldCodiceprodotto.setText(GenerateId.generatoreConfezionati());
				}

			}
		});
		
		JLabel jlabelIva = new JLabel("Iva");
		
		textFieldIva = new JTextField();
		textFieldIva.setColumns(10);

		GroupLayout gl_panelLeft = new GroupLayout(panelLeft);
		gl_panelLeft.setHorizontalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addComponent(jlabelUnita)
					.addPreferredGap(ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
					.addComponent(comboBoxUnita, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(JlabelTipoProdotto)
						.addComponent(jlabelDescrizione)
						.addComponent(jlabelProvenienza)
						.addComponent(jlabelProduttore)
						.addComponent(jlabelPrezzo)
						.addComponent(jlabelQuantita)
						.addComponent(JlabelCodiceProdotto, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(jlabelIva))
					.addGap(33)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(textFieldCodiceprodotto, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(comboBoxTipo, Alignment.TRAILING, 0, 194, Short.MAX_VALUE)
						.addComponent(textFieldDescrizione, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(textFieldProvenienza, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(textFieldProduttore, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(textFieldPrezzo, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(textFieldQuantita, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
						.addComponent(textFieldIva, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(117)
					.addComponent(buttonGenera)
					.addContainerGap(121, Short.MAX_VALUE))
		);
		gl_panelLeft.setVerticalGroup(
			gl_panelLeft.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLeft.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(JlabelTipoProdotto)
						.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldCodiceprodotto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(JlabelCodiceProdotto))
					.addGap(29)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(jlabelDescrizione)
						.addComponent(textFieldDescrizione, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(jlabelProvenienza)
						.addComponent(textFieldProvenienza, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(jlabelProduttore)
						.addComponent(textFieldProduttore, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(jlabelPrezzo)
						.addComponent(textFieldPrezzo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.LEADING)
						.addComponent(jlabelQuantita)
						.addComponent(textFieldQuantita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlabelIva)
						.addComponent(textFieldIva))
					.addGap(46)
					.addGroup(gl_panelLeft.createParallelGroup(Alignment.BASELINE)
						.addComponent(jlabelUnita)
						.addComponent(comboBoxUnita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(buttonGenera)
					.addGap(24))
		);
		panelLeft.setLayout(gl_panelLeft);


		JLabel jlabelDataRaccoltaFrutta = new JLabel("Data Raccolta");

		JComboBox comboBoxGiorno = new JComboBox();
		comboBoxGiorno.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiorno.setBackground(new Color(204, 204, 204));

		JComboBox comboBoxMese = new JComboBox();
		comboBoxMese.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMese.setBackground(new Color(204, 204, 204));

		JComboBox comboBoxAnno = new JComboBox();
		comboBoxAnno.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnno.setBackground(new Color(204, 204, 204));
		GroupLayout gl_panelFrutta = new GroupLayout(panelFrutta);
		gl_panelFrutta.setHorizontalGroup(
				gl_panelFrutta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFrutta.createSequentialGroup()
								.addGap(125)
								.addComponent(jlabelDataRaccoltaFrutta)
								.addGap(27)
								.addComponent(comboBoxGiorno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBoxMese, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBoxAnno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_panelFrutta.setVerticalGroup(
				gl_panelFrutta.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelFrutta.createSequentialGroup()
								.addGap(155)
								.addGroup(gl_panelFrutta.createParallelGroup(Alignment.BASELINE)
										.addComponent(jlabelDataRaccoltaFrutta)
										.addComponent(comboBoxGiorno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxMese, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxAnno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(383, Short.MAX_VALUE))
		);
		panelFrutta.setLayout(gl_panelFrutta);


		JComboBox comboBoxAnnoV = new JComboBox();
		comboBoxAnnoV.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoV.setBackground(new Color(204, 204, 204));

		JComboBox comboBoxMeseV = new JComboBox();
		comboBoxMeseV.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseV.setBackground(new Color(204, 204, 204));

		JComboBox comboBoxGiornoV = new JComboBox();
		comboBoxGiornoV.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoV.setBackground(new Color(204, 204, 204));

		JLabel jlabelDataRaccoltaFrutta_1 = new JLabel("Data Raccolta");
		GroupLayout gl_panelVerdura = new GroupLayout(panelVerdura);
		gl_panelVerdura.setHorizontalGroup(
				gl_panelVerdura.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVerdura.createSequentialGroup()
								.addGap(107)
								.addComponent(jlabelDataRaccoltaFrutta_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBoxGiornoV, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBoxMeseV, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(comboBoxAnnoV, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(111, Short.MAX_VALUE))
		);
		gl_panelVerdura.setVerticalGroup(
				gl_panelVerdura.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelVerdura.createSequentialGroup()
								.addGroup(gl_panelVerdura.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelVerdura.createSequentialGroup()
												.addGap(151)
												.addGroup(gl_panelVerdura.createParallelGroup(Alignment.LEADING)
														.addComponent(comboBoxGiornoV, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
														.addGroup(gl_panelVerdura.createParallelGroup(Alignment.BASELINE)
																.addComponent(comboBoxMeseV, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
																.addComponent(comboBoxAnnoV, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
										.addGroup(gl_panelVerdura.createSequentialGroup()
												.addGap(154)
												.addComponent(jlabelDataRaccoltaFrutta_1)))
								.addContainerGap(387, Short.MAX_VALUE))
		);
		panelVerdura.setLayout(gl_panelVerdura);


		layeredPaneAggiungiProdotto.add(panelLatticini, "name_362468641471800");
		panelLatticini.setLayout(null);

		JLabel jlabelDataMungitura = new JLabel("Data Mungitura");
		jlabelDataMungitura.setBounds(128, 108, 85, 14);
		panelLatticini.add(jlabelDataMungitura);

		JComboBox comboBoxGiornoL = new JComboBox();
		comboBoxGiornoL.setBackground(new Color(204, 204, 204));
		comboBoxGiornoL.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoL.setBounds(241, 104, 49, 22);
		panelLatticini.add(comboBoxGiornoL);

		JComboBox comboBoxMeseL = new JComboBox();
		comboBoxMeseL.setBackground(new Color(204, 204, 204));
		comboBoxMeseL.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseL.setBounds(311, 104, 49, 22);
		panelLatticini.add(comboBoxMeseL);

		JComboBox comboBoxAnnoL = new JComboBox();
		comboBoxAnnoL.setBackground(new Color(204, 204, 204));
		comboBoxAnnoL.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoL.setBounds(384, 104, 59, 22);
		panelLatticini.add(comboBoxAnnoL);

		JLabel jlabelDataProduzione = new JLabel("Data Produzione");
		jlabelDataProduzione.setBounds(128, 189, 85, 14);
		panelLatticini.add(jlabelDataProduzione);

		JLabel jlabeLattosio = new JLabel("Senza Lattosio");
		jlabeLattosio.setBounds(128, 262, 85, 14);
		panelLatticini.add(jlabeLattosio);

		JComboBox comboBoxSenzaLattosio = new JComboBox();

		comboBoxSenzaLattosio.setBackground(new Color(204, 204, 204));
		comboBoxSenzaLattosio.setModel(new DefaultComboBoxModel(new String[] {"Seleziona", "True", "False"}));
		comboBoxSenzaLattosio.setBounds(250, 258, 91, 22);
		panelLatticini.add(comboBoxSenzaLattosio);

		JComboBox comboBoxGiornoL_1 = new JComboBox();
		comboBoxGiornoL_1.setBackground(new Color(204, 204, 204));
		comboBoxGiornoL_1.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoL_1.setBounds(241, 189, 49, 22);
		panelLatticini.add(comboBoxGiornoL_1);

		JComboBox comboBoxMeseL_1 = new JComboBox();
		comboBoxMeseL_1.setBackground(new Color(204, 204, 204));
		comboBoxMeseL_1.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseL_1.setBounds(311, 189, 49, 22);
		panelLatticini.add(comboBoxMeseL_1);

		JComboBox comboBoxAnnoL_1 = new JComboBox();
		comboBoxAnnoL_1.setBackground(new Color(204, 204, 204));
		comboBoxAnnoL_1.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoL_1.setBounds(384, 189, 59, 22);
		panelLatticini.add(comboBoxAnnoL_1);


		layeredPaneAggiungiProdotto.add(panelFarinacei, "name_364574683479700");
		panelFarinacei.setLayout(null);

		JComboBox comboBoxMeseF = new JComboBox();
		comboBoxMeseF.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseF.setBackground(new Color(204, 204, 204));
		comboBoxMeseF.setBounds(285, 155, 64, 20);
		panelFarinacei.add(comboBoxMeseF);

		JComboBox comboBoxAnnoF = new JComboBox();
		comboBoxAnnoF.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoF.setBackground(new Color(204, 204, 204));
		comboBoxAnnoF.setBounds(359, 155, 71, 20);
		panelFarinacei.add(comboBoxAnnoF);

		JComboBox comboBoxGiornoF = new JComboBox();
		comboBoxGiornoF.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoF.setBackground(new Color(204, 204, 204));
		comboBoxGiornoF.setBounds(227, 155, 48, 20);
		panelFarinacei.add(comboBoxGiornoF);

		JLabel jlabelDataScadenzaL = new JLabel("Data Scadenza\r\n");
		jlabelDataScadenzaL.setBounds(120, 158, 97, 14);
		panelFarinacei.add(jlabelDataScadenzaL);


		layeredPaneAggiungiProdotto.add(panelConfezionati, "name_408674951769400");
		panelConfezionati.setLayout(null);

		JLabel jlabelDataConfezionamento = new JLabel("Data Confezionamento");
		jlabelDataConfezionamento.setBounds(95, 154, 134, 14);
		panelConfezionati.add(jlabelDataConfezionamento);

		JComboBox comboBoxGiornoConf = new JComboBox();
		comboBoxGiornoConf.setBackground(new Color(204, 204, 204));
		comboBoxGiornoConf.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoConf.setBounds(252, 150, 47, 22);
		panelConfezionati.add(comboBoxGiornoConf);

		JComboBox comboBoxMeseConf = new JComboBox();
		comboBoxMeseConf.setBackground(new Color(204, 204, 204));
		comboBoxMeseConf.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseConf.setBounds(325, 150, 58, 22);
		panelConfezionati.add(comboBoxMeseConf);

		JComboBox comboBoxAnnoConf = new JComboBox();
		comboBoxAnnoConf.setBackground(new Color(204, 204, 204));
		comboBoxAnnoConf.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoConf.setBounds(403, 150, 66, 22);
		panelConfezionati.add(comboBoxAnnoConf);

		JLabel jlabelDataScadenzaC = new JLabel("Data Scadenza");
		jlabelDataScadenzaC.setBounds(95, 227, 118, 14);
		panelConfezionati.add(jlabelDataScadenzaC);

		JComboBox comboBoxGiornoC = new JComboBox();
		comboBoxGiornoC.setBackground(new Color(204, 204, 204));
		comboBoxGiornoC.setModel(new DefaultComboBoxModel(new String[] {"GG", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxGiornoC.setBounds(252, 223, 47, 22);
		panelConfezionati.add(comboBoxGiornoC);

		JComboBox comboBoxMeseC = new JComboBox();
		comboBoxMeseC.setBackground(new Color(204, 204, 204));
		comboBoxMeseC.setModel(new DefaultComboBoxModel(new String[] {"MM", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBoxMeseC.setBounds(325, 223, 58, 22);
		panelConfezionati.add(comboBoxMeseC);

		JComboBox comboBoxAnnoC = new JComboBox();
		comboBoxAnnoC.setBackground(new Color(204, 204, 204));
		comboBoxAnnoC.setModel(new DefaultComboBoxModel(new String[] {"AAAA", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028"}));
		comboBoxAnnoC.setBounds(403, 223, 66, 22);
		panelConfezionati.add(comboBoxAnnoC);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(153, 153, 153));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton ButtonOk = new JButton("Aggiungi");
			ButtonOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controll.rimuoviProdottodalMagazzino(textFieldCodiceprodotto.getText());
					String scelta = (String)comboBoxTipo.getSelectedItem();
					if(scelta.equalsIgnoreCase("Frutta")) {
						controll.salvaProdottoFrutta(textFieldCodiceprodotto, textFieldDescrizione, textFieldPrezzo, textFieldProvenienza,
								textFieldProduttore, textFieldQuantita,textFieldIva, comboBoxUnita, comboBoxGiorno, comboBoxMese, comboBoxAnno);
					}
					else if(scelta.equalsIgnoreCase("Verdura")) {
						controll.salvaProdottoVerdura(textFieldCodiceprodotto, textFieldDescrizione, textFieldPrezzo, textFieldProvenienza,
								textFieldProduttore, textFieldQuantita,textFieldIva, comboBoxUnita, comboBoxGiornoV, comboBoxMeseV, comboBoxAnnoV);
					}
					else if(scelta.equalsIgnoreCase("Uova")) {
						controll.salvaProdottoUova(textFieldCodiceprodotto, textFieldDescrizione, textFieldPrezzo, textFieldProvenienza,
								textFieldProduttore, textFieldQuantita,textFieldIva, comboBoxUnita, comboBoxGiornoU, comboBoxMeseU,
								comboBoxAnnoU,comboBoxCategoriaU,comboBoxClasseUova);
					}
					else if(scelta.equalsIgnoreCase("Latticini")) {
						controll.salvaProdottoLatticini(textFieldCodiceprodotto,textFieldDescrizione,textFieldPrezzo,
								textFieldProvenienza,textFieldProduttore,textFieldQuantita,textFieldIva,comboBoxUnita,comboBoxGiornoL,
								comboBoxMeseL,comboBoxAnnoL,comboBoxGiornoL_1,comboBoxMeseL_1,comboBoxAnnoL_1,comboBoxSenzaLattosio);
					}
					else if(scelta.equalsIgnoreCase("Farinacei")) {
						controll.salvaProdottoFarinacei(textFieldCodiceprodotto,textFieldDescrizione,textFieldPrezzo,
								textFieldProvenienza,textFieldProduttore,textFieldQuantita,textFieldIva,comboBoxUnita,comboBoxGiornoF,
								comboBoxMeseF,comboBoxAnnoF);
					}
					else {
						controll.salvaProdottoConfezionati(textFieldCodiceprodotto,textFieldDescrizione,textFieldPrezzo,
								textFieldProvenienza,textFieldProduttore,textFieldQuantita,textFieldIva,comboBoxUnita,comboBoxGiornoConf,
								comboBoxMeseConf,comboBoxAnnoConf,comboBoxGiornoC, comboBoxMeseC,comboBoxAnnoC);
					}
					dispose();
				}
			});
			ButtonOk.setBackground(new Color(204, 204, 204));
			buttonPane.add(ButtonOk);
			{
				JButton cancelButton = new JButton("ANNULLA");
				cancelButton.setBackground(new Color(204, 204, 204));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void riceviProdotto(Prodotto prodotto) {
		controll.LeggiProdotto(prodotto,textFieldCodiceprodotto,textFieldDescrizione,textFieldPrezzo,textFieldProvenienza,
				textFieldProduttore,textFieldQuantita,comboBoxUnita,textFieldIva);

	}
}