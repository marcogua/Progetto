package Classi;

import Interfaccie.ProdottoInterface;

public class Prodotto implements ProdottoInterface {
	private String codiceProdotto;
	private String descrizione;
	private String produttoreFornitore;
	private String provenienza;
    private double prezzo;
    private double quantita;
    private String unita;
    private String iva;
    
    public Prodotto() {
    	
    }
    
    public Prodotto(String codiceProdotto, String descrizione, double quantita) {
    	this.codiceProdotto = codiceProdotto;
    	this.descrizione = descrizione;
    	this.quantita = quantita;
    }

	public Prodotto(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
					double prezzo, double quantita, String unita, String iva) {
		this.codiceProdotto = codiceProdotto;
		this.descrizione = descrizione;
		this.produttoreFornitore = produttoreFornitore;
		this.provenienza = provenienza;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.unita = unita;
		this.iva = iva;
	}


	@Override
	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	@Override
	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	@Override
	public String getDescrizione() {
		return descrizione;
	}

	@Override
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String getProduttoreFornitore() {
		return produttoreFornitore;
	}

	@Override
	public void setProduttoreFornitore(String produttoreFornitore) {
		this.produttoreFornitore = produttoreFornitore;
	}

	@Override
	public String getProvenienza() {
		return provenienza;
	}

	@Override
	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}

	@Override
	public double getPrezzo() {
		return prezzo;
	}

	@Override
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public double getQuantita() {
		return quantita;
	}

	@Override
	public void setQuantita(double quantita) {
		this.quantita = quantita;
	}

	public String getUnita() {
		return unita;
	}

	public void setUnita(String unita) {
		this.unita = unita;
	}


	public String getIva() {
		return iva;
	}


	public void setIva(String iva) {
		this.iva = iva;
	}
}
