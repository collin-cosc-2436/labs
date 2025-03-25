package week_9;

public class CircularLinkedListDemo {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.addToEnd("Hello");
        list.addToEnd("World");

        list.printList();
    }
}


class CircularNode{
    String data;
    CircularNode next;
    public CircularNode(String data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList{
    CircularNode head;

    public void addToEnd(String data){
        CircularNode newNode = new CircularNode(data);
        if(head == null){
            head = newNode;
            head.next = newNode;
            return;
        }

        CircularNode current = head;
        while(current.next != head){
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
    }

    public void printList(){
        if(head == null) return; //empty
        CircularNode current = head;
       do{
           System.out.print(current.data+"-->");
           current = current.next;
        } while(current != head);
        System.out.println("null");
    }
}