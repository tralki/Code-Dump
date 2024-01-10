package aula14;
import java.util.*;
public class palindromo {
		private static boolean traFren(char palavra[] , int i , int sum) {
			if ( i < palavra.length/2) {
				if (palavra[i] != palavra[palavra.length - i - 1]){
					i++;
					sum++;
					return traFren(palavra , i , sum);
				} 
				else {
					i++;
					return traFren(palavra , i , sum);
				}
			}
			
			if (sum >= 1) {
			return false;
			}
			else {
			return true;
			}
				
		}
		public static boolean tranFren(String palavra) {
			char[] arr = palavra.toCharArray();
			return traFren(arr , 0 ,0);
		}
		
		public static void main(String[] args) {
			String palavra1 = "abracadabra";
			String palavra2 = "palitotilap";
			
			System.out.println(tranFren(palavra1));
			System.out.println(tranFren(palavra2));
			
		}
}
