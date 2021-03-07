package DAO;

import java.util.ArrayList;

import Classi.Verdura;

public interface VerduraDAO {

	ArrayList<Verdura> getVerdura();

	void updateVerdura(String descrizione, double prezzo, String codiceProdotto, double quantita,
					   String provenienza, String produttoreFornitore, String unita, String dataraccolta);

	void delateVerdura(String codiceProdotto);

	void addVerdura(String idVerdura, String dataraccolta);

	ArrayList<Verdura> getVerdureByCodiceProdotto(String codiceProdotto);

	ArrayList<Verdura> getVerdureByDescrizione(String descrizione);

	ArrayList<Verdura> getVerdureByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Verdura> getVerdureByProvenienza(String provenienza);

	ArrayList<Verdura> getVerdureByDataRaccolta(String dataRaccolta);
}