## Methods And Encapsulation

## Designing Methods

```
public final void nap(int minutes) throws Exception {
	// take a nap
}
```

This is called a method declaration.


## Access Modifiers

Java offers four choices of access modifiers.

<b>public</b> The method can be called from an any class.
<br>
<b>private</b> The method can only be called within the same class.
<br>
<b>protected</b> The method can only be called from classes in the same package or subclasses
<br>
<b>Default(Package Private)</b> The method can only be called from classes in the same
package. This one is tricky because there is no keyword for default access. You simply omit
the access modifier.
<br>


Let's consider the following examples:

```
public void walk1() {}
default void walk2() {} // DOES NOT COMPILE because default is not a legal keyword
void public walk3() {} // DOES NOT COMPILE because access modifier is defined after the return type.
void walk4() {}
}
```

## Optional Specifiers

<b>static</b> Used for class methods.
<br>
<b>abstract</b> Used when not providing a method body.
<br>
<b>final</b> Used when a method is not allowed to be overriden by a subclass' method.
<br>
<b>synchronize</b> Regarding to the OCP exam.
<br>
<b>native</b> Not on the OCA or OCP exam. Used when interacting with code written in
another language such as C++.
<br>
<b>strictfp</b> Not on the OCA or OCP exam. Used for making floating-point calculations
portable.
<br>

Let's consider the following examples:

```
public void walk1() {}
public final void walk2() {}
public static final void walk3() {}
public final static void walk4() {}
public modifier void walk5() {} // DOES NOT COMPILE because modifier is not a legal specifier keyword.
public void final walk6() {} // DOES NOT COMPILE because optional modifier is after the return type.
final public void walk7() {} // java allows optional specifiers to appear before the access modifiers.
}
```

## Return Type

The return type might be an
actual Java type such as String or int. If there is no return type, the void keyword is used.
This special return type comes from the English language: void means without contents. In
Java, we have no type there.

Let's consider some examples:

```
public void walk1() { }
public void walk2() { return; }
public String walk3() { return ""; }
public String walk4() { } // DOES NOT COMPILE
public walk5() { } // DOES NOT COMPILE
String walk6(int a) { if (a == 4) return ""; } // DOES NOT COMPILE because if a is not 4, then we dont specify a return type.
```

## Method Name 

Method names follow the same rules as we practiced with variable names in Chapter 1. To review, an identifier may only contain letters, numbers or $,_ signs. Importantly, the first character is not allowed to be a number , and reserved words are not allowed.

```
public void walk1() { }
public void 2walk() { } // DOES NOT COMPILE
public walk3 void() { } // DOES NOT COMPILE
public void Walk_$() { }
public void() { } // DOES NOT COMPILE
```

## Working with Varargs

A method may use a vararg parameter(variable argument) as if it is an array. It is a little different than array, though. A vararg parameter must be the last element in a method's parameter list. This implies you are only allowed to have one vararg parameter per method.

```
public void walk1(int... nums) { }
public void walk2(int start, int... nums) { }
public void walk3(int... nums, int start) { } // DOES NOT COMPILE
public void walk4(int... start, int... nums) { } // DOES NOT COMPILE
```
```
15: public static void walk(int start, int... nums) {
16: System.out.println(nums.length);
17: }
18: public static void main(String[] args) {
19: walk(1); // 0
20: walk(1, 2); // 1
21: walk(1, 2, 3); // 2
22: walk(1, new int[] {4, 5}); // 2
23: }
```

## Applying Access Modifiers

### Private Access

Private access is easy. Only code in the same class can call private methods or access private fields.

### Defaul(Package Private) Access

When there is no access modifier, Java uses the default, which is package private access. This means that the member is private to classes in the same package. In other words, only classes in the package may access it.

### Protected Access

Protected access allows everything that default package access allows and more. The protected access modifier adds ability to access members of a parent class.

### Public Access

Anyone can call from anywhere!.