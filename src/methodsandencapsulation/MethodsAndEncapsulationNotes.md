## Methods And Encapsulation

## Designing Methods

```
public final void nap(int minutes) throws Exception {
	// take a nap
}
```

This is called a method declaration.


## Access Modifiers

Java offers four choices of access modifiers.

<b>public</b> The method can be called from an any class.
<br>
<b>private</b> The method can only be called within the same class.
<br>
<b>protected</b> The method can only be called from classes in the same package or subclasses
<br>
<b>Default(Package Private)</b> The method can only be called from classes in the same
package. This one is tricky because there is no keyword for default access. You simply omit
the access modifier.
<br>


Let's consider the following examples:

```
public void walk1() {}
default void walk2() {} // DOES NOT COMPILE because default is not a legal keyword
void public walk3() {} // DOES NOT COMPILE because access modifier is defined after the return type.
void walk4() {}
}
```

## Optional Specifiers

<b>static</b> Used for class methods.
<br>
<b>abstract</b> Used when not providing a method body.
<br>
<b>final</b> Used when a method is not allowed to be overriden by a subclass' method.
<br>
<b>synchronize</b> Regarding to the OCP exam.
<br>
<b>native</b> Not on the OCA or OCP exam. Used when interacting with code written in
another language such as C++.
<br>
<b>strictfp</b> Not on the OCA or OCP exam. Used for making floating-point calculations
portable.
<br>

Let's consider the following examples:

```
public void walk1() {}
public final void walk2() {}
public static final void walk3() {}
public final static void walk4() {}
public modifier void walk5() {} // DOES NOT COMPILE because modifier is not a legal specifier keyword.
public void final walk6() {} // DOES NOT COMPILE because optional modifier is after the return type.
final public void walk7() {} // java allows optional specifiers to appear before the access modifiers.
}
```

## Return Type

The return type might be an
actual Java type such as String or int. If there is no return type, the void keyword is used.
This special return type comes from the English language: void means without contents. In
Java, we have no type there.

Let's consider some examples:

```
public void walk1() { }
public void walk2() { return; }
public String walk3() { return ""; }
public String walk4() { } // DOES NOT COMPILE
public walk5() { } // DOES NOT COMPILE
String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE because if a is not 4, then we dont specify a return type.
```

## Method Name 

Method names follow the same rules as we practiced with variable names in Chapter 1. To review, an identifier may only contain letters, numbers or $,_ signs. Importantly, the first character is not allowed to be a number , and reserved words are not allowed.

```
public void walk1() { }
public void 2walk() { } // DOES NOT COMPILE
public walk3 void() { } // DOES NOT COMPILE
public void Walk_$() { }
public void() { } // DOES NOT COMPILE
```

## Working with Varargs

A method may use a vararg parameter(variable argument) as if it is an array. It is a little different than array, though. A vararg parameter must be the last element in a method's parameter list. This implies you are only allowed to have one vararg parameter per method.

```
public void walk1(int... nums) { }
public void walk2(int start, int... nums) { }
public void walk3(int... nums, int start) { } // DOES NOT COMPILE
public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
```
```
15: public static void walk(int start, int... nums) {
16: System.out.println(nums.length);
17: }
18: public static void main(String[] args) {
19: walk(1); // 0
20: walk(1, 2); // 1
21: walk(1, 2, 3); // 2
22: walk(1, new int[] {4, 5}); // 2
23: }
```

## Applying Access Modifiers

### Private Access

Private access is easy. Only code in the same class can call private methods or access private fields.

### Defaul(Package Private) Access

When there is no access modifier, Java uses the default, which is package private access. This means that the member is private to classes in the same package. In other words, only classes in the package may access it.

### Protected Access

Protected access allows everything that default package access allows and more. The protected access modifier adds ability to access members of a parent class.

### Public Access

Anyone can call from anywhere!.

## Static Methods and Fields

Static methods have two main purpose:

1) For utility or helper methods that don't require any object state. Since there is no need to access instance variables, having static methods eliminates the need for the called to instantiate the object just to call the method.

2) For state that is shared by all instances of a class, like a counter. All instances must share the same state. Methods that merely use that state should be static as well.

