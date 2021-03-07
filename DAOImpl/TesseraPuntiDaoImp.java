package DAOImpl;

import Classi.TesseraPunti;
import DAO.TesseraPuntiDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TesseraPuntiDaoImp implements TesseraPuntiDAO  {
	 private Connection connection;
	 private PreparedStatement getAllTessere, insertTessere, delateTessere;
	 private PreparedStatement getAllTesseraPerNome, getAllTesseraPerCliente, getAllTesseraPerTessera ;
	 private PreparedStatement ordinaTessera;

    public TesseraPuntiDaoImp(Connection connection) throws SQLException{
    	this.connection = connection;
    	getAllTessere = connection.prepareStatement("SELECT * FROM tesserapunti ");
    	insertTessere = connection.prepareStatement("INSERT INTO tesserapunti VALUES (?, ?, ?, ?, ?,?, ?, ?, ?, ?)");
    	delateTessere = connection.prepareStatement("DELETE FROM tesserapunti WHERE codicecliente ilike ? ");
    	getAllTesseraPerNome = connection.prepareStatement("SELECT * FROM tesserapunti WHERE nomeintestatario ilike ? ");
    	getAllTesseraPerCliente = connection.prepareStatement("SELECT * FROM tesserapunti WHERE codicecliente ilike ? ");
    	getAllTesseraPerTessera = connection.prepareStatement("SELECT * FROM tesserapunti WHERE codicetessera ilike ? ");
    	
    }
    
    
    @Override
	public ArrayList<TesseraPunti> getAllTesseraPunti(ArrayList<TesseraPunti> punti) throws SQLException {
        ResultSet rs=getAllTessere.executeQuery();
        while(rs.next()) {
        	TesseraPunti  tesseraS = new TesseraPunti();
        	tesseraS.setCodiceTessera(rs.getString("codicetessera"));
        	tesseraS.setSaldoPunti(rs.getInt("saldopunti"));
        	tesseraS.setNomeIntestatario(rs.getString("nomeintestatario"));
        	tesseraS.setPuntiFrutta(rs.getInt("puntifrutta"));
        	tesseraS.setPuntiVerdura(rs.getInt("puntiverdura"));
        	tesseraS.setPuntiUova(rs.getInt("puntiuova"));
        	tesseraS.setPuntiConfezionati(rs.getInt("punticonfezionati"));
        	tesseraS.setPuntiFarinacei(rs.getInt("puntifarinacei"));
        	tesseraS.setPuntiLatticini(rs.getInt("puntilatticini"));
        	tesseraS.setCodiceCliente(rs.getString("codicecliente"));
        	punti.add(tesseraS);
        }
        rs.close();
    	return punti;
    }
	
    
    public ArrayList<TesseraPunti> getAllTesseraPuntiPerNome(ArrayList<TesseraPunti> punti,String nome) throws SQLException {
    	getAllTesseraPerNome.setString(1, nome);
        ResultSet rs=getAllTesseraPerNome.executeQuery();
        while(rs.next()) {
        	TesseraPunti  tesseraS = new TesseraPunti();
        	tesseraS.setCodiceTessera(rs.getString("codicetessera"));
        	tesseraS.setSaldoPunti(rs.getInt("saldopunti"));
        	tesseraS.setNomeIntestatario(rs.getString("nomeintestatario"));
        	tesseraS.setPuntiFrutta(rs.getInt("puntifrutta"));
        	tesseraS.setPuntiVerdura(rs.getInt("puntiverdura"));
        	tesseraS.setPuntiUova(rs.getInt("puntiuova"));
        	tesseraS.setPuntiConfezionati(rs.getInt("punticonfezionati"));
        	tesseraS.setPuntiFarinacei(rs.getInt("puntifarinacei"));
        	tesseraS.setPuntiLatticini(rs.getInt("puntilatticini"));
        	tesseraS.setCodiceCliente(rs.getString("codicecliente"));
        	punti.add(tesseraS);
        }
        rs.close();
    	return punti;
    }
    
    public ArrayList<TesseraPunti> getAllTesseraPuntiPerCliente(ArrayList<TesseraPunti> punti,String nome) throws SQLException {
    	getAllTesseraPerCliente.setString(1, nome);
        ResultSet rs=getAllTesseraPerCliente.executeQuery();
        while(rs.next()) {
        	TesseraPunti  tesseraS = new TesseraPunti();
        	tesseraS.setCodiceTessera(rs.getString("codicetessera"));
        	tesseraS.setSaldoPunti(rs.getInt("saldopunti"));
        	tesseraS.setNomeIntestatario(rs.getString("nomeintestatario"));
        	tesseraS.setPuntiFrutta(rs.getInt("puntifrutta"));
        	tesseraS.setPuntiVerdura(rs.getInt("puntiverdura"));
        	tesseraS.setPuntiUova(rs.getInt("puntiuova"));
        	tesseraS.setPuntiConfezionati(rs.getInt("punticonfezionati"));
        	tesseraS.setPuntiFarinacei(rs.getInt("puntifarinacei"));
        	tesseraS.setPuntiLatticini(rs.getInt("puntilatticini"));
        	tesseraS.setCodiceCliente(rs.getString("codicecliente"));
        	punti.add(tesseraS);
        }
        rs.close();
    	return punti;
    }
    
    public ArrayList<TesseraPunti> getAllTesseraPuntiPerTessera(ArrayList<TesseraPunti> punti,String nome) throws SQLException {
    	getAllTesseraPerTessera.setString(1, nome);
        ResultSet rs=getAllTesseraPerTessera.executeQuery();
        while(rs.next()) {
        	TesseraPunti  tesseraS = new TesseraPunti();
        	tesseraS.setCodiceTessera(rs.getString("codicetessera"));
        	tesseraS.setSaldoPunti(rs.getInt("saldopunti"));
        	tesseraS.setNomeIntestatario(rs.getString("nomeintestatario"));
        	tesseraS.setPuntiFrutta(rs.getInt("puntifrutta"));
        	tesseraS.setPuntiVerdura(rs.getInt("puntiverdura"));
        	tesseraS.setPuntiUova(rs.getInt("puntiuova"));
        	tesseraS.setPuntiConfezionati(rs.getInt("punticonfezionati"));
        	tesseraS.setPuntiFarinacei(rs.getInt("puntifarinacei"));
        	tesseraS.setPuntiLatticini(rs.getInt("puntilatticini"));
        	tesseraS.setCodiceCliente(rs.getString("codicecliente"));
        	punti.add(tesseraS);
        }
        rs.close();
    	return punti;
    }
    
    @Override
	public int insertTesseraPS(TesseraPunti tesseraP) throws SQLException {
    	insertTessere.setString(1, tesseraP.getCodiceTessera());
		insertTessere.setInt(2, tesseraP.getSaldoPunti());
		insertTessere.setString(3, tesseraP.getNomeIntestatario());
		insertTessere.setInt(4, tesseraP.getPuntiFrutta());
		insertTessere.setInt(5, tesseraP.getPuntiVerdura());
		insertTessere.setInt(6, tesseraP.getPuntiUova());
		insertTessere.setInt(7, tesseraP.getPuntiConfezionati());
		insertTessere.setInt(8, tesseraP.getPuntiFarinacei());
		insertTessere.setInt(9, tesseraP.getPuntiLatticini());
		insertTessere.setString(10, tesseraP.getCodiceCliente());
		int row = insertTessere.executeUpdate();
		return row;
    }
    
    @Override
	public void creaTessera(JTextField codiceCliente, JTextField codiceTessera, JTextField nome) {
    	TesseraPunti tessera = new TesseraPunti(codiceCliente.getText(), codiceTessera.getText(),nome.getText() );
		try {
			this.insertTesseraPS(tessera);
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere la Tessera: "
					+ e.getMessage());
		}
    }
    
    @Override
	public void mostraTessera(JTable tabella)  {
    	
    	ArrayList<TesseraPunti> punti = new ArrayList<TesseraPunti>();
		try {
			this.mostraTabella(tabella, this.getAllTesseraPunti(punti));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}

    	
    }
    
    public void mostraTesseraPreNome(JTable tabella, String nome)  {
    	
    	ArrayList<TesseraPunti> punti = new ArrayList<TesseraPunti>();
		try {
			this.mostraTabella(tabella, this.getAllTesseraPuntiPerNome(punti,nome));
			
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}

    	
    }
    
    public void mostraTesseraPreClienti(JTable tabella, String codicecliente)  {
    	
    	ArrayList<TesseraPunti> punti = new ArrayList<TesseraPunti>();
		try {
			this.mostraTabella(tabella, this.getAllTesseraPuntiPerCliente(punti,codicecliente));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}
    	
    }
    
 public void mostraTesseraPreTessera(JTable tabella, String codicetessera)  {
    	
    	ArrayList<TesseraPunti> punti = new ArrayList<TesseraPunti>();
		try {
			this.mostraTabella(tabella, this.getAllTesseraPuntiPerTessera(punti,codicetessera));
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}
    	
    }
    
    @Override
	public void mostraTabella(JTable tabella, ArrayList<TesseraPunti> punti) {
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		model.setRowCount(0);
		Object[] row = new Object[10];
		for (int i = 0; i<punti.size();i++) {
			row[0] = punti.get(i).getCodiceTessera();
			row[1] = punti.get(i).getCodiceCliente();
			row[2] = punti.get(i).getNomeIntestatario();
			row[3] = punti.get(i).getPuntiFrutta();
			row[4] = punti.get(i).getPuntiVerdura();
			row[5] = punti.get(i).getPuntiConfezionati();
			row[6] = punti.get(i).getPuntiFarinacei();
			row[7] = punti.get(i).getPuntiLatticini();
			row[8] = punti.get(i).getPuntiUova();
			row[9] = punti.get(i).getSaldoPunti();
			model.addRow(row);
		}
	}
    
    @Override
	public int delateTessera(String valore) throws SQLException{
    	delateTessere.setString(1,  valore);
    		int row = delateTessere.executeUpdate();
    		return row;
        
    }
    
    public ArrayList<TesseraPunti> ordinaTessera( ArrayList<TesseraPunti> punti) throws SQLException {
		ResultSet rs=ordinaTessera.executeQuery();
		while(rs.next()) {
        	TesseraPunti  tesseraS = new TesseraPunti();
        	tesseraS.setCodiceTessera(rs.getString("codicetessera"));
        	tesseraS.setSaldoPunti(rs.getInt("saldopunti"));
        	tesseraS.setNomeIntestatario(rs.getString("nomeintestatario"));
        	tesseraS.setPuntiFrutta(rs.getInt("puntifrutta"));
        	tesseraS.setPuntiVerdura(rs.getInt("puntiverdura"));
        	tesseraS.setPuntiUova(rs.getInt("puntiuova"));
        	tesseraS.setPuntiConfezionati(rs.getInt("punticonfezionati"));
        	tesseraS.setPuntiFarinacei(rs.getInt("puntifarinacei"));
        	tesseraS.setPuntiLatticini(rs.getInt("puntilatticini"));
        	tesseraS.setCodiceCliente(rs.getString("codicecliente"));
        	punti.add(tesseraS);
        }
        rs.close();
    	return punti;
    
    }

    public void fornisciQuery(JComboBox ordina, JTable tabella) throws SQLException {
		String query = (String)ordina.getSelectedItem();
		ArrayList<TesseraPunti> punti = new ArrayList<TesseraPunti>();
		
		if(query.equalsIgnoreCase("Codice cliente")) {
			ordinaTessera = connection.prepareStatement("SELECT * FROM tesserapunti  ORDER BY codicecliente");
		}
		else if(query.equalsIgnoreCase("Nome intestatario A-Z")) {
			ordinaTessera = connection.prepareStatement("SELECT * FROM tesserapunti  ORDER BY nomeintestatario ");
		}
		else if(query.equalsIgnoreCase("Codice tessera")) {
			ordinaTessera = connection.prepareStatement("SELECT * FROM tesserapunti  ORDER BY codicetessera");
		}
		
			this.mostraTabella(tabella, this.ordinaTessera( punti));
	}
}
