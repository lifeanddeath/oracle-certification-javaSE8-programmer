package coreJavaAPIs;

public class ArraySize {

	public static void main(String[] args) {
		String s[] = {"ahmet", "ahmet2", "ahmet3"};
		
		System.out.println(s.length);
		// System.out.println(s.size());  // wouldn't compile no such a method
		// System.out.println(s.length()); // wouldn't compile, length is a property not a method!
	}

}
