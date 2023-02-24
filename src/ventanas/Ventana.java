package ventanas;

import javax.swing.JOptionPane;
import unidades.*;
import operaciones.Convertir;

public class Ventana {
	
	public static void Iniciar$Finalizar(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Conversor Unidades Alura", JOptionPane.DEFAULT_OPTION);
	}


	public static void SelectorUnidad() {
		try {
			String[] unidades = { "Monedas", "Temperaturas" };
			String respuesta = (String) JOptionPane.showInputDialog(null,
					"Seleccione la clase de unidad que desea convertir", "Conversor Unidades Alura",
					JOptionPane.DEFAULT_OPTION, null, unidades, unidades[0]);
			if (respuesta.equals(unidades[0])) {
				Ventana.convertirMonedas();
			} else if (respuesta.equals(unidades[1])) {
				Ventana.convertirTemperaturas();
			}
		} catch (java.lang.NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Valor no válido", "Conversor Unidades Alura", JOptionPane.DEFAULT_OPTION);
			if (Ventana.confirmarDialogo("¿Desea continuar con el programa?") != 1) {
				Ventana.SelectorUnidad();
			} else {
				Ventana.Iniciar$Finalizar("Hasta la próxima");
				System.exit(0);
			}
		}
	}


	public static void convertirMonedas() {
		Convertir sc = new Convertir();
		String[] monedas = { "UDS", "MXN", "EUR", "GBP"};

		try {

			Divisa m1 = sc.seleccion(JOptionPane.showOptionDialog(null, "Seleccione la moneda que desea convertir",
					"Moneda a Cambiar", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, monedas, monedas[0]));

			m1.setCambio(Ventana.valor());

			Divisa m2 = sc.seleccion(JOptionPane.showOptionDialog(null, "Seleccione la moneda que desea convertir",
					"Moneda de Cambio", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, monedas, monedas[0]));

			JOptionPane.showMessageDialog(null, "Usted tiene: \n" + sc.cambiar(m1, m2));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Valor no válido. El valor debe ser un número entero o decimal.\nSe retorna al selector de unidades",
					"Error", JOptionPane.DEFAULT_OPTION);
			Ventana.SelectorUnidad();
		}
	}


	public static void convertirTemperaturas() {
		Convertir sc = new Convertir();
		String[] temperaturas = { "°K", "°C", "°F" };

		try {
			Escala t1 = sc.seleccion1(JOptionPane.showOptionDialog(null,
					"Escala de temperatura a cambiar", "Temperatura a Cambiar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]));

			t1.setCambio(Ventana.valor());

			Escala t2 = sc.seleccion1(JOptionPane.showOptionDialog(null,
					"Escala de temperatura de cambio", "Temperatura de Cambio",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, temperaturas, temperaturas[0]));

			JOptionPane.showMessageDialog(null, "La temperatura es de: \n" + sc.cambiar(t1, t2));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Valor no válido. El valor debe ser un número entero o decimal.\nSe retorna al selector de unidades",
					"Conversor Unidades Alura", JOptionPane.DEFAULT_OPTION);
			Ventana.SelectorUnidad();
		}

	}


	public static int confirmarDialogo(String mensaje) {
		return JOptionPane.showConfirmDialog(null, mensaje);
	}

	public static double valor() {
		return Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor: "));
	}
}
