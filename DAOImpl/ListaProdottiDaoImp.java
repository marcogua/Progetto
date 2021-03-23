package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classi.Prodotto;
import DbConfig.DbConnect;

public class ListaProdottiDaoImp {
	ArrayList<Prodotto> listaProdotti;
	
	public ListaProdottiDaoImp() {}
	
	public ListaProdottiDaoImp(ArrayList<Prodotto> listaProdotti) {
		super();
		this.listaProdotti = listaProdotti;
	}
	
	public ArrayList<Prodotto> getListaProdottiByIdLista(String idLista) {
		String sql = "SELECT * FROM listaprodotti WHERE idlista=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idLista);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	listaProdotti.add(new Prodotto(rs.getString(2), rs.getString(3), rs.getDouble(1)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return listaProdotti;
	}
	
	public void addListaProdotti(ArrayList<Prodotto> listaProdotti, String idLista) {
		String sql = "INSERT INTO listaprodotti(idlista, quantita, codiceprodotto, descrizione) VALUES (?, ?, ?, ?);";
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();
            for (Prodotto prodotto : listaProdotti) { 
            	PreparedStatement ps = conn.prepareStatement(sql);
            	ps.setString(1, idLista);
            	ps.setDouble(2, prodotto.getQuantita());
            	ps.setString(3, prodotto.getCodiceProdotto());
            	ps.setString(4, prodotto.getDescrizione());
            	ps.executeUpdate();	
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	public void modificaTabellaListaProdotti(JTable tabellaListaProdotti, ArrayList<Prodotto> listaProdottiArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaListaProdotti.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<listaProdottiArrayList.size();i++) {
            row[0] = listaProdottiArrayList.get(i).getCodiceProdotto();
            row[1] = listaProdottiArrayList.get(i).getDescrizione();
            row[2] = listaProdottiArrayList.get(i).getQuantita();
            model.addRow(row);
        }
    }
}
