package interfaz;

import javax.swing.JFrame;

/**
 * Ventana que permite mostrar el automata
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 *
 */
public class Ventana extends JFrame {

	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setSize(600, 700);
		v.setVisible(true);
		Panel p = new Panel("/imagenes/Automata.png");
		v.add(p);
	}
}
