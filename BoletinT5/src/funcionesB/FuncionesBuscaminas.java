package funcionesB;

import java.util.Arrays;

public class FuncionesBuscaminas {
	static int MINAS = 6;
	static int TAMANIO = 20;

	public static char[] tablaLlena(char t[]) {
		int posicionAleatoria;// aqui se guarda la posicion de las minas
		// recorro la cantidad de minas
		Arrays.fill(t, '0');
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
			// si es amyor a 0 o menor que que el final de la tabla entonces
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
	
	public static char[] muestraT(char tCosas[], char tUser[], int posUser) {
		if(tCosas[posUser]=='*') {
			System.out.println(Arrays.toString(tCosas));
			System.out.println("Has perdido");
		}
		else {
			tUser[posUser] = tCosas[posUser];
			System.out.println(Arrays.toString(tUser));
		}
		return tUser;
	}//fin del metodo
	
	public static boolean ganaste (char tUser[]) {
		int contadorMinas=0;
		boolean ganaste=false;
		for(int i=0;i<tUser.length;i++) {
			if (tUser[i]=='ª') {
				contadorMinas++;
			}
		}
		if(contadorMinas ==6) {
			ganaste =true; 
		}
		return ganaste;
		
	}//fin del metodo
}// fin de la clase
