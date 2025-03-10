package week_6;

import java.util.ArrayList;
import java.util.HashMap;

public class BoxDemo {
    public static void main(String[] args) {
        //without generics
        ArrayList list  = new ArrayList();

        list.add("hello");
        list.add(1234);

        String hello = (String)list.get(0);

        //with generics

        ArrayList<String> list1  = new ArrayList<>();
        list1.add("hello");
        String s = list1.get(0);

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1212121);

        Box<Dog> boxForDog = new Box<>();
        boxForDog.setAnimal(new Dog());


        Box<Car> boxForCar = new Box<>();
        boxForCar.setAnimal(new Car());


    }


}
class Car extends Animal {

}

class Box<T extends Animal> {
    T animal;

    static String name;
    public void setAnimal(T animal){
        this.animal = animal;
    }
    public T getAnimal(){
        return animal;
    }



}

class Animal {
    public String age;

}

class Dog extends Animal{
    public String name;
}
class Cat extends  Animal{
    public String name;
}
