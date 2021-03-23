package Classi;

import java.util.ArrayList;
import java.util.Comparator;

public class TesseraPunti {
    private String codiceTessera;
    private String nomeIntestatario;
    private int saldoPunti;
    private double puntiFrutta;
    private double puntiVerdura;
    private double puntiUova;
    private double puntiFarinacei;
    private double puntiConfezionati;
    private double puntiLatticini;
    private String codiceCliente;
    
    public TesseraPunti() {
    	this.codiceTessera = null;
        this.nomeIntestatario = null;
        this.saldoPunti = 0;
        this.puntiFrutta = 0;
        this.puntiVerdura = 0;
        this.puntiUova = 0;
        this.puntiFarinacei = 0;
        this.puntiConfezionati = 0;
        this.puntiLatticini = 0;
        this.codiceCliente = null;
    }
    
    public TesseraPunti(String codiceClienti, String codiceTessera, String nome) {
    	this.codiceTessera = codiceTessera;
        this.nomeIntestatario = nome;
        this.saldoPunti = 0;
        this.puntiFrutta = 0;
        this.puntiVerdura = 0;
        this.puntiUova = 0;
        this.puntiFarinacei = 0;
        this.puntiConfezionati = 0;
        this.puntiLatticini = 0;
        this.codiceCliente = codiceClienti;
    }

    public TesseraPunti(String codiceTessera, String nomeIntestatario, int saldoPunti, 
    		int puntiFrutta, int puntiVerdura, int puntiUova, int puntiFarinacei, 
    		int puntiConfezionati, int puntiLatticini, String codiceCliente) {
        this.codiceTessera = codiceTessera;
        this.nomeIntestatario = nomeIntestatario;
        this.saldoPunti = saldoPunti;
        this.puntiFrutta = puntiFrutta;
        this.puntiVerdura = puntiVerdura;
        this.puntiUova = puntiUova;
        this.puntiFarinacei = puntiFarinacei;
        this.puntiConfezionati = puntiConfezionati;
        this.puntiLatticini = puntiLatticini;
        this.codiceCliente = codiceCliente;
    }

    public String getCodiceTessera() {
        return codiceTessera;
    }

    public void setCodiceTessera(String codiceTessera) {
        this.codiceTessera = codiceTessera;
    }

    public String getNomeIntestatario() {
        return nomeIntestatario;
    }

    public void setNomeIntestatario(String nomeIntestatario) {
        this.nomeIntestatario = nomeIntestatario;
    }

    public int getSaldoPunti() {
        return saldoPunti;
    }

    public void setSaldoPunti(int saldoPunti) {
        this.saldoPunti = saldoPunti;
    }

    public double getPuntiFrutta() {
        return puntiFrutta;
    }

    public void setPuntiFrutta(double puntiFrutta) {
        this.puntiFrutta = puntiFrutta;
    }

    public double getPuntiVerdura() {
        return puntiVerdura;
    }

    public void setPuntiVerdura(double puntiVerdura) {
        this.puntiVerdura = puntiVerdura;
    }

    public double getPuntiUova() {
        return puntiUova;
    }

    public void setPuntiUova(double puntiUova) {
        this.puntiUova = puntiUova;
    }

    public double getPuntiFarinacei() {
        return puntiFarinacei;
    }

    public void setPuntiFarinacei(double puntiFarinacei) {
        this.puntiFarinacei = puntiFarinacei;
    }

    /**
     *
     * @return
     */
    public double getPuntiConfezionati() {
        return puntiConfezionati;
    }

    /**
     *
     * @param puntiConfezionati
     */
    public void setPuntiConfezionati(double puntiConfezionati) {
        this.puntiConfezionati = puntiConfezionati;
    }

    /**
     *
     * @return
     */
    public double getPuntiLatticini() {
        return puntiLatticini;
    }

    /**
     *
     * @param puntiLatticini
     */
    public void setPuntiLatticini(double puntiLatticini) {
        this.puntiLatticini = puntiLatticini;
    }
    
    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }
    
    public TesseraPunti calcolaPunti(double totale, ArrayList<Prodotto> listaPrdotti, TesseraPunti tessera) {
    	int puntiGenerati = 0;
		double puntiFruttaGenerati, puntiVerduraGenerati, puntiFarinaceiGenerati,
		puntiLatticiniGenerati, puntiUovaGenerati, puntiConfezionatiGenerati;
		puntiGenerati = (int) (totale * 10 /100);
		tessera.setSaldoPunti(tessera.getSaldoPunti() + puntiGenerati);
		for (Prodotto prodotto : listaPrdotti) {
			if(prodotto.getCodiceProdotto().startsWith("FR")) {
				puntiFruttaGenerati =((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiFrutta(tessera.getPuntiFrutta() + puntiFruttaGenerati);
			}else if(prodotto.getCodiceProdotto().startsWith("VE")) {
				puntiVerduraGenerati = ((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiVerdura(tessera.getPuntiVerdura() + puntiVerduraGenerati);
			}else if(prodotto.getCodiceProdotto().startsWith("FA")) {
				puntiFarinaceiGenerati = ((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiFarinacei(tessera.getPuntiFarinacei() + puntiFarinaceiGenerati);
			}else if(prodotto.getCodiceProdotto().startsWith("LA")) {
				puntiLatticiniGenerati = ((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiLatticini(tessera.getPuntiLatticini() + puntiLatticiniGenerati);
			}else if(prodotto.getCodiceProdotto().startsWith("UO")) {
				puntiUovaGenerati = ((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiUova(tessera.getPuntiUova() + puntiUovaGenerati);
			}else if(prodotto.getCodiceProdotto().startsWith("CO")) {
				puntiConfezionatiGenerati = ((((prodotto.getPrezzo() * prodotto.getQuantita()) * (double)puntiGenerati)) / totale);
				tessera.setPuntiConfezionati(tessera.getPuntiConfezionati() + puntiConfezionatiGenerati);
			}
		}
		return tessera;
	}
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiCodiceTessera(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getCodiceTessera));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiNomeIntestatario(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getNomeIntestatario));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiSaldoPunti(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getSaldoPunti));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiFrutta(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiFrutta));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiVerdura(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiVerdura));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiUova(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiUova));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiFarinacei(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiFarinacei));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiConfezionati(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiConfezionati));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiPuntiLatticini(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getPuntiLatticini));
    	return tesseraPuntiArrayList;
    }
    
    public ArrayList<TesseraPunti> OrdinaTesseraPuntiCodiceCliente(ArrayList<TesseraPunti> tesseraPuntiArrayList){
    	tesseraPuntiArrayList.sort(Comparator.comparing(TesseraPunti::getCodiceCliente));
    	return tesseraPuntiArrayList;
    }
}
