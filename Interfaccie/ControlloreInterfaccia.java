package Interfaccie;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Classi.Carta;
import Classi.Cliente;
import Classi.Confezionati;
import Classi.Contanti;
import Classi.Farinacei;
import Classi.Frutta;
import Classi.Latticini;
import Classi.Magazzino;
import Classi.Ordine;
import Classi.Pagamento;
import Classi.Prodotto;
import Classi.Uova;
import Classi.Verdura;

public interface ControlloreInterfaccia {

	void homeGUI();

	void pagameto_GUI();

	void addProdotto_GUI();

	void addClienti_GUI();

	void error_GUI();

	void errorModifica_GUI();

	void modifica_GUI(Cliente client);

	void Pagamento_GUI(Pagamento pagamento, ArrayList<Prodotto> prodotto);

	void modificaProdotto_GUI(Prodotto prodotto);

	public void ListaProdotti_GUI(String idLista);

	Connection collegamento();

	void mostraClienti(JTable tabella);

	void mostraClientiNome(JTable tabella, JTextField nome);

	void mostraClientiCognome(JTable tabella, JTextField nome);

	void mostraClientiEmail(JTable tabella, JTextField email);

	void mostraClientiTessera(JTable tabella, JTextField email);

	void mostraClientiCodClienti(JTable tabella, JTextField cliente);

	void verificaCerca(JComboBox selezione, JTable tabella, JTextField nome);

	void salvaCliente(JTextField codicecliente, JTextField nome, JTextField cognome, JTextField email,
			JTextField codicetessera);

	Cliente prelevaSelezionato(JTable tabella);

	void Leggi(Cliente client, JTextField codiceCliente, JTextField nome, JTextField cognome, JTextField email,
			JTextField codicetessera);

	void rimuoviClienteTabella(String cliente);

	void mostraTessera(JTable tabella);

	void VisualizzaTesseraPuntiPerNome(JTable tabella, JTextField nome);

	void VisualizzaTesseraPuntiPerCliente(JTable tabella, JTextField nome);

	void VisualizzaTesseraPuntiPerTessrra(JTable tabella, JTextField nome);

	void verificaCercaTessera(JComboBox selezione, JTable tabella, JTextField nome);

	void ordina(JComboBox nome, JTable tabella);

	void ordinaTessrea(JComboBox nome, JTable tabella);

	void leggiProdotto(JTable tabella);

	void salvaProdottoFrutta(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza, JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita,
			JComboBox giorno, JComboBox mese, JComboBox anno);

	void salvaProdottoVerdura(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza, JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita,
			JComboBox giorno, JComboBox mese, JComboBox anno);

	void salvaProdottoUova(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo, JTextField provenienza,
			JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita, JComboBox giorno,
			JComboBox mese, JComboBox anno, JComboBox categoriaUova, JComboBox classe);

	void salvaProdottoLatticini(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza, JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita,
			JComboBox giorno, JComboBox mese, JComboBox anno, JComboBox giornoM, JComboBox meseM, JComboBox annoM,
			JComboBox senzaLattosio);

	void salvaProdottoFarinacei(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza, JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita,
			JComboBox giorno, JComboBox mese, JComboBox anno);

	void salvaProdottoConfezionati(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza, JTextField produttore, JTextField quantita, JTextField iva, JComboBox unita,
			JComboBox giorno, JComboBox mese, JComboBox anno, JComboBox giornoC, JComboBox meseC, JComboBox annoC);

	void ripilusci(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo, JTextField provenienza,
			JTextField produttore, JTextField quantita);

	void LeggiProdotto(Prodotto prodotto, JTextField codiceProdotto, JTextField Descrizione, JTextField Prezzo,
			JTextField proveninza, JTextField produttore, JTextField quantita, JComboBox unita, JTextField iva);

	Prodotto prelevaProdottoSelezionato(JTable tabella);

	void rimuoviProdottoTabella(String prodotto);

	void visualizzaTabellaFrutta(JTable tabellaFrutta);

	void visualizzaTabellaVerdura(JTable tabellaVerdura);

	void visualizzaTabellaUova(JTable tabellaUova);

	void visualizzaTabellaFarinacei(JTable tabellaFarinacei);

	void visualizzaTabellaConfezionati(JTable tabellaConfezionati);

