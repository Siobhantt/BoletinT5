package sieteMedia;

import java.util.Arrays;
import java.util.Scanner;

public class FuncionesSieteMedia {
	static Scanner lee = new Scanner(System.in);


	//creo una funcion que sea la nueva partida y esta va a inicializar el array a 0
	//recibe una tabla
	public static void nuevaPartida(double [] jugadores) {
		Arrays.fill(jugadores, 0);
	}
	//funcion que devuelve el resultado almacenadoç
	//recibe el jugador

	//creo una funcion que sea la ronda y esta recibirá el jugador correspondiente y la tabla
	//dentro haré un bucle que se mantendra activo hasta que 
	//quiero que esta funcion mientras el user me de la oopcion si siga dando cartas, hasta que diga que no o la puntuacion
	//sea mayor de 7.5
	public static void tirada(double [] t, int jugador) {
		int carta;
		String respuesta;
		respuesta=pregunta();
		while((respuesta.equals("s")||respuesta.equals("S")) && t[jugador]<= 7.5) {
			carta = cartAleatoria();
			if(carta == 8) {
				System.out.println("Usted ha sacado la carta Sota de " + palo());
			}
			else if(carta == 9) {
				System.out.println("Usted ha sacado la carta Caballo de " + palo());
			}
			else if(carta == 10) {
				System.out.println("Usted ha sacado la carta Rey de " + palo());
			}
			else {
				System.out.println("Usted ha sacado la carta "+carta + " de " + palo());

			}
			t[jugador]=sumaPuntuacion(t, carta, jugador);
			System.out.println("Actualmente tiene "+t[jugador]+" puntos");
			System.out.println();
			if(t[jugador]<= 7.5) {
			respuesta=pregunta();
			}
		}
	}
	//funcion de pregunta
	
	public static String pregunta() {
		String opcionUser;
		System.out.println("Quiere sacar una carta? (s/n)");
		opcionUser = lee.next();
	/*	if (opcionUser != "s"  && opcionUser!="n") {
			opcionUser = lee.next();
		}*/
		return opcionUser;
	}
//Lo primero que necesito es mostrar un mensaje de bienvenida al juego
	public static void bienvenida() {
		System.out.println("Bienvenido al Siete y medio!");
	}
	
 // luego muestro que es el turno del jugador 1 y
	public static String turno(int jugador) {
		return "Es el turno del jugador "+ (jugador+1);
	} 
	
 // devuelve una carta al azar
	public static int cartAleatoria() {
		return (int) ((Math.random()*10)+1);
	}
	
	public static String palo() {
	String palo[] = {"basto" , "oro" , "copas", "espadas"};
	int azar = (int)(Math.random()*4);
	return palo[azar];
	}
	
// tengo que definir la puntuacion que será la suma de las cartas que se iran sacando
	public static double sumaPuntuacion(double []t, int carta, int jugador) {
		if(carta>=1&&carta<=7) {
			t[jugador] += carta;
		}else {
			t[jugador]+=0.5;
		}
		return t[jugador];
	}
// genero una carta aleatoria, y mantengo generando una carta aleatoria hasta que me diga que no o la puntuacion pase de 7.5
// en caso que me diga que no termina el turno del  jugador 1 y paso al jugador 2,
 
	public static String ganador(double[] t, int jugador1, int jugador2) {
		String ganador=null;
		if(t[jugador1]>7.5&&t[jugador2]>7.5) {
			ganador="Ambos jugadores han perdido.";
		}else if(t[jugador1]>7.5) {
			ganador="Gana jugador 2";
		}else if(t[jugador2]>7.5) {
			ganador="Gana jugador 1";
		}else {
			if(t[jugador1]==t[jugador2]) {
				ganador="Empate";
			}else if(t[jugador1]>t[jugador2]) {
				ganador="Gana el jugador 1";
			}else if(t[jugador1]<t[jugador2]) {
				ganador="Gana el jugador 2";
			}
		}

		return ganador;
	}
 
 
}
