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

To counter this, Java offers the `StringBuffer` class which is synchronized and thread-safe.

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

### #50 Remove Training Zeros from String - LeetCode #2710

```java
String num = "51230100";
```

This is LeetCode #2710. We are given a number as a string. We should chop off all the trailing zeros and return the remaining part of the number.

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

### #51 What is a Class in Java

+-------------------------+
|        MyClass          |  <-- Class Name
+-------------------------+
| - attribute1: int       |  <-- Attribute
| - attribute2: String    |  
+-------------------------+
| + method1(): void       |  <-- Method
| + method2(): int        |
+-------------------------+

This is probably the most basic questions in Java. A class in Java is a blueprint for creating objects. In general, It has 3 things

1. A class name
2. Attributes that represent properties of the object
3. Methods that represent behaviours of the object. 

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    double getBalance() {
        return balance;
    }
}
```

For example, if you wanted to create a Bank account class, here is how you would start

```java
class BankAccount {
}
```
1. Start with a name and to specify that it is a class use the `class` keyword. 


```java
// Attributes
String name;
int number;
double balance;
```

2. Every bank account has say a name, account number and balance. We define them as `attributes` using the required data types - like `String`, `int` or `double`. 

```java
// Method to deposit money
void deposit(double amount) {
    balance += amount;
}

// Method to check the balance
double getBalance() {
    return balance;
}
```

3. What are the actions you do on the bank account ? You deposit money, get the balance in the account and so on, right ? Define them as `methods`. 

That's all there is to a class. Just remember the 3 key things

1. Declare the class using the `class` keyword with a name.
2. Define it's properties using `Attributes` and
3. Define it's behaviour using `Methods`

### #52 What is an Object in Java

In question #51, we have seen what a `class` is. An object is an instance of a class. Think of `class` as a blueprint and `object` as a real version of the class. 

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    double getBalance() {
        return balance;
    }
}
```
Let's create an `object` from the `BankAccount` class we have seen in question #51. 

```java
public static void main(String[] args) {
    BankAccount account = new BankAccount();
}
```

To do that, we have to use the `new` keyword along with the class name. Here `BankAccount` is the class name and `account` is an object of class `BankAccount`. Don't worry about the statement `public static void main` - We will talk about it later. For now, just put it in.

```java
public static void main(String[] args) {
    BankAccount account = new BankAccount();
    account.name = "CampusHire";
    account.number = 123;
    account.balance = 0;

    account.deposit(100);
    System.out.println(account.getBalance());
}
```

Using the `new` keyword, Java gives life to a new object of type `BankAccount` class. Once we have the object, we can start to fill it in. Like, give it a name, number and balance. You access its properties using the `.` operator. 

```java
public static void main(String[] args) {
    BankAccount account = new BankAccount();
    account.name = "CampusHire";
    account.number = 123;
    account.balance = 0;

    account.deposit(100);
    System.out.println(account.getBalance());
}
```

You can now access it's behaviours using its methods. For example, we deposit 100 rupees into the account object. And use the getBalance() method to get thee account balance. 

### #53 What is a Java Constructor

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    double getBalance() {
        return balance;
    }
}
```

In Question #51 and #52, we have seen what classes and objects are using the `BankAccount` example. 

```java
BankAccount account = new BankAccount();
```

We have created a new `BankAccount` object using the `new` keyword and specifying the class name with paranthesis. Java then constructs a new object on the heap and assigns it to the variable `account. 

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    BankAccount(){
        System.out.println("object initialized");
    }

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    double getBalance() {
        return balance;
    }
}
```

But, before doing that, Java calls a special method called the `constructor`. Think of it as an initializer. 


```java
public static void main(String[] args) {
    BankAccount account = new BankAccount();
}
```

When you create a new `BankAccount` object, you can see that the print statement in the constructor is called automatically.

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    BankAccount(double balance){
        this.balance = balance;        
    }

    // Method to deposit money
    void deposit(double amount) {
        balance += amount;
    }

    // Method to check the balance
    double getBalance() {
        return balance;
    }
}
```

You can do some initialization activities here. For example, say everytime a new account is created, it is mandatory to create it with a non-zero balance. You can create the constructor with an balance variable that is used to initialize the account balance. 

```java
public static void main(String[] args) {
    BankAccount account = new BankAccount(100);
}
```

And here is how you create the BankAccount class with a balance of 100 rupees. 


### #54 Types of Constructors

There are 2 types of constructors in Java. 

1. Default Constructor
2. Paremeterized Constructor

We have already seen examples of these in Question #53. 

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    BankAccount(){
        System.out.println("object initialized");
    }
}
```

This is an example of a default constructor. It does not have any arguments. If you don't provide it, Java automatically creates one for you, right at the time of compilation.

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    BankAccount(double balance){
        this.balance = balance;        
    }
}
```

When you specify a parameter to the constructor, it is called as a `parameterized` constructor. You can provide more than one parameter. 


```java
public static void main(String[] args) {
    BankAccount account = new BankAccount(100);
}
```

The purpose of these parameters is to provide flexibility in the way the new objects are created.


### #55 Constructor Overloading 

```java
class BankAccount {

    // Attributes
    String name;
    int number;
    double balance;

    BankAccount(){
        System.out.println("object initialized");
    }

    BankAccount(int balance){
        this.balance = balance;
    }

    BankAccount(String name){
        this.name = name;
    }

}
```

If a java class has has more than one constructor, each having either a different number of parameters or different types of parameters it is called Constructor Overloading. Any of these constructors can be used to create an object of this class. 

```java
public static void main(String[] args) {

    // Using the default constructor
    BankAccount account1 = new BankAccount();

    // Using the parameterized constructor 1
    BankAccount account2 = new BankAccount(100);

    // Using the parameterized constructor 2
    BankAccount account3 = new BankAccount("Campushire");

}
```

For example, 

- the object `account1` is created using the default constructor. 
- the object `account2` is created using the first parameterized constructor which uses the balance parameter.
- the object `account3` is created using the second parameterized constructor which uses the name parameter. 

In case you are wondering why have so many ways of creating a new `BankAccount` object, it is to provide flexibility in initializing objects with various types of data.

The key points to understand when overloading constructors is

1. **Same Name** - All constructors have the same name, which is the class name.
2. **Different parameters** - Each constructor has a different signature. Meaning, it should have a different number, type, or order of parameters


### #56 Default Constructor Overloading

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

### #57 What is Constructor Chaining

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


### #58 Constructor Chaining with Superclass

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


### #59 Why are Private Constructors used

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

### #60 Can Constructors have a return type

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


### #61 Default Constructor in a Parent Class

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

### #62 Constructor Delegation

