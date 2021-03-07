package Interfaccie;

public interface ClienteInterface {

	/**
	 * 
	 * @return Codice Cliente
	 */
	String getCodiceCliente();

	/**
	 * 
	 * @param codiceCliente
	 */
	void setCodiceCliente(String codiceCliente);

	/**
	 * 
	 * @return Nome cliente
	 */
	String getNome();

	/**
	 * 
	 * @param nome
	 */
	void setNome(String nome);

	/**
	 * 
	 * @return Cognome cliente
	 */
	String getCognome();

	/**
	 * 
	 * @param cognome
	 */
	void setCognome(String cognome);

	/**
	 * 
	 * @return Codice Tessera cliente
	 */
	String getCodiceTessera();

	/**
	 * 
	 * @param codiceTessera
	 */
	void setCodiceTessera(String codiceTessera);

	/**
	 * 
	 * @return email cliente
	 */
	String getEmail();

	/**
	 * 
	 * @param email
	 */
	void setEmail(String email);

}