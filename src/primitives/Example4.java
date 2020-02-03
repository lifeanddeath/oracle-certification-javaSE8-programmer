package primitives;

public class Example4 {

	public int printNumber(int number) {
		return number;
	}
	
	public int getNumber() {
		Byte a = 10;
		int number = printNumber(a);
		
		return number;
	}
	
	public static void main(String... args) {
		System.out.println(new Example4().getNumber());
	}
}
