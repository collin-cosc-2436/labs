package week_1;


// Similarly for Cat
public class Cat extends Pet {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void eat() {
        System.out.println(getName() + " is eating cat food");
    }
}
