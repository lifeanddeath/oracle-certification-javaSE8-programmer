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

## Creating Constuctors

Example: 


```
public class Bunny {
	public Bunny() {
		System.out.println("constructor");
	}
}
```

why one of these these two wouldn't work?

```
public bunny() { } // DOES NOT COMPILE
public void Bunny() { }
}
```

The fi rst one doesn't match the classname because Java is case sensitive. Since it doesn't
match, Java knows it can't be a constructor and is supposed to be a regular method.
However, it is missing the return type and doesn't compile. The second method is a perfectly
good method, but is not a constructor because it has a return type.

## Default Constructor 

Every class in java has a constructor whether you code it or not. If you don't include any constructors in the class, Java will create one for you without any parameters.

This java-created constructor is called the default constructor.Sometimes we call it the default no-arguments constructor for clarity. 

```
public class Rabbit {
public static void main(String[] args) {
Rabbit rabbit = new Rabbit(); // Calls default constructor
}
}
```

We keep saying generated. This happens during the compile step. If you look at the file with the .java extension, the constructor will stil be missing.  It is only in the compiled file with the .class extension it makes an appearance.

Let's take a look at the following example:

```
1: public class RabbitsMultiply {
2: public static void main(String[] args) {
3:	 Rabbit1 r1 = new Rabbit1();
4: 	 Rabbit2 r2 = new Rabbit2();
5:	 Rabbit3 r3 = new Rabbit3(true);
6: 	 Rabbit4 r4 = new Rabbit4(); // DOES NOT COMPILE
7: } }
```

Line 3 calls the generated default no-argument constructor. Lines 4 and 5 call the userprovided
constructors. Line 6 does not compile. Rabbit4 made the constructor private so
that other classes could not call it.
Having a private constructor in a class tells the compiler not to provide a default noargument
constructor. It also prevents other classes from instantiating the class. This is
useful when a class only has static methods or the class wants to control all calls to create
new instances of itself.

## Overloading Constructors

You can have multiple constructors
in the same class as long as they have different method signatures. When overloading methods,
the method name and parameter list needed to match. With constructors, the name is
always the same since it has to be the same as the name of the class. This means constructors
must have different parameters in order to be overloaded.

Example:

```
public class Hamster {
	private String color;
	private int weight;
	public Hamster(int weight) { // first constructor
		this.weight = weight;
		color = "brown";
	}	
	public Hamster(int weight, String color) { // second constructor
		this.weight = weight;
		this.color = color;
	}
}

```

There  is a duplication so we should fix it!

```
public Hamster(int weight) {
Hamster(weight, "brown"); // DOES NOT COMPILE
}
```
This will not work. Constructors can be called only by writing new before the name of the
constructor. They are not like normal methods that you can just call. What happens if we
stick new before the constructor name?

```
public Hamster(int weight) {
new Hamster(weight, "brown"); // Compiles but does not do what we want
}
```

This attempt does compile. It doesn't do what we want, though. When the constructor
with one parameter is called, it creates an object with the default weight and color. It then
constructs a different object with the desired weight and color and ignores the new object.
That's not what we want. We want weight and color set on the object we are trying to
instantiate in the first place.

Java provides a solution: this—yes, the same keyword we used to refer to instance variables.
When this is used as if it were a method, Java calls another constructor on the same
instance of the class.

```
public Hamster(int weight) {
this(weight, "brown");
}
```
```
3: public Hamster(int weight) {
4: System.out.println("in constructor");
5: // ready to call this
6: this(weight, "brown"); // DOES NOT COMPILE
7: }
```

Even though a print statement on line 4 doesn't change any variables, it is still a Java statement
and is not allowed to be inserted before the call to this(). The comment on line 5 is
just fine. Comments don't run Java statements and are allowed anywhere.

## Final Fields

As we saw earlier in the chapter, final instance variables must be assigned a value exactly once.  We saw this happen in the line of the decleration and in an instance initializer. There is one more location this assignment can be done: in the constructor.

```
public class MouseHouse {
	private final int volume;
	private final String name = "The Mouse House";
	
	public MouseHouse(int length, int width, int height) {
		volume = length * width * height;
}}
```

The constructor is part of the initialization process, so it is allowed to assign final
instance variables in it. By the time the constructor completes, all final instance variables
must have been set.

## Order of Initialization

The rules are as follows:

1. If there is a superclass, initialize it first (we’ll cover this rule in the next chapter. For
now, just say “no superclass” and go on to the next rule.)

2. Static variable declarations and static initializers in the order they appear in the file.

3. Instance variable declarations and instance initializers in the order they appear in the file.

4. The constructor.

Let's consider the following example:

```
1: public class InitializationOrderSimple {
2:	 private String name = "Torchie";
3: 	{ System.out.println(name); }
4:	 private static int COUNT = 0;
5: 	static { System.out.println(COUNT); }
6: 	static { COUNT += 10; System.out.println(COUNT); }
7: 	public InitializationOrderSimple() {
8: 		System.out.println("constructor");
9: } }

1: public class CallInitializationOrderSimple {
2: 	public static void main(String[] args) {
3: 		InitializationOrderSimple init = new InitializationOrderSimple();
4: } }
```

