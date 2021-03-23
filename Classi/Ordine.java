package Classi;

import java.util.ArrayList;
import java.util.Comparator;

public class Ordine {
	
	private String numeroOrdine;
	private double totaleOrdine;
	private String dataRegistrazione;
	private String codiceCliente;
	private String codiceTessera;
	private String idLista;
	private String tipoPagamento;
	private String codiceCarta;
	private String bancaRicevente;
	private double soldiRicevuti;
	
	public Ordine(){}
	
	public Ordine (String numeroOrdine, double totaleOrdine, String dataRegistrazione,
	String codiceCliente, String idLista, String tipoPagamento, String codiceCarta, double soldiRicevuti, String bancaRicevente) {
		this.numeroOrdine = numeroOrdine;
		this.totaleOrdine = totaleOrdine;
		this.dataRegistrazione = dataRegistrazione;
		this.codiceCliente = codiceCliente;
		this.idLista = idLista;
		this.tipoPagamento = tipoPagamento;
		this.codiceCarta = codiceCarta;
		this.soldiRicevuti = soldiRicevuti;
		this.bancaRicevente = bancaRicevente;
	}

	public Ordine(String numeroOrdine, double totaleOrdine, String dataRegistrazione,
			String codiceCliente, String codiceTessera, String idLista, String tipoPagamento, String codiceCarta, double soldiRicevuti) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.totaleOrdine = totaleOrdine;
		this.dataRegistrazione = dataRegistrazione;
		this.codiceCliente = codiceCliente;
		this.codiceTessera = codiceTessera;
		this.idLista = idLista;
		this.tipoPagamento = tipoPagamento;
		this.codiceCarta = codiceCarta;
		this.soldiRicevuti = soldiRicevuti;
	}

	/*
	public Ordine(String numeroOrdine, double totaleOrdine, String dataRegistrazione, String codiceCliente, String codiceTessera, String idLista,
			String tipoPagamento, String codiceCarta) {
		this.numeroOrdine = numeroOrdine;
        this.totaleOrdine = totaleOrdine;
        this.dataRegistrazione = dataRegistrazione;
        this.codiceCliente = codiceCliente;
        this.codiceTessera = codiceTessera;
        this.idLista = idLista;
        this.tipoPagamento = tipoPagamento;
        this.codiceCarta = codiceCarta;
	}
	 */
	public String getTipoPagamento() {
		return tipoPagamento;
	}



	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}



	public String getCodiceCarta() {
		return codiceCarta;
	}



	public void setCodiceCarta(String codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public String getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(String dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(String numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public double getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(double totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}
	
	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public String getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}
	
	public String getIdLista() {
		return idLista;
	}



	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}



	public String getBancaRicevente() {
		return bancaRicevente;
	}



	public void setBancaRicevente(String bancaRicevente) {
		this.bancaRicevente = bancaRicevente;
	}



	public double getSoldiRicevuti() {
		return soldiRicevuti;
	}



	public void setSoldiRicevuti(double soldiRicevuti) {
		this.soldiRicevuti = soldiRicevuti;
	}


	public ArrayList<Ordine> OrdinaOrdiniNumeroOrdine(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getNumeroOrdine));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniTotaleOrdine(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getTotaleOrdine));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniDataRegistrazione(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getDataRegistrazione));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniCodiceCliente(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getCodiceCliente));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniCodiceTessera(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getCodiceTessera));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniIdLista(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getIdLista));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniTipoPagamento(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getTipoPagamento));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniCodiceCarta(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getCodiceCarta));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniBancaRicevente(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getBancaRicevente));
		return confezionatiArrayList;
	}
	
	public ArrayList<Ordine> OrdinaOrdiniSoldiRicevuti(ArrayList<Ordine> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Ordine::getSoldiRicevuti));
		return confezionatiArrayList;
	}
}
