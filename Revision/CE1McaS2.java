package Revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class CE1McaS2 {
     //STack:
    // 1: valid parenthesis?
    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '('|| c == '{' || c =='['){
                st.push(c);
            }
            else{
                if(st.isEmpty()) return false;
                char top = st.pop(); 
                if(c == ')' && top!='(') return false;
                if(c == '}' && top!='{') return false;
                if(c == ']' && top!='[') return false;
            }
        }
        return st.isEmpty();
    }
    
    // 2: daily temperatures
    public int[] dailyTemperatures(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums.length];
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty()&&nums[i]>=nums[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? 0 : st.peek()-i;
            st.push(i);
        }
        return ans;
    }
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums2){

            while(!st.isEmpty() && st.peek() < num){
                map.put(st.pop(), num);
            }

            st.push(num);
        }

        while(!st.isEmpty()){
            map.put(st.pop(), -1);
        }

        int[] ans = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
    
    
    public static void main(String[] args) {
        CE1McaS2 m = new CE1McaS2();
//  String s = "]";
//  boolean ans = m.isValid(s);
int[] qst = {73,74,75,71,69,72,76,73};
int[] ans = m.dailyTemperatures(qst);
 System.out.println(Arrays.toString(ans));
 
 //         Stack<Integer> st = new Stack<>();
//         st.push(45);
//         st.push(46);
//         st.push(47);
//         st.push(48);
//           System.out.println(st);
// int top = st.pop();
//         System.out.println(top);
//         System.out.println(st);
// Queue<Integer> q = new LinkedList<>();
// q.offer(42);
// q.offer(43);
// q.offer(44);
// q.poll();
// System.out.println(q);

    }
}
