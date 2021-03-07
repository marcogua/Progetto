package DAOImpl;

import Classi.Prodotto;
import Classi.RegistroVendite;
import DAO.RegistoVenditeDAO;
import DbConfig.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class RegistroVenditeDaoImp implements RegistoVenditeDAO {
    ArrayList<RegistroVendite> registroVendite;

    public RegistroVenditeDaoImp(ArrayList<RegistroVendite> registroVendite) {
        this.registroVendite = registroVendite;
    }

    @Override
	public ArrayList<RegistroVendite> getAllRegistroVendite() {
        return registroVendite;
    }

    
	@Override
	public void updateRegistroVendite(){

    }

    
	@Override
	public void delateRegistroVendite(){

    }

    
	@Override
	public void addRegistroVendite(RegistroVendite o1){
		String sql = "INSERT INTO listaprodotti(idlist, descrizione, quantita, codiceprodotto)	VALUES (?, ?, ?, ?);";
		ArrayList<Prodotto> tmp = new ArrayList<Prodotto>();
		tmp = o1.getListaProdotti();
		for (Prodotto prodotto : tmp) {
			try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(0, o1.getNumeroOrdine());
            ps.setString(1, prodotto.getDescrizione());
            ps.setString(2, prodotto.getDescrizione());

            ps.executeUpdate();

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		}
        
    }
}
