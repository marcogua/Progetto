package DAOImpl;

import Classi.Frutta;
import DAO.FruttaDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class FruttaDaoImp implements FruttaDAO {
    ArrayList<Frutta> frutta;

    public FruttaDaoImp(){}

    public FruttaDaoImp(ArrayList<Frutta> frutta) {
        this.frutta = frutta;
    }

    //Ritorna tutta la Frutta
    @Override
	public ArrayList<Frutta> getAllFrutta(){
        String sql = "SELECT * FROM lista_frutta;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }
    //Modifica Frutta
    @Override
	public void updateFrutta(String descrizione, double prezzo, String codiceProdotto, double quantita,
           String provenienza, String produttoreFornitore, String unita, String dataraccolta){
        String sql = "UPDATE prodotto\n" +
                "\tSET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, \"quantità\"=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE frutta\n" +
                "\tSET dataraccolata=?, codiceprodotto=?\n" +
                "\tWHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);
            ps.setString(2, descrizione);
            ps.setDouble(3, prezzo);
            ps.setString(4, provenienza);
            ps.setString(5, produttoreFornitore);
            ps.setDouble(6, quantita);
            ps.setString(7, unita);
            ps.setString(8, codiceProdotto);
            ps.setString(9, dataraccolta);
            ps.setString(10, codiceProdotto);
            ps.setString(11, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Cancella Frutta
    @Override
	public void dalateFrutta(String codiceProdotto){
        String sql = "DELETE FROM frutta\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "DELETE FROM prodotto\n" +
                "\tWHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);
            ps.setString(2, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //Aggiunge Frutta
    @Override
	public void addFrutta(String idFrutta,  String dataraccolta){
        String sql ="INSERT INTO frutta(idfrutta, dataraccolta) VALUES (?, to_date(?,' DD MM YYYY'));";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idFrutta);
            ps.setString(2, dataraccolta);
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Frutta> getFruttaByCodiceProdotto(String codiceProdotto) {
        String sql = "SELECT * FROM lista_frutta WHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }

    public ArrayList<Frutta> getFruttaByDescrizione(String descrizione) {
        String sql = "SELECT * FROM lista_frutta WHERE descrizione iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }

    public ArrayList<Frutta> getFruttaByProduttoreFornitore(String produttoreFornitore) {
        String sql = "SELECT * FROM lista_frutta WHERE produttorefornitore iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }

    public ArrayList<Frutta> getFruttaByProvenienza(String provenienza) {
        String sql = "SELECT * FROM lista_frutta WHERE provenienza iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + provenienza + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }

    public ArrayList<Frutta> getFruttaByDataRaccolta(String dataRaccolta) {
        String sql = "SELECT * FROM lista_frutta WHERE dataraccolta=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataRaccolta);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	frutta.add(new Frutta(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return frutta;
    }

    public void modificaTabellaFrutta(JTable tabellaFrutta, ArrayList<Frutta> fruttaArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaFrutta.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<fruttaArrayList.size();i++) {
            row[0] = fruttaArrayList.get(i).getCodiceProdotto();
            row[1] = fruttaArrayList.get(i).getDescrizione();
            row[2] = fruttaArrayList.get(i).getProduttoreFornitore();
            row[3] = fruttaArrayList.get(i).getProvenienza();
            row[4] = fruttaArrayList.get(i).getData_raccolta();
            row[5] = fruttaArrayList.get(i).getQuantita();
            row[6] = fruttaArrayList.get(i).getUnita();
            row[7] = fruttaArrayList.get(i).getPrezzo();
            row[8] = fruttaArrayList.get(i).getIva();
            model.addRow(row);
        }
    }
}
