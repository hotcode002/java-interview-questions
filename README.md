# java-interview-questions
Java Interview Questions


- [# 21 - What is a Local Variable in Java](#what-is-a-local-variable)
- [# 22 - Scope of a Local Variable in Java](#scope-of-a-local-variable-in-java)
- [# 24 - Local vs Instance vs Static Variables in Java ](#local-vs-instance-vs-static)


### What is a Local Variable

Local variables are declared within a method, constructor or block.

```java
class Hello {
    public void showName() {

        // local variable declared in a method
        String name = "Campushire"; 

        System.out.println(name);
    }
    
}
```

Here the variable `name` is declared in the method `showName`. 

```java
public class Hello {
    
    // Constructor
    public Hello() {

        // Local variable declared in the constructor
        String name = "Campushire"; 

    }
}
```

and here the variable `name` is declared in the constructor.

```java
public class Hello {
    
    // Constructor
    public Hello() {

        // local variable declared in a method
        String name = "Campushire"; 

        // Block
        {
            // Local variable declared within the block
            String blockName = "Campushire Block"; 
            System.out.println(blockName);
        }

    }
}
```

and finally, we have the variable `blockName` declared within a block - A block is a some piece of code that is written within curly braces. 

A key concept that you need to understand here is that the scope of a local variable is limited to the block of code in which it is declared. This means it cannot be accessed outside of that block.

For example, this local variable `name` declared within the method `showName()` cannot be accessed outside of the method.

```java
class Hello {
    public void showName() {

        // local variable declared in a method
        String name = "Campushire"; 

        System.out.println(name);
    }

    System.out.println(name);
    
}
```

The same logic applies for local variables declared within a constructor or a block.

### Scope of a Local Variable in Java






### local-vs-instance-vs-static
Local vs Instance vs Static Variables in Java

There are 3 types of variables in Java

1. Local
2. Instance
3. Static

```java
class Hello {
    public void myMethod() {

        // local variable
        int localVar = 10; 

        System.out.println(localVar);
    }
}
``` 

Local variables are declared within a method, constructor or block.
