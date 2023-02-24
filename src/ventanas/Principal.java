package ventanas;

public class Principal {
	
public static void main(String[] args) {
		
		Ventana.Iniciar$Finalizar("Bienvenido al Conversor de Unidades Alura");
		do {
			Ventana.SelectorUnidad();
		} while(Ventana.confirmarDialogo("¿Desea realizar otra conversión?") != 1);
		Ventana.Iniciar$Finalizar("Hasta la próxima");
	}

}
