package week_1;

public class OOPDemo {
    public static void main(String[] args) {
       Pet ella = new Dog("Ella","Lab",7);
        System.out.println(ella.getName());

        Pet nili = new Cat("Nili",2);

        nili.makeSound();
        ella.makeSound();
    }
}

