package unidades;
import enums.Divisas;

public class Usd extends Divisa {
	
	public Usd (double cambio) {
		super.divisa = Divisas.USD;
		super.valorDolar = 1.0;
		super.cambio = cambio;
	}
}
