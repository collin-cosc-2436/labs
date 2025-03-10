package week_7;

import javax.sound.midi.Soundbank;

public class NodeBasedSet {

    private static final int INITIAL_CAPACITY = 10;
    private Node[] buckets;
    private int size;

    public NodeBasedSet() {
        buckets = new Node[INITIAL_CAPACITY];
        size = 0;
    }

    //add
    public boolean add(String element) {
        int index = getBucketIndex(element);
        System.out.println("Adding element: " + element+" to idx: "+index);
        Node current = buckets[index];
        while (current != null) {
            //check for dup
            if (current.data.equals(element)) {
                System.out.println("Element already exists is set");
                return false;
            }
            current = current.next;
        }

        Node newNode = new Node(element);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;

        return true;


    }

    private int getBucketIndex(Object element) {
        int hashCode = element.hashCode();
        return Math.abs(hashCode % buckets.length); // return value will be between 0 and elements.length
    }

    public void printElements() {
        for (int i = 0; i < buckets.length; i++) {
            Node current = buckets[i];
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
        }
    }
}
