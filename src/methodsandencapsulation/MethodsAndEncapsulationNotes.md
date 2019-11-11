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