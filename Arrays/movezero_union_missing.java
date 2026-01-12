package Arrays;
import java.util.*;
class Main {
     public int[] moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;
        while(r<nums.length){
        if (nums[l]!=0){
            l++;
        }
        else if(nums[l] == 0 && nums[r]!=0){
            nums[l] = nums[r];
            nums[r] = 0;
            l++;
        }
            r++;
        }
        return nums;
    }
    
     public int linearSearch(int nums[], int target) {
		for(int i =0;i<nums.length;i++){
      if(nums[i]==target){
        return i;
      }
    }
    return -1;
    }
    
    public int[] brutetryunionArray(int[] nums1, int[] nums2) {
      int[] res = new int[nums1.length+nums2.length];
      int count = 0;
      for(int i=0; i<nums1.length;i++){
          if(linearSearch(res,nums1[i])==-1){
          res[count++] = nums1[i];
          }
      }
      for(int j=0 ;j<nums2.length;j++){
          int temp = nums2[j];
          if(linearSearch(res,temp)==-1){
              res[count++] = temp;
          }
      }
      int[] final_ans = new int[count];
      for(int i =0;i<count;i++){
          final_ans[i] = res[i];
      }
      Arrays.sort(final_ans);
      return final_ans;
    }
    
    private boolean isnotpresent(int[] arr,int count,int val){
        if(count==0 || arr[count-1]!=val){
            return true;
        }
        else{
            return false;
        }
    }
    
     public int[] unionArray(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length+nums2.length];
        int count = 0;
        int i =0;
        int j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                if(isnotpresent(res,count,nums1[i])==true){ 
                res[count++] = nums1[i];
            }
            i++;
            }
            else if(nums2[j]<nums1[i]){
                if(isnotpresent(res,count,nums2[j])==true){
                    res[count++] = nums2[j];
                }
                j++;
            }
            else if(nums1[i]==nums2[j]){
                if(isnotpresent(res,count,nums2[j])==true){
                    res[count++] = nums1[i];
                }
                i++;
            }
        }
        //bache hue elements:
        while(i<nums1.length){
            if(isnotpresent(res,count,nums1[i])==true){ 
                res[count++] = nums1[i];
        }
        i++;
        }
        while(j<nums2.length){
            if(isnotpresent(res,count,nums2[j])==true){ 
                res[count++] = nums2[j];
        }
        j++;
        }
        int[] ans = new int[count];
        for(int l=0;l<count;l++){
            ans[l] = res[l];
        }
        return ans;
     }
     
     public int missingNumber(int[] nums) {
       int range = nums.length;
       int expected_sum = 0;
       for(int i=0;i<=range;i++){
           expected_sum += i;
       }
       int given_sum = 0;
       for(int j=0;j<nums.length;j++){
           given_sum += nums[j];
       }
       int missing = expected_sum - given_sum;
       return missing;
    }
        
    public static void main(String[] args) {
        Main m = new Main();
        int[] arr = {0, 2, 3, 1, 4};
    //   int[] nums1 = {3, 4, 6, 7, 9, 9}; 
    //   int[] nums2 = {1, 5, 7, 8, 8};
        int sol = m.missingNumber(arr);
        System.out.println(sol);
        // for(int i=0;i<sol.length;i++){
        //     System.out.println(sol[i]);
        // }
    }
}