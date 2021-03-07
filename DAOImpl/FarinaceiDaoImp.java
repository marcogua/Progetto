package DAOImpl;

import Classi.Farinacei;
import DAO.FarinaceiDAO;
import DbConfig.DbConnect;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;

public class FarinaceiDaoImp implements FarinaceiDAO {
    ArrayList<Farinacei> farinacei;

    public FarinaceiDaoImp(){}

    public FarinaceiDaoImp(ArrayList<Farinacei> farinacei) {
        this.farinacei = farinacei;
    }
    @Override
	public ArrayList<Farinacei> getAllFarinacei() {
        String sql = "SELECT * FROM lista_farinacei;";
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("Selezione tutti i Farinacei errata");
            e.printStackTrace();
        }
        return farinacei;
    }
    @Override
	public void updateFarinacei(String descrizione, double prezzo, String codiceProdotto, double quantita, String provenienza, String produttoreFornitore, String unita, String datascadenza) {
        String sql = "UPDATE prodotto\n" +
                "\tSET  descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, \"quantità\"=?, unita=?\n" +
                "\tWHERE codiceprodotto=?;\n" +
                "UPDATE farinacei\n" +
                "\tSET datascadenza=?\n" +
                "\tWHERE codiceprodotto=?;";
        try {
        DbConnect dbconn = DbConnect.getIstanza();
        Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, descrizione);
            ps.setDouble(2,prezzo);
            ps.setString(3, provenienza);
            ps.setString(4,produttoreFornitore);
            ps.setDouble(5, quantita);
            ps.setString(6, unita);
            ps.setString(7, codiceProdotto);
            ps.setString(8, datascadenza);
            ps.setString(9, codiceProdotto);

            ps.executeUpdate();

        conn.close();
        } catch (SQLException throwables) {
        	System.out.println("Update Farinacei errata");
            throwables.printStackTrace();
        }
    }
    @Override
	public void delateFarinacei(String codiceProdotto){
        String sql = "DELETE FROM farinacei\n" +
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
	public void addFarinacei(String idFarinacei, String datascadenza){
        String sql = "INSERT INTO farinacei(idfarinacei, datascadenza) VALUES (?, to_date(?,' DD MM YYYY'))";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idFarinacei);
            ps.setString(2, datascadenza);

            ps.executeUpdate();

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Farinacei> getFarinaceiByCodiceProdotto(String codiceProdotto) {
        String sql = "SELECT * FROM lista_farinacei WHERE codiceprodotto=?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codiceProdotto);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return farinacei;
    }

    public ArrayList<Farinacei> getFarinaceiByDescrizione(String descrizione) {
        String sql = "SELECT *" +
                "FROM lista_farinacei" +
                "WHERE descrizione iLIKE ?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + descrizione + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return farinacei;
    }

    public ArrayList<Farinacei> getFarinaceiByProduttoreFornitore(String produttoreFornitore) {
        String sql = "SELECT * FROM lista_farinacei WHERE produttorefornitore iLIKE ?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + produttoreFornitore + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return farinacei;
    }

    public ArrayList<Farinacei> getFarinaceiByProvenienza(String provenienza) {
        String sql = "SELECT * FROM lista_farinacei WHERE descrizione iLIKE ?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + provenienza + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return farinacei;
    }

    public ArrayList<Farinacei> getFarinaceiByDataScadenza(String dataScadenza) {
        String sql = "SELECT * FROM lista_farinacei WHERE datascadenza=?;";

        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dataScadenza);

            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
            	farinacei.add(new Farinacei(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getDouble(6),
                        rs.getString(7), rs.getDouble(8), rs.getString(9)));
            }

            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return farinacei;
    }

    public void modificaTabellaFarinacei(JTable tabellaFarinacei, ArrayList<Farinacei> farinaceiArrayList) {
        DefaultTableModel model = (DefaultTableModel)tabellaFarinacei.getModel();
        model.setRowCount(0);
        Object[] row = new Object[9];
        for (int i = 0; i<farinaceiArrayList.size();i++) {
            row[0] = farinaceiArrayList.get(i).getCodiceProdotto();
            row[1] = farinaceiArrayList.get(i).getDescrizione();
            row[2] = farinaceiArrayList.get(i).getProduttoreFornitore();
            row[3] = farinaceiArrayList.get(i).getProvenienza();
            row[4] = farinaceiArrayList.get(i).getData_scadenza();
            row[5] = farinaceiArrayList.get(i).getQuantita();
            row[6] = farinaceiArrayList.get(i).getUnita();
            row[7] = farinaceiArrayList.get(i).getPrezzo();
            row[8] = farinaceiArrayList.get(i).getIva();
            model.addRow(row);
        }
    }
}
