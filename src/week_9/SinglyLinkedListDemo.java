package week_9;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();
        //head -->null
        list.add("Hello");
        list.printList();
        //head --> [Hello|next]-->null
        list.addToEnd("World");
        list.add("Goodbye");
        list.printList();

        list.reverse();
        list.printList();

       list.reverseRecursive(list.head);
       list.printList();
    }

}


class Node{
    String data;
    Node next;
}

class SinglyLinkedList{
    Node head; //null

    public void add(String data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }
    public void addToEnd(String data){
        Node newNode = new Node();
        newNode.data = data;

        //checks if list is empty
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;


    }

    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data+"-->");
            current = current.next;
        }
        System.out.println("null");
    }

    //[1]-->[2]-->[5]
    public void reverse(){
        Node prev =null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    public Node reverseRecursive(Node head) {
        if (head == null || head.next == null) return head; //base case
        Node rest = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        this.head = rest;
        return rest;
    }

}