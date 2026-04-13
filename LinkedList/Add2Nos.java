package LinkedList;

public class Add2Nos {
     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        boolean carry = false;
        while(l1!=null || l2!=null){
            int first = (l1!=null) ? l1.val : 0; 
            int second = (l2!=null) ? l2.val: 0;
            int sum = (carry) ? first+second+1 : first+second;
            carry = false;
            ListNode tojoin;
            if(sum>=10){
                carry = true;
                tojoin = new ListNode(sum%10);
            }
            else{
                tojoin = new ListNode(sum);
            }
            temp.next = tojoin;
            temp=temp.next;
            if(l1!=null && l2!=null){
                l1=l1.next;
                l2=l2.next;
            }
            else if(l1==null) l2 = l2.next;
            else if(l2==null) l1 = l1.next;
        }
        if (carry){
        temp.next = new ListNode(1);
        }
        return dummy.next;
    }
    public ListNode addOneBrute(ListNode head) {
        ListNode l1 = reverseList(head);
        ListNode l2 = new ListNode(1);
        ListNode ans = addTwoNumbers(l1,l2);
        return reverseList(ans);
    }
    
    public ListNode reverseList(ListNode head) {
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
}
