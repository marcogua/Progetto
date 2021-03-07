package Interfaccie;

public interface ProdottoInterface {

	String getDescrizione();

	/**
	 * 
	 * @param descrizione
	 */
	void setDescrizione(String descrizione);

	double getPrezzo();

	/**
	 * 
	 * @param prezzo
	 */
	void setPrezzo(double prezzo);

	String getCodiceProdotto();

	/**
	 * 
	 * @param codiceProdotto
	 */
	void setCodiceProdotto(String codiceProdotto);

	double getQuantita();

	/**
	 * 
	 * @param quantita
	 */
	void setQuantita(double quantita);

	String getProvenienza();

	/**
	 * 
	 * @param provenienza
	 */
	void setProvenienza(String provenienza);

	String getProduttoreFornitore();

	/**
	 * 
	 * @param produttoreFornitore
	 */
	void setProduttoreFornitore(String produttoreFornitore);

}