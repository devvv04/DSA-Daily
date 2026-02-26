package LinkedList;

public class MyLinkedList {
     class Node{
    int val;
    Node next;
    }
    int size = 0;
    Node head;
    Node tail;
    public MyLinkedList() {
      
    }
    
    public int get(int index) {
Node temp = head;
if(index < 0 || index >= size){
    return -1;
}
else{
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
}
        return temp.val;
    }
    
    public void addAtHead(int val) {
        Node nn = new Node();
        nn.val = val;
        if(size == 0){
            head = nn;
            tail = nn;
            size = 1;
        }
        else{
            nn.next = head;
            head = nn;
            size++;
        }
    }
    
    public void addAtTail(int val) {
        Node nn = new Node();
        nn.val = val;
        if(size == 0){
            head =nn;
            tail = nn;
            size++;
        }
        else{
            // nn.next = null;
            tail.next = nn;
            tail = nn;
            size++;
        }
    }
    
    public void addAtIndex(int index, int val) {
if(index>size){
        return;
    }

        Node nn = new Node();
        nn.val = val;

// Case 1: Insert at head
    if(index == 0){
        nn.next = head;
        head = nn;
        size++;
        return;
    }
    if(index == size){
    addAtTail(val);
    return;
}

      Node temp = head;
        for(int i = 0;i<index-1;i++){
temp = temp.next;
            
        }
        nn.next = temp.next;
            temp.next = nn;
            size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size){
            return;
        }
        if(index == 0){
            head = head.next;
            if(size == 1) tail = null;
            size--;
            return;
        }
       Node temp = head;
       Node prev = null;
       for(int i=0;i<index;i++){
        prev = temp;
        temp = temp.next;
       }
       prev.next = temp.next;
       if(temp==tail){
        tail = prev;
       }
       size--;
    }
    
    
    public static void main(String[] args){
        MyLinkedList nn = new MyLinkedList();
        nn.addAtHead(10);
        nn.addAtTail(30);
        nn.addAtIndex(1,20);
        // Node temp = head;
        MyLinkedList.Node temp = nn.head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
