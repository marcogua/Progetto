package Classi;

import Interfaccie.FruttaInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Frutta extends Prodotto implements FruttaInterface{
    private String data_raccolta;

    public Frutta() {}
    
	public Frutta(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
				  String data_raccolta, double quantita, String unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita, iva);
		this.data_raccolta = data_raccolta;
	}

	@Override
	public String getData_raccolta() {
		return data_raccolta;
	}

	@Override
	public void setData_raccolta(String data_raccolta) {
		this.data_raccolta = data_raccolta;
	}

	public ArrayList<Frutta> OrdinaFruttaCodiceProdottoAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getCodiceProdotto));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaCodiceProdottoDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getCodiceProdotto));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaDescrizioneAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getDescrizione));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaDescrizioneDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getDescrizione));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaProveninenzaAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getProvenienza));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaProvenienzaDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getProvenienza));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaProduttoreFornitoreAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getProduttoreFornitore));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaProduttoreForniotreDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getProduttoreFornitore));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaDataRaccolataAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getData_raccolta));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaDataRaccolataDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getData_raccolta));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaPrezzoAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getPrezzo));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaPrezzoDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getPrezzo));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaQunaitaAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getQuantita));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaQunaitaDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getQuantita));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaUnitaAsc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getUnita));
		return fruttaArrayList;
	}

	public ArrayList<Frutta> OrdinaFruttaUnitaDesc(ArrayList<Frutta> fruttaArrayList){
		fruttaArrayList.sort(Comparator.comparing(Frutta::getUnita));
		Collections.reverse(fruttaArrayList);
		return fruttaArrayList;
	}
}
