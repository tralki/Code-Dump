package Projeto;

import java.util.Scanner;

public class treinador extends pessoas{
	int anosdecarreira;
	int titulosconsquistados;
	static treinador b = new treinador();
	public int getAnosdecarreira() {
		return anosdecarreira;
	}
	public void setAnosdecarreira(int anosdecarreira) {
		this.anosdecarreira = anosdecarreira;
	}
	public int getTitulosconsquistados() {
		return titulosconsquistados;
	}
	public void setTitulosconsquistados(int titulosconsquistados) {
		this.titulosconsquistados = titulosconsquistados;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDatadenascimento() {
		return datadenascimento;
	}
	public void setDatadenascimento(String datadenascimento) {
		this.datadenascimento = datadenascimento;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public treinador getTreiner() {
		Scanner sn = new Scanner(System.in);
		System.out.println("Indique o nome do Treinador");
		String p = sn.nextLine();
		b.setNome(p);
		System.out.println("Indique a sua data de nascimento");
		String p1 = sn.nextLine();
		b.setDatadenascimento(p1);
		System.out.println("Indique a sua nacionalidade");
		String p2 = sn.nextLine();
		b.setNacionalidade(p2);
		System.out.println("Indique quantos anos de carreira ele tem");
		int p3 = sn.nextInt();
		b.setAnosdecarreira(p3);
		System.out.println("Indique quantos titulos ele conquistou");
		int p4 = sn.nextInt();
		b.setTitulosconsquistados(p4);
		return b;
		
	}
}
