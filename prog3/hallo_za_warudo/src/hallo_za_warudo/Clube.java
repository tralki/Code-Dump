package hallo_za_warudo;

import java.util.Random;


public class Clube {
	protected String nome;
	private int id;
	private int ano_criacao;
	private String nome_fundador;
	
	public Clube() {
		
	}
	
	public Clube(String nome, int ano_criacao, String fundador) {
		this.nome = nome;
		this.ano_criacao = ano_criacao;
		nome_fundador = fundador;
		id = new Random().nextInt(ano_criacao);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAno_criacao() {
		return ano_criacao;
	}

	public void setAno_criacao(int ano_criacao) {
		this.ano_criacao = ano_criacao;
	}

	public String getNome_fundador() {
		return nome_fundador;
	}

	public void setNome_fundador(String nome_fundador) {
		this.nome_fundador = nome_fundador;
	}

	public int getId() {
		return id;
	}

}
