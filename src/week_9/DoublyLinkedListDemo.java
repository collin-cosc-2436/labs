package week_9;

public class DoublyLinkedListDemo {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.addToEnd("Hello");
        list.addToEnd("World");
        list.printList();
    }
}

class DoublyNode{
    String data;
    DoublyNode prev;
    DoublyNode next;

    public DoublyNode(String data) {
        this.data = data;
        this.prev = this.next = null;
    }
}
class DoublyLinkedList {
    DoublyNode head;


    public void addToEnd(String data){
        DoublyNode newNode = new DoublyNode(data);
        if(head == null){
            head = newNode;
            return;
        }
        DoublyNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void printList(){
        DoublyNode current = head;
        while(current != null){
            System.out.print(current.data+"<-->");
            current = current.next;
        }
        System.out.println("null");
    }
}
