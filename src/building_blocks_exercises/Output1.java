package building_blocks_exercises;

public class Output1 {

	public static void main(String[] args) {
		
		for (int i = 1; i < 3; i++ ) {
			System.out.println("main question:" + i);
		}
		
		for (int t = 1; t++ < 3; t++ ) {
			System.out.println("first option" + t);
		}
		
		int i = 1; 
		while (i++ < 3) {
			System.out.println("second option:"+i);
		}
		
		
		i = 1;
		
		do {
			System.out.println("third option" + i);
		} while(i++ < 3);
	

	}

}
