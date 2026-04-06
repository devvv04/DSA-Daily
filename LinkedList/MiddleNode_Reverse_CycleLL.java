package LinkedList;
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class MiddleNode_Reverse_CycleLL {
     Node head;
    Node tail;
    int size = 0;
     public void InsertAtHead(int val){
     Node newnode = new Node(val);
     if(size==0){
         head = newnode;
         tail = newnode;
         size=1;
     }
     else{
     newnode.next = head;
     head = newnode;
     size++;
     }
    }
     public void display(){
       Node temp = head;
       while(temp != null){
           System.out.println(temp.val);
           temp = temp.next;
       }
    }
    
   public Node middleNode(Node head) {
        // slow at 1 and fast at 2, inc slow by 1 and fast by 2;
        Node slow = head;
        Node fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
public Node reverseListOptimal(Node head) {
Node prev = null;
Node curr = head;
while(curr!=null){
    Node next = curr.next;
    curr.next = prev;
    prev = curr;
    curr = next;
}
return prev;
}

public boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }

class Main {
    public static void main(String[] args){
        MiddleNode_Reverse_CycleLL ls = new MiddleNode_Reverse_CycleLL();
        
        ls.InsertAtHead(60);
        ls.InsertAtHead(50);
        ls.InsertAtHead(40);
        ls.InsertAtHead(30);
        ls.InsertAtHead(20);
        ls.InsertAtHead(10);
        ls.display();
        System.out.println();
        // Node rev = ls.reverseList(ls.head);
        // System.out.println(rev.val);
        // System.out.println(mid.val);
        
        
    }
}
}
