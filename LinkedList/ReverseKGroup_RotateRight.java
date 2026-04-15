package LinkedList;

public class ReverseKGroup_RotateRight {
      public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode temp = head;
        ListNode ansd = new ListNode(-1);
        ListNode anst = ansd;
        while(temp!=null){
            ListNode toconnect = temp;
            for(int i=0;i<k-1;i++){
                temp = temp.next;
                if(temp==null) break;
            }
           ListNode kth = (temp==null) ? null : temp;
            if(kth == null){
                anst.next = toconnect;
                break;
            }
            else{
            ListNode nextkth = kth.next;
            kth.next = null;
            ListNode newhead = reverse(toconnect);
            anst.next = newhead;
            anst = toconnect;
            temp = nextkth;
            }
        }
        return ansd.next;
    }
    public ListNode reverse(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while(curr!=null){
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
    }
    public ListNode rotateRight(ListNode head, int k) {
        //1 : my try:
        // if(k==0) return head;
        // if(head==null) return head;
        // int len = 0;
        // ListNode temp = head;
        // while(temp != null){
        //     len++;
        //     temp = temp.next;
        // }
        // k = k % len;
        // if(k==0) return head;
        // ListNode prev = null;
        // ListNode slow = head;
        // ListNode fast = head;
        // for(int i=0;i<k;i++){
        //     fast = fast.next;
        // }
        // while(fast!=null){
        //     prev = slow;
        //     slow = slow.next;
        //     fast=fast.next;
        // }
        // ListNode newhead =slow;
        // prev.next = null;
        // ListNode newtemp = newhead;
        // while(newtemp.next!=null){
        //     newtemp = newtemp.next;
        // }
        // newtemp.next = head;
        // return newhead;

        // 2: using circular linked list 
        if(head==null || head.next==null || k==0) return head;
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
            tail = tail.next;
            len++;
        }
        tail.next = head;
        ListNode temp = head;
        k = k % len;
        if(k==0) return head;
        int togo = len - k;
        for(int i=0;i<togo-1;i++){
            temp = temp.next;
        }
        ListNode newhead = temp.next;
        temp.next = null;
        return newhead;

    }
}
