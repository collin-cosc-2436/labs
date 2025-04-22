package module_11;

public class BoardingQueue {
    private Passenger[] passengers;
    private int size;

    public BoardingQueue(int capacity) {
        passengers = new Passenger[capacity];
        size = 0;
    }

    public void addPassenger(Passenger passenger) {
        passengers[size] = passenger;
        size++;
        siftUp();

    }

    public Passenger nextBoardingPassenger() {

        Passenger passenger = passengers[0];
        size--;

        if(size >0){
            passengers[0] = passengers[size];
            passengers[size] = null;
            siftDown();
        }else{
            passengers[0] = null;
        }

        return passenger;
    }

    private void siftDown() {
        int index = 0;
        while(index<size) {
            int leftChildIndex = 2*index+1;
            int rightChildIndex = 2*index+2;
            int indexWithLargestValue = index;

            if (leftChildIndex < size && comparePassengers(passengers[leftChildIndex], passengers[indexWithLargestValue])>0) {
                indexWithLargestValue = leftChildIndex;
            }

            if (rightChildIndex < size && comparePassengers(passengers[rightChildIndex], passengers[indexWithLargestValue])>0) {
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
    public void swap(int index1, int index2) {
        Passenger temp = passengers[index1];
        passengers[index1] = passengers[index2];
        passengers[index2] = temp;
    }


    public int comparePassengers(Passenger passenger1, Passenger passenger2) {
        return Integer.compare(passenger1.boardingClass().getPriority(), passenger2.boardingClass().getPriority());
    }

    private void siftUp() {
        int index = size-1;
        while (index > 0 && passengers[index].boardingClass().getPriority()>passengers[parentIndex(index)].boardingClass().getPriority()) {
            //swap
            Passenger temp = passengers[index];
            passengers[index] = passengers[parentIndex(index)];
            passengers[parentIndex(index)] = temp;

            index = parentIndex(index);
        }
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }


    public boolean isEmpty() {
        return this.size == 0;
    }
}
