package hallo_za_warudo;

import java.lang.String; 
import java.lang.StringBuilder;
import java.util.Scanner;

public class ObfuscarTextos {

	public static void main(String[] args) {
		fusca();
	}
	
	public static void fusca() {
		int i;
		int num=0;
		Scanner frase = new Scanner(System.in);
		System.out.println("Escreva a frase que quer que seja ofuscada");
		String fra = frase.nextLine();
		fra = fra.replaceAll(" " , "");
		char [] fras = fra.toCharArray();
		
		for(i = 0; i < fra.length() ; i++) {
			if (num < 5) {
				fras[i] = Character.toUpperCase(fras[i]);
				System.out.print(fras[i]);
				num++;
			}
			if (num > 4) {
				fras[i] = Character.toLowerCase(fras[i]);
				System.out.print(fras[i]);
				num++;
			}
			if (num == 10) {
				num = 0;
			}
		}
	}

}
