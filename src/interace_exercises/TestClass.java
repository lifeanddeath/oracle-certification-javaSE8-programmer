package interace_exercises;

public class TestClass {

	public static void main(String[] args) {
		
		Movable movable = new Donkey();
		Donkey donkey  = new Donkey();
		movable.move(10);
		movable.moveBack(20);
		donkey.move(10);
		donkey.moveBack(20);
		
		System.out.println(movable.location); // prints 0
		System.out.println(donkey.location); // prints 190
	}

}
