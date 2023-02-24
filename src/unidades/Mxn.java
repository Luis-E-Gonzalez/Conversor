package unidades;
import enums.Divisas;

public class Mxn extends Divisa{
	
	public Mxn(double cambio) {
		super.divisa = Divisas.MXN;
		super.valorDolar = 0.054;
		super.cambio = cambio;
	}
}
