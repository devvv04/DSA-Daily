package Recursion;

import java.util.ArrayList;
import java.util.List;

public class generateBinStr_Parenthes {
     public List<String> generateBinaryStrings(int n) {
        List<String> ls = new ArrayList<>();
        String curr = "";
        return generate(curr,ls,n);
    }
    protected List<String> generate(String curr,List<String> ls,int n){
        if(curr.length()==n){
            ls.add(curr);
            return ls;
        }
        generate(curr+"0",ls,n);
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!='1'){
            generate(curr+"1",ls,n);
        }
        return ls;
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String curr = "";
        return generateP(curr,0,0,ans,n);
    }
    protected List<String> generateP(String curr,int open,int close,List<String> ans,int n){
        if(curr.length() == 2*n){
            ans.add(curr);
            return ans;
        }
        if(open<n) generateP(curr+'(',open+1,close,ans,n);
        if(close<open) generateP(curr+')',open,close+1,ans,n);
        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");
        generateBinStr_Parenthes m = new generateBinStr_Parenthes();
        int n = 2;
        // List<String> ls = m.generateBinaryStrings(n);
        List<String> ls = m.generateParenthesis(n);
        System.out.println(ls);
    }
}
