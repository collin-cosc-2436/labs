package week_7;


public class MyArrayList<E> {


    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size;
    public MyArrayList() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    //add
    public boolean add(E element) {
        ensureCapacity();
        elements[size] = element;
        size++;
        return true;
    }

    //get
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    //remove
    //isEmpty
    //size
    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newSize = elements.length * 2;
            Object[] newElements = new Object[newSize];

            //copy the old elements into new
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;

        }
    }

}
