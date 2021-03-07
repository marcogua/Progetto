package DAOImpl;

import Classi.Latticini;
import DAO.LatticiniDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class LatticiniDaoImp implements LatticiniDAO {
    ArrayList<Latticini> latticini;

    public LatticiniDaoImp(){}

    public LatticiniDaoImp(ArrayList<Latticini> latticini) {
        this.latticini = latticini;
    }
    @Override
	public ArrayList<Latticini> getAllLatticini() {
        String sql = "SELECT * FROM lista_latticini;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    @Override
	public void updateLatticini(String descrizione, double prezzo, String codiceProdotto, double quantita,
            String provenienza, String produttoreFornitore, String unita, String datamungitura,
            String dataproduzione, boolean senzalattosio){

        String sql = "UPDATE prodotto\n" +
                "\tSET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, \"quantità\"=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE latticini\n" +
                "\tSET datamungitura=?, dataproduzione=?, senzalattosio=?, codiceprodotto=?\n" +
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
            ps.setString(8, datamungitura);
            ps.setString(9, dataproduzione);
            ps.setBoolean(10, senzalattosio);
            ps.setString(11, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
	public void delateLatticini(String codiceProdotto){
        String sql = "DELETE FROM latticini\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "DELETE FROM prodotto\n" +
                "\tWHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,codiceProdotto);
            ps.setString(2,codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
	public void addLatticini(String idLatticini, String datamungitura, String dataproduzione, boolean senzalattosio){
        String sql =
                "INSERT INTO latticini(idlatticini, datamungitura, dataproduzione, senzalattosio) VALUES (?, to_date(?,' DD MM YYYY'), to_date(?,' DD MM YYYY'), ?)";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idLatticini);
            ps.setString(2, datamungitura);
            ps.setString(3, dataproduzione);
            ps.setBoolean(4, senzalattosio);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Latticini> getLatticiniByCodiceProdotto(String codiceProdotto) {
        String sql = "SELECT * FROM lista_latticini WHERE codiceprodotto=?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public ArrayList<Latticini> getLatticiniByDescrizione(String descrizione) {
        String sql = "SELECT * FROM lista_latticini WHERE descrizione iLIKE ?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public ArrayList<Latticini> getLatticiniByProduttoreFornitore(String produttoreFornitore) {
        String sql = "SELECT * FROM lista_latticini WHERE produttorefornitore iLIKE ?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public ArrayList<Latticini> getLatticiniByProvenienza(String provenineza) {
        String sql = "SELECT * FROM lista_latticini WHERE produttorefornitore iLIKE ?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + provenineza + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public ArrayList<Latticini> getLatticiniByDataMungitura(String dataMungitura) {
        String sql = "SELECT * FROM lista_latticini WHERE datamungitura=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataMungitura);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public ArrayList<Latticini> getLatticiniByDataProduzione(String dataProduzione) {
        String sql = "SELECT * FROM lista_latticini WHERE dataproduzione=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataProduzione);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	latticini.add(new Latticini(rs.getString(1), rs.getString(2),rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getBoolean(7),
                        rs.getDouble(8), rs.getString(9), rs.getDouble(10), rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return latticini;
    }

    public void modificaTabellaLatticini(JTable tabellaLatticini, ArrayList<Latticini> latticiniArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaLatticini.getModel();
        model.setRowCount(0);
        Object[] row = new Object[11];
        for (int i = 0; i<latticiniArrayList.size();i++) {
            row[0] = latticiniArrayList.get(i).getCodiceProdotto();
            row[1] = latticiniArrayList.get(i).getDescrizione();
            row[2] = latticiniArrayList.get(i).getProduttoreFornitore();
            row[3] = latticiniArrayList.get(i).getProvenienza();
            row[4] = latticiniArrayList.get(i).getData_mungitura();
            row[5] = latticiniArrayList.get(i).getData_produzione();
            row[6] = latticiniArrayList.get(i).isSenzaLattosio();
            row[7] = latticiniArrayList.get(i).getQuantita();
            row[8] = latticiniArrayList.get(i).getUnita();
            row[9] = latticiniArrayList.get(i).getPrezzo();
            row[10] = latticiniArrayList.get(i).getIva();
            model.addRow(row);
        }
    }

}

//codiceprodotto, descrizione, produttorefornitore, provenienza, datamungitura, dataproduzione, senzalattosio, quantità, unita, prezzo