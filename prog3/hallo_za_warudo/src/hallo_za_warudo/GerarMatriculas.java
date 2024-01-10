package hallo_za_warudo;

import java.util.Random;
import java.lang.String;
	
public class GerarMatriculas {

	public static void main(String[] args) {
		Random rand = new Random();
		String letras = "ABCDEFGHIJLMNOPQRSTUVXZ";
		int i;
		int r = letras.length();
		for(i=1 ; i<4 ; i++ ) {
			int random = rand.nextInt(99);
			int rndom = rand.nextInt(r);
			int rdom = rand.nextInt(r);
			if (random < 10 && i%2!=0) {
				System.out.print("0"+random);
			}
			if (9 < random && random < 100 && i%2!=0) {
				System.out.print(random);
			}
			if (i%2==0) {
				System.out.print("-"+letras.charAt(rndom)+letras.charAt(rdom)+"-");
			}
		}
		
		
	}

}
