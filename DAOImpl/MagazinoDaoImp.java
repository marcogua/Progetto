package DAOImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classi.Cliente;
import Classi.Magazzino;
import Classi.Prodotto;
import DbConfig.DbConnect;

import java.sql.Connection;

public class MagazinoDaoImp {
	private Connection connection;
	private PreparedStatement getAllMagazzino,getAllMagazzinoCodiceProdotto,getAllMagazzinoDescrizione,getAllMagazzinoProvenienza,
	getAllMagazzinoProduttore,insertProdotto, delateProdotto, ordinaMagazzino;
	
	
	public MagazinoDaoImp(Connection connection) throws SQLException {
		this.connection = connection;
		getAllMagazzino = connection.prepareStatement("SELECT * FROM prodotto");
		getAllMagazzinoCodiceProdotto = connection.prepareStatement("SELECT * FROM prodotto WHERE codiceprodotto ilike ?");
		getAllMagazzinoDescrizione =connection.prepareStatement("SELECT * FROM prodotto WHERE descrizione ilike ?");
		getAllMagazzinoProvenienza =connection.prepareStatement("SELECT * FROM prodotto WHERE provenienza ilike ?");
		getAllMagazzinoProduttore = connection.prepareStatement("SELECT * FROM prodotto WHERE produttorefornitore ilike ?");
		insertProdotto = connection.prepareStatement("INSERT INTO prodotto(codiceprodotto, descrizione, prezzo, provenienza, produttorefornitore, quantita, unita, iva)	VALUES (?, ?, ?, ?, ?, ?, ?,?)");
		delateProdotto = connection.prepareStatement("DELETE FROM prodotto WHERE codiceprodotto ilike ?");
	}
	
	public ArrayList<Magazzino> getAllMagazzino(ArrayList<Magazzino> magazzino) throws SQLException {
        ResultSet rs=getAllMagazzino.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
	
	public ArrayList<Magazzino> getAllMagazzinoCodiceProdotto(ArrayList<Magazzino> magazzino, String codiceProdotto) throws SQLException {
		getAllMagazzinoCodiceProdotto.setString(1, codiceProdotto);
        ResultSet rs=getAllMagazzinoCodiceProdotto.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
	
	public ArrayList<Magazzino> getAllMagazzinoDescrizione(ArrayList<Magazzino> magazzino, String descrizione) throws SQLException {
		getAllMagazzinoDescrizione.setString(1, descrizione);
        ResultSet rs=getAllMagazzinoDescrizione.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
	
	public ArrayList<Magazzino> getAllMagazzinoProvenienza(ArrayList<Magazzino> magazzino, String provenienza) throws SQLException {
		getAllMagazzinoProvenienza.setString(1, provenienza);
        ResultSet rs=getAllMagazzinoProvenienza.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
	
	public ArrayList<Magazzino> getAllMagazzinoProduttore(ArrayList<Magazzino> magazzino, String produttore) throws SQLException {
		getAllMagazzinoProduttore.setString(1, produttore);
        ResultSet rs=getAllMagazzinoProduttore.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
	
	public int insertProdotto(Prodotto magazzino) throws SQLException{
		insertProdotto.setString(1, magazzino.getCodiceProdotto());
		insertProdotto.setString(2, magazzino.getDescrizione());
		insertProdotto.setDouble(3, magazzino.getPrezzo());
		insertProdotto.setString(4, magazzino.getProvenienza());
		insertProdotto.setString(5, magazzino.getProduttoreFornitore());
		insertProdotto.setInt(6, (int) magazzino.getQuantita());
		insertProdotto.setString(7, magazzino.getUnita());
		insertProdotto.setString(8, magazzino.getIva());
		int row = insertProdotto.executeUpdate();
		return row;
    }
	
	public int delateProdotto(String valore) throws SQLException{
		delateProdotto.setString(1,  valore);
		int row = delateProdotto.executeUpdate();
		return row;
    }
	
	public void leggiMagazzino(JTable tabella){
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		try {
			this.modificaTabella(tabella, this.getAllMagazzino(magazzino));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i prodotti"
					+ "nel magazzino: "
					+ e.getMessage());
		}
		
    }
	
	public void leggiMagazzinoPerCodiceProdotto(JTable tabella,JTextField codiceProdotto){
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		try {
			this.modificaTabella(tabella, this.getAllMagazzinoCodiceProdotto(magazzino, codiceProdotto.getText()));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i prodotti"
					+ "nel magazzino per codice prodotto: "
					+ e.getMessage());
		}
		
    }
	
	public void leggiMagazzinoPerDescrizione(JTable tabella,JTextField descrizione){
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		try {
			this.modificaTabella(tabella, this.getAllMagazzinoDescrizione(magazzino, descrizione.getText()));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i prodotti"
					+ "nel magazzino per descrizione: "
					+ e.getMessage());
		}
		
    }
	
	public void leggiMagazzinoPerProvenienza(JTable tabella,JTextField provenienza){
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		try {
			this.modificaTabella(tabella, this.getAllMagazzinoProvenienza(magazzino, provenienza.getText()));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i prodotti"
					+ "nel magazzino per provenienza: "
					+ e.getMessage());
		}
		
    }
	
	public void leggiMagazzinoPerProduttore(JTable tabella,JTextField produttore){
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		try {
			this.modificaTabella(tabella, this.getAllMagazzinoProduttore(magazzino, produttore.getText()));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i prodotti"
					+ "nel magazzino per produttore: "
					+ e.getMessage());
		}
		
    }
	