```
Koala.count = 4;
Koala koala1 = new Koala();
Koala koala2 = new Koala();
koala1.count = 6;
koala2.count = 5;
System.out.println(Koala.count);
```

It prints as 5. There is only one count variable since it is static. It is set to 4,6 and finally winds up as 5. All the koala variables are just distractions.

## Static vs. Instance

A static member cannot call an instance member. This shouldn't be a suprise since static doesn't require any instance of the classs to be around.

A typical mistake that is done by rookie programmers:

```
public class Static {
	private String name = "Static class";
	public static void first() { }
	public static void second() { }
	public void third() { System.out.println(name); }
	public static void main(String args[]) {
		first();
		second();
		third(); // DOES NOT COMPILE
} }
```

Let's consider the following example:

```
1: public class Gorilla {
2: 	public static int count;
3: 	public static void addGorilla() { count++; }
4: 	public void babyGorilla() { count++; }
5: 	public void announceBabies() {
6: 		addGorilla();
7: 		babyGorilla();
8: }
9: 	public static void announceBabiesToEveryone() {
10: 		addGorilla();
11: 		babyGorilla(); // DOES NOT COMPILE
12: }
13: public int total;
14: public static average = total / count; // DOES NOT COMPILE
15: }
```

Lines 3 and 4 are fi ne because both static and instance methods can refer to a static
variable. Lines 5–8 are fi ne because an instance method can call a static method. Line 11
doesn’t compile because a static method cannot call an instance method. Similarly, line 14
doesn’t compile because a static variable is trying to use an instance variable.

```
public class Counter {
	private static int count;
	public Counter() { count++; }
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		Counter c3 = new Counter();
		System.out.println(count); // 3
	}
}
```

## Static variables

Some static variables are meant to change as the program runs. Counter are a common example of this. We want the count to icrease over time. Just as with instance variables, you can initialize a static variable on the line it is declared.

```
public class Initializers {
	private static int counter = 0; // initialization
}
```

Other static variables are meant t onever change during the program. This type of variables is known as a constant. It uses the final modifier to ensure the variable never changes. Static final constants use a different naming convention than other variables. They use all uppercase letters with underscores between words .

```
public class Initializers {
	private static final int NUM_BUCKETS = 45;
	public static void main(String[] args) {
	NUM_BUCKETS = 5; // DOES NOT COMPILE
} }
```

```
private static final ArrayList<String> values = new ArrayList<>();
	public static void main(String[] args) {
	values.add("changed");
}
```

Above example actually does compile.  values is a reference variable. We are allowed to call methods on reference variables. All the compiler can do is check that we don't try to reassign the final values to point to a different object.

## Static Initialization

```
private static final int NUM_SECONDS_PER_HOUR;
	static {
	int numSecondsPerMinute = 60;
	int numMinutesPerHour = 60;
	NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
}
}
```
The static initializer runs when the class is fi rst used. The statements in it run
and assign any static variables as needed. There is something interesting about
this example. We just got through saying that fi nal variables aren’t allowed to
be reassigned. The key here is that the static initializer is the fi rst assignment.
And since it occurs up front, it is okay.
Let’s try another example to make sure you understand the distinction:

```
14: private static int one;
15: private static final int two;
16: private static final int three = 3;
17: private static final int four; // DOES NOT COMPILE
18: static {
19: one = 1;
20: two = 2;
21: three = 3; // DOES NOT COMPILE
22: two = 4; // DOES NOT COMPILE
23: }
```
## Static Imports

```
import java.util.List;
import java.util.Arrays;
public class Imports {
public static void main(String[] args) {
List<String> list = Arrays.asList("one", "two");
}
}
```
Also could be called like this:

```
import java.util.List;
import static java.util.Arrays.asList; // static import

public class StaticImports {
	public static void main(String[] args) {
		List<String> list = asList("one", "two"); // no Arrays.
} }
```
Let's take a look at a tricky example:

```
1: import static java.util.Arrays; // DOES NOT COMPILE
2: import static java.util.Arrays.asList;
3: static import java.util.Arrays.*; // DOES NOT COMPILE

4: public class BadStaticImports {
5: 	public static void main(String[] args) {
6: 		Arrays.asList("one"); // DOES NOT COMPILE
7: } }
```

