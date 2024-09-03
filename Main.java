// Base class
class Animal {
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

// Derived class
class Dog extends Animal {

    // Constructor
    public Dog(String name) {
        super(name); // Call the constructor of the base class
    }

    // Overriding the method from the base class
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    // New method specific to Dog
    public void fetch() {
        System.out.println("Fetching the ball...");
    }
}

public class Main {

    public static void main (String[] args){
        Dog d = new Dog("Sunny");
        d.makeSound();
    }

}
