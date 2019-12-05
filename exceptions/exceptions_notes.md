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