The output of the code will be as follows:

0

10

Torchie

constructor

```
1: 	public class InitializationOrder {
2: 		private String name = "Torchie";
3: 		{ System.out.println(name); }
4: 		private static int COUNT = 0;
5: 		static { System.out.println(COUNT); }
6: 		{ COUNT++; System.out.println(COUNT); }

7: 		public InitializationOrder() {
8: 			System.out.println("constructor");
9: 	}
	
10: 	public static void main(String[] args) {
11: 		System.out.println("read to construct");
12: 		new InitializationOrder();
13: 	}
14: }
```

0

read to construct

Torchie

1

constructor

Let's take a look at the hardest example with this topic:

```
1: public class YetMoreInitializationOrder {
2: 	static { add(2); }
3: 	static void add(int num) { System.out.print(num + " "); }
4: 	YetMoreInitializationOrder() { add(5); }
5: 	static { add(4); }
6: 	{ add(6); }
7: 	static { new YetMoreInitializationOrder(); }
8: 	{add(8); }
9: 	public static void main(String[] args) { } }
```

The correct answer is 2 4 6 8 5. Let's walk through why that is. There is no superclass,
so we jump right to rule 2—the statics. There are three static blocks: on lines 2, 5, and 7.
They run in that order. The static block on line 2 calls the add() method, which prints 2.
The static block on line 5 calls the add() method, which prints 4. The last static block,
on line 7, calls new to instantiate the object. This means we can go on to rule 3 to look at
the instance variables and instance initializers. There are two of those: on lines 6 and 8.
They both call the add() method and print 6 and 8, respectively. Finally, we go on to rule 4
and call the constructor, which calls the add() method one more time and prints 5.

## Encapsulating Data

When there is a package private access, that means any class in the package can set the field. WE no longer have control of what gets set in our own class. 

Encapsulation means we set up the class so only methods in the class with the variables can refer to the instance variables. Callers are required to use these methods. Let's take a look at our newly encapsulated Swan Class.

```
1: public class Swan {
2: private int numberEggs; // private
3: public int getNumberEggs() { // getter
4: return numberEggs;
5: }
6: public void setNumberEggs(int numberEggs) { // setter
7: if (numberEggs >= 0) // guard condition
8: this.numberEggs = numberEggs;
9: } }
```
## Createing Immutable Classes

Encapsulating data is helpful because it prevents callers from making uncontrolled changes to your class. Another common technique is making classes immutable so they cannot be
changed at all. Immutable classes are helpful because you know they will always be the same. You can
pass them around your application with a guarantee that the caller didn’t change anything.
This helps make programs easier to maintain. It also helps with performance by limiting
the number of copies, as you saw with String in Chapter 3, “Core Java APIs.”
One step in making a class immutable is to omit the setters. But wait: we still want the
caller to be able to specify the initial value—we just don’t want it to change after the object
is created. Constructors to the rescue!

## Writing Simple Lambdas

A lambda expression
is a block of code that gets passed around. You can think of a lambda expression as an
continued
Writing Simple Lambdas 209
anonymous method. It has parameters and a body just like full-fl edged methods do, but it
doesn’t have a name like a real method. Lambda expressions are often referred to as lambdas
for short. You might also know them as closures if Java isn’t your fi rst language. If you
had a bad experience with closures in the past, don’t worry. They are far simpler in Java.
In other words, a lambda expression is like a method that you can pass as if it were a
variable. For example, there are different ways to calculate age. One human year is equivalent
to seven dog years. You want to write a method that that takes an age() method as
input. To do this in an object-oriented program, you’d need to defi ne a Human subclass and a
Dog subclass. With lambdas, you can just pass in the relevant expression to calculate age.
Lambdas allow you to write powerful code in Java. Only the simplest lambda expressions
are on the OCA exam. The goal is to get you comfortable with the syntax and the
concepts. This means you aren’t truly doing functional programming yet. You’ll see
lambdas again on the OCP exam.
In this section, we’ll cover an example of why lambdas are helpful, the syntax of
lambdas, and how to use predicates.

## Lambda Example

Lets consider some scenario in which we want to achieve a specific task:

Task: Our goal is to print out all the animals in a list according to some criteria. We’ll show you
how to do this without lambdas to illustrate how lambdas are useful. We start out with the
Animal class:

```
public class Animal {
	private String species;
	private boolean canHop;
	private boolean canSwim;
	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}
	public boolean canHop() { return canHop; }
	public boolean canSwim() { return canSwim; }
	public String toString() { return species; }
}
```

We plan to write a lot of different checks, so we want an interface. You’ll learn more
about interfaces in the next chapter. For now, it is enough to remember that an interface
specifies the methods that our class needs to implement:

