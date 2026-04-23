package LinkedList;
class ListNode {
    int data;
    ListNode prev, next;
    ListNode(int val) {
        this.data = val;
        this.prev = null;
        this.next = null;
    }
}
public class DoublyDelHead_Reverse {
     public ListNode deleteHead(ListNode head) {
        if(head==null || head.next ==null ) return null;
        head = head.next;
        head.prev = null;
        return head;
    }
    public ListNode reverseDLL(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode front = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode back = curr.next;
            curr.next = front;
            curr.prev = back;
            front = curr;
            curr = back;
        }
        return front; 
    }
}
