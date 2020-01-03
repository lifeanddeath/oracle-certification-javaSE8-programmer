package loops_output_exercises;

public class Exercise1 {
	
	int k = 5;
	
	public boolean checkIt (int k) {
		return this.k-->0? true: false;
	}
	
	public void printThem() {
		while (checkIt(k)) {
			System.out.println(k);
		}
	}

	public static void main(String[] args) {
		new Exercise1().printThem();
	}

}
