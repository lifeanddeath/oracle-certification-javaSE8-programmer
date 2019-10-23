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


