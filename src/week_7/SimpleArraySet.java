package week_7;

import javax.sound.midi.Soundbank;

public class SimpleArraySet {
    private static final int INITIAL_CAPACITY = 3;
    private Object[] buckets;
    private int size;

    public SimpleArraySet() {
        buckets = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    //add
    public boolean add(Object element) {
        int index = getBucketIndex(element);
        System.out.println("Adding element: " + element+" to idx: "+index);

        //check if bucket is empty
        if(buckets[index] == null) {
            buckets[index] = element;
            size++;
            return true;
        }
        //check if element already exists
        else if(buckets[index].equals(element)) {
            System.out.println("Element already exists!");
            return false;
        }
        //handing collision
        else{
            System.out.println("COLLISION: Bucket "+index+" already contains element "+buckets[index]+" But we want to add "+element);
            System.out.println("We can't add both elements with this simple structure!");
            return false;
        }
    }

    public void printElements() {
        for (int i = 0; i < size; i++) {
            Object bucket = buckets[i];
            System.out.println();
        }
    }

    private int getBucketIndex(Object element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode % buckets.length); // return value will be between 0 and elements.length
    }


}
