package interace_exercises;

public interface Movable {
	int location = 0;
	
	void move(int by);
	
	public void moveBack(int by);
	
	static void sayMyName() {
		System.out.println("from movable interface");
	}
}
