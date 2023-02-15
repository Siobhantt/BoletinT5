package sieteMedia;

public class MainSieteMedia {
	// declaro que el jugador 1 es la posicion 0 del array
	final static int JUGADOR1 = 0;
	// y que el jugador 2 es la posicion 1 del array
	final static int JUGADOR2 = 1;

	public static void main(String[] args) {

		double jugadores[] = new double[2];

		FuncionesSieteMedia.nuevaPartida(jugadores);
		FuncionesSieteMedia.bienvenida();
		System.out.println();
		System.out.println(FuncionesSieteMedia.turno(JUGADOR1));
		FuncionesSieteMedia.tirada(jugadores, JUGADOR1);
		System.out.println();
		System.out.println(FuncionesSieteMedia.turno(JUGADOR2));
		FuncionesSieteMedia.tirada(jugadores, JUGADOR2);
		System.out.println();
		System.out.println(FuncionesSieteMedia.ganador(jugadores, JUGADOR1, JUGADOR2));
	}
}
