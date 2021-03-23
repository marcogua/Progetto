package DAOImpl;

import Classi.Cliente;
import DAO.ClienteDao;
import DbConfig.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClienteDaoImp implements ClienteDao  {
    private Connection connection;
    private PreparedStatement getAllClientPS, insertClientiPS, delateClientiPS;
    private PreparedStatement getClientiPerNome, getClientiPerCognome,getClientiPerEmail;
    private PreparedStatement getClientiPerTessera,getClientiPerCliente;
    private PreparedStatement ordinaCliente;

    public ClienteDaoImp(Connection connection) throws SQLException {
        this.connection = connection;
        getAllClientPS = connection.prepareStatement("SELECT * FROM clienti ");
        getClientiPerNome = connection.prepareStatement("SELECT * FROM clienti WHERE nome ilike ?");
        getClientiPerCognome = connection.prepareStatement("SELECT * FROM clienti WHERE cognome ilike ?");
        getClientiPerEmail = connection.prepareStatement("SELECT * FROM clienti WHERE email like ?");
        getClientiPerTessera = connection.prepareStatement("SELECT * FROM clienti WHERE codicetessera ilike ?");
        getClientiPerCliente = connection.prepareStatement("SELECT * FROM clienti WHERE codiceclienti like ?");
        insertClientiPS = connection.prepareStatement("INSERT INTO clienti VALUES (?, ?, ?, ?, ?)");
        delateClientiPS = connection.prepareStatement("DELETE FROM clienti WHERE codiceclienti like ?");
    } 
    
    public ClienteDaoImp() {}

    /**
     * Legge dalla base di dati tutte le tuple di cliente
     */
	@Override
	public ArrayList<Cliente> getAllClienti(ArrayList<Cliente> clienti) throws SQLException {
        ResultSet rs=getAllClientPS.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceclienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
	
	
	@Override
	public ArrayList<Cliente> getClientiNome(ArrayList<Cliente> clienti, String nome) throws SQLException {
		getClientiPerNome.setString(1, nome);
        ResultSet rs=getClientiPerNome.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceClienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
    
	@Override
	public ArrayList<Cliente> getClientiCognome(ArrayList<Cliente> clienti, String nome) throws SQLException {
		getClientiPerCognome.setString(1, nome);
        ResultSet rs=getClientiPerCognome.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceClienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
	
	@Override
	public ArrayList<Cliente> getClientiEmail(ArrayList<Cliente> clienti, String email) throws SQLException {
		getClientiPerEmail.setString(1, email);
        ResultSet rs=getClientiPerEmail.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceClienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
	
	@Override
	public ArrayList<Cliente> getClientiTessere(ArrayList<Cliente> clienti, String nome) throws SQLException {
		getClientiPerTessera.setString(1, nome);
        ResultSet rs=getClientiPerTessera.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceClienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
	
	@Override
	public ArrayList<Cliente> getClientiCodClienti(ArrayList<Cliente> clienti, String cliente) throws SQLException {
		getClientiPerCliente.setString(1, cliente);
        ResultSet rs=getClientiPerCliente.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente(rs.getString("codiceclienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }
	
	@Override
	public int insertCliente(Cliente clienti) throws SQLException{
		insertClientiPS.setString(1, clienti.getCodiceCliente());
		insertClientiPS.setString(2, clienti.getNome());
		insertClientiPS.setString(3, clienti.getCognome());
		insertClientiPS.setString(4, clienti.getEmail());
		insertClientiPS.setString(5, clienti.getCodiceTessera());
		int row = insertClientiPS.executeUpdate();
		return row;
    }
	
	
	@Override
	public int delateCliente(String valore) throws SQLException{
		delateClientiPS.setString(1,  valore);
		int row = delateClientiPS.executeUpdate();
		return row;
    }
	
    

	@Override
	public void addCliente(JTable tabella){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getAllClienti(clienti);
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}

		this.modificaTabella(tabella, clienti);
		
    }

	
	@Override
	public void addCliente(JTable tabella,JTextField nome ){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getClientiNome(clienti, nome.getText());
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti per"
					+ " nome: "
					+ e.getMessage());
		}

		this.modificaTabella(tabella, clienti);
		
    }
	
	@Override
	public void addClienteCognome(JTable tabella,JTextField cognome ){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getClientiCognome(clienti, cognome.getText());
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti per"
					+ " cognome: "
					+ e.getMessage());
		}
		
		this.modificaTabella(tabella, clienti);
    }
	
	@Override
	public void addClienteEmail(JTable tabella,JTextField email ){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getClientiEmail(clienti, email.getText());
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti per"
					+ " email: "
					+ e.getMessage());
		}
		
		this.modificaTabella(tabella, clienti);
		
    }
	
	@Override
	public void addClienteTessera(JTable tabella,JTextField tessera ){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getClientiTessere(clienti, tessera.getText());
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti per"
					+ " Codice tessera: "
					+ e.getMessage());
		}
		
		this.modificaTabella(tabella, clienti);
	}
	
	@Override
	public void addClientiCodClienti(JTable tabella,JTextField cli ){
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		try {
			this.getClientiCodClienti(clienti, cli.getText());
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti per"
					+ " codice cliente: "
					+ e.getMessage());
		}
		
		this.modificaTabella(tabella, clienti);
	}
	
	
	
	@Override
	public void modificaTabella(JTable tabella, ArrayList<Cliente> clienti) {
		DefaultTableModel model = (DefaultTableModel)tabella.getModel();
		model.setRowCount(0);
		Object[] row = new Object[6];
		for (int i = 0; i<clienti.size();i++) {
			row[0] = clienti.get(i).getCodiceCliente();
			row[1] = clienti.get(i).getNome();
			row[2] = clienti.get(i).getCognome();
			row[3] = clienti.get(i).getEmail();
			row[4] = clienti.get(i).getCodiceTessera();
			model.addRow(row);
		}
	}

	@Override
	public void aggiungiCliente( JTextField codicecliente, JTextField nome, JTextField cognome,JTextField email,JTextField codicetessera){
		Cliente clienti = new Cliente(codicecliente.getText(), nome.getText(), cognome.getText(), email.getText(), codicetessera.getText() );
		try {
			this.insertCliente(clienti);
		} catch (SQLException e) {
			System.out.println("Errore riscontrato nella aggiungere i clienti: "
					+ e.getMessage());
		}
		
    }
	
	public ArrayList<Cliente> ordinaClienti( ArrayList<Cliente> clienti) throws SQLException {
		ResultSet rs=ordinaCliente.executeQuery();
        while(rs.next()) {
        	Cliente  s = new Cliente();
        	s.setCodiceCliente(rs.getString("codiceclienti"));
        	s.setNome(rs.getString("nome"));
        	s.setCognome(rs.getString("cognome"));
        	s.setCodiceTessera(rs.getString("codicetessera"));
        	s.setEmail(rs.getString("email"));
        	clienti.add(s);
        }
        rs.close();
    	return clienti;
    }

	public void fornisciQuery(JComboBox ordina, JTable tabella) throws SQLException {
		String query = (String)ordina.getSelectedItem();
		ArrayList<Cliente> clienti = new ArrayList<Cliente>();
		
		if(query.equalsIgnoreCase("Codice cliente")) {
			ordinaCliente = connection.prepareStatement("SELECT * FROM clienti  ORDER BY codiceclienti");
		}
		else if(query.equalsIgnoreCase("Nome")) {
			ordinaCliente = connection.prepareStatement("SELECT * FROM clienti  ORDER BY nome ");
		}
		else if(query.equalsIgnoreCase("Cognome")) {
			ordinaCliente = connection.prepareStatement("SELECT * FROM clienti  ORDER BY cognome");
		}
		else if(query.equalsIgnoreCase("Email")) {
			ordinaCliente = connection.prepareStatement("SELECT * FROM clienti  ORDER BY email");
		}
		else if(query.equalsIgnoreCase("Codice Tessera")) {
			ordinaCliente = connection.prepareStatement("SELECT * FROM clienti  ORDER BY codiceTessera");
		}
		
			this.modificaTabella(tabella, this.ordinaClienti( clienti));
	}
	
	public String cercaCodiceCliente(String codiceTessera) {
		String sql="SELECT codiceclienti FROM clienti WHERE codicetessera=?;";
		String codiceCliente = null;
        try {
            DbConnect dbconn = DbConnect.getIstanza();
            Connection conn = dbconn.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, codiceTessera);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
				codiceCliente = rs.getString(1);
			}

            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return codiceCliente;
	}
}
