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

## Using StringBuilder Class

A small program can create a lot of String objects very quickly. For example, how many would we have in the following code?


```
String alpha = "";
for (chat current = 'a'; current <= 'z'; current++) {
	alpha += current;
}

System.out.println(alpha);
```

This method creates 26 iterations and 26 interim objects that are eligible for garbage collection making it very inefficient.

To prevent this, we could use StringBuilder class.

```
StringBuilder alpha = new StringBuilder();
for (chat current = 'a'; current <= 'z'; current++) {
	alpha.append(current);
}
System.out.println(alpha);
```

## Mutability and Chaining 

```
StringBuilder sb = new StringBuilder("start");
sb.append("+middle");  						 // sb  = "start+middle"
StringBuilder same = sb.append("+end");				// "start+middle+end"
```

In the following code:

```
StringBuilder a = new StringBuilder("abc");
StringBuilder b = a.append("de");
b = b.append("f").append("g");
System.out.println("a=" + a);
System.out.println("b=" + b);
```

both of the outputs will be "abcdefg", because there is only one StrinbBuilder object is created in line 1. Then stringbuilder b simply refers to the same object.

There are officially three ways to construct a StringBuilder:

```
StringBuilder sb1 = new StrinBuilder();
StringBuilder sb2 = new StringBuilder("animal");
StringBuilder sb3 = new StringBuilder(10); // this specifies the capacity not the size!
```

## Important StringBuilder Methods

As with String, we aren't going to cover every single method in the StringBuilder class. 

<b>charAt(), indexOf(), length(), substring()</b>

These four methods work exactly the same as in the String class. 

```
StringBuilder sb = new StringBuilder("animals");
String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));
int len = sb.length();
char ch = sb.charAt(6);
System.out.println(sub + " " + len + " " + ch);  //prints anim 7 s

```

<b>append()</b>

The append method is bay far the most frequently used method in StringBuilder. In fact, it is so frequently used that we just started using it without comment.

Examples:

```
StringBuilder sb =  new StringBuilder().append(1).append('c');
sb.append("-").append(true);
System.out.println(sb); // 1c-true

```

<b>insert()</b>

The insert() method adds characters to the StringBuilder at the requested index and returns a reference to the current StringBuilder. Just like append(),there are lots of method signatures for different types.

```
StringBuilder sb = new StringBuilder("animals);
sb.insert(7, "-");    // sb = animals-
sb.insert(0, "-");	// sb = -animals-
sb.insert(4, "-");	// sb = -ani-mals
system.out.println(sb);
```

<b>delete() and deleteCharAt()</b>

```
StringBuilder sb = new StringBuilder("abcdef");
sb.delete(1,3);   // sb = adef
sb.deleteCharAt(5) //throws an exception
```
