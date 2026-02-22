package Revision;

import java.util.Arrays;
import java.util.HashMap;

public class revisionTillBS1 {
     public int largestelement(int[] arr){
        int max = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return arr[max];
    }
    
    public int largestsecondelement(int[] arr){
        int second = -1;
        int first = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>first){
                second = first;
                first = arr[i];
            }
            else if(arr[i]>second && first != arr[i]){
                second = arr[i];
            }
        }
        return second;
    }
    
    public boolean arrsorted(int[] arr){
        for(int i =0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]) return false;
        }
        return true;
    }
    
    public boolean check(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                count++;
            }
        }
        if(nums[nums.length-1]>nums[0]){
            count++;
        }
   return count<=1;
    }
    
     public int removeDuplicates(int[] nums) {
        int count = 1;
        int cand = nums[0];
        int k = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=cand){
                cand = nums[i];
                nums[k++] = cand;
                count++;
            }
        }
        return count;
    }
    
    public void leftrotateArrayByOne(int[] nums) {
        int n = nums.length;
        int temp1 = nums[n-1];
        nums[n-1] = nums[0];
        for(int i=n-2;i>=0;i--){
            int temp2 = nums[i];
            nums[i] = temp1;
            temp1 = temp2;
        }
    }
    
    public void rightrotateArrayByOne(int[] nums){
        int n = nums.length;
        int last = nums[n-1];
        for(int i = n-1;i>0;i--){
            nums[i] = nums[i-1];
        }
        nums[0] = last;
    }
    
    private void reverse(int[] nums,int start,int end){
        while(start<=end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public void rightrotateArrayByK(int[] nums,int k){
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,k,n-1);
        reverse(nums,0,k-1);
    }
    
    public void moveZeroes(int[] nums) {
        int l =0;
        int r =1;
        while(r<nums.length){
            if(nums[l]!=0){
                l++;
            }
            else if(nums[l]==0&&nums[r]!=0){
                nums[l] = nums[r];
                nums[r] = 0;
                l++;
            }
        
                r++;
            
        }
    
    }
    
    private boolean isvalid(int[] nums,int[] res,int val,int k){
            return k == 0 || nums[val]!=res[k-1];
    }
    public int[] unionArray(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int k = 0;
        int[] res = new int[nums1.length+nums2.length];
        while(l<nums1.length && r<nums2.length){
            if(nums1[l]<=nums2[r]){
                if(isvalid(nums1,res,l,k) == true){
                    res[k++] = nums1[l];
                }
                l++;
            }
            else{
                if(isvalid(nums2,res,r,k) == true){
                    res[k++] = nums2[r];
                }
                r++;
            }
        }
        while(l<nums1.length){
            if(isvalid(nums1,res,l,k)==true){
                 res[k++] = nums1[l];
            }
            l++;
        }
        while(r<nums2.length){
            if(isvalid(nums2,res,r,k) == true){
                    res[k++] = nums2[r];
                }
                r++;
        }
        //Arrays.copyOf(originalArr,newlength);
        return Arrays.copyOf(res,k);
    }
    
    public int missingNumber(int[] nums) {
     int n = nums.length;
     int actual_sum = (n * (n+1)) / 2;
     int cs = 0;
     for(int num : nums){
         cs = cs + num;
     }
     return actual_sum - cs;
    }
    
     public int findMaxConsecutiveOnes(int[] nums) {
    int count  =0 ;
    int max_count = 0;
    for(int n : nums){
        if(n==1){
            count++;
if (count > max_count) max_count = count; 
        }
        else if(n == 0){
            
            count = 0;
        }
    }
    return max_count;
    }
    
     public int longestSubarrayPrefixSum(int[] nums, int k) {
       HashMap<Integer,Integer> mp = new HashMap<>();
       int ps = 0;
       int len  = 0;
       for(int i=0;i<nums.length;i++){
           ps = ps + nums[i];
           if(ps - k == 0){
               len = Math.max(len , i+1);
           }
           else if(mp.containsKey(ps-k)){
               len = Math.max(len,i-mp.get(ps-k));
           }
           if(!mp.containsKey(ps)) mp.put(ps,i);
       }
       return len;
    }
    
    public int longestSubarraySlidingWindow(int[] nums, int k){
        int l = 0;
        int sum = nums[l];
        int len = 0;
        for(int r = 1;r<nums.length;r++){
            sum = sum + nums[r];
            if(sum == k){
                len = Math.max(len,((r-l)+1));
            }
            else if(sum>k){
                sum = sum - nums[l];
                l++;
            }
        }
        return len;
    }

     public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int first = 0;
        int second = 0;
        for(int i=0;i<nums.length;i++){
            int needed = target - nums[i];
            if(mp.containsKey(needed)){
                first = i;
                second = mp.get(needed);
                break;
            }
            else{
                mp.put(nums[i],i);
            }
        }
        int[] res = new int[2];
        res[0] = first;
        res[1] = second;
        return res;
    }
    
    private void swap(int[]nums,int l , int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }


    
    public static void main(String[] args) {
        revisionTillBS1 m = new revisionTillBS1();
        int[] qst = {10,5,2,0,0,7,1,9};
        // int[] qst2 = {1,5,7,8,8};
        // int ans = m.removeDuplicates(qst);
        // boolean ans = m.arrsorted(qst);
        int ans = m.longestSubarraySlidingWindow(qst,15);
        // int[] ans = m.unionArray(qst,qst2);
        // for(int i=0;i<ans.length;i++){
        //     System.out.println(ans[i]);
        // }
        // System.out.println(Arrays.toString(ans));
        System.out.println(ans);
    }
}
