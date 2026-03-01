package Revision;

import java.util.Arrays;

public class binarysearchrev {
     public int search(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
    
     public int lowerBound(int[] nums, int x) {
      int ans = nums.length;
      int low = 0;
      int high = nums.length;
      while(low<=high){
        int mid = low + (high-low)/2;
        if(nums[mid]>=x){
            ans = Math.min(ans,mid);
            high = mid-1;
        }
        else{
low = mid+1;
        }
      }
      return ans; 
     }
     
     public int upperBound(int[] nums, int x) {
      int ans = nums.length;
      int low = 0;
      int high = nums.length;
      while(low<=high){
        int mid = low + (high-low)/2;
        if(nums[mid]>x){
            ans = Math.min(ans,mid);
            high = mid-1;
        }
        else{
low = mid+1;
        }
      }
      return ans; 
     }
     
      public int searchInsert(int[] nums, int target) {
        int ans = nums.length;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=target){
                ans = Math.min(ans,mid);
                high=mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return ans;
}
 public static void main(String[] args) {
        binarysearchrev m = new binarysearchrev();
        int[] qst = {2, 4, 6, 8, 10, 12, 14};
        int ans = m.lowerBound(qst,1);
        System.out.println(ans);
    }
}
