package coreJavaAPIs;

public class StringConcat {

	public static void main(String[] args) {
		String s1 = "1";
			   s1 = s1.concat("5");
		String s2 = s1.concat("2");
		
		System.out.println(s1);
		
		System.out.println("S2 is: " + s2);
		
		s2.concat("3");
		System.out.println(s2);
		
		System.out.println("S2 is: " + s2);
		
		System.out.println(s1.concat("9"));

	}

}
