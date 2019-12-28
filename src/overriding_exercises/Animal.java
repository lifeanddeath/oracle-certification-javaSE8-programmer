package overriding_exercises;

public class Animal {
	
	int someNumber = 10;
	
	static int secondNumber = 20;
	
	 static void testClassMethod() {
		System.out.println("this is a method in Animal Class");
	}
	
     void testInstanceMethod() {
    	 System.out.println("this is a instance method in Animal Class");
     }
}
