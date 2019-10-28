package operators_and_statements;

public class PostAndPreIncrements {
	private int a = 2;
	
	public static void main(String[] args) {
		PostAndPreIncrements postAndPreIncrements = new PostAndPreIncrements();
		System.out.println(postAndPreIncrements.a);  // console = 2 a = 2
		System.out.println(postAndPreIncrements.a++); // console = 2  a = 3
		System.out.println(++postAndPreIncrements.a);  // console = 4 a = 4
		System.out.println(postAndPreIncrements.a++);  // console = 4 a = 5
		System.out.println(--postAndPreIncrements.a);  // console =  4 a = 4
		System.out.println(postAndPreIncrements.a--);  // console  = 4 a = 3
		System.out.println(postAndPreIncrements.a); // console = 3 a = 3
	}

}
