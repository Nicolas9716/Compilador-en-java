package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Sirve para situar imagenes en las ventanas
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 *
 */
public class Panel extends JPanel {

	ImageIcon imagen, imagen2;
	String url;

	public Panel(String url) {
		this.url = url;
	}

	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource(url));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);

	}
}
