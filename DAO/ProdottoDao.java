package DAO;

import Classi.Prodotto;

public interface ProdottoDao {

	Prodotto getProdottoByCodiceProdotto(String codiceProdotto);

	void updateProdotto(Prodotto prodotto);

}