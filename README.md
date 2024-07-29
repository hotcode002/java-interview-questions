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
1. [# 30 - What is a `enum` data type in java](#-30-what-is-an-enum)
1. [# 31 - What is Variable Shadowing in java](#-31-variable-shadowing)
1. [# 32 - What is a `Ternary` operator in java](#-32-ternary-operator)
1. [# 33 - What is `Type Inference` in java](#33-type-inference)
1. [# 34 - Swap two numbers using bitwise operators in Java](#34-swap-two-numbers-using-bitwise-operators)
1. [# 35 - Why are Strings `immutable` in java](#35-why-are-strings-immutable)






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

We know how the `switch` statement works. 

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;
        switch (day) {
            case 1: 
                System.out.println("Monday"); 
                break;
            case 2: 
                System.out.println("Tuesday"); 
                break;
            case 3: 
                System.out.println("Wednesday"); 
                break;
        }
    }
}

```

But, did you know that in Java 12, a new version of `switch` was introduced called the `switch` expression ? Here is how it works. 

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Sunday";
            case 2 -> "Monday";
            case 3 -> "Tuesday";
            case 4 -> "Wednesday";
        };
    }
}
```

Instead of a colon `:`, we can use the `->` arrow operator to separate the case statement from it's code block. As you can see, the `switch` expression is much more compact compared to the regular `switch` statement. 

If you have multiple lines of code in a block, you can use flower brackets - like so and use the `yield` keyword to return a value.

```java
public class Main {
    public static void main(String[] args) {
        int day = 3;
        String dayName = switch (day) {
            case 3 -> {
                // Multiple statements can be executed here.
                System.out.println("Sunday");
                yield "Sunday";
            }
            case 2 -> "Monday";
            case 4 -> "Wednesday";
            default -> "Not a valid day";
        };
    }
}
```

Also, there is no need for a `break` statement in a `switch` expression. This reduces a lot of boilerplate code. 

### # 30 What is an `enum`

```java
public enum CoffeeSize {
    SMALL,
    MEDIUM,
    LARGE
}
```

An `enum` (short for "enumeration") is a special data type that represents a group of constants. Here we have 3 coffee sizes - SMALL, MEDIUM and LARGE. 

```java
public class CoffeeShop {
    public static void main(String[] args) {
        CoffeeSize size = CoffeeSize.MEDIUM;

        switch (size) {
            case SMALL:
                System.out.println("small coffee.");
                break;
            case MEDIUM:
                System.out.println("medium coffee.");
                break;
            case LARGE:
                System.out.println("large coffee.");
                break;
        }
    }
}
```

Here is how we can use `enum` data types. If you observe, these are not strings - you can see that we are not using the constant SMALL in quotes. They are just constants. `enum`s can have methods and constructors as well, but more about that in a separate interview question.

You might now be wondering, why not define coffee sizes using integers or strings - like `1` for `SMALL`, `2` for `MEDIUM` and so on. That's exactly where `enum`s are useful - You see, you don't have to bother about data types like integers or strings. That's what makes `enum`s **type safe** and it also increases code **readability**

### # 31 Variable Shadowing

```java
public class Test {

    // Instance variable
    int x = 5;

    public void print() {
        
        // Local variable 
        int x = 10;
        System.out.println(x);

    }

    public static void main(String[] args) {
        Test example = new Test();
        example.print();
    }
}
```

We have an instance variable `x` with a value of `5`. Inside the `print` method, we define a local variable with the same name - `x` but with a different value `10`. Is this even legal ? 

Yes, it is. When you create a local variable with the same name as a variable in it's outer scope, its called **Variable Shadowing**. The word **shadowing** might be a bit confusing. Think of it as overriding. 

When you declare a variable that shadows a variable in it's outer scope, the inner scope variable takes precedence over the outer scope variable. So, in this case, the inner scope variable `x` will have a value of `10` within that scope. \

### # 32 Ternary Operator

```java
public class Test {

    public static void main(String[] args) {

        int a = 10, b = 20;

        int max = (a > b) ? a : b;

        // Output: Max value: 20
        System.out.println("Max value: " + max); 
    }

}
```

The ternary operator `?` ,  `:` is a shorthand for the if-else statement. The syntax goes like this. 

```java
condition ? expression1 : expression2
```

If the condition is true, expression1 is evaluated and returned; otherwise, expression2 is evaluated and returned. In this case, `a` is not greater than `b`. So, the second expression `b` is returned to the `max` variable. 

We can very well nest ternary operators. For example, to find the biggest of 3 numbers `a`, `b` and `c` you can do a nested ternary operator like this. 

```java
public class Test {

    public static void main(String[] args) {

        int a = 10, b = 20, c = 30;

        int result = a > b ? (a > c ? a : c) : (b > c ? b : c);

        // Output: Max value: 30
        System.out.println("The largest number is: " + result);
    }

}
```

The first expression `a > b` evaluates to false, so the second part of the ternary operator `(b > c ? b : c)` is evaluated.
Since `b > c` is false, the result is `c`.

### 33 Type Inference

```java
public class Test {
    public static void main(String[] args) {
        var message = "Hello, Java!";
        var number = 42;
        var list = List.of("A", "B", "C");
    }
}
```

Type inference allows the compiler to Java automatically determine the type of a variable based on the context in which it is used. Here, we are not using the data type - like `String`, `int` or `array`. Instead we are just using the keyword `var` to declare the variable and assigning it to the data directly. 

This looks very cool, right ? Like `python` or `javascript`. It is. But there are some restrictions. 

```java
public class Test {

    // This is invalid
    var message = "Hello, Java!";

    public static void main(String[] args) {
        var message = "Hello, Java!";
        var number = 42;
        var list = List.of("A", "B", "C");
    }
}
```

1. You can only use the `var` keyword on local variables. If you try to create an instance variable, java throws an error.


```java
public class Test {

    public static void main(String[] args) {
        var message;
        message = "Hello World";
        var number = 42;
        var list = List.of("A", "B", "C");
    }
}
```
2. You have to initialize the variable when declaring it. For example, you cannot just declare the variable with the `var` keyword and not initialize it. Java compiler throws an error. 


### #34 Swap two numbers using bitwise operators

```java
public class Test {
    public static void main(String[] args) {
        int a = 5;
        int b = 3;

        // a now becomes 6 (binary: 0110)
        a = a ^ b;  

        // b now becomes 5 (binary: 0101)
        b = a ^ b;  

        // a now becomes 3 (binary: 0011)
        a = a ^ b;  

    }
}

```

You can swap two numbers without using a temporary variable by using the XOR operator. The `XOR` operator compares each bit of its operands. Here are the rules. 

`0 ^ 0 = 0`
`1 ^ 1 = 0`
`0 ^ 1 = 1`
`1 ^ 0 = 1`

If the bits are different, the result is 1; if they are the same, the result is 0. Here are the steps.

1. The first step combines both values into `a`, while `b` remains unchanged. This new value in `a` contains information about both `a` and `b`.
2. The second step extracts the original value of `a` into `b`. This is because XORing the combined value with `b` cancels out `b` and leaves `a`. This effectively moves the original `a` value into `b`.
3. Now, `b` holds the original value of `a`. The third step extracts the original value of `b` (which is now in `b`) into `a`. This is because XORing the combined value with the new `b` (which is the original `a`) cancels out `a` and leaves `b`.


The key thing to understand is that XORing the same value twice cancels out that value, allowing us to manipulate and recover the original numbers.


### #35 Why are Strings immutable

```java

public class Test {
    public static void main(String[] args) {
    
        String message = "Hello";
        System.out.println(System.identityHashCode(message));

        message = "Hello World";
        System.out.println(System.identityHashCode(message));

    }
}       

```

Immutability of strings means that once a String object is created, its value cannot be changed. Any modification to a string results in the creation of a new String object rather than altering the existing one. 

In this example, we see that once the string has been changed from "Hello" to "Hello World", the addresses of these strings have changed. 

```sh
498931366
2060468723
```

But do you know why they are immutable ? Security is ofcourse a primary reason, but here are the next top 3 reasons why Java Strings are immutable

1. **String Pooling** - String Pool is an area on the heap where strings are stored. When a new string is created, Java checks in the pool to see if an identical string already exists. If it does, it references the existing string. This reduces memory usage and improves performance. 

2. **Thread Safe** - Since threads are immutable, they can be freely shared between threads without the risk of concurrent modification. This makes strings inherently thread-safe.

3. **Performance** - Because of immutability, the JVM can safely cache and reuse immutable objects, knowing that their state will not change. This results in huge performance improvements. 


### #36 What is String Pool

```java
String str1 = "Hello, World!";
```
The `String Pool` in Java, is a special area of memory where the JVM stores String literals like this. Here is how a string pool works. 

```java
String string1 = "Hello, World!";
String string2 = "Hello, World!";
```

First we create a string variable `string1` and assign it the string literal `Hello, World!`. Now, when we create the next string `string2` with the same `Hello, World!` string literal, the JVM checks the string pool to see if an `Hello, World!` string already exists. In this case, it already does. So, instead of creating a new string object a reference to the string `Hello, World!` is returned. 

You can check this by getting their addresses. They will both be pointing to the same address in the string pool. 

```java
System.out.println(System.identityHashCode(str1));
System.out.println(System.identityHashCode(str1));
```

```sh
498931366
498931366
```

The string pool exists in the heap memory. 

There are 2 benefits of using the String pool. 

1. **Memory Efficiency**: By reusing string literals, the JVM conserves memory because multiple references can point to the same string object.
2. **Performance**: String comparison using == becomes faster for pooled strings because we are just comparing references instead of checking each character.





















