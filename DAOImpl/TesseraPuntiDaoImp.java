package DAOImpl;

import Classi.TesseraPunti;
import DAO.TesseraPuntiDAO;
import DbConfig.DbConnect;

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
	 
	 public TesseraPuntiDaoImp() {}

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
		insertTessere.setDouble(4, tesseraP.getPuntiFrutta());
		insertTessere.setDouble(5, tesseraP.getPuntiVerdura());
		insertTessere.setDouble(6, tesseraP.getPuntiUova());
		insertTessere.setDouble(7, tesseraP.getPuntiConfezionati());
		insertTessere.setDouble(8, tesseraP.getPuntiFarinacei());
		insertTessere.setDouble(9, tesseraP.getPuntiLatticini());
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
    
    public TesseraPunti cercaTesseraPuntiPerCodiceTessera(String codiceTessera) {
    	TesseraPunti tesseraPunti = new TesseraPunti();
    	String sql = "SELECT * FROM tesserapunti WHERE codicetessera=?;";
    	 try {
             DbConnect dbconn = DbConnect.getIstanza();
             Connection conn = dbconn.getConnection();

             PreparedStatement ps = conn.prepareStatement(sql);

             ps.setString(1, codiceTessera);

             ResultSet rs = ps.executeQuery();
             
             while (rs.next()) {
				tesseraPunti.setCodiceTessera(rs.getString(1));
				tesseraPunti.setSaldoPunti(rs.getInt(2));
				tesseraPunti.setNomeIntestatario(rs.getString(3));
				tesseraPunti.setPuntiFrutta(rs.getDouble(4));
				tesseraPunti.setPuntiVerdura(rs.getDouble(5));
				tesseraPunti.setPuntiUova(rs.getDouble(6));
				tesseraPunti.setPuntiConfezionati(rs.getDouble(7));
				tesseraPunti.setPuntiFarinacei(rs.getDouble(8));
				tesseraPunti.setPuntiLatticini(rs.getDouble(9));
				tesseraPunti.setCodiceCliente(rs.getString(10));
			}

             conn.close();
         } catch (SQLException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
    	return tesseraPunti;
    }
    
    public void updateTesseraPunti(TesseraPunti tesseraPunti) {
    	String sql = "UPDATE tesserapunti SET codicetessera=?, saldopunti=?, nomeintestatario=?, puntifrutta=?, puntiverdura=?, puntiuova=?, punticonfezionati=?, puntifarinacei=?, puntilatticini=?, codicecliente=? WHERE codicetessera=?;";
    	try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, tesseraPunti.getCodiceTessera());
            ps.setInt(2, tesseraPunti.getSaldoPunti());
            ps.setString(3, tesseraPunti.getNomeIntestatario());
            ps.setDouble(4, tesseraPunti.getPuntiFrutta());
            ps.setDouble(5, tesseraPunti.getPuntiVerdura());
            ps.setDouble(6, tesseraPunti.getPuntiUova());
            ps.setDouble(7, tesseraPunti.getPuntiConfezionati());
            ps.setDouble(8, tesseraPunti.getPuntiFarinacei());
            ps.setDouble(9, tesseraPunti.getPuntiLatticini());
            ps.setString(10, tesseraPunti.getCodiceCliente());
            ps.setString(11, tesseraPunti.getCodiceTessera());

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
