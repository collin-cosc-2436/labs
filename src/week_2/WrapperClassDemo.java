package week_2;

import java.util.ArrayList;

public class WrapperClassDemo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); //AutoBoxing ==> int -> Integer

        Integer val = list.get(0); //Unboxing Integer -> int
        if(val!=null){
            val.intValue();
        }
//        val
        char d ='a';
        ArrayList<Character> cList = new ArrayList<>();
        cList.add(d);

    }

}
