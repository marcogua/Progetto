package Classi;

import Interfaccie.VerduraInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Verdura extends Prodotto implements VerduraInterface{
    private String data_raccolata;

    public Verdura() {}

	public Verdura(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
				   String data_raccolata, double quantita, String unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita , iva);
		this.data_raccolata = data_raccolata;
	}

	@Override
	public String getData_raccolata() {
		return data_raccolata;
	}

	@Override
	public void setData_raccolata(String data_raccolata) {
		this.data_raccolata = data_raccolata;
	}

	public ArrayList<Verdura> OrdinaVerduraCodiceProdottoAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getCodiceProdotto));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraCodiceProdottoDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getCodiceProdotto));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraDescrizioneAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getDescrizione));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraDescrizioneDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getDescrizione));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraProvenienzaAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getProvenienza));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraProvenienzaDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getProvenienza));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraProduttoreFornitoreAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getProduttoreFornitore));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraProduttoreFornitoreDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getProduttoreFornitore));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraDataRaccoltaAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getData_raccolata));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraDataRaccolataDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getData_raccolata));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraPrezzoAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getPrezzo));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraPrezzoDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getPrezzo));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraQunaitaAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getQuantita));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraQunaitaDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getQuantita));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraUnitaAsc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getUnita));
		return verduraArrayList;
	}

	public ArrayList<Verdura> OrdinaVerduraUnitaDesc(ArrayList<Verdura> verduraArrayList){
		verduraArrayList.sort(Comparator.comparing(Verdura::getUnita));
		Collections.reverse(verduraArrayList);
		return verduraArrayList;
	}
}
