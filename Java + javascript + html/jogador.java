package Projeto;

import java.util.Scanner;

public class jogador extends pessoas{
	static posicaojogador posicao = posicaojogador.AVANCADO;
	int numerodecamisola;
	int golosmarcados;
	int cartoesrecebidos;
	public posicaojogador getPosicaojogador() {
		return posicao;
	}
	public void setPosicaojogador(posicaojogador posicaojogador) {
		this.posicao = posicaojogador;
	}
	public int getNumerodecamisola() {
		return numerodecamisola;
	}
	public void setNumerodecamisola(int numerodecamisola) {
		this.numerodecamisola = numerodecamisola;
	}
	public int getGolosmarcados() {
		return golosmarcados;
	}
	public void setGolosmarcados(int golosmarcados) {
		this.golosmarcados = golosmarcados;
	}
	public int getCartoesrecebidos() {
		return cartoesrecebidos;
	}
	public void setCartoesrecebidos(int cartoesrecebidos) {
		this.cartoesrecebidos = cartoesrecebidos;
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
	public jogador setJogador(jogador j) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Diga qual é o nome do jogador");
		String p = sc.nextLine();
		j.setNome(p);
		System.out.println("Escolha a posição do jogador" + "\n1-Avancado" + "  2-Medio" + "  3-Defesa" + "  4-Guarda_Redes");
		int a = sc.nextInt();
		
		switch(a){
			case(1):{
				j.setPosicaojogador(posicao);
				break;
			}
			case(2):{
				posicao = posicaojogador.MEDIO;
				j.setPosicaojogador(posicao);
				break;
			}
			case(3):{
				posicao = posicaojogador.DEFESA;
				j.setPosicaojogador(posicao);
				break;
			}
			case(4):{
				posicao = posicaojogador.GUARDA_REDES;
				j.setPosicaojogador(posicao);
				break;
			}
			default:{
				j.setPosicaojogador(posicao);
				break;
			}
		}
		System.out.println("Indique o numero da camisola");
		a = sc.nextInt();
		j.setNumerodecamisola(a);
		System.out.println("Indique a sua data de nascimento");
		String b = sc.nextLine();
		j.setDatadenascimento(b);
		System.out.println("Indique a sua nacionalidade");
		String b1 = sc.nextLine();
		j.setNacionalidade(b1);
		System.out.println("Indique o numero de golos marcados");
		int a1 = sc.nextInt();
		j.setNumerodecamisola(a1);
		System.out.println("Indique o numero de cartões recebidos");
		int a2 = sc.nextInt();
		j.setCartoesrecebidos(a2);
		
		return j;
	}
}
