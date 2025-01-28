package week_1;
abstract public class Animal {
    private int age;

    //Constructor
    public Animal(int age) {
        this.age = age;
    }

    // behavior
    public abstract void eat();
}
