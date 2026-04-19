package LinkedList;

public class DoublyLL_inserthead {

    class ListNode {
        public int data;
        public ListNode prev;
        public ListNode next;

        // constructors
        public ListNode() {
        }

        public ListNode(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }

        public ListNode(int data, ListNode prev, ListNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    ListNode head;
    ListNode tail;
    int size = 0;

    public void InsertAtHead(int val) {
        ListNode newnode = new ListNode(val);

        if (size == 0) {
            head = newnode;
            tail = newnode;
            size = 1;
        } else {
            newnode.next = head;
            head.prev = newnode;
            head = newnode;
            size++;
        }
    }

    // optional: print list
    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    // main method for testing
    public static void main(String[] args) {
        DoublyLL_inserthead list = new DoublyLL_inserthead();

        list.InsertAtHead(10);
        list.InsertAtHead(20);
        list.InsertAtHead(30);

        list.display();  // Expected: 30 <-> 20 <-> 10 <-> NULL
    }
}