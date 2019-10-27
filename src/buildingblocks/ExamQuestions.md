# Exam Questions

In this file, I'll note several exam questions, in addition to but not limited to, tricky questions I come across during my preparation.

* 1) Which of the following are valid Java identifiers?

A. A$B

B. _helloWorld

C. true

D. java.lang

E. Public

F. 1980_s

Answer:
A, B, E. Option A is valid because you can use the dollar sign in identifiers. Option B is
valid because you can use an underscore in identifiers. Option C is not a valid identifier
because true is a Java reserved word. Option D is not valid because the dot (.) is not
allowed in identifiers. Option E is valid because Java is case sensitive, so Public is not
a reserved word and therefore a valid identifier. Option F is not valid because the first
character is not a letter, $, or _.

* 2. What is the output of the following program?

```
 public class WaterBottle {
		private String brand;
		private boolean empty;
		
		public static void main(String[] args) {
		WaterBottle wb = new WaterBottle();
		System.out.println("Empty = " + wb.empty());
		System.out.println(", Brand = " + wb.brand);
		}
} 

```

A. Line 6 generates a compiler error.

B. Line 7 generates a compiler error.

C. There is no output.

D. Empty = false, Brand = null

E. Empty = false, Brand =

F. Empty = null, Brand = null

Answer 

D. Boolean fields initialize to false and references initialize to null, so empty is false
and brand is null. Brand = null is output.