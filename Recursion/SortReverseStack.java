package Recursion;

import java.util.Stack;

public class SortReverseStack {
      public void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st,temp);
        }
    }
    protected void insert(Stack<Integer> st , int temp){
        if(st.isEmpty()||st.peek()<=temp){
            st.push(temp);
            return;
        }
        int val = st.pop();
        insert(st,temp);
        st.push(val);
    }
    public void reverseSt(Stack<Integer> st){
        if(st.isEmpty()) return;
        int temp = st.pop();
        reverseSt(st);
        insertbottom(st,temp);
    }
    protected void insertbottom(Stack<Integer> st, int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        } 
        int val = st.pop();
        insertbottom(st,temp);
        st.push(val);
        
    }
     public static void main(String[] args) {
        SortReverseStack m = new SortReverseStack();
        System.out.println("Start small. Ship something.");
        Stack<Integer> st = new Stack<>();
        st.push(28);
        st.push(47);
        st.push(2);
        st.push(55);
        st.push(4);
        // m.sortStack(st);
        m.reverseSt(st);
        while(!st.isEmpty()){
            System.out.println(st.pop());
        }
    }

}
