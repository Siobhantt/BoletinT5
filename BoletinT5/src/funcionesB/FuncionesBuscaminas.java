package funcionesB;

public class FuncionesBuscaminas {
	static int MINAS = 6;
	static int TAMANIO = 20;

	public static char[] tablaLlena(char t[]) {
		int posicionAleatoria;// aqui se guarda la posicion de las minas
		// recorro la cantidad de minas
		for (int i = 0; i < MINAS; i++) {
			// es un do, porque necesito que siga generando una posicion en caso de que ya
			// alla una mina en la posicion generada
			do {
				posicionAleatoria = (int) (Math.random() * 20); // genero una posicion para guardar una mina
			} while (t[posicionAleatoria] == '*'); // mientras en la posicion haya una mina
			//arriba es el fin del do while
			
			t[posicionAleatoria] = '*'; // en t[de posicion Aleatoria] pongo una mina
		}//fin del for
		return t;
	}//fin del metodo
	
	
}// fin de la clase
