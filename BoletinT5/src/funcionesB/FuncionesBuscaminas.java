package funcionesB;


public class FuncionesBuscaminas {
	public static void tabla() {
			char pista[] = new char[20];
		
		for (int i=0;i<pista.length;i++) {
			System.out.print("_ , ");
		}//fin del for
	}//fin del metodo
	
public int[] tablaLlena(int t[]) {
char mina= '*';
int contadorMinas=0;

mina =(char) (Math.random()*20);
	while (contadorMinas<=6) {
		t[contadorMinas] = mina;
		contadorMinas++;
	}
return t;

}//fin del metodo
}//fin de la clase

