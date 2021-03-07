package Classi;

import java.util.ArrayList;

public class ListaProdotti {
		String idLista;
	ArrayList<Prodotto> listaProdotti;
	
	
	
	public ListaProdotti(String idLista, ArrayList<Prodotto> listaProdotti) {
		super();
		this.idLista = idLista;
		this.listaProdotti = listaProdotti;
	}



	public String getIdLista() {
		return idLista;
	}



	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}



	public ArrayList<Prodotto> getListaProdotti() {
		return listaProdotti;
	}



	public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}
	
	
}
