package coreJavaAPIs;

public class StringBuilderVsStringBuilder {

	public static void main(String[] args) {
		String java = "java";
	//	StringBuilder sb1 = "Hello";  // --> wouldn't compile because u can't assign string to stringbuilder
		StringBuilder sb2 = new StringBuilder(java);
		StringBuilder sb3 = new StringBuilder("java");
		StringBuilder sb4 = sb2;
		
		if (sb2 == sb3)  System.out.println("one");  // wouldn't compile because they refer to different objects
		if (sb2 == sb4)  System.out.println("two");  // prints because they refer to same object
		if (sb3 == sb4)  System.out.println("three"); // same like first if condition, they are different objects
		if (sb2.equals(sb3))  System.out.println("four"); //wouldn't work because they are differnt objects
		if (sb2.equals(sb4))  System.out.println("this would work"); //this works because their content is equal
		if (sb2.equals(sb3.toString())); System.out.println("this is tricky");  //it works
		if (sb2.toString().equals(sb4)) System.out.println("five"); // it doesn't work
		if (sb2.toString().equals(sb4.toString())) System.out.println("six"); //this also works
		
	//	sb4 += "Addition";  // wouldn't compile because it is not a string!
		sb4.append("Addition");
		System.out.println("sb2 is: " + sb2 + " Sb4 is: " + sb4);
		if (sb2.toString() == sb4.toString()) System.out.println("seven"); //doesn't work because they are different objects
		if (sb2.equals(sb4)) System.out.println("eight"); //works because it refers to the same object
		if (sb2.toString().equals(sb4.toString())) System.out.println("nine"); //also works
	}

}
