package BinarySearch;

import java.util.Arrays;

public class KPostive_AgressiveCow_MagneticForce {
     public int findKthPositive(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;
        int ans = 0;
        //edge case : if last missing + 
        if(((nums[high]-1)-high)<k){
            return ans = nums[high] + (k - ((nums[high]-1)-high));
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            int missing = (nums[mid]-1) - mid;
            if(missing>=k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans+k;
    }
    
     public int aggressiveCows(int[] nums, int k) {
         if(nums.length < k) return -1;
   Arrays.sort(nums);
   int low = 1;
   int high = nums[nums.length-1] - nums[0];
   int ans = 0;
   while(low<=high){
       int mid = low + (high - low)/2;
       int cntcow = 1;
       int cowpos = nums[0];
       for(int i=1;i<=nums.length-1;i++){
           if(nums[i]-cowpos >= mid){
               cntcow++;
               cowpos = nums[i];
           }
           if(cntcow>=k) break;
       }
       if(cntcow>=k){
           ans = mid;
           low = mid+1;
       }
       else{
           high = mid-1;
       }
   }
   return ans;
    }
    
     public int magneticForceBwBalls(int[] nums, int m) {
        if(nums.length < m) return -1;
        Arrays.sort(nums);
        int low = 1;
        int high = nums[nums.length-1] - nums[0];
        int ans =0;
        while(low<=high){
            int mid = low + (high-low)/2;
            int cntball = 1;
            int basketpos = nums[0];
            for(int i=1;i<=nums.length-1;i++){
                if(nums[i]-basketpos >= mid){
                    cntball++;
                    basketpos = nums[i];
                }
                if(cntball>=m) break;
            }
            if(cntball>=m){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        KPostive_AgressiveCow_MagneticForce m = new KPostive_AgressiveCow_MagneticForce();
        int[] qst = {10, 1, 2, 7, 5};
        int ans = m.aggressiveCows(qst,3);
          System.out.println(ans);
        // int ans1 = m.findKthPositive(qst,2);
        // int ans2 = m.findKthPositive(qst,3);
        // int ans3 = m.findKthPositive(qst,4);
        // int ans4 = m.findKthPositive(qst,5);
        // int ans5 = m.findKthPositive(qst,6);
        // int ans6 = m.findKthPositive(qst,7);
        // int ans7 = m.findKthPositive(qst,8);
        // int ans8 = m.findKthPositive(qst,9);
        // int ans9 = m.findKthPositive(qst,10);
        // int ans10 = m.findKthPositive(qst,11);
        // int ans11 = m.findKthPositive(qst,12);
      
        // System.out.println(ans1);
        // System.out.println(ans2);
        // System.out.println(ans3);
        // System.out.println(ans4);
        // System.out.println(ans5);
        // System.out.println(ans6);
        // System.out.println(ans7);
        // System.out.println(ans8);
        // System.out.println(ans9);
        // System.out.println(ans10);
        // System.out.println(ans11);
    }
}