	public void modificaTabella(JTable tabella, ArrayList<Magazzino> magazzino) {
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		model.setRowCount(0);
		Object[] row = new Object[7];
		for (int i = 0; i<magazzino.size();i++) {
			row[0] = magazzino.get(i).getCodiceProdotto();
			row[1] = magazzino.get(i).getDescrizione();
			row[2] = magazzino.get(i).getPrezzo();
			row[3] = magazzino.get(i).getProvenienza();
			row[4] = magazzino.get(i).getProduttore();
			row[5] = magazzino.get(i).getQuantita();
			row[6] = magazzino.get(i).getUnita();
			model.addRow(row);
		}
	}
	
	
	public void aggiungiProdotto( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita){
			double prez = Double.parseDouble(prezzo.getText());
			double quant = Double.parseDouble(quantita.getText());
			String unit = (String)unita.getSelectedItem();
			
			
		Prodotto magazzino = new Prodotto(codiceprodotto.getText(), descrizione.getText(),produttore.getText(),
				provenienza.getText(), prez , quant, unit,iva.getText());
		try {
			this.insertProdotto(magazzino);
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella "
					+ "aggiungere i Prodotti nel magazzino: "
					+ e.getMessage());
		}
    }
	
	public void Ordinamento(JComboBox ordina, JTable tabella) throws SQLException {
		String query = (String)ordina.getSelectedItem();
		ArrayList<Magazzino> magazzino = new ArrayList<Magazzino>();
		
		if(query.equalsIgnoreCase("Codice Prodotto")) {
			ordinaMagazzino = connection.prepareStatement("SELECT * FROM prodotto  ORDER BY codiceprodotto");
		}
		else if(query.equalsIgnoreCase("Descrizione")) {
			ordinaMagazzino = connection.prepareStatement("SELECT * FROM prodotto  ORDER BY descrizione");
		}
		else if(query.equalsIgnoreCase("prezzo")) {
			ordinaMagazzino = connection.prepareStatement("SELECT * FROM prodotto  ORDER BY prezzo");
		}
		else if(query.equalsIgnoreCase("Provenienza")) {
			ordinaMagazzino = connection.prepareStatement("SELECT * FROM prodotto  ORDER BY provenienza");
		}
		else if(query.equalsIgnoreCase("Produttore")){
			ordinaMagazzino = connection.prepareStatement("SELECT * FROM prodotto  ORDER BY produttorefornitore");
		}	
		this.modificaTabella(tabella, this.ordinaMagaz(magazzino));
	}
	
	public ArrayList<Magazzino> ordinaMagaz( ArrayList<Magazzino> magazzino) throws SQLException {
		ResultSet rs=ordinaMagazzino.executeQuery();
        while(rs.next()) {
        	Magazzino  m = new Magazzino();
        	m.setCodiceProdotto(rs.getString("codiceprodotto"));
        	m.setDescrizione(rs.getString("descrizione"));
        	m.setPrezzo(rs.getDouble("prezzo"));
        	m.setProvenienza(rs.getString("provenienza"));
        	m.setProduttore(rs.getString("produttorefornitore"));
        	m.setQuantita(rs.getInt("quantita"));
        	m.setUnita(rs.getString("Unita"));
        	magazzino.add(m);
        }
        rs.close();
    	return magazzino;
    }
}
	