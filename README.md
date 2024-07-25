# java-interview-questions
Java Interview Questions


1. [# 21 - What is a Local Variable in Java](#what-is-a-local-variable)
1. [# 22 - What are Instance Variables in Java](#what-are-instance-variables)
1. [# 23 - What are Static Variables in Java](#what-are-static-variables)
1. [# 24 - What is a Static Block in Java](#what-is-a-static-block)
1. [# 25 - Difference between static and final in Java](#difference-between-static-and-final)
1. [# 26 - Default values assigned to variables in Java](#default-values-assigned-to-variables)
1. [# 27 - What is `instanceof` operator in java](#-27-what-is-instanceof-operator)
1. [# 28 - What is `short circuit` evaluation in java](#-28-what-is-short-circuit-evaluation)
1. [# 29 - What is a `switch` expression in java](#-29-what-is-a-switch-expression)



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

Instance variables are the exact opposite of local variables. They are declared within a class but outside of any method, constructor or block. Instance variables are used to store the state of the object. 

Here we have an instance variable `name` that is used to store the state of a `Person` object.  

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

```java
public class Person {

    // Instance variable
    private String name;
    String address;


    public static void main(String[] args) {
        // Creating objects of Person class
        Person person1 = new Person("Siva");
        person1.address = "100 Kondapur, Hyderabad";
    }
}
```

By the way, you don't have to always specify the access modifier. If you don't specify any, the default is `package-private` - meaning, the variable is accessible only within the package

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

```shell
#output
null
```

For example, since we have not initialized the name variable here, the default value will be null.


### What are Static Variables

**Static** variables, also known as **class** variables, are variables that are declared with the **static** keyword inside a class but outside any method, constructor, or block. To understand **static** variables, let's start off by comparing them with instance variable. 

```java
public class Person {

    // Instance variable
    public String name;

    // Constructor to initialize the name
    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // Creating objects of Person class
        Person person1 = new Person("Siva");
        Person person2 = new Person("Hari");

        System.out.println(person1.name); // Siva
        System.out.println(person2.name); // Hari
    }
}
```

Here we have an instances variable **name**, that is used to store the name of the **Person** object. For every new object that you create, you are going to have as many name values. These values are associated with the objects and not with the class itself. So, each object that we create has it's own name value.

```sh
Siva
Hari
```

However, when you declare a variable as **static**, it is associated with the class itself as opposed to the object. This means that all instances of the class share the same copy of the static variable.

Let's change the name variable to static now. This time, when we create 2 different Persons, the static variable **name** cannot be object specific. It can only hold one value that is associated with the **Person** class itself. 

```java
public class Person {

    // Static variable
    public static String name;

    // Constructor to initialize the name
    public Person(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        // Creating objects of Person class
        Person person1 = new Person("Siva");
        Person person2 = new Person("Hari");

        System.out.println(person1.name); // Hari
        System.out.println(person2.name); // Hari
    }
}
```

```sh
Hari
Hari
```

### What is a Static Block

A **static** block, is a block of code inside a class that is executed when the class is first loaded into memory.

The **static** variable name is initialized not at the time of declaration but in the static block. 

```java
public class Person {

    // Static variable
    public static String name;

    // Static Block
    static {
        name = "Siva";
    }

    public static void main(String[] args) {
        // Creating objects of Person class
        Person person1 = new Person();
        Person person2 = new Person();

        System.out.println(person1.name); // Siva
        System.out.println(person2.name); // Siva       
    }
}
```

```sh
Siva
Siva
```

That's all good, but you are now wondering why do it like this ? Why not initialize the **static** variable right at the time of declaration ?

```java
    // Static variable
    public static String name = "Siva";
```

instead of initializing it in the **static** block ? 

Well, in this case, the initialization is really simple. It just a name. Now, imagine a complex initialization. For example, if we had to read a file or make a network request and get the name and assign it to the static variable. 

```java
    // Static variable
    public static String name;

    // Static Block
    static {
        // Read a file or make a network request

        // Extract the name field

        // Assign it to the name variable
    }
```

In complex cases like this, you can use the **static** block. 

### Difference between static and Final

Let's first tackle the **final** keyword as its relatively simple. Any variable that you need to be declared as a constant and never changed again throught he program can be declared using the **final** keyword. For example, when you are calculating the area of a circle, the value of `PI` is constant and should never be changed. So, you can declare it using the **final** keyword. 

```java
public class Circle {

    // Final variable for pi (π)
    public final double PI = 3.14159;

    public static void main(String[] args) {

    }
}
```

If you try and change it later, you get an error.

```java
public class Circle {

    // Final variable for pi (π)
    public final double PI = 3.14159;

    // Static variable as a counter
    public static int counter = 0;

    public static void main(String[] args) {
        
        // Everytime you calculate area of circle
        // increment the counter
        Circle c1 = new Circle();
        Circle c2 = new Circle();
        
    }
}
```

**static** keyword on the other hand is used to store data associated with the class and not  the objects of that class. For example, if you want to calculate how many times you have calculated the area of a circle, have a **static** variable and start incrementing it. 

The Circle objects `c1` and `c2` share the `counter` data. They don't have separate instances for each other.


### Default values assigned to variables

When you declare a variable and do NOT assign a value to it, Java assigns a default value to it. This would depend on the type of variable.

1. Local Variable - Local variables do not have a default value. If you try to use the unassigned local variable age, you get a syntax error. 

```java
public class Main {
    public static void main(String[] args) {

        // Declaration of a local variable
        int age; 

        // Trying to use age without initialization 
        // will cause a compile-time error
        System.out.println(age); 

    }
}
```

2. Instance Variable -  Instance variables get default values. Here, even though we haven't assigned a value to age, it still prints 0. 

```java
class Example {
    // Instance variable
    int age; 

    public static void main(String[] args) {

        Example ex = new Example();

        // When you use the instance variable
        // without initialization it gets a
        // default value
        System.out.println(ex.age); 

    }
}
```

The default values depend on the data type. Here are the default values for numeric, character, boolean, objects and arrays. 

Numeric types:

byte: 0
short: 0
int: 0
long: 0L
float: 0.0f
double: 0.0d
Character type:

char: null

boolean: false

Reference types 
(objects, arrays, etc.):null

3. Static Variables - Static variables also have default values. The default values are similar to how instance variables get default values. 


### # 27 What is instanceof operator

The instanceof operator in Java is used to test whether an object is an instance of a specific class or a subclass of that class. Here we have a string `name` and when you say `name instanceof String` you are asking Java, if the variable `name` is an object of type `String` class. In this case it is and you get `true`.

```java

public class Main {
    public static void main(String[] args) {

        String name = "Hello, World!";

        // returns true becuase name is an 
        // instance of string Class
        System.out.println(name instanceof String);

    }
}


```

It does not check just classes, but subclasses as well. Say you have an `Animal` class, and then we have the `Dog` class that extend the `Animal` class. When you say the `Dog` object `d` is an instance of the `Dog` class, it obviously is. But when you ask if it is an instanceof its parent class `Animal`, the answer is still true. Because the `Dog` is just a sub-class of the `Animal` class.

```java
class Animal {
}

class Dog extends Animal {
}

public class Main {
    public static void main(String[] args) {

        Dog d = new Dog();
      
        // true
        System.out.println(d instanceof Dog);    

        // true
        System.out.println(d instanceof Animal);
        
    }
}
```

### # 28 What is Short Circuit Evaluation

Short-circuit evaluation means that in logical AND (&&) and logical OR (||) operations, the second operand is evaluated only if necessary. Here is an example

```java
public class Main {
    public static void main (String[] args){

        int a = 5;

        // The division by zero is not evaluated 
        // because the first condition is false
        boolean result = (a > 10) && (a / 0 == 1); 

        // prints false
        System.out.println( result );

    }
}

```

In this logical AND operation, `a = 5` and since 5 is not greater than 10, the left side of the logical AND operation evaluates to `false`. Because it is `false`, Java takes a shortcut and does not evaluate the second part of it and the result will be `false`. This is called as a `short circuit` evaluation. 

The same is true with the logical OR operation. If the first operand evaluates to true, the second operand is not evaluated because the overall expression will be true regardless of the value of the second operand.

```java
    int a = 5;
    boolean result = (a > 0) || (a / 0 == 1);

    // truez
    System.out.println(result);
```

### # 29 What is a Switch Expression








