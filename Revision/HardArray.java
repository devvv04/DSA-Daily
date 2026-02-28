package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HardArray {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            ans.add(PascalRow(i));
        }
        return ans;
    }
    private List<Integer> PascalRow(int row){
        List<Integer> each = new ArrayList<>();
        each.add(1);
        long ans = 1;
        for(int i=1;i<row;i++){
            ans = ans * (row-i) / i;
            each.add((int)ans);
        }
        return each;
    }

      public List<List<Integer>> fourSum(int[] nums, int target){
          List<List<Integer>> res = new ArrayList<>();
          Arrays.sort(nums);
          for(int i =0;i<nums.length-3;i++){
              if(i>0 && nums[i]==nums[i-1]) continue;
              for(int j=i+1;j<nums.length-2;j++){
                  if(j>i+1 && nums[j]==nums[j-1]) continue;
                  int start = j+1;
                  int end = nums.length-1;
                  while(start<end){
                      long sum = (long) nums[i]+nums[j]+nums[start]+nums[end];
                      if(sum == target){
                          res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                          while(start<end && nums[start]==nums[start+1]) start++;
                          while(start<end && nums[end]==nums[end-1]) end--;
                          start++;
                          end--;
                      }
                      else if(sum<target){
                          start++;
                      }
                      else{
                         end--;
                      }
                  }
              }
          }
          return res;
      }
      
       public int maxLenOfSubSum0(int[] arr){
           HashMap<Integer,Integer> map = new HashMap<>();
           int ps = 0;
           int maxlen = 0;
           for(int i=0;i<arr.length;i++){
               ps = ps + arr[i];
               if(ps==0)  maxlen = Math.max(maxlen,i+1);
               else if(map.containsKey(ps)){
                   maxlen = Math.max(maxlen , i- map.get(ps));
               }
               if(!map.containsKey(ps)) map.put(ps,i);
           }
           return maxlen;
       }
       
       public int[][] mergeInt(int[][] intervals) {
           //sort matrix
           Arrays.sort(intervals,(a,b)->{
               if(a[0]!=b[0]){
                   return Integer.compare(a[0],b[0]);
               }
               else{
                   return Integer.compare(a[1],b[1]);
               }
           });
         List<int[]> ls = new ArrayList<>();
         int[] current = intervals[0];
         for(int i=1;i<intervals.length;i++){
             int[] next = intervals[i];
             if(current[1]>=next[0]){
                 current[1] = Math.max(current[1],next[1]);
             }
             else{
                 ls.add(current);
                 current = next;
             }
         }
         ls.add(current);
         int[][] ans = new int[ls.size()][];
         for(int i=0;i<ls.size();i++){
             ans[i] = ls.get(i);
         }
         
         return ans;
       }
    
     public List<Integer> majorityElement(int[] nums){
         List<Integer> ls = new ArrayList<>();
         int c1 = 0;
         int c2 =0;
         int cnt1 = 0;
         int cnt2 = 0;
         for(int n : nums){
             if(n == c1){
                 cnt1++;
             }
             else if(n==c2){
                 cnt2++;
             }
             else if(cnt1 == 0){
                 c1 = n;
                 cnt1 = 1;
             }
             else if(cnt2 == 0){
                 c2 = n;
                 cnt2 = 1;
             }
             else{
                 cnt1--;
                 cnt2--;
             }
         }
         cnt1 = 0;
         cnt2 = 0;
         for(int n : nums){
             if(n == c1){
                 cnt1++;
             }
             else if(n==c2){
                 cnt2++;
             }
         }
         if(cnt1>nums.length/3) ls.add(c1);
         if(cnt2>nums.length/3) ls.add(c2);
         return ls;
     }
    
    public static void main(String[] args) {
       HardArray m = new HardArray();
        // List<int[]> ls = new ArrayList<>();
        // List<Integer> ls = new ArrayList<>();
        // int[] qst = {15, -2, 2, -8, 1, 7, 10, 23};
        int[][] qst = {{1,4},{4,5}};
        // ls = m.fourSum(qst);
        int[][] ans = m.mergeInt(qst);
        // ls = m.mergeInt(qst);
        
        // System.out.println(ls);
        for(int i=0;i<ans.length;i++){
            for(int j=0;j<ans[0].length;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
