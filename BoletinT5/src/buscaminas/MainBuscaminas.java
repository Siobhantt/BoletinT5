package buscaminas;

import java.util.Arrays;
import java.util.Scanner;

public class MainBuscaminas {

	public static void main(String[] args) {
		int posUser;
		boolean ganar = false;
		char t[] = new char[20];
		char tablota[] = new char[20];
		Scanner lee = new Scanner(System.in);
		//Inicio la tabla a guiones bajos
		for (int i = 0; i < tablota.length; i++) {
			tablota[i] = '_';
		}
		//a la tabla le doy los valores de ambas funciones, de las minas y pistas
		t = FuncionesBuscaminas.tablaLlena(t);
		t = FuncionesBuscaminas.pistas(t);
		System.out.println("Bienvenido al buscaminas (;");
		//en este bucle solicitamos la posicion que quiera el usuario
		do {
			System.out.println("Por favor introduzca la posicion que quiere destapar: ");
			posUser = lee.nextInt();
			tablota = FuncionesBuscaminas.muestraT(t, tablota, posUser); //y muestramos lo que esté en esa posicion
			ganar = FuncionesBuscaminas.ganaste(tablota); //llamamos a la funcion de ganar y mientras esta sea false o distinta a una mina continuamos
		} while (t[posUser] != '*' && ganar == false);
		if (ganar == true) { //en caso de ganar mostramos un mensaje
			System.out.println("Ganaste! (:");
		}

	}// fin del main
}