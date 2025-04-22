package module_11;

public class HeapDemo {
    public static void main(String[] args) {
        System.out.println("Max heap demo");

        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(6);
        maxHeap.printHeap();


        System.out.println("Max element: "+maxHeap.peek());

        //
        System.out.println("Extract max element: "+maxHeap.extractMax());
        maxHeap.printHeap();
        System.out.println("Extract max element: "+maxHeap.extractMax());
        maxHeap.printHeap();

        int[] arr = {100,80,90,30,20};
        maxHeap.buildHeap(arr);
    }
}

class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    public void insert(int value) {
        if (size >= capacity) {
            System.out.println("Max heap is full");
            return;
        }

        heap[size] = value;
        size++;

        heapifyUp();
    }

    public int extractMax() {
        if (size == 0) {
            System.out.println("Max heap is empty");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            size--;
            return heap[0];
        }


        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;


        //heapifyDown bubbleDown

        heapifyDown();


        return max;

    }


    public int peek(){
        if (size == 0) {
            System.out.println("Max heap is empty");
            return Integer.MIN_VALUE;
        }
        return heap[0];
    }

    private void heapifyUp() {
        int index = size - 1;
        while(index >0 && heap[parentIndex(index)] < heap[index] ) {
                swap(index,parentIndex(index));
                index = parentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(index<size) {
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            int indexWithLargestValue = index;

            if (leftChildIndex < size && heap[leftChildIndex] > heap[indexWithLargestValue]) {
                indexWithLargestValue = leftChildIndex;
            }

            if (rightChildIndex < size && heap[rightChildIndex] > heap[indexWithLargestValue]) {
                indexWithLargestValue = rightChildIndex;
            }

            if (indexWithLargestValue != index) {
                swap(index, indexWithLargestValue);
                index = indexWithLargestValue;
            } else {
                break;
            }
        }
    }

    private int leftChildIndex(int index) {
        return 2*index + 1;
    }
    private int rightChildIndex(int index) {
        return 2*index + 2;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    public void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void printHeap() {
        System.out.println("Max heap: ");
        for (int i = 0; i < this.size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }


    public void buildHeap(int[] arr) {

    }
}
