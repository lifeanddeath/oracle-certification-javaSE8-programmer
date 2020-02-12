package primitives;

public class Example9 {
	
	int x = 3;

	// doesn't compile because it should be compile time constant
	public static void main(String[] args) {
		String[] b = new String[] {"a","b","c"};
		
		switch("c") {
		case b[0]: System.out.println("hi");
		}
	}

}
