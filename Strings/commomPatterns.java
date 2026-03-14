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
    
    
    
//     1 Reverse String
// 2 Palindrome
// 3 Count Vowels
// 4 Count Digits
// 5 Remove Spaces
// 6 Character Frequency
// 7 Remove Duplicates
// 8 Anagram
// 9 Longest Common Prefix
// 10 Reverse Words
    
    public static void main(String[] args) {
        commomPatterns m = new commomPatterns();
        String s = "hel1dev465in";
        // boolean ans = m.palindrome(s);
        // String ans = m.reversesent(s);
        int ans = m.countDigits(s);
        System.out.println(ans);
        // Stack<Character> st = new Stack<>();
        // st.push('a');
        // System.out.println(st.peek());
    }
}
