package hallo_za_warudo;

public class Aeronave extends Veiculo{
	
	private int mutores;
	private boolean rodas_coverciveis;
	private boolean publico;
	
	public Aeronave() {
		
	}
	
	public Aeronave(int torbinas, boolean rodas_coverciveis, boolean publico) {
		super(3,"Aerio",true);
		this.mutores = torbinas;
		this.rodas_coverciveis = rodas_coverciveis;
		this.publico = publico;
	}

	public int getTorbinas() {
		return mutores;
	}

	public void setTorbinas(int torbinas) {
		this.mutores = torbinas;
	}

	public boolean getBool_passageiros() {
		return rodas_coverciveis;
	}

	public void setNum_passageiros(boolean rodas_coverciveis) {
		this.rodas_coverciveis = rodas_coverciveis;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}

}