	void visualizzaTabellaLatticini(JTable tabellaLatticini);

	void visualizzaTabellaFruttaCercaCodiceProdotto(JTable tabellaFrutta, String codiceProdotto);

	void visualizzaTabellaVerduraCercaCodiceProdotto(JTable tabellaVerdura, String codiceProdotto);

	void visualizzaTabellaUovaCercaCodiceProdotto(JTable tabellaUova, String codiceProdotto);

	void visualizzaTabellaFarinaceiCercaCodiceProdotto(JTable tabellaFarinacei, String codiceProdotto);

	void visualizzaTabellaConfezionatiCercaCodiceProdotto(JTable tabellaConfezionati, String codiceProdotto);

	void visualizzaTabellaLatticiniCercaCodiceProdotto(JTable tabellaLatticini, String codiceProdotto);

	void visualizzaTabellaFruttaCercaDescrizione(JTable tabellaFrutta, String descrizione);

	void visualizzaTabellaVerduraCercaDescrizione(JTable tabellaVerdura, String descrizione);

	void visualizzaTabellaUovaCercaDescrizione(JTable tabellaUova, String descrizione);

	void visualizzaTabellaFarinaceiCercaDescrizione(JTable tabellaFarinacei, String descrizione);

	void visualizzaTabellaConfezionatiCercaDescrizione(JTable tabellaConfezionati, String descrizione);

	void visualizzaTabellaLatticiniCercaDescrizione(JTable tabellaLatticini, String descrizione);

	void visualizzaTabellaFruttaCercaProduttoreFornitore(JTable tabellaFrutta, String produttoreFornitore);

	void visualizzaTabellaVerduraCercaProduttoreFornitore(JTable tabellaVerdura, String produttoreFornitore);

	void visualizzaTabellaUovaCercaProduttoreFornitore(JTable tabellaUova, String produttoreFornitore);

	void visualizzaTabellaFarinaceiCercaProduttoreFornitore(JTable tabellaFarinacei, String produttoreFornitore);

	void visualizzaTabellaConfezionatiCercaProduttoreFornitore(JTable tabellaConfezionati, String produttoreFornitore);

	void visualizzaTabellaLatticiniCercaProduttoreFornitore(JTable tabellaLatticini, String produttoreFornitore);

	void visualizzaTabellaFruttaCercaProvenienza(JTable tabellaFrutta, String provenienza);

	void visualizzaTabellaVerduraCercaProvenienza(JTable tabellaVerdura, String provenienza);

	void visualizzaTabellaUovaCercaProvenienza(JTable tabellaUova, String provenienza);

	void visualizzaTabellaFarinaceiCercaProvenienza(JTable tabellaFarinacei, String provenienza);

	void visualizzaTabellaConfezionatiCercaProvenienza(JTable tabellaConfezionati, String provenienza);

	void visualizzaTabellaLatticiniCercaProvenienza(JTable tabellaLatticini, String provenienza);

	void visualizzaTabellaFruttaCercaDataRaccolta(JTable tabellaFrutta, String dataraccolata);

	void visualizzaTabellaVerduraCercaDataRaccolta(JTable tabellaVerdura, String dataraccolata);

	void visualizzaTabellaUovaCercaDataConfezionamento(JTable tabellaUova, String dataConfezionamento);

	void visualizzaTabellaUovaCercaCategoriaUova(JTable tabellaUova, String categoriaUova);

	void visualizzaTabellaUovaCercaClassePeso(JTable tabellaUova, String classePeso);

	void visualizzaTabellaLatticiniCercaDataMungitura(JTable tabellaLatticini, String dataMungitura);

	void visualizzaTabellaLatticiniCercaDataProduzione(JTable tabellaLatticini, String dataProduzione);

	void visualizzaTabellaConfezionatiCercaDataConfezionamento(JTable tabellaConfezionati, String dataConfezionamento);

	void visualizzaTabellaConfezionatiCercaDataScadenza(JTable tabellaConfezionati, String dataScadenza);

	void visualizzaTabellaFarinaceiCercaDataScadenza(JTable tabellaFarinacei, String dataScadenza);

	void aggiungiAlCarelloFrutta(JTable tabellaFrutta, double quantita, JTable carello,
			ArrayList<Prodotto> listaProdotti);

