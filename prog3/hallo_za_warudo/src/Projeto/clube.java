package Projeto;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class clube implements gestaoclubes {
	static clube a = new clube();
	static treinador b = new treinador();
	String nome;
	String cidade;
	String pais;
	String datadefundacao;
	String estadio;
	List<jogador> listadejogadores = new ArrayList<>();
	treinador treinador;
	List<resultadopartida> resultados = new ArrayList<>();
	static int v = 0;
	static int d = 0;
	static int e = 0;
	
	public void getResultados(int r) {
			if (r == 1) {
				v++;
			}
			if (r == 2) {
				d++;
			}
			if (r == 3) {
				e++;
			}
	}
	public void getVitoria() {
		System.out.print(v);
	}
	public void getEmpate() {
		System.out.print(e);
	}
	public void getDerrota() {
		System.out.print(d);
	}
	public void setResultados(List<resultadopartida> resultados) {
		this.resultados = resultados;
	}
	public clube getclube(clube a) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Porfavor insira o nome do clube");
		String p = sn.nextLine();
		a.setNome(p);
		System.out.println("Porfavor insira o nome da cidade");
		String p1 = sn.nextLine();
		a.setCidade(p1);
		System.out.println("Porfavor insira o nome do pais");
		String p2 = sn.nextLine();
		a.setPais(p2);
		System.out.println("Porfavor insira a data de fundação do clube");
		String p3 = sn.nextLine();
		a.setDatadefundacao(p3);
		System.out.println("Porfavor insira o nome do estadio");
		String p4 = sn.nextLine();
		a.setEstadio(p4);
		System.out.println("Porfavor adicione as informações referentes ao treinador");
		b.getTreiner();
		return a;
	}
	public static void setclube(String a) {
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getDatadefundacao() {
		return datadefundacao;
	}
	public void setDatadefundacao(String datadefundacao) {
		this.datadefundacao = datadefundacao;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public List<jogador> getListadejogadores(List<jogador> lol) {
		for (int i = 0 ; i < listadejogadores.size(); i++) {
			jogador jojo = listadejogadores.get(i);
			System.out.println(jojo.getNome());
		}
		return listadejogadores;
	}
	public void setListadejogadores(List<jogador> listadejogadores) {
		this.listadejogadores = listadejogadores;
	}
	public void addjogador(jogador jog) {
		listadejogadores.add(jog);
	}
	public void removerjogador(jogador jogador) {
		listadejogadores.remove(jogador);
	}
	public String getTreinador() {
		return b.getNome();
	}
	public void setTreinador(treinador treinador) {
		this.treinador = treinador;
	}
	public static void apresentacaoclub(clube c) {
		
	}
	public void adicionaClube(clube c) {
		// TODO Auto-generated method stub
		
	}
	public void removerClube(clube c) {
		// TODO Auto-generated method stub
		
	}

}
