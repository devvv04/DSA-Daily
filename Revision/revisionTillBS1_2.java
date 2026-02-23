package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class revisionTillBS1_2 {
      public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for(int n : nums){
            if(count == 0){
                candidate = n;
                count = 1;
            }
            else if(n == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
    
    public int maxSubArray(int[] nums) {
     int cs = 0;
     int ms = Integer.MIN_VALUE;
     for(int n : nums){
         cs = cs + n;
         ms = Math.max(ms,cs);
         if(cs < 0){
             cs = 0;
         }
     }
     return ms;
    }
    
    public int[] maxSubArrayExtend(int[] nums){
        int cs = 0;
        int start = 0;
        int end = 0;
        int tempst = 0;
     int ms = Integer.MIN_VALUE;
     for(int i=0; i<nums.length;i++){
         cs = cs + nums[i];
         if(cs>ms){
             ms = cs;
             start = tempst;
             end = i;
         }
         if(cs < 0){
             cs = 0;
             tempst = i+1;
         }
     }
     int[] res = Arrays.copyOfRange(nums, start, end + 1);
     return res;
    }
    
    public int maxProfit(int[] prices) {
       int min = Integer.MAX_VALUE;
       int profit = 0;
       for(int n : prices){
            if(n < min){
                min = n;
            }
            else if(n - min > profit){
                profit = n - min;
            }
       }
       return profit; 
    }
    
    public int[] rearrangeArray(int[] nums) {
        int even = 0;
        int odd = 1;
        int[] ans = new int[nums.length];
        for(int n : nums){
            if(n>=0){
                ans[even] = n;
                even = even+2;
            }
            else{
                ans[odd] = n;
                odd = odd+2;
            }
        }
        return ans;
    }
    
     public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        //edge case if no idx found i.e last permut
            if(idx==-1)  {
                Arrays.sort(nums);
                return;
            }
        for(int j = nums.length-1;j>idx;j--){
            if(nums[j]>nums[idx]){
                int temp = nums[j];
                nums[j] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(nums,idx+1,nums.length-1);
    }
    private void reverse(int[] nums, int start , int end){
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
        int max = nums[nums.length-1];
        ls.add(max);
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]>max){
                max = nums[i];
                ls.add(max);
            }
        }
        Collections.reverse(ls);
        return ls;
    }
    
      public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int streak = 0;
        int maxlen = 0;
        for(int n : nums){
            set.add(n);
        }
            for(int d : set){
            if(!set.contains(d-1)){
                int curr = d;
                streak = 1;
                while(set.contains(curr+1)){
                    streak++;
                    curr=curr+1;
                }
                 maxlen = Math.max(maxlen,streak);
            }
        }
        return maxlen;
    }
    
    public static void main(String[] args) {
        revisionTillBS1_2 m = new revisionTillBS1_2();
        int[] qst = {100,4,200,1,3,2};
        int ans = m.longestConsecutive(qst);
        // int[] ans = m.rearrangeArray(qst);
        // List<Integer> ls = new ArrayList<>();
        // ls = m.leaders(qst);
        // System.out.println(Arrays.toString(qst));
        System.out.println(ans);
    }
}
