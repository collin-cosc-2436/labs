package module_9;

public class CircularQueueDemo {

    public static void main(String[] args) {
        CircularQueue<String> circularQueue = new CircularQueue(5);

        circularQueue.enQueue("Java");
        circularQueue.enQueue("Python");
        circularQueue.enQueue("JavaScript");
        circularQueue.enQueue("C++");
        System.out.println(circularQueue);
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue);
        System.out.println(circularQueue.deQueue());
        System.out.println(circularQueue);

        circularQueue.enQueue("A");
        System.out.println(circularQueue);
        circularQueue.enQueue("B");
        System.out.println(circularQueue);
        circularQueue.enQueue("C");
        System.out.println(circularQueue);
        circularQueue.enQueue("D");
        System.out.println(circularQueue);
    }
}

class CircularQueue<T> {

    private T[] array;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enQueue(T element) {
        if(isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if(rear == capacity-1){
            rear = 0;
        }else{
            rear++;
        }
        array[rear] = element;
        size++;
    }

    public T deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T element = array[front];
        array[front] = null;
        if(front == capacity - 1){
            front = 0;
        }else{
            front++;
        }
        size--;

        return element;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
//        return size == capacity;

        //Cams :)
        return (front == 0 && rear == capacity -1) || (front == rear +1 && array[front] != null);


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
        stringBuilder.append("===>Front: " + front + " Rear: " + rear).append(" Size: " + size).append(" Capacity: " + capacity);
        return stringBuilder.toString();
    }

}
