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