Line 1 tries to use a static import to import a class. Remember that static imports are
only for importing static members. Regular imports are for importing a class. Line 3 tries
to see if you are paying attention to the order of keywords. The syntax is import static
and not vice versa. Line 6 is sneaky. We imported the asList method on line 2. However,
we did not import the Arrays class anywhere. This makes it okay to write asList("one");
but not Arrays.asList("one");.

```
import static statics.A.TYPE;
import static statics.B.TYPE; // DOES NOT COMPILE
```

## Passing Data Among Methods

Java is a pass by value language. This means that a copy of the variable is made and the method receives that copy. Assignments made in the method do not affect the caller.

```
2: public static void main(String[] args) {
3: 	int num = 4;
4: 	newNumber(5);
5: 	System.out.println(num); // 4
6: 	}
7: 	public static void newNumber(int num) {
8: 	num = 8;
9: 	}
```

Lets try an example with reference type.

```
public static void main(String[] args) {
String name = "Webby";
speak(name);
System.out.println(name);
}
public static void speak(String name) {
name = "Sparky";
}
```

It'll again print as Webby.

```
public static void main(String[] args) {
StringBuilder name = new StringBuilder();
speak(name);
System.out.println(name); // Webby
}
public static void speak(StringBuilder s) {
s.append("Webby");
}
```

In this case, output is Webby because the method merely calls a method on the parameter. It doesn't reassign name to a different object.

Let's take a look at this example:

```
1: public class ReturningValues {
2: 	public static void main(String[] args) {
3: 	int number = 1; // 1
4: 	String letters = "abc"; // abc
5: 	number(number); // 1
6: 	letters = letters(letters); // abcd
7: 	System.out.println(number + letters); // 1abcd
8: }
9: 	public static int number(int number) {
10: 		number++;
11: 		return number;
12: 	}
13: public static String letters(String letters) {
14: 		letters += "d";
15: 		return letters;
16: 	}
17: }
```
Line 5 doesn't return anything so it is quite tricky. On the other hand line 6 reassings it so it becomes abcd. 


## Overloading Methods

Method overloading occurs when there are different method signatures with the same name but different type  parameters. We have been calling overloaded methods for a while. System.out.println and StringBuilder’s append methods provide many overloaded versions so you can pass just
about anything to them without having to think about it. 

Some examples for method overloading:

```
public void fly(int numMiles) { }
public void fly(short numFeet) { }
public boolean fly() { return false; }
void fly(int numMiles, short numFeet) { }
public void fly(short numFeet, int numMiles) throws Exception { }
```

We can also see these tricky examples:

```
public void fly(int numMiles) { }
public int fly(int numMiles) { } // DOES NOT COMPILE
```

```
public void fly(int numMiles) { }
public static void fly(int numMiles) { } // DOES NOT COMPILE
```

## Overloading and Varargs

```
public void fly(int[] lengths) { }
public void fly(int... lengths) { } // DOES NOT COMPILE
```
Trick question! Remember that Java treats varargs as if they were an array. This means
that the method signature is the same for both methods. Since we are not allowed to overload
methods with the same parameter list, this code doesn't compile. Even though the code
doesn't look the same, it compiles to the same parameter list.

We can make this work by this way though:

```
fly(new int[] { 1, 2, 3 });
```

However, you can only call the varargs version with stand-alone parameters:

```
fly(1, 2, 3);
```

## Autoboxing

IN the previous chapter, we saw how java will convert a primitive int to an object Integer to add it to an ArrayList though the wonders of autoboxing. This works for us too.

```
public void fly(Integer numMiles) { }
```

This means calling fly(3); will call the previous method as expected. However, what
happens if we have both a primitive and an integer version?

```
public void fly(int numMiles) { }
public void fly(Integer numMiles) { }
```
Java will match the int numMiles version. Java tries to use the most specifi c parameter
list it can fi nd. When the primitive int version isn't present, it will autobox. However, when
the primitive int version is provided, there is no reason for Java to do the extra work of
autoboxing.