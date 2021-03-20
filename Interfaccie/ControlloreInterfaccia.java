package Interfaccie;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import Classi.*;

public interface ControlloreInterfaccia {

	/**
	 *Chiama l'interfaccia Grafica Home_GUI
	 */
	void homeGUI();

	/**
	 *Chiama l'interfaccia Grafica PagamentoGui
	 */
	void pagameto_GUI();

	/**
	 *Chiama l'interfaccia Grafica AggiungiProdottoGUI
	 */
	void addProdotto_GUI();

	/**
	 *Chiama l'interfaccia Grafica AggiungiClienteGUI
	 */
	void addClienti_GUI();

	/**
	 *Chiama l'interfaccia Grafica ErroreGUI
	 */
	void error_GUI();

	/**
	 *Chiama l'interfaccia Grafica ErroreModificaGUI
	 */
	void errorModifica_GUI();

	/**
	 *Chiama l'interfaccia Grafica ModificaGUI
	 * @param client
	 */
	void modifica_GUI(Cliente client);

	/**
	 *Chiama l'interfaccia Grafica ModificaProdottoGUI
	 * @param prodotto
	 */
	void modificaProdotto_GUI(Prodotto prodotto);

	/**
	 *Metodo Per rimuovere un prodotto dal magazzino
	 * @param prodotto
	 */
	void rimuoviProdottodalMagazzino(String prodotto);

	/**
	 *Metodo per stabilire la connessione con il DB
	 * @return
	 */
	Connection collegamento();

	/**
	 *Metodo per prelevare tutti i cliente dal DB e inserirli nella tabbella Clienti
	 * @param tabella
	 */
	void mostraClienti(JTable tabella);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void mostraClientiNome(JTable tabella, JTextField nome);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void mostraClientiCognome(JTable tabella, JTextField nome);

	/**
	 *
	 * @param tabella
	 * @param email
	 */
	void mostraClientiEmail(JTable tabella, JTextField email);

	/**
	 *
	 * @param tabella
	 * @param email
	 */
	void mostraClientiTessera(JTable tabella, JTextField email);

	/**
	 *
	 * @param tabella
	 * @param cliente
	 */
	void mostraClientiCodClienti(JTable tabella, JTextField cliente);

	/**
	 *
	 * @param selezione
	 * @param tabella
	 * @param nome
	 */
	void verificaCerca(JComboBox selezione, JTable tabella, 
			JTextField nome);

	/**
	 *
	 * @param codicecliente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param codicetessera
	 */
	void salvaCliente(JTextField codicecliente, JTextField nome, 
			JTextField cognome,JTextField email,JTextField codicetessera);

	/**
	 *
	 * @param tabella
	 * @return
	 */
	Cliente prelevaSelezionato(JTable tabella);

	/**
	 *
	 * @param cliente
	 * @param codiceCliente
	 * @param nome
	 * @param cognome
	 * @param email
	 * @param codicetessera
	 */
	void Leggi(Cliente cliente,JTextField codiceCliente, JTextField nome,
			JTextField cognome, JTextField email, JTextField codicetessera);

	/**
	 *
	 * @param cliente
	 */
	void rimuoviClienteTabella(String cliente);

	/**
	 *
	 * @param tabella
	 */
	void mostraTessera(JTable tabella);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void VisualizzaTesseraPuntiPerNome(JTable tabella, JTextField nome);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void VisualizzaTesseraPuntiPerCliente(JTable tabella, JTextField nome);

	/**
	 *
	 * @param tabella
	 * @param nome
	 */
	void VisualizzaTesseraPuntiPerTessrra(JTable tabella, JTextField nome);

	/**
	 *
	 * @param selezione
	 * @param tabella
	 * @param nome
	 */
	void verificaCercaTessera(JComboBox selezione,JTable tabella, JTextField nome );

	/**
	 *
	 * @param nome
	 * @param tabella
	 */
	void ordina(JComboBox nome, JTable tabella);

	/**
	 *
	 * @param nome
	 * @param tabella
	 */
	void ordinaTessrea(JComboBox nome, JTable tabella);

