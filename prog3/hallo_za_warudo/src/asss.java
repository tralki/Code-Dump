import java.util.List;

public class asss {
	public static void main(String[] args) {
		int a = 94728;
		System.out.print("o menor numero é "+ menorAlgoritmo(convertToArray(a)));
	}
	
	public static int menorAlgoritmo(int [] a) {
		int k = 9;
		for (int i = 0; i < a.length ; i++) {
			if (k != a[i]) {
				if(k > a[i]) {
					k = a[i];
				}
			}
		}
		return k;
	}
	
	public static int[] convertToArray(int a) {
		String b = Integer.toString(a);
		int [] c = new int[b.length()];
		for (int i = 0; i < b.length(); i++) {
			c[i] = b.charAt(i) - '0';
			System.out.println(c[i] + " " + b.charAt(i));
		}
		return c;
	}
}
