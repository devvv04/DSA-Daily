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

 public int[] floorandceil(int[] nums, int x){
        int floor = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid]<= x){
                floor = Math.max(floor,nums[mid]);
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        int ceil = -1;
        int low1 =0;
        int high1 = nums.length-1;
        while(low1<=high1){
            int mid1 = low1 + (high1 - low1)/2;
            if(nums[mid1]>=x){
                ceil = nums[mid1];
                high1 = mid1 -1 ;
            }
            else{
                low1 = mid1+1;
            }
        }
        int[] ans = new int[2];
        ans[0] = floor;
        ans[1] = ceil;
        return ans;
    }

     public int countOccurrences(int[] nums, int x) {
       int first = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == x){
                first = mid;
                high = mid-1;
            }
            else if(nums[mid]>x){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        int last = -1;
        int l = 0;
        int h = nums.length-1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==x){
                last = m;
                l = m+1;
            }
            else if(nums[m]>x){
                h = m - 1;
            }
            else{
                l = m+1;
            }
        }
        int len = 0;
       if(first == last && first!=-1){
        len = 1;
       }
       else if(first == last && first == -1){
        len = 0;
       }
       else{
        len = last - first + 1;
       }
       return len;
    }

      public int searchRotated(int[] nums, int x){
    int low = 0;
    int high = nums.length-1;
    // int ans = -1;
    while(low<=high){
        int mid = low + (high-low)/2;
        if(nums[mid]==x) return mid;
        else if(nums[mid]>=nums[low]){ //left sorted
        if(x>=nums[low] && x<nums[mid]){
            high = mid-1;
        }    
        else{
            low = mid+1;
        }
        }
        else{
            if(x>nums[mid]&& x<=nums[high]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
       
    }
         return -1;
    }
     public boolean searchRotated2(int[] nums, int x){
         int low = 0;
         int high = nums.length-1;
         while(low<=high){
             int mid = low + (high-low)/2;
             if(nums[mid]==x) return true;
             if(nums[low] == nums[mid] && nums[mid]==nums[high]) {
                 low++;
                 high--;
             }
             else if(nums[mid]>=nums[low]){ //left sorted
        if(x>=nums[low] && x<nums[mid]){
            high = mid-1;
        }    
        else{
            low = mid+1;
        }
        }
        else{
            if(x>nums[mid]&& x<=nums[high]){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
         }
         return false;
     }
     
     public int findmin(int[]nums){
         int low = 0;
         int high = nums.length-1;
         int ans = Integer.MAX_VALUE;
         while(low<=high){
             int mid = low+(high-low)/2;
             if(nums[mid]>=nums[low]){
                 ans = Math.min(ans,nums[low]);
                 low = mid+1;
             }
             else {
                 ans = Math.min(ans,nums[mid]);
                 high = mid-1;
             }
         }
         return ans;
     }
     
      public int singleNonDuplicate(int[] nums){
          int low = 0;
          int high = nums.length-1;
          while(low<high){
              int mid = low + (high - low)/2;
              if(mid % 2==1){
                  mid--;
              }
              if(nums[mid]==nums[mid+1]){
                  //left ok
                  low = mid+2;
              }
              else{
                  high = mid;
              }
          }
          return nums[low];
      }


 public static void main(String[] args) {
        binarysearchrev m = new binarysearchrev();
        int[] qst = {2, 4, 6, 8, 10, 12, 14};
        int ans = m.lowerBound(qst,1);
        System.out.println(ans);
    }
}
