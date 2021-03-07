package DAOImpl;

import Classi.Confezionati;
import DAO.ConfezionatiDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class ConfezionatiDaoImp implements ConfezionatiDAO {
    ArrayList<Confezionati> confezionati;

    public ConfezionatiDaoImp (){}

    public ConfezionatiDaoImp(ArrayList<Confezionati> confezionati) {
        this.confezionati = confezionati;
    }
    @Override
	public ArrayList<Confezionati> getAllConfezionati() {
        String sql = "SELECT * FROM lista_confezionati;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }
    @Override
	public void updateConfezionati(String descrizione, double prezzo, String codiceProdotto, double quantita,
            String provenienza, String produttoreFornitore, String unita, String dataconfezionameto,
            String datascadenza){
        String sql = "UPDATE prodotto\n" +
                "\tSET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, \"quantità\"=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE confezionati\n" +
                "\tSET dataconfezionamento=?, datascadenza=?, codiceprodotto=?\n" +
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
            ps.setString(9, dataconfezionameto);
            ps.setString(10, datascadenza);
            ps.setString(11, codiceProdotto);
            ps.setString(12, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
	public void delateConfezionati(String codiceProdotto){
        String sql = "DELETE FROM prodotto\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "DELETE FROM confezionati\n" +
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
	public void addConfezionati(String idConfezionati, String dataconfezionameto, String datascadenza){
        String sql ="INSERT INTO confezionati(idconfezionati, dataconfezionamento, datascadenza)VALUES (?, to_date(?,' DD MM YYYY'), to_date(?,' DD MM YYYY'));";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, idConfezionati);
            ps.setString(2, dataconfezionameto);
            ps.setString(3, datascadenza);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            System.out.println("Errore nel inserire Confezionati: " + e.getMessage());
        }
    }

    public ArrayList<Confezionati> getConfezionatiByCodiceProdotto(String codiceProdotto) {
        String sql = "SELECT * FROM lista_confezionati WHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public ArrayList<Confezionati> getConfezionatiByDescrizione(String descrizione) {
        String sql = "SELECT * FROM lista_confezionati WHERE descrizione iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public ArrayList<Confezionati> getConfezionatiByProduttoreFornitore(String produttoreFornitore) {
        String sql = "SELECT * FROM lista_confezionati WHERE descrizione iLIKE ?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public ArrayList<Confezionati> getConfezionatiByProvenienza(String provenienza) {
        String sql = "SELECT * FROM lista_confezionati WHERE descrizione iLIKE ?";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + provenienza + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public ArrayList<Confezionati> getConfezionatiByDataConfezionamento(String dataConfezionamento) {
        String sql = "SELECT * FROM lista_confezionati WHERE dataconfezionamento=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataConfezionamento);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public ArrayList<Confezionati> getConfezionatiByDataScadenza(String dataScadenza) {
        String sql = "SELECT * FROM lista_confezionati WHERE datascadenza=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataScadenza);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	confezionati.add(new Confezionati(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7),
                        rs.getString(8),rs.getDouble(9), rs.getString(10)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return confezionati;
    }

    public void modificaTabellaConfezionati(JTable tabellaConfezionati, ArrayList<Confezionati> confezionatiArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaConfezionati.getModel();
        model.setRowCount(0);
        Object[] row = new Object[10];
        for (int i = 0; i<confezionatiArrayList.size();i++) {
            row[0] = confezionatiArrayList.get(i).getCodiceProdotto();
            row[1] = confezionatiArrayList.get(i).getDescrizione();
            row[2] = confezionatiArrayList.get(i).getProduttoreFornitore();
            row[3] = confezionatiArrayList.get(i).getProvenienza();
            row[4] = confezionatiArrayList.get(i).getData_confezionamento();
            row[5] = confezionatiArrayList.get(i).getData_scadenza();
            row[6] = confezionatiArrayList.get(i).getQuantita();
            row[7] = confezionatiArrayList.get(i).getUnita();
            row[8] = confezionatiArrayList.get(i).getPrezzo();
            row[9] = confezionatiArrayList.get(i).getIva();
            model.addRow(row);
        }
    }
}
