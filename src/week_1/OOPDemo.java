package week_1;


// Demonstration
public class OOPDemo {
    public static void main(String[] args) {
        Dog ella = new Dog("Ella", 3, "Labrador");
        Cat kers = new Cat("Whiskers", 5);

        ella.makeSound(); // Woof! Woof!

        ella.eat(); // Whiskers is eating dog food
        kers.eat(); // Whiskers is eating cat food

        ella.eat("fish");



        // Polymorphic references
        Pet sky = new Dog("Sky", 2, "Golden Retriever");

        sky.makeSound(); // Woof! Woof!
        // sky.bark(); // Compile-time error
        ((Dog)sky).bark(); // OK
    }
}

