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

<b>reverse()</b>

This method does just what it sounds like, reversing the characters in the sequences and returns a reference to the current StringBuilder. The method signature is as follows:

StrinbBuilder reverse()

```
StringBuilder sb = new StringBuilder("ABC");
sb.reverse();
System.out.println(sb); //prints CBA
```
<b>toString()</b>

This method converts a StringBuilder into a String. 

```
String s = sb.toString();
```

## StringBuilder vs StringBuffer

When writing new code that concatenates a lot of String objects  together, we should use StringBuilder. StringBuilder was added to Java in Java 5. If we come across older code, we will see Stringbuffer used for this purpose. it does the same thing but more slowly because it is thread safe.

## Understanding Equality

```
StringBuilder one = new StringBuilder();
StringBuilder two = new StringBuilder();
StringBuilder three = one.append("a");
System.out.println(one == two); //false
System.out.println(one == three); // true
```

Another confusing example:

```
String x = "Hello World";
String y = "Hello World";
System.out.println(x==y); //true
```

We see that Strings are immutable and literals are pooled. The JVM created only one literal in memory. x and y both point to the same location in memory;therefore, the statement outputs true.

```
String x = "Hello World";
String y = "Hello World".trim();
System.out.println(x==y); //false
```
A bit more confusing example: 

```
String x = new String("Hello World");
String y = "Hello World";
System.out.println(x==y); //false
```

Another example:

```
String x = "Hello World;
String y = "Hello World".trim();
System.out.println(x.equals(z)); //true
```

Example with objects:

```
Tiger t1 = new Tiger();
tiger t2 = new Tiget();
Tiger t3 = t1;
System.out.println(t1==t1); // true
System.out.println(t1==t2); // false
System.out.println(t1.equals(t2)); // false 
```

## Understanding Java Arrays 

an array is an area of memory on the heap with space for a designated number of elements. A String is implemented as an array with some methods that you might want to use when dealing with characters specifically. A StringBuilder is implemented as an array where the array object is replaced with a new bigger array object when it runs out of space to store all the characters. A big difference is that an array can be of any other Java type. 

```
char[] letters;
```

## Creating an Array of Primitives
The most common way to create an array looks like this:

```
int[] numbers1 = new int[3];
```

Another way of creating an array:

```
int[] numbers2 = new int[]{42,55,99};
```

Also, all the following declerations are valid:

```
int[] numAnimals;
int [] numAnimals2;
int numAnimals3[];
int numAnimals4 [];
```

Let's look at this example:

```
String [] bugs = { "cricket", "beetle", "ladybug" };
String [] alias = bugs;
System.out.println(bugs.equals(alias)); // true
System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0
```

These operations can be done with arrays too:

```
String[] strings = { "stringValue" };
Object[] objects = strings;
String[] againStrings = (String[]) objects;
againStrings[0] = new StringBuilder();
objects[0] = new StringBuilder();
```

## Using an Array

Simple example with array:

```
String[] mammals = {"monkey", "chimp", "donkey"};
System.out.println(mammals.length);  //3
System.out.println(mammals[0]);		// monkey
System.out.println(mammals[1]);     // chimp
System.out.println(mammals[2]);		// donkey
```

## Sorting

Java makes it easy to sort on array by providing a sort method, a bunch of sort methods.

```
int[] numbers = { 6, 9, 1 };
Arrays.sort(numbers);
for (int i = 0; i < numbers.length; i++)
L System.out.print (numbers[i] + " "); // 1 6 9
```
 However, in this example things get tricky:
 
 ```
String[] strings = { "10", "9", "100" };
Arrays.sort(strings);
for (String string : strings)
System.out.print(string + " ");  // 10 100 9 because it sorts alphabetically
```

## Searching

Java also provides a convenient way to search-- but only if the array is already sorted.

Binary Search Rules:

Target element found in sorted array --> index of match

Target element not found in sorted array --> Negative value showing one smaller than the negative of index, where a match needs to be inserted to preserve sorted order.

Unsorted array --> A suprise- this result isn't predictable.

Example case:

 ```
int[] numbers = {2,4,6,8};
System.out.println(Arrays.binarySearch(numbers, 2)); // 0
System.out.println(Arrays.binarySearch(numbers, 4)); // 1
System.out.println(Arrays.binarySearch(numbers, 1)); // -1
System.out.println(Arrays.binarySearch(numbers, 3)); // -2
System.out.println(Arrays.binarySearch(numbers, 9)); // -5

```

