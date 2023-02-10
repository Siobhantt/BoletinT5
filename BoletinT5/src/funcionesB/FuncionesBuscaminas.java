package funcionesB;


public class FuncionesBuscaminas {	
	 static  int MINAS =6;
	 static int TAMANIO = 20;
	
	
	public static char[] tablaLlena (char t[]) {
		int posicion = 0;
		while (MINAS !=0) {
			posicion = (int) (Math.random()*20);

			MINAS--;
			System.out.print(t[posicion]);
		}
		return t;
	}

	
}//fin de la clase

