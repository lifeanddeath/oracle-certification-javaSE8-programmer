package primitives;

public class Example7 {
	
	// this wouldn't compile because cases should be compile time constant.

	public static void main(String[] args) {
		int  a = 4;
		int b = 0;
		
		switch (a) {
		case b: System.out.println("first case");
		case b+1: System.out.println("first case");
		}
	}

}
