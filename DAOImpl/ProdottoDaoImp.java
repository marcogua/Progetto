package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Classi.Prodotto;
import DAO.ProdottoDao;
import DbConfig.DbConnect;

public class ProdottoDaoImp implements ProdottoDao {
	
	public ProdottoDaoImp() {}
	
	@Override
	public Prodotto getProdottoByCodiceProdotto(String codiceProdotto) {
		Prodotto prodotto = new Prodotto();
		String sql = "SELECT * FROM prodotto WHERE codiceprodotto=?;";
		
		try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, codiceProdotto);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				prodotto.setCodiceProdotto(rs.getString(1));
				prodotto.setDescrizione(rs.getString(2));
				prodotto.setPrezzo(rs.getDouble(3));
				prodotto.setProvenienza(rs.getString(4));
				prodotto.setProduttoreFornitore(rs.getString(5));
				prodotto.setQuantita(rs.getDouble(6));
				prodotto.setUnita(rs.getString(7));
				prodotto.setIva(rs.getString(8));
			}

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return prodotto;
	}
	
	@Override
	public void updateProdotto(Prodotto prodotto) {
		String sql = "UPDATE prodotto	SET codiceprodotto=?, descrizione=?, prezzo=?, provenienza=?, produttorefornitore=?, quantita=?, unita=?, iva=? WHERE codiceprodotto=?;";
    	try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, prodotto.getCodiceProdotto());
            ps.setString(2, prodotto.getDescrizione());
            ps.setDouble(3, prodotto.getPrezzo());
            ps.setString(4, prodotto.getProvenienza());
            ps.setString(5, prodotto.getProduttoreFornitore());
            ps.setDouble(6, prodotto.getQuantita());
            ps.setString(7, prodotto.getUnita());
            ps.setString(8, prodotto.getIva());
            ps.setString(9, prodotto.getCodiceProdotto());
            
            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
