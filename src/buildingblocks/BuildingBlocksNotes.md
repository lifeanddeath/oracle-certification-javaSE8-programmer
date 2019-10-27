# Understanding the Java Class Structure

* Java classes have two primary elements: methods and fields(generally known as variables).

* These two are usually known as members of the class.

* There are three different types of comments 
	
	// comment until end of line
	
	/*
	*  Multiple line comment
	*/
	
	/**
	* Javadoc multiple line comments.
	*
	*/
	
* Related set of classes are held in the containers called "Packages".
	
* Every class in java.lang package is considered to be automatically imported.

* In the exam, if a code snippet starts with line 1 number and has no package declaration, don't get fooled.

# Constructors

* Main purpose -> initialize a class.

* '{' -> are called instance initializers.

* instance initializers are run with priority in the class when they are called.

* When a new object is created, the object sets its variables and and runs the instance initializers.

* variable value can't be read if not initialized at the time of compilation, it'll cause compilation error.

* class constuctor is called after instance initializers and variables are set.

# Distinguishing Between Object References and Primitives 

* Java applications contain two data types-> 1) Primitive types 2) Reference types

## Primitive Types

* Java has 8 built-in data types, so called Java primitive types.

-boolean ( true or false)
-byte    (8 bit integral value)
-short(16 bit integral value)
-int ( 32 bit integral value)
-long (64 bit integral value)
-float(32 bit floating point value)
-double(64 bit floating point value)
-char(16 bit unicode value)

* when defining a long number , use the l postfix. 
For example = long max = 332420930392L;


 ``` 
int numGrains = 5.6; // wouldn't compile
```

* When you deal with numbers you can alway use underscores to increase readability.

underscores can be used anywhere but the beginning and the end of the literal in addition to before and after a decimal point sign.

Examples: 

double notAtStart = _1000.000 --> doesn't compile
double notAtEnd = 1000.00_;   --> doesn't compile
double notByDecimal =  10_.0 ---> doenst't compile
double annoyingButLegal = 1_00_00.0_0; --> annoying but compiles.


## Reference Types

Unlike the primitive types that hold their values in the memory where the vaiable is allocated, references hold the value of the object they refer to.Instead, a refernce *points* to an object by storing the memory address where the object is stored.

Java doesnt allow us to learn the physical memory address.

* primitive types can't be assigned null, whereas reference types can be.

* primitive types don't have methods, and can't be assigned using methods hence.

* you can't declare different multiple variables with different data types. like string and int in the same line.

* even if two variable would be in the same type, it wouldn't be legal
double  b1, double b2; // wouldn't compile.

* two different variables can only be in the same line when there is a semicolon in between.

* variables can't be bigger than their assigned types.

Example:

```
int amount = 9L; // not OK
long max = 234235353; // also not ok
long max = 389345798435L; // now java knows it is a long.
```

* Octal(digits 0-7), which uses the number 0 as a prefix -- for example 017
* Hexadecimal(0-9 and letters A-F), which uses the number 0 followed by x or X as a prefix - for example, 0xFF
* binary(0-1), which uses the number 0 followed by b or B as aprefix - for example 0b10

Examples

	- System.out.println(56) // 56
	- System.out.println(0b11) //3
	- System.out.println(017) //15
	- System.out.println(0x1F) //31

# Identifiers

* The name should begin with a letter or symbol $ or _.
* The name can also contain numbers.
* Usage of reserved keywords are not allowed.

* Legal name examples
- okidentifier
- $OK2Identifier
- _alsoOK1d3ntifier
- __SStillOkbutKnotsonice$

* Not legal examples:

- 3DPointclass -> identifiers cannot start with numbers
- hollywood@vine -> @ is not a letter, digit or $
- *$coffee -> * is not a letter, digit or $ or _
- public public is a reserved keyword.

# Initialization of Variables

## Local Variables

Local variables must be initialized before use. They do not have a default value and contain garbage data until initialized.

## Instance and Class Variables 

If a variable has a static keyword in its declaration, it means it is  class variable.

