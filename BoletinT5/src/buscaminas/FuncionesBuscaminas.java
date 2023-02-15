package buscaminas;

import java.util.Arrays;

public class FuncionesBuscaminas {
	static int MINAS = 6;
	static int TAMANIO = 20;

	public static char[] tablaLlena(char t[]) {
		int posicionAleatoria;// aqui se guarda la posicion de las minas

		// lleno la tabla de 0s
		Arrays.fill(t, '0');

		// recorro la cantidad de minas
		for (int i = 0; i < MINAS; i++) {
			// es un do, porque necesito que siga generando una posicion en caso de que ya
			// alla una mina en la posicion generada
			do {
				posicionAleatoria = (int) (Math.random() * 20); // genero una posicion para guardar una mina
			} while (t[posicionAleatoria] == '*'); // mientras en la posicion haya una mina
			// arriba es el fin del do while

			t[posicionAleatoria] = '*'; // en t[de posicion Aleatoria] pongo una mina
		} // fin del for
		return t;
	}// fin del metodo

	public static char[] pistas(char t[]) {
		// Con este for estoy recorriendo la tabla
		for (int i = 0; i < t.length; i++) {
//aqui abajo hago las comprobaciones de 
			// si es mayor a 0 o menor que que el final de la tabla entonces
			if (i > 0 && i < t.length - 1 && t[i] == '0') {
				// si en la posicion anterior y en la posicion siguiente a la que me encuentro
				// hay un asterisco entonces igualo la posicion en la que estoy a 2
				if (t[i - 1] == '*' && t[i + 1] == '*') {
					t[i] = '2';
				} else if (t[i - 1] == '*' && t[i + 1] != '*') { // si en la posicion de antes hay un asterisco y en la
																	// posicion siguiente hay algo qe no sea un
																	// asterisco
					// igualo la posicion en la que estoy a 1
					t[i] = '1';

				} else if (t[i + 1] == '*' && t[i - 1] != '*') { // lo mismo pero al contrario
					t[i] = '1';
				}
			} // if grande

			// este else if comprueba el principio de la tabla (el indice 0)
			else if (t[i] == '0' && i == 0) {
				// si en el siguiente al primero hay un asterisco entonces el primer elemento
				// del array lo igualo a uno
				if (t[i + 1] == '*') {
					t[i] = '1';
				}
			}

			else if (t[i] == '0' && i == t.length - 1) { // este comprueba el fnal de la tabla que es t.length-1
				// si en el elemento anterior al ultimo hay una mina entonces el ultimo elemento
				// es un 1
				if (t[i - 1] == '*') {
					t[i] = '1';
				}
			}
		} // fin del for
		return t;
	}// fin del metodo

	/*Esta funcion recibe las tablas y la posicion que escoja el user
	 *  en caso de encontrar una mina, nos informa que ha perdido y nos muestra la tabla
	 *  en caso contrario "destapa esa casilla" */
	public static char[] muestraT(char tCosas[], char tUser[], int posUser) {
		if (tCosas[posUser] == '*') {
			System.out.println(Arrays.toString(tCosas));
			System.out.println("Has perdido! :((");
		} else {
			tUser[posUser] = tCosas[posUser];
			System.out.println(Arrays.toString(tUser));
		}
		return tUser;
	}// fin del metodo

	/*Funcion que nos devuelve true en caso de que se recorra la tabla y solo queden 6 casillas sin destapar*/
	public static boolean ganaste(char tUser[]) {
		int contadorAgujeros = 14;
		boolean ganaste = false;
//en caso de que encuentre en la tabla oculta una pista le resta al contador y cuando este llegue a 0 significa que el jugador ha ganado
		for (int i = 0; i < tUser.length; i++) {
			if (tUser[i] == '0' || tUser[i] == '1' || tUser[i] == '2') {
				contadorAgujeros--;
			}
		}
		if (contadorAgujeros == 0) {
			ganaste = true;
		}
		return ganaste;

	}// fin del metodo
}// fin de la clase
