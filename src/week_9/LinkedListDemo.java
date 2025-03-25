package week_9;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.addFirst(20);
        list.addLast(10);
        // 20-->1-->2-->3-->10
        list.add(3,35); //??
        //20-->1-->2-->35-->10
        System.out.println(list);
        list.remove(Integer.valueOf(20));

        for(Integer i : list){
            System.out.print(i+"--->");
        }
        System.out.println("null");
    }
}
