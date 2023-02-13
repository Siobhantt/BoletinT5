package funcionesB;

import java.util.Scanner;

public class MainBuscaminas {

	public static void main(String[] args) {
	int posUser;	
	boolean ganar;
	char t[]= new char[20];
	char tablota[]=new char[20];
	Scanner lee = new Scanner(System.in);

	for(int i=0;i<tablota.length;i++) {
		tablota[i]='ª';
	}
	
	t = FuncionesBuscaminas.tablaLlena(t);
	t = FuncionesBuscaminas.pistas(t);			

	do {
	System.out.println("Por favor introduzca la posicion que quiere destapar: ");
	posUser = lee.nextInt();
	tablota = FuncionesBuscaminas.muestraT(t, tablota, posUser);
	ganar = FuncionesBuscaminas.ganaste(t);
	} while(t[posUser]!='*' && ganar==false);
	if (ganar ==true) {
		System.out.println("Ganaste");
	}
	
	}//fin del main
}