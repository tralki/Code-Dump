package aula14;

import java.util.ArrayList;
import java.util.List;

public class bla {

	    public static List<List<Integer>> gerarSubconjuntos(List<Integer> conjunto) {
	        List<List<Integer>> subconjuntos = new ArrayList<>();
	        gerarSubconjuntosAux(conjunto, new ArrayList<>(), 0, subconjuntos);
	        return subconjuntos;
	    }

	    private static void gerarSubconjuntosAux(List<Integer> conjunto, List<Integer> subconjuntoAtual, int index, List<List<Integer>> subconjuntos) {
	        subconjuntos.add(new ArrayList<>(subconjuntoAtual)); // Adiciona o subconjunto atual à lista de subconjuntos

	        for (int i = index; i < conjunto.size(); i++) {
	            subconjuntoAtual.add(conjunto.get(i)); // Adiciona o elemento atual ao subconjunto atual
	            gerarSubconjuntosAux(conjunto, subconjuntoAtual, i + 1, subconjuntos); // Chama recursivamente a função para o próximo elemento
	            subconjuntoAtual.remove(subconjuntoAtual.size() - 1); // Remove o elemento atual do subconjunto atual
	        }
	    }

	    public static void main(String[] args) {
	        List<Integer> conjunto = new ArrayList<>();
	        conjunto.add(1);
	        conjunto.add(2);
	        conjunto.add(3);

	        List<List<Integer>> subconjuntos = gerarSubconjuntos(conjunto);

	        // Imprime os subconjuntos gerados
	        for (List<Integer> subconjunto : subconjuntos) {
	            System.out.println(subconjunto);
	        }
	    }
	}
 
