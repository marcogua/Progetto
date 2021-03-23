package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.Ordine;
import Classi.Prodotto;
import DAO.OrdineDao;
import DbConfig.DbConnect;

public class OrdineDaoImp implements OrdineDao  {
	ArrayList<Ordine> ordine;
	
	public OrdineDaoImp() {}
	
	public OrdineDaoImp(ArrayList<Ordine> ordine) {
		this.ordine = ordine;
	}

	
	public ArrayList<Ordine> getAllOrdini(){
		String sql = "SELECT * FROM registrovendite;";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
			}
            
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return ordine;
	}
	
	@Override
	public void updateOrdine() {
		
	}
	
	@Override
	public void deleteOrdine(String codiceOrdine) {
		String sql = "DELETE FROM registrovendite WHERE idordine=?;";
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
	
	@Override
	public void addOrdine(Ordine ordine) {
		String sql = "INSERT INTO registrovendite(totaleordine, dataregistrazione, soldiricevuti, codicecarta, codicebancaricevente, tipopagamento, codiceclienti, idlista, idordine) VALUES (?, to_date(?,'DD MM YYYY'), ?, ?, ?, ?, ?, ?, ?);";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, ordine.getTotaleOrdine());
            ps.setString(2, ordine.getDataRegistrazione());
            ps.setDouble(3, ordine.getSoldiRicevuti());
            ps.setString(4, ordine.getCodiceCarta());
            ps.setString(5, ordine.getBancaRicevente());
            ps.setString(6, ordine.getTipoPagamento());
            ps.setString(7, ordine.getCodiceCliente());
            ps.setString(8, ordine.getIdLista());
            ps.setString(9, ordine.getNumeroOrdine());
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	
	@Override
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
	@Override
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
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
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
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
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
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
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
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
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
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
	public ArrayList<Ordine> cercaPerCodiceCliente(String codiceCliente){
		String sql = "SELECT * FROM registrovendite WHERE codiceclienti=?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceCliente);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	ordine.add(new Ordine(rs.getString(1), rs.getDouble(2), rs.getString(3), rs.getString(8),
						rs.getString(9), rs.getString(7), rs.getString(5), rs.getDouble(4), rs.getString(6)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ordine;
	}
	
	@Override
	public void modificaTabellaOrdine(JTable tabellaOrdine, ArrayList<Ordine> ordineArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaOrdine.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<ordineArrayList.size();i++) {
            row[0] = ordineArrayList.get(i).getNumeroOrdine();
            row[1] = ordineArrayList.get(i).getDataRegistrazione();
            row[2] = ordineArrayList.get(i).getTotaleOrdine();
            row[3] = ordineArrayList.get(i).getIdLista();
            row[4] = ordineArrayList.get(i).getSoldiRicevuti();
            row[5] = ordineArrayList.get(i).getCodiceCarta();
            row[6] = ordineArrayList.get(i).getBancaRicevente();
            row[7] = ordineArrayList.get(i).getTipoPagamento();
            row[8] = ordineArrayList.get(i).getCodiceCliente();
            model.addRow(row);
        }
    }
}


