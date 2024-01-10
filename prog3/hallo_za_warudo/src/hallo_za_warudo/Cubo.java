package hallo_za_warudo;

public class Cubo {
	private double comprimento;private double altura;private double largura;
	public Cubo (int x , int y , int z) {
		comprimento = x;
		altura = y;
		largura = z;
	}
	public double getComprimento(){
		return comprimento;
	}
	public double getAltura() {
		return altura;
	}
	public double getLargura() {
		return largura;
	}
	public double getVolume() {
		double volume = getComprimento() * getAltura() * getLargura();
		return volume;
	} 	
}
