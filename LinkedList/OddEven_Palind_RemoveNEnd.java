package LinkedList;
 
public class OddEven_Palind_RemoveNEnd {
     public ListNode removeNthFromEnd(ListNode head, int n) {
        //brute: 
        int count = 0;
        ListNode temp = head; 
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        if (count == n) {
        return head.next;
    }
        temp = head;
        for(int i=0;i<count-n-1;i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
      public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        ListNode first = head;
        while(prev!=null){
            if(first.val!=prev.val) return false;
            first = first.next;
            prev = prev.next;
        }
        return true;
    }
     public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = evenStart;
        return head;
    }
}
