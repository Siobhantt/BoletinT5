package sieteMedia;

import java.util.Arrays;
import java.util.Scanner;

public class FuncionesSieteMedia {

	static Scanner lee = new Scanner(System.in);

	// Lo primero que necesito es mostrar un mensaje de bienvenida al juego
	public static void bienvenida() {
		System.out.println("Bienvenido al Siete y medio!");
	}

	// creo una funcion que sea la nueva partida y esta va a inicializar el array a
	// 0
	// recibe una tabla
	public static void nuevaPartida(double[] jugadores) {
		Arrays.fill(jugadores, 0);
	}

	/*
	 * La funcion tirada recibe la tabla donde estan las puntuaciones y un entero
	 * que representa al jugador
	 */
	public static void tirada(double[] t, int jugador) {
		int carta;
		String respuesta;
		// uso la funcion pregunta para obtenerla del jugador
		respuesta = pregunta();
		/*
		 * Inicia un bucle while donde si la respuesta es igual a s,S Y la puntuacion es
		 * menor que 7,5 se mantenga activo
		 */
		while ((respuesta.equals("s") || respuesta.equals("S")) && t[jugador] <= 7.5) {
			// dentro del bucle llamo a la funcion que me da la carta aleatoria
			carta = cartAleatoria();
			// este bloque es para el caso de que sea 7, 8 o 9, en esos cassos a cada uno le
			// asigné sota caballo y rey.
			if (carta == 8) {
				System.out.println("Usted ha sacado la carta Sota de " + palo());
			} else if (carta == 9) {
				System.out.println("Usted ha sacado la carta Caballo de " + palo());
			} else if (carta == 10) {
				System.out.println("Usted ha sacado la carta Rey de " + palo());
			} // a todo lo deas se asigné un palo con una funcion
			else {
				System.out.println("Usted ha sacado la carta " + carta + " de " + palo());
			}
			// una vez generado la carta con su palo correspondiente guardo en la tabla la
			// suma de la puntuacion con la funcion correspondiente
			t[jugador] = sumaPuntuacion(t, carta, jugador);
			// informacion sobre la puntuacion que tiene el jugador
			System.out.println("Actualmente tiene " + t[jugador] + " puntos");
			System.out.println(); //
			// si el jugador sigue teniendo menos de 7.5 sigo preguntando
			if (t[jugador] <= 7.5) {
				respuesta = pregunta();
			}
		} // finn del while
	}

	// funcion de pregunta que recibe la opcion del user
	public static String pregunta() {
		String opcionUser;
		System.out.println("Quiere sacar una carta? (s/n)");
		opcionUser = lee.next();
		return opcionUser;
	}
/*Como la puntuacion de cada jugador esta guardado en una tabla con las posiciones 0 y 1, le sumo 1 al jugador para que se califique como 1 y 2*/
	public static String turno(int jugador) {
		return "Es el turno del jugador " + (jugador + 1);
	}

	// devuelve una carta al azar entre 1 y 10 
	public static int cartAleatoria() {
		return (int) ((Math.random() * 10) + 1);
	}
//esta funcion me ofrece un palo al azar
	//guardo un numero random en la variable azar entre 1 y 4 entonces tomará uno de el array que contiene los palos y lo devolverá
	public static String palo() {
		String palo[] = { "basto", "oro", "copas", "espadas" };
		int azar = (int) (Math.random() * 4);
		return palo[azar];
	}

//la suma de las cartas que se iran sacando, mientras esten entro 1 y 7 se sumaran a la puntuacion, todo lo demas valdrá 0.5 y eso(0,5) será lo que se sume a la puntuacion
	public static double sumaPuntuacion(double[] t, int carta, int jugador) {
		if (carta >= 1 && carta <= 7) {
			t[jugador] += carta;
		} else {
			t[jugador] += 0.5;
		}
		return t[jugador];
	}
	/*Funcion que guarda los casos de cuando se gana
	 * en ella esta el caso de si ambos jugadores se pasan, 
	 * si solo se pasa el primer jugador
	 * si solo se pasa el segundo jugador
	 * y si ambos jugadores terminan con la misma puntuacion
	 * devuelve el jugador.*/
	public static String ganador(double[] t, int jugador1, int jugador2) {
		String ganador = null;
		if (t[jugador1] > 7.5 && t[jugador2] > 7.5) {
			ganador = "Ambos jugadores han perdido.";
		} else if (t[jugador1] > 7.5) {
			ganador = "Gana jugador 2";
		} else if (t[jugador2] > 7.5) {
			ganador = "Gana jugador 1";
		} else {
			if (t[jugador1] == t[jugador2]) {
				ganador = "Empate";
			} else if (t[jugador1] > t[jugador2]) {
				ganador = "Gana el jugador 1";
			} else if (t[jugador1] < t[jugador2]) {
				ganador = "Gana el jugador 2";
			}
		}
		return ganador;
	}

}
