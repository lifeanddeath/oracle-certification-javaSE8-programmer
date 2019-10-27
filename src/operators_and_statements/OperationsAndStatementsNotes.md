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
- Smaller data types, namely byte, short, char, are first promoted to  int any time they're used with a Java binary arithmetic operator, even if neither of the operans is int.
- After all promotion has occurred and the operands have the same data type, the resulting value will have the same data type as its promoted operands.

