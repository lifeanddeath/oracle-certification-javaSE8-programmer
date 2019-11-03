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

## The String Pool

The string pool, also known as the intern pool, is a location in the java virtual machine that collects all these strings.

The string pool contains literal values that appear in your program. For example, "name" is a literal and therefore goes into the string pool. myObject.toString() is a string but not a literal, so it does not go into the string pool. Strings not in the string pool are garbage collected just like any other object.

String name = "Fluffy";

String name = new String("Fluffy");

The former says to use the string pool normally. The second says “No, JVM. I really
don’t want you to use the string pool. Please create a new object for me even though it is
less efficient.” When you write programs, you wouldn’t want to do this. For the exam, you
need to know that it is allowed.

## Important String Methods

<b>length()</b>

The method returns the number of characters in the String

```
String string = "animals";
System.out.println(string.length()); // 7
```

<b>charAt()</b>

The method lets you query the string to find out what character is at a specific index.

```
String string = "animals";
System.out.println(string.charAt(0)); //a
System.out.println(string.charAt(6)); // s
System.out.println(string.charAt(7)); // throws exception
```
<b>indexOf()</b>

The method looks at the characters in the string and finds the first index that matches the desired value. It can work with an individual character or a whole String as input.It can also  start from a requested poisition. The method signatures are as follows:

1) int indexOf(char ch)

2) int indexOf(char ch, index fromIndex)

3) int indexOf(String str)

4)int indexOf(String str, index from Index)

```
String string = "animals";
System.out.println(string.indexOf('a'); //0
System.out.println(string.indexOf("al"); // 4
System.out.println(string.indexOf('a',4); // 4
System.out.println(string.indexOf("al",5); // -1
```

When a match is not found it returns -1.

<b>substring()</b>

The method also looks for  characters in a string. It returns parts of the string. The first parameter is the index to start with for the returned string. As usual, this is a zero-based index. There is an optional second parameter, which is the end index you want to stop at. 




