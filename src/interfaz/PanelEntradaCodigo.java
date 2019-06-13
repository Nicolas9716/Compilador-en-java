package interfaz;
/**
 * Panel para ingresar texto al analizador léxico
 */

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Panel donde se ingresa el codigo
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 *
 */
public class PanelEntradaCodigo extends JPanel implements ActionListener {

	// -----------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------

	private static final String VERTOKENS = "VER TOKENS";

	// -----------------------------------------------------------
	// Atributos de interfaz
	// -----------------------------------------------------------

	/**
	 * Ventana principal
	 */
	private InterfazAnalizadorLexico ventanaPrincipal;

	/**
	 * Etiqueta código
	 */
	private JLabel etiquetaCodigo;

	/**
	 * Campo donde se ingresa el código fuente
	 */
	private JTextField campoCodigo;

	/**
	 * Botón ver tokens
	 */
	private JButton botonVerTokens;

	// -----------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------

	/**
	 * Constructor del panel.
	 * 
	 * @param principal Ventana principal. principal != null.
	 */
	public PanelEntradaCodigo(InterfazAnalizadorLexico principal) {
		ventanaPrincipal = principal;
//        setLayout( new GridLayout( 1, 10 ) );

		etiquetaCodigo = new JLabel("Código que se desea analizar: ");
		campoCodigo = new JTextField(40);
		botonVerTokens = new JButton("Mostrar Tokens");
		botonVerTokens.addActionListener(this);
		botonVerTokens.setActionCommand(VERTOKENS);

		etiquetaCodigo.setBounds(100, 100, 20, 20);

		add(etiquetaCodigo);
		add(campoCodigo);
		add(botonVerTokens);
	}

	// -----------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------

	/**
	 * Responde ante las acciones en el panel.
	 * 
	 * @param e Evento que generó la acción.
	 */
	public void actionPerformed(ActionEvent e) {
//        if( e.getActionCommand( ) == VERTOKENS )
		if (e.getActionCommand().equals(VERTOKENS)) {
			ventanaPrincipal.verTokens(campoCodigo.getText());
		}

	}
}
