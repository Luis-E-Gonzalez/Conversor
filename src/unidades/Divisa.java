package unidades;

import enums.Divisas;

public class Divisa extends Unidad {
	protected double valorDolar;
	protected Divisas divisa;
	
	public Divisas getDivisa() {
		return divisa;
	}

	public double getValorDolar() {
		return valorDolar;
	}

}