## Exceptions

A program can fail for just about any reason. Here are just a few possibilities:

■ The code tries to connect to a website, but the Internet connection is down.

■ You made a coding mistake and tried to access an invalid index in an array.

■ One method calls another with a value that the method doesn’t support.

## Throwing an Exception

Java lets you write statements like these:

```
throw new Exception();

throw new Exception("Ow! I fell.");

throw new RuntimeException();

throw new RuntimeException("Ow! I fell.");

```

## try statement

```
3: void explore() {
4: try {
5: fall();
6: System.out.println("never get here");
7: } catch (RuntimeException e) {
8: getUp();
9: }
10: seeAnimals();
11: }
12: void fall() { throw new RuntimeException(); }
```

First, line 5 calls the fall() method. Line 12 throws an exception. This means Java
jumps straight to the catch block, skipping line 6. The girl gets up on line 8. Now the try
statement is over and execution proceeds normally with line 10.

```
try // DOES NOT COMPILE
fall();
catch (Exception e)
System.out.println("get up");
```

The problem is that the braces are missing. It needs to look like this:

```
try {
fall();
} catch (Exception e) {
System.out.println("get up");
}
```

what about next one?

```
try {// DOES NOT COMPILE
fall();
}
```

This code doesn’t compile because the try block doesn’t have anything after it.
Remember, the point of a try statement is for something to happen if an exception is
thrown. Without another clause, the try statement is lonely.

## Finally block

The try statement also lets you run code at the end with a fi nally clause regardless of
whether an exception is thrown. Figure 6.3 shows the syntax of a try statement with this
extra functionality.

```
12: void explore() {
13: try {
14: seeAnimals();
15: fall();
16: } catch (Exception e) {
17: getHugFromDaddy();
18: } finally {
19: seeMoreAnimals();
20: }
21: goHome();
22: }
```

Let's consider the following example:

```
25: try { // DOES NOT COMPILE
26: fall();
27: } finally {
28: System.out.println("all better");
29: } catch (Exception e) {
30: System.out.println("get up");
31: }
32:
33: try { // DOES NOT COMPILE
34: fall();
35: }
36:
37: try {
38: fall();
39: } finally {
40: System.out.println("all better");
41: }
```

The first example (lines 25–31) does not compile because the catch and finally blocks
are in the wrong order. The second example (lines 33–35) does not compile because there
must be a catch or finally block. The third example (lines 37–41) is just fine. catch is not
required if finally is present.

```

public void visitMonkeys() {
	try {
		seeAnimal();
	} catch (ExhibitClosedForLunch e) {// subclass exception
	System.out.print("try back later");
	} catch (ExhibitClosed e) {// superclass exception
	System.out.print("not today");	
	}
}