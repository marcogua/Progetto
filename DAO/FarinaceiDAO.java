package DAO;

import java.util.ArrayList;

import Classi.Farinacei;

public interface FarinaceiDAO {

	ArrayList<Farinacei> getAllFarinacei();

	void updateFarinacei(String descrizione, double prezzo, String codiceProdotto, double quantita, String provenienza, String produttoreFornitore, String unita, String datascadenza);

	void delateFarinacei(String codiceProdotto);

	void addFarinacei(String idFarinacei, String datascadenza);

	ArrayList<Farinacei> getFarinaceiByCodiceProdotto(String codiceProdotto);

	ArrayList<Farinacei> getFarinaceiByDescrizione(String descrizione);

	ArrayList<Farinacei> getFarinaceiByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Farinacei> getFarinaceiByProvenienza(String provenienza);

	ArrayList<Farinacei> getFarinaceiByDataScadenza(String dataScadenza);
}