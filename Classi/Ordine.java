package Classi;

import java.util.ArrayList;

public class Ordine {
	
	private String numeroOrdine;
	private double totaleOrdine;
	private String dataRegistrazione;
	private String codiceCliente;
	private String codiceTessera;
	private String idLista;
	private String tipoPagamento;
	private String codiceCarta;
	private double soldiRicevuti;
	private int totalePuntiGenerati = 0;
	private double puntiFruttaGenerati = 0;
	private double puntiVerduraGenerati = 0;
	private double puntiFarinaceiGenerati = 0;
	private double puntiLatticiniGenerati = 0;
	private double puntiUovaGenerati = 0;
	private double puntiConfezionatiGenerati = 0;
	
	public Ordine() {}
	
	

	public Ordine(String numeroOrdine, double totaleOrdine, String dataRegistrazione,
			String codiceCliente, String codiceTessera, String idLista, String tipoPagamento, String codiceCarta,
			int totalePuntiGenerati, double puntiFruttaGenerati,
			double puntiVerduraGenerati, double puntiFarinaceiGenerati, double puntiLatticiniGenerati,
			double puntiUovaGenerati, double puntiConfezionatiGenerati) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.totaleOrdine = totaleOrdine;
		this.dataRegistrazione = dataRegistrazione;
		this.codiceCliente = codiceCliente;
		this.codiceTessera = codiceTessera;
		this.idLista = idLista;
		this.tipoPagamento = tipoPagamento;
		this.codiceCarta = codiceCarta;
		this.totalePuntiGenerati = totalePuntiGenerati;
		this.puntiFruttaGenerati = puntiFruttaGenerati;
		this.puntiVerduraGenerati = puntiVerduraGenerati;
		this.puntiFarinaceiGenerati = puntiFarinaceiGenerati;
		this.puntiLatticiniGenerati = puntiLatticiniGenerati;
		this.puntiUovaGenerati = puntiUovaGenerati;
		this.puntiConfezionatiGenerati = puntiConfezionatiGenerati;
	}



	public String getTipoPagamento() {
		return tipoPagamento;
	}



	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}



	public String getCodiceCarta() {
		return codiceCarta;
	}



	public void setCodiceCarta(String codiceCarta) {
		this.codiceCarta = codiceCarta;
	}

	public String getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(String dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(String numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public double getTotaleOrdine() {
		return totaleOrdine;
	}

	public void setTotaleOrdine(double totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}
	
	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public String getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(String codiceTessera) {
		this.codiceTessera = codiceTessera;
	}
	
	public String getIdLista() {
		return idLista;
	}



	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}



	public double getSoldiRicevuti() {
		return soldiRicevuti;
	}



	public void setSoldiRicevuti(double soldiRicevuti) {
		this.soldiRicevuti = soldiRicevuti;
	}



	public int getTotalePuntiGenerati() {
		return totalePuntiGenerati;
	}

	public void setTotalePuntiGenerati(int totalePuntiGenerati) {
		this.totalePuntiGenerati = totalePuntiGenerati;
	}

	public double getPuntiFruttaGenerati() {
		return puntiFruttaGenerati;
	}

	public void setPuntiFruttaGenerati(double puntiFruttaGenerati) {
		this.puntiFruttaGenerati = puntiFruttaGenerati;
	}

	public double getPuntiVerduraGenerati() {
		return puntiVerduraGenerati;
	}

	public void setPuntiVerduraGenerati(double puntiVerduraGenerati) {
		this.puntiVerduraGenerati = puntiVerduraGenerati;
	}

	public double getPuntiFarinaceiGenerati() {
		return puntiFarinaceiGenerati;
	}

	public void setPuntiFarinaceiGenerati(double puntiFarinaceiGenerati) {
		this.puntiFarinaceiGenerati = puntiFarinaceiGenerati;
	}

	public double getPuntiLatticiniGenerati() {
		return puntiLatticiniGenerati;
	}

	public void setPuntiLatticiniGenerati(double puntiLatticiniGenerati) {
		this.puntiLatticiniGenerati = puntiLatticiniGenerati;
	}

	public double getPuntiUovaGenerati() {
		return puntiUovaGenerati;
	}

	public void setPuntiUovaGenerati(double puntiUovaGenerati) {
		this.puntiUovaGenerati = puntiUovaGenerati;
	}

	public double getPuntiConfezionatiGenerati() {
		return puntiConfezionatiGenerati;
	}

	public void setPuntiConfezionatiGenerati(double puntiConfezionatiGenerati) {
		this.puntiConfezionatiGenerati = puntiConfezionatiGenerati;
	}
	
	public int calcolaPunti(double totale, ArrayList<Prodotto> listaPrdotti) {
		int puntiGenerati = 0;
		puntiGenerati = (int) (totale * 10 /100);
		for (Prodotto prodotto : listaPrdotti) {
			if(prodotto.getCodiceProdotto().compareTo("Frutta") == 0) {
				puntiFruttaGenerati++;
			}else if(prodotto.getCodiceProdotto().compareTo("Verdura") == 0) {
				puntiVerduraGenerati++;
			}else if(prodotto.getCodiceProdotto().compareTo("Farinacei") == 0) {
				puntiFarinaceiGenerati++;
			}else if(prodotto.getCodiceProdotto().compareTo("Latticini") == 0) {
				puntiLatticiniGenerati++;
			}else if(prodotto.getCodiceProdotto().compareTo("Uova") == 0) {
				puntiUovaGenerati++;
			}else if(prodotto.getCodiceProdotto().compareTo("Confezionati") == 0) {
				puntiConfezionatiGenerati++;
			}
		}
		return puntiGenerati;
	}



	
}
