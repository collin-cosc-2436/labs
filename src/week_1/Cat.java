package week_1;

public class Cat extends Pet {

    public Cat(String name,int age) {
        super(name,age);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}
