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
1. [# 36 - What is a `String Pool` in Java](#36-what-is-string-pool)
1. [# 37 - Why is String concatenation in Java loops inefficient](#37-why-is-string-concatenation-in-java-loops-inefficient)
1. [# 38 - How to reverse a string in Java](#38-how-to-reverse-a-string )
1. [# 39 - How to reverse a string with recursion in Java](#39-reverse-a-string-with-recursion)
1. [# 40 - What does the String's `intern` method do](#40-string-intern-method)
1. [# 41 - How to count vowels in a String in java](#41-count-vowels-in-a-string)
1. [# 42 - How to check if two strings are `Anagrams` in Java](#42-check-if-two-strings-are-anagrams)






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
3. Now, `b` holds the original value of `a`. The third step extracts the original value of `b` into `a`. This is because XORing the combined value with the new `b` cancels out `a` and leaves `b`.


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

2. **Thread Safe** - Since strings  are immutable, they can be freely shared between threads without the risk of concurrent modification. This makes strings inherently thread-safe.

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



### #37 Why is String Concatenation in Java Loops inefficient

```java
public class Test {
    public static void main(String[] args) {
        String result = "";
        for (int i = 0; i < 1000; i++) {
            result += i;
        }
    }
}
```

Using the + operator for string concatenation inside a loop is not recommended in Java. Why is that ? As you know, Strings in Java are immutable and this leads to the creation of multiple temporary String objects during the concatenation process.

In a loop, using the + operator repeatedly results in the creation of many temporary String objects. Each iteration of the loop creates a new String object, which involves copying the existing characters to a new array and appending the new characters, leading to a lot of overhead.

```java
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            sb.append(i);
        }
        String result = sb.toString();
    }
}
```

To avoid this, use the `StringBuilder` instead of the `String` class. The `append()` method of StringBuilder modifies the same StringBuilder instance without creating new objects.

### #38 How to reverse a String

There are many problems where you have to reverse strings. There are many ways to reverse a string in Java and we are going to look at two simple methods. 

1. Use the built-in `reverse()` method. 

```java
public class Test {
    public static void main(String[] args) {
        String original = "Hello";
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed);
    }
}
```

If you use the `StringBuilder` or the `StringBuffer` class, it has a built-in `reverse()` method. It is simple and efficient. 

2. Using a `for` loop. Ofcourse, this is the hard way, but you get to be a better programmer by learning this. 

```java
public class Test {
    public static void main(String[] args) {
        String original = "Hello";

        // Reverse the string using a loop directly in the main method
        char[] chars = original.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        String reversed = new String(chars);

        System.out.println(reversed);
    }
}
```

First, convert the string into a character array using the `toCharArray()` method so that you can work with the individual characters easily. Have two pointers called `left` and `right`. The `left` points to the first character and `right` points to the last character. After each swap, move the `left` pointer to the right and the `right` pointer to the left. Now, keep swapping those characters as long as the `right` pointer is greater than the `left` pointer. 

| Iteration | Char Array |
|---| ---|
|Original | Hello|
|1 | oellH|
|2 | olleH |

Here is how the loop swaps characters. First `H` and `o`are swapped. Next, `e` and `l` are swapped. And that's it. Finally convert the character array to string using a new String Constructor. 


### #39 Reverse a String with Recursion

There are many ways to reverse a string and here we are asked specifically to reverse a string using Recursion. 

```java
public class Test {
    public static void main(String[] args) {
        String original = "Hello";
        String reversed = reverseString(original);
        System.out.println(original);
        System.out.println(reversed);
    }

    // Method to reverse a string using recursion
    public static String reverseString(String str) {
        // Base case: if the string is empty or has only one character, return it as is
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: reverse the substring and append the first character to the end
        return reverseString(str.substring(1)) + str.charAt(0);
    }
}
```

The function `reverseString` is called recursively, by cutting off the first character and appending it at the end. Here is how the flow goes.

```java
 reverseString("Hello")
  -> reverseString("ello") + 'H'
    -> reverseString("llo") + 'e'
      -> reverseString("lo") + 'l'
        -> reverseString("o") + 'l'
          -> reverseString("") + 'o'
            -> ""
          -> "o"
        -> "ol"
      -> "oll"
    -> "olle"
  -> "olleH"
```

In the first call, we are calling the `reverseString` with just `ello` and appending `H` at the end. 

In the second call, we are calling `reverseString` with just `llo`and appending `e` at the end and so on. 

Finally, when the string is empty, recursion reaches the base case and starts to return. This is where we build the reversed string.

As the recursive function returns, the letters are appended from the laste letter `o` all the way to the first letter `H`. And that's how you get the final reversed string. 

### #40 String intern method

In Java, the `intern()` method is used to obtain a canonical representation of a string. Here's what this means:

```java
public class Test {
    public static void main(String[] args) {

        String str1 = "example";

        // Already exists in the pool.
        // Just a reference is returned
        String str2 = str1.intern();

    }
}
```

- The `intern()` method can be called on any String object. When you call `intern()` on a string, Java checks if the string is already in the string pool.
- If it is, `intern()` returns a reference to the pooled string.

```java
public class Test {
    public static void main(String[] args) {

        // Added to the string pool
        String str3 = "hello".intern();

    }
}
```
- If not, `intern()` adds the string to the pool and then returns a reference to it.

```java
public class Test    {
    public static void main(String[] args) {
        String a = new String("example");
        String b = "example";
        String c = a.intern();

        System.out.println(a == b);  // false
        System.out.println(b == c);  // true
        System.out.println(a == c);  // false
    }
}
```
Here is an example. 

`a` is Created with the new `String()` method, so it's a new object on the heap, not in the string pool.

`b` is a string literal, so it is stored in the string pool.

`c` calls `a.intern()` which returns a reference to the string "example" from the pool.

`a == b` is false because `a` refers to a new object, while `b` refers to the pooled string.

`b == c`: true because `c`is a reference to the pooled string "example", which is the same as `b`.

`a == c`: false because `a` is a different object compared to `c`, even though they have the same content.

### #41 Reverse a String "in-place"

This is LeetCode Problem # 344. The problem statement goes like this

Write a function that reverses a string. The input string is given as an array of characters. The constraint is that you must do this by modifying the input array `in-place` with `o(1)` extra memory. Meaning, we should not use a lot of memory and not use additional data structures. 

Here is an example. 

`Input` - `["h","e","l","l","o"]`

`Ouput` - `["o","l","l","e","h"]`

This can be easily achieved using the `2-pointer` approach. 

```java
public class Test {
    public static void main(String[] args) {

        char[] str = { 'h', 'e', 'l', 'l', 'o' };
        reverseString(str);
        System.out.println(str);

    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            // Swap characters at left and right pointers
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            // Move pointers towards the center
            left++;
            right--;
        }
    }
}
```

```java
    int left = 0;
    int right = s.length - 1;
```

Have two pointers called `left` and `right`. The `left` points to the first character and `right` points to the last character.

```java
    // Swap characters at left and right pointers
    char temp = s[left];
    s[left] = s[right];
    s[right] = temp;
```

Swap characters at the left and right pointer. 

```java
    // Move pointers towards the center
    left++;
    right--;
```

After each swap, move the `left` pointer to the right and the `right` pointer to the left. 

```java
    while (left < right) {
        // Swap characters at left and right pointers
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Move pointers towards the center
        left++;
        right--;
    }
```

Now, keep swapping those characters as long as the `right` pointer is greater than the `left` pointer.          

| Iteration | Char Array |
|---| ---|
|Original | Hello|
|1 | oellH|
|2 | olleH |

Here is how the loop swaps characters. First `H` and `o`are swapped. Next, `e` and `l` are swapped. And that's it. Finally convert the character array to string using a new String Constructor. 


### #42 Score of a String

This is Leetcode # 3110. 

`Input`: `s = "hello"`

`Output`: `13`

You are given a string `s`. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

`Explanation`:

- 'h' = 104
- 'e' = 101
- 'l' = 108
- 'o' = 111

The differences in ASCII values of the characters are: 

`|104 - 101|` + 
`|101 - 108|` + 
`|108 - 108|` + 
`|108 - 111|` = `3` + `7` + `0` + `3` = `13`.

So, the score of string `s` would be `13`.

```java
public class Test {
    public static void main(String[] args) {

        int score = 0;
        String s = "hello";
        for (int i = 1; i < s.length(); i++) {

            int diff = s.charAt(i) - s.charAt(i - 1);
            score += (Math.abs(diff));
        }
        System.out.println(score);

    }
}

```
And here is the solution. 

First, iterate over the string one character at a time using the for loop.

Inside the loop, to get the the individual character, use the `charAt` method of the string. 

When you subtract two characters, Java automatically computes the ASCII value difference between them. 

```java
'h' - 'e' = 3
```
For example, the character `h` - the character `e` would be `3` because the ascii values are 

`h` - 104
`e` - 101

`score += (Math.abs(diff));`

Sometimes the difference could be negative. So, use the `Math.abs` method to get the absolute value. 

That't it. By the end of the string, you accumulate all the differences values in the `score` variable. 



### #43 Count vowels in a string

```java
public class Test {
    public static void main(String[] args) {
        String input = "Hello World";
        int count = 0;

        // Convert the string to lowercase to
        // handle case insensitivity
        input = input.toLowerCase();

        // Iterate through each character
        // in the string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            // Check if the character is a vowel
            if (ch == 'a' || ch == 'e' ||
                    ch == 'i' || ch == 'o' ||
                    ch == 'u') {
                count++;
            }

        }
        System.out.println("Number of vowels: " +
                count);
    }
}
```

This question is essentially a test of your skill to traverse all the characters in a string. 

```java
int count = 0;
```
First, we create a counter to store the number of vowels. 

```java
str = str.toLowerCase();
```

Next, let's convert all the characters in the string to lower case - you will see why in a second.

```java
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);

    }
```

After that, we iterate over each character in the string. To look at a particular character we use the `charAt` function of the `String` class. 

```java
if (ch == 'a' || ch == 'e' || 
    ch == 'i' || ch == 'o' || 
    ch == 'u') {
    count++;
}
```

We compare the character with each of the vowels. We are only comparing with lower case letters. Now, you know why we have converted the string to lower case in one of the previous steps. If it's a match increase the counter. 

After the loop finishes, the counter would contain the number of vowels in the string.

### #44 Valid Anagram

This is also [LeetCode # 242](https://leetcode.com/problems/valid-anagram/description/)

```sh
alert
later
```

Two strings are `anagrams` if they contain the same characters in any order. The words **alert** and **later** are anagrams. They have the same letters `a`, `l`, `e`, `r` and `t` , just in a different order. 

```java
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String str1 = "alert";
        String str2 = "later";

        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
```


`str1` = `a`, `l`, `e`, `r`, `t`
`str2` = `l`, `a`, `t`, `e`, `r`


The idea here is to first separate the strings into their individual characters.

`str1` = `a`,`e`,`l`,`r`,`t`
`str2` = `a`,`e`,`l`,`r`,`t`

Then sort them. Now, you can compare them for equality. 


```java
if (str1.length() != str2.length()) {
    return false;
}
```
To do this in Java, first check if they are of the same length. If not, they are not anagrams. 

```java
char[] arr1 = str1.toCharArray();
char[] arr2 = str2.toCharArray();
```

Next, get the characters of each string into a character array. 

```java
Arrays.sort(arr1);
Arrays.sort(arr2);
```

To get them into order, sort these character arrays using the `sort` method of the built-in `Arrays` class. Now, all the characters are in order for both the strings. 


```java
return Arrays.equals(arr1, arr2);
```

All you have to do now is call on the `equals` method of the `Arrays` class. Think of it like a String's `equals` method. If all the sorted characters are equal, the strings are anagrams. Otherwise, not.

### #45 Defang IP Address

This is [LeetCode # 1108](https://leetcode.com/problems/defanging-an-ip-address/description/). 

A defanged IP address replaces every period `.` with `[.]`. Here is an example. 

`Input`: `1.1.1.1`
`Output`: `1[.]1[.]1[.]1`

In case you are wondering why do this, IP addresses are often defanged to prevent accidental or malicious clicking of links. 

```java
 class Test {
    public static void main(String[] args) {

        String address = "1.1.1.1";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {

            char ch = address.charAt(i);
            if (ch != '.') {
                sb.append(ch + "");
            } else {
                sb.append("[.]");
            }

        }

        System.out.println(sb);
    }
}
```

Here is how we can solve this. 

```java
String address = "1.1.1.1";
```

Say, we have an address like this in a string. 

```java
StringBuilder sb = new StringBuilder();
```

Let's create a new `StringBuilder` object that will hold the final de-fanged ip address. 

```java
 for (int i = 0; i < address.length(); i++) {

}
```

Now, loop over the ip address string one character at a time. 

```java
char ch = address.charAt(i);
if (ch != '.') {
    sb.append(ch + "");
} else {
    sb.append("[.]");
}
```

Inside the loop, we take the character, and check if it is a dot `.` character. 

1. If it not, we append it as-is to the new `StringBuilder`object. 
2. If it is, we replace the dot `.` with its defanged version `[.]`

Once the loop completes, we have the final defanged ip address in the string builder object. 

### #46 String vs StringBuilder vs StringBuffer

All of these are classes used to work with strings, but they have different usecases. Here is a comparision. 

```java
String str = "Hello";

// Creates a new String object
str = str + " World";  
```

1. Immutability

Strings are immutable. Any modification results in the creation of a new String object.

```java
StringBuffer sb = new StringBuffer("Hello");

// Modifies the existing object
sb.append(" World");  
```

```java
StringBuilder sb = new StringBuilder("Hello");

// Modifies the existing object
sb.append(" World");  
```

But, both `StringBuffer` and `StringBuilder` objects can be modified after they are created. Meaning, these objects can be changed without creating new objects.

2. Performance

```java
String str = "Hello";

// Creates a new String object
str = str + " World";  
```

Because threads are immutable, operations like concatenation create new objects, especially in loops. This makes string manipulation slow and memory intensive. 

```java
StringBuffer sb = new StringBuffer("Hello");

// Modifies the existing object
sb.append(" World");  
```

```java
StringBuilder sb = new StringBuilder("Hello");

// Modifies the existing object
sb.append(" World");  
```

`StringBuilder` and `StringBuffer` on the other hand are much faster than strings.

3. Thread Safety.

```java
String str = "Hello";

// Creates a new String object
str = str + " World";  
```

Because threads are immutable, they are thread safe by default.

```java
StringBuilder sb = new StringBuilder("Hello");

// Modifies the existing object
sb.append(" World");  
```
StringBuilder on the other hand is not thread-safe. 

```java
StringBuffer sb = new StringBuffer("Hello");

// Modifies the existing object
sb.append(" World");  
```

To counter this, Java offers the `StringBuilder` class which is synchronized and thread-safe.

4. Use Cases

```java
String str = "Hello";

// Creates a new String object
str = str + " World";  
```

Use strings when you have a fixed sequence of character that wont change.


```java
StringBuilder sb = new StringBuilder("Hello");

// Modifies the existing object
sb.append(" World");  
```

Use StringBuilder when you need to modify strings and thread safety is not an issue.

```java
StringBuffer sb = new StringBuffer("Hello");

// Modifies the existing object
sb.append(" World");  
```

Use StringBuffer when you need to modify strings in multi-threaded environment.

### #47 Jewels and Stones LeetCode #771

This is LeetCode #771. 

```java
String jewels = "aA";
String stones = "aAAbbbb";
```
You are given 2 strings. The characters in the first String are jewels and the second one are stones. Any stone can be a jewel. Your job is to figure out how many how many of these stones are jewels. 

```java
class Test {
    public static void main (String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = 0;

        // For each stone...
        for (char s: stones.toCharArray()) 

            // For each jewel...
            for (char j: jewels.toCharArray()) 

                // If the stone is a jewel...
                if (j == s) {  
                    count++;

                    // Stop searching whether this stone 's' is a jewel
                    break; 
                }
        System.out.println(count);
    }
}
```

We are going to first try the brute force approach. In video # 48, we will look at an optimized solution. 

```java
int count = 0;
```

First set a counter to 0. 

```java
// For each stone...
for (char s: stones.toCharArray()) {

}
```

Next, start to loop over each stone. 

```java
// For each jewel...
for (char j: jewels.toCharArray()) {

}
```

For each stone, we have to figure out if it is a jewel or not. To do that, we have to loop over the jewels character array. 

```java
// If the stone is a jewel...
if (j == s) {  
    count++;

    // Stop searching whether this stone 's' is a jewel
    break; 
}
```

Check if the stone is a jewel or not. If it is, increase the counter and stop searching further. If not, keep going. 

```java
// For each stone...
for (char s: stones.toCharArray()) 

    // For each jewel...
    for (char j: jewels.toCharArray()) 

        // If the stone is a jewel...
        if (j == s) {  
            count++;

            // Stop searching whether this stone 's' is a jewel
            break; 
        }
```

Loop through until all the stones are checked against the jewels. 

```java
System.out.println(count);
```

Now, the count variable should have the number of jewels. 

Remember, this is a brute force approach and in Question #48, we will look at a more optimized way of doing this. 

### #48 Jewels and Stones LeetCode #771

In Question #48, we have solved this problem using brute force approach. Now, we are going to look at a more optimized solution. 

```java
class Test {
    public static void main (String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = 0;

        // For each stone...
        for (char s: stones.toCharArray()) 

            // For each jewel...
            for (char j: jewels.toCharArray()) 

                // If the stone is a jewel...
                if (j == s) {  
                    count++;

                    // Stop searching whether this stone 's' is a jewel
                    break; 
                }
        System.out.println(count);
    }
}
```

In the brute force approach, we were sequentially checking the jewels array to figure out if each stone is a jewel or not. This sequential check is what causes the double for loop, which is computationally expensive. 

```java
import java.util.HashSet;
import java.util.Set;

class Test {
    public static void main(String[] args) {

        String jewels = "aA";
        String stones = "aAAbbbb";

        // A new hashset to hold jewels
        Set<Character> jewelHashSet = new HashSet<>();

        // Fill the hashset with jewels
        for (char j : jewels.toCharArray())
            jewelHashSet.add(j);

        int count = 0;
        for (char s : stones.toCharArray())
            if (jewelHashSet.contains(s))
                count++;
        System.out.println(count);
    }
}
```
Instead, we are going to use a `HashSet` data structure in the Java Collections library. There are two key features of a hash set.

```java
// A new hashset to hold jewels
Set<Character> jewelHashSet = new HashSet<>();

// Fill the hashset with jewels
for (char j : jewels.toCharArray())
    jewelHashSet.add(j);
```
1. There can only be one unique value in a hash set. So, let's add all unique jewels to the `HashSet` using the `add()` method. 

```java
if (jewelHashSet.contains(s))
    count++;
```

2. To check if a value exists in a hashset, you don't have to loop through it. Instead, you can just get it directly using the `contains()` method with `O(1)` complexity.

```java
for (char s : stones.toCharArray())
    if (jewelHashSet.contains(s))
        count++;
```

In essence, what we have done here is eliminated the double `for` loop. And the data structure we have used to do this is the `HashSet`.


### #49 Substrings in Word LeetCode #1967

This is LeetCode #1967. 

```java
String[] patterns = {"a","abc","bc","d"};
```

You are given an array of strings called `patterns`.

```java
String word = "abc";
```

and another string `word` say `abc`. You have to find the number of strings in `patterns` that are substrings of `abc`. 

`a` is a substring of `abc`
`abc` is a substring of `abc`
`bc` is a substing of `abc`
`d` is NOT a substring of `abc`

So, the answer is 3. 

There are a couple of ways to do this. 

```java
class Test {
    public static void main(String[] args) {

        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abc";

        int count = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                count++;
            }
        }
        System.out.println(count);

    }
}
```

1. Use the `contains()` method. Have a counter and set it to 0. Loop over the patterns array. Inside the loop, use the `contains` method to check against the word. It returns `true` if the string is a substring. Increase the counter if it is a substring.

```java
class Test {
    public static void main(String[] args) {

        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abc";

        int count = 0;
        for (String pattern : patterns) {
            if (word.indexOf(pattern) != -1) {
                count++;
            }
        }
        System.out.println(count);

    }
}
```

2. Use the `indexOf()` method which returns the index of the first occurrence of the substring. If it is not a substring, `indexOf` returns -1. So, if it is not -1, increase the counter. 

```java
String[] patterns = { "a", "abc", "bc", "d" };
String word = "abc";
```
The time complexity of this is `O(m*n)` where `m` is the number of patterns and `n` is the length of the word. 

### #50 Remove Training Zeros from String - LeetCode #1967

```java
String num = "51230100";
```

This is LeetCode #1967. We are given a number as a string. We should chop off all the trailing zeros and return the remaining part of the number.

+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 | | 0 | | 0 |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+

For example, in this case, there are two trailing zeros.

+---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 |
+---+ +---+ +---+ +---+ +---+ +---+

Chop off the last zeros and just return 512301. 

```java
int len = num.length();
```

First, get the length of the string. 

```java
for (int i = len - 1; i >= 0; i--) {

}
```

Start loop from the end of the string.

```java
if (num.charAt(i) != '0') {
    System.out.println(num.substring(0, i + 1));
    System.exit(0);
}
```

Check if the character is zero or not. To do that, we use the string functions `charAt()` method to get the `i`th character in the string. If the character is zero, continue the loop. The moment, the character is not zero, that's the point we want to stop.

                                            |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 | | 0 | | 0 |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+

For example, we start here, at this character. Since it is zero, we continue backwards in the loop. 

                                      |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 | | 0 | | 0 |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+

The next character is also zero, so we continue further in the loop. 

                                |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 | | 0 | | 0 |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+

Finally, we have hit a non-zero number. 

        Extract this substring
|-------------------------------|
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+
| 5 | | 1 | | 2 | | 3 | | 0 | | 1 | | 0 | | 0 |
+---+ +---+ +---+ +---+ +---+ +---+ +---+ +---+

Since `i` holds the index of the first non-zero character from the end, backwards, all we have to do now is get a substring from index `0` to `i+1`. 

### #51 Default Constructor Overloading

```java
class Example {
    int x;

    // If we don't provide a default
    // constructor, Java will do it for us
    Example() {
    }
}
```
We know that if we don't provide a default constructor, Java will do it for us. 

```java
class Example {
    int x;

    Example(int i) {
        x = i;
    }
}
```

But, what happens if you overload a constructor, but don't provide a no-argument constructor ? For example, in this class, we have a parameterized constructor, but we have not provided a default constructor. 

```java
class Test {

    public static void main(String[] args) {

        // Compilation Error
        Example obj = new Example();

    }
}
```

If we try to instantiate this class with a default constructor, Java throws a compile time error. So, the moral of the story is, if we define any constructor in our Java class, the compiler will not automatically generate a default constructor for us. We must have to declare it explicitly. 

### #52 Constructor Chaining

```java
class Test {

    int i;

    public Test() {
        this(0);
        System.out.println("Default Constructor");
    }

    public Test(int i) {
        this.i = i;
        System.out.println("Parameterized Constructor");

    }

    public static void main(String[] args) {

        Test test = new Test();

    }
}
```

Can we call one constructor from another ?

```java
this(0);
```

Is this even valid ? Yes it is. It is called `Constructor Chaining`. 

```java
int i;

public Test(int i) {
    this.i = i;
    System.out.println("Parameterized Constructor");

}   
```
Here, we have an instance variable `i`. 

```java
Test test = new Test();
```
If we are not using the parameterized constructor, say we want to default `i` to `0`. How would we do it ?

```java
int i;

public Test() {
    this(0);
    System.out.println("Default Constructor");
}
```

Simple, have a new default constructor and call the other constructor using the `this` keyword. 

```java
public Test(int i) {
    System.out.println("Parameterized Constructor");
    this.i = i;
}
```

Let's check this out. Put a print statement in the parameterized constructor and let's see if Java calls this from the default constructor using the this keyword. 

```sh
Parameterized Constructor
Default Constructor
```

As you can see from the output, Java first calls the default constructor, which in turn calls the parameterized constructor to initialize the variable `i` to `0`.

In case you are wondering Why is it used, it essentially helps in code reuse and reducing redundancy.


### #53 Constructor Chaining with Superclass

```java
class Test {

    int i;

    public Test() {
        this(0);
    }

    public Test(int i) {
        this.i = i;
    }

    public static void main(String[] args) {

        Test test = new Test();

    }
}
```

In Question #52, we have seen what is `Constructor Chaining`. It is just calling one constructor from another. We have see an example of calling one constructor from another with in the same class using the `this` keyword. 

But, whaþ if we want to call a parent class' constructor ? Can we do it ? Yes ofcourse we can. The only difference is that, instead of the `this` keyword, we have to use the `super` keyword.

```java
class Parent {
    public Parent() {
    }

    public Parent(String msg) {
    }
}
```

Say, we have a `Parent` class with two constructors. 

```java
class Child extends Parent {
    public Child() {
    }
}
```

And, we have a `Child` class that extends the `Parent` class.

```java
class Child extends Parent {
    public Child() {
        super("Called from Child");
    }
}
```

To call the parent's constructor, just call it using the `super` keyword. 

```java
class Parent {
    public Parent() {
        System.out.println("Parent default constructor");
    }

    public Parent(String msg) {
        System.out.println("Parent parameterized constructor: " + msg);
    }
}

class Child extends Parent {
    public Child() {
         // Calls the parameterized constructor of Parent
        super("Called from Child");
        System.out.println("Child default constructor");
    }
}

public class Main {
    public static void main(String[] args) {
        Child obj = new Child();
    }
}
```

Here is the full example.  


```sh
Parent parameterized constructor: Called from Child
Child default constructor
```

The `Child` class is instantiated using it's constructor and in the constructor of the child class, we are calling the parent class' constructor using the `super` keyword. That's why, you see the output from the `Parent` class first and then the `Child` class.


### #54 Private Constructor

```java
class Animal {
    Animal() {

    }
}

public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
    }
}
```
We know that a constructor is used when creating an object from a class. 

```java
class Animal {
    Animal() {

    }
}
```

By default, a constructor is `public`. 

```java
public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
    }
}
```

And that's why we are able to call it when creating a new object. 

```java
class Animal {
    private Animal() {

    }
}
```

But, what happens when you make the constructor private ? 

```java
public class Test {
    public static void main(String[] args) {
        Animal a = new Animal();
    }
}
```

Will you be able to create a new object ? No, the compiler immediately complains that the constructor is not visible. Makes sense, right ? But, what is the point in making the constructor private when it prevents you from creating a new object out of the class ?


- `Singleton Pattern`
- `Utility Classes`
- `Factory Pattern`
- `Immutable Classes`
- `Preventing Subclassing`

There are atleast 5 reasons why constructors are made private. Let's just take one example - Utility Classes.

```java
public class Test {
    public static void main(String[] args) {
        int max = Math.max(1, 2);
    }
}
```

When using any of the `Math` class' methods, do we create the object out of it first and then use it ? No, right ? 

```java
public final class Math {

    // Private constructor prevents instantiation
    private Math() {}
    
    // Various static methods like 
    //abs, sqrt, sin, cos, etc.
}
```

This is because the `Math` class has a private constructor. Java doesn't want you to create an Math object. 

```java
public final class Math {

    // Private constructor prevents instantiation
    private Math() {}
    
    public static max(int i, int j){
        // implementation 
    }
}
```

Instead, all the usable methods in it like `max`, `min`, `abs` are all defined as `public` and `static`. 

```java
int max = Math.max(1, 2);
```

And that's why we are able to instantiate it directly using the class name itself. 

### #55 Constructors with return type

```java
class Example {
    Example() {
        System.out.println("Constructor called");
    }
}

public class Test {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.Example();
    }
}
```

Whenever you declare a constructor, you don't put a return type. A constructor is just supposed to initialize a class and not return anything. 

```java
void Example() {
    System.out.println("Method called");
}
```

But, what if you specify a return type ? Can you still call it a constructor ? The answer is NO. 

```java
// This is not a constructor, just a method
// with the same name as the class
void Example() {
    System.out.println("Method called");
}
```

When you specify a return type, the constructor is deemed by Java as just another method - not a constructor. Just remember, constructors don't have a return type. Not even `void`. 


### #56 Default Constructor in a Parent Class

```java
class Parent {
    Parent(int x) {
    }
}

class Child extends Parent {
    Child() {
    }
}

public class Test {
    public static void main(String[] args) {
        Child obj = new Child();
    }
}
```

Here, we have a `Child` class that inherits from a `Parent` class. 

```java
Child obj = new Child();
```
We are trying to instantiate the `Child` class using the default constructor. Does this work ? No, it does not. Here is why.

```java
class Parent {
    Parent(int x) {
    }
}
```

The parent class does NOT have a default constructor. It only has a parameterized constructor. 

```java
class Child extends Parent {
    Child() {
    }
}
```
When the child class is called with it's default constructor, Java by default also invokes the parent class' default constructor.

```java
class Parent {
    Parent(int x) {
    }
}
```
In this case, the parent does NOT have a default constructor. Java compiler identifies this and throws an error. 

```java
class Parent {
    Parent() {
    }

    Parent(int x) {
    }
}
```
To fix this, have a default constructor in the parent as well. 

```java
class Parent {
    Parent(){ // <-- Called automatically
    }

    Parent(int x) {
    }
}

class Child extends Parent {
    Child() {  // <--
    }
}

public class Test {
    public static void main(String[] args) {
        Child obj = new Child();  // <--
    }
}
```

The key point to understand is that when a child class` default constructor is called, Java automatically calls the default constructor of the parent class as well. 

### #57 Default Constructor in a Parent Class













