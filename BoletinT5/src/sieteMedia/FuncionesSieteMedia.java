package sieteMedia;

import java.util.Arrays;
import java.util.Scanner;

public class FuncionesSieteMedia {

	//creo una funcion que sea la nueva partida y esta va a inicializar el array a 0
	//recibe una tabla
	public static void nuevaPartida(int [] jugadores) {
		Arrays.fill(jugadores, 0);
	}
	//funcion que devuelve el resultado almacenadoç
	//recibe el jugador
	
	public static int devuelveResultado(int[] t, int jugador) {
		return t[jugador];
	}
	
	//creo una funcion que sea la ronda y esta recibirá el jugador correspondiente y la tabla
	//dentro haré un bucle que se mantendra activo hasta que 
	//quiero que esta funcion mientras el user me de la oopcion si siga dando cartas, hasta que diga que no o la puntuacion
	//sea mayor de 7.5
	public static void tirada(int [] t, int jugador) {
		int carta;
		while(pregunta().equals("s") && devuelveResultado(t, jugador)< 7.5) {
			carta = cartAleatoria();
			sumaPuntuacion(t, carta, jugador);
			}
	}
	//funcion de pregunta
	
	public static String pregunta() {
		String opcionUser;
		Scanner lee = new Scanner(System.in);
		System.out.println("Quiere sacar una carta? (s/n)");
		opcionUser = lee.nextLine();
	/*	if (opcionUser != "s"  && opcionUser!="n") {
			opcionUser = lee.next();
		}*/
		lee.close();
		return opcionUser;
	}
//Lo primero que necesito es mostrar un mensaje de bienvenida al juego
	public static void bienvenida() {
		System.out.println("Bienvenido al Siete y medio!");
	}
	
 // luego muestro que es el turno del jugador 1 y
	public static String turno(String jugador) {
		return "Es el turno del "+ jugador;
	}
	
 // devuelve una carta al azar
	public static int cartAleatoria() {
		return (int) (Math.random()*10);
	}
	
// tengo que definir la puntuacion que será la suma de las cartas que se iran sacando
	public static int sumaPuntuacion(int []t, int carta, int jugador) {
		t[jugador] += carta;
		return devuelveResultado(t,  jugador);
	}
// genero una carta aleatoria, y mantengo generando una carta aleatoria hasta que me diga que no o la puntuacion pase de 7.5
// en caso que me diga que no termina el turno del  jugador 1 y paso al jugador 2,
 
 
 
 
	
	/*Funcion sacar una carta al azar
 * public static int cartaAleatoria() {
	int carta;
	 carta =(int) (Math.random()*10);
return carta;
}

public static int sumaCartas(int carta) {
	int suma;
	
}
 * */

}
