package interace_exercises;

public class Donkey implements Movable{

	int location = 200;
	
	@Override
	public void move(int by) {
		location += by;
		
	}

	@Override
	public void moveBack(int by) {
		location -= by;
	}
	
	static void sayMyName() {
		System.out.println("from donkey class");
	}

}
