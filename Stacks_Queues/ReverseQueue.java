package Stacks_Queues;
import java.util.*;
class Main {
    
    public static void main(String[] args) {
       Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
    Stack<Integer> st = new Stack<>();
    while(!q.isEmpty()){
        st.push(q.remove());
    }
    while(!st.isEmpty()){
        q.add(st.pop());
    }
    System.out.println(q);
    
    
    //2:
    Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);
        int k = 3;
         Stack<Integer> st2 = new Stack<>();
         for(int i = 0; i < k; i++) {
    st2.push(q2.remove());
}
         Queue<Integer> ans = new LinkedList<>();
        while(!st2.isEmpty()){
        ans.add(st2.pop());
    }
    while(!q2.isEmpty()){
        ans.add(q2.remove());
    }
    System.out.println(ans);
    
    // 3
    // Queue<Integer> q3 = new LinkedList<>();
    //     q3.add(2);
    //     q3.add(4);
    //     q3.add(3);
    //     q3.add(1);
    //     q3.add(5);
    //     q3.add(6);
    //     Stack<Integer> st3 = new Stack<>();
    //     Stack<Integer> st4 = new Stack<>();
        
    }
}
