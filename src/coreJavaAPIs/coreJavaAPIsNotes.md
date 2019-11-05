# Core Java APIs

## Creating and Manipulating Strings

String name = "Fluffy;
String name =  new String("Fluffy");

## Concatenation 

Placing one String before the other String and combining them together is called string concatenation. 

Three rules about concatenations:

1) If both operands are numeric, + means numeric addition.

2) If either operand is String , + means concatenation.

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
don't want you to use the string pool. Please create a new object for me even though it is
less efficient.When you write programs, you wouldn't want to do this. For the exam, you
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

```
int substring(int beginIndex)
int substring(int beginIndex, int endIndex)

```

```
String string = "animals";
System.out.println(string.substring(3)); // mals
System.out.println(string.substring(string.indexOf('m'))); // mals
System.out.println(string.substring(3, 4)); // m
System.out.println(string.substring(3, 7)); // mals
```


```
System.out.println(string.substring(3, 3)); // empty string
System.out.println(string.substring(3, 2)); // throws exception
System.out.println(string.substring(3, 8)); // throws exception
```
<b>toLowerCase() and toUpperCase()</b>

The method signatures are as follows:

String toLowerCase(String str)

String toUpperCase(STring str)

```
String string = "animals";
System.out.println(string.toUpperCase()); // ANIMALS
System.out.println("Abc133".toLowerCase()); // abc133

```

<b>startsWith() and endsWith()</b>

The methods look at whether the provided value matches part of the String. The method signatures are as follows:

boolean startsWith(String prefix)

boolean endsWith(String suffix)

```
System.out.println("abc".startsWith("a")); // true
System.out.println("abc".startsWith("A")); // false
System.out.println("abc".endsWith("c")); // true
System.out.println("abc".endsWith("a")); // false
```

<b>contains()</b>

The method also looks for matches in the String. It isn't as particular as StartsWith() and endsWith()- the match can be anywhere in the String. The method signature is as follows 

boolean contains(String str)

```
System.out.println("abc".contains("b")); // true
System.out.println("abc".contains("B")); // false

```

<b>replace()</b>

The method does a simple search and replace on the string. There's a version that takes char paramters as well as a version that takes CharSequence parameters. A charsequence is a general way of representing several classes, including String and StringBuilder- It's called an interface.

```
System.out.println("abcabc".replace('a', 'A')); // AbcAbc
System.out.println("abcabc".replace("a", "A")); // AbcAbc

```

<b>trim()</b>

This method removes whitespace from the beginning and end of a String. Whitespace consists of spaces along with the \t (tab) and
\n (newline) characters. Other characters, such as \r (carriage return), are also included in
what gets trimmed

```
System.out.println("abc".trim()); // abc
System.out.println("\t a b c\n".trim()); // a b c

```

## Method Chaining

It is common to call multiple methods on the same String, as shown here:

```
String start = "AnimaL   ";
String trimmed = start.trim();
String lowercase = trimmed.toLowerCase(); // "animal"
String result = lowercase.replace('a', 'A'); // "Animal"
System.out.println(result);

```

this code is equivalent to:

```
String result = "AniMaL ".trim().toLowerCase().replace('a', 'A');
System.out.println(result);
```