```java
class Dog {
    String name;

    // Default Constructor
    public Dog () {
        // Delegating to the parameterized Constructor
        this("Sunny");
    }

    // Constructor in Dog with name
    public Dog(String name) {
        this.name = name;
    }
}
```

In Question #57, we have seen "Constructor Chaining". When you call one constructor from another, we call it constructor chaining. This can be done within the class using the `this` keyword.


```java
class Animal {
    String type;

    public Animal(String type) {
        this.type = type;
    }
}

class Dog extends Animal {
    String name;

    // Constructor in Dog
    public Dog(String name, String type) {

        // Calls the constructor of Animal (superclass)
        super(type); 
        this.name = name;
    }
}

```

or you can call the super class' constructor using the `super` keyword. In general this concept is called `Constructor Chaining`. 

```java
class Dog {
    String name;

    // Default Constructor
    public Dog () {
        // Delegating to the parameterized Constructor
        this("Sunny");
    }

    // Constructor in Dog with name
    public Dog(String name) {
        this.name = name;
    }
}
```

When you do `Constructor Chaining` specifically within the class using the `this` keyword, it is also called `Constructor Delegation`. For example, here, we have a `Dog` class which has a `name` parameter. We have 2 constructors. 

```java
// Default Constructor
public Dog () {
    // Delegating to the parameterized Constructor
    this("Sunny");
}
```
A default constructor which is called without any parameters. In case, the default constructor is called, we want the default dog name to be `Sunny`. 


```java
// Constructor in Dog with name
public Dog(String name) {
    this.name = name;
}
```

Since we already have a parameterized constructor that can initialize the dog's name


```java
// Default Constructor
public Dog () {
    // Delegating to the parameterized Constructor
    this("Sunny");
}
```
we can call the parameterized constructor from the default constructor using the `this` keyword and pass the `name` value as a parameter.

In case you are wondering why do this, Constructor delegation helps avoid repeating the same setup code in different constructors by allowing one constructor to call another.

### #63 Can a constructor be final, static, or abstract

```java
class Test {

    // Not Allowed
    final Test(){

    }

    // Not allowed
    static Test(){

    }

    // Not Allowed
    abstract Test(){
        
    }
}
```

No. None of these keywords are allowed for constructors in Java. Let's see why.

```java
class Test {

    // Not Allowed
    final Test(){

    }

}
```

Let's start with the first keyword - `final`. The `final` keyword is used to prevent a method from being overridden in subclasses. However, constructors are not inherited by subclasses, so the concept of a final constructor does not apply.


```java
class Test {

    // Not allowed
    static Test(){

    }

}
```

Next, we have the `static` keyword. A constructor sets up an object when it's created, while `static` things apply to the class as a whole, not to individual objects. Having a `static` constructor would be confusing because it would try to set up the class itself, which isn't the purpose of a constructor. So, `static` keyword is a no-no for constructors.


```java
class Test {

    // Not allowed
    abstract Test(){

    }

}
```

Finally, we have the `abstract` keyword. The `abstract` keyword means that a method or class must be completed by a subclass. However, constructors are for creating objects, and you can’t create objects of an abstract class. So, having an `abstract` constructor doesn’t make sense.

In summary, a constructor can be neither `final` nor `static`, nor `abstract`.

### #64 Can you inherit constructors

```java
class Parent {
    String name;
    String getName(){
        return name;
    }

    public Parent() {

    }

    // Constructor in Parent
    public Parent(String name) {
        this.name = name;
    }

}

class Child extends Parent {
    int age;

    // Constructor in Child
    public Child(String name) {
        this.age = age;
    }

}
```

When you inherit one class from another, we know that all 

```java
String name;
```
non-private instance variables and 

```java
String getName(){
    return name;
}
```all non-private methods are inherited from the parent class to the child class. 

```java
public Parent() {

}

// Constructor in Parent
public Parent(String name) {
    this.name = name;
}
```

But, what about constructors ? Are constructors inherited too ? No. Constructors are not inherited to the child class. Each class must define its own constructors.

```java
class Parent {
    String name;

    // Constructor in Parent
    public Parent(String name) {
        this.name = name;
    }
}

class Child extends Parent {
    int age;

    // Constructor in Child
    public Child(String name, int age) {

        // Calls the constructor of Parent
        super(name); 
        this.age = age;
    }
}
```

However, you can call the constructor in the parent class from the child class using the `super` method. This is necessary to properly initialize the inherited fields from the superclass.

In this example:

- The `Child` class calls the `Parent` class's constructor using `super` keyword to set up the `name` field inherited from `Parent`.
- The `Child` constructor initializes its own `age` field.

### #65 4 pillars of OOPS

1. `Encapsulation`
2. `Inheritance`
3. `Polymorphism`
4. `Abstraction`

These are the 4 pillars of OOPS. They are called "pillars" because they represent the fundamental principles upon which Object Oriented Programming is built.

```java
public class Person {
    // Private field
    private String name; 

    // Public getter method
    public String getName() {
        return name;
    }

    // Public setter method
    public void setName(String name) {
        this.name = name;
    }
}
```
1. `Encapsulation` - In the `Person` class, the `name` field is declared as `private`.  meaning it cannot be accessed directly from outside the Person class. This is a key aspect of encapsulation, which hides the internal state of the object from outside interference and misuse.

```java
public class Animal {
    public void eat() {
        System.out.println("This animal eats.");
    }
}

public class Dog extends Animal {
    public void bark() {
        System.out.println("The dog barks.");
    }
}
```

2. `Inheritance` - Inheritance is the mechanism by which one class can inherit the properties and methods of another class. In this code, the `Dog` class inherits the `eat()` method from the `Animal` class, meaning it can use that method without defining it again.

```java
public class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}
```


3. `Polymorphism` - Polymorphism provides flexibility and the ability to perform a single action in different ways, depending on the context. The `makeSound()` method in the Dog class overrides the method in the Animal class

```java
abstract class Shape {
    // Abstract method, must be implemented by subclasses
    abstract void draw(); 
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}
```

4. `Abstraction` - Finally, `Abstraction` is the concept of hiding the complex implementation details of a system and exposing only the necessary and relevant parts. Here, the `Shape` class defines an abstract method `draw()`, without providing its implementation. The `Circle` class provides the specific implementation of `draw()` method.

### #66 What is Encapsulation

```java
public class Person {
     
    // Private variables to restrict direct access
    private String name;
    private int age;

    // Public getter method to access the name
    public String getName() {
        return name;
    }

    // Public setter method to modify the name
    public void setName(String name) {
        this.name = name;
    }

    // Public getter method to access the age
    public int getAge() {
        return age;
    }

    // Public setter method to modify the age
    public void setAge(int age) {
        this.age = age;
    }
}
```

