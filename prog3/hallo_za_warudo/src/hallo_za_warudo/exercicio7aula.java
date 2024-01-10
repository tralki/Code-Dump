package hallo_za_warudo;

public class exercicio7aula {

	public static void main(String[] args) {
		Cachorro bobby = new Cachorro("bobby" , 4 , "amarelo");
		Pato SrPenas = new Pato("SrPenas" , 2 , "branco");
		bobby.emitirSom();
		bobby.voar();
		SrPenas.emitirSom();
		SrPenas.voar();
	}

}