What will be the output of the following example?

 ```
int numbers = new int[] {3,2,1};
System.out.println(Arrays.binarySearch(numbers, 2));
System.out.println(Arrays.binarySearch(numbers, 3));
```

The array isn't sorted. This means the output will not be predictable. 

## Varargs

When creating an array ourselves, it looks like what we have seen thus far. When one is passed to our method, there is another way it can look.

 ```
public static void main(String[] args)
public static void main(String args[])
public static void main(String... args) // varargs
```

## Multidimensional Arrays

## Creating a Multidimensional Array

 ```
int[][] vars1; // 2D array
int vars2 [][]; // 2D array
int[] vars3[]; // 2D array
int[] vars4 [], space [][]; // a 2D AND a 3D arrays
```
Array called space is a 3D array because it also gets one dimension from int keyword!.

## ArrayLists

ArrayList has many methods , but you only need to know a handful of them, even fewer than you did for String and StringBuilder.
We should also know that ArrayList implements toString() so that we can see the contents just by printing it.

<b>add()</b>

The add method  inserts a new value in the ArrayList. The method signatures are as follows.

boolean add(E element)

void add(int index, E element)

 ```
ArrayList list = new ArrayList();
list.add("hawk"); // [hawk]
list.add(Boolean.TRUE); // [hawk, true]
System.out.println(list); // [hawk, true]
```

ArrayList type should be defined beforehands.

 ```
ArrayList<String> safer = new ArrayList<>();
safer.add("sparrow");
safer.add(Boolean.TRUE); // DOES NOT COMPILE
```

You can also add an element based on desired position:

 ```
4: List<String> birds = new ArrayList<>();
5: birds.add("hawk"); // [hawk]
6: birds.add(1, "robin"); // [hawk, robin]
7: birds.add(0, "blue jay"); // [blue jay, hawk, robin]
8: birds.add(1, "cardinal"); // [blue jay, cardinal, hawk, robin]
9: System.out.println(birds); // [blue jay, cardinal, hawk, robin]
```

<b>remove()</b>

The method removes the first matching value in the ArrayList or remove the element at a specified index. The method signatures are as follows:

boolean remove ( Object object )
E remove (index)

 ```
3: List<String> birds = new ArrayList<>();
4: birds.add("hawk"); // [hawk]
5: birds.add("hawk"); // [hawk, hawk]
6: System.out.println(birds.remove("cardinal")); // prints false
7: System.out.println(birds.remove("hawk")); // prints true
8: System.out.println(birds.remove(0)); // prints hawk
9: System.out.println(birds); // []
```

<b>set()</b>

The set method changes one of the elements of the ArrayList without changing the size. The method signature is as follows:

E set(int index, E newElement)

The E return type is the element that got replaced.

 ```
15: List<String> birds = new ArrayList<>();
16: birds.add("hawk"); // [hawk]
17: System.out.println(birds.size()); // 1
18: birds.set(0, "robin"); // [robin]
19: System.out.println(birds.size()); // 1
20: birds.set(1, "robin"); // IndexOutOfBoundsException
```

<b>isEmpty() and size()</b>

The isEmpty() and size() methods look at how many of the slots are in use. The method signatures are as follows:

boolean isEmpty()

int size()

 ```
System.out.println(birds.isEmpty()); // true
System.out.println(birds.size()); // 0
birds.add("hawk"); // [hawk]
birds.add("hawk"); // [hawk, hawk]
System.out.println(birds.isEmpty()); // false
System.out.println(birds.size()); // 2
```

<b>clear()</b>

The clear method provides an easy way to discard all elements of the ArrayList.The method signature is as follows: 

void clean()

The following shows how to use this method:

 ```
List<String> birds = new ArrayList<>();
birds.add("hawk"); // [hawk]
birds.add("hawk"); // [hawk, hawk]
System.out.println(birds.isEmpty()); // false
System.out.println(birds.size()); // 2
birds.clear(); // []
System.out.println(birds.isEmpty()); // true
System.out.println(birds.size()); // 0
```

<b>contains()</b>

the method checks whether a certain value is in the ArrayList. The method signature is as follows. 

boolean contains ( Object object)

The following shows how to use this method:

 ```
List<String> birds = new ArrayList<>();
birds.add("hawk"); // [hawk]
System.out.println(birds.contains("hawk")); // true
System.out.println(birds.contains("robin")); // false
```

<b>equals()</b>