	/**
	 *
	 * @param tabella
	 */
	void leggiProdotto(JTable tabella);

	/*void salvaProdotto( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
						JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
						JComboBox giorno, JComboBox mese, JComboBox anno);*/

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 */
	void ripilusci(JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
			JTextField provenienza,JTextField produttore, JTextField quantita);

	/**
	 *
	 * @param tabella
	 * @return
	 */
	Prodotto prelevaProdottoSelezionato(JTable tabella);

	/**
	 *
	 * @param prodotto
	 */
	void rimuoviProdottoTabella(String  prodotto);

	/**
	 *
	 * @param tabellaFrutta
	 */
	void visualizzaTabellaFrutta(JTable tabellaFrutta);

	/**
	 *
	 * @param tabellaVerdura
	 */
	void visualizzaTabellaVerdura(JTable tabellaVerdura);

	/**
	 *
	 * @param tabellaUova
	 */
	void visualizzaTabellaUova(JTable tabellaUova);

	/**
	 *
	 * @param tabellaFarinacei
	 */
	void visualizzaTabellaFarinacei(JTable tabellaFarinacei);

	/**
	 *
	 * @param tabellaConfezionati
	 */
	void visualizzaTabellaConfezionati(JTable tabellaConfezionati);

	/**
	 *
	 * @param tabellaLatticini
	 */
	void visualizzaTabellaLatticini(JTable tabellaLatticini);

	/**
	 *
	 * @param tabellaFrutta
	 * @param codiceProdotto
	 */
	void visualizzaTabellaFruttaCercaCodiceProdotto(JTable tabellaFrutta, String codiceProdotto);

	/**
	 *
	 * @param tabellaVerdura
	 * @param codiceProdotto
	 */
	void visualizzaTabellaVerduraCercaCodiceProdotto(JTable tabellaVerdura, String codiceProdotto);

	/**
	 *
	 * @param tabellaUova
	 * @param codiceProdotto
	 */
	void visualizzaTabellaUovaCercaCodiceProdotto(JTable tabellaUova, String codiceProdotto);

	/**
	 *
	 * @param tabellaFarinacei
	 * @param codiceProdotto
	 */
	void visualizzaTabellaFarinaceiCercaCodiceProdotto(JTable tabellaFarinacei, String codiceProdotto);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param codiceProdotto
	 */
	void visualizzaTabellaConfezionatiCercaCodiceProdotto(JTable tabellaConfezionati, String codiceProdotto);

	/**
	 *
	 * @param tabellaLatticini
	 * @param codiceProdotto
	 */
	void visualizzaTabellaLatticiniCercaCodiceProdotto(JTable tabellaLatticini, String codiceProdotto);

	/**
	 *
	 * @param tabellaFrutta
	 * @param descrizione
	 */
	void visualizzaTabellaFruttaCercaDescrizione(JTable tabellaFrutta, String descrizione);

	/**
	 *
	 * @param tabellaVerdura
	 * @param descrizione
	 */
	void visualizzaTabellaVerduraCercaDescrizione(JTable tabellaVerdura, String descrizione);

	/**
	 *
	 * @param tabellaUova
	 * @param descrizione
	 */
	void visualizzaTabellaUovaCercaDescrizione(JTable tabellaUova, String descrizione);

	/**
	 *
	 * @param tabellaFarinacei
	 * @param descrizione
	 */
	void visualizzaTabellaFarinaceiCercaDescrizione(JTable tabellaFarinacei, String descrizione);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param descrizione
	 */
	void visualizzaTabellaConfezionatiCercaDescrizione(JTable tabellaConfezionati, String descrizione);

	/**
	 *
	 * @param tabellaLatticini
	 * @param descrizione
	 */
	void visualizzaTabellaLatticiniCercaDescrizione(JTable tabellaLatticini, String descrizione);

