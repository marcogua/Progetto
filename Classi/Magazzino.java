package Classi;

import Interfaccie.MagazzinoInterfaccia;

public class Magazzino implements MagazzinoInterfaccia {
	
	private String codiceProdotto;
	private String Descrizione;
	private double prezzo;
	private String provenienza;
	private String produttore;
	private int quantita;
	private String unita;
	
	
	public Magazzino(String codiceProdotto, String Descrizione, double prezzo, 
			String provenienza,String produttore, int quantita, String unita) {
		
		this.codiceProdotto = codiceProdotto;
		this.Descrizione = Descrizione;
		this.prezzo = prezzo;
		this.provenienza = provenienza;
		this.produttore = produttore;
		this.quantita = quantita;
		this.unita = unita;
		
	}
	
	public Magazzino() {
		
		this.codiceProdotto = null;
		this.Descrizione = null;
		this.prezzo = 0;
		this.provenienza = null;
		this.produttore = null;
		this.quantita = 0;
		this.unita = null;
		
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
		return Descrizione;
	}
	
	
	@Override
	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
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
	public String getProvenienza() {
		return provenienza;
	}
	
	
	@Override
	public void setProvenienza(String provenienza) {
		this.provenienza = provenienza;
	}
	@Override
	public String getProduttore() {
		return produttore;
	}
	
	
	@Override
	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}
	
	
	@Override
	public int getQuantita() {
		return quantita;
	}
	
	
	@Override
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
	@Override
	public String getUnita() {
		return unita;
	}
	
	
	@Override
	public void setUnita(String unita) {
		this.unita = unita;
	}
	
	

}
