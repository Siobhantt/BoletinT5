package sieteMedia;

import java.util.Scanner;

public class MainSieteMedia {
	//declaro que el jugador 1 es la posicion 0 del array
		final static int JUGADOR1 =0;
		//y que el jugador 2 es la posicion 1 del array
		final static int JUGADOR2 =1;
		
	public static void main(String[] args) {
		int jugadores[] = new int[2];
		
		
		FuncionesSieteMedia.nuevaPartida(jugadores);
		FuncionesSieteMedia.tirada(jugadores, JUGADOR1);
		
	}
}
