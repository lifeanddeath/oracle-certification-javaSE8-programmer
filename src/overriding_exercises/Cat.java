package overriding_exercises;

public class Cat extends Animal{
	
	int someNumber = 20;
	
	static int secondNumber = 30;
	
	static void testClassMethod() {
		System.out.println("this method is from cat class");
	}
	
	void testInstanceMethod() {
		System.out.println("this method is from cat class");
	}

	public static void main(String[] args) {
		
		Animal animal = new Cat();
		Cat cat = new Cat();
		
		animal.testClassMethod(); // prints animal
		animal.testInstanceMethod(); //prints cat
		Animal.testClassMethod(); // prints animal
		System.out.println(animal.someNumber); //prints 10
		System.out.println("second" + animal.secondNumber);
		
		cat.testClassMethod();     //prints cat
		cat.testInstanceMethod();  //prints cat
		System.out.println(cat.someNumber); // prints 20
		System.out.println("second" + cat.secondNumber);
		
		System.out.println(new Cat().someNumber); // prints 20
		new Cat().testClassMethod(); // prints cat
		new Cat().testInstanceMethod(); // prints cat
		
	//	Cat castedCat = (Cat) new Animal(); // gives class cast exception because of overriding
	//	castedCat.testClassMethod();    
	//	castedCat.testInstanceMethod();  
		
	}

}
