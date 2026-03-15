package Strings;

public class commomPatterns {
      // 1: reverse a string:
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
    
    public boolean palindrome(String s){
        // StringBuilder sb = new StringBuilder(s);
        // String rev =  sb.reverse().toString();
        // return rev.equals(s);
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else break;
        }
        return left>right;
    }
    
    public String reversesent(String s){
        String[] arr = s.split(" ");
        int left = 0;
    int right = arr.length - 1;

    while(left < right){

        String temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
    }
    return  String.join(" ",arr);
    }
    
    public int countvowels(String s){
        int count =0;
        for(char c : s.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                count++;
            }
        }
        return count;
    }
    
    public int countDigits(String s){
        int count = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)) count++;
        }
        return count;
    }
    
    public char maxfreq(String s){
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        int highfreq = 0;
        int highind = 0;
        for(int i=0;i<26;i++){
            if(freq[i]>highfreq){
                highfreq = freq[i];
                highind = i;
            } 
        }
        return (char)('a'+highind);
    }
    
// 5 Remove Spaces
// 6 Character Frequency
// 7 Remove Duplicates
// 8 Anagram
// 9 Longest Common Prefix
// 10 Reverse Words
    
    public static void main(String[] args) {
        commomPatterns m = new commomPatterns();
        String s = "devvvvveeeeeeeeeerma";
        // boolean ans = m.palindrome(s);
        // String ans = m.reversesent(s);
        char ans = m.maxfreq(s);
        System.out.println(ans);
        // Stack<Character> st = new Stack<>();
        // st.push('a');
        // System.out.println(st.peek());
    }
}
