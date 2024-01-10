package aula14;

public class fibonas {
	public static int fibas(int a , int b , int n) {
		System.out.print(a + " " + b + " ");
		return fibas (a , b , 0 , 0 , n);
	}
	private static int fibas(int a , int b , int c , int i , int n) {
	  if(i < n) {	
		c = a + b;
		a = b ;
		b = c ;
		System.out.print(c + " ");
		i++;
		return fibas(a ,b ,c ,i ,n);
	}
	else {
		return 0 ;
	}
	}
	public static void main(String[] args) {
		int n = 7;
		int a = 0;
		int b = 1;
		fibas(a ,b ,n-1);
		
		}
	}

