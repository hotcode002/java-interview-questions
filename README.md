# java-interview-questions
Java Interview Questions


- [# 21 - What is a Local Variable in Java](#what-is-a-local-variable)
- [# 22 - What are Instance Variables in Java](#what-are-instance-variables)
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

### What are Instance Variables

Instance variables are the exact opposite of local variables. They are declared within a class but outside of any method, constructor or block. 

Instance variables are used to store the state of the object. Here we have an instance variable `name` that is used to store the state of a `Person` object.  

```java
public class Person {

    // Instance variable
    private String name;

    // Constructor to initialize the name
    public Person(String name) {
        this.name = name;
    }

    // Method to get the name
    public String getName() {
        return name;
    }

public static void main(String[] args) {
        // Creating objects of Person class
        Person person1 = new Person("Siva");
    }
}
```

There are 4 key things to note here. 

1. **scope** - While a local variable is restricted in scope to its block, the scope of the instance variable is the entire class. For example, here we can use the name instance variable in the constructor, method or any block in the class.

2. **Access Modifiers** - While a local variable cannot have access modifiers, instance variables can have access modifiers like private, public or protected.

3. **Lifetime** - While local variables are destroyed beyond the scope of their block, instance variables exist for the entire lifecycle of the object. 

4. **Default values** - While local variables do NOT have any default value, instance variables have default values assigned to them. 

```java
public class Person {

    // Instance variable
    private String name;

    public static void main (String[] args){

        Person person = new Person();
        System.out.println(person.name);

    }
}
```

`Output`
```shell
null
```

For example, since we have not initialized the name variable here, the default value will be null.








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
