package Classi;

public class TesseraPunti {
    private String codiceTessera;
    private String nomeIntestatario;
    private int saldoPunti;
    private int puntiFrutta;
    private int puntiVerdura;
    private int puntiUova;
    private int puntiFarinacei;
    private int puntiConfezionati;
    private int puntiLatticini;
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

    public int getPuntiFrutta() {
        return puntiFrutta;
    }

    public void setPuntiFrutta(int puntiFrutta) {
        this.puntiFrutta = puntiFrutta;
    }

    public int getPuntiVerdura() {
        return puntiVerdura;
    }

    public void setPuntiVerdura(int puntiVerdura) {
        this.puntiVerdura = puntiVerdura;
    }

    public int getPuntiUova() {
        return puntiUova;
    }

    public void setPuntiUova(int puntiUova) {
        this.puntiUova = puntiUova;
    }

    public int getPuntiFarinacei() {
        return puntiFarinacei;
    }

    public void setPuntiFarinacei(int puntiFarinacei) {
        this.puntiFarinacei = puntiFarinacei;
    }

    /**
     *
     * @return
     */
    public int getPuntiConfezionati() {
        return puntiConfezionati;
    }

    /**
     *
     * @param puntiConfezionati
     */
    public void setPuntiConfezionati(int puntiConfezionati) {
        this.puntiConfezionati = puntiConfezionati;
    }

    /**
     *
     * @return
     */
    public int getPuntiLatticini() {
        return puntiLatticini;
    }

    /**
     *
     * @param puntiLatticini
     */
    public void setPuntiLatticini(int puntiLatticini) {
        this.puntiLatticini = puntiLatticini;
    }
    
    public String getCodiceCliente() {
        return codiceCliente;
    }

    public void setCodiceCliente(String codiceCliente) {
        this.codiceCliente = codiceCliente;
    }
}
