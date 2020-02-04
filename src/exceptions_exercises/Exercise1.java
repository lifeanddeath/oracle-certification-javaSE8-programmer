package exceptions_exercises;

public class Exercise1 {

	public static void main(String... args) {
		new Exercise1().someCalculation();
	}
	
	public void someCalculation() throws ArithmeticException {
		for (int i = 0; i < 4 ; i++)
			System.out.println(i);
	}
}
