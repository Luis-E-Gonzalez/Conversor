package unidades;
import enums.Divisas;

public class Gbp extends Divisa{
	
	public Gbp(double cambio) {
		super.divisa = Divisas.GBP;
		super.valorDolar = 1.2316;
		super.cambio = cambio;
	}
}
