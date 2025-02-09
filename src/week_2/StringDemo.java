package week_2;

public class StringDemo {

    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println(text.indexOf("or"));
        System.out.println(text.length());

        String str = "hello world"; //java interning...
        String rts = "hello world";

        if(str==rts){
            System.out.println("they are same");
        }

        DynamicStringArray a = new DynamicStringArray();
        DynamicStringArray b = new DynamicStringArray();

        if(a==b){
            System.out.println("a and b are same");
        }
    }
}
