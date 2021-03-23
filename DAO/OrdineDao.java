package DAO;

import java.util.ArrayList;

import javax.swing.JTable;

import Classi.Ordine;
import Classi.Prodotto;

public interface OrdineDao {

	ArrayList<Ordine> getAllOrdini();

	void updateOrdine();

	void deleteOrdine(String codiceOrdine);

	void addOrdine(Ordine ordine);

	void addListaProdotti(ArrayList<Prodotto> listaProdotti, String idLista);

	/* ------------------------------------------------------------ */
	ArrayList<Ordine> cercaPerIdOrdine(String idOrdine);

	ArrayList<Ordine> cercaPerIdLista(String idLista);

	ArrayList<Ordine> cercaPerCodiceCarta(String codiceCarta);

	ArrayList<Ordine> cercaPerTotaleOrdine(String totaleOrdine);

	ArrayList<Ordine> cercaPerDataRegistrazione(String dataRegistrazione);

	ArrayList<Ordine> cercaPerCodiceCliente(String codiceCliente);

	void modificaTabellaOrdine(JTable tabellaOrdine, ArrayList<Ordine> ordineArrayList);

}