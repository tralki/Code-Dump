package aula13;

public class testes {
	public static void main(String[] args) throws INE {
		funExept bob = new funExept();
		int a = 19;
		int b = 4;
		int c = 0;
		float total1 = bob.divisaoSegura(a , c);
		System.out.println(total1);
		boolean ver = bob.verificar(a);
		System.out.println("Maior de 18 = " + ver);
		int la = bob.convToint("12");
		System.out.println(la);
	}
	}
