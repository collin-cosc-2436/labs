package module_9;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        //Enqueue ==> Offer
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");

        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue);


        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer("a");
        arrayDeque.offer("b");
        arrayDeque.offer("c");
        System.out.println(arrayDeque);
        System.out.println(arrayDeque.peek());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque);

        arrayDeque.addFirst("r");

        System.out.println(arrayDeque.peek());


        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");
        System.out.println(arrayQueue);
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue);

    }
}


class ArrayQueue<T>{
    private T[] array;
    private int size;


    public ArrayQueue(int capacity) {
        array = (T[]) new Object[capacity];
        size = 0;
    }



    public void enqueue(T t){
        if(size == array.length){
            throw new RuntimeException("Queue is full");
        }
        array[size++] = t;
    }

    public T dequeue(){
        if(size == 0){
            throw new RuntimeException("Queue is empty");
        }
        T t = array[0];
        for (int i = 0; i < size-1; i++) {
            array[i] = array[i + 1];
        }
        array[size-1] = null;
        size--;
        return t;
    }

    public T peek(){
        return null;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(T t : array) {
//            if (t != null) {
                stringBuilder.append(t).append(",");
//            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
