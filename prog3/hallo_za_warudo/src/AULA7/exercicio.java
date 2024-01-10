package AULA7;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class exercicio {
	
	public static void main(String[] args) {
		
	AnimalHouse<Animal> house1 = new AnimalHouse<>();
	
	house1.setAnimal(new Animal(6));
	
	AnimalHouse<Animal> house2= new AnimalHouse<>();
	house2.setAnimal(new Animal(5));
	
	AnimalHouse<Animal> house3= new AnimalHouse<>();
	house3.setAnimal(new Animal(4));
		
	int Legs1 = AnimalAuciliar.getALegs(house1);
	
	System.out.println("Exercicio B NumPer = " + Legs1);
	
	ArrayList<AnimalHouse<Animal>> lista = new ArrayList<>();
	
	lista.add(house1);lista.add(house3);lista.add(house2);
	
	int Alegs = AnimalAuciliar.calcALegs(lista);
	System.out.println("Exercicio C Todas as Patas = " + Alegs);
	
	Animal animal = new Animal(8);
	System.out.print("Exercicio D = " );
	AnimalAuciliar.addAnimal(house3 , animal);
	
	AnimalAuciliar.addColAnimal(lista, new Animal(13));
	
	int Blegs = AnimalAuciliar.calcALegs(lista);
	System.out.println("Exercicio E Com o novo par de patas = " + Blegs);
	
	
}
}