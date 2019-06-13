package aplicacion;

import java.awt.Color;

import interfaz.InterfazAnalizadorLexico;
import logica.AnalizadorLexico;
/**
 * Clase principal que contiene el metodo main necesario para iniciar el proyecto
 * @author Juan David Romero, Sebastian Camilo Anttury
 *
 */
public class Aplicacion {

	// -----------------------------------------------------------------
	// Main
	// -----------------------------------------------------------------

	/**
	 * Ejecuta la aplicación
	 * 
	 * @param args
	 *            Son los parámetros de la línea de comandos. No se utilizan.
	 */
	public static void main(String[] args) {
		AnalizadorLexico aL=new AnalizadorLexico();
		InterfazAnalizadorLexico interfaz = new InterfazAnalizadorLexico(aL);
		interfaz.setSize(600, 400);
		interfaz.setVisible(true);
		interfaz.setBackground(Color.WHITE);	
	}
}
