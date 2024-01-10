package hallo_za_warudo;

public class Avião extends Aeronave {
	
	private int Asas;
	private int passageiros;
	private String piloto;

	public Avião() {
		
	}
	
	public Avião(int Asas, int passageiros, String piloto) {
		super(2,true,true);
		this.Asas = Asas;
		this.passageiros = passageiros;
		this.piloto = piloto;
	}

	public int getAsas() {
		return Asas;
	}

	public void setAsas(int asas) {
		Asas = asas;
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
