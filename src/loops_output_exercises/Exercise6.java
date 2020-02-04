package loops_output_exercises;

public class Exercise6 {

	public static void main(String... args) {
		
		//these wouldn't compile
		
		while (2 > 9) {
			System.out.println("2");
		}
		
		for (int i = 0; false; i++) {
			System.out.println(i);
		}
		
	}
}
