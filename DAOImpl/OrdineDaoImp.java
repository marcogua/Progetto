package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.Carta;
import Classi.Contanti;
import Classi.Frutta;
import Classi.Ordine;
import Classi.Prodotto;
import DbConfig.DbConnect;

public class OrdineDaoImp {
	ArrayList<Ordine> ordine;
	
	public OrdineDaoImp() {}
	
	public ArrayList<Ordine> getAllOrdini(){
		String sql = "SELECT * FROM registrovendite;";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
				ordine.add(new Ordine());
			}
            
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return ordine;
	}
	
	public void updateOrdine() {
		
	}
	
	public void deleteOrdine(String codiceOrdine) {
		String sql = "DELETE FROM registrovendite WHERE numeroordine=?;";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceOrdine);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void addOrdineCarta(Ordine ordine, String idOrdine, String idLista, Carta carta) {
		String sql = "INSERT INTO registrovendite(totaleordine, dataregistrazione, soldiricevuti, codicecarta, codicebancaricevente, tipopagamento, codiceclienti, idlista, idorinde) VALUES (?, to_date(?,'DD MM YYYY'), ?, ?, ?, ?, ?, ?, ?);";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ordine.getTotaleOrdine());
            ps.setString(2, ordine.getDataRegistrazione());
            ps.setInt(3, 0);
            ps.setString(4, carta.getCodiceCarta());
            ps.setString(5, carta.getCodiceBancaRicevente());
            ps.setString(6, "CARTA");
            ps.setString(7, ordine.getCodiceCliente());
            ps.setString(8, idLista);
            ps.setString(9, idOrdine);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void addOrdineContanti(Ordine ordine, String idOrdine, String idLista, Contanti contanti) {
		String sql = "INSERT INTO registrovendite(totaleordine, dataregistrazione, soldiricevuti, codicecarta, codicebancaricevente, tipopagamento, codiceclienti, idlista, idorinde) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ordine.getTotaleOrdine());
            ps.setString(2, ordine.getDataRegistrazione());
            ps.setDouble(3, contanti.getSoldiRicevuti());
            ps.setString(4, null);
            ps.setString(5, null);
            ps.setString(6, "CONTANTI");
            ps.setString(7, ordine.getCodiceCliente());
            ps.setString(8, idLista);
            ps.setString(9, idOrdine);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void addListaProdotti(ArrayList <Prodotto> listaProdotti, String idLista) {
		String sql = "INSERT INTO listaprodotti(idlista, quantita, codiceprodotto) VALUES (?, ?, ?);";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();
            for (Prodotto prodotto : listaProdotti) { 
            	PreparedStatement ps = conn.prepareStatement(sql);
            	ps.setString(1, idLista);
            	ps.setDouble(2, prodotto.getQuantita());
            	ps.setString(3, prodotto.getCodiceProdotto());
            	ps.executeUpdate();	
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	/* ------------------------------------------------------------ */
	public ArrayList<Ordine> cercaPerIdOrdine(String idOrdine) {
		String sql = "SELECT * FROM registrovendite WHERE idordine=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idOrdine);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public ArrayList<Ordine> cercaPerIdLista(String idLista) {
		String sql = "SELECT * FROM registrovendite WHERE idlista=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idLista);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public ArrayList<Ordine> cercaPerCodiceCarta(String codiceCarta) {
		String sql = "SELECT * FROM registrovendite WHERE codicecarta=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceCarta);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public ArrayList<Ordine> cercaPerTotaleOrdine(String totaleOrdine){
		String sql = "SELECT * FROM registrovendite WHERE totaleordine=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, totaleOrdine);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public ArrayList<Ordine> cercaPerDataRegistrazione(String dataRegistrazione){
		String sql = "SELECT * FROM registrovendite WHERE dataregistrazione=to_date(?,'DD MM YYYY');";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataRegistrazione);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public ArrayList<Ordine> cercaPerCodiceCliente(String codiceCliente){
		String sql = "SELECT * FROM registrovendite WHERE codiceCliente=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceCliente);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine());
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	public void modificaTabellaOrdine(JTable tabellaOrdine, ArrayList<Ordine> ordineArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaOrdine.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<ordineArrayList.size();i++) {
            row[0] = ordineArrayList.get(i).getNumeroOrdine();
            row[1] = ordineArrayList.get(i).getIdLista();
            row[2] = ordineArrayList.get(i).getCodiceCliente();
           // row[3] = ordineArrayList.get(i).getd
            model.addRow(row);
        }
    }
}


