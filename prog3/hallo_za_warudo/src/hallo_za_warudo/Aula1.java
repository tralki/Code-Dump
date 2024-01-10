package hallo_za_warudo;

import java.util.Scanner;

public class Aula1 {
	public static void main(String[] args) {
		
		int n = 0;
		char[] charlista = {'j','o','n','n','y'};
		String str = "Jorge";
		char c = 'S';
		double num = 2.34;
		
		Scanner sn = new Scanner(System.in);
		
		String nome = sn.nextLine(); 
		
		System.out.print("Guten Morgen " + nome);
	}
}
