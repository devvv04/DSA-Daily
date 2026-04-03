package Strings;

public class LongPalin_BeautySum_Kdist {
     public String longestPalindrome(String s) {
        //brute n3
        // int longest = -1;
        // int longi = 0;
        // int longj = 0;
        // for(int i =0;i<s.length();i++){
        //     for(int j = i+1;j<s.length();j++){
        //         if(ispalin(s,i,j)){
        //             int len = j-i+1;
        //             if(len>longest){
        //                 longi = i;
        //                 longj = j;
        //                 longest = len;
        //             }
        //         }
        //     } 
        // }
        // return s.substring(longi,longj+1);

        //optimal try(dp) n2:
        String ans = "";
        int maxlen = 0;
        int n = s.length();
       int[][] dp = new int[n][n];
        for(int diff=0;diff<n;diff++){
            for(int i=0,j=diff+i;j<n;i++,j++){
               if(i==j){
                dp[i][j]=1;
               }
               else if(diff==1){
                dp[i][j] = s.charAt(i)==s.charAt(j) ? 2 : 0; 
               }
               else{
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]>0){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else{
                    dp[i][j] = 0;
                }
               }
               
               if( dp[i][j]  > maxlen){
                maxlen = dp[i][j];
                ans = s.substring(i,j+1);
               }

            }
        }
        return ans;
    }

    // private boolean ispalin(String s){
    //     int start = 0;
    //     int end = s.length()-1;
    //     while(start<end){
    //         if(s.charAt(start) != s.charAt(end)) return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }
    
    public int beautySumn3(String s) {
        int ans = 0;
        for(int i=0;i<s.length()-1;i++){
            for(int j=i+1;j<s.length();j++){
            String subs = s.substring(i,j+1);
            ans = ans + countbeauty(subs);
        }
        }
        return ans;
    }

    private int countbeauty(String s){
        if(s.length()==1) return 0; 
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c-97]++;
        }
        int large = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        for(int i=0;i<26;i++){
            if(freq[i]>large){
                large = freq[i];
            }
            if(freq[i]<small && freq[i]!=0){
                small = freq[i];
            }
        }
        return large-small;
    }
    
    public int beautySumOptimaln2(String s) {
        int ans = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]!=0){
                        min = Math.min(min,freq[k]);
                        max = Math.max(max,freq[k]);
                    }
                }
                ans = ans + (max-min);
            }
        }
        return ans;
    }

    //count of 0 should in freq arr should be 26-k
    public int countsubstrwithkdistinct(String s, int k){
        int n = s.length();
        int count = 0;
        for(int i=0;i<n;i++){
            int[] freq = new int[26];
            for(int j = i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(dist(freq,k)) count++; 
            }
        }
        return count;
    }
    private boolean dist(int[]freq , int k ){
        int count = 0;
        for(int i=0;i<26;i++){
            if(freq[i]!=0)count++;
        }
        return count==k;
    }
    
    public static void main(String[] args) {
        LongPalin_BeautySum_Kdist m = new LongPalin_BeautySum_Kdist();
        String s = "abcbaa";
        int ans = m.countsubstrwithkdistinct(s,3);
         System.out.println(ans);
    }
}
