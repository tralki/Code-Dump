package AULA7;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class AnimalAuciliar {
	AnimalHouse<Animal> h1 = new AnimalHouse<Animal>();
	Animal animal = new Animal(2);
	public static int getALegs(AnimalHouse<Animal> h1) {
		System.out.println(h1.getAnimal());
		return h1.getAnimal().getLegs();
	}
	
	public static int calcALegs(Collection<AnimalHouse<Animal>> lista) {
		int i = 0;
			for (AnimalHouse<Animal> h1 : lista) {
				i += getALegs(h1);
			}
		return i;
	}
	
	public static void addAnimal(AnimalHouse<Animal> h1 , Animal animal) {
		h1.setAnimal(animal);
		System.out.println(h1.getAnimal());
	}
	
	public static void addColAnimal(Collection<AnimalHouse<Animal>> lista , Animal animal) {
		AnimalHouse<Animal> h2 = new AnimalHouse<>();
		h2.setAnimal(animal);
		lista.add(h2);
	}
}