	void aggiungiAlCarelloVerdura(JTable tabellaVerdura, double quantita, JTable carello,
			ArrayList<Prodotto> listaProdotti);

	void aggiungiAlCarelloFarinacei(JTable tabellaFarinacei, double quantita, JTable carello,
			ArrayList<Prodotto> listaProdotti);

	void aggiungiAlCarelloLatticini(JTable tabellaLatticini, double quantita, JTable carello,
			ArrayList<Prodotto> listaProdotti);

	void aggiungiAlCarelloUova(JTable tabellaUova, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	void aggiungiAlCarelloConfezionati(JTable tabellaConfezionati, double quantita, JTable carello,
			ArrayList<Prodotto> listaProdotti);

	void svuotaCarello(JTable carello, ArrayList<Prodotto> listCarrello, JLabel subTotale);

	void rimuoviProdottoCarrello(JTable carrello, ArrayList<Prodotto> listCarrello, JLabel subTotale);

	void visualizzaTabellaCarrello(ArrayList<Prodotto> carrello, JTable tableCarrello);

	ArrayList<Frutta> tableToArrayListFrutta(JTable tablefrutta);

	ArrayList<Verdura> tableToArrayListVerdura(JTable tableVerdura);

	ArrayList<Farinacei> tableToArrayListFarinacei(JTable tableFarinacei);

	ArrayList<Latticini> tableToArrayListLatticini(JTable tableLatticini);

	ArrayList<Uova> tableToArrayListUova(JTable tableUova);

	ArrayList<Confezionati> tableToArrayListConfezionati(JTable tableConfezionati);

	void visualizzaTabellaFruttaOrdinaCodiceProdottoAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaCodiceProdottoDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaDescrizioneAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaDescrizioneDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaProduttoreFornitoreAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaProduttoreFornitoreDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaProvenienzaAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaProvenienzaDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaDataRaccoltaAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaDataRaccoltaDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaQuantitaAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaQuantitaDesc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaPrezzoAsc(JTable tableFrutta);

	void visualizzaTabellaFruttaOrdinaPrezzoDesc(JTable tableFrutta);

	void visualizzaTabellaVerduraOrdinaCodiceProdottoAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaCodiceProdottoDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaDescrizioneAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaDescrizioneDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaProduttoreFornitoreAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaProduttoreFornitoreDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaProvenienzaAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaProvenienzaDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaDataRaccoltaAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaDataRaccoltaDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaQuantitaAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaQuantitaDesc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaPrezzoAsc(JTable tableVerdura);

	void visualizzaTabellaVerduraOrdinaPrezzoDesc(JTable tableVerdura);

	void visualizzaTabellaUovaOrdinaCodiceProdottoAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaCodiceProdottoDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaDescrizioneAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaDescrizioneDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaProduttoreFornitoreAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaProduttoreFornitoreDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaProvenienzaAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaProvenienzaDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaClassePesoAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaClassePesoDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaCategoriaUovaAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaCategoriaUovaDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaDataConfezionamentoAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaDataConfezionamentoDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaQuantitaAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaQuantitaDesc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaPrezzoAsc(JTable tableUova);

	void visualizzaTabellaUovaOrdinaPrezzoDesc(JTable tableUova);

	void visualizzaTabellaLatticiniOrdinaCodiceProdottoAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaCodiceProdottoDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDescrizioneAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDescrizioneDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaProvenienzaAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaProvenienzaDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDataMungituraAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDataMungituraDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDataProduzioneAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaDataProduzioneDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaSenzaLattosioAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaSenzaLattosioDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaQuantitaAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaQuantitaDesc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaPrezzoAsc(JTable tableLatticini);

	void visualizzaTabellaLatticiniOrdinaPrezzoDesc(JTable tableLatticini);

	void visualizzaTabellaFarinaceiOrdinaCodiceProdottoAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaCodiceProdottoDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaDescrizioneAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaDescrizioneDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaProvenienzaAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaProvenienzaDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaDataScadenzaAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaDataScadenzaDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaQuantitaAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaQuantitaDesc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaPrezzoAsc(JTable tableFarinacei);

	void visualizzaTabellaFarinaceiOrdinaPrezzoDesc(JTable tableFarinacei);

	void visualizzaTabellaConfezionatiOrdinaCodiceProdottoAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaCodiceProdottoDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDescrizioneAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDescrizioneDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaProvenienzaAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaProvenienzaDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDataConfezionametoAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDataConfezionametoDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDataScadenzaAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaDataScadenzaDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaQuantitaAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaQuantitaDesc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaPrezzoAsc(JTable tableConfezionati);

	void visualizzaTabellaConfezionatiOrdinaPrezzoDesc(JTable tableConfezionati);

	//void rimuoviProdottodalMagazzino(String prodotto);

	double calcolaSubTotale(ArrayList<Prodotto> carrello, JLabel subTotale);

	ArrayList<Prodotto> aggiungiProdottoListaProdotti(Prodotto prodotto);

	Ordine completaOrdine(Ordine ordine);

	void aggiungiListaProdotti(ArrayList<Prodotto> listaProdotti, String idLista);

	Ordine aggiungiDatiOrdine(JTextField nomeIntestatario, JTextField tesseraFedelta, JTextField codiceCarta);

	Contanti aggiungiPagamentoContanti(JTextField textContanti, JTextField cartaFedelta);

	Carta aggiungiPagamentoCarta(JTextField codiceBancaRicevente, JTextField numeroCarta, JTextField cartaFedelta);

	void generaOrdineCarta(JTextPane totaleCarta, JTextField codiceCarta, JTextField codiceTessera,
			ArrayList<Prodotto> listaProdotti);

	void generaOrdineContanti(ArrayList<Prodotto> listaProdotti, JTextField textFieldContantiDati, JTextPane textPaneTotaleContanti, JTextField codiceTessera);

	void visualizzaListaProdotti(JTable tableListaProdotti, String idLista);

	void leggiVal(Pagamento pagamento,JTextPane totale, JTextPane iva, JTextPane totaleContanti, JTextPane ivaContanti);

	Pagamento prelevaTotale(JLabel valore, JLabel iva);

	void calcolaIvaSubTotale(ArrayList<Prodotto> carrello, JLabel lblsubTotaleIva);

	void visualizzaTabellaRegistroVendite(JTable tableRegistroVendite);
	
	void visualizzaTabellaListaProdotti(JTable tableListaProdotti, String idLista);
	
	void generaPunti(JTextField codiceTessera, JTextPane textPaneTotaleContanti, ArrayList<Prodotto> listaProdotti);
	
	void sottraiQuantitaProdottiVenduti(ArrayList<Prodotto> listaProdotti);
	
	void visualizzaTabellaRegistroVenditeCercaPerNumeroOrdine(JTable tableRegistroVendite, String numeroOrdine);
	
	void visualizzaTabellaRegistroVenditeCercaPerDataRegistrazione(JTable tableRegistroVendite, String dataRegistrazione);
	
	void visualizzaTabellaRegistroVenditeCercaPerIdListaProdotti(JTable tableRegistroVendite, String idLista);
	
	void visualizzaTabellaRegistroVenditeCercaPerCodiceCarta(JTable tableRegistroVendite, String codiceCarta);
	
	void visualizzaTabellaRegistroVenditeCercaPerCodiceCliente(JTable tableRegistroVendite, String codiceCliente);
	
	ArrayList<Ordine> tableToArrayListOrdine(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaNumeroOrdine(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaDataRegistrzione(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaCodiceCliente(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaCodiceTessera(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaTotaleOrdine(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaIdLista(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaTipoPagamento(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaCodiceCarta(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaBancaRicevente(JTable tableOrdini);
	
	void visualizzaTabellaOrdinaSoldiRicevuti(JTable tableOrdini);
	
	String prelevaIdListSelezionato(JTable tabella);
	
	void ListaProdotti_GUI1();
	
	void verificaCercaProdotto(JComboBox selezione,JTable tabella, JTextField nome );
	
	void mostraProdottoCodiceProdotto(JTable tabella, JTextField codiceProdotto);
	
	void mostraProdottoDescrizione(JTable tabella, JTextField descrizione);
	
	void mostraProdottoProvenienza(JTable tabella, JTextField provenienza);
	
	void mostraProdottoProduttore(JTable tabella, JTextField produttore);
	
	void ordinaProdotti(JComboBox nome, JTable tabella);
	
}