package Strings;

import java.util.HashMap;
import java.util.Stack;

public class Parenthesis_LargestOddPrefix_Isomorphic {
     public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                if(!st.isEmpty()) sb.append(c);
                st.push(c);
            }
            else if(c == ')'){
                st.pop();
                if(!st.isEmpty()){
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }
    
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        int l = 0;
        int r = arr.length-1;
        while(l<r){
            String temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        return String.join(" ",arr);
    }
    
    public String largestOddNumber(String num) {
        for(int i=num.length()-1;i>=0;i--){
            int digit = num.charAt(i) - '0';
            if(digit % 2 != 0) return num.substring(0,i+1);
        }
        return "";
    }
    
    public String longestCommonPrefix(String[] strs) {
        int minlen = Integer.MAX_VALUE;
        for(String s : strs){
            if(s.length()<minlen) minlen = s.length();
        }
        for(int i = 0;i<minlen;i++){
            char c = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
            
        }
        return strs[0].substring(0,minlen);
    }
    
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> st = new HashMap<>();
        HashMap<Character,Character> ts = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(!st.containsKey(cs) && !ts.containsKey(ct)){
                st.put(cs,ct);
                ts.put(ct,cs);
            }
            else if(st.containsKey(cs) && st.get(cs)!=ct) return false;
            else if(ts.containsKey(ct)  && ts.get(ct)!=cs) return false;
        }
        return true;
    }
    
    
    
    public static void main(String[] args) {
        Parenthesis_LargestOddPrefix_Isomorphic m = new Parenthesis_LargestOddPrefix_Isomorphic();
        // String qst = "(())";
        String qst = "baba";
        String qst2 = "badc";
        // String[] arr = {"flower","flow","flight"};
        // String ans = m.longestCommonPrefix(arr);
        Boolean ans = m.isIsomorphic(qst,qst2);
        System.out.println(ans);
    //     for(int i = 0; i < 128; i++){
    // System.out.println(i + " : " + (char)i);
// }

// for(String s : arr){
//     System.out.println(s);
// }
// Arrays.sort(arr);
// for(int i=0;i<arr.length;i++){
// System.out.println(arr[i]);
// }
    }
}
