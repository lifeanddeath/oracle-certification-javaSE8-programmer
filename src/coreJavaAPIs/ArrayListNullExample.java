package coreJavaAPIs;

import java.util.ArrayList;
import java.util.List;

public class ArrayListNullExample {

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<>();
		l.add(Integer.parseInt("4"));
		l.add(Integer.valueOf(6));
		l.add(7);
		l.add(null);  // compiles but throws exception!
		
		for(int number: l) {
			System.out.println(number);
		}
	}

}
