package aula14;

import java.util.ArrayList;
import java.util.List;

public class Conjuntos {
	public static List<List<Integer>> lista(List<Integer> nums) {
		List<List<Integer>> array = new ArrayList<>();
		arraycraft(nums , new ArrayList<>() , 0 , array);
		return array;
	}
	
	private static void arraycraft(List<Integer> nums, List<Integer> aray , int i , List<List<Integer>> array) {
		array.add(new ArrayList<>(aray));
		
		for (i = i ; i < nums.size(); i++) {
			aray.add(nums.get(i));
			arraycraft(nums , aray , i + 1, array);
			aray.remove(aray.size() - 1);
		}
		
	}
	public static void main(String[] args) {
        List<Integer> conjunto = new ArrayList<>();
        conjunto.add(1);
        conjunto.add(2);
        conjunto.add(3);

        List<List<Integer>> subconjuntos = lista(conjunto);

        for (List<Integer> subconjunto : subconjuntos) {
            System.out.println(subconjunto);
        }
    }
}