```
public interface CheckTrait {	
	boolean test(Animal a);
}
```

The first thing we want to check is whether the Animal can hop. We provide
a class that can check this:

```
public class CheckIfHopper implements CheckTrait {
	public boolean test(Animal a) {
		return a.canHop();
	}
}
```

```
1: public class TraditionalSearch {
2: 	public static void main(String[] args) {
3: 	List<Animal> animals = new ArrayList<Animal>(); // list of animals
4: 	animals.add(new Animal("fish", false, true));
5: 	animals.add(new Animal("kangaroo", true, false));
6: 	animals.add(new Animal("rabbit", true, false));
7: 	animals.add(new Animal("turtle", false, true));
8:
9: 	print(animals, new CheckIfHopper()); // pass class that does check
10: }
11: private static void print(List<Animal> animals, CheckTrait checker) {
12: 	for (Animal animal : animals) {
13: 		if (checker.test(animal)) // the general check
14: 			System.out.print(animal + " ");
15: 	}
16: 	System.out.println();
17: 	}
18: }
```
The print() method on line 11 method is very general—it can check for any trait. This
is good design. It shouldn’t need to know what specifi cally we are searching for in order to
print a list of animals.

Now what happens if we want to print the Animals that swim? Sigh. We need to write
another class CheckIfSwims. Granted, it is only a few lines. Then we need to add a new line
under line 9 that instantiates that class. That’s two things just to do another check.
Why can’t we just specify the logic we care about right here? Turns out that we can with
lambda expressions. We could repeat that whole class here and make you fi nd the one line
that changed. Instead, we’ll just show you. We could replace line 9 with the following, which
uses a lambda:

```
9: print(animals, a -> a.canHop());
```

Here’s that other line:

```
print(animals, a -> a.canSwim());
```
How about Animals that cannot swim?

```
print(animals, a -> ! a.canSwim());
```

Deferred execution
means that code is specifi ed now but will run later. In this case, later is when the print()
method calls it.

## Lambda Syntax

One of the simplest lambda expressions you can write is the one you just saw:

```
a -> a.canHop();
```

This means that Java should call a method with an Animal parameter that returns a
boolean value that’s the result of a.canHop(). We know all this because we wrote the code.
But how does Java know?

Java replies on context when figuring out what lambda expressions mean. We are passing
this lambda as the second parameter of the print() method. That method expects a
CheckTrait as the second parameter. Since we are passing a lambda instead, Java tries to
map our lambda to that interface:

```
boolean test(Animal a);
```

Since that interface’s method takes an Animal, that means the lambda parameter has to
be an Animal. And since that interface’s method returns a boolean, we know the lambda
returns a boolean.

The syntax of lambdas is tricky because many parts are optional. These two lines do the
exact same thing:

```
a -> a.canHop()
(Animal a) -> { return a.canHop(); }
```

Let’s look at what is going on here. The first example, shown in Figure 4.5, has
three parts:

■ Specify a single parameter with the name a

■ The arrow operator to separate the parameter and body

■ A body that calls a single method and returns the result of that method

Let’s look at some examples of valid lambdas. Pretend that there are valid interfaces that
can consume a lambda with zero, one, or two String parameters.

```
3: print(() -> true); // 0 parameters
4: print(a -> a.startsWith("test")); // 1 parameter
5: print((String a) -> a.startsWith("test")); // 1 parameter
6: print((a, b) -> a.startsWith("test")); // 2 parameters
7: print((String a, String b) -> a.startsWith("test")); // 2 parameters
```

Notice that all of these examples have parentheses around the parameter list except the
one that takes only one parameter and doesn’t specify the type. Line 3 takes 0 parameters
and always returns the Boolean true. Line 4 takes one parameter and calls a method on
it, returning the result. Line 5 does the same except that it explicitly defi nes the type of the
variable. Lines 6 and 7 take two parameters and ignore one of them—there isn’t a rule that
says you must use all defined parameters.

```
print(a, b -> a.startsWith("test")); // DOES NOT COMPILE
print(a -> { a.startsWith("test"); }); // DOES NOT COMPILE
print(a -> { return a.startsWith("test") }); // DOES NOT COMPILE
```
The fi rst line needs parentheses around the parameter list. Remember that the parentheses
are only optional when there is one parameter and it doesn’t have a type declared. The
second line is missing the return keyword. The last line is missing the semicolon.
You might have noticed all of our lambdas return a boolean. That is because the scope
for the OCA exam limits what you need to learn.

There is one more issue you might see with lambdas. We’ve been defi ning an argument
list in our lambda expressions. Since Java doesn’t allow us to redeclare a local variable, the
following is an issue:

```
(a, b) -> { int a = 0; return 5;} // DOES NOT COMPILE
```

We tried to redeclare a, which is not allowed. By contrast, the following line is okay
because it uses a different variable name:

```
(a, b) -> { int c = 0; return 5;}
```