package LinkedList;

public class SortingLL_Intersection {
      public ListNode sortList(ListNode head) {
     if(head==null || head.next==null) return head;
     ListNode mid = findmid(head);
     ListNode right = mid.next;
    mid.next = null;
     ListNode left = head;
     ListNode l1 = sortList(left);
     ListNode l2 = sortList(right);
     ListNode ans =  merge(l1,l2); 
     return ans;
    }
    private ListNode merge(ListNode l1 , ListNode l2){
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next = l1;
                l1=l1.next;
            }
            else{
                temp.next = l2;
                l2=l2.next;
            }
            temp = temp.next;
        }
        if(l1!=null){
            temp.next = l1;
        }
        if(l2!=null){
            temp.next = l2;
        }
        return dummy.next;
    }
    private ListNode findmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
     public ListNode sort012(ListNode head) {
       ListNode dummy0 = new ListNode(-1);
       ListNode dummy1 = new ListNode(-1);
       ListNode dummy2 = new ListNode(-1);
       ListNode temp = head;
       ListNode ll0 = dummy0;
       ListNode ll1 = dummy1;
       ListNode ll2 = dummy2;
       while(temp!=null){
        if(temp.val==0){
            ll0.next = temp;
            ll0 = ll0.next;
        }
        if(temp.val==1){
            ll1.next = temp;
            ll1 = ll1.next;
        }
        if(temp.val==2){
            ll2.next = temp;
            ll2 = ll2.next;
        }
        temp = temp.next;
       }
       ll0.next = (dummy1.next!=null) ? dummy1.next : dummy2.next;
       ll1.next = dummy2.next;
       ll2.next = null;
        return dummy0.next;
    }
     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa = headA;
        ListNode tempb = headB;
        int counta = 0;
        int countb = 0;
        while(tempa!=null){
            counta++;
            tempa=tempa.next;
        }
        while(tempb!=null){
            countb++;
            tempb=tempb.next;
        }
    
        int gap = (counta>countb) ? counta-countb : countb-counta;
        ListNode slow = (counta>countb) ? headB : headA;
        ListNode fast = (counta>countb) ? headA : headB;
            for(int i=0;i<gap;i++){
                fast = fast.next;
            }

        while(fast!=null){
            if(slow==fast) return slow;
            slow=slow.next;
            fast = fast.next;
        }
        return null;
    }
}
