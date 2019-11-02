# Operations and Statements

A java operator is a special symbol that can be applied to a set of variables, values or literals--referred to as operands-- and that returns a result. Three flavors of operators are available in Java:

- Unary
- Binary 
- Ternary

|       Post-unary operators      	| expression++, expresion--                      	|
|:-------------------------------:	|------------------------------------------------	|
|       Pre-unary operators       	| ++expression, --expresion                      	|
|      Other unary operators      	| +, -, !                                        	|
| Multiplication/Division/Modulus 	| *, /, %                                        	|
|      Addition/Substraction      	| +, -                                           	|
|         Shift operators         	| <<, >>, >>>                                    	|
|       Relational operators      	| <, >, <=, >=, instanceof                       	|
|      Equal to/not equal to      	| ==, !=                                         	|
|        Logical operators        	| &, ^,                                          	|
|  Short-circuit logcal operators 	| &&,                                            	|
|        Ternary operators        	| boolean expression ? expression1 : expression2 	|
|       Assignment operators      	| =, +=, -=, ...                                 	|



# Binary Arithmetic Operators

## Arithmetic Operators

Arithmetic operators are often encountered in early mathematics and include addition or subtraction, division and so on.

Arithmetic operators may be applied to any Java primitives, except boolean and String. Furthermore, only the addition operators + and += may be applied to String values, which results in String concatenation.

## Numeric Promotion

Numeric Promotion Rules:

- If two values have different data types, Java will automatically promote one of the values to the larger of the two data types.
- If one of the values is integral and the other is floating-point, Java will automatically promote the integral to the floating-point value's data type.
- Smaller data types, namely byte, short, char, are first promoted to  int any time they're used with a Java binary arithmetic operator, even if neither of the operands is int.
- After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.

What is the data type of x+y?

```
double x = 39.21;
float y  = 2.1;
```

This is actually a trick question, as this code wouldn't compile. Floating point literals are assumed to be double, unless postfixed with a f, as in 2.1f. if the value was set properly to 2.1f,  then the promotion would be similar to the last example, with both operands being promoted to a double,and the result would be a double value.

What is the data type of x / y?

```
short x = 10;
short y = 3;
```

In this case, both of the literals will be applied to rule number three, where they will be promoted to int before the operation, resulting an output of type int.

What is the data type of x*y/z?

```
short x = 14;
float y = 13;
double z = 30;
```

In this case, we must apply all of the rules. First x automatically be promoted to int solely because it is a short and it is being used in an arithmetic operation. The promoted X value will then be automatically promoted to a float so that it can be multiplied with y. The result of x*y will then be automatically promoted to a double, so that it can be divided by z. Result happens to be double.

## Unary Operators 

By definition, unary operators are the ones that require exactly one operand, or variable to function. They often perform simple tasks, such as increasing a numeric variable by one, or negating a boolean value.

| +   | Indicates a number is positive, although numbers are assumed to be positive in java unless accompanied by a negative unary operator  |
|-----|--------------------------------------------------------------------------------------------------------------------------------------|
| -   | Indicates a literal number is negative or negates an expression                                                                      |
|  ++ | Increments a value by 1                                                                                                              |
| --  | Decrements a value by 1                                                                                                              |
| !   | Inverts a Boolean's logical value     


## Increment and Decrement Operators

Increment and decrement operators , ++ and --, respectively, can be applied to numeric operands and have the higher order or precedence, as compared to binary operators.

If the operator is placed before the operand, referred to as the pre-increment operator and the pre-decrement operator, then the operator is applied first and the value return is new value of the expression.Alternatively, if the operator is placed after the operand, referred to as the post-increment operator and the post-decrement operator, the original value of the expression is returned, with operator applied after the value is returned.

```
int counter = 0;
System.out.println(counter); // Outputs 0
System.out.println(++counter); //Outputs 1
System.out.println(counter); // Outputs 1
System.out.println(counter--); // Outputs 1
System.out.println(counter); // Outputs 0
```

How the following code would result?

```
int x = 3;
int y = ++x * 5 / x-- + --x;

System.out.println("x is" +x);
System.out.println("y is" +y);
```

The solution would be as follows:

```
int y = 4*5/ x-- + --x; // x assigned value of 4
```
Next x, is decremented, but the original value of 4 is used in the expression, leading to this;

```
int y = 4*5/4+ --x;
```

The final assignment of x reduces the value to 2, and since this is a pre-increment operator, that value is returned to the expression:

```
int y = 4*5/4+2
```

Finally as a result x = 2 and y = 7.

## Using Additional Binary Operators

```
int x = 1.0; //wouldn't compile
short y = 3204823094; //wouldn't compile
int z = 9f; //woudln't compile
long t = 304983240293842309483029; //wouldn't compile
```

## Casting Primitive Values 

```
int x = (int) 1.0;
short y = (short) 5454543; // stored as 20678
int z = (int)9l;
long t = 324309823094823042L;
```

Interesting example:

```
short x = 10;
short y = 3;
short z = x*y; // wouldn't compile
```

Trying to set a short variable to an int results in a compiler error.

```
short z = (short) x*y;
```
would compile.

```
long x = 10;
int y = 5;
y = y*x; // wouldn't compile because right hand side is in the type of long
```