	/**
	 *
	 * @param tabellaFrutta
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaFruttaCercaProduttoreFornitore(JTable tabellaFrutta, String produttoreFornitore);

	/**
	 *
	 * @param tabellaVerdura
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaVerduraCercaProduttoreFornitore(JTable tabellaVerdura, String produttoreFornitore);

	/**
	 *
	 * @param tabellaUova
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaUovaCercaProduttoreFornitore(JTable tabellaUova, String produttoreFornitore);

	/**
	 *
	 * @param tabellaFarinacei
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaFarinaceiCercaProduttoreFornitore(JTable tabellaFarinacei, String produttoreFornitore);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaConfezionatiCercaProduttoreFornitore(JTable tabellaConfezionati, String produttoreFornitore);

	/**
	 *
	 * @param tabellaLatticini
	 * @param produttoreFornitore
	 */
	void visualizzaTabellaLatticiniCercaProduttoreFornitore(JTable tabellaLatticini, String produttoreFornitore);

	/**
	 *
	 * @param tabellaFrutta
	 * @param provenienza
	 */
	void visualizzaTabellaFruttaCercaProvenienza(JTable tabellaFrutta, String provenienza);

	/**
	 *
	 * @param tabellaVerdura
	 * @param provenienza
	 */
	void visualizzaTabellaVerduraCercaProvenienza(JTable tabellaVerdura, String provenienza);

	/**
	 *
	 * @param tabellaUova
	 * @param provenienza
	 */
	void visualizzaTabellaUovaCercaProvenienza(JTable tabellaUova, String provenienza);

	/**
	 *
	 * @param tabellaFarinacei
	 * @param provenienza
	 */
	void visualizzaTabellaFarinaceiCercaProvenienza(JTable tabellaFarinacei, String provenienza);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param provenienza
	 */
	void visualizzaTabellaConfezionatiCercaProvenienza(JTable tabellaConfezionati, String provenienza);

	/**
	 *
	 * @param tabellaLatticini
	 * @param provenienza
	 */
	void visualizzaTabellaLatticiniCercaProvenienza(JTable tabellaLatticini, String provenienza);

	/**
	 *
	 * @param tabellaFrutta
	 * @param dataraccolata
	 */
	void visualizzaTabellaFruttaCercaDataRaccolta(JTable tabellaFrutta, String dataraccolata);

	/**
	 *
	 * @param tabellaVerdura
	 * @param dataraccolata
	 */
	void visualizzaTabellaVerduraCercaDataRaccolta(JTable tabellaVerdura, String dataraccolata);

	/**
	 *
	 * @param tabellaUova
	 * @param dataConfezionamento
	 */
	void visualizzaTabellaUovaCercaDataConfezionamento(JTable tabellaUova, String dataConfezionamento);

	/**
	 *
	 * @param tabellaUova
	 * @param categoriaUova
	 */
	void visualizzaTabellaUovaCercaCategoriaUova(JTable tabellaUova, String categoriaUova);

	/**
	 *
	 * @param tabellaUova
	 * @param classePeso
	 */
	void visualizzaTabellaUovaCercaClassePeso(JTable tabellaUova, String classePeso);

	/**
	 *
	 * @param tabellaLatticini
	 * @param dataMungitura
	 */
	void visualizzaTabellaLatticiniCercaDataMungitura(JTable tabellaLatticini, String dataMungitura);

	/**
	 *
	 * @param tabellaLatticini
	 * @param dataProduzione
	 */
	void visualizzaTabellaLatticiniCercaDataProduzione(JTable tabellaLatticini, String dataProduzione);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param dataConfezionamento
	 */
	void visualizzaTabellaConfezionatiCercaDataConfezionamento(JTable tabellaConfezionati, String dataConfezionamento);

	/**
	 *
	 * @param tabellaConfezionati
	 * @param dataScadenza
	 */
	void visualizzaTabellaConfezionatiCercaDataScadenza(JTable tabellaConfezionati, String dataScadenza);

	/**
	 *
	 * @param tabellaFarinacei
	 * @param dataScadenza
	 */
	void visualizzaTabellaFarinaceiCercaDataScadenza(JTable tabellaFarinacei, String dataScadenza);

