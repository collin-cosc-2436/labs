package week_7;

interface Printer{
    void print(String message);
}



public class FunctionalInterfacesDemo {
    public static void main(String[] args) {
        Printer printer = new Printer() {
            @Override
            public void print(String message) {
                System.out.println("Printing: "+message);
            }
        };

        printer.print("Hello World");

        Printer printer2 = (message) -> System.out.println("Printing: "+message);
        printer2.print("Hello World");
    }
}
