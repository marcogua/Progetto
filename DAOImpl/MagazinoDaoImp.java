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

import java.sql.Connection;

public class MagazinoDaoImp {
	private Connection connection;
	private PreparedStatement getAllMagazzino,insertProdotto, delateProdotto;
	
	
	public MagazinoDaoImp(Connection connection) throws SQLException {
		this.connection = connection;
		getAllMagazzino = connection.prepareStatement("SELECT * FROM prodotto");
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


}
	