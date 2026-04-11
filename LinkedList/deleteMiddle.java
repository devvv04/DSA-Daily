package LinkedList;

import java.util.Arrays;

public class deleteMiddle {
     public ListNode deleteMiddlefn(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow==head) return null;
        prev.next = prev.next.next;
        return head;
    }
     public ListNode sortListBrute(ListNode head) {
        //brute
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int[] arr = new int[count];
        temp = head;
        int i = 0;
        while(temp!=null){
            arr[i]=temp.val;
            temp=temp.next;
            i++;
        }
        Arrays.sort(arr);
        temp = head;
        for(int k=0;k<arr.length;k++){
            temp.val = arr[k];
            temp = temp.next;
        }
        return head;
    }
}
