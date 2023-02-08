package funcionesB;

import java.util.Arrays;

public class FuncionesBuscaminas {

	public static void tablaMinas() {
		char pista[] = new char[20];
		
		for (int i=0;i<pista.length;i++) {
			pista[i]=(char) (Math.random()*10);
		if(pista[i]==4) {
			pista[i]='*';
		}
		}
			System.out.println(Arrays.toString(pista));
	}
	
	
}
