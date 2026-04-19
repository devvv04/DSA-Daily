package LinkedList;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode child;

    ListNode() {
        val = 0;
        next = null;
        child = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        child = null;
    }

    ListNode(int data1, ListNode next1, ListNode next2) {
        val = data1;
        next = next1;
        child = next2;
    }
}
public class Flattening_DeepCopy {
      public ListNode flattenLinkedList(ListNode head) {
       if (head == null || head.next == null) return head;
       ListNode right = flattenLinkedList(head.next);
       head.next = null;
       return mergefromchild(head,right);
    }
    private ListNode mergefromchild(ListNode l1, ListNode l2){
        ListNode ansd = new ListNode(-1);
        ListNode anst = ansd;
        ListNode t1 = l1;
        ListNode t2 = l2;
        while(t1!=null&&t2!=null){
            if(t1.val<t2.val){
                anst.child = t1;
                t1 = t1.child;
            }
            else{
                anst.child = t2;
                t2 = t2.child;
            }
            anst = anst.child;
        }
        if(t1==null) anst.child = t2;
        if(t2==null) anst.child = t1;
        return ansd.child;
    }
      public Node copyRandomListwithHM(Node head) {
    HashMap<Node,Node> mp = new HashMap<>();
    Node temp = head;
    while(temp!=null){
        Node nn = new Node(temp.val);
        mp.put(temp,nn);
        temp =temp.next;
    }
    temp = head;
    while(temp!=null){
        mp.get(temp).next = mp.get(temp.next);
        mp.get(temp).random = mp.get(temp.random);
        temp = temp.next;
    }
    return mp.get(head);
}
public Node copyRandomListOptimal(Node head) {
 
    Node temp = head;
    while(temp!=null){
        Node store = temp.next;
        Node nn =  new Node(temp.val);
        temp.next = nn;
        nn.next = store;
        temp = temp.next.next;
    }

    temp = head;
    while(temp!=null){
       if(temp.random!=null){
        temp.next.random = temp.random.next;
       }
       temp = temp.next.next;
    }

    Node ansd = new Node(-1);
    Node anst = ansd;
    temp = head;
    while(temp!=null){
        Node copy = temp.next;
        anst.next = copy;
        anst = copy;
        temp.next = copy.next;
        temp = temp.next;
    }
    return ansd.next;
}
}
