package week_1;

abstract class Pet extends Animal{

    private String name;


    public Pet(String name,int age){
        super(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void makeSound();

    @Override
    public void eat() {

    }
}
