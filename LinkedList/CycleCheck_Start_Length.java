package LinkedList;
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        val = 0;
        next = null;
    }

    ListNode(int data1) {
        val = data1;
        next = null;
    }

    ListNode(int data1, ListNode next1) {
        val = data1;
        next = next1;
    }
}
public class CycleCheck_Start_Length {
      public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }
     public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                ListNode temp = head;
                while(temp!=slow){
                    slow = slow.next;
                    temp = temp.next;
                }
                return slow;
            }
        }
        return null;
    }
     public int findLengthOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                ListNode temp = slow.next;
                int count = 1;
                while(temp!=slow){
                    count++;
                    temp = temp.next;
                }
                return count;
            }

        }
return 0;
     }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}
