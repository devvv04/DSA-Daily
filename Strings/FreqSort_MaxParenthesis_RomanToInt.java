package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class FreqSort_MaxParenthesis_RomanToInt {
     public String frequencySort(String s) {
    HashMap<Character,Integer> mp = new HashMap<>();
    for(char ch : s.toCharArray()){
        mp.put(ch,mp.getOrDefault(ch,0)+1);
    }
    List<Character> ls = new ArrayList<>(mp.keySet());
    Collections.sort(ls,(a,b)->mp.get(b)-mp.get(a));
    StringBuilder sb = new StringBuilder();
    for(char l : ls){
        int times = mp.get(l);
        while(times-->0) sb.append(l);
    }
    return sb.toString();
    }
    
    public int maxDepthParenthesis(String s) {
     Stack<Character> st = new Stack<>();
     int top = 0;
     int ans = 0;
     for(char c : s.toCharArray()){
         if(c == '('){
             st.push(c);
             top++;
             ans = Math.max(ans,top);
         }
         else if(c == ')'){
             st.pop();
             top--;
         }
     }
     return ans;
    }
    
    public int romanToInt(String s) {
    HashMap<Character,Integer> mp = new HashMap<>();
    mp.put('I',1);
    mp.put('V',5);
    mp.put('X',10);
    mp.put('L',50);
    mp.put('C',100);
    mp.put('D',500);
    mp.put('M',1000);
    int ans = 0;
    for(int i=0;i<s.length()-1;i++){
    if(mp.get(s.charAt(i))<mp.get(s.charAt(i+1))){
        ans = ans - mp.get(s.charAt(i));
    }
    else{
        ans = ans + mp.get(s.charAt(i));
    }
    }
    ans = ans + mp.get(s.charAt(s.length()-1));
    return ans;
    }
    
    public static void main(String[] args) {
        FreqSort_MaxParenthesis_RomanToInt m = new FreqSort_MaxParenthesis_RomanToInt();
        String s = "MCMXCIV";
        int ans = m.romanToInt(s);
        System.out.println(ans);
    }
}
