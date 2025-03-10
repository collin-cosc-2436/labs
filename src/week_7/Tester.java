package week_7;

public class Tester {
    public static void main(String[] args) {
//        MyArrayList<String> list = new MyArrayList<>();
//        list.add("hello");
//        list.add("world");
//        list.add("world");
//
//        String obj = list.get(4);
//        System.out.println(list.get(4));
//

        SimpleArraySet set = new SimpleArraySet();
        set.add("Java");
        set.add("Python");
        set.add("C++");
        set.add("JavaScript");

        set.printElements();


        NodeBasedSet stringSet = new NodeBasedSet();
        stringSet.add("Java");
        stringSet.add("Python");
        stringSet.add("C++");
        stringSet.add("JavaScript");

        stringSet.printElements();

    }
}
