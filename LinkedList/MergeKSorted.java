package LinkedList;

import java.util.PriorityQueue;

public class MergeKSorted {
    public ListNode mergeKLists(ListNode[] lists) {
        //brute using join all list and simply sort
    //     if(lists.length==0) return null;
    //     if(lists.length==1) return lists[0];
    //     ListNode ansd = new ListNode(-1);
    //     ListNode anst = ansd;
    //     for(int i=0;i<lists.length;i++){
    //         anst.next = lists[i];
    //         while(anst.next!=null){
    //             anst=anst.next;
    //         }
    //     }
    //     anst.next=null;
    //     return sortList(ansd.next);
    // }
    // public ListNode sortList(ListNode head) {
    //  if(head==null || head.next==null) return head;
    //  ListNode mid = findmid(head);
    //  ListNode right = mid.next;
    // mid.next = null;
    //  ListNode left = head;
    //  ListNode l1 = sortList(left);
    //  ListNode l2 = sortList(right);
    //  ListNode ans =  merge(l1,l2); 
    //  return ans;
    // }
    // private ListNode merge(ListNode l1 , ListNode l2){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode temp = dummy;
    //     while(l1!=null && l2!=null){
    //         if(l1.val<l2.val){
    //             temp.next = l1;
    //             l1=l1.next;
    //         }
    //         else{
    //             temp.next = l2;
    //             l2=l2.next;
    //         }
    //         temp = temp.next;
    //     }
    //     if(l1!=null){
    //         temp.next = l1;
    //     }
    //     if(l2!=null){
    //         temp.next = l2;
    //     }
    //     return dummy.next;
    // }
    // private ListNode findmid(ListNode head){
    //     ListNode slow = head;
    //     ListNode fast = head.next;
    //     while(fast!=null && fast.next!=null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
    //     return slow;
    // }

    //optimal using heap :
    ListNode ansd = new ListNode(-1);
    ListNode anst = ansd;
    PriorityQueue<ListNode> pq =  new PriorityQueue<>(
        (a,b)->a.val - b.val
    );
    for(ListNode node : lists){
        if(node!=null){
        pq.offer(node);
        }
    }
    while(!pq.isEmpty()){
        ListNode curr = pq.poll();
        anst.next = curr;
        anst = anst.next;
        if(curr.next!=null){
            pq.offer(curr.next);
        }
    }
    anst.next=null;
    return ansd.next;
    }
}
