package hallo_za_warudo;

import java.util.Scanner;
import java.lang.String;


public class exercicio4B {

	public static void main(String[] args) {
		Scanner palavra = new Scanner(System.in);
		System.out.println("Porfavor escreva o quanto quiser ");
		String pal = palavra.nextLine();
		System.out.println("\n"+"O seu texto/Frase contem a letra 'A' " + nletra(pal) + " vezes");
	}
	//função do exercio 4 a) alterada para este programa
		public static int nletra(String pal) {
			int i;
			int p;
			int quan=0 ;
			pal = pal.toLowerCase();
			char[] pala = pal.toCharArray();
			char lete = 'a';
			for (i = 0; i < pal.length(); i++) {
				if ( pala[i] == lete) {
					quan++;
				}
				else {
					p = 1;
				}
			}
			return quan;
		}
}


