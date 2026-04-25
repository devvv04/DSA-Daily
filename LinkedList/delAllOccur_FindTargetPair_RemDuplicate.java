package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode() {
        val = 0;
        next = null;
        prev = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
        prev = null;
    }

    ListNode(int data1, ListNode next1, ListNode prev1) {
        val = data1;
        next = next1;
        prev = prev1;
    }
}
public class delAllOccur_FindTargetPair_RemDuplicate {
    public ListNode deleteAllOccurrences(ListNode head, int target) {
        ListNode temp = head;
        while(temp!=null){
            ListNode newnode = temp.next;
            if(temp.val==target){
                if(temp==head){
                    if(temp.next==null) return null;
                    else{
                        head= temp.next;
                        head.prev = null;
                    }
                }
                else{
                    if(temp.prev!=null){
                        temp.prev.next = temp.next;
                    }
                    if(temp.next!=null){
                        temp.next.prev = temp.prev;
                    }
                }
            }
            temp = newnode;
        }
        return head;
    }
     public List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ListNode left = head;
        ListNode right = head;
        while(right.next!=null){
            right = right.next;
        }
        while(left!=null && right!=null && right!=left && right.next!=left){
            int leftval = left.val;
            int rightval = right.val;
            int sum = leftval+rightval;
            if(sum==target){
                ans.add(Arrays.asList(leftval,rightval));
                left = left.next;
                right = right.prev;
            }
            else if(sum>target){
                right = right.prev;
            }
            else{
                left = left.next;
            }
        }
        return ans;
    }
    public ListNode removeDuplicates(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode temp = head;
        while(temp!=null&& temp.next!=null){
            ListNode check = temp.next;
            while(check!=null&&check.val==temp.val){
                check=check.next;
            }
            temp.next = check;
            if(check!=null) check.prev = temp;
            temp = check;
        }
        return head;
    }
}
