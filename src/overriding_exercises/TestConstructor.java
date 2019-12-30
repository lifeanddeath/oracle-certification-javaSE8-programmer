package overriding_exercises;

public class TestConstructor {
	
	int a = 3;
	
	public TestConstructor() {}
	
	public TestConstructor (int b) {
		b = a;
	}

}
