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