Encapsulation in Java is the concept of wrapping data or variables and methods into a single unit called a class. This is achieved using 2 things.

```java
// Private variables to restrict direct access
private String name;
private int age;
```
1. **Data Hiding** : This is done by declaring variables as private. For example, in this class, the `name` and `age` variables are private. Think of them as the internal state of the object. They can't be accessed directly from outside the `Person` class. This is Data Hiding.

```java
// Public getter method to access the name
public String getName() {
    return name;
}

// Public setter method to modify the name
public void setName(String name) {
    this.name = name;
}

// Public getter method to access the age
public int getAge() {
    return age;
}

// Public setter method to modify the age
public void setAge(int age) {
    if (age > 0) { // Validation to ensure age is positive
        this.age = age;
    } else {
        System.out.println("Age must be positive.");
    }
}
```

2. **Controlled Access** : Public getter and setter methods are used to access and update the private variables. The methods `getName()`, `setName()`, `getAge()`, and `setAge()` are public methods that allow controlled access to the private variables. This means you can read and modify the data in a controlled manner. This is Controlled Acccess.




```java
// Public setter method to modify the age
public void setAge(int age) {
    if (age > 0) { // Validation to ensure age is positive
        this.age = age;
    } else {
        System.out.println("Age must be positive.");
    }
}
```


### #67 What is Inheritance



+------------------+
|     Animal       |
+------------------+
| - name: String   |
+------------------+
| + makeSound()    |
+------------------+
        ^
        |
        |
+------------------+
|       Dog        |
+------------------+
| - name : String  | <- inherited from parent class
+------------------+
| + makeSound()    | <- inherited from the parent class
+------------------+

Inheritance in Java is a mechanism that allows one class to inherit the fields and methods of another class. It basically creates a parent-child relationship between classes. Here `Animal` is the parent class and `Dog` is the child class which inherits properties and methods from the `Animal` class.

```java
// Base class
public class Animal {
    // Field
    String name;

    // Constructor
    public Animal(String name) {
        this.name = name;
    }

    // Method
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}
```

Let's create the base or parent class called `Animal`. It has a field `name`, and a method `makeSound`(). 

```java
// Derived class
public class Dog extends Animal {

    // `name` field is inherited from the Animal class

    // `makeSound` method is also inherited

    // Constructor
    public Dog(String name) {
        // Call the constructor of the base class
        super(name); 
    }

}
```

We have a derived or child class called `Dog`, which  extends the `Animal` class, inheriting its fields and methods. For example, the `name` field and the `makeSound` method is inherited from the parent class.


```java
// Overriding the method from the base class
@Override
public void makeSound() {
    System.out.println("Bark");
}
```
The child class is ofcourse free to override any methods from the parent class. For example, if you add the same makeSound method to the child class, the inherited method from the parent class is overridden. The `@Override` annotation is optional. As long as the method class in the parent and child class match, the child class' method automatically overrides the parent class's implementation. 

```java

// New method specific to Dog
public void fetch() {
    System.out.println("Fetching the ball...");
}
```

The child class is ofcourse not limited to the methods inherited from the parent class. For example, you can add a new method, `fetch()`, which is specific to the `Dog` class.

### #68 What is Compile time Polymorphism

+--------------------------+
|      Calculator          |      <--- Class
+--------------------------+
| - add(int a, int b)      |      <--- Overloaded Method 1
| - add(double a, double b)|      <--- Overloaded Method 2
+--------------------------+
            |
    -----------------
    |               |
+------------+     +----------------+
| add(5, 10) |     | add(5.0, 10.0) |
+------------+     +----------------+
      |               |
    Output: 15     Output: 15.0     <--- Different behavior based on argument types


Compile-time Polymorphism is also called `method overloading`. 

The Calculator class has two overloaded methods called `add()`, but they have different parameters - one for integers and one for doubles. When you call `add(5, 10)`, it chooses the version that takes `int` parameters, and for `add(5.0, 10.0)`, it uses the version that accepts `double` parameters. This is resolved at compile time because the compiler determines which method to invoke based on the method signatures and argument types.

```java
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));  // Calls int version
        System.out.println(calc.add(5.0, 10.0));  // Calls double version
    }
}
```

Let's see an this in java.

```java
public int add(int a, int b) {
    return a + b;
}

public double add(double a, double b) {
    return a + b;
}
```

We have 2 `add()` methods. The first one takes `int` parameters and the second one takes `double` parameters. 

```java

// Calls int version
System.out.println(calc.add(5, 10));  

// Calls double version
System.out.println(calc.add(5.0, 10.0));  
```

When we call the `add()` method with integers it calls the `int` version and when we call the add method with `double` data types, it calls the `double` version of the add class. 

In summary, `Method Overloading` or `Compile Time polymorphism` happens when multiple methods have the same name but different parameters like type, number, or both in the same class.

### #69 What is Run-time Polymorphism

