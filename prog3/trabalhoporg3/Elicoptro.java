package hallo_za_warudo;

public class Elicoptro extends Aeronave{
	
	private int helices;
	private int passageiros;
	private String piloto;
	
	public Elicoptro() {
		
	}
	
	public Elicoptro(int helices, int passageiros, String piloto) {
		super(2,false,false);
		this.helices = helices;
		this.passageiros = passageiros;
		this.piloto = piloto;
	}

	public int getHelices() {
		return helices;
	}

	public void setHelices(int helices) {
		this.helices = helices;
	}

	public int getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(int passageiros) {
		this.passageiros = passageiros;
	}

	public String getPiloto() {
		return piloto;
	}

	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}
}
