package coreJavaAPIs;

import java.util.ArrayList;
import java.util.List;

public class ArraylistEqualsOverride {

	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
		List<String> l2 = new ArrayList<String>();
		List<String> l3 = l1;
		
		l1.add("ahmet");
		l1.add("ahmet2");
		l2.add("ahmet");
		l2.add("ahmet2");
		
		if (l1.equals(l2)) System.out.println("one");
	    if (l3.equals(l2)) System.out.println("two");
	    
	    l2.add("ahmet3");
	    
		if (l1.equals(l2)) System.out.println("three");
        if (l1 == l2) System.out.println("four");		

	}

}
