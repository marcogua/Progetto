package DAO;

import java.util.ArrayList;

import Classi.Frutta;

public interface FruttaDAO {

	//Ritorna tutta la Frutta
	ArrayList<Frutta> getAllFrutta();

	//Modifica Frutta
	void updateFrutta(String descrizione, double prezzo, String codiceProdotto, double quantita, String provenienza,
					  String produttoreFornitore, String unita, String dataraccolta);

	//Cancella Frutta
	void dalateFrutta(String codiceProdotto);

	//Aggiunge Frutta
	void addFrutta(String idFrutta, String dataraccolta);

	ArrayList<Frutta> getFruttaByCodiceProdotto(String codiceProdotto);

	ArrayList<Frutta> getFruttaByDescrizione(String descrizione);

	ArrayList<Frutta> getFruttaByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Frutta> getFruttaByProvenienza(String provenienza);

	ArrayList<Frutta> getFruttaByDataRaccolta(String dataRaccolta);
}