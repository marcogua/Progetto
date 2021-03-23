package DAOImpl;

import Classi.Verdura;
import DAO.VerduraDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class VerdureDaoImp implements VerduraDAO {
    ArrayList<Verdura> verdure;

    public VerdureDaoImp(){}

    public VerdureDaoImp(ArrayList<Verdura> verdure) {
        this.verdure = verdure;
    }
    @Override
	public ArrayList<Verdura> getVerdura() {
        String sql = "SELECT * FROM lista_verdura;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }
    @Override
	public void updateVerdura(String descrizione, double prezzo, String codiceProdotto, double quantita,
            String provenienza, String produttoreFornitore, String unita, String dataraccolta){
        String sql = "UPDATE prodotto\n" +
                "\tSET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, \"quantità\"=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE verdure\n" +
                "\tSET datraccolta=?, codiceprodotto=?\n" +
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
    @Override
	public void delateVerdura(String codiceProdotto){
        String sql = "DELETE FROM prodotto\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "DELETE FROM verdure\n" +
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
    @Override
	public void addVerdura(String idVerdura, String dataraccolta){
        String sql = "INSERT INTO verdure(idverdura, dataraccolta) VALUES (?, to_date(?,' DD MM YYYY'));";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idVerdura);
            ps.setString(2, dataraccolta);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public ArrayList<Verdura> getVerdureByCodiceProdotto(String codiceProdotto) {
        String sql = "SELECT * FROM lista_verdura WHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }

    public ArrayList<Verdura> getVerdureByDescrizione(String descrizione) {
        String sql = "SELECT * FROM lista_verdura WHERE descrizione iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }

    public ArrayList<Verdura> getVerdureByProduttoreFornitore(String produttoreFornitore) {
        String sql = "SELECT * FROM lista_verdura WHERE produttorefornitore iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }

    public ArrayList<Verdura> getVerdureByProvenienza(String provenienza) {
        String sql = "SELECT * FROM lista_verdura WHERE provenienza iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + provenienza + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }

    public ArrayList<Verdura> getVerdureByDataRaccolta(String dataRaccolta) {
        String sql = "SELECT * FROM lista_verdura WHERE dataraccolta=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataRaccolta);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	verdure.add(new Verdura(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return verdure;
    }

    public void modificaTabellaVerdure(JTable tabellaVerdure, ArrayList<Verdura> verdureArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaVerdure.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<verdureArrayList.size();i++) {
            row[0] = verdureArrayList.get(i).getCodiceProdotto();
            row[1] = verdureArrayList.get(i).getDescrizione();
            row[2] = verdureArrayList.get(i).getProduttoreFornitore();
            row[3] = verdureArrayList.get(i).getProvenienza();
            row[4] = verdureArrayList.get(i).getData_raccolata();
            row[5] = verdureArrayList.get(i).getQuantita();
            row[6] = verdureArrayList.get(i).getUnita();
            row[7] = verdureArrayList.get(i).getPrezzo();
            row[8] = verdureArrayList.get(i).getIva();
            model.addRow(row);
        }
    }
}
