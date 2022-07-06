## Default and static methods in interfaces  in java

One word backward compatibility 

Suppose you want to introduce new method in your interface but before java 8 it was not possible as it would have lead to implementation break in java7 or older version
But in java 8 we can create a default method (that has body ) by this way it will not lead to implementation break. 

Also its not necessay to implement the default methods as well 

```java
public class MyClass implements inter {
    public static void main(String args[]) {
      int x=10;
      int y=25;
      int z=x+y;

      System.out.println("Sum of x+y = " + z);
      MyClass c  = new MyClass();
      c.getMyName();
    }
    // we don't necessarily have to implement the default methods 
    @Override
    public void getMyName(){
        System.out.println("my name is class c");
    }
}
interface inter {
    default void getMyName(){
        System.out.println("my name is prashant mishra");
    }
}
```
## Static method in interface in java 8

If we want to add a method in interface and we don't want the implementing classes to override it  we can create static methods in that interface.

Static is used to create methods when methods are not necessarily changing the state of the object of the class the implements this interface.

## private methods in interface in java 9 
Used for confidentiality code . As methods that are created with private keyword are not accessble or visible out side of the interface and hence they can't be overridden.

Note : 

	An interface supports default methods since Java 8 version. Sometimes these default methods may contain a code that can be common in multiple methods. In those situations, we can write another default method and make code reusability. When the common code is confidential then it's not advisable to keep them in default methods because all the classes that implement that interface can access all default methods.
	
	An interface can have private methods since Java 9 version. These methods are visible only inside the class/interface, so it's recommended to use private methods for confidential code. That's the reason behind the addition of private methods in interfaces.


```java
Syntax
private void methodName() {
   // some statementscode
}
Example
interface Operation {
   default void addition() {
      System.out.println("default method addition");
   }
   default void multiply() {
      division();
      System.out.println("default method multiply");
   }
   private void division() {         // private method
      System.out.println("private method division");
   }
}

class PrivateMethodTest implements Operation {
   public static void main(String args[]) {
      PrivateMethodTest test = new PrivateMethodTest();
      test.multiply();
   }
}
Output
private method division
default method multiply
```
