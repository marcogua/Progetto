package Classi;

public class Pagamento {
    private double totale;
    private String dataAcquisto;
    private int puntiGenerati;

    public Pagamento(double totale, String dataAcquisto, int puntiGenerati) {
        this.totale = totale;
        this.dataAcquisto = dataAcquisto;
        this.puntiGenerati = puntiGenerati;
    }


    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public String getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(String dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public int getPuntiGenerati() {
        return puntiGenerati;
    }

    public void setPuntiGenerati(int puntiGenerati) {
        this.puntiGenerati = puntiGenerati;
    }

    public int calcolaPunti(double totale){
        return puntiGenerati;
    }
}
