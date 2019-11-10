package coreJavaAPIs;

public class StringVsStringBuilder {

	public static void main(String[] args) {
		String j = "java";
		StringBuilder j2 = new StringBuilder("java");
		
  //	if (j == j2)  // this wouldn't compile because they are different types!
		
		System.out.println("Starting..");
		System.out.println("j2 is: " + j2);
		
		if (j.equals(j2)) System.out.println("one"); //different types wouldn't print
		if (j==j2.toString()) System.out.println("two"); //equal operator for object reference comparison
		if (j==j2.append("").toString()) System.out.println("three"); // would't work because they are different objects
		if (j.equals(j2.toString())) System.out.println("four"); //euqals method compares the values. so it would work.
	}

}
