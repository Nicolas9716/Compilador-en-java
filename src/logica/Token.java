/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad del Quindío (Armenia - Colombia)
 * Programa de Ingeniería de Sistemas y Computación
 *
 * Asignatura: Teoría de Lenguajes Formales
 * Ejercicio: AnalizadorLexico
 * Autor: Leonardo A. Hernández R. - Agosto 2008, sep 2013.
 * Publicado por: Claudia Elena Quiceno Restrepo- en tlf2018-1
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package logica;

/**
 * Clase que modela un token
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 */

public class Token {

	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Constante util
	 */
	final public static String NORECONOCIDO = "No reconocido";
	final public static String ERROR = "Error";

	/**
	 * Constantes para modelar los posibles tipos de token que se van a analizar
	 */

	/**
	 * Categorias Lexicas (Palabras reservadas)
	 */
	final public static String ENTERO = "Categoria Entero"; //znum
	final public static String DECIMAL = "Categoria Decimal";//qnum
	final public static String CARACTER = "Categoria Caracter";//#val
	final public static String CADENA = "Categoria Cadena";//$val
	final public static String BOOLEANO = "Categoria Booleano";//tof

	/**
	 * Identificadores de variable
	 */
	final public static String ENTEROI = "Entero";// (Digito)z
	final public static String DECIMALI = "Decimal";// (digito . Digito)q
	final public static String CARACTERI = "Caracter";// (caracter)#
	final public static String CADENAI = "Cadena";// $(cualquier cosa)$
	final public static String BOOLEANOI = "Booleano";// |(uno o cero)

	/**
	 * Identificador de metodo
	 */
	final public static String METODO = "Metodo";
	final public static String CLASE = "Clase";

	/**
	 * Palabras reservadas
	 */
	final public static String AS = "Ciclo for"; // as(Cliclo for)
	final public static String DURING = "Ciclo While"; // during(Ciclo While)
	final public static String VACANT = "void"; // vacant(void)
	final public static String CRACK = "break"; // crack(break)
	final public static String CONDITION = " if"; // condition (if)
	final public static String OTHER = "else"; // other (else)
	final public static String LEVEL = "Clase"; // level(clase)
	final public static String CONSTANT = "final"; // constant(final)
	final public static String INTERFAZ = "interface"; // interfaz(interface)
	final public static String ACTUAL = "new"; // actual(new)
	final public static String MASP = "private"; // +p(private)
	final public static String MENOSP = "public"; // -p(publico)
	final public static String PALABRARESERVADA="palabra Reservada";

	/**
	 * Operadores Aditivos
	 */
	final public static String SUM = "Operador de suma"; // SUM(+)
	final public static String RES = "Operador de resta"; // RES(-)

	/**
	 * Operadores Multiplicativos
	 */
	final public static String MULT = "Operador de multiplicacion"; // MULT(*)
	final public static String DIV = "Operador de division"; // DIV(/)

	/**
	 * Operador de asignacion
	 */
	final public static String ASIGNACION = "Asignacion"; // ==(Asignar)

	/**
	 * Operadores de incremento y decremento
	 */

	final public static String INCREMENTO = "Incremento"; // INCR (++)

	final public static String DECREMENTO = "Decremento"; // DECR (--)
	/**
	 * Operadores Relacionales
	 */
	final public static String MIN = "Menor que  Operador relacional"; // min(<)
	final public static String MAX = "Mayor que Operador relacional"; // max(>)
	final public static String MIN_ = "Menor o igual que Operador relacional"; // min_(<=)
	final public static String MAX_ = "Mayor o igual que Operador relacional"; // max_(>=)
	final public static String IGUALA = "Igual a Operador relacional"; // === (Igual a )
	final public static String DIFERENTEQUE = "Dirente Que Operador relacional"; // dif==(!=)

	/**
	 * Operadores Logicos
	 */
	final public static String AND = "AND"; // AND (&)
	final public static String OR = "OR"; // OR (|)

	/**
	 * Terminales O inicializadores
	 */
	final public static String PUNTOYCOMA = " Punto y Coma"; // ..(;)
	final public static String LLAVES = "Llaves "; // ¡!( {} )
	final public static String CORCHETES = "Corchetes"; // ¿? ( [] )
	final public static String PARENTESIS = "Parentesis"; // [] ( () )

	// Poner separador ,

	final public static String SEPARADOR = "Separador"; // - (,)
	// Poner punto .

	final public static String PUNTO = "Punto"; //  > (.)

	// Poner comentarios //* //
	final public static String COMENTARIO_LINEA = "Comentario de linea"; // -- (//)

	final public static String COMENTARIO_BLOQUE = "Comentario de bloque"; // *-** *-* ( /** */)
	/**
	 * 
	 */
	/**
	 * Tokens Elegidos
	 */

	final public static String DES = "Desabilitar una variable momentaneamente(Token Elegido)";
	final public static String CON = "Habilitar una variable detenida(Token Elegido)";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Lexema
	 */
	private String lexema;

	/**
	 * tipo
	 */
	private String tipo;

	/**
	 * posición del siguiente lexema
	 */
	private int indiceSiguiente;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor de un token
	 * 
	 * @param elLexema          - cadena - laCadena != null
	 * @param elTipo            - tipo del token - elTipo != null
	 * @param elIndiceSiguiente - posición del siguiente token - laPosicionSiguiente
	 *                          > 0
	 */
	public Token(String elLexema, String elTipo, int elIndiceSiguiente) {
		lexema = elLexema;
		tipo = elTipo;
		indiceSiguiente = elIndiceSiguiente;
	}

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	/**
	 * Entrega la información del token
	 * 
	 * @return Descripción del token
	 */
	public String darDescripcion() {
		return "Token: " + lexema + "     Tipo: " + tipo + "     Índice del siguiente: " + indiceSiguiente;
	}

	/**
	 * Método que retorna el lexema del token
	 * 
	 * @return el lexema del token
	 */
	public String darLexema() {
		return lexema;
	}

	/**
	 * Método que retorna la posición del siguiente lexema
	 * 
	 * @return posición del siguiente token
	 */
	public int darIndiceSiguiente() {
		return indiceSiguiente;
	}

	/**
	 * Método que retorna el tipo del token
	 * 
	 * @return el tipo del token
	 */
	public String darTipo() {
		return tipo;
	}

}
