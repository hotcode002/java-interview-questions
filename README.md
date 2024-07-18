# java-interview-questions
Java Interview Questions


[# 21 - What is a Local Variable in Java](#what-is-local-variable)

[# 24 - Local vs Instance vs Static Variables in Java ](#local-vs-instance-vs-static)


### What is Local Variable

Local variables are declared within a method, constructor or block.

```java
class Hello {
    public void showName() {

        // local variable
        String name = "Campushire"; 

        System.out.println(name);
    }
}
```

Here the variable `name` is declared in the method `showName`. 

```java =
public class Hello {
    
    // Constructor
    public Hello() {

        // Local variable declared in the constructor
        String name = "Campushire"; 

    }
}
```



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
