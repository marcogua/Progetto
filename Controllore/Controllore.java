package Controllore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classi.*;
import DAO.ClienteDao;
import DAO.TesseraPuntiDAO;
import DAOImpl.*;

import javax.swing.JComboBox;

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
	
	public void error_GUI() {
		errore.setVisible(true);
	}
	
	public void errorModifica_GUI() {
		erroreModifica.setVisible(true);
	}
	
	
	public void modifica_GUI(Cliente client) {
			modifica.riceviCliente(client);
			modifica.setVisible(true);
		
	}

	public void modificaProdotto_GUI(Prodotto prodotto) {
		modificaProdotto.riceviProdotto(prodotto);
		modificaProdotto.setVisible(true);
	}
	
	public void modificaProdotto_GUI(Magazzino magazino) {
		modificaProdotto.setVisible(true);
}
	
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
	
	
	@Override
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
	
	
	
	@Override
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
	
	public void Leggi(Cliente client, JTextField codiceCliente, JTextField nome, JTextField cognome, JTextField email, JTextField codicetessera) {
		Cliente cliente = client;
		
		nome.setText(cliente.getNome());
		cognome.setText(cliente.getCognome());
		email.setText(cliente.getEmail());
		codiceCliente.setText(cliente.getCodiceCliente());
		codicetessera.setText(cliente.getCodiceTessera());
	}

	
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

	public void salvaProdottoUova( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
							   JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
								   JComboBox giorno, JComboBox mese, JComboBox anno,JComboBox categoriaUova, JComboBox classe) {
		Connection conn = this.collegamento();
		try {

			UovaDaoImp uovaDao = new UovaDaoImp();
			MagazinoDaoImp mag = new MagazinoDaoImp(conn);

			String data = ((String)giorno.getSelectedItem())+"-"+((String)mese.getSelectedItem()) +
					"-"+((String)anno.getSelectedItem());

			uovaDao.addUova(codiceprodotto.getText(),data,(String)categoriaUova.getSelectedItem(),(String)classe.getSelectedItem() );
			mag.aggiungiProdotto(codiceprodotto,descrizione,prezzo,provenienza,produttore,quantita,iva,unita);

			conn.close();
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nell'aggiungere  "
					+ " il prodotto: "
					+ e.getMessage());
		}

		this.ripilusci(codiceprodotto, descrizione, prezzo, provenienza, produttore, quantita);

	}

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
	
	public void ripilusci(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza,JTextField produttore, JTextField quantita) {
		
		codiceprodotto.setText("");
		descrizione.setText("");
		prezzo.setText("");
		provenienza.setText("");
		produttore.setText("");
		quantita.setText("");
		
	}

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

	public void visualizzaTabellaFrutta(JTable tabellaFrutta){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getAllFrutta();
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerdura(JTable tabellaVerdura){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdura();
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUova(JTable tabellaUova){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getAllUova();
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaFarinacei(JTable tabellaFarinacei){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getAllFarinacei();
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	public void visualizzaTabellaConfezionati(JTable tabellaConfezionati){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getAllConfezionati();
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaLatticini(JTable tabellaLatticini){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getAllLatticini();
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaFruttaCercaCodiceProdotto(JTable tabellaFrutta, String codiceProdotto){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByCodiceProdotto(codiceProdotto);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerduraCercaCodiceProdotto(JTable tabellaVerdura, String codiceProdotto){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByCodiceProdotto(codiceProdotto);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUovaCercaCodiceProdotto(JTable tabellaUova, String codiceProdotto){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByCodiceProdotto(codiceProdotto);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaFarinaceiCercaCodiceProdotto(JTable tabellaFarinacei, String codiceProdotto){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByCodiceProdotto(codiceProdotto);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaCodiceProdotto(JTable tabellaConfezionati, String codiceProdotto){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByCodiceProdotto(codiceProdotto);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaLatticiniCercaCodiceProdotto(JTable tabellaLatticini, String codiceProdotto){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByCodiceProdotto(codiceProdotto);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaFruttaCercaDescrizione(JTable tabellaFrutta, String descrizione){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByDescrizione(descrizione);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerduraCercaDescrizione(JTable tabellaVerdura, String descrizione){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByDescrizione(descrizione);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUovaCercaDescrizione(JTable tabellaUova, String descrizione){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByDescrizione(descrizione);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaFarinaceiCercaDescrizione(JTable tabellaFarinacei, String descrizione){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByDescrizione(descrizione);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaDescrizione(JTable tabellaConfezionati, String descrizione){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDescrizione(descrizione);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaLatticiniCercaDescrizione(JTable tabellaLatticini, String descrizione){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDescrizione(descrizione);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaFruttaCercaProduttoreFornitore(JTable tabellaFrutta, String produttoreFornitore){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByProduttoreFornitore(produttoreFornitore);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerduraCercaProduttoreFornitore(JTable tabellaVerdura, String produttoreFornitore){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByProduttoreFornitore(produttoreFornitore);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUovaCercaProduttoreFornitore(JTable tabellaUova, String produttoreFornitore){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByProduttoreFornitore(produttoreFornitore);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaFarinaceiCercaProduttoreFornitore(JTable tabellaFarinacei, String produttoreFornitore){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByProduttoreFornitore(produttoreFornitore);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaProduttoreFornitore(JTable tabellaConfezionati, String produttoreFornitore){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByProduttoreFornitore(produttoreFornitore);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaLatticiniCercaProduttoreFornitore(JTable tabellaLatticini, String produttoreFornitore){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByProduttoreFornitore(produttoreFornitore);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaFruttaCercaProvenienza(JTable tabellaFrutta, String provenienza){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByProvenienza(provenienza);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerduraCercaProvenienza(JTable tabellaVerdura, String provenienza){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByProvenienza(provenienza);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUovaCercaProvenienza(JTable tabellaUova, String provenienza){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByProvenienza(provenienza);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaFarinaceiCercaProvenienza(JTable tabellaFarinacei, String provenienza){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByProvenienza(provenienza);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaProvenienza(JTable tabellaConfezionati, String provenienza){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByProvenienza(provenienza);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaLatticiniCercaProvenienza(JTable tabellaLatticini, String provenienza){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByProvenienza(provenienza);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaFruttaCercaDataRaccolta(JTable tabellaFrutta, String dataraccolata){
		ArrayList<Frutta> fruttaArrayList = new ArrayList<>();
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaArrayList);
		fruttaArrayList = fruttaDaoImp.getFruttaByDataRaccolta(dataraccolata);
		fruttaDaoImp.modificaTabellaFrutta(tabellaFrutta,fruttaArrayList);
	}

	public void visualizzaTabellaVerduraCercaDataRaccolta(JTable tabellaVerdura, String dataraccolata){
		ArrayList<Verdura> verduraArrayList = new ArrayList<>();
		VerdureDaoImp verdureDaoImp = new VerdureDaoImp(verduraArrayList);
		verduraArrayList = verdureDaoImp.getVerdureByDataRaccolta(dataraccolata);
		verdureDaoImp.modificaTabellaVerdure(tabellaVerdura,verduraArrayList);
	}

	public void visualizzaTabellaUovaCercaDataConfezionamento(JTable tabellaUova, String dataConfezionamento){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByDataConfezionamento(dataConfezionamento);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaUovaCercaCategoriaUova(JTable tabellaUova, String categoriaUova){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByCategoriaUova(categoriaUova);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaUovaCercaClassePeso(JTable tabellaUova, String classePeso){
		ArrayList<Uova> uovaArrayList = new ArrayList<>();
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaArrayList);
		uovaArrayList = uovaDaoImp.getUovaByClassePeso(classePeso);
		uovaDaoImp.modificaTabellaUova(tabellaUova, uovaArrayList);
	}

	public void visualizzaTabellaLatticiniCercaDataMungitura(JTable tabellaLatticini, String dataMungitura){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDataMungitura(dataMungitura);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaLatticiniCercaDataProduzione(JTable tabellaLatticini, String dataProduzione){
		ArrayList<Latticini> latticiniArrayList = new ArrayList<>();
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniArrayList);
		latticiniArrayList = latticiniDaoImp.getLatticiniByDataProduzione(dataProduzione);
		latticiniDaoImp.modificaTabellaLatticini(tabellaLatticini,latticiniArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaDataConfezionamento(JTable tabellaConfezionati, String dataConfezionamento){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDataConfezionamento(dataConfezionamento);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaConfezionatiCercaDataScadenza(JTable tabellaConfezionati, String dataScadenza){
		ArrayList<Confezionati> confezionatiArrayList = new ArrayList<>();
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiArrayList);
		confezionatiArrayList = confezionatiDaoImp.getConfezionatiByDataScadenza(dataScadenza);
		confezionatiDaoImp.modificaTabellaConfezionati(tabellaConfezionati,confezionatiArrayList);
	}

	public void visualizzaTabellaFarinaceiCercaDataScadenza(JTable tabellaFarinacei, String dataScadenza){
		ArrayList<Farinacei> farinaceiArrayList = new ArrayList<>();
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiArrayList);
		farinaceiArrayList = farinaceiDaoImp.getFarinaceiByDataScadenza(dataScadenza);
		farinaceiDaoImp.modificaTabellaFarinacei(tabellaFarinacei,farinaceiArrayList);
	}
	
	public void aggiungiAlCarelloFrutta(JTable tabellaFrutta, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow() , 1);
		row[2]= tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow() , 8);
		row[3]= tabellaFrutta.getValueAt(tabellaFrutta.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void aggiungiAlCarelloVerdura(JTable tabellaVerdura, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow() , 1);
		row[2]= tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow() , 8);
		row[3]= tabellaVerdura.getValueAt(tabellaVerdura.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void aggiungiAlCarelloFarinacei(JTable tabellaFarinacei, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow() , 1);
		row[2]= tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow() , 8);
		row[3]= tabellaFarinacei.getValueAt(tabellaFarinacei.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void aggiungiAlCarelloLatticini(JTable tabellaLatticini, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow() , 1);
		row[2]= tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow() , 8);
		row[3]= tabellaLatticini.getValueAt(tabellaLatticini.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void aggiungiAlCarelloUova(JTable tabellaUova, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaUova.getValueAt(tabellaUova.getSelectedRow() , 1);
		row[2]= tabellaUova.getValueAt(tabellaUova.getSelectedRow() , 8);
		row[3]= tabellaUova.getValueAt(tabellaUova.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void aggiungiAlCarelloConfezionati(JTable tabellaConfezionati, double quantita, JTable carello) {
		int i =  carello.getRowCount();
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		model.setRowCount(i);
		Object[] row = new Object[4];
		row[0]= quantita;
		row[1]= tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow() , 1);
		row[2]= tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow() , 8);
		row[3]= tabellaConfezionati.getValueAt(tabellaConfezionati.getSelectedRow() , 7);
		model.addRow(row);
	}
	
	public void svuotaCarello(JTable carello) {
		DefaultTableModel model = (DefaultTableModel)carello.getModel();
		for(int i= model.getRowCount() -1; i >= 0; i--) {
		model.removeRow(i);
		}
	}
	
	public void rimuoviProdottoCarrello(JTable carrello) {
		DefaultTableModel model = (DefaultTableModel)carrello.getModel();
		model.removeRow(carrello.getSelectedRow());
	}
	
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
	
	public void visualizzaTabellaFruttaOrdinaCodiceProdottoAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaCodiceProdottoAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaCodiceProdottoDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaCodiceProdottoDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaDescrizioneAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDescrizioneAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaDescrizioneDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDescrizioneDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaProduttoreFornitoreAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProduttoreFornitoreAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaProduttoreFornitoreDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProduttoreForniotreDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaProvenienzaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProveninenzaAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaProvenienzaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaProvenienzaDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaDataRaccoltaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDataRaccolataAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaDataRaccoltaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaDataRaccolataDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaQuantitaAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaQunaitaAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaQuantitaDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaQunaitaDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaPrezzoAsc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaPrezzoAsc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaFruttaOrdinaPrezzoDesc(JTable tableFrutta) {
		ArrayList<Frutta> fruttaOrdinata = new ArrayList<Frutta>();
		fruttaOrdinata = tableToArrayListFrutta(tableFrutta);
		Frutta tmp = new Frutta();
		tmp.OrdinaFruttaPrezzoDesc(fruttaOrdinata);
		FruttaDaoImp fruttaDaoImp = new FruttaDaoImp(fruttaOrdinata);
		fruttaDaoImp.modificaTabellaFrutta(tableFrutta, fruttaOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaCodiceProdottoAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraCodiceProdottoAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaCodiceProdottoDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraCodiceProdottoDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaDescrizioneAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDescrizioneAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaDescrizioneDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDescrizioneDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaProduttoreFornitoreAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProduttoreFornitoreAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaProduttoreFornitoreDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProduttoreFornitoreDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaProvenienzaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProvenienzaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaProvenienzaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraProvenienzaDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaDataRaccoltaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDataRaccoltaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaDataRaccoltaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraDataRaccolataDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaQuantitaAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraQunaitaAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaQuantitaDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraQunaitaDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaPrezzoAsc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraPrezzoAsc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaVerduraOrdinaPrezzoDesc(JTable tableVerdura) {
		ArrayList<Verdura> verduraOrdinata = new ArrayList<Verdura>();
		verduraOrdinata = tableToArrayListVerdura(tableVerdura);
		Verdura tmp = new Verdura();
		tmp.OrdinaVerduraPrezzoDesc(verduraOrdinata);
		VerdureDaoImp verduraDaoImp = new VerdureDaoImp(verduraOrdinata);
		verduraDaoImp.modificaTabellaVerdure(tableVerdura, verduraOrdinata);
	}
	
	public void visualizzaTabellaUovaOrdinaCodiceProdottoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCodiceProdottoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaCodiceProdottoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCodiceProdottoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaDescrizioneAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDescrizioneAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaDescrizioneDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDescrizioneDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaProduttoreFornitoreAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProduttoreFornitoreAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaProduttoreFornitoreDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProduttoreFornitoreDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaProvenienzaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProvenienzaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaProvenienzaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaProvenienzaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaClassePesoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaClassePesoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaClassePesoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaClassePesoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaCategoriaUovaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCategoriaUovaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaCategoriaUovaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaCategoriaUovaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaDataConfezionamentoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDataConfezionametoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaDataConfezionamentoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaDataConfezionamentoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaQuantitaAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaQuantitaAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaQuantitaDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaQuantitaDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaPrezzoAsc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaPrezzoAsc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaUovaOrdinaPrezzoDesc(JTable tableUova) {
		ArrayList<Uova> uovaOrdinate = new ArrayList<Uova>();
		uovaOrdinate = tableToArrayListUova(tableUova);
		Uova tmp = new Uova();
		tmp.OrdinaUovaPrezzoDesc(uovaOrdinate);
		UovaDaoImp uovaDaoImp = new UovaDaoImp(uovaOrdinate);
		uovaDaoImp.modificaTabellaUova(tableUova, uovaOrdinate);
	}
	
	public void visualizzaTabellaLatticiniOrdinaCodiceProdottoAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininCodiceProdottoAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaCodiceProdottoDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniCodiceProdottoDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDescrizioneAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDescrizioneAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDescrizioneDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDescrizioneDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininProduttoreFornitoreAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProduttoreFornitoreDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaProvenienzaAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProvenienzaAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaProvenienzaDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniProvenienzaDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDataMungituraAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDataMungituraAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDataMungituraDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDataMungituraDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDataProduzioneAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininDataProduzioneAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaDataProduzioneDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniDataProduzioneDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaSenzaLattosioAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininSenzaLattosioAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaSenzaLattosioDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniSenzaLattosioDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaQuantitaAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininQuanitaAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaQuantitaDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniQunaitaDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaPrezzoAsc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticininPrezzoAsc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaLatticiniOrdinaPrezzoDesc(JTable tableLatticini) {
		ArrayList<Latticini> latticiniOrdinati = new ArrayList<Latticini>();
		latticiniOrdinati = tableToArrayListLatticini(tableLatticini);
		Latticini tmp = new Latticini();
		tmp.OrdinaLatticiniPrezzoDesc(latticiniOrdinati);
		LatticiniDaoImp latticiniDaoImp = new LatticiniDaoImp(latticiniOrdinati);
		latticiniDaoImp.modificaTabellaLatticini(tableLatticini, latticiniOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaCodiceProdottoAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiCodiceProdottoAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaCodiceProdottoDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiCodiceProdottoDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaDescrizioneAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDescrizioneAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaDescrizioneDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDescrizioneDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProduttoreFornitoreAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProduttoreFornitoreDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaProvenienzaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProvenienzaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaProvenienzaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiProvenienzaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaDataScadenzaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDataScadenzaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaDataScadenzaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiDataScadenzaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaQuantitaAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiQuantitaAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaQuantitaDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiQuanitaDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaPrezzoAsc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiPrezzoAsc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaFarinaceiOrdinaPrezzoDesc(JTable tableFarinacei) {
		ArrayList<Farinacei> farinaceiOrdinati = new ArrayList<Farinacei>();
		farinaceiOrdinati = tableToArrayListFarinacei(tableFarinacei);
		Farinacei tmp = new Farinacei();
		tmp.OrdinaFarinaceiPrezzoDesc(farinaceiOrdinati);
		FarinaceiDaoImp farinaceiDaoImp = new FarinaceiDaoImp(farinaceiOrdinati);
		farinaceiDaoImp.modificaTabellaFarinacei(tableFarinacei, farinaceiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaCodiceProdottoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiCodiceProdottoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaCodiceProdottoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiCodiceProdottoDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDescrizioneAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDescrizioneAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDescrizioneDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDescrizioneDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProduttoreFornitoreAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProduttoreFornitoreDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaProvenienzaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProvenienzaAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaProvenienzaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiProvenienzaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDataConfezionametoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataConfezionamentoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDataConfezionametoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataConfezionamentoDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDataScadenzaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataScadenzatoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaDataScadenzaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiDataScadenzaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaQuantitaAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiQuantitaAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaQuantitaDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiQuantitaDesc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaPrezzoAsc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiPrezzoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}
	
	public void visualizzaTabellaConfezionatiOrdinaPrezzoDesc(JTable tableConfezionati) {
		ArrayList<Confezionati> confezionatiOrdinati = new ArrayList<Confezionati>();
		confezionatiOrdinati = tableToArrayListConfezionati(tableConfezionati);
		Confezionati tmp = new Confezionati();
		tmp.OrdinaConfezionatiPrezzoAsc(confezionatiOrdinati);
		ConfezionatiDaoImp confezionatiDaoImp = new ConfezionatiDaoImp(confezionatiOrdinati);
		confezionatiDaoImp.modificaTabellaConfezionati(tableConfezionati, confezionatiOrdinati);
	}

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
	}

}

