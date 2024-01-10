package hallo_za_warudo;

import java.util.Scanner;
import java.lang.Math;

public class Aula2u02l05l2023 {
	public static void main (String[] args) {
		Leituras();
		int n = 3;
		int m = 10;
		Scanner canal = new Scanner(System.in);
		System.out.print("\n" + "Insira um valor entre [" + n + "," + m +"] :");
		System.out.print("\n" + "O numero " + lerValorNoIntervalo(n, m, canal) + " pertence ao intrevalo");
	}
	
	public static void Leituras () {
		Scanner var1 = new Scanner(System.in);
		Scanner var2 = new Scanner(System.in);
		Scanner var3 = new Scanner(System.in);
		
		System.out.print("Insere o teu nome: ");
		String nome = var1.nextLine();
		
		System.out.print("\n" + "Insere um número inteiro: ");
		int teiro = var2.nextInt();
		
		System.out.print("\n" + "Insere um número decimal: ");
		double dec = var3.nextDouble();
		
		double teira = teiro;
		double terec = teira + dec;
		
		System.out.print("\n" + "Caro " + nome + " ,somar " + teiro + " com " + dec + " dá " + terec);
	}
	
	public static int lerValorNoIntervalo(int n, int m, Scanner canal) {
		int cana = canal.nextInt();
		if(n > cana || m < cana) {
		while ( n > cana || m < cana) {
			System.out.print("\n" + "Erro , numero não pertence ao interevalo inserir novamente: ");
			cana = canal.nextInt();
		}
		}
		return cana;
	}
	
	public static void notas() {
		
	}
	
}
