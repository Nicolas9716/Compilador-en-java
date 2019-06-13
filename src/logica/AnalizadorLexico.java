package logica;

import java.util.ArrayList;

/**
 * Clase que modela un analizador léxico
 * 
 * @author Juan David Romero, Sebastian Camilo Anttury, Nicolas Palacios Rios
 */

public class AnalizadorLexico {

	/**
	 * ArrayList con las palabras reservadas del Lenduaje Mottan
	 */
	private ArrayList<String> palabrasReservadas;

	// -----------------------------------------------------------------
	// Métodos
	// -----------------------------------------------------------------

	public AnalizadorLexico() {

		this.palabrasReservadas = new ArrayList<String>();
		ponerPalabrasReservadas();

	}

	/**
	 * Metodo para llenar la lista de las palabras reservadas
	 */
	public void ponerPalabrasReservadas() {
		palabrasReservadas.add("qnum");
		palabrasReservadas.add("znum");
		palabrasReservadas.add("#val");
		palabrasReservadas.add("$val");
		palabrasReservadas.add("tof");
		palabrasReservadas.add("during");
		palabrasReservadas.add("vacant");
		palabrasReservadas.add("crack");
		palabrasReservadas.add("condition");
		palabrasReservadas.add("other");
		palabrasReservadas.add("level");
		palabrasReservadas.add("constant");
		palabrasReservadas.add("interfaz");
		palabrasReservadas.add("actual");
		palabrasReservadas.add("des");
		palabrasReservadas.add("rea");
		palabrasReservadas.add("+p");
		palabrasReservadas.add("-p");	
	}

	/**
	 * Metodo para verificar si una palabra encontada es una palabra reservada
	 * 
	 * @param lexema
	 * @return
	 */
	public boolean esPalabraReservada(String lexema) {
		return palabrasReservadas.contains(lexema);
	}

	/**
	 * Extrae los tokens de un código fuente dado
	 * 
	 * @param cod - código al cual se le van a extraer los tokens - !=null
	 * @return vector con los tokens
	 */
	public ArrayList<Token> extraerTokens(String cod) {
		Token token;
		ArrayList<Token> vectorTokens = new ArrayList<Token>();

		// El primer token se extrae a partir de posición cero
		int i = 0;

		// Ciclo para extraer todos los tokens
		while (i < cod.length()) {
			// Extrae el token de la posición i
			token = extraerSiguienteToken(cod, i);
			vectorTokens.add(token);
			i = token.darIndiceSiguiente();
		}
		return vectorTokens;
	}

