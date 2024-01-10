package hallo_za_warudo;

public class Carro extends Veiculo {
	
	private String marca;
	private boolean bozina;
	private String mudancas;
	
	public Carro() {
		
	}
	
	public Carro(String marca, boolean bozina, String mudancas) {
		super(4,"Terra",true);
		this.marca = marca;
		this.bozina = bozina;
		this.mudancas = mudancas;
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public boolean isBozina() {
		return bozina;
	}
	public void setBozina(boolean bozina) {
		this.bozina = bozina;
	}
	public String getMudancas() {
		return mudancas;
	}
	public void setMudancas(String mudancas) {
		this.mudancas = mudancas;
	}
	
	
	
	
}
