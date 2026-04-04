package Strings;

import java.util.HashMap;

public class countAndSay_HappyPrefixBrute {
       public String countAndSay(int n) {
    if(n==1) return "1";
    String prev = countAndSay(n-1);
    return rle(prev);
    
}
private String rle(String s){
    int l = 0;
    int r =1;
    StringBuilder sb = new StringBuilder();

    while(r<s.length()){
        int count = 0;
        
        if(s.charAt(l)==s.charAt(r))r++;
        else{
            count = r-l;
            sb.append(Integer.toString(count));
            sb.append(s.charAt(l));
            l = r;
            r++;
        }
    }
    sb.append(Integer.toString(r-l));
    sb.append(s.charAt(l));
    return sb.toString();
}
 public String longestPrefix(String s) {
        //optimal is kmp
        //brute:
        HashMap<String,Integer> mpprefix = new HashMap<>();
        HashMap<String,Integer> mpsuffix = new HashMap<>();
        for(int i=0;i<s.length()-1;i++){
            mpprefix.put(s.substring(0,i+1),(i+1));
        }
        for(int j=s.length()-1;j>0;j--){
            mpsuffix.put(s.substring(j,s.length()),(s.length()-j));
        }
        String ans = "";
        int maxlen = 0;
        for(String key : mpprefix.keySet()){
            if(mpsuffix.containsKey(key)&&maxlen<mpsuffix.get(key)){
                maxlen = mpsuffix.get(key);
                ans = key;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // System.out.println("Try");
        // StringBuilder sb = new StringBuilder();
        // sb.append("World");
        // String s = "hello";
        // char c = 'a';
        // sb.append(c);
        // System.out.println(sb);
        // String s = "ababab";
        
        // System.out.println(s.substring(0,4));
        String s = "ababab";
        HashMap<String,Integer> mpprefix = new HashMap<>();
        HashMap<String,Integer> mpsuffix = new HashMap<>();
        for(int i=0;i<s.length()-1;i++){
            mpprefix.put(s.substring(0,i+1),(i+1));
        }
        for(int j=s.length()-1;j>0;j--){
            mpsuffix.put(s.substring(j,s.length()),(s.length()-j));
        }
        System.out.println(mpsuffix);
        System.out.println(mpsuffix);
    }
}
