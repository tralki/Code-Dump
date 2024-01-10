package hallo_za_warudo;

public class Pato extends Animal implements voar {

	public Pato(String nome, int idade, String cor) {
		super(nome, idade, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void voar() {
		System.out.println("Pode voar");
		// TODO Auto-generated method stub
		
	}

	@Override
	void emitirSom() {
		System.out.println("Quack!");
		// TODO Auto-generated method stub
		
	}

}
