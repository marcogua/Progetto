package Classi;

import java.util.Random;

public class GenerateId {
	private final static String LETTERE = "abcdefghijklmnopqrstuvwxyz";
	private final static char[] ALFANUMERICHE = (LETTERE.toUpperCase() + "0123456789").toCharArray();
	
	public static void main(String[] args) {
		
	}
	public static String generatoreCodiceCliente() {
		StringBuilder result = new StringBuilder();
		result.append("IT");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}
	
	public static String generatoreCodiceTessera() {
		StringBuilder result = new StringBuilder();
		result.append("TS");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreFrutta() {
		StringBuilder result = new StringBuilder();
		result.append("FR");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreVerdura() {
		StringBuilder result = new StringBuilder();
		result.append("VE");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreUova() {
		StringBuilder result = new StringBuilder();
		result.append("UO");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreFarinacei() {
		StringBuilder result = new StringBuilder();
		result.append("FA");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreLatticini() {
		StringBuilder result = new StringBuilder();
		result.append("LA");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreConfezionati() {
		StringBuilder result = new StringBuilder();
		result.append("CO");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreOrdine() {
		StringBuilder result = new StringBuilder();
		result.append("OR");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}

	public static String generatoreListaProdotti() {
		StringBuilder result = new StringBuilder();
		result.append("LP");
		for(int i=0;i<14;i++) {
			result.append(ALFANUMERICHE[new Random().nextInt(ALFANUMERICHE.length)]);
		}
		return result.toString();
	}
	
}
