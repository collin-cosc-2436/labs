package week_1;

// Now properly extending Pet
public class Dog extends Pet {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    // Behavior specific to Dog
    public void bark() {
        System.out.println(getName() + " is barking");
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating dog food");
    }

    // Overloading example explain later.
    public void eat(String food) {
        System.out.println(getName() + " is eating "+food);
    }



}