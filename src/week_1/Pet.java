package week_1;
// Intermediate class inheriting from Animal
abstract class Pet extends Animal {
    private String name;

    public Pet(String name, int age) {
        super(age);
        this.name = name;
    }

    // Pet-specific methods
    public String getName() {
        return name;
    }

    // Abstract methods
    public abstract void makeSound();
}
