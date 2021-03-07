package DAO;

import java.util.ArrayList;

import Classi.Confezionati;

public interface ConfezionatiDAO {

	ArrayList<Confezionati> getAllConfezionati();

	void updateConfezionati(String descrizione, double prezzo, String codiceProdotto, double quantita,
							String provenienza, String produttoreFornitore, String unita,
							String dataconfezionameto, String datascadenza);

	void delateConfezionati(String codiceProdotto);

	void addConfezionati(String idConfezionati, String dataconfezionameto, String datascadenza);

	ArrayList<Confezionati> getConfezionatiByCodiceProdotto(String codiceProdotto);

	ArrayList<Confezionati> getConfezionatiByDescrizione(String descrizione);

	ArrayList<Confezionati> getConfezionatiByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Confezionati> getConfezionatiByProvenienza(String provenienza);

	ArrayList<Confezionati> getConfezionatiByDataConfezionamento(String dataConfezionamento);

	ArrayList<Confezionati> getConfezionatiByDataScadenza(String dataScadenza);
}