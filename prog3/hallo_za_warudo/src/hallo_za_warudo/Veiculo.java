package hallo_za_warudo;

public class Veiculo {
	private int rodas;
	private String locumocao;
	private boolean mutor;
	
	public Veiculo() {
		
	}
	
	public Veiculo(int rodas , String locumocao , boolean mutor) {
		this.rodas = rodas;
		this.locumocao = locumocao;
		
		this.mutor = mutor;
	}

	public int getRodas() {
		return rodas;
	}

	public void setRodas(int rodas) {
		this.rodas = rodas;
	}

	public String getLocumocao() {
		return locumocao;
	}

	public void setLocumocao(String locumocao) {
		this.locumocao = locumocao;
	}

	public boolean isMutor() {
		return mutor;
	}

	public void setMutor(boolean mutor) {
		this.mutor = mutor;
	}
}