	/**
	 * Extrae el token de la cadena cod a partir de la posición i, basándose en el
	 * Autómata
	 * 
	 * @param cod - código al cual se le va a extraer un token - codigo!=null
	 * @param i   - posición a partir de la cual se va a extraer el token - i>=0
	 * @return token que se extrajo de la cadena
	 */
	public Token extraerSiguienteToken(String cod, int i) {
		Token token;

		/**
		 * Se hace los llamados a los metodos que extraen los tokens
		 */

		if (cod.charAt(i) == ' '&&i<cod.length()) {
			i++;
		}
		token = extraerCadena(cod, i);
		if (token != null)
			return token;

		token = extraerEntero(cod, i);
		if (token != null)
			return token;

		token = extraerDecimal(cod, i);
		if (token != null)
			return token;

		token = extraerCaracter(cod, i);
		if (token != null)
			return token;

		token = extraerBooleano(cod, i);
		if (token != null)
			return token;

		token = extraerIncremento(cod, i);
		if (token != null)
			return token;

		token = extraerDecremento(cod, i);
		if (token != null)
			return token;

		token = extraerMetodo(cod, i);
		if (token != null)
			return token;

		token = extraerIgualA(cod, i);
		if (token != null)
			return token;

		token = extraerClase(cod, i);
		if (token != null)
			return token;

		token = extraerSum(cod, i);
		if (token != null)
			return token;

		token = extraerRes(cod, i);
		if (token != null)
			return token;

		token = extraerMult(cod, i);
		if (token != null)
			return token;

		token = extraerDiv(cod, i);
		if (token != null)
			return token;

		token = extraerAsignacion(cod, i);
		if (token != null)
			return token;

		token = extraerMenorOIgual(cod, i);
		if (token != null)
			return token;

		token = extraerMayorOIgual(cod, i);
		if (token != null)
			return token;

		token = extraerMenor(cod, i);
		if (token != null)
			return token;

		token = extraerMayor(cod, i);
		if (token != null)
			return token;

		token = extraerDiferenteQue(cod, i);
		if (token != null)
			return token;

		token = extraerAnd(cod, i);
		if (token != null)
			return token;

		token = extraerOr(cod, i);
		if (token != null)
			return token;

		token = extraerSeparador(cod, i);
		if (token != null)
			return token;

		token = extraerPunto(cod, i);
		if (token != null)
			return token;
		token = extraerComentarioBloque(cod, i);
		if (token != null)
			return token;

		token = extraerComentarioLinea(cod, i);
		if (token != null)
			return token;

		token = extraerPuntoYComa(cod, i);
		if (token != null)
			return token;

		token = extraerLlaves(cod, i);
		if (token != null)
			return token;

		token = extraerCorchetes(cod, i);
		if (token != null)
			return token;

		token = extraerParentesis(cod, i);
		if (token != null)
			return token;

		token = extraerPalabraReservada(cod, i);
		if (token != null)
			return token;

		token = extraerNoReconocido(cod, i);
		return token;
	}

	/**
	 * Extraer un lexema no reconocido de la cadena cod a partir de la posición i.
	 * Antes de utilizar este método, debe haberse intentado todos los otros métodos
	 * para los otros tipos de token
	 * 
	 * @param cod - código al cual se le va a extraer el token no reconocido -
	 *            codigo!=null
	 * @param i   - posición a partir de la cual se va a extraer el token no
	 *            reconocido - 0<=indice<codigo.length()
	 * @return el token no reconocido. El Token se compone de lexema, el tipo y la
	 *         posición del siguiente lexema.
	 * 
	 */
	public Token extraerNoReconocido(String cod, int i) {
		String lexema = cod.substring(i, i + 1);
		int j = i + 1;
		Token token = new Token(lexema, Token.NORECONOCIDO, j);
		return token;
	}

	/**
	 * Determina si un carácter es un dígito
	 * 
	 * @param caracter - Carácter que se va a analizar - caracter!=null,
	 * @return true o false según el carácter sea un dígito o no
	 */
	public boolean esDigito(char caracter) {
		return caracter >= '0' && caracter <= '9';
	}

	/**
	 * Determina si un carácter es una letra
	 * 
	 * @param caracter - Carácter que se va a analizar - caracter!=null,
	 * @return true o false según el carácter sea una letra o no
	 */
	public boolean esLetra(char caracter) {
		return (caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z');
	}

	/**
	 * Determina si un caracter es una letra mayuscula
	 * 
	 * @param caracter caracter a analizar
	 * @return true o false
	 */
	public boolean esLetraMayuscula(char caracter) {
		return (caracter >= 'A' && caracter <= 'Z');
	}

	/**
	 * Determina si un caracter es una letra minuscula
	 * 
	 * @param caracter caracter a analizar
	 * @return true o false
	 */
	public boolean esLetraMinuscula(char caracter) {
		return (caracter >= 'a' && caracter <= 'z');
	}

	/**
	 * Determina si un caracter es aceptado en el lenguaje Mottan
	 * 
	 * @param caracter caracter a analizar
	 * @return true o false
	 */
	public boolean esCaracter(char caracter) {
		return (caracter >= '!' && caracter <= '}');
	}

	// -----------------Categoras Lexicas-----------------

	/**
	 * Metodo para extraer palabras reservadas
	 * 
	 * @param cod Codigo del programa
	 * @param i   contador donde se encuetra en cursor
	 * @return El token con la palabra o null
	 */
	public Token extraerPalabraReservada(String cod, int i) {

		int j;
		String lex;
		String subL = "";
		j = i;
		cod += " ";

		while (j < cod.length()) {
			subL += cod.charAt(j);
			j++;
			if (esPalabraReservada(subL) && j < cod.length()) {

				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.PALABRARESERVADA, j);
				return token;
			}

		}
		return null;

	}

