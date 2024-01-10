package hallo_za_warudo;

import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

public class Aula2TPC {

	public static void main(String[] args) {
		//notas();
		Scanner palavra = new Scanner (System.in);
		System.out.println("\n" + "A palavra inserida tinha " + nletra(palavra) + " vezes");

	}
	//função do exercicio 3b)
	public static void notas() {
		System.out.println("Insira de maneira seguida(por um enter) , as suas notas de Matematica , Inglês e Programação");
		Scanner var1 = new Scanner(System.in);
		double nota1 = var1.nextInt();
		double nota2 = var1.nextInt();
		double nota3 = var1.nextInt();
		
		double tota = nota1+nota2+nota3;
		double total = tota / 3;
		if(Math.round(total) > 9) {
			System.out.print("Passas-te a tua media é " + Math.round(total));
		}
		else {
			System.out.print("Chumbaste");
		}
		
	}
	//função do exercio 4 a)
	public static int nletra(Scanner palavra) {
		int i;
		int p;
		int quan=0 ;
		System.out.print("\n" + "Insira uma letra :");
		String let = palavra.next();
		let = let.toLowerCase();
		
		System.out.print("\n" + "Insira uma palavra :");
		String pal = palavra.next();
		pal = pal.toLowerCase();
		char[] pala = pal.toCharArray();
		char[] lete = let.toCharArray();
		for (i = 0; i < pal.length(); i++) {
			if ( pala[i] == lete[0]) {
				quan++;
			}
			else {
				p = 1;
			}
		}
		return quan;
	}
	
}
