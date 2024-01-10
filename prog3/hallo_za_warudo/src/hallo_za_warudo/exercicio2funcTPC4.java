package hallo_za_warudo;
import java.util.Scanner;
import java.lang.String;

public class exercicio2func {
	
/*a. static int howMany(int[] v, int x) que determina o número de entradas de v que têm
o valor x, assumindo que v não é null.
b. static boolean exists(int[] v, int x) que verifica se existe alguma ocorrência de x em
v, assumindo que v não é null.
c. static int sum(int[] v) que determina a soma dos números em v, assumindo que v não
é null.
*/
	public static void main(String[] args) {
		int[] v = new int[5]; int x; int i; 
		Scanner var = new Scanner(System.in);
		System.out.println("Insira os numeros da variavel ");
		for (i = 0; i < v.length ; i++) {
			v[i] = var.nextInt();
		}
		System.out.println("Insira um numero ");
		x = var.nextInt();
		System.out.println("Existem " + howMany(v , x) + " veses o numero " + x + " no array v");
		System.out.println("A preposição , Existe x no array v é : " + exists(v , x));
		System.out.println("A soma de todos os valores de v é : " + sum(v));
	}
	public static int howMany(int [] v, int x) {
		int c=0; int j;
		for (j=0;j<v.length;j++) {
			if (v[j] == x) {
				c++;
			}
		}
		return c;
	}
	public static boolean exists(int[] v, int x) {
		int j;
		for (j=0;j<v.length;j++) {
			if (v[j] == x) {
				return true;
			}
		}
		return false ;
	}
	public static int sum(int[] v) {
		int sam = 0;int j;
		for (j=0;j<v.length;j++) {
			sam = sam + v[j];
		}
		return sam;
	}

}
