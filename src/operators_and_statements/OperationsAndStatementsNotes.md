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

What is the data tpye of x*y/z?

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

