package hallo_za_warudo;

import java.lang.Math;

public class Matrizes {

	public static void main(String[] args) {
		int i;
		int j;
		int k = 0;
		int a = 99;
		int vp = 0;
		int sv = 0;
		double sqv = 0;
		boolean tf = false;
		/*1º*/int v [] = {4,6,2,8};
		int l = v.length;
		/*2º*/int nums []= {1,2,3,4,5,6,7,8,9}; 
		/*3º*/for (i=0;i<v.length;i++) {
			if(a > v[i]) {
				a = v[i];
			}
		}
		System.out.println("O menor numero de v é " + a);
		/*4º*/ for (i=0;i<v.length;i++) {
			vp = v[i] + vp;
		}
		vp = vp / v.length;
		System.out.println("A media de v é " + vp);
		/*5º*/ for (i=0;i<v.length;i++) {
			sv = (v[i] - vp)*(v[i] - vp) + sv;
		}
		sv = sv / v.length;
		sqv = Math.sqrt(sv);
		System.out.println("O desvio padrão de v é " + sqv);
		/*6º*/ for (i=0;i<v.length;i++) {
			if (v[i] == 0) {
				tf = true;
			}
			else {
				tf = false;
			}
		}
		System.out.println("A preposição , o vetor 'v' tem um 0 é , " + tf);
		/*7º*/for (i=0;i<v.length;i++) {
				for (j=0;j<nums.length;j++) {
					if (v[i] == nums[j]) {
						tf = true;
					}
				}
		}
		System.out.println("A preposição , o vetor 'v' tem pelomenos um valor igual ao vetor 'nums' é , " + tf);
		/*8º*/for (i=0;i<v.length;i++) {
				for (j=0;j<nums.length;j++) {
					if (v[i] == nums[j]) {
						k++;
				}
			}
		}
		if (k == v.length) {
			tf = true;
		}
		else {
			tf = false;
		}
		System.out.println("A preposição , todos os valores do vetor 'v' existem no vetor 'nums' é , " + tf);
		/*9º*/for (i=0;i<v.length;i++) {
				for (j=0;j<v.length;j++) {
					if(v[i] == v[j] && i != j) {
						tf = true;
						break;
					}
					else {
						tf = false;
					}	
				}
		}
		System.out.println("A preposição , o vetor 'v' tem valores repetidos é , " + tf);
		/*10º*/System.out.print("O vetor 'v' invertido é  [");
				for (i=0;i<v.length;i++) {
				l--;
				v[i] = v[l];
				System.out.print(v[i]);
			 }
		System.out.println("]");
	}		
 
}
