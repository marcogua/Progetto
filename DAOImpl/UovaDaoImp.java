package DAOImpl;

import Classi.Uova;
import DAO.UovaDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class UovaDaoImp implements UovaDAO {
    ArrayList<Uova> uova;

    public UovaDaoImp(ArrayList<Uova> uova) {
        this.uova = uova;
    }

    public UovaDaoImp() {
    }

    @Override
	public ArrayList<Uova> getAllUova() {
        String sql = "SELECT * FROM lista_uova;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }
    @Override
	public void updateUova(String descrizione, double prezzo, String codiceProdotto, double quantita,
                           String provenienza, String produttoreFornitore, String unita, String data_confezionamento,
                           String categoriaUova, String classePeso){
        String sql = "UPDATE prodotto\n" +
                "\tSET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, quantita=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE uova\n" +
                "\tSET dataconfeionamento=?, categoriauova=?, classepeso=?, codiceprodotto=?\n" +
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
            ps.setString(9, data_confezionamento);
            ps.setString(10, categoriaUova);
            ps.setString(11, categoriaUova);
            ps.setString(12, categoriaUova);
            ps.setString(13, codiceProdotto);
            ps.setString(14, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    @Override
	public void delateUova(String codiceProdotto){
        String sql = "DELETE FROM prodotto\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "DELETE FROM uova\n" +
                "\tWHERE codiceprodotto=?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);
            ps.setString(2, codiceProdotto);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
	public void addUova(String codiceProdotto, String data_confezionamento, String categoriaUova, String classePeso){
        String sql = "INSERT INTO uova(iduova, dataconfezionamento, categoriauova, classepeso) VALUES (?, to_date(?,' DD MM  YYYY'), ?, ?)";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);
            ps.setString(2, data_confezionamento);
            ps.setString(3, categoriaUova);
            ps.setString(4, classePeso);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public ArrayList<Uova> getUovaByCodiceProdotto(String codiceProdotto){
        String sql = "SELECT * FROM lista_uova WHERE codiceprodotto=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByDescrizione(String descrizione) {
        String sql = "SELECT * FROM lista_uova WHERE descrizione iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByProduttoreFornitore(String produttoreFornitore) {
        String sql="SELECT * FROM lista_uova WHERE produttorefornitore iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByProvenienza(String provenienza) {
        String sql="SELECT * FROM lista_uova WHERE provenienza iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + provenienza + "%");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByDataConfezionamento(String dataConfezionamento) {
        String sql="SELECT * FROM lista_uova WHERE dataconfezionamento=?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dataConfezionamento);

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByCategoriaUova(String categoriaUova) {
        String sql="SELECT * FROM lista_uova WHERE caterogiauova iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + categoriaUova + "%");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public ArrayList<Uova> getUovaByClassePeso(String classePeso) {
        String sql="SELECT * FROM lista_uova WHERE classepeso iLIKE ?;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + classePeso + "%");

            ResultSet rs = ps.executeQuery(sql);

            while (rs.next())
            {
            	uova.add(new Uova(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6),
                        rs.getString(7),rs.getDouble(8), rs.getString(9), rs.getDouble(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return uova;
    }

    public void modificaTabellaUova(JTable tabellaUova, ArrayList<Uova> uovaArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaUova.getModel();
        model.setRowCount(0);
        Object[] row = new Object[11];
        for (int i = 0; i<uovaArrayList.size();i++) {
            row[0] = uovaArrayList.get(i).getCodiceProdotto();
            row[1] = uovaArrayList.get(i).getDescrizione();
            row[2] = uovaArrayList.get(i).getProduttoreFornitore();
            row[3] = uovaArrayList.get(i).getProvenienza();
            row[4] = uovaArrayList.get(i).getData_confezionamento();
            row[5] = uovaArrayList.get(i).getCategoriaUova();
            row[6] = uovaArrayList.get(i).getClassePeso();
            row[7] = uovaArrayList.get(i).getQuantita();
            row[8] = uovaArrayList.get(i).getUnita();
            row[9] = uovaArrayList.get(i).getPrezzo();
            row[10] = uovaArrayList.get(i).getIva();
            model.addRow(row);
        }
    }
}