package week_1;

public class Dog extends Pet{
    private String breed;


    public Dog(String name,String breed,int age){
        super(name,age);
        this.breed = breed;
    }


    public String getBreed() {
        return breed;
    }

    //behavior
    public void bark(){
        System.out.println(getName()+" is barking");
    }


    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}