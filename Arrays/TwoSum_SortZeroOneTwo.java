package Arrays;
import java.util.Arrays;
import java.util.HashMap;
class TwoSum_SortZeroOneTwo {
    public int largestsubarraywithsumkusingslidingwindow(int nums[],int k){
        int left = 0;
        int sum = 0;
        int maxlen = 0;
        for(int right =0;right<nums.length;right++){
            sum = sum + nums[right];
            while(sum>k){
                sum = sum - nums[left];
                left++;
            }
            if(sum==k){
                maxlen = Math.max(maxlen,right-left+1);
            }

        }
        return maxlen;
    }
     public int[] twoSumonSorted(int[] nums, int target) {
       
        int[] res = new int[2];
       
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while(l<r){
            if(nums[l]+nums[r] > target){
                r--;
            }
            if(nums[l]+nums[r]< target){
                l++;
            }
            if(nums[l]+nums[r] == target){
res[0] = l;
res[1] =r;
break;
            }
        }
        return res;
    }
    
    public int[] twoSumwithnoduplicates(int[] nums, int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],i);
        }
        for(int n:nums){
            if(mp.containsKey(k-n)){
                res[0] = mp.get(n);
                res[1] = mp.get(k-n);
                
            }
        }
        return res;
    }
    
     public void sortZeroOneTwoBettersol(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int n:nums){
            if(n==0){
                count0++;
            }
            if(n==1){
                count1++;
            }
            if(n==2){
                count2++;
            }
        }
        int index =0;
        for(int i=0;i<count0;i++){
            nums[index++] = 0;
        }
        for(int i=0;i<count1;i++){
            nums[index++] = 1;
        }
        for(int i=0;i<count2;i++){
            nums[index++] = 2;
        }
    }
    
     public void sortZeroOneTwomytry(int[] nums) {
         int l = 0;
         int r = nums.length-1;
         for(int n:nums){
             if(n ==0){
                int templ = nums[l];
                nums[l] = 0;
                n =templ;
                l++;
             }
             else if(n ==2){
                 int tempr = nums[r];
                 nums[r] = 2;
                 n = tempr;
                 r--;
             }
         }
     }
    
    private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}
    
    public void sortColorsoptimal(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,mid,low);
                low++;
                mid++;
            }
            else if(arr[mid]==1){
                mid++;
            }
            else if(arr[mid]==2){
                swap(arr,mid,high);
                high--;
            }
        }
    }
    
    public static void main(String[] args) {
        TwoSum_SortZeroOneTwo m = new TwoSum_SortZeroOneTwo();
        int[] arr = {0,1,1,0,1,2,1,2,0,0,0}; 
        // int[] arr = {1,1,1}; 
       m.sortColorsoptimal(arr);
       for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
       }
    }
}