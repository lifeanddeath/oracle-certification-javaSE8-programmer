package overriding_exercises;

public class TestClass {

	public static void main(String[] args) {
		ABCD a = new MNOB();
		System.out.println(new MNOB().x + " and " + new MNOB().y);
		System.out.println(a.x + " and " + a.y);
	}

}
