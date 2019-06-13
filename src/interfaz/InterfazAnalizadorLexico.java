package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import logica.AnalizadorLexico;
import logica.Token;

/**
 * Ventana principal de la aplicación
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 */
public class InterfazAnalizadorLexico extends JFrame implements ActionListener {

	// -----------------------------------------------------------
	// Atributos de interfaz
	// -----------------------------------------------------------

	/**
	 * Panel donde se muestran los resultados
	 */
	private PanelEntradaCodigo panelEntradaCodigo;

	/**
	 * El diálogo usado para mostrar los tokens
	 */
	private DialogoTokens dialogoTokens;

	/**
	 * Analizador léxico
	 */
	private AnalizadorLexico analizadorLexico;

	private JLabel lbltitulo, lblintro;
	private JButton btnAutomata;

	// -----------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------

	/**
	 * Constructor de la interfaz
	 */
	public InterfazAnalizadorLexico(AnalizadorLexico aL) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setTitle("Analizador Léxico");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		Panel p1 = new Panel("/imagenes/cabecera.jpg");
		add(p1);

		lbltitulo = new JLabel("                            MOTTAN ");
		Font fuente = new Font("Calibri", 3, 36);
		lbltitulo.setFont(fuente);
		lbltitulo.setForeground(Color.BLUE);
		lbltitulo.setBounds(40, 60, 100, 25);
		add(lbltitulo);

		lblintro = new JLabel("   Lenguaje creado por : " + "\n" + " Sebastian Camilo Anttury " + " & "
				+ " Juan David Romero " + " & " + " Nicolás Palacios ");
		Font fuente1 = new Font("Times New York", 2, 12);
		lblintro.setFont(fuente1);
		lblintro.setForeground(Color.black);
		lblintro.setBounds(80, 120, 100, 25);
		add(lblintro);

		setLayout(new GridLayout(6, 4));
		setBackground(Color.BLUE);
		analizadorLexico = new AnalizadorLexico();
		panelEntradaCodigo = new PanelEntradaCodigo(this);
		dialogoTokens = new DialogoTokens();
		dialogoTokens.setModal(true);
		add(panelEntradaCodigo);
		btnAutomata = new JButton("Automata");
		btnAutomata.setBounds(100, 500, 80, 25);
		add(btnAutomata);

		btnAutomata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana v = new Ventana();
				v.setSize(800, 1500);
				v.setVisible(true);
				Panel p = new Panel("/imagenes/Automata.png");
				v.add(p);
			}
		});
		Panel p2 = new Panel("/imagenes/SLOGAN-UQ.png");
		add(p2);
		pack();
		centrarFrame();

	}

	// -----------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------

	/**
	 * Centra el frame en la pantalla según resolución
	 */
	private void centrarFrame() {
		Dimension screenSize = getToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		setLocation(((screenWidth / 2) - (getWidth() / 2)), ((screenHeight / 2) - (getHeight() / 2)));
	}

	/**
	 * Método usado para ver los tokens del código ingresada param codigo código
	 * fuente que se va a analizar
	 */
	public void verTokens(String codigo) {
		if (!codigo.equals("")) {
			ArrayList vectorTokens;
			vectorTokens = analizadorLexico.extraerTokens(codigo);
			ArrayList vectorTokensEditados = new ArrayList();
			Token token;

			for (int i = 0; i < vectorTokens.size(); i++) {
				token = (Token) vectorTokens.get(i);
				vectorTokensEditados.add(token.darDescripcion());
			}

			dialogoTokens.setSize(450, 200);
			dialogoTokens.cambiarListaTokens(vectorTokensEditados);
			dialogoTokens.setLocation(calculaPosicionCentral(this, dialogoTokens));
			dialogoTokens.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "No ha ingresado un codigo para analizar", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Calcula el punto que indica la posición centrada del frame
	 * 
	 * @param componentePadre - Ventana Padre del componente - !=null
	 * @param componenteHijo  - Ventana Hija del componente - !=null
	 * @return punto - Localizacion en coordinadas x,y del nuevo componente - !=null
	 */
	private Point calculaPosicionCentral(Component componentePadre, Component componenteHijo) {
		Dimension tamanoPantalla, tamanoPadre, tamanoHijo;
		Point localizacionPadre;

		// Centra la ventana y verifica que no sea mayor que la resolución
		// actual
		tamanoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
		int max_y = tamanoPantalla.height;
		int min_y = 0;

		// Tamaño de la resolucion de la pantalla
		tamanoPadre = componentePadre.getSize();
		localizacionPadre = componentePadre.getLocation();
		tamanoHijo = componenteHijo.getSize();
		int x = (tamanoPadre.width - tamanoHijo.width) / 2 + localizacionPadre.x;
		int y = tamanoPadre.height + localizacionPadre.y;

		// Ajuste para abajo
		if (y + tamanoHijo.height > max_y) {
			y = max_y - tamanoHijo.height;
		}

		// Ajuste para arriba
		if (y < min_y) {
			y = 0;
		}
		return new Point(x, y);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
