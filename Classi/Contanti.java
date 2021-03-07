package Classi;

public class Contanti extends Pagamento{
    private double soldiRicevuti;
    private double resto;
    
    public Contanti() {
    	super();
    	this.soldiRicevuti = 0;
    	this.resto = 0;
    }

    public Contanti(double totale, String dataAcquisto, int puntiGenerati, double soldiRicevuti, double resto) {
        super(totale, dataAcquisto, puntiGenerati);
        this.soldiRicevuti = soldiRicevuti;
        this.resto = resto;
    }

    public double getSoldiRicevuti() {
        return soldiRicevuti;
    }

    public void setSoldiRicevuti(double soldiRicevuti) {
        this.soldiRicevuti = soldiRicevuti;
    }

    public double getResto() {
        return resto;
    }

    public void setResto(double resto) {
        this.resto = resto;
    }
    public double calcolaResto(double soldiRicevuti){
        return resto;
    }
}
