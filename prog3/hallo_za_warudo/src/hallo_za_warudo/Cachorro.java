package hallo_za_warudo;

public class Cachorro extends Animal implements voar {

	public Cachorro(String nome, int idade, String cor) {
		super(nome, idade, cor);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void voar() {
		System.out.println("Não pode voar");
		// TODO Auto-generated method stub
		
	}

	@Override
	void emitirSom() {
		System.out.println("Au Au!");
		// TODO Auto-generated method stub
		
	}

}
