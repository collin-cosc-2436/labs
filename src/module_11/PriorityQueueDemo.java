package module_11;

import java.util.PriorityQueue;


record Pax(String name, int priorityScore){}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Pax> queue = new PriorityQueue<>((p1,p2) -> Integer.compare(p2.priorityScore(), p1.priorityScore()));

        queue.add(new Pax("Bob", 1));
        queue.add(new Pax("John", 3));
        queue.add(new Pax("Alice", 2));

        System.out.println("Boarding order: ");
        while (!queue.isEmpty()) {
            Pax pax = queue.poll();
            System.out.println("Now boarding: "+ pax.name()+" priority: "+pax.priorityScore());
        }
    }
}
