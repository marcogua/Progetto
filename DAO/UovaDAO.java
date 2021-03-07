package DAO;

import java.util.ArrayList;

import Classi.Uova;

public interface UovaDAO {

	ArrayList<Uova> getAllUova();

	void updateUova(String descrizione, double prezzo, String codiceProdotto, double quantita,
					String provenienza, String produttoreFornitore, String unita, String data_confezionamento,
					String categoriaUova, String classePeso);

	void delateUova(String codiceProdotto);

	void addUova( String codiceProdotto,String data_confezionamento, String categoriaUova, String classePeso);

	ArrayList<Uova> getUovaByCodiceProdotto(String codiceProdotto);

	ArrayList<Uova> getUovaByDescrizione(String descrizione);

	ArrayList<Uova> getUovaByProduttoreFornitore(String produttoreFornitore);

	ArrayList<Uova> getUovaByProvenienza(String provenienza);

	ArrayList<Uova> getUovaByDataConfezionamento(String dataConfezionamento);

	ArrayList<Uova> getUovaByCategoriaUova(String categoriaUova);

	ArrayList<Uova> getUovaByClassePeso(String classePeso);
}