package module_9;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {

        //built in Stack
        Stack<String> stack = new Stack<>();
        //push operation
        stack.push("java");
        stack.push("python");
        stack.push("javascript");
        System.out.println(stack);

        //peek operation
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        //pop operation
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());




        //Array based stack
        ArrayBasedStack<String> arrayBasedStack = new ArrayBasedStack<>(5);

        arrayBasedStack.push("java");
        arrayBasedStack.push("python");
        arrayBasedStack.push("javascript");

        System.out.println(arrayBasedStack);

        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack);
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack);
        System.out.println(arrayBasedStack.peek());



        //LinkedList based Stack
        LinkedListBasedStack<Integer> linkedListBasedStack = new LinkedListBasedStack<>();
        System.out.println(linkedListBasedStack.getSize());
        linkedListBasedStack.push(1);
        linkedListBasedStack.push(2);
        linkedListBasedStack.push(3);
        System.out.println(linkedListBasedStack);
        System.out.println(linkedListBasedStack.pop());
        System.out.println(linkedListBasedStack);
    }
}

class Node<T>{
    public T data;
    public Node<T> next;
    public Node(T data) {
        this.data = data;
    }
}

class LinkedListBasedStack<T> {
    private Node<T> top;
    private int size;

    public LinkedListBasedStack() {
        top = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }


    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next  = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }



    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Node<T> current = top;
        while (current != null) {
            stringBuilder.append(current.data).append(", ");
            current = current.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}


class ArrayBasedStack<T> {
    private T[] array;
    private int capacity;
    private int top;


    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T t) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full. Capacity: " + capacity);
        }
        array[++top] = t;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = array[top];
        array[top] = null;
        top--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }


    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for(T t : array) {
            if (t != null) {
                stringBuilder.append(t).append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
