# Core Java APIs

## Creating and Manipulating Strings

String name = "Fluffy;
String name =  new String("Fluffy");

## Concatenation 

Placing one String before the other String and combining them together is called string concatenation. 

Three rules about concatenations:

1) If both operands are numeric, + means numeric addition.

2) If either operand is String , ü means concatenation.

3) The expression is evaluated left to right.

Let's take a look at some examples:

```
System.out.println(1 + 2); // 3
System.out.println("a" + "b"); // ab
System.out.println("a" + "b" + 3); // ab3
System.out.println(1 + 2 + "c"); // 3c
```

What would be the output of the following code?

```
int three = 3;
String four = "4";
System.out.println(1 + 2 + three + four);
```

The answer would be "64".

## Immutability

Once a String object is created, it is not allowed to change. It cannot be made larger or smaller, and you cannot change one of the characters inside it.

Mutable is another word for changeable. Immutable is the opposite an object that can't be changed once it's created. We need to know that String is immutable.

