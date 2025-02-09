package week_2;

public class CharacterDemo {
    public static void main(String[] args) {
        char c = 'A';
        System.out.println("Is letter? " + Character.isLetter(c)); // true
        System.out.println("Is digit? " + Character.isDigit(c)); // false
        System.out.println("Uppercase: " + Character.toUpperCase('a')); // A
    }
}
