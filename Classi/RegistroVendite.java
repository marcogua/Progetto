package Classi;

import java.util.ArrayList;

public class RegistroVendite {
    private String numeroOrdine;
    private ArrayList<Prodotto> listaProdotti;
    private double totaleOrdine;
    private String dataRegistrazione;
    private double soldiRicevuti;
    private String codiceCarta;
    private String bancaRicevente;

    private enum tipoPagamento {CONTANTI, CARTA};

    public RegistroVendite(String numeroOrdine, ArrayList<Prodotto> listaProdotti, double totaleOrdine, String dataRegistrazione, double soldiRicevuti, String codiceCarta, String bancaRicevente) {
        this.numeroOrdine = numeroOrdine;
        this.listaProdotti = listaProdotti;
        this.totaleOrdine = totaleOrdine;
        this.dataRegistrazione = dataRegistrazione;
        this.soldiRicevuti = soldiRicevuti;
        this.codiceCarta = codiceCarta;
        this.bancaRicevente = bancaRicevente;
    }

    public String getNumeroOrdine() {
        return numeroOrdine;
    }

    public void setNumeroOrdine(String numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
    }

    public ArrayList<Prodotto> getListaProdotti() {
        return listaProdotti;
    }

    public void setListaProdotti(ArrayList<Prodotto> listaProdotti) {
        this.listaProdotti = listaProdotti;
    }

    public double getTotaleOrdine() {
        return totaleOrdine;
    }

    public void setTotaleOrdine(double totaleOrdine) {
        this.totaleOrdine = totaleOrdine;
    }

    public String getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(String dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }

    public double getSoldiRicevuti() {
        return soldiRicevuti;
    }

    public void setSoldiRicevuti(double soldiRicevuti) {
        this.soldiRicevuti = soldiRicevuti;
    }

    public String getCodiceCarta() {
        return codiceCarta;
    }

    public void setCodiceCarta(String codiceCarta) {
        this.codiceCarta = codiceCarta;
    }

    public String getBancaRicevente() {
        return bancaRicevente;
    }

    public void setBancaRicevente(String bancaRicevente) {
        this.bancaRicevente = bancaRicevente;
    }

    public void emettiRicevuta(){

    }
}