Note: compound operator which is y*= x would cast thing automatically, and we wouldn't have a compilation error.

Another interesting assignment example:

```
long x = 5;
long y = (x=3); 

System.out.println(x); // outputs 3
System.out.println(y); // also outputs 3
```

They key here is that  (x=3) does two things. First, it sets the value of the variable x to be 3, Second, it returns a value of the  assignment, which is also 3.

## Relational instanceof operator

a instanceof b ---> True if the reference that a points to is an instance of a class, subclass, or class that implements a particular interface, as named in b.

''

## Equality Operations 

1) Comparing two numeric primitive types.If the numeric values are of different data types, the values are automatically promoted as previously described.

5 == 5.0 returns true since the left side is promoted to a double

2) Comparing two boolean values.

3) Comparing two objects, including null and String values.

For the object comparison, the equality operator is applied to the references to the objects, not the objects they point to. Two references are equal if and only if they point to the same object, or both point to null.

```
file x = new File("myFile.txt");
file y = new File("myFile.txt");

File z = x;

System.out.println(x == y); //outputs false
System.out.println(x == z); //outputs true
```

# Java Statements

Java statement is a complete unit of execution in Java, terminated with a semicolon.  

```
int y = 1;
int z = 1;
final int x = y<10 ? y++ : z++;
System.out.println(y+",",+z); // outputs 2,1
```

# Switch Statement

A switch statement is a complex decision-making structure in which a single value is evaluated and flow is redirected to the first matching branch, known as a case statement. If no such case statement is found that matches the value, an optional default statement will be called. If no such default option is available, the entire switch statement will be skipped.

Data types supported by switch statements include the following:

- int and Integer
- byte and Byte
- short and Short
- char and Character
- int and Integer
- String
- enum values

As can be seen, boolean and long values are not supported.

If break keyword is not used after each statement, the flow will be continued.

After each case keyword you should write the data and then colon.

Case statement values should be literal, enum constant, or final constant.

## While Statement

A repetition control structure, which we refer to as a loop, executes a statement of code multiple times in succession. By using non-constant variables, each repetition of statement may be different. For example, a statement that  iterates over a list of uniqeu names and outputs them would encounter a new name on every execution of the loop.

## do-While Statement

The primary difference between the syntactic structure of a do-while loop and a while loop is that a do while loop purposely orders the statement or block of statements before the conditional expression, in order to reinforce that the statement will be executed before the expression is ever evaluated. 

## For Loop

A basic for loop has the same conditional boolean expression and statement, or block of statements, as theother loops you have seen, as well as two new sections: an initialization block and an update statement. 

```
for ( initialization; booleanExpression; updateStatement) {
	/// body
}
```

```
int x = 0;
for ( long  y=0, x=4; x<5 && y<10, x++, y++){
	System.out.print(x+ " ");					// Does not compile because variable y is declared, then x is reassigned.
}
```

This example would compile though.

```
int x = 0;
long y = 10;
for ( y=0, x=4; x<5 && y<10, x++, y++){
	System.out.print(x+ " ");		
}
```

The following example would also not compile because declaring variables should be in the same type.


```
for ( long y=0, int x=4; x<5 && y<10, x++, y++){
	System.out.print(x+ " ");					// Does not compile because y and x are different types.
}
```

## foreach statement

```
for( datatype instance: collection){
	//body
}
```

The for-each loop declaration is composed of an initialization section and an object to be iterated over. The right hand side of the for-each loop statement bust be a built in java array or an object who class implements  java. Iterable, which includes most of the Java Collections framework. The left- hand side of the for-each loop must include a declaration for an instance of a variable, whose type matches the type of a member of the array or collection in the right hand side of the statement.

```
java.util.List<String> values = new java.util.ArrayList<String>();
values.add("Lisa");
values.add("Kevin");
values.add("Alex");

for(String name: values) {
	System.out.println(name);
}
```

The following example wouldn't compile because the right hand side of the loop should be always a list or iterable!

```
String names = "Lisa";

for(String name: names) {
	System.out.println(name); // wouldn't compile
}
```

Because its not an array nor does it implement java.lang.Iterable.


```
int[] values =new int[3];
values[0] = 10;
values[1] = new Integer(5);
values[2] = 15;

for(int i = 1; i<values.length; i++) {
	System.out.println(values[i]- values[i-1]);
}
```

the output result would be -5,10.

## Optional Statements


```
int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
OUTER_LOOP: for(int[] mySimpleArray : myComplexArray) {
	INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++) {
		System.out.print(mySimpleArray[i]+"\t");
	}
	System.out.println();
} 
```

## The break Statement

```
optionalLabel: while(booleanExpression) {
	//body
	
	//somewhere in Loop
	break optionalLabel;
} 
```

## Continue Statement

```
optionalLabel: while(booleanExpression) {
	//body
	
	//somewhere in Loop
	continue optionalLabel;
} 
```

While the break statement transfers control to the enclosing statement, the continue
statement transfers control to the boolean expression that determines if the loop should
continue. In other words, it ends the current iteration of the loop. Also like the break
statement, the continue statement is applied to the nearest inner loop under execution
using optional label statements to override this behavior.




