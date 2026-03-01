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

      public void merge2sorted(int[] nums1, int m, int[] nums2, int n){
         //m = no. of real elem in nums1 , bcz nums1 = m+n
         int i = m-1;
         int j = n-1;
         int k = nums1.length-1;
         while(i>=0 && j>=0){
             if(nums1[i]<=nums2[j]){
                 nums1[k] = nums2[j];
                 k--;
                 j--;
             }
             else{
                 nums1[k] = nums1[i];
                 k--;
                 i--;
             }
         }
         while(j>=0){
             nums1[k] = nums2[j];
             k--;
             j--;
         }
     }
     
    public int[] findMissingRepeatingNumbers(int[] nums) {
          int n = nums.length;
            int realsum = (n * (n+1))/2;
            int currsum = 0;
            int realss = (n*(n+1)*(2*n+1))/6;
            int currss = 0;
            for(int num : nums){
                currsum = currsum + num;
                currss = currss + num*num;
            }
            int diff1 = realsum - currsum; //A-B
            int diff2 = realss - currss; //A2-B2
            int sum = diff2 / diff1; //A+B
            int b = (sum - diff1) / 2;
            int a = sum -b;
            int[] ans = new int[2];
            ans[0]= b;
            ans[1] = a;
            return ans;
    }
    
    public int coutnInversion(int[] nums){
        return mergedivide(nums,0,nums.length-1);
    }
    private int mergedivide(int[]nums,int low, int high){
        int count = 0;
        if(low>=high) return count;
        int mid = low + (high-low)/2;
        count = count + mergedivide(nums,low,mid);   
        count = count + mergedivide(nums,mid+1,high);
        count = count + countfn(nums,low,mid,high);
        return count;
    }
    private int countfn(int[]nums,int low,int mid,int high){
        //sort + count part
        int count = 0;
        int l = low;
        int r = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                temp[k] = nums[l];
                k++;
                l++;
            }
            else{
                temp[k] = nums[r];
                count = count + (mid-l+1);
                k++;
                r++;
            }
        }
        while(l<=mid){
            temp[k] = nums[l];
            k++;
            l++;
        }
        while(r<=high){
            temp[k] = nums[r];
            k++;
            r++;
        }
        //merge 
        for(int i=0;i<temp.length;i++){
            nums[low+i] = temp[i];
        }
        return count;
    }
    
    public int reversepair(int[] nums){
        return dividerev(nums,0,nums.length-1);
    }
    private int dividerev(int[]nums, int low , int high){
        int count = 0;
        if(low>=high) return count;
        int mid = low + (high-low)/2;
        count = count + dividerev(nums,low,mid);
        count = count + dividerev(nums,mid+1,high);
        count = count + countfnrev(nums,low,mid,high);
        mergerev(nums,low,mid,high);
        return count;
    }
    private int countfnrev(int[]nums , int low , int mid , int high){
        int count = 0;
        int r = mid+1;
        for(int l = low;l<=mid;l++){
            while(r<=high && (long)nums[l]>2L * nums[r]){
                r++;
            }
            count = count + (r-(mid+1));
        }
        return count;
    }
    private void mergerev(int[] nums , int low, int mid , int high){
        int l = low;
        int r = mid+1;
        int[] temp = new int[high-low+1];
        int k = 0;
        while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                temp[k] = nums[l];
                k++;
                l++;
            }
            else{
                temp[k] = nums[r];
                k++;
                r++;
            }
        }
        while(l<=mid){
            temp[k] = nums[l];
            k++;
            l++;
        }
        while(r<=high){
            temp[k] = nums[r];
            k++;
            r++;
        }
        //merge 
        for(int i=0;i<temp.length;i++){
            nums[low+i] = temp[i];
        }
    }
    
    public static void main(String[] args) {
        HardArray m = new HardArray();
        // List<int[]> ls = new ArrayList<>();
        // List<Integer> ls = new ArrayList<>();
        int[] qst1 = {1,3,2,3,1};
        // int[] qst2 = {2,5,6};
        // m.merge2sorted(qst1,3,qst2,3);
        int ans = m.reversepair(qst1);
        System.out.println(ans);
        // int[][] qst = {{1,4},{4,5}};
        // ls = m.fourSum(qst);
        // int[][] ans = m.mergeInt(qst);
        // ls = m.mergeInt(qst);
        // System.out.println(ls);
        // for(int i=0;i<ans.length;i++){
        //     for(int j=0;j<ans[0].length;j++){
        //         System.out.print(ans[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
    }
}
