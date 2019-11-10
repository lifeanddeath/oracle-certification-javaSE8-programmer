package coreJavaAPIs;


import java.util.Arrays;
import java.util.List;

public class ArrayToListExample {

	public static void main(String[] args) {
		String names[] = {"Tom", "Ahmet", "Eroglu"};
		List<String> list = Arrays.asList(names);
		list.set(0, "Alex");
		System.out.println(list.get(0));
	}

}