	/**
	 * Metodo para extraer un numero entero
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token entero o null
	 */
	public Token extraerEntero(String cod, int i) {
		int j = i;
		String lex;

		if (j < cod.length() && esDigito(cod.charAt(j))) {
			do
				j++;
			while (j < cod.length() && esDigito(cod.charAt(j)));
			if (j < cod.length() && cod.charAt(j) == 'z') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.ENTEROI, j);
				return token;
			}
		}

		return null;
	}

	/**
	 * Metodo para extraer un numero decimal
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token decimal o null
	 */
	public Token extraerDecimal(String cod, int i) {
		int j = i;
		String lex;
		if (j < cod.length() && esDigito(cod.charAt(j))) {
			do
				j++;
			while (j < cod.length() && esDigito(cod.charAt(j))  );
			if (j < cod.length() && cod.charAt(j) == '.') {
				do
					j++;
				while (j < cod.length() && esDigito(cod.charAt(j)));
				if (j < cod.length() && cod.charAt(j) == 'q') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.DECIMALI, j);
					return token;
				}
			}
		}
		if (j < cod.length() && cod.charAt(j) == '.') {
			do
				j++;
			while (j < cod.length() && esDigito(cod.charAt(j)));
			if (j < cod.length() && cod.charAt(j) == 'z') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.DECIMALI, j);
				return token;
			}

		}

		return null;
	}

	/**
	 * Metodo para extraer un caracter
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token caracter o null
	 */
	public Token extraerCaracter(String cod, int i) {
		int j = i;
		String lex;
		if (esCaracter(cod.charAt(i))) {
			j++;
			if (j < cod.length() && cod.charAt(j) == '#') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.CARACTERI, j);
				return token;
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer un Booelano
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token Boleano o null
	 */
	public Token extraerBooleano(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '|') {
			j++;
			if (cod.charAt(j) == '1' || cod.charAt(j) == '0') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.BOOLEANOI, j);
				return token;
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer una cadena
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token cadena o null
	 */
	public Token extraerCadena(String cod, int i) {

		int j = i;
		String lex;
		if (j < cod.length() && cod.charAt(i) == '$') {
			do
				j++;
			while (j < cod.length() && ((esLetra(cod.charAt(j))) || esDigito(cod.charAt(j))));

			if (j < cod.length() && cod.charAt(j) == '$') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.CADENA, j);
				return token;
			}
		}

		return null;
	}

	/**
	 * Metodo para extraer una metodo
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token metodo o null
	 */
	public Token extraerMetodo(String cod, int i) {
		int j = i;
		String lex;
		if (esLetraMayuscula(cod.charAt(i))) {
			j++;
			if (j < cod.length() && cod.charAt(j) == '_') {
				j++;
				while (j < cod.length() && esLetraMinuscula(cod.charAt(j))) {
					j++;
					if (j < cod.length() && cod.charAt(j) == ' ') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.METODO, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer una metodo
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token metodo o null
	 */
	public Token extraerClase(String cod, int i) {
		int j = i;
		String lex;
		if (esCaracter((cod.charAt(i)))) {
			j++;
			if (j < cod.length() && cod.charAt(j) == '_') {
				j++;
				while (j < cod.length() && esLetraMayuscula(cod.charAt(j))) { // ARREGLAR
					j++;
					if (j < cod.length() && cod.charAt(j) == ' ') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.CLASE, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	// Operadores Aditivos

	/**
	 * Metodo para extraer el operador SUM
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token SUM o null
	 */
	public Token extraerSum(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'S') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'U') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'M') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.SUM, j);
					return token;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador RES
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token RES o null
	 */
	public Token extraerRes(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'R') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'E') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'S') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.RES, j);
					return token;
				}
			}
		}
		return null;
	}

	// Operadores Multiplicativos

	/**
	 * Metodo para extraer el operador MULT
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token MULT o null
	 */
	public Token extraerMult(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'M') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'U') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'L') {
					j++;
					if (j < cod.length() && cod.charAt(j) == 'T') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.MULT, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador DIV
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token DIV o null
	 */
	public Token extraerDiv(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'D') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'I') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'V') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.DIV, j);
					return token;
				}
			}
		}
		return null;
	}

	// Operadores de asignacion

	/**
	 * Metodo para extraer el operador de asignacion
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token del operador de asignacion o null
	 */
	public Token extraerAsignacion(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '=') {
			j++;
			if (j < cod.length() && cod.charAt(j) == '=') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.ASIGNACION, j);
				return token;
			}

		}
		return null;
	}

	// Operadores de incremento y decremento
	/**
	 * Metodo para extraer el operador de incremento
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token del operador de incremento o null
	 */
	public Token extraerIncremento(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'I') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'N') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'C') {
					j++;
					if (j < cod.length() && cod.charAt(j) == 'R') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.INCREMENTO, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador de decremento
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token del operador de decremento o null
	 */
	public Token extraerDecremento(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'D') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'E') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'C') {
					j++;
					if (j < cod.length() && cod.charAt(j) == 'R') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.DECREMENTO, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	// Operadores Relacionales
	/**
	 * Metodo para extraer el operador de relacion <
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token < o null
	 */
	public Token extraerMenor(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'm') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'i') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'n') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.MIN, j);
					return token;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador relacional >
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token > o null
	 */
	public Token extraerMayor(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'm') {
			j++;
			if (cod.charAt(j) == 'a') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'x') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.MAX, j);
					return token;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador <=
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token <= o null
	 */
	public Token extraerMenorOIgual(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'm') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'i') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'n') {
					j++;
					if (j < cod.length() && cod.charAt(j) == '_') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.MIN_, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador >=
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token >= o null
	 */
	public Token extraerMayorOIgual(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'm') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'a') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'x') {
					j++;
					if (j < cod.length() && cod.charAt(j) == '_') {
						j++;
						lex = cod.substring(i, j);
						Token token = new Token(lex, Token.MAX_, j);
						return token;
					}
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador relacional ===
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token === o null
	 */
	public Token extraerIgualA(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '=') {
			j++;
			if (j < cod.length() && cod.charAt(j) == '=') {
				j++;
				if (j < cod.length() && cod.charAt(j) == '=') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.IGUALA, j);
					return token;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador relacional dif==
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token dif== o null
	 */
	public Token extraerDiferenteQue(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'd') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'i') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'f') {
					j++;
					if (j < cod.length() && cod.charAt(j) == '=') {
						j++;
						if (j < cod.length() && cod.charAt(j) == '=') {
							j++;
							lex = cod.substring(i, j);
							Token token = new Token(lex, Token.DIFERENTEQUE, j);
							return token;
						}
					}
				}
			}
		}
		return null;
	}

	// Operadores Logicos

	/**
	 * Metodo para extraer el operador relacional AND
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token AND o null
	 */
	public Token extraerAnd(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'A') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'N') {
				j++;
				if (j < cod.length() && cod.charAt(j) == 'D') {
					j++;
					lex = cod.substring(i, j);
					Token token = new Token(lex, Token.AND, j);
					return token;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el operador relacional OR
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token OR o null
	 */
	public Token extraerOr(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == 'O') {
			j++;
			if (j < cod.length() && cod.charAt(j) == 'R') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.OR, j);
				return token;
			}
		}
		return null;
	}

	// Tokens
	/**
	 * Metodo para extraer el separador - (,)
	 * 
	 * @param cod       cadena que contiene el codigo del programa
	 * @param iposicion de donde se va a extraer el token
	 * @return el token - o null
	 */
	public Token extraerSeparador(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '-') {
			j++;
			lex = cod.substring(i, j);
			Token token = new Token(lex, Token.SEPARADOR, j);
			return token;

		}
		return null;
	}

	/**
	 * Metodo para extraer el punto > (.) invocacion a...
	 * 
	 * @param cod       cadena que contiene el codigo del programa
	 * @param iposicion de donde se va a extraer el token
	 * @return el token > o null
	 */
	public Token extraerPunto(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '>') {
			j++;
			lex = cod.substring(i, j);
			Token token = new Token(lex, Token.PUNTO, j);
			return token;

		}
		return null;
	}

	/**
	 * Metodo para extraer el comentario de linea.
	 * 
	 * @param cod       cadena que contiene el codigo del programa
	 *                  Arrrelakdlaskldjadjalksjdklasjdka
	 * @param iposicion de donde se va a extraer el token
	 * @return el comentario de linea o null
	 */
	public Token extraerComentarioLinea(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '>') {
			j++;
			lex = cod.substring(i, j);
			Token token = new Token(lex, Token.COMENTARIO_LINEA, j);
			return token;

		}
		return null;
	}

	/**
	 * Metodo para extraer el comentario de bloque.
	 * 
	 * @param cod       cadena que contiene el codigo del programa
	 * 
	 * @param iposicion de donde se va a extraer el token
	 * @return el comentario de bloque o null
	 */
	public Token extraerComentarioBloque(String cod, int i) {
		int j = i;
		String lex;// *-** *
		if (cod.charAt(i) == '*') {
			j++;
			if (cod.charAt(i) == '-') {
				j++;
				if (cod.charAt(i) == '*') {
					j++;
					if (cod.charAt(i) == '*') {
						j++;
						while (j < cod.length()) {
							j++;
							if (cod.charAt(j) == '*') {

							}

						}

					}

				}
			}
			lex = cod.substring(i, j);
			Token token = new Token(lex, Token.COMENTARIO_BLOQUE, j); // Arrrelakdlaskldjadjalksjdklasjdka
			return token;

		}
		return null;
	}

	// Terminales

	/**
	 * Metodo para extraer el terminal ..
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token .. o null
	 */
	public Token extraerPuntoYComa(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '.') {
			j++;
			if (j < cod.length() && cod.charAt(j) == '.') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.PUNTOYCOMA, j);
				return token;
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el terminal ¡!
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token ¡! o null
	 */
	public Token extraerLlaves(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '¡') {
			j++;
			if (j < cod.length() && cod.charAt(j) == '!') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.LLAVES, j);
				return token;
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el terminal ¿?
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token ¿? o null
	 */
	public Token extraerCorchetes(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '¿') {
			j++;
			if (j < cod.length() && cod.charAt(j) == '?') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.CORCHETES, j);
				return token;
			}
		}
		return null;
	}

	/**
	 * Metodo para extraer el terminal []
	 * 
	 * @param cod cadena que contiene el codigo del programa
	 * @param i   posicion de donde se va a extraer el token
	 * @return el token [] o null
	 */
	public Token extraerParentesis(String cod, int i) {
		int j = i;
		String lex;
		if (cod.charAt(i) == '[') {
			j++;
			if (j < cod.length() && cod.charAt(j) == ']') {
				j++;
				lex = cod.substring(i, j);
				Token token = new Token(lex, Token.PARENTESIS, j);
				return token;
			}
		}
		return null;
	}
}
