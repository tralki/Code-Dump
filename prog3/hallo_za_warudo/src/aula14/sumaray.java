package aula14;

public class sumaray {
		public static int sumArray(int num[]) {
			int total = 0;
			for (int i = 0; i < num.length ; i++) {
				total = total + num[i];
			}
			return total;
		}
		public static int sumArrayRec(int num[],int i , int total ) {
			if (i < num.length) {
				total = total + num[i];
						i++;
				return sumArrayRec(num , i , total);	
			} else {
				return total;
			}
		}
		public static void main(String[] args) {
			int total = 0;
			int i = 0;
			int num[] = {1,2,3,4,5,6,7,8,9};
			System.out.println(sumArrayRec(num , i , total));
		}
}
