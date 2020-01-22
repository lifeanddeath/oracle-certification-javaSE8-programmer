package primitives;

public class InstanceInitializers {
	
	;

	{
		System.out.println("Whiz");
	};

	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			System.out.println(i);
		}
		;

		boolean b = true;

		while (b) {
			System.out.println("aa");
			b = false;
		}
		;

		if (!b) {
			b = true;
		}
		;

		b = false;
		System.out.println(b);

	};

}