Run-time Polymorphism is also called `Method Overeriding`. 

        +-------------------+
        |     Animal        |        <--- Base Class (Parent)
        +-------------------+
        | - makeSound()     |        <--- General Method (Parent's behavior)
        +-------------------+
                  |
        -------------------------
        |                       |
+-------------------+   +-------------------+
|       Dog         |   |       Cat         |     <--- Derived Classes (Children)
+-------------------+   +-------------------+
| - makeSound()     |   | - makeSound()     |     <--- Overridden Method
+-------------------+   +-------------------+
        |                       |
     Bark!                  Meow!            <--- Different Behaviors (Polymorphism in action)

The `Animal` class is the parent class, and it has a method called `makeSound()`. The `Dog` and `Cat` classes inherit from `Animal` and override the `makeSound()` method, each providing their own implementation (Bark! for Dog and Meow! for Cat). This is called run-time polymorphism where the behavior depends on the actual object - `Dog` or `Cat` - that calls the method. Let's see this in Java.

```java
class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

public class Main {
    public static void main(String[] args) {

        // Reference of type Animal, but actual object is Dog
        Animal myDog = new Dog();  

        // Output: "Bark"
        myDog.makeSound();  
    }
}
```

Here, the reference type is `Animal`, but the actual object is of type `Dog`. During runtime, Java determines that the Dog's version of `makeSound()` should be called. That's why the output is `Bark` instead of `Meow`.

In summary, Method Overriding or run-time polymorphism occurs when a subclass provides a specific implementation of a method that is already defined in its superclass. At runtime, the actual method is chosen depending on the object calling it. 


### #70 What is Abstraction with Abstract Classes

There are two ways to achieve abstraction in Java. 

- Abstract Classes
- Interfaces

In this video, we will use Abstract Classes. In the next video, we will use Interfaces. 

```java
abstract class Vehicle {
    // Abstract method (no implementation)
    abstract void move();
}
```

Abstraction in Java is the process of hiding the implementation details of a system and only exposing the essential features or functionalities to the user. For example, here is an abstract class called `Vehicle`. It has an abstract method called `move()` which does not have an implementation. 

```java
class Car extends Vehicle {
    // Implementing the abstract method
    @Override
    void move() {
        System.out.println("Car is moving...");
    }
}
```

If you want to use the `Vehicle` abstract class, extend it into another class say `Car` and implement the abstract methods in it. 

```java
public class Main {
    public static void main(String[] args) {
        Vehicle myCar = new Car();  // Can refer to abstract class, but instantiate subclass
        myCar.move();               // Output: Car is moving...
    }
}
```

You can now instantiate the `Car` class and call the `move()` method. 

```java
abstract class Vehicle {
    // Abstract method (no implementation)
    abstract void move();
}
```

In summary, Abstract classes are used when you want to define a common template for its subclasses, leaving some methods to be implemented by those subclasses. Here the `Vehicle` class defines the common template for all subclasses that inherit it. Subclasses like `Car` or `Van` do the actual implementation. 

### #71 What is Abstraction with Interfaces

In #69, we have seen how to achieve Abstraction with Abstract classes. In this video, we will see it with Interfaces. 


```java
interface Animal {
    void makeSound();  // Abstract method
}
```

An interface is a reference type in Java that can contain only `method signatures` or `abstract methods`. It does not have any implementation details. For example, this interface `Animal` has a method signature - `makeSound`. But it does not have the implementation details. 

```java
class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
```
To be able to actually use this `Animal` interface, implement it in a class using the `implements` keyword and provide an implementation for all the signature methods in the interface. 

In summary, you can use Interfaces in Java provide to achieve abstraction. The implementation details are left to the concrete classes, making the interface itself purely abstract.

### #72 Inheritance vs Polymorphism

These are 2 out of the 4 pillars of Object Oriented Programming. We have discussed Inheritance in #66 and Polymorphism in #67 and #68. In this question, we will understand the differences between Inheritance and Polymorphism, specifically run-time polymorphism. 

            +-------------------+
            |     Animal        |        <--- Base Class (Parent)
            +-------------------+
            |  + makeSound()    |        <--- Common Method
            +-------------------+
                  |
        -------------------------
        |                       |
+-------------------+     +-------------------+
|       Dog         |     |       Cat         |     <--- Derived Classes (Children)
+-------------------+     +-------------------+
|  - makeSound()    |     |  - makeSound()    |     <--- Inherits from Animal class
+-------------------+     +-------------------+

Say we have a parent class `Animal` which has the `makeSound()` method. When the child classes - `Dog` and `Cat` extend the parent class `Animal`, they automatically inherit the `makeSound()` method. This act of inheriting variables and methods from the parent class is called inheritance. 

        +-------------------+
        |     Animal        |        <--- Base Class (Parent)
        +-------------------+
        | + makeSound()     |        <--- General Method (Parent's behavior)
        +-------------------+
                  |
        -------------------------
        |                       |
+-------------------+   +-------------------+
|       Dog         |   |       Cat         |     <--- Derived Classes (Children)
+-------------------+   +-------------------+
| - makeSound()     |   | - makeSound()     |     <--- Overridden Method
+-------------------+   +-------------------+
        |                       |
     Bark!                  Meow!            <--- Different Behaviors (Polymorphism in action)

Let's see polymorphism now. Let's take the same `Animal` class and say it has a `makeSound()` method. When the `Dog` and `Cat` classes inherit from this class, they automatically inherit the `makeSound()` method. However, the child classes can override the inherited `makeSound()` method by defining their own implementations - For example, the `Dog` class makes a sound of Bark and the `Cat` class makes a sound of Meow. The fact that child classes can override the inherited behaviours by defining their own behaviours is called Polymorphism.


### #73 Abstraction vs Encapsulation

Abstraction and Encapsulation are two of the pillars of Object Oriented Programming, but they serve different purposes.

```java
abstract class Animal {
    abstract void sound(); // Abstract method
}
```

Let's talk about Abstraction first. Abstraction is the process of hiding complex implementation details and showing only the necessary features of an object. It focuses on what an object does rather than how it does it. For example, the `Animal` class here is declared as `abstract`. This means you cannot create an object of `Animal` directly. The method `sound()` is declared as `abstract` in the `Animal` class.

```java
class Dog extends Animal {
    void sound() {
        System.out.println("Barks");
    }
}
```

The `Dog` class extends the `Animal` class and provides the actual implementation of the `sound()` method. 

```java
abstract class Animal {
    // Private variable - not accessible outside this class
    private String name; 
    
    // Constructor to initialize name
    public Animal(String name) {
        this.name = name;
    }
    
    // Public getter method to access the private variable
    public String getName() {
        return name;
    }

    // Public setter method to modify the private variable
    public void setName(String name) {
        this.name = name;
    }

    // Abstract method - still for abstraction
    abstract void sound();
}
```

Next let's talk about Encapsulation. Encapsulation is about restricting direct access to an object's data and allowing controlled access. This is achieved through two things. 

1. Private Data - the `name` field is private. This is a key principle of encapsulation: hiding the internal state.
2. Getter and Setter Methods - The getter and setter methods act as controlled access points to the private data.


### #74 Is Multiple Inheritance allowed


      Animal
        /\
       /  \
   Mammal  Bird
     \      /
      \    /
       \  /
       Dog


Java does support multiple inheritance but not with classes. To understand why, we have to understand the `Diamond Problem`. 

Here `Animal` is the base class and both the `Mammal` and `Bird` classes inherit from the `Animal` class. `Dog` inherits from both `Mammal` and `Bird`.

       Animal
      /      \
     /        \
makeSound()  makeSound() 
   /             \
  /               \
Mammal           Bird
  \               /
   \             /
    \           /
     \         /
      \       / 
         Dog
     makeSound()

In the `Dog` class, it becomes ambiguous which `makeSound()` method `Dog` should use, as both `Mammal` and `Bird` are contributing their own versions of `makeSound()`. This is why multiple inheritance is not allowed in Java with classes. 

```java
// Define the interfaces
interface Animal {
    void makeSound();
}

interface Mammal extends Animal {
    // Inherits makeSound() from Animal
}

interface Bird extends Animal {
    // Inherits makeSound() from Animal
}

// Implementing the interfaces in a class
class Dog implements Mammal, Bird {
    @Override
    public void makeSound() {
        System.out.println("Dog sound");
    }
}
```

However, Java supports multiple inheritance with interfaces. Instead of declaring `Animal`, `Mammal` and `Bird` as classes, use interfaces. Since there are no implementations of the methods either in the `Mammal` or `Bird` class, we can happily implement both the interfaces in the `Dog` class and override the implementation in the `Dog` class without any fear of the `Diamond problem`. 

### #75 Default methods in an Interface

```java
public interface Animal {

    // Default method
    default void makeSound() {
        System.out.println("Some generic animal sound");
    }
    
    // Abstract method
    void eat();

}
```
Starting with Java 8, an Interface can have default methods. Use the `default` keyword to declare a default method. 

```java
public class Dog implements Animal {

    // Optionally override the default method
    @Override
    public void makeSound() {
        System.out.println("Woof Woof");
    }

}
```

The Dog class implements the Animal class. It gets the default implementation of the makeSound() method by default. However, you can override it and provide your own implementation of the makeSound() class in the Dog class. 

One of the main uses of default methods in Interfaces is Backwards compatibility. Let'see this with an example. 

            +-----------------+
            |    Animal       |   <--- Interface
            |-----------------|
            |     + eat()     |   <--- Abstract Method
            +-----------------+
                    ^
                    |
      +-------------+-------------+
      |             |             |
+-----------+   +-----------+   +-----------+
|    Dog    |   |    Cat    |   |   Tiger   |  <--- Subclasses
|-----------|   |-----------|   |-----------|
| + eat()   |   | + eat()   |   | + eat()   |
+-----------+   +-----------+   +-----------+

Say you have an `Animal` Interface with an abstract `eat()` method. There are 3 subclasses that implement the `Animal` interface. Each of these subclasses are forced to provide an implemention of the the `eat()` method. So far so good. 

            +-----------------+
            |    Animal       |   <--- Interface
            |-----------------|
            |     + eat()     |   <--- Abstract Method
            |     + drink()   |   <--- New Abstract Method added
            +-----------------+
                    ^
                    |
      +-------------+-------------+
      |             |             |
+-----------+   +-----------+   +-----------+
|    Dog    |   |    Cat    |   |   Tiger   |  <--- Subclasses
|-----------|   |-----------|   |-----------|
| + eat()   |   | + eat()   |   | + eat()   |
+-----------+   +-----------+   +-----------+

Now, what happens when you add a new method ? say `drink()` ? All the subclasses are now forced to implement the `drink()` method. This means that all the classes that implement the `Animal` interface need to be changed. 

To avoid this, Java 8 onwards, Interfaces can have `default` methods that need not be implemented by subclasses. If you want, you can override though. 

### #76 Interfaces vs Abstract Classes

```java

public interface Animal {

    // Abstract method
    void eat();

    // Abstract method
    void makeSound();
}
```

Interfaces are purely Abstract. They only contain the method declarations - atleast prior to Java 8. Basically, it represents a contract that the implementing classes should implement.


```java
public abstract Animal {

    // Abstract Method
    abstract void eat();

    // Concrete Method
    void makeSound() {
        System.out.println("Make Sound");
    }
}
```

Abstract classes on the other hand, can have both abstract and concrete methods. 

```java
    // Abstract Method
    abstract void eat();
```

All abstract methods should be declared as `abstract`. 

|          Feature          | Abstract Class       | Interface                  |
+---------------------------+----------------------+----------------------------+
| 1. Constructors           |        Yes           |          No                |
+---------------------------+----------------------+----------------------------+
| 2. Access Modifiers       |   Private, Public or |   Only public              |
|                           |      Protected       |                            |
+---------------------------+----------------------+----------------------------+
| 3. Inheritance            |  Single (extends     |  Multiple (implements      |
|                           |  one class)          |  multiple interfaces)      |
+---------------------------+----------------------+----------------------------+


There are some other differences between abstract classes and interfaces, but most importantly, we have to understand the purpose of each.

              Abstract Class: Vehicle
              +-------------------------+
              |      startEngine()      |   <-- Default behavior
              +-------------------------+
                        |
   +--------------------+---------------------+
   |                                          |
  Car                                        Truck
+------------------+                    +------------------+
| specificFeatures()|                    | specificFeatures()|
+------------------+                    +------------------+

An abstract class can provide default behavior, for subclasses that share the common functionality but may also have their own specific features.


                Interface: Flyable
              +-------------------------+
              |         fly()            |   <-- Defined contract
              +-------------------------+
                        |
   +--------------------+---------------------+
   |                                          |
Implements:                                Implements:
Bird                                       Airplane
+------------------+                    +------------------+
|   fly() method   |                    |   fly() method   |
|  (implemented)   |                    |  (implemented)   |
+------------------+                    +------------------+

An interface on ther other hand can define methods that must be implemented by unrelated classes, essentially forcing them to implement a common set of functionality. 

### #77 Default Access Modifiers in an Interface

```java
interface Flyable {
    // This variable is implicitly public, 
    // static, and final (a constant)
    int MAX_ALTITUDE = 10000;
}
```
Variables are implicitly public, static, and final. This means all variables are constants and cannot be modified after initialization.

```java
interface Flyable {

    // Compile time error. 
    int MAX_ALTITUDE;
}
```
For example, if you try to declare a variable without initializing it results in compile time error.

```java
interface Flyable {
    // This method is implicitly 
    // public and abstract
    void fly();
}
```

On the other hand, Methods in an interface are implicitly public and abstract. There are some exceptions to this though. 

1. `default` methods - This was introduced in Java 8. Know more about these in # 75


```java
interface Flyable {
    // private methods should have a body
    private void fly(){
        System.out.println("Fly");
    }
}
```

2. `private` methods - Starting with Java 9, Interfaces can have private methods. However, make sure they have a body. 

```java
interface MathUtils {
    // Static method in the interface
    static int add(int a, int b) {
        return a + b;
    }
}
```

3. `static` methods - Starting with Java 8, Interfaces can also have static methods. This is typically used as utility methods. For example, A Collection interface might have a static method to perform common operations that are not specific to any single instance.

### #78 Can one interface extend another

```java
// Parent interface
interface Animal {
    void eat();
}

// Child interface extending 
// the parent interface
interface Cat extends Animal {
    void play();
}
```

Yes, in Java, an interface can extend another interface. Here, we have 2 interfaces

1. `Animal` which has an abstract `eat()` method.
2. We have another interface `Cat` that `extends` the `Animal` Interface. 

The `Cat` interface inherits the `eat()` method and it adds its own abstract method `play()`.

Observe that when you extend one interface from another, we use the `extends` keyword, not the `implements` keyword. 


      +---------+
      | Animal  |
      +---------+
         ^  ^
         |  |------------------
         |                     |
  +-------------+      +-------------+
  |    Feline   |      |   Canine    |
  +-------------+      +-------------+
         ^                  ^
         |                  |
         |                  |
  +----------------+    +-----------------+
  |       Cat      |    |     Dog         |
  +----------------+    +-----------------+
         ^
         |
         |
+---------------------+
| CatImplementation   |
+---------------------+


In case you are wondering why do this, this is generally done so that our code is more flexible and reusable. For example, there are two interfaces here `Feline` and `Canine` that are inheriting from the `Animal` interface. The Cat interface now implements from both the Feline and the Animal Interface. This way, the `Cat` interface inherits from both the `Feline` and the `Animal` Interfaces inhering both the characteristics. 


### #79 What is a private Access Modifier

```java
class Account {
    private int number;
}
```

When you declare a variable or method as private, it is only accessible from within the class.

```java
class Main {

    public static void main (String[] args){
        Account account = new Account();
        account.number = 1;
    }
}
```
If you try to access the private variable within another class, it results in an error. 

```java
class Account {
    private int number;
}

class CurrentAccount extends Account {
    // No access to the `number` private variable
    private int accNumber = number;
}
```

Similarly, you can't access private variables even in the child class.

+----------------------+
|       Class Account  |
| +------------------+ |
| |   private field  | |
| +------------------+ |
| +------------------+ |
| |  private method()| |
| +------------------+ |
+----------------------+
           |
           |
           v
+----------------------+
| Class CurrentAccount |
+----------------------+

When the child class inherits from the parent class, all the fields and methods marked as private will not be inherited to the child class. 

```java
class Account {
    private int number;

    public getNumber(){
        return number;
    }
}
```

The only way to access a private variable is to have a public getter method. 

The primary purpose of private variables or methods is Encapsulation, which is one of the core principles of Object oriented programming. To understand more about Encapsultion, refer to #66. 


### #80 What is a public Access Modifier

We have seen the `private` access modifier in #79. In this video, we are going to look at the `public` access modifier. 

```java
class Account {
    public int number;
}
```

```java
class Main {

    public static void main (String[] args){
        Account account = new Account();
        account.number = 1;
    }
}
```
When you declare a variable as `public`, it is not just accessible within the class, but from outside the class as well.

```java
account.number = 1;
```

If the variable number were a `private` variable, we would not be able to access it like this. Since the variable number is `public`, we can access it directly using the `.` operator. This applies not just to variables but to methods as well. 

+----------------------+
|       Class Account  |
| +------------------+ |
| |   public  field  | |
| +------------------+ |
| +------------------+ |
| |  public  method()| |
| +------------------+ |
+----------------------+
           |
           |
           v
+----------------------+
| Class CurrentAccount |
| +------------------+ |
| |   public  field  | |  < -- Automatically gets access
| +------------------+ |
| +------------------+ |
| |  public  method()| |  < -- Automatically gets access
| +------------------+ |
+----------------------+

Now, what about inheritance ? variables and methods declared as `public` automatically get passed on to the child classes as well. 

```java
class Account {
    public int number;
}

class CurrentAccount extends Account {
    // This class has access to `number` variable

}
```

For example, the `number` field declared as public in the parent class automatically gets inherited by the child class.

```java
class Main {

    public static void main (String[] args){
        CurrentAccount account = new CurrentAccount();
        account.number = 1;
        System.out.println(account.number);
    }
}
```

Also, since the variable is declared as `public`, the child class can just use the `.` operator to access the field. 

### #81 Default Access Modifier

We have seen `private` and `public` access modifiers in #79 and #80. 

```java
class Account {
    int number;
}

class CurrentAccount extends Account {
    // Does this class have access
    // to the `number` variable ??

}
```

But, What if you just say `int number` without saying explicitly that it is `private` or `public`. 

```java
class Account {

    // This is package-private
    int number; 
}
```

In this case, the access level is called `package-private`. 

```java
class Account {

    // This is package-private
    int number;
}

/** Another class in the same package */
class Main {

    public static void main (String[] args){
        Account account = new Account();
        account.number = 1;
        System.out.println(account.number);
    }
}
```
Any other class within the same package can access these `package-private` variables. The key being **within the same package**. In other words, within the same package, `package-private` acts like the `public` access modifer. 

```java
class Account {

    // package-private by default
    int number;
}

/** Another class in the same package */
class CurrentAccount extends Account {
    // This class has access to `number` variable
   
}
```

The next question you might have is, what about sub-classes ? As long as the sub-class is within the same package, you inherit the `package-private` variables and methods. 

```java
class Account {

    // package-private by default
    int number;
}

/** Another class in a different package */
class CurrentAccount extends Account {
    // This class does not have access to `number` variable
   
}
```

But if the sub-class is from a different package, then the child class does not have access to the parent classes `package-private` variables and methods. 

### #82 protected Access Modifier

Access Modifiers

#79 - `private`
#80 - `public`
#81 - `package-private` or `default`

We have seen `private`, `public` and `default` access modifiers in #79 and #80 and #81. 


```java
class Account {

    protected int number;
}
```


There is another access modifier called `protected`. It is less restrictive than `private`, but more restrictive than `public`. 


```java
class Account {

    protected int number;
}

/** Another class in the same package */
class Main {

    public static void main (String[] args){
        Account account = new Account();
        account.number = 1;
        System.out.println(account.number);
    }
}
```

Just like `package-private`, any class within the same package can access `protected` members. 

```java
class Account {

    protected int number;
}

/** Another class in a different package */
class CurrentAccount extends Account {
    // This class has access to `number` variable
   
}
```

However, unlike `package-private` any child class either within the package or outside the package has access to all `protected` members of the `parent` class. 

### #83 private vs public vs protected vs default

Access Modifiers

#79 - `private`
#80 - `public`
#81 - `package-private` or `default`
#82 - `protected`

We have seen `private`, `public`, `default` and `protected` access modifiers in #79, #80, #81 and #82. In this video we are going to summarize the differences between them. 


+-------------------------------------------------------------+
| Access Level    |  Same    |   Same  | Subclass | Outside   |
|                 |  Class   | Package |          | Package   |
+-----------------+----------+---------+- --------+-----------+
| private         |  Yes     |   No    |    No    |      No   |
| package-private |  Yes     |   Yes   |   Yes*   |      No   |
| protected       |  Yes     |   Yes   |   Yes*   |      No   |
| public          |  Yes     |   Yes   |    Yes   |      Yes  |
+-------------------------------------------------------------+

The first column is kinda lame. Same class means, any method can access any other variable or method within the same class irrespective of its access modifier.

The second column `same package` means, any other class in the same package can access the variables and methods within another class. Except for methods and variables declared as `private`, all other access modifiers give access to other classes within the same package.

The fourth column talks about the same thing but outside the package. 

The third column subclass talks about the same concept, but in the context of inheritance. Only private variables and methods are not passed on from parent to child. 

We have to be a bit careful about these accesses. The difference is that sub-classes can inherit default variables within the same package, but not from a different package. However, protected does not have that restriction.  


### #84 Can you overload the main method

```java
class Example {
    public static void main (String[] args){

    }
}
```

We know that this is how the main method is written. It is declared `public` and `static` with a return type of void. It also takes in an array of `String`s as arguments. 

```java
class Example {
    public static int main (String[] args){

    }
}
```

But, what if we want to specify the return type as `int` instead of `void` ? Will Java complain ? 

No, it doesn't. 

`public void main (String[] args)`

`public int main ()`

`public void main()`

In fact it is perfectly legal to have any variation of the `main` method. 

`public static void main (String[] args)`

However, JVM looks for a specific signature of the main method to start the program. And it should have this kind of a signature only - `public static void main` with an array of Strings as arguments. 

You are free to overload the main method with as many alternate signatures as you want, but just make sure that this particular version is always available. 

```sh
Error: Main method not found in class Main, please define the main method as:
   public static void main(String[] args)
```

If you don't specify this, you don't get a compile time error, but you get a run time error saying `Main method not found`, which means, Java is expecting you to declare that particular variation of the `main` method. 

### #85 Can sub-classes override Access Levels

```java
class Parent {
    protected void show() {
        System.out.println("Parent show");
    }
}
```

Imagine a parent class like this with a `protected` method.

```java
class Child extends Parent {
    // Allowed: More accessible (public)
    @Override
    public void show() {
        System.out.println("Child show");
    }
}
```

In the child class, can you override the access level of the same method from `protected` to `public` ? Yes, you can. However, there are some constraints that need to be followed.

- private (least accessible)
- default (no modifier, package-private)
- protected
- public (most accessible)

In terms of access levels, we know that `private` is the most restrictive and `public` is the least. 

When overriding methods, make sure that the access level is expansive not restrictive. 

`private` -> `public`  (Allowed)

`protected` -> `private` (Not allowed)

For example, you can override a `private` method in a parent class into a `public` method in a child class. But you can't make a `protected` method to a `private` one. 

```java
class Parent {
    protected void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    // Allowed: More accessible (public)
    @Override
    public void show() {
        System.out.println("Child show");
    }

    // Not allowed: Less accessible (private)
    @Override
    private void show() { // Compile-time error
        System.out.println("Child show");
    }
}
```

```java
// Allowed: More accessible (public)
@Override
public void show() {
    System.out.println("Child show");
}
```
So, this is possible, 

```java
// Not allowed: Less accessible (private)
@Override
private void show() { // Compile-time error
    System.out.println("Child show");
}
```

but this is not. 

This applies ONLY to methods. Overriding Access modifiers of variables is NOT possible. 

### #86 Can you make a class private

```java
// Not allowed
private class MyClass { // Compile-time error
    // code
}
```

No, it's not possible to have private classes. Java will throw a compile time error. 


```java
// Allowed for inner class
class Outer {
    private class Inner {
        // code
    }
}
```

The only exception is inner classes which can be private. 

```java
// Not allowed
private class MyClass { // Compile-time error
    // code
}
```

There is a simple logic for this. Top level classes cannot be private because Java needs them to be accessible from outside for object creation and execution. 

```java
// Allowed for inner class
class Outer {
    private class Inner {
        // code
    }
}
```
Inner classes or classes inside classes can be `private`. Since they are private within the outer class, their access can be restricted within the class and there is no need for object creation outside of that context. 

### #87 Can you make a class protected

In #86, we have seen that top level classes cannot be marked as private. 

```java
// Not allowed: protected class
protected class MyClass {  // Compile-time error
    // code
}
```

Can, you mark it as `protected` ? No, similar to `private` , top level classes cannot be marked as `protected`. Java will throw a compile time error. Let's explore why.


`protected` is used to allow access to fields or methods within the package and by subclasses. 


However, classes are not inherited in the same way as methods or fields - so protected is NOT applicable. 



```java
// Allowed: public or package-private
class MyClass {
    // code
}
```

So, java allows ONLY `public` or `package-private` by default. `private` and `protected` access modifiers are not allowed. 

### #88 Can you have private abstract methods in Abstract class


```java
abstract class AbstractClass {
    // Not allowed: private abstract method

    // Compile-time error
    // private abstract void myMethod(); 

    // Allowed: protected or public abstract method
    protected abstract void myMethod();
}
```

No, an abstract method in an abstract class cannot be declared as private. Let's understand why.


```java
abstract class AbstractClass {

    // Allowed: protected or public abstract method
    protected abstract void myMethod();
}

class SubClass extends AbstractClass {
    @Override
    public void myMethod() {
        System.out.println("Implemented in SubClass");
    }
}
```
The purpose of an abstract method is to provide a contract for subclasses to implement. If an abstract method is declared as private, it would not be visible to any subclasses - meaning, those subclasses would NOT have a way to implement the method. 

This defaults the purpose of declaring it as abstract. The same principle applies to interfaces as well. 

### #89 What are exceptions

```java
public class ExceptionExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};

        // This will throw ArrayIndexOutOfBoundsException
        System.out.println(numbers[5]); 
    }
}
```

Exceptions are events that occur during the execution of a program that disrupt the normal flow of instructions.

For example, here we have an array of length 3, but we are trying to access the fifth element in the array. At this point, Java doesn't know what to do and just stops the execution of the program. 

```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]); // This will throw ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds: " + e.getMessage());
        }
    }
}
```

To be able to handle these types or problems, we have to catch the exception and do remedial action. For example, this is an Index out of bounds exception and we have to explicitly catch that exception. 

Enclose the code in a try catch block and catch the specific exception. You can do some actions in the catch block like print a message etc. 

The advantages of doing this is that Java does not crash the program. It handles the exception gracefully and keeps going. It improves the overall reliability of the program.  


### #90 What are Checked Exceptions

  +---------------------------+
  |      Exceptions           |
  +---------------------------+
          /         \
         /           \
        /             \
+----------------+  +-----------------+
|   Checked      |  |   Unchecked     |
|   Exceptions   |  |   Exceptions    |
+----------------+  +-----------------+

In #89, we have seen what exceptions are. There are 2 types of exceptions - Checked and Unchecked Exceptions. 

In terms of writing code, most of the time, we work with Checked Exceptions. These are exceptions that Java predicts at compile time and expects you as a programmer to handle it. 

```java
// Throws IOException
FileReader file = new FileReader("nonexistentfile.txt"); 
```

For example, when you read a file, there could be many things that go wrong 

- The file is locked
- The file is not found etc

In these cases, Java throws a checked Exception, for example - IOException - and Java expects that you handle it. And Java warns you about this right at the time of compilation. That is why they are called `checked` exceptions, because Java checks them right at compile time. 

```java
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("nonexistentfile.txt");
            // Additional code to read from the file can go here

        } catch (IOException e) {
            System.out.println("An error occurred " + e.getMessage());
        }
    }
}
```

To handle this, wrap it in a `try` `catch` block and handle the specific exception before moving on to the next step. 

- IOException
- FileNotFoundException
- SQLException
- ClassNotFoundException
- InterruptedException

Here are some examples of most commonly occuring Exceptions. 

### #91 What are UnChecked Exceptions


#90 - Checked Exceptions

In #90, we have seen Checked Exceptions. These are exceptions that are handled at compile time - meaning, these are predictable. 

Unchecked Exceptions on the other hand are not predicatable. The program is not supposed to recover from these. 

```java
public class NullPointerExceptionExample {
    public static void main(String[] args) {
        String str = null;
        System.out.println(str.length()); // Causes NullPointerException
    }
}
```

A good example is `NullPointerException`. For example, here, we have a string variable pointing to null - and we are trying to get the length of that string. 

Since this is an Unchecked Exception, Java doesn't expect that you enclose this within a try catch block. 

```java
class Main {

    public static void main(String[] args) {
        try{
            String str = null;
            System.out.println(str.length()); // Causes NullPointerException
        }catch(NullPointerException e){
            System.out.println(e);
        }
    }
}
```

If you can predict the problem though, you are free to catch the exception. But it is typically better to fix the underlying issue rather than catch Unchecked exceptions. 


### #92 Why is the `finally` block used

```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileReader reader = null;
        try {
            reader = new FileReader("example.txt");
            // Perform file operations
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close(); // Ensures the file is closed
                }
            } catch (IOException e) {
                System.out.println("Error closing file: " + e.getMessage());
            }
            System.out.println("File handling completed.");
        }
    }
}
```

The purpose of `finally` in a `try` `catch` block is to ensure that you clean-up or release resources. 

```java
reader = new FileReader("example.txt");
```
For example, here we read a file in the `try` block and perform some file operations. But since file is an external resource, anything can go wrong in the try block - like file not found or file getting locked etc.  

```java
System.out.println("Caught IOException: " + e.getMessage());
```

This is being caught as an exception here. 

```java
reader = new FileReader("example.txt");
```

But what happens to the `FileReader` variable, which is still pointing to the file system ? The program has to close it before exiting. Otherwise, this results in a deadlock. 

```java
 finally {
    try {
        if (reader != null) {
            reader.close(); // Ensures the file is closed
        }
    } catch (IOException e) {
        System.out.println("Error closing file: " + e.getMessage());
    }
    System.out.println("File handling completed.");
}
```

That's why, we have the `finally` block. Java ensures that irrespective of what happens in the `try` `catch` block, the `finally` block always runs. This gives us a chance to do clean-up activities like release resources etc. In this case, we just ensure that the file handler is closed. 

However, the `finally` block is optional. You can choose to just do `try` `catch` and not implement the `z` block. 


### #93 what is Exception Propogration (`throw` keyword)

```java
public class Main {
    public static void main(String[] args) {
        try {
            divide(10, 0); 
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method that throws an unchecked exception (ArithmeticException)
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("not allowed.");
        } else {
            System.out.println("Result: " + a / b);
        }
    }
}
```

Imagine you have a method `divide(a,b)` that divides two integers - `a` divided by `b`. 

```java
if (b == 0)
```
But, what if `b` is `0` ? It results in a runtime exception, right ? Say, you don't want the method divide() to handle it. 

```java
public static void main(String[] args) {
    try {
        divide(10, 0); 
```

Instead, you want the calling method, in this case `main` to handle it. 

```java
throw new ArithmeticException("not allowed.");
```

In this case, instead of using the `try` `catch` block in the `divide` method, just throw the exception back to the calling class using the `throw` keyword. 

+------------------+       +------------------+       +------------------+
|   Method C       |       |   Method B       |       |   Method A       |
|  (throws ex)     |       | (calls Method C) |       | (calls Method B) |
+------------------+       +------------------+       +------------------+
         |                          |                           |
         |                          |                           |
         |------------------>       |------------------>        |
         |   Exception Thrown       |    Exception Propagated   |
         |                          |                           |
  +------------------+       +------------------+       +------------------+
  |  No try-catch    |       |  No try-catch    |       |   try-catch      |
  |  block present   |       |  block present   |       |   block present  |
  +------------------+       +------------------+       +------------------+
                                                    |
                                                    |
                                        Exception caught and handled

For example, here, Method C doesn't want to handle the exception, but throws it to the called method - Method B. Method B doesn't want to handle it either and throws it back to it's calling class Method A. When exceptions are not handled in the current method but thrown back to the calling method, it is called Exception propogation. You throw an exception using the `throw` keyword.

### #94 `throw` vs `throws` in Java

In Java, `throw` and `throws` are both related to Exception Handling, but serve different purposes. 


```java
public class Main {
    public static void main(String[] args) {
        try {
            divide(10, 0); 
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method that throws an unchecked exception (ArithmeticException)
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("not allowed.");
        } else {
            System.out.println("Result: " + a / b);
        }
    }
}
```

When a method does not want to handle an exception, it uses the `throw` key word, creates a new instance of an Exception and throws it to the calling class. This is called Exception propogation, which we have seen in # 93.  

Divide by zero is an example of an unchecked exception.

```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            readFile("file.txt");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method declares that it throws FileNotFoundException
    public static void readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file); // This might throw FileNotFoundException
    }
}
```

What about a checked exception like `FileNotFoundException` ? If you want a method to not handle checked exceptions, you have to explicitly declare the method with the throws keyword followed by the exception you wish the calling method handle.

```java
File file = new File(fileName);
FileReader reader = new FileReader(file); // This might throw FileNotFoundException
```
In this case, any of these lines can throw the checked exception FileNotFound. 

```java
if (fileName == null) {

    // Uses throw to explicitly throw an exception
    throw new IllegalArgumentException("Filename cannot be null"); 
}

// Might throw FileNotFoundException
FileReader reader = new FileReader(fileName); 
```

You can also use a combination of `throw` and `throws`. For example, here you are explititly throwing an `IllegalArgumentException` using the `throw` keyword and using the `throws` keyword to indicate that this method might throw a `FileNotFoundException`. 

In summary, the `throw` keyword is used to explicitly throw an exception, while the `throws` keyword declares that a method might throw an exception, which must be handled by the calling method.






