Finally ArrayList has a custom implementation of equals() so you can comapre two lists to see if they contain the same elements in the same order.

boolean equals(Objects object)

 ```
31: List<String> one = new ArrayList<>();
32: List<String> two = new ArrayList<>();
33: System.out.println(one.equals(two)); // true
34: one.add("a"); // [a]
35: System.out.println(one.equals(two)); // false
36: two.add("a"); // [a]
37: System.out.println(one.equals(two)); // true
38: one.add("b"); // [a,b]
39: two.add(0, "b"); // [b,a]
40: System.out.println(one.equals(two)); // false
```

## Wrapper Classes

The wrapper classes also have a method that converts back to a primitive. We don't need to know much about the constructors or intValue() type methods for the exam because auto-boxing has removed the need for them. You might encounter this syntax on questions that have been on the exam for many years. 

There are also methods for converting a String to a primitive or wrapper class. The pase methods, such as parseInt(), return a primitive, and the valueOf() method returns a wrapper class. This is easy to remember because the name of the returne prmitive is in the methdo name. For example: 

 ```
int primitive = Integer.parseInt("123");
Integer wrapper = Integer.valueOf("123");
```

The first line converts a String to an int primitive. The second converts a String to an Integer wrapper class. If the String passed in is not valid for the given type, Java throws an exception. In these examples, letters and dots are not valid for an integer value:

 ```
int bad1 = Integer.parseInt("a"); // throws NumberFormatException
Integer bad2 = Integer.valueOf("123.45"); // throws NumberFormatException
```

## Autoboxing

We can just type the primitive value and Java will convert it to the relevant wrapper class for us. This is called autoboxing. 

 ```
4: List<Double> weights = new ArrayList<>();
5: weights.add(50.5); // [50.5]
6: weights.add(new Double(60)); // [50.5, 60.0]
7: weights.remove(50.5); // [60.0]
8: double first = weights.get(0); // 60.0
```

What would be the output of the following code?

 ```
List<Integer> numbers = new ArrayList<>();
numbers.add(1);
numbers.add(2);
numbers.remove(1);
System.out.println(numbers);
```

It actually outputs 1. 


## converting Between Array and List

 ```
3: List<String> list = new ArrayList<>();
4: list.add("hawk");
5: list.add("robin");
6: Object[] objectArray = list.toArray();
7: System.out.println(objectArray.length); // 2
8: String[] stringArray = list.toArray(new String[0]);
9: System.out.println(stringArray.length); // 2
```

And here is an example about how to change an Array to List:

 ```
20: String[] array = { "hawk", "robin" }; // [hawk, robin]
21: List<String> list = Arrays.asList(array); // returns fixed size list
22: System.out.println(list.size()); // 2
23: list.set(1, "test"); // [hawk, test]
24: array[0] = "new"; // [new, test]
25: for (String b : array) System.out.print(b + " "); // new test
26: list.remove(1); // throws UnsupportedOperation Exception
```

## Dates and Times

## Creating Dates and Times


<b>LocalDate</b>

Contains just a date -- no time and no time zone . A good example of LocalDate is our birthday this year. It is our birthday for a full day regardless of what time it is.

<b>LocalTime</b>

Contains just a time -- no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.

<b>LocalDateTime</b>

Contains both a date and time but no time zone. A good example of LocalDateTime is the stroke of midnight on New Year's. Midnight on January 2 isn't nearly as special, and clearly an hour after midnight isn't as special either.

 ```
System.out.println(LocalDate.now());  // 2015.01.20
System.out.println(LocalTime.now());  // 12:45:18.401
System.out.println(LocalDateTime.now()); // 2015-01--20T12:45:18.401

```

Both of these examples create the same date:

 ```
LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
LocalDate date2 = LocalDate.of(2015, 1, 20);
```

Examples with LocalTime:

 ```
LocalTime time1 = LocalTime.of(6, 15); // hour and minute
LocalTime time2 = LocalTime.of(6, 15, 30); // + seconds
LocalTime time3 = LocalTime.of(6, 15, 30, 200); // + nanoseconds
```

Then we can combine dates and times:

 ```
LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
LocalDateTime dateTime2 = LocalDateTime.of(date1, time1);
```

In exam it might be tricky to distinguish this:

 ```
LocalDate d = new LocalDate(); // DOES NOT COMPILE
```

Or if we go out of the boundaries:

 ```
LocalDate.of(2015, Month.JANUARY, 32) // throws DateTimeException
```