	/**
	 * 
	 * @param tabellaFrutta
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloFrutta(JTable tabellaFrutta, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param tabellaVerdura
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloVerdura(JTable tabellaVerdura, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param tabellaFarinacei
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloFarinacei(JTable tabellaFarinacei, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param tabellaLatticini
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloLatticini(JTable tabellaLatticini, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param tabellaUova
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloUova(JTable tabellaUova, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param tabellaConfezionati
	 * @param quantita
	 * @param carello
	 * @param listaProdotti
	 */
	void aggiungiAlCarelloConfezionati(JTable tabellaConfezionati, double quantita, JTable carello, ArrayList<Prodotto> listaProdotti);

	/**
	 * 
	 * @param carello
	 * @param listCarrello
	 * @param subTotale
	 */
	void svuotaCarello(JTable carello, ArrayList<Prodotto> listCarrello, JLabel subTotale);

	/**
	 * 
	 * @param carrello
	 * @param listCarrello
	 * @param subTotale
	 */
	void rimuoviProdottoCarrello(JTable carrello, ArrayList<Prodotto> listCarrello, JLabel subTotale);

	/**
	 *
	 * @param tablefrutta
	 * @return
	 */
	ArrayList<Frutta> tableToArrayListFrutta(JTable tablefrutta);

	/**
	 *
	 * @param tableVerdura
	 * @return
	 */
	ArrayList<Verdura> tableToArrayListVerdura(JTable tableVerdura);

	/**
	 *
	 * @param tableFarinacei
	 * @return
	 */
	ArrayList<Farinacei> tableToArrayListFarinacei(JTable tableFarinacei);

	/**
	 *
	 * @param tableLatticini
	 * @return
	 */
	ArrayList<Latticini> tableToArrayListLatticini(JTable tableLatticini);

	/**
	 *
	 * @param tableUova
	 * @return
	 */
	ArrayList<Uova> tableToArrayListUova(JTable tableUova);

	/**
	 *
	 * @param tableConfezionati
	 * @return
	 */
	ArrayList<Confezionati> tableToArrayListConfezionati(JTable tableConfezionati);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaCodiceProdottoAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaCodiceProdottoDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaDescrizioneAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaDescrizioneDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaProduttoreFornitoreAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaProduttoreFornitoreDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaProvenienzaAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaProvenienzaDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaDataRaccoltaAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaDataRaccoltaDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaQuantitaAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaQuantitaDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaPrezzoAsc(JTable tableFrutta);

	/**
	 *
	 * @param tableFrutta
	 */
	void visualizzaTabellaFruttaOrdinaPrezzoDesc(JTable tableFrutta);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaCodiceProdottoAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaCodiceProdottoDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaDescrizioneAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaDescrizioneDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaProduttoreFornitoreAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaProduttoreFornitoreDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaProvenienzaAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaProvenienzaDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaDataRaccoltaAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaDataRaccoltaDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaQuantitaAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaQuantitaDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaPrezzoAsc(JTable tableVerdura);

	/**
	 *
	 * @param tableVerdura
	 */
	void visualizzaTabellaVerduraOrdinaPrezzoDesc(JTable tableVerdura);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaCodiceProdottoAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaCodiceProdottoDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaDescrizioneAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaDescrizioneDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaProduttoreFornitoreAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaProduttoreFornitoreDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaProvenienzaAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaProvenienzaDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaClassePesoAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaClassePesoDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaCategoriaUovaAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaCategoriaUovaDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaDataConfezionamentoAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaDataConfezionamentoDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaQuantitaAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaQuantitaDesc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaPrezzoAsc(JTable tableUova);

	/**
	 *
	 * @param tableUova
	 */
	void visualizzaTabellaUovaOrdinaPrezzoDesc(JTable tableUova);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaCodiceProdottoAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaCodiceProdottoDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDescrizioneAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDescrizioneDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaProduttoreFronitoreDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaProvenienzaAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaProvenienzaDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDataMungituraAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDataMungituraDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDataProduzioneAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaDataProduzioneDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaSenzaLattosioAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaSenzaLattosioDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaQuantitaAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaQuantitaDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaPrezzoAsc(JTable tableLatticini);

