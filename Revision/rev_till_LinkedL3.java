package Revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class rev_till_LinkedL3 {
     public int[] maxSubArrayExtend(int[] nums) {
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        int start = 0;
        int ansend = -1;
        int ansstart = -1;
        for(int i=0;i<nums.length;i++){
            cs = cs + nums[i];
            if(cs>ms){
                ms = cs;
                ansstart = start;
                ansend = i;
            }
            if(cs<0){
                cs = 0;
                start = i+1;
            }
        }
        int len = ansend - ansstart + 1;
        int ans[] = new int[len];
        for(int k =0;k<len;k++){
            ans[k] = nums[ansstart];
            ansstart++;
        }
        return ans;
    }
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int n  : prices){
            if(n<min){
                min = n;
            }
            else if(n-min>profit){
                profit = n-min;
            }
        }
        return profit;
    }
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int even = 0;
        int odd = 1;
        for(int n:nums){
            if(n>=0){
                ans[even]=n;
                even=even+2;
            }
            else{
                ans[odd]=n;
                odd=odd+2;
            }
        }
        return ans;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int ind = -1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind = i;
                break;
            }
        }
        if(ind == -1) reverse(nums,0,n-1);
        else{
            for(int j = n-1;j>ind;j--){
                if(nums[j]>nums[ind]){
                    int temp = nums[j];
                    nums[j] = nums[ind];
                    nums[ind] = temp;
                    break;
                }
            }
            reverse(nums,ind+1,n-1);
        }
    }
    protected void reverse(int[]nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public List<Integer> leaders(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[nums.length-1]);
        int max = nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>max){
                max = nums[i];
                ls.add(max);
            }
        }
        Collections.reverse(ls);
        return ls;
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int ans = 0;
        for(int n:nums){
            hs.add(n);
        }
        // for(int num : nums){
        //     int val = num ;
        //     while(hs.contains(val-1)){
        //         val = val-1;
        //     }
        //     int count = 0;
        //     while(hs.contains(val)){
        //         count++;
        //         val++;
        //     }
        //     ans = Math.max(ans,count);
        // }
        // return ans;

        for(int d : hs){
            if(!hs.contains(d-1)){
                int curr = d;
                int count = 0;
                while(hs.contains(curr)){
                    count++;
                    curr++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
         for(int i=0;i<boxGrid.length;i++){
             boolean empty = false;
             int fempty = 0;
        for(int r=boxGrid[0].length-1;r>=0;r--){
            if(boxGrid[i][r]=='.'){
                if(empty==false){
                    empty = true;
                    fempty = r;
                }
            }
            else if(boxGrid[i][r]=='*'){
                empty = false;
            }
            else if(boxGrid[i][r]=='#'){
                if(empty==true){
                    boxGrid[i][fempty] = '#';
                    boxGrid[i][r] = '.';
                    fempty--;
                }
            }
        }
         }
        char[][] ans = new char[boxGrid[0].length][boxGrid.length];

int rows = boxGrid.length;
int cols = boxGrid[0].length;

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        ans[j][rows - 1 - i] = boxGrid[i][j];
    }
}
         return ans;
    }
}
