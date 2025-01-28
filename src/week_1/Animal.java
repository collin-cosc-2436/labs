package week_1;
abstract class Animal{
    private int age;

    public Animal(int age){
        this.age = age;
    }

    public abstract void eat();
}