# Understanding Variable Scope

public void eat(int piecesOfCheese) {
	int bitesOfCheese = 1;
}

In this example, there are two local variables. parameter methods are also considered as local parameters.
*Local variables can never have a scope larger than the method they are defined in. However .they can have a smaller scope.Consider this example:


*Class variables are the static variables whereas instance variables are defined inside the class like regular variables.

* Package keyword should be on top of the java file, whereas imports are not mandatory.

* Multiple classes can be defined in the same file, but only one of them is allowed to be public.

* A file is also allowed to have neither class be public. As long as there isn't more than one public class in a file, it is okey.

# Destroying Objects

* Java provides  a garbage collector to automactically look for objects that aren't needed anymore.

* All java objects are stored in your program memory's heap. The heap, which is also referred to as the free store, represents a large pool of unused memory aollocated to your Java application. The heap may be quite large, depending on your environment, but there is always a limit to its size. if you keep exhausting your heap memory, you'll eventually run out of memory.

# Garbage Collection

* Garbage collection refers to the process of automatically freeing memory on the heap by deleting objects that are no longer reachable in your program. There are  many different algorithms for garbage collection.

* System.gc() is a way to suggest to to JVM  to do this, but it can as well be ignored.

# finalize 

* Java allows objects to impelment a method called finalize() that might get called. This method gets called if the garbage collector tries to collect othe bojet. If the garbage  collector doesn't run, the method doesn't get called. If the garbage collector fails to collect the object and tries to run it again later, the method doesn't get called a second time.

In practice, this mean you are highly unlikely to use it in real projects. Luckily, there isn't much remember to about this finalize().

# Package Declarations & Imports

* Java puts classes in packages. (but package names are optional in a file system).

Two ways to import classes:

1) Wildcards

2) Direct class import decleration

 Every java class automatically imports java.lang.

Example:

What inputs do we need for the following class?

```
public class InputImports {
	public void read(Files files) {
		Paths.get("name);
	}
}
```

There are two possible answers. The shorter one is to use a wildcard to import both at the same time:

```
import java.nio.file.*;
```

The other answer is to import both classes explicitly:

```
import java.nio.file.Files;
import java.nio.filePaths;
```

Let's consider some imports that wouldn't work:

```
import java.nio.*; // No good - a wildcard only matches  class names, not "file.*FIles"
import java.nio.*.*: // no good - you can only have one wildcard and it must be at the end.
import java.nio.files.Paths.*; No good - you cannot import mehods, only class name
```

When a class is found in multiple packages, Java gives us an compilation error.

# Naming Conflicts with Imports

What imports would we need for the following class?

```
public class Conflicts {
	Date date;
	// some more code
}
```
The answer is <b>import java.util.*;</b> or <b>import java.util.Date;</b>.

Tricky part comes when there are more than two imports are present.

```
import java.util.*;
import java.sql.*; // Does not compile
```

Because the class is found in multiple packages.

```
import java.util.Date;
import java.sql.*;
```

Now it would work, because if you explicitly import a class name, it takes precedence over any wildcards present. Then, Java thinks, "he will use this specific class".

What would be the case with the following imports?

```
import java.util.Date;
import java.sql.Date;
```

If you really really need to use two classes with the same name...

```
import java.util.Date;

public class Conflicts {
	Date date;
	java.sql.Date sqlDate;
}
```

or alternatively,

```
public class Conflicts {
	java.util.Date date;
	java.sql.Date sqlDate;
}
```

# Varargs

In java you can use <b>...</b> to specify a (zero to many) arguments for simplicity.

For example:

```
public class MyClass {
	public static void main(String... args) {
	}
}
```

is a legal definition.

However it should be the last argument of the undertaking function. 

```
void displayValues(int a, int b, int ... values) // OK
void displayValues(int a, int b, int ... values, int ... moreValues) //compilation error.
```

# Java Compiling Files

-  Javac compiles a -java file into a .class file
-  Java takes the name of the class as a parameter // .class is not used.