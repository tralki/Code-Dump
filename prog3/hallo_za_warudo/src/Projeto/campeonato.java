package Projeto;

import java.util.List;

public class campeonato {
	String nome;
	String pais;
	String temporada;
	List<clube> listaclub;
	List<String> gestaotabela;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public List<clube> getListaclub() {
		for (int i = 0 ; i < listaclub.size(); i++) {
			clube jojo = listaclub.get(i);
			String jon = jojo.getNome();
			System.out.println(jon);
		}
		return listaclub;
	}
	public void setListaclub(List<clube> listaclub) {
		this.listaclub = listaclub;
	}
	public List<String> getGestaotabela(List<String> al) {
		for (int i = 0 ; i < gestaotabela.size(); i++) {
			String jojo = gestaotabela.get(i);
			System.out.println(jojo);
		}
		return gestaotabela;
	}
	public void setGestaotabela(List<String> gestaotabela) {
		this.gestaotabela = gestaotabela;
	}
	public void insirtGestaotabela(List<String> gestaotabela , clube a, clube b, int i, int j) {
		gestaotabela.add(a +" "+ i + " - " + j +" "+ b);
	}
	public void remuveGestaotabela(List<String> gestaotabela , clube a, clube b, int i, int j) {
		gestaotabela.remove(a +" "+ i + " - " + j +" "+ b);
	}
	
	public void addclub(clube c) {
		listaclub.add(c);
	}
	public void remuveclub(clube c) {
		listaclub.remove(c);
	}
}
