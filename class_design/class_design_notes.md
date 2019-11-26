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