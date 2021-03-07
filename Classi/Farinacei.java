package Classi;

import Interfaccie.FarinaceiInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Farinacei extends Prodotto implements FarinaceiInterface{
    private String data_scadenza;

    public Farinacei() {}

	public Farinacei(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
					 String data_scadenza, double quantita, String  unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita, iva);
		this.data_scadenza = data_scadenza;
	}

	@Override
	public String getData_scadenza() {
		return data_scadenza;
	}

	@Override
	public void setData_scadenza(String data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiCodiceProdottoAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getCodiceProdotto));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiCodiceProdottoDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getCodiceProdotto));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiDescrizioneAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getDescrizione));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiDescrizioneDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getDescrizione));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiProvenienzaAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getProvenienza));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiProvenienzaDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getProvenienza));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiProduttoreFornitoreAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getProduttoreFornitore));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiProduttoreFornitoreDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getProduttoreFornitore));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiDataScadenzaAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getData_scadenza));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiDataScadenzaDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getData_scadenza));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiPrezzoAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getPrezzo));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiPrezzoDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getPrezzo));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiQuantitaAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getQuantita));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiQuanitaDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getQuantita));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiUnitaAsc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getUnita));
		return farinaceiArrayList;
	}

	public ArrayList<Farinacei> OrdinaFarinaceiUnitaDesc(ArrayList<Farinacei> farinaceiArrayList){
		farinaceiArrayList.sort(Comparator.comparing(Farinacei::getUnita));
		Collections.reverse(farinaceiArrayList);
		return farinaceiArrayList;
	}
}
