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
```

This time it works perfectly fine.

```
public void visitMonkeys() {
try {
	seeAnimal();
} catch (ExhibitClosed e) {
	System.out.print("not today");
} catch (ExhibitClosedForLunch e) {// DOES NOT COMPILE
	System.out.print("try back later");
}
}

```

This time, if the more specifi c ExhibitClosedForLunch exception is thrown, the catch
block for ExhibitClosed runs—which means there is no way for the second catch block to
ever run. Java correctly tells us there is an unreachable catch block.

```
public void visitSnakes() {
	try {
		seeAnimal();
	} catch (RuntimeException e) {
	
	System.out.print("runtime exception");
	
	} catch (ExhibitClosed e) {// DOES NOT COMPILE
	
	System.out.print("not today");
	
	} catch (Exception e) {
	
	System.out.print("exception");
}
}
```
It’s the same problem. ExhibitClosed is a RuntimeException. If it is thrown, the fi rst
catch block takes care of it, making sure there no way to get to the second catch block.
To review catching multiple exceptions, remember that at most one catch block will run
and it will be the fi rst catch block that can handle it.

## Throwing a Second Exception

```
16: public static void main(String[] args) {
17: FileReader reader = null;
18: try {
19: reader = read();
20: } catch (IOException e) {
21: try {
22: if (reader != null) reader.close();
23: } catch (IOException inner) {
24: }
25: }
26: }
27: private static FileReader read() throws IOException {
28: // CODE GOES HERE
29: }
```

The easiest case is if line 28 doesn’t throw an exception. Then the entire catch block on
lines 20–25 is skipped. Next, consider if line 28 throws a NullPointerException. That isn’t
an IOException, so the catch block on lines 20–25 will still be skipped.

If line 28 does throw an IOException, the catch block on lines 20–25 does get run. Line
22 tries to close the reader. If that goes well, the code completes and the main() method
ends normally. If the close() method does throw an exception, Java looks for more catch
blocks. There aren’t any, so the main method throws that new exception. Regardless, the
exception on line 28 is handled. A different exception might be thrown, but the one from
line 28 is done.

```
26: try {
27: throw new RuntimeException();
28: } catch (RuntimeException e) {
29: throw new RuntimeException();
30: } finally {
31: throw new Exception();
32: }
```

Line 27 throws an exception, which is caught on line 28. The catch block then throws
an exception on line 29. If there were no finally block, the exception from line 29 would
Recognizing Common Exception Types 313
be thrown. However, the finally block runs after the try block. Since the finally block
throws an exception of its own on line 31, this one gets thrown. The exception from the
catch block gets forgotten about. This is why you often see another try/catch inside a
finally block—to make sure it doesn’t mask the exception from the catch block.
Next we are going to show you the hardest example you can be asked related to
exceptions. What do you think this method returns? Go slowly. It’s tricky.

```
30: public String exceptions() {
31: String result = "";
32: String v = null;
33: try {
34: try {
35: result += "before";
36: v.length();
37: result += "after";
38: } catch (NullPointerException e) {
39: result += "catch";
40: throw new RuntimeException();
41: } finally {
42: result += "finally";
43: throw new Exception();
44: }
45: } catch (Exception e) {
46: result += "done";
47: }
48: return result;
49: }
```

The correct answer is before catch finally done. Everything is normal up until line
35, when "before" is added. Line 36 throws a NullPointerException. Line 37 is skipped
as Java goes straight to the catch block. Line 38 does catch the exception, and "catch" is
added on line 39. Then line 40 throws a RuntimeException. The finally block runs after
the catch regardless of whether an exception is thrown; it adds "finally" to result. At this
point, we have completed the inner try statement that ran on lines 34–44. The outer catch
block then sees an exception was thrown and catches it on line 45; it adds "done" to result.

