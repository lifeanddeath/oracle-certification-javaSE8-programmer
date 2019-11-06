package coreJavaAPIs;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {

	public static void main(String[] args) {
		List<String> myList = new ArrayList();
		myList.add("ahmet");
		myList.add("ismet");
		
		String[] stringArray = myList.toArray(new String[0]);
		System.out.println(stringArray.length);
	}

}
