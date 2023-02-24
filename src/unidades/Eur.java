package unidades;
import enums.Divisas;

public class Eur extends Divisa{

	public Eur(double cambio) {
		super.divisa = Divisas.EUR;
		super.valorDolar = 1.05;
		super.cambio = cambio;
	}
}
