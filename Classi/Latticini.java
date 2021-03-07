package Classi;

import Interfaccie.LatticiniInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Latticini extends Prodotto implements LatticiniInterface{
    private String data_mungitura;
    private String data_produzione;
    private boolean senzaLattosio;

    public Latticini() {}

	public Latticini(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
					 String data_mungitura, String data_produzione, boolean senzaLattosio, double quantita,
					 String unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita, iva);
		this.data_mungitura = data_mungitura;
		this.data_produzione = data_produzione;
		this.senzaLattosio = senzaLattosio;
	}

	@Override
	public String getData_mungitura() {
		return data_mungitura;
	}

	@Override
	public void setData_mungitura(String data_mungitura) {
		this.data_mungitura = data_mungitura;
	}

	@Override
	public String getData_produzione() {
		return data_produzione;
	}

	@Override
	public void setData_produzione(String data_produzione) {
		this.data_produzione = data_produzione;
	}

	public boolean isSenzaLattosio() {
		return senzaLattosio;
	}

	public void setSenzaLattosio(boolean senzaLattosio) {
		this.senzaLattosio = senzaLattosio;
	}

	public ArrayList<Latticini> OrdinaLatticininCodiceProdottoAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getCodiceProdotto));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniCodiceProdottoDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getCodiceProdotto));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininDescrizioneAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getDescrizione));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniDescrizioneDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getDescrizione));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniProvenienzaAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getProvenienza));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniProvenienzaDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getProvenienza));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininProduttoreFornitoreAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getProduttoreFornitore));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniProduttoreFornitoreDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getProduttoreFornitore));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininUnitaAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getUnita));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniUnitaDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getUnita));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininDataMungituraAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getData_mungitura));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniDataMungituraDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getData_mungitura));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininDataProduzioneAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getData_produzione));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniDataProduzioneDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getData_produzione));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininSenzaLattosioAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::isSenzaLattosio));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniSenzaLattosioDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::isSenzaLattosio));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininPrezzoAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getPrezzo));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniPrezzoDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getPrezzo));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticininQuanitaAsc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getQuantita));
		return latticiniArrayList;
	}

	public ArrayList<Latticini> OrdinaLatticiniQunaitaDesc(ArrayList<Latticini> latticiniArrayList){
		latticiniArrayList.sort(Comparator.comparing(Latticini::getQuantita));
		Collections.reverse(latticiniArrayList);
		return latticiniArrayList;
	}
}
