package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import Classi.Cliente;

public interface ClienteDao {

	/**
	 *
	 * @param clienti
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getAllClienti(ArrayList<Cliente> clienti) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getClientiNome(ArrayList<Cliente> clienti, String nome) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getClientiCognome(ArrayList<Cliente> clienti, String nome) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @param email
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getClientiEmail(ArrayList<Cliente> clienti, String email) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @param nome
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getClientiTessere(ArrayList<Cliente> clienti, String nome) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @param cliente
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> getClientiCodClienti(ArrayList<Cliente> clienti, String cliente) throws SQLException;

	/**
	 *
	 * @param clienti
	 * @return
	 * @throws SQLException
	 */
	int insertCliente(Cliente clienti) throws SQLException;

	/**
	 *
	 * @param valore
	 * @return
	 * @throws SQLException
	 */
	int delateCliente(String valore) throws SQLException;

	/**
	 *
	 * @param tabella
	 */
	void addCliente(JTable tabella);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void addCliente(JTable tabella, JTextField nome);

	/**
	 *
	 * @param tabella
	 * @param cognome
	 */
	void addClienteCognome(JTable tabella, JTextField cognome);

	/**
	 *
	 * @param tabella
	 * @param email
	 */
	void addClienteEmail(JTable tabella, JTextField email);

	/**
	 *
	 * @param tabella
	 * @param tessera
	 */
	void addClienteTessera(JTable tabella, JTextField tessera);

	/**
	 *
	 * @param tabella
	 * @param cli
	 */
	void addClientiCodClienti(JTable tabella, JTextField cli);

	/**
	 *
	 * @param tabella
	 * @param clienti
	 */
	void modificaTabella(JTable tabella, ArrayList<Cliente> clienti);

	/**
	 *
	 * @param codicecliente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param codicetessera
	 */
	void aggiungiCliente(JTextField codicecliente, JTextField nome, JTextField cognome, JTextField email,
			JTextField codicetessera);

	/**
	 *
	 * @param ordina
	 * @param tabella
	 * @throws SQLException
	 */
	void fornisciQuery(JComboBox ordina, JTable tabella) throws SQLException ;

	/**
	 *
	 * @param clienti
	 * @return
	 * @throws SQLException
	 */
	ArrayList<Cliente> ordinaClienti( ArrayList<Cliente> clienti) throws SQLException;


}