package Classi;

import Interfaccie.UovaInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Uova extends Prodotto implements UovaInterface{
    private String data_confezionamento;
    private String categoriaUova;
    private String classePeso;

    public Uova() {}

	public Uova(String codiceProdotto, String descrizione, String produttoreFornitore, String provenienza,
				String data_confezionamento, String categoriaUova, String classePeso, double quantita,
				String unita, double prezzo, String iva) {
		super(codiceProdotto, descrizione, provenienza, produttoreFornitore, prezzo, quantita, unita, iva);
		this.data_confezionamento = data_confezionamento;
		this.categoriaUova = categoriaUova;
		this.classePeso = classePeso;
	}

	@Override
	public String getData_confezionamento() {
		return data_confezionamento;
	}

	@Override
	public void setData_confezionamento(String data_confezionamento) {
		this.data_confezionamento = data_confezionamento;
	}

	public String getCategoriaUova() {
		return categoriaUova;
	}

	public void setCategoriaUova(String categoriaUova) {
		this.categoriaUova = categoriaUova;
	}

	public String getClassePeso() {
		return classePeso;
	}

	public void setClassePeso(String classePeso) {
		this.classePeso = classePeso;
	}

	public ArrayList<Uova> OrdinaUovaCodiceProdottoAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getCodiceProdotto));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaCodiceProdottoDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getCodiceProdotto));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaDescrizioneAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getDescrizione));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaDescrizioneDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getDescrizione));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaProvenienzaAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getProvenienza));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaProvenienzaDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getProvenienza));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaProduttoreFornitoreAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getProduttoreFornitore));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaProduttoreFornitoreDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getProduttoreFornitore));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaDataConfezionametoAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getData_confezionamento));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaDataConfezionamentoDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getData_confezionamento));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaCategoriaUovaAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getCategoriaUova));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaCategoriaUovaDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getCategoriaUova));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaClassePesoAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getClassePeso));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaClassePesoDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getClassePeso));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaPrezzoAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getPrezzo));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaPrezzoDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getPrezzo));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaQuantitaAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getQuantita));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaQuantitaDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getQuantita));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaUnitaAsc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getUnita));
		return uovaArrayList;
	}

	public ArrayList<Uova> OrdinaUovaUnitaDesc(ArrayList<Uova> uovaArrayList){
		uovaArrayList.sort(Comparator.comparing(Uova::getUnita));
		Collections.reverse(uovaArrayList);
		return uovaArrayList;
	}
}
