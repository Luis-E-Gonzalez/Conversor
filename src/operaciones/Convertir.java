package operaciones;

import unidades.*;
import enums.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Convertir {
	
	private DecimalFormat df = new DecimalFormat("###.##"); 
	
	public Divisa seleccion(int seleccion) {
		try {
			switch (seleccion) {
			case 0:
				return new Usd(1.0);
			case 1:
				return new Mxn(1.0);
			case 2:
				return new Eur(1.0);
			case 3:
				return new Gbp(1.0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha detectado un error inesperado.\nEl programa se cerrará",
					"CONVERSOR DE UNIDADES", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return null;
	}

	public Escala seleccion1(int seleccion) {
		try {
			switch (seleccion) {
			case 0:
				return new Kelvin(1.0);
			case 1:
				return new Centigrado(1.0);
			case 2:
				return new Fahrenheit(1.0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha detectado un error inesperado.\nEl programa se cerrará",
					"CONVERSOR DE UNIDADES", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return null;
	}

	public String cambiar(Divisa m1, Divisa m2) {
		try {
			double operacionCambio = m1.getCambio() / m2.getValorDolar() * m1.getValorDolar();
			return df.format(m1.getCambio()) + " " +  m1.getDivisa()+ " = " +df.format(operacionCambio) + " "
					+ m2.getDivisa() ;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha detectado un error inesperado.\nEl programa se cerrará",
					"CONVERSOR DE UNIDADES", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return null;
	}


	public String cambiar(Escala t1, Escala t2) {
		try {
			double oc = 0.0;
			if (t1.getTemperatura() == Escalas.Centigrados && t2.getTemperatura() == Escalas.Kelvin) {
				oc = t1.getCambio() + 273.15;
			} else if (t1.getTemperatura() == Escalas.Centigrados && t2.getTemperatura() == Escalas.Fahrenheit) {
				oc =  (t1.getCambio() * (9.0/5.0)) + 32.0;
			} else if (t1.getTemperatura() == Escalas.Fahrenheit && t2.getTemperatura() == Escalas.Kelvin) {
				oc = ((t1.getCambio() - 32.0) * (5.0/9.0)) + 273.15;
			} else if (t1.getTemperatura() == Escalas.Fahrenheit && t2.getTemperatura() == Escalas.Centigrados) {
				oc = ((t1.getCambio() - 32.0) * (5.0/9.0));
			} else if (t1.getTemperatura() == Escalas.Kelvin && t2.getTemperatura() == Escalas.Centigrados) {
				oc = t1.getCambio() - 273.15;
			} else if (t1.getTemperatura() == Escalas.Kelvin && t2.getTemperatura() == Escalas.Fahrenheit) {
				oc = ((t1.getCambio() - 273.15) * (9.0/5.0)) + 32.0;
			} else if (t1.getTemperatura() == t2.getTemperatura()) {
				oc = t1.getCambio();
			}
			return df.format(t1.getCambio()) + " " + t1.getTemperatura() + " = " + df.format(oc) + " "
					+ t2.getTemperatura();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Se ha detectado un error inesperado.\nEl programa se cerrará",
					"CONVERSOR DE UNIDADES", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return null;
	}
}
