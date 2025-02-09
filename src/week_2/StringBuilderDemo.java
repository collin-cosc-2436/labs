package week_2;

import java.util.StringTokenizer;

public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        System.out.println(sb);
        sb.reverse();
        System.out.println(sb);


        String data = "apple, orange, banana";
        String[] fruits = data.split(",");
        for (String f:fruits){
            System.out.println(f.trim());
        }

        StringTokenizer stringTokenizer = new StringTokenizer("Java is OOP and Fun"," ");

        while (stringTokenizer.hasMoreTokens()){
            System.out.println(stringTokenizer.nextToken());
        }

    }
}
