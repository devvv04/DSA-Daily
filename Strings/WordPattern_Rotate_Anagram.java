package Strings;

import java.util.Arrays;
import java.util.HashMap;

public class WordPattern_Rotate_Anagram {
      public boolean wordPattern(String pattern, String s) {
       
        String[] arr = s.split(" ");
        if(pattern.length()!=arr.length) return false;
         HashMap<Character,String> ps = new HashMap<>();
         HashMap<String,Character> sp = new HashMap<>();
         for(int i=0;i<pattern.length();i++){
            char cp = pattern.charAt(i);
            String cs = arr[i];
            if(ps.containsKey(cp) && !ps.get(cp).equals(cs)) return false;
            if(sp.containsKey(cs) && !sp.get(cs).equals(cp)) return false;
            ps.put(cp,cs);
            sp.put(cs,cp);
         }
         return true;
       
        
    }
    
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
        String twotimes = s+s;
        return twotimes.contains(goal);
    }
    
    public boolean isAnagramUsing2Arr(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] nums = new int[26];
        int[] nums1 = new int[26];
        for(int i=0;i<s.length();i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            nums[cs-97]++;
            nums1[ct-97]++;
        }
        return Arrays.equals(nums,nums1);
    }
    
    public static void main(String[] args) {
        WordPattern_Rotate_Anagram m = new WordPattern_Rotate_Anagram();
        String qst = "abcde";
        // String qst1 = "cdeba";
        String qst2 = "cdeab";
        boolean ans = m.rotateString(qst,qst2);
        System.out.println(ans);
        // char ch = 'b';
        // System.out.println(ch-97);
    }
}
