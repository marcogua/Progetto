package DAO;

import java.util.ArrayList;
import java.util.List;

import Classi.Latticini;

public interface LatticiniDAO {

	List<Classi.Latticini> getAllLatticini();

	void updateLatticini(String descrizione, double prezzo, String codiceProdotto, double quantita,
						 String provenienza, String produttoreFornitore, String unita, String datamungitura,
						 String dataproduzione, boolean senzalattosio);

	void delateLatticini(String codiceProdotto);

	void addLatticini(String idLatticini, String datamungitura, String dataproduzione, boolean senzalattosio);

	ArrayList<Latticini> getLatticiniByCodiceProdotto(String codiceProdotto);

	ArrayList<Latticini> getLatticiniByDescrizione(String descrizione);

	ArrayList<Latticini> getLatticiniByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Latticini> getLatticiniByProvenienza(String provenineza);

	ArrayList<Latticini> getLatticiniByDataMungitura(String dataMungitura);

	ArrayList<Latticini> getLatticiniByDataProduzione(String dataProduzione);
}