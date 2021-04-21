package Controllore;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import Classi.*;
import Classi.ListaProdotti;
import DAO.ClienteDao;
import DAO.OrdineDao;
import DAO.ProdottoDao;
import DAO.TesseraPuntiDAO;
import DAOImpl.*;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import DbConfig.DbConnect;
import GUI.*;
import Interfaccie.ControlloreInterfaccia;


public class Controllore implements ControlloreInterfaccia  {
	Home_GUI homeGUI;
	PagamentoGUI paga;
	AggiungiProdottoGUI addProdotto;
	AggiungiClienteGUI addClient;
	ErroreGUI errore;
	ErroreModifica erroreModifica;
	ModificaGUI modifica;
	ModificaProdottoGUI modificaProdotto;
	ListaProdottiGUI lista;
	
	public static void main(String[] args) {
		ControlloreInterfaccia ilcontrollo = new Controllore();
		Home_GUI frame = new Home_GUI(ilcontrollo);
		frame.setVisible(true);
	}
	
	public Controllore() {
		homeGUI = new Home_GUI(this);
		paga = new PagamentoGUI(this);
		addProdotto = new AggiungiProdottoGUI(this);
		addClient = new AggiungiClienteGUI(this);
		errore = new ErroreGUI(this);
		erroreModifica = new ErroreModifica(this);
		modifica = new ModificaGUI(this,null);
		modificaProdotto = new ModificaProdottoGUI(this);
		lista = new ListaProdottiGUI(this);
	}
	
	@Override
	public void homeGUI() {
		homeGUI.setVisible(true);
	}
	
	
	@Override
	public void pagameto_GUI(){
		paga.setVisible(true);
	}
	
	
	@Override
	public void addProdotto_GUI() {
		addProdotto.setVisible(true);
	}
	
	@Override
	public void addClienti_GUI() {
		addClient.setVisible(true);
		
	}
	
	@Override
	public void error_GUI() {
		errore.setVisible(true);
	}
	
	@Override
	public void errorModifica_GUI() {
		erroreModifica.setVisible(true);
	}
	
	
	@Override
	public void modifica_GUI(Cliente client) {
			modifica.riceviCliente(client);
			modifica.setVisible(true);
	}
	
	@Override
	public void Pagamento_GUI(Pagamento pagamento, ArrayList<Prodotto> prodotto) {
		paga.riceviTortale(pagamento, prodotto);
		paga.setVisible(true);
	
	}

	@Override
	public void modificaProdotto_GUI(Prodotto prodotto) {
		modificaProdotto.riceviProdotto(prodotto);
		modificaProdotto.setVisible(true);
	}
	
	@Override
	public void ListaProdotti_GUI(String idLista) {
		lista.rceviIdLista(idLista);
		lista.setVisible(true);
	}
	
	public void ListaProdotti_GUI1() {
		lista.setVisible(true);
	}
	
	@Override
	public Connection collegamento() {
		DbConnect dbconn = null;
		Connection conn = null;
		try {
			dbconn = DbConnect.getIstanza();
			conn = dbconn.getConnection();
			
		} catch (SQLException e) {
			System.out.println("Errore Collegamento "
					+ e.getMessage());
		}
		
		return conn;
	}
	
	
	
