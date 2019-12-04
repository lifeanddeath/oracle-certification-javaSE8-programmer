## Notes

Inheritance is the process by which the new child subclass automatically includes any
public or protected primitives, objects, or methods defined in the parent class.

the super() command may only
be used as the fi rst statement of the constructor.


## Constructor Rules

Constructor Defi nition Rules:

1. The first statement of every constructor is a call to another constructor within the class
using this(), or a call to a constructor in the direct parent class using super().

2. The super() call may not be used after the first statement of the constructor.

3. If no super() call is declared in a constructor, Java will insert a no-argument super()
as the first statement of the constructor.

4. If the parent doesn’t have a no-argument constructor and the child doesn’t define any
constructors, the compiler will throw an error and try to insert a default no-argument
constructor into the child class.

5. If the parent doesn’t have a no-argument constructor, the compiler requires an explicit
call to a parent constructor in each child constructor.

Make sure you understand these rules; the exam will often provide code that breaks one
or many of these rules and therefore doesn’t compile.

Overriding a method is not without limitations, though. The compiler performs the following
checks when you override a nonprivate method:

1. The method in the child class must have the same signature as the method in the parent
class.

2. The method in the child class must be at least as accessible or more accessible than the
method in the parent class.

3. The method in the child class may not throw a checked exception that is new or
broader than the class of any exception thrown in the parent class method.

4. If the method returns a value, it must be the same or a subclass of the method in the
parent class, known as covariant return types.


## Creating Abstract Classes 

Your
goal is to provide some reusable variables and methods to developers in the parent class,
whereas the developers provide specifi c implementations or overrides of other methods in
the child classes. Furthermore, let’s say you also don’t want an instance of the parent class
to be instantiated unless it is an instance of the child class.

An abstract class is a class that is marked with the abstract keyword and cannot be instantiated.
An abstract method is a method marked with the abstract keyword defined in an
abstract class, for which no implementation is provided in the class in which it is declared.

```
public abstract class Animal {
protected int age;
public void eat() {
System.out.println("Animal is eating");
}
public abstract String getName();
}
public class Swan extends Animal {
public String getName() {
return "Swan";
}
}
```

Rules for Creating Abstract Classes:

Abstract Class Definition Rules:

1. Abstract classes cannot be instantiated directly.

2. Abstract classes may be defined with any number, including zero, of abstract and nonabstract
methods.

3. Abstract classes may not be marked as private or final.

4. An abstract class that extends another abstract class inherits all of its abstract methods
as its own abstract methods.

5. The first concrete class that extends an abstract class must provide an implementation
for all of the inherited abstract methods.

Abstract Method Definition Rules:

1. Abstract methods may only be defined in abstract classes.

2. Abstract methods may not be declared private or final.

3. Abstract methods must not provide a method body/implementation in the abstract
class for which is it declared.

4. Implementing an abstract method in a subclass follows the same rules for overriding a
method. For example, the name and signature must be the same, and the visibility of
the method in the subclass must be at least as accessible as the method in the parent
class.

## Defining Interface

1. Interfaces cannot be instantiated directly.

2. An interface is not required to have any methods.

3. An interface may not be marked as final.

4. All top-level interfaces are assumed to have public or default access, and they must
include the abstract modifier in their definition. Therefore, marking an interface as
private, protected, or final will trigger a compiler error, since this is incompatible
with these assumptions.

5. All nondefault methods in an interface are assumed to have the modifiers abstract
and public in their definition. Therefore, marking a method as private, protected,
or final will trigger compiler errors as these are incompatible with the abstract and
public keywords.

1. A default method may only be declared within an interface and not within a class or
abstract class.

2. A default method must be marked with the default keyword. If a method is marked as
default, it must provide a method body.

3. A default method is not assumed to be static, final, or abstract, as it may be used
or overridden by a class that implements the interface.

4. Like all methods in an interface, a default method is assumed to be public and will not
compile if marked as private or protected.

Here are some basic rules to keep in mind when casting variables:

1. Casting an object from a subclass to a superclass doesn’t require an explicit cast.

2. Casting an object from a superclass to a subclass requires an explicit cast.

3. The compiler will not allow casts to unrelated types.

4. Even when the code compiles without issue, an exception may be thrown at runtime if
the object being cast is not actually an instance of that class.