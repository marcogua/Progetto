package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

import Classi.TesseraPunti;

public interface TesseraPuntiDAO {

	ArrayList<TesseraPunti> getAllTesseraPunti(ArrayList<TesseraPunti> punti) throws SQLException;
	
	/**
	 * 
	 * @param tesseraP
	 * @return
	 * @throws SQLException
	 */
	int insertTesseraPS(TesseraPunti tesseraP) throws SQLException;
	
	/**
	 * 
	 * @param codiceCliente
	 * @param codiceTessera
	 * @param nome
	 */
	void creaTessera(JTextField codiceCliente, JTextField codiceTessera, JTextField nome);
	
	/**
	 * 
	 * @param tabella
	 * @throws SQLException
	 */
	void mostraTessera(JTable tabella) throws SQLException;
	
	/**
	 * 
	 * @param tabella
	 * @param punti
	 */
	void mostraTabella(JTable tabella, ArrayList<TesseraPunti> punti);
	
	/**
	 * 
	 * @param valore
	 * @return
	 * @throws SQLException
	 */
	int delateTessera(String valore) throws SQLException;

	/**
	 *
	 * @param tabella
	 * @param text
	 */
	void mostraTesseraPreNome(JTable tabella, String text);

	/**
	 *
	 * @param tabella
	 * @param codicecliente
	 */
	void mostraTesseraPreClienti(JTable tabella, String codicecliente);

	/**
	 *
	 * @param tabella
	 * @param codicetessera
	 */
	void mostraTesseraPreTessera(JTable tabella, String codicetessera);

	/**
	 *
	 * @param ordina
	 * @param tabella
	 * @throws SQLException
	 */
	void fornisciQuery(JComboBox ordina, JTable tabella) throws SQLException;

	/**
	 *
	 * @param punti
	 * @return
	 * @throws SQLException
	 */
	ArrayList<TesseraPunti> ordinaTessera( ArrayList<TesseraPunti> punti) throws SQLException;

}