## Manipulating Dates and Times

 ```
12: LocalDate date = LocalDate.of(2014, Month.JANUARY, 20);
13: System.out.println(date); // 2014-01-20
14: date = date.plusDays(2);
15: System.out.println(date); // 2014-01-22
16: date = date.plusWeeks(1);
17: System.out.println(date); // 2014-01-29
18: date = date.plusMonths(1);
19: System.out.println(date); // 2014-02-28
20: date = date.plusYears(5);
21: System.out.println(date); // 2019-02-28
```

This time, lets work with LocalDateTime:

 ```
22: LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
23: LocalTime time = LocalTime.of(5, 15);
24: LocalDateTime dateTime = LocalDateTime.of(date, time);
25: System.out.println(dateTime); // 2020-01-20T05:15
26: dateTime = dateTime.minusDays(1);
27: System.out.println(dateTime); // 2020-01-19T05:15
28: dateTime = dateTime.minusHours(10);
29: System.out.println(dateTime); // 2020-01-18T19:15
30: dateTime = dateTime.minusSeconds(30);
31: System.out.println(dateTime); // 2020-01-18T19:14:30
```

This can also be written as:

 ```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
LocalTime time = LocalTime.of(5, 15);
LocalDateTime dateTime = LocalDateTime.of(date2, time)
.minusDays(1).minusHours(10).minusSeconds(30);
```

What would be the output of the following code?

 ```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date.plusDays(10);
System.out.println(date);
```

It prints January 20, 2020. Adding 10 days was useless because we ignored the result. Whenever we see immutable types, we gotta pay attention to make sure the return value of a method call isn't ignored.

Also here:

 ```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
date = date.plusMinutes(1); // DOES NOT COMPILE
```

## Working with Periods:

Let's imagine, our zoo performs animal enrichment activities to give the animals something fun to do. The head zookeeper has decided to switch toys every month. This system will continue for three months to see how it works out. 

 ```
public static void main(String[] args) {
	LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
	LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
	performAnimalEnrichment(start, end);
}

private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
	LocalDate upTo = start;
	while (upTo.isBefore(end)) { // check if still before end
	System.out.println("give new toy: " + upTo);
	upTo = upTo.plusMonths(1); // add a month
}}
```

We should shorten this by using java periods

 ```
public static void main(String[] args) {
	LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
	LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
	Period period = Period.ofMonths(1); // create a period
	performAnimalEnrichment(start, end, period);
}
private static void performAnimalEnrichment(LocalDate start, LocalDate end,
	Period period) { // uses the generic period
	LocalDate upTo = start;
	while (upTo.isBefore(end)) {
	System.out.println("give new toy: " + upTo);
	upTo = upTo.plus(period); // adds the period
}}
```

There are different ways to instantiate period class:

 ```
Period annually = Period.ofYears(1); // every 1 year
Period quarterly = Period.ofMonths(3); // every 3 months
Period everyThreeWeeks = Period.ofWeeks(3); // every 3 weeks
Period everyOtherDay = Period.ofDays(2); // every 2 days
Period everyYearAndAWeek = Period.of(1, 0, 7); // every year and 7 days
```

Let's see what objects can be used with period class:

 ```
3: LocalDate date = LocalDate.of(2015, 1, 20);
4: LocalTime time = LocalTime.of(6, 15);
5: LocalDateTime dateTime = LocalDateTime.of(date, time);
6: Period period = Period.ofMonths(1);
7: System.out.println(date.plus(period)); // 2015-02-20
8: System.out.println(dateTime.plus(period)); // 2015-02-20T06:15
9: System.out.println(time.plus(period)); // UnsupportedTemporalTypeException
```
## Formatting Dates and Times

The date and time class support many methods to get data out of them.

 ```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
System.out.println(date.getDayOfWeek()); // MONDAY
System.out.println(date.getMonth()); // JANUARY
System.out.println(date.getYear()); // 2020
System.out.println(date.getDayOfYear()); // 20
```

We could use DatatimeFormatter to change the format of the data.

 ```
LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
LocalTime time = LocalTime.of(11, 12, 34);
LocalDateTime dateTime = LocalDateTime.of(date, time);System.out.println(date
.format(DateTimeFormatter.ISO_LOCAL_DATE));
System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));
System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
```

Alternatively, we can create our own format:

 ```
 DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");
System.out.println(dateTime.format(f)); // January 20, 2020, 11:12
```