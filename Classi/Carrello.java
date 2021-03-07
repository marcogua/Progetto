package Classi;

import java.util.ArrayList;

public class Carrello {
    private ArrayList<Prodotto> listaProdotti;

    public Carrello(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public void AggiungiProdotto(Prodotto prodotto){
    	listaProdotti.add(prodotto);
    }

    public void RimuoviProdotto(Prodotto prodotto){
    	listaProdotti.add(prodotto);
    }

    public void SvuotaCarello(){
    	listaProdotti.removeAll(listaProdotti);
    }
}
