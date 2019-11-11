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