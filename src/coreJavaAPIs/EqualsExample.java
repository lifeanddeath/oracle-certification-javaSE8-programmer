package coreJavaAPIs;

public class EqualsExample {

	public static void main(String[] args) {
		String number = "1";
		int value = 1;
		boolean result = true;
		
		if (number.equals(value)) System.out.println("They are equal -1-"); // it would compile but not work
		if (Integer.parseInt(number) == value) System.out.println("This also works -2-"); //works
		if (number.equals(String.valueOf(value))) System.out.println("This might not work -3-"); //works
		
		// if (number == value )  // wouldn't work because they are different types.
	    if (number.equals(result)) System.out.println("dont expect that this works -4-");// equals doesn't care about type so it would compile but not work
	}

}