	/**
	 *
	 * @param tableLatticini
	 */
	void visualizzaTabellaLatticiniOrdinaPrezzoDesc(JTable tableLatticini);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaCodiceProdottoAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaCodiceProdottoDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaDescrizioneAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaDescrizioneDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaProduttoreFornitoreDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaProvenienzaAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaProvenienzaDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaDataScadenzaAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaDataScadenzaDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaQuantitaAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaQuantitaDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaPrezzoAsc(JTable tableFarinacei);

	/**
	 *
	 * @param tableFarinacei
	 */
	void visualizzaTabellaFarinaceiOrdinaPrezzoDesc(JTable tableFarinacei);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaCodiceProdottoAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaCodiceProdottoDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDescrizioneAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDescrizioneDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaProduttoreFornitoreDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaProvenienzaAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaProvenienzaDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDataConfezionametoAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDataConfezionametoDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDataScadenzaAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaDataScadenzaDesc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaQuantitaAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaQuantitaDesc(JTable tableConfezionati) ;

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaPrezzoAsc(JTable tableConfezionati);

	/**
	 *
	 * @param tableConfezionati
	 */
	void visualizzaTabellaConfezionatiOrdinaPrezzoDesc(JTable tableConfezionati);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 * @param categoriaUova
	 * @param classe
	 */
	void salvaProdottoUova( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
							JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
							JComboBox giorno, JComboBox mese, JComboBox anno,JComboBox categoriaUova, JComboBox classe);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 */
	void salvaProdottoFrutta( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
							  JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
							  JComboBox giorno, JComboBox mese, JComboBox anno);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 */
	void salvaProdottoVerdura( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
							   JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
							   JComboBox giorno, JComboBox mese, JComboBox anno);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 * @param giornoM
	 * @param meseM
	 * @param annoM
	 * @param senzaLattosio
	 */
	void salvaProdottoLatticini( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
										JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
										JComboBox giorno, JComboBox mese, JComboBox anno,JComboBox giornoM,
										JComboBox meseM, JComboBox annoM,JComboBox senzaLattosio);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 */
	void salvaProdottoFarinacei( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
										JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
										JComboBox giorno, JComboBox mese, JComboBox anno);

	/**
	 *
	 * @param codiceprodotto
	 * @param descrizione
	 * @param prezzo
	 * @param provenienza
	 * @param produttore
	 * @param quantita
	 * @param iva
	 * @param unita
	 * @param giorno
	 * @param mese
	 * @param anno
	 * @param giornoC
	 * @param meseC
	 * @param annoC
	 */
	void salvaProdottoConfezionati( JTextField codiceprodotto, JTextField descrizione, JTextField prezzo,
									JTextField provenienza,JTextField produttore, JTextField quantita,JTextField iva, JComboBox unita,
									JComboBox giorno, JComboBox mese, JComboBox anno, JComboBox giornoC,
									JComboBox meseC, JComboBox annoC);

	/**
	 *
	 * @param prodotto
	 * @param codiceProdotto
	 * @param Descrizione
	 * @param Prezzo
	 * @param proveninza
	 * @param produttore
	 * @param quantita
	 * @param unita
	 * @param iva
	 */
	void LeggiProdotto(Prodotto prodotto, JTextField codiceProdotto, JTextField Descrizione, JTextField Prezzo, JTextField proveninza,
					   JTextField produttore, JTextField quantita, JComboBox unita, JTextField iva);

	Carta aggiungiPagamentoCarta(JTextField codiceBancaRicevente, JTextField numeroCarta, JTextField cartaFedelta);

	Contanti aggiungiPagamentoContanti(JTextField textContanti, JTextField cartaFedelta);

	double calcolaSubTotale(ArrayList<Prodotto> carrelloArrayList, JLabel lblTotaleNumero);
	
	void leggiVal(Pagamento pagamento,JTextPane nome);
	
	Pagamento prelevaTotale(JLabel valore);
	
	void Pagamento_GUI(Pagamento pagamento, ArrayList<Prodotto> prodotto);

	void calcolaIvaSubTotale(ArrayList<Prodotto> carrelloArrayList);
}