package Classi;

public class Carta extends Pagamento{
    private String codiceCarta;
    private String codiceBancaRicevente;
    
    public Carta() {}

    public Carta(double totale, String dataAcquisto, int puntiGenerati, String codiceCarta, String codiceBancaRicevente) {
        super(totale, dataAcquisto, puntiGenerati);
        this.codiceCarta = codiceCarta;
        this.codiceBancaRicevente = codiceBancaRicevente;
    }

    public String getCodiceCarta() {
        return codiceCarta;
    }

    public void setCodiceCarta(String codiceCarta) {
        this.codiceCarta = codiceCarta;
    }

    public String getCodiceBancaRicevente() {
        return codiceBancaRicevente;
    }

    public void setCodiceBancaRicevente(String codiceBancaRicevente) {
        this.codiceBancaRicevente = codiceBancaRicevente;
    }
}