	public void mostraClienti(JTable tabella) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addCliente(tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti : "
					+ e.getMessage());
		}
		
	}
	

	
	public void mostraClientiNome(JTable tabella, JTextField nome) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addCliente(tabella,nome );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per nome: "
					+ e.getMessage());
		}
		
	}
	
	@Override
	public void mostraClientiCognome(JTable tabella, JTextField nome) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addClienteCognome(tabella,nome );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per cognome: "
					+ e.getMessage());
		}
		
	}
	
	@Override
	public void mostraClientiEmail(JTable tabella, JTextField email) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addClienteEmail(tabella,email );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per email: "
					+ e.getMessage());
		}
		
	}
	

	@Override
	public void mostraClientiTessera(JTable tabella, JTextField email) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addClienteTessera(tabella,email );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per codice tessera: "
					+ e.getMessage());
		}
		
	}
	

	@Override
	public void mostraClientiCodClienti(JTable tabella, JTextField cliente) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.addClientiCodClienti(tabella,cliente );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per codice cliente: "
					+ e.getMessage());
		}
		
	}
	

	@Override
	public void verificaCerca(JComboBox selezione,JTable tabella, JTextField nome ) {
		String valore = (String)selezione.getSelectedItem();

			if (valore.equalsIgnoreCase("nome")) {
				this.mostraClientiNome(tabella, nome);
			} else if (valore.equalsIgnoreCase("cognome")) {
				this.mostraClientiCognome(tabella, nome);
			} else if (valore.equalsIgnoreCase("email")) {
				this.mostraClientiEmail(tabella, nome);
			} else if (valore.equalsIgnoreCase("Codice cliente")) {
				this.mostraClientiCodClienti(tabella, nome);
			} else if (valore.equalsIgnoreCase("Codice tessera")) {
				this.mostraClientiTessera(tabella, nome);
			}
	}

	@Override
	public void salvaCliente(JTextField codicecliente, JTextField nome, JTextField cognome,JTextField email,JTextField codicetessera) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.aggiungiCliente(codicecliente, nome, cognome, email, codicetessera );
			
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.creaTessera(codicecliente, codicetessera, nome);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il cliente e tessera: "
					+ e.getMessage());
			this.errorModifica_GUI();
		}
		
		codicecliente.setText("");
		nome.setText("");
		cognome.setText("");
		email.setText("");
		codicetessera.setText("");
		
	}
	
	@Override
	public Cliente prelevaSelezionato(JTable tabella) {
		Cliente client = new Cliente();
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		
		client.setCodiceCliente(model.getValueAt(tabella.getSelectedRow(), 0).toString());
		client.setNome(model.getValueAt(tabella.getSelectedRow(), 1).toString());
		client.setCognome(model.getValueAt(tabella.getSelectedRow(), 2).toString());
		client.setEmail(model.getValueAt(tabella.getSelectedRow(), 3).toString());
		client.setCodiceTessera(model.getValueAt(tabella.getSelectedRow(), 4).toString());
		
		return client;
	}
	
	@Override
	public void Leggi(Cliente client, JTextField codiceCliente, JTextField nome, JTextField cognome, JTextField email, JTextField codicetessera) {
		Cliente cliente = client;
		
		nome.setText(cliente.getNome());
		cognome.setText(cliente.getCognome());
		email.setText(cliente.getEmail());
		codiceCliente.setText(cliente.getCodiceCliente());
		codicetessera.setText(cliente.getCodiceTessera());
	}

	
	@Override
	public void rimuoviClienteTabella(String  cliente) {
		Connection conn = this.collegamento();
		try {
			ClienteDao clienteD = new ClienteDaoImp(conn);
			clienteD.delateCliente(cliente);
			
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.delateTessera(cliente);
			
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nel rimuovere  "
					+ " il cliente: "
					+ e.getMessage());
		}
	}
	
	
	@Override
	public void mostraTessera(JTable tabella) {
		Connection conn = this.collegamento();
		try {
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.mostraTessera(tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per nome: "
					+ e.getMessage());
		}
	}
	
	@Override
	public void VisualizzaTesseraPuntiPerNome(JTable tabella, JTextField nome) {
		Connection conn = this.collegamento();
		try {
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.mostraTesseraPreNome(tabella,nome.getText());
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per nome: " + e.getMessage());
		}
		
	}
	
	@Override
	public void VisualizzaTesseraPuntiPerCliente(JTable tabella, JTextField nome) {
		Connection conn = this.collegamento();
		try {
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.mostraTesseraPreClienti(tabella,(String)nome.getText());
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per nome: "
					+ e.getMessage());
		}
		
	}
	
	@Override
	public void VisualizzaTesseraPuntiPerTessrra(JTable tabella, JTextField nome) {
		Connection conn = this.collegamento();
		try {
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.mostraTesseraPreTessera(tabella,nome.getText());
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i clienti per nome: "
					+ e.getMessage());
		}
	}
	
	
	@Override
	public void verificaCercaTessera(JComboBox selezione,JTable tabella, JTextField nome ) {
		String valore = (String)selezione.getSelectedItem();
		
		if(valore.equalsIgnoreCase("Nome intestatario")) {
			this.VisualizzaTesseraPuntiPerNome( tabella, nome);
		}
		else if(valore.equalsIgnoreCase("Codice cliente")) {
			this.VisualizzaTesseraPuntiPerCliente( tabella, nome);
		}
		else if(valore.equalsIgnoreCase("Codice tessera")) {
			this.VisualizzaTesseraPuntiPerTessrra( tabella, nome);
		}
		
	}
	
	@Override
	public void ordina(JComboBox nome, JTable tabella) {
		Connection conn = this.collegamento();
		try {
			ClienteDaoImp client = new ClienteDaoImp(conn);
			client.fornisciQuery(nome, tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'ordinare "
					+ " i clienti : " + e.getMessage());
		}
	}
	
	@Override
	public void ordinaTessrea(JComboBox nome, JTable tabella) {
		Connection conn = this.collegamento();
		try {
			
			TesseraPuntiDAO tessera = new TesseraPuntiDaoImp(conn);
			tessera.fornisciQuery(nome, tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'ordinare "
					+ " i clienti : " + e.getMessage());
		}
	}
	
	@Override
	public void leggiProdotto(JTable tabella) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magazzino = new MagazinoDaoImp(conn);
			magazzino.leggiMagazzino(tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'ordinare "
					+ " i clienti : " + e.getMessage());
		}
	}

	@Override
	public void salvaProdottoFrutta( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
								   JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
								   JComboBox giorno, JComboBox mese, JComboBox anno) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodotto = new MagazinoDaoImp(conn);
			prodotto.aggiungiProdotto(codiceprodotto, descrizione,prezzo, provenienza, produttore,quantita ,iva, unita );

			FruttaDaoImp fruttaDao = new FruttaDaoImp();

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());

			fruttaDao.addFrutta(codiceprodotto.getText(), data);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

	@Override
	public void salvaProdottoVerdura( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
									 JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
									 JComboBox giorno, JComboBox mese, JComboBox anno) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodotto = new MagazinoDaoImp(conn);
			prodotto.aggiungiProdotto(codiceprodotto, descrizione,prezzo, provenienza, produttore,quantita ,iva, unita );

			VerdureDaoImp verduraDao = new VerdureDaoImp();

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());

			verduraDao.addVerdura(codiceprodotto.getText(), data);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

	@Override
	public void salvaProdottoUova( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
							   JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
								   JComboBox giorno, JComboBox mese, JComboBox anno,JComboBox categoriaUova, JComboBox classe) {
		Connection conn = this.collegamento();
		try {

			UovaDaoImp uovaDao = new UovaDaoImp();
			MagazinoDaoImp mag = new MagazinoDaoImp(conn);

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());
			
			mag.aggiungiProdotto(codiceprodotto,descrizione,prezzo,provenienza,produttore,quantita,iva,unita);
			uovaDao.addUova(codiceprodotto.getText(),data,(String)categoriaUova.getSelectedItem(),(String)classe.getSelectedItem() );

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

	@Override
	public void salvaProdottoLatticini( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
									  JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
									  JComboBox giorno, JComboBox mese, JComboBox anno,JComboBox giornoM,
										JComboBox meseM, JComboBox annoM,JComboBox senzaLattosio) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodotto = new MagazinoDaoImp(conn);
			prodotto.aggiungiProdotto(codiceprodotto, descrizione,prezzo, provenienza, produttore,quantita ,iva, unita );

			LatticiniDaoImp latticiniDao = new LatticiniDaoImp();

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());
			String dataM = ((String)giornoM.getSelectedItem())+"-"+((String)meseM.getSelectedItem()) +
					"-"+((String)annoM.getSelectedItem());
			Boolean senza = Boolean.valueOf((String)senzaLattosio.getSelectedItem());

			latticiniDao.addLatticini(codiceprodotto.getText(), data,dataM,senza);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

	@Override
	public void salvaProdottoFarinacei( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
										JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
										JComboBox giorno, JComboBox mese, JComboBox anno) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodotto = new MagazinoDaoImp(conn);
			prodotto.aggiungiProdotto(codiceprodotto, descrizione,prezzo, provenienza, produttore,quantita ,iva, unita );

			FarinaceiDaoImp farinaceiDao = new FarinaceiDaoImp();

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());

			farinaceiDao.addFarinacei(codiceprodotto.getText(), data);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

	@Override
	public void salvaProdottoConfezionati( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
										JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
										JComboBox giorno, JComboBox mese, JComboBox anno, JComboBox giornoC,
										   JComboBox meseC, JComboBox annoC) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodotto = new MagazinoDaoImp(conn);
			prodotto.aggiungiProdotto(codiceprodotto, descrizione,prezzo, provenienza, produttore,quantita ,iva, unita );

			ConfezionatiDaoImp confezionatiDao = new ConfezionatiDaoImp();

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());
			String dataC = ((String)giornoC.getSelectedItem())+"-"+((String)meseC.getSelectedItem()) +
					"-"+((String)annoC.getSelectedItem());

			confezionatiDao.addConfezionati(codiceprodotto.getText(), data,dataC);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}
	
	@Override
	public void ripilusci(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza,JTextField produttore, JTextField quantita) {
		
		codiceprodotto.setText("");
		descrizione.setText("");
		prezzo.setText("");
		provenienza.setText("");
		produttore.setText("");
		quantita.setText("");
		
	}

	@Override
	public void LeggiProdotto(Prodotto prodotto, JTextField codiceProdotto, JTextField Descrizione, JTextField Prezzo, JTextField proveninza,
							  JTextField produttore,JTextField quantita, JComboBox unita, JTextField iva) {

		codiceProdotto.setText(prodotto.getCodiceProdotto());
		Descrizione.setText(prodotto.getDescrizione());
		Prezzo.setText(Double.toString(prodotto.getPrezzo()));
		proveninza.setText(prodotto.getProvenienza());
		produttore.setText(prodotto.getProduttoreFornitore());
		quantita.setText(Double.toString(prodotto.getQuantita()));
		unita.setSelectedItem(prodotto.getUnita());
		iva.setText(prodotto.getIva());
	}

	@Override
	public Prodotto prelevaProdottoSelezionato(JTable tabella) {
		Prodotto prodott = new Prodotto();
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		
		prodott.setCodiceProdotto(model.getValueAt(tabella.getSelectedRow(), 0).toString());
		prodott.setDescrizione(model.getValueAt(tabella.getSelectedRow(), 1).toString());
		prodott.setPrezzo(Double.parseDouble(model.getValueAt(tabella.getSelectedRow(), 2).toString()));
		prodott.setProvenienza(model.getValueAt(tabella.getSelectedRow(), 3).toString());
		prodott.setProduttoreFornitore(model.getValueAt(tabella.getSelectedRow(), 4).toString());
		prodott.setQuantita(Integer.parseInt(model.getValueAt(tabella.getSelectedRow(), 5).toString()));
		prodott.setUnita(model.getValueAt(tabella.getSelectedRow(), 6).toString());
		
		return prodott;
	}

	
	@Override
	public void rimuoviProdottoTabella(String  prodotto) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magazzino = new MagazinoDaoImp(conn);
			magazzino.delateProdotto(prodotto);
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nel rimuovere  "
					+ " il prodotto: "
					+ e.getMessage());
		}
	}
	
	@Override
	public void visualizzaTabellaFrutta(JTable tabellaFrutta){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getAllFrutta();
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerdura(JTable tabellaVerdura){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdura();
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUova(JTable tabellaUova){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getAllUova();
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaFarinacei(JTable tabellaFarinacei){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getAllFarinacei();
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionati(JTable tabellaConfezionati){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getAllConfezionati();
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaLatticini(JTable tabellaLatticini){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getAllLatticini();
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaFruttaCercaCodiceProdotto(JTable tabellaFrutta, String codiceProdotto){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByCodiceProdotto(codiceProdotto);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerduraCercaCodiceProdotto(JTable tabellaVerdura, String codiceProdotto){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByCodiceProdotto(codiceProdotto);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaCodiceProdotto(JTable tabellaUova, String codiceProdotto){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByCodiceProdotto(codiceProdotto);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaFarinaceiCercaCodiceProdotto(JTable tabellaFarinacei, String codiceProdotto){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByCodiceProdotto(codiceProdotto);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaCodiceProdotto(JTable tabellaConfezionati, String codiceProdotto){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByCodiceProdotto(codiceProdotto);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaCodiceProdotto(JTable tabellaLatticini, String codiceProdotto){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByCodiceProdotto(codiceProdotto);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaFruttaCercaDescrizione(JTable tabellaFrutta, String descrizione){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByDescrizione(descrizione);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerduraCercaDescrizione(JTable tabellaVerdura, String descrizione){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByDescrizione(descrizione);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaDescrizione(JTable tabellaUova, String descrizione){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByDescrizione(descrizione);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaFarinaceiCercaDescrizione(JTable tabellaFarinacei, String descrizione){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByDescrizione(descrizione);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaDescrizione(JTable tabellaConfezionati, String descrizione){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDescrizione(descrizione);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaDescrizione(JTable tabellaLatticini, String descrizione){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDescrizione(descrizione);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaFruttaCercaProduttoreFornitore(JTable tabellaFrutta, String produttoreFornitore){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByProduttoreFornitore(produttoreFornitore);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerduraCercaProduttoreFornitore(JTable tabellaVerdura, String produttoreFornitore){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByProduttoreFornitore(produttoreFornitore);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaProduttoreFornitore(JTable tabellaUova, String produttoreFornitore){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByProduttoreFornitore(produttoreFornitore);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaFarinaceiCercaProduttoreFornitore(JTable tabellaFarinacei, String produttoreFornitore){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByProduttoreFornitore(produttoreFornitore);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaProduttoreFornitore(JTable tabellaConfezionati, String produttoreFornitore){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByProduttoreFornitore(produttoreFornitore);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaProduttoreFornitore(JTable tabellaLatticini, String produttoreFornitore){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByProduttoreFornitore(produttoreFornitore);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaFruttaCercaProvenienza(JTable tabellaFrutta, String provenienza){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByProvenienza(provenienza);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerduraCercaProvenienza(JTable tabellaVerdura, String provenienza){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByProvenienza(provenienza);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaProvenienza(JTable tabellaUova, String provenienza){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByProvenienza(provenienza);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaFarinaceiCercaProvenienza(JTable tabellaFarinacei, String provenienza){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByProvenienza(provenienza);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaProvenienza(JTable tabellaConfezionati, String provenienza){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByProvenienza(provenienza);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaProvenienza(JTable tabellaLatticini, String provenienza){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByProvenienza(provenienza);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaFruttaCercaDataRaccolta(JTable tabellaFrutta, String dataraccolata){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByDataRaccolta(dataraccolata);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	@Override
	public void visualizzaTabellaVerduraCercaDataRaccolta(JTable tabellaVerdura, String dataraccolata){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByDataRaccolta(dataraccolata);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaDataConfezionamento(JTable tabellaUova, String dataConfezionamento){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByDataConfezionamento(dataConfezionamento);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaCategoriaUova(JTable tabellaUova, String categoriaUova){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByCategoriaUova(categoriaUova);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaUovaCercaClassePeso(JTable tabellaUova, String classePeso){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByClassePeso(classePeso);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaDataMungitura(JTable tabellaLatticini, String dataMungitura){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDataMungitura(dataMungitura);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaLatticiniCercaDataProduzione(JTable tabellaLatticini, String dataProduzione){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDataProduzione(dataProduzione);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaDataConfezionamento(JTable tabellaConfezionati, String dataConfezionamento){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDataConfezionamento(dataConfezionamento);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaConfezionatiCercaDataScadenza(JTable tabellaConfezionati, String dataScadenza){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDataScadenza(dataScadenza);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	@Override
	public void visualizzaTabellaFarinaceiCercaDataScadenza(JTable tabellaFarinacei, String dataScadenza){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByDataScadenza(dataScadenza);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}
	
	@Override
	public void aggiungiAlCarelloFrutta(JTable tabellaFrutta, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 5).toString()) > quantita) {
		Prodotto prodotto = new Prodotto(tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 0).toString(),
				tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 1).toString(),
				tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 2).toString(),
				tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 7).toString()),
				quantita, tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 6).toString(),
				tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow(), 8).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
	}
	
	@Override
	public void aggiungiAlCarelloVerdura(JTable tabellaVerdura, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 5).toString()) >= quantita) {
		Prodotto prodotto = new Prodotto(tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 0).toString(),
				tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 1).toString(),
				tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 2).toString(),
				tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 7).toString()),
				quantita, tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 6).toString(),
				tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow(), 8).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
	}
	
	@Override
	public void aggiungiAlCarelloFarinacei(JTable tabellaFarinacei, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 5).toString()) >= quantita) {
		Prodotto prodotto = new Prodotto(tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 0).toString(),
				tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 1).toString(),
				tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 2).toString(),
				tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 7).toString()),
				quantita, tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 6).toString(),
				tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow(), 8).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
	}
	
	@Override
	public void aggiungiAlCarelloLatticini(JTable tabellaLatticini, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 7).toString()) >= quantita) {
		Prodotto prodotto = new Prodotto(tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 0).toString(),
				tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 1).toString(),
				tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 2).toString(),
				tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 9).toString()),
				quantita, tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 8).toString(),
				tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow(), 10).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
		
	}
	
	@Override
	public void aggiungiAlCarelloUova(JTable tabellaUova, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 7).toString()) >= quantita) {
		Prodotto prodotto = new Prodotto(tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 0).toString(),
				tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 1).toString(),
				tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 2).toString(),
				tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 9).toString()),
				quantita, tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 8).toString(),
				tabellaUova.getValueAt(tabellaUova.getSelectedRow(), 10).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
	}
	
	@Override
	public void aggiungiAlCarelloConfezionati(JTable tabellaConfezionati, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti) {
		if(Double.parseDouble(tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 6).toString()) >= quantita) {
		Prodotto prodotto = new Prodotto(tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 0).toString(),
				tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 1).toString(),
				tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 2).toString(),
				tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 3).toString(),
				Double.parseDouble(tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 8).toString()),
				quantita, tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 7).toString(),
				tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow(), 9).toString());
		listaProdotti.add(prodotto);
		visualizzaTabellaCarrello(listaProdotti, carello);
		}
	}
	
	@Override
	public void svuotaCarello(JTable carello, ArrayList<Prodotto> listCarrello, JLabel subTotale) {
		listCarrello.removeAll(listCarrello);
		visualizzaTabellaCarrello(listCarrello, carello);
		subTotale.setText("Nessuno");
	}
	
	@Override
	public void rimuoviProdottoCarrello(JTable carrello, ArrayList<Prodotto> listCarrello, JLabel subTotale) {
		double totalePrima = Double.parseDouble(subTotale.getText());
		double valoreDaSottrarre = ((listCarrello.get(carrello.getSelectedRow()).getPrezzo())* (listCarrello.get(carrello.getSelectedRow()).getQuantita()));
		double nuovoTotale = totalePrima - valoreDaSottrarre;
		subTotale.setText(String.valueOf(Math.floor(nuovoTotale * 100) / 100));
		listCarrello.remove(carrello.getSelectedRow());
		visualizzaTabellaCarrello(listCarrello, carrello);
	}
	
	@Override
	public void visualizzaTabellaCarrello(ArrayList<Prodotto> carrello, JTable tableCarrello) {
		DefaultTableModel model = (DefaultTableModel)tableCarrello.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i<carrello.size();i++) {
            row[0] = carrello.get(i).getDescrizione();
            row[1] = carrello.get(i).getQuantita();
            row[2] = carrello.get(i).getIva();
            row[3] = carrello.get(i).getPrezzo();
            model.addRow(row);
        }
	}
	
	@Override
	public ArrayList<Frutta> tableToArrayListFrutta(JTable tablefrutta) {
		ArrayList<Frutta> tmp = new ArrayList<Frutta>();
		for (int i = 0; i < tablefrutta.getRowCount(); i++) {
				tmp.add(new Frutta(tablefrutta.getValueAt(i, 0).toString(), tablefrutta.getValueAt(i, 1).toString(), 
				tablefrutta.getValueAt(i, 2).toString(), tablefrutta.getValueAt(i, 3).toString(), 
				tablefrutta.getValueAt(i, 4).toString(), Double.parseDouble(tablefrutta.getValueAt(i, 5).toString()),
				tablefrutta.getValueAt(i, 6).toString(), Double.parseDouble(tablefrutta.getValueAt(i, 7).toString()), 
				tablefrutta.getValueAt(i, 8).toString()));
		}
		return tmp;
	}
	
	@Override
	public ArrayList<Verdura> tableToArrayListVerdura(JTable tableVerdura) {
		ArrayList<Verdura> tmp = new ArrayList<Verdura>();
		for (int i = 0; i < tableVerdura.getRowCount(); i++) {
				tmp.add(new Verdura(tableVerdura.getValueAt(i, 0).toString(), tableVerdura.getValueAt(i, 1).toString(), 
				tableVerdura.getValueAt(i, 2).toString(), tableVerdura.getValueAt(i, 3).toString(), 
				tableVerdura.getValueAt(i, 4).toString(), Double.parseDouble(tableVerdura.getValueAt(i, 5).toString()), 
				tableVerdura.getValueAt(i, 6).toString(), Double.parseDouble(tableVerdura.getValueAt(i, 7).toString()), 
				tableVerdura.getValueAt(i, 8).toString()));
		}
		return tmp;
	}
	
	@Override
	public ArrayList<Farinacei> tableToArrayListFarinacei(JTable tableFarinacei){
		ArrayList<Farinacei> tmp = new ArrayList<Farinacei>();
		for (int i = 0; i < tableFarinacei.getRowCount(); i++) {
				tmp.add(new Farinacei(tableFarinacei.getValueAt(i, 0).toString(), tableFarinacei.getValueAt(i, 1).toString(), 
				tableFarinacei.getValueAt(i, 2).toString(), tableFarinacei.getValueAt(i, 3).toString(), 
				tableFarinacei.getValueAt(i, 4).toString(), Double.parseDouble(tableFarinacei.getValueAt(i, 5).toString()), 
				tableFarinacei.getValueAt(i, 6).toString(), Double.parseDouble(tableFarinacei.getValueAt(i, 7).toString()), 
				tableFarinacei.getValueAt(i, 8).toString()));
			}
		return tmp;
	}
	
	@Override
	public ArrayList<Latticini> tableToArrayListLatticini(JTable tableLatticini){
		ArrayList<Latticini> tmp = new ArrayList<Latticini>();
		for (int i = 0; i < tableLatticini.getRowCount(); i++) {
				tmp.add(new Latticini(tableLatticini.getValueAt(i, 0).toString(), tableLatticini.getValueAt(i, 1).toString(),
				tableLatticini.getValueAt(i, 2).toString(), tableLatticini.getValueAt(i, 3).toString(), 
				tableLatticini.getValueAt(i, 4).toString(), tableLatticini.getValueAt(i, 5).toString(), 
				Boolean.parseBoolean(tableLatticini.getValueAt(i, 6).toString()), Double.parseDouble(tableLatticini.getValueAt(i, 7).toString()),
				tableLatticini.getValueAt(i, 8).toString(), Double.parseDouble(tableLatticini.getValueAt(i, 9).toString()), 
				tableLatticini.getValueAt(i, 10).toString()));
			}
		return tmp;
	}
	
	@Override
	public ArrayList<Uova> tableToArrayListUova(JTable tableUova){
		ArrayList<Uova> tmp = new ArrayList<Uova>();
		for (int i = 0; i < tableUova.getRowCount(); i++) {
			tmp.add(new Uova(tableUova.getValueAt(i, 0).toString(), tableUova.getValueAt(i, 1).toString(),
					tableUova.getValueAt(i, 2).toString(), tableUova.getValueAt(i, 3).toString(),
					tableUova.getValueAt(i, 4).toString(), tableUova.getValueAt(i, 5).toString(),
					tableUova.getValueAt(i, 6).toString(), Double.parseDouble(tableUova.getValueAt(i, 7).toString()),
					tableUova.getValueAt(i, 8).toString(), Double.parseDouble(tableUova.getValueAt(i, 9).toString()),
					tableUova.getValueAt(i, 10).toString()));
			}
		return tmp;
	}
	
	@Override
	public ArrayList<Confezionati> tableToArrayListConfezionati(JTable tableConfezionati){
		ArrayList<Confezionati> tmp = new ArrayList<Confezionati>();
		for (int i = 0; i < tableConfezionati.getRowCount(); i++) {
			tmp.add(new Confezionati(tableConfezionati.getValueAt(i, 0).toString(), tableConfezionati.getValueAt(i, 1).toString(),
				tableConfezionati.getValueAt(i, 2).toString(), tableConfezionati.getValueAt(i, 3).toString(),
				tableConfezionati.getValueAt(i, 4).toString(), tableConfezionati.getValueAt(i, 5).toString(),
				Double.parseDouble(tableConfezionati.getValueAt(i, 6).toString()), tableConfezionati.getValueAt(i, 7).toString(),
				Double.parseDouble(tableConfezionati.getValueAt(i, 8).toString()), tableConfezionati.getValueAt(i, 9).toString()));
			}
		return tmp;
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaCodiceProdottoAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaCodiceProdottoAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaCodiceProdottoDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaCodiceProdottoDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaDescrizioneAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDescrizioneAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaDescrizioneDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDescrizioneDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaProduttoreFornitoreAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProduttoreFornitoreAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaProduttoreFornitoreDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProduttoreForniotreDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaProvenienzaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProveninenzaAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaProvenienzaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProvenienzaDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaDataRaccoltaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDataRaccolataAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaDataRaccoltaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDataRaccolataDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaQuantitaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaQunaitaAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaQuantitaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaQunaitaDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaPrezzoAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaPrezzoAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaFruttaOrdinaPrezzoDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaPrezzoDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaCodiceProdottoAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraCodiceProdottoAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaCodiceProdottoDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraCodiceProdottoDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaDescrizioneAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDescrizioneAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaDescrizioneDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDescrizioneDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaProduttoreFornitoreAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProduttoreFornitoreAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaProduttoreFornitoreDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProduttoreFornitoreDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaProvenienzaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProvenienzaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaProvenienzaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProvenienzaDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaDataRaccoltaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDataRaccoltaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaDataRaccoltaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDataRaccolataDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaQuantitaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraQunaitaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaQuantitaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraQunaitaDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaPrezzoAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraPrezzoAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaVerduraOrdinaPrezzoDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraPrezzoDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaCodiceProdottoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCodiceProdottoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaCodiceProdottoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCodiceProdottoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaDescrizioneAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDescrizioneAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaDescrizioneDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDescrizioneDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaProduttoreFornitoreAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProduttoreFornitoreAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaProduttoreFornitoreDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProduttoreFornitoreDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaProvenienzaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProvenienzaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaProvenienzaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProvenienzaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaClassePesoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaClassePesoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaClassePesoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaClassePesoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaCategoriaUovaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCategoriaUovaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaCategoriaUovaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCategoriaUovaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaDataConfezionamentoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDataConfezionametoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaDataConfezionamentoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDataConfezionamentoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaQuantitaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaQuantitaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaQuantitaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaQuantitaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaPrezzoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaPrezzoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaUovaOrdinaPrezzoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaPrezzoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaCodiceProdottoAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininCodiceProdottoAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaCodiceProdottoDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniCodiceProdottoDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDescrizioneAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDescrizioneAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDescrizioneDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDescrizioneDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininProduttoreFornitoreAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProduttoreFornitoreDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaProvenienzaAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProvenienzaAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaProvenienzaDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProvenienzaDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDataMungituraAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDataMungituraAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDataMungituraDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDataMungituraDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDataProduzioneAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDataProduzioneAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaDataProduzioneDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDataProduzioneDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaSenzaLattosioAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininSenzaLattosioAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaSenzaLattosioDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniSenzaLattosioDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaQuantitaAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininQuanitaAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaQuantitaDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniQunaitaDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaPrezzoAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininPrezzoAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaLatticiniOrdinaPrezzoDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniPrezzoDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaCodiceProdottoAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiCodiceProdottoAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaCodiceProdottoDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiCodiceProdottoDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaDescrizioneAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDescrizioneAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaDescrizioneDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDescrizioneDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProduttoreFornitoreAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProduttoreFornitoreDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaProvenienzaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProvenienzaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaProvenienzaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProvenienzaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaDataScadenzaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDataScadenzaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaDataScadenzaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDataScadenzaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaQuantitaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiQuantitaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaQuantitaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiQuanitaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaPrezzoAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiPrezzoAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaFarinaceiOrdinaPrezzoDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiPrezzoDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaCodiceProdottoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiCodiceProdottoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaCodiceProdottoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiCodiceProdottoDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDescrizioneAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDescrizioneAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDescrizioneDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDescrizioneDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProduttoreFornitoreAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProduttoreFornitoreDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaProvenienzaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProvenienzaAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaProvenienzaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProvenienzaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDataConfezionametoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataConfezionamentoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDataConfezionametoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataConfezionamentoDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDataScadenzaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataScadenzatoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaDataScadenzaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataScadenzaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaQuantitaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiQuantitaAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaQuantitaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiQuantitaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaPrezzoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiPrezzoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	@Override
	public void visualizzaTabellaConfezionatiOrdinaPrezzoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiPrezzoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}

	/*@Override
	public void rimuoviProdottodalMagazzino(String prodotto) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp prodottoD = new MagazinoDaoImp(conn);
			prodottoD.delateProdotto(prodotto);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nel rimuovere  "
					+ " il prodotto dal magazzino: "
					+ e.getMessage());
		}
	}*/
	
	@Override
	public double calcolaSubTotale(ArrayList<Prodotto> carrello, JLabel subTotale) {
		double subTotaleTemp=0;
		for (Prodotto prodotto : carrello) {
			subTotaleTemp += ((prodotto.getPrezzo()) * (prodotto.getQuantita()));
		}
		subTotale.setText(String.valueOf(Math.floor(subTotaleTemp * 100) / 100));
		return subTotaleTemp;
	}
	

	@Override
	public ArrayList<Prodotto> aggiungiProdottoListaProdotti(Prodotto prodotto) {
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		listaProdotti.add(prodotto);
		return listaProdotti;
	}
	

	@Override
	public Ordine completaOrdine(Ordine ordine) {
		return ordine;
	}
	
	
	@Override
	public void aggiungiListaProdotti(ArrayList<Prodotto> listaProdotti, String idLista) {
		ListaProdottiDaoImp listaprodottiDaoImp = new ListaProdottiDaoImp();
		listaprodottiDaoImp.addListaProdotti(listaProdotti, idLista);
	}
	

	@Override
	public Ordine aggiungiDatiOrdine(JTextField nomeIntestatario, JTextField tesseraFedelta, JTextField codiceCarta) {
		Ordine ordine = new Ordine();
		ordine.setCodiceCliente(null);
		ordine.setCodiceTessera(tesseraFedelta.getText());
		ordine.setDataRegistrazione(LocalDate.now().toString());
		return ordine;
	}
	

	@Override
	public Contanti aggiungiPagamentoContanti(JTextField textContanti, JTextField cartaFedelta) {
		Contanti contanti = new Contanti();
		contanti.setSoldiRicevuti(Double.parseDouble(textContanti.getText()));
		return contanti;
	}
	

	@Override
	public Carta aggiungiPagamentoCarta(JTextField codiceBancaRicevente, JTextField numeroCarta, JTextField cartaFedelta) {
		Carta carta = new Carta();
		carta.setCodiceCarta(numeroCarta.getText());
		carta.setCodiceBancaRicevente(codiceBancaRicevente.getText());
		return carta;
	}
	
	@Override
	public void generaOrdineCarta(JTextPane totaleCarta, JTextField codiceCarta, JTextField codiceTessera, ArrayList<Prodotto> listaProdotti) {
		Ordine ordine = new Ordine();
		OrdineDao ordinedaoimp = new OrdineDaoImp();
		Carta carta = new Carta();
		ClienteDaoImp clientedaoimp = new ClienteDaoImp();
		String idLista = GenerateId.generatoreListaProdotti();
		carta.setCodiceCarta(codiceCarta.getText());
		ordine.setCodiceCliente(clientedaoimp.cercaCodiceCliente(codiceTessera.getText()));
		ordine.setTipoPagamento("carta");
		ordine.setIdLista(idLista);
		ordine.setCodiceCarta(carta.getCodiceCarta());
		ordine.setSoldiRicevuti(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		ordine.setDataRegistrazione(LocalDate.now().format(formatter).toString());
		System.out.println(ordine.getDataRegistrazione());
		ordine.setNumeroOrdine(GenerateId.generatoreOrdine());
		ordine.setTotaleOrdine(Double.parseDouble(totaleCarta.getText()));
		ordine.setBancaRicevente("SanPaolo");
		aggiungiListaProdotti(listaProdotti, idLista);
		ordinedaoimp.addOrdine(ordine);
	}
	
	@Override
	public void generaOrdineContanti(ArrayList<Prodotto> listaProdotti, JTextField textFieldContantiDati, JTextPane textPaneTotaleContanti, JTextField codiceTessera) {
		Ordine ordine = new Ordine();
		OrdineDao ordinedaoimp = new OrdineDaoImp();
		Contanti contanti = new Contanti();
		ClienteDaoImp clientedaoimp = new ClienteDaoImp();
		String idLista = GenerateId.generatoreListaProdotti();
		contanti.setSoldiRicevuti(Double.parseDouble(textFieldContantiDati.getText()));
		ordine.setCodiceCliente(clientedaoimp.cercaCodiceCliente(codiceTessera.getText()));
		ordine.setTipoPagamento("contanti");
		ordine.setIdLista(idLista);
		ordine.setBancaRicevente("");
		ordine.setCodiceCarta("");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		ordine.setDataRegistrazione(LocalDate.now().format(formatter).toString());
		ordine.setNumeroOrdine(GenerateId.generatoreOrdine());
		ordine.setTotaleOrdine(Double.parseDouble(textPaneTotaleContanti.getText()));
		ordine.setSoldiRicevuti(contanti.getSoldiRicevuti());
		aggiungiListaProdotti(listaProdotti, idLista);
		ordinedaoimp.addOrdine(ordine);
	}
	
	@Override
	public void visualizzaListaProdotti(JTable tableListaProdotti, String idLista){
		ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
		ListaProdottiDaoImp listaprodottidaoimp = new ListaProdottiDaoImp();
		listaProdotti = listaprodottidaoimp.getListaProdottiByIdLista(idLista, listaProdotti);
		listaprodottidaoimp.modificaTabellaListaProdotti(tableListaProdotti, listaProdotti);
	}
	
	@Override
	public void leggiVal(Pagamento pagamento,JTextPane totale, JTextPane iva, JTextPane totaleContanti, JTextPane ivaContanti) {
		totale.setText(Double.toString(pagamento.getTotale()));
		iva.setText(Double.toString(pagamento.getIva()));
		totaleContanti.setText(Double.toString(pagamento.getTotale()));
		ivaContanti.setText(Double.toString(pagamento.getIva()));	
	}
	
	@Override
	public Pagamento prelevaTotale(JLabel valore, JLabel iva) {
		Pagamento pagamento = new Pagamento();
		
		pagamento.setTotale(Double.parseDouble(valore.getText()));
		pagamento.setIva(Double.parseDouble(iva.getText()));;
		
		return pagamento;
	}

	@Override
	public void calcolaIvaSubTotale(ArrayList<Prodotto> carrello, JLabel lblsubTotaleIva)
	{
		double subTotaleIva = 0;
		for (Prodotto prodotto : carrello) {
			subTotaleIva += (((prodotto.getPrezzo() * Double.parseDouble(prodotto.getIva())) / 100) * prodotto.getQuantita());
		}
		lblsubTotaleIva.setText(String.valueOf(Math.floor(subTotaleIva * 100) / 100));
	}
	
	@Override
	public void visualizzaTabellaRegistroVendite(JTable tableRegistroVendite) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.getAllOrdini();
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	
	public void visualizzaTabellaListaProdotti(JTable tableListaProdotti, String idLista) {
		ArrayList<Prodotto> arrayListProdotti = new ArrayList<Prodotto>();
		ListaProdottiDaoImp listaprodottidaoimp = new ListaProdottiDaoImp(arrayListProdotti);
		arrayListProdotti = listaprodottidaoimp.getListaProdottiByIdLista(idLista, arrayListProdotti);
		listaprodottidaoimp.modificaTabellaListaProdotti(tableListaProdotti, arrayListProdotti);
	}
	
	public void generaPunti(JTextField codiceTessera, JTextPane textPaneTotaleContanti, ArrayList<Prodotto> listaProdotti) {
		TesseraPunti tesseraPunti = new TesseraPunti();
		TesseraPuntiDaoImp tesseraPuntiDaoImp = new TesseraPuntiDaoImp();
		tesseraPunti = tesseraPuntiDaoImp.cercaTesseraPuntiPerCodiceTessera(codiceTessera.getText());
		tesseraPunti.calcolaPunti(Double.parseDouble(textPaneTotaleContanti.getText()), listaProdotti, tesseraPunti);
		tesseraPuntiDaoImp.updateTesseraPunti(tesseraPunti);
	}
	
	public void sottraiQuantitaProdottiVenduti(ArrayList<Prodotto> listaProdotti) {
		Prodotto prodotti = new Prodotto();
		ProdottoDao prodottiDaoImp = new ProdottoDaoImp();
		for (Prodotto prodotto : listaProdotti) {
			prodotti = prodottiDaoImp.getProdottoByCodiceProdotto(prodotto.getCodiceProdotto());
			prodotti.setQuantita(prodotti.getQuantita() - prodotto.getQuantita());
			prodottiDaoImp.updateProdotto(prodotti);
		}
	}
	//Da inserire nell'iterface
	public void visualizzaTabellaRegistroVenditeCercaPerNumeroOrdine(JTable tableRegistroVendite, String numeroOrdine) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.cercaPerIdOrdine(numeroOrdine);
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	
	public void visualizzaTabellaRegistroVenditeCercaPerDataRegistrazione(JTable tableRegistroVendite, String dataRegistrazione) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.cercaPerDataRegistrazione(dataRegistrazione);
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	
	public void visualizzaTabellaRegistroVenditeCercaPerIdListaProdotti(JTable tableRegistroVendite, String idLista) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.cercaPerIdLista(idLista);
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	
	public void visualizzaTabellaRegistroVenditeCercaPerCodiceCarta(JTable tableRegistroVendite, String codiceCarta) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.cercaPerCodiceCarta(codiceCarta);
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	/*
	public void visualizzaTabellaRegistroVenditeCercaPerTipoPagamento(JTable tableRegistroVendite, String tipoPagamento) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		OrdineDaoImp ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		//
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	*/
	public void visualizzaTabellaRegistroVenditeCercaPerCodiceCliente(JTable tableRegistroVendite, String codiceCliente) {
		ArrayList<Ordine> ordiniArrayList = new ArrayList<Ordine>();
		DAO.OrdineDao ordinedaoimp = new OrdineDaoImp(ordiniArrayList);
		ordiniArrayList = ordinedaoimp.cercaPerCodiceCliente(codiceCliente);
		ordinedaoimp.modificaTabellaOrdine(tableRegistroVendite, ordiniArrayList);
	}
	
	public ArrayList<Ordine> tableToArrayListOrdine(JTable tableOrdini) {
		ArrayList<Ordine> ordini = new ArrayList<Ordine>();
		for (int i = 0; i < tableOrdini.getRowCount(); i++) {
			ordini.add(new Ordine(tableOrdini.getValueAt(i, 0).toString(), Double.parseDouble(tableOrdini.getValueAt(i, 2).toString()),
			tableOrdini.getValueAt(i, 1).toString(), tableOrdini.getValueAt(i, 8).toString(), tableOrdini.getValueAt(i, 3).toString(),
			tableOrdini.getValueAt(i, 7).toString(), tableOrdini.getValueAt(i, 5).toString(),Double.parseDouble(tableOrdini.getValueAt(i, 4).toString()),
			tableOrdini.getValueAt(i, 6).toString()));
		}
		return ordini;
	}
	
	public void visualizzaTabellaOrdinaNumeroOrdine(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniNumeroOrdine(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaTotaleOrdine(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniTotaleOrdine(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaDataRegistrzione(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniDataRegistrazione(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaCodiceCliente(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniCodiceCliente(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaCodiceTessera(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniCodiceTessera(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaIdLista(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniIdLista(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaTipoPagamento(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniTipoPagamento(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaCodiceCarta(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniCodiceCarta(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaBancaRicevente(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniBancaRicevente(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public void visualizzaTabellaOrdinaSoldiRicevuti(JTable tableOrdini) {
		ArrayList<Ordine> ordiniOrdinati = new ArrayList<Ordine>();
		ordiniOrdinati = tableToArrayListOrdine(tableOrdini);
		Ordine tmp = new Ordine();
		tmp.OrdinaOrdiniSoldiRicevuti(ordiniOrdinati);
		DAO.OrdineDao ordineDaoImp = new OrdineDaoImp(ordiniOrdinati);
		ordineDaoImp.modificaTabellaOrdine(tableOrdini, ordiniOrdinati);
	}
	
	public String prelevaIdListSelezionato(JTable tabella) {
		String idLista;
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		
		idLista = model.getValueAt(tabella.getSelectedRow(), 3).toString();
		
		return idLista;
	}
	
	public void verificaCercaProdotto(JComboBox selezione,JTable tabella, JTextField nome ) {
		String valore = (String)selezione.getSelectedItem();

			if (valore.equalsIgnoreCase("codice Prodotto")) {
				this.mostraProdottoCodiceProdotto(tabella, nome);
			} else if (valore.equalsIgnoreCase("Descrizione")) {
				this.mostraProdottoDescrizione(tabella, nome);
			} else if (valore.equalsIgnoreCase("Provenienza")) {
				this.mostraProdottoProvenienza(tabella, nome);
			} else{
				this.mostraProdottoProduttore(tabella, nome);
			}
	}
	
	public void mostraProdottoCodiceProdotto(JTable tabella, JTextField codiceProdotto) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magaz = new MagazinoDaoImp(conn);
			magaz.leggiMagazzinoPerCodiceProdotto(tabella,codiceProdotto );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i prodotti per codice prodotto: "
					+ e.getMessage());
		}
		
	}
	
	public void mostraProdottoDescrizione(JTable tabella, JTextField descrizione) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magaz = new MagazinoDaoImp(conn);
			magaz.leggiMagazzinoPerDescrizione(tabella,descrizione );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i prodotti per descrizione: "
					+ e.getMessage());
		}
		
	}
	
	public void mostraProdottoProvenienza(JTable tabella, JTextField provenienza) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magaz = new MagazinoDaoImp(conn);
			magaz.leggiMagazzinoPerProvenienza(tabella,provenienza );
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i prodotti per provenienza: "
					+ e.getMessage());
		}
	}
	
	public void mostraProdottoProduttore(JTable tabella, JTextField produttore) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magaz = new MagazinoDaoImp(conn);
			magaz.leggiMagazzinoPerProduttore(tabella,produttore );
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella mostrare "
					+ " i prodotti per produttore: "
					+ e.getMessage());
		}
	}
	
	public void ordinaProdotti(JComboBox combo, JTable tabella) {
		Connection conn = this.collegamento();
		try {
			MagazinoDaoImp magazzino = new MagazinoDaoImp(conn);
			magazzino.Ordinamento(combo, tabella);
			
			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'ordinare "
					+ " i prodotti : " + e.getMessage());
		}
	}
	
	
}

