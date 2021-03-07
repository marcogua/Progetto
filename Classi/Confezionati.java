package Classi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Confezionati extends Prodotto {
    private String data_confezionamento;
    private String data_scadenza;

    public Confezionati() {}

	public Confezionati(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
						String data_confezionamento, String data_scadenza ,
						double quantita, String unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita, iva);
		this.data_confezionamento = data_confezionamento;
		this.data_scadenza = data_scadenza;
	}

	public String getData_confezionamento() {
		return data_confezionamento;
	}

	public void setData_confezionamento(String data_confezionamento) {
		this.data_confezionamento = data_confezionamento;
	}

	public String getData_scadenza() {
		return data_scadenza;
	}

	public void setData_scadenza(String data_scadenza) {
		this.data_scadenza = data_scadenza;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiCodiceProdottoAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getCodiceProdotto));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiCodiceProdottoDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getCodiceProdotto));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDescrizioneAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getDescrizione));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDescrizioneDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getDescrizione));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiProvenienzaAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getProvenienza));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiProvenienzaDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getProvenienza));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiProduttoreFornitoreAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getProduttoreFornitore));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiProduttoreFornitoreDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getProduttoreFornitore));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDataConfezionamentoAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getData_confezionamento));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDataConfezionamentoDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getData_confezionamento));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDataScadenzatoAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getData_scadenza));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiDataScadenzaDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getData_scadenza));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiPrezzoAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getPrezzo));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiPrezzoDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getPrezzo));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiQuantitaAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getQuantita));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiQuantitaDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getQuantita));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiUnitaAsc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getUnita));
		return confezionatiArrayList;
	}

	public ArrayList<Confezionati> OrdinaConfezionatiUnitaDesc(ArrayList<Confezionati> confezionatiArrayList){
		confezionatiArrayList.sort(Comparator.comparing(Confezionati::getUnita));
		Collections.reverse(confezionatiArrayList);
		return confezionatiArrayList;
	}
}
