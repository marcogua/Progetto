package Classi;

import java.util.Random;

public class GenerateCode {
	private final static String LETTERE = "abcdefghijklmnopqrstuvwxyz";
	private final static char[] ALFANUMERICHE = (LETTERE.toUpperCase() + "0123456789").toCharArray();
	
	private StringBuilder result;

	public String generatoreCodiceCliente() {
		result = new StringBuilder();
		result.append("IT");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}
	
	public String generatoreCodiceTessera() {
		result = new StringBuilder();
		result.append("TS");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreFrutta() {
		result = new StringBuilder();
		result.append("FR");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreVerdura() {
		result = new StringBuilder();
		result.append("VE");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreUova() {
		result = new StringBuilder();
		result.append("UO");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreFarinacei() {
		result = new StringBuilder();
		result.append("FA");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreLatticini() {
		result = new StringBuilder();
		result.append("LA");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreConfezionati() {
		result = new StringBuilder();
		result.append("CO");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreOrdine() {
		result = new StringBuilder();
		result.append("OR");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public String generatoreListaProdotti() {
		result = new StringBuilder();
		result.append("LP");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}
	
	public void stampa(String code) {
		System.out.println(code);
	}
	
}
