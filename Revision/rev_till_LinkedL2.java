package Revision;

import java.util.HashMap;

public class rev_till_LinkedL2 {
     public int[] unionArray(int[] nums1, int[] nums2) {
        int l = 0;
        int r=0;
        int res[] = new int[nums1.length+nums2.length];
        int k = 0;
        while(l<nums1.length&&r<nums2.length){
            int val=0;
            if(nums1[l]==nums2[r]){
                val = nums1[l];
                l++;
                r++;
            }
            else if(nums1[l]>nums2[r]){
                val = nums2[r];
                r++;
            }
            else{
                val = nums1[l];
                l++;
            }
            if(k==0||res[k-1]!=val){
                res[k++]=val;
            }
        }
        while(l<nums1.length){
            if(k==0||res[k-1]!=nums1[l]){
                res[k++]=nums1[l];
            }
            l++;
        }
        while(r<nums2.length){
            if(k==0||res[k-1]!=nums2[r]){
                res[k++]=nums2[r];
            }
             r++;
        }
        int result[] = new int[k];
        for(int x=0;x<k;x++){
            result[x] = res[x];
        }
        return result;
    }
    
    public int longestSubarraypos(int[] nums, int k) {
       int l = 0;
       int len = 0;
       int sum = 0;
       for(int r=0;r<nums.length;r++){
           sum = sum + nums[r];
           while(sum>k){
               sum = sum - nums[l];
               l++;
           }
           if(sum==k){
               len = Math.max(len,(r-l+1));
           }
       }
       return len;
    }
    
    public int longestSubarrayall(int[] nums, int k) {
       HashMap<Integer,Integer> mp = new HashMap<>();
       int pfs = 0;
       int len = 0;
       for(int i=0;i<nums.length;i++){
           pfs = pfs + nums[i];
           if(pfs-k==0) len = Math.max(len,i+1);
           else if(mp.containsKey(pfs-k)){
               len = Math.max(len,(i-mp.get(pfs-k)));
           }
           if(!mp.containsKey(pfs)){
           mp.put(pfs,i);
           }
       }
       return len;
    }
    
    public boolean rotateString(String s, String goal) {
        if(s.length()!=goal.length()) return false;
    String two = s + s;
    return two.contains(goal);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            if(mp.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=mp.get(target-nums[i]);
                break;
            }
            mp.put(nums[i],i);
        }
        return ans;
    }
    public void sortColors(int[] nums) {
        int l = 0;
        int m = 0;
        int h = nums.length-1;
        while(m<=h){
            if(nums[m]==0){
                swap(nums,l,m);
                l++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                swap(nums,h,m);
                h--;
            }
        }
    }
    protected void swap(int[]nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void rotate(int[][] matrix) {
        //transpose:
        for(int i=0;i<matrix.length;i++){
            for(int j = i+1;j<matrix[0].length;j++){
                int store = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = store;
                }
        }

        //rotate row:
        for(int i=0;i<matrix.length;i++){
            int start = 0;
            int end = matrix[0].length-1;
            while(start<end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
    public int majorityElementI(int[] nums) {
        int cand = 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            if(count==0){
                cand = nums[i];
            }
            if(nums[i]==cand){
                count++;
            }
            else{
                count--;
            }
        }
        return cand;
    }
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int n:nums){
            cs = cs+n;
            ms = Math.max(cs,ms);
            if(cs<0){
                cs = 0;
            }
        }
        return ms;
    }
    
    
    public static void main(String[] args) {
        // rev_till_LinkedL2 m = new rev_till_LinkedL2();
        // int a[] = {10,5,2,7,1,9};
        // int ans = m.longestSubarrayall(a,15);
        // System.out.println(ans);
        // int b[] = {1,2,7};
        // int ans[] = new int[a.length+b.length];
        // ans = m.unionArray(a,b);
        // for(int n : ans){
        //     System.out.println(n);
        // String s = "abcde";
        // s = s+s;
        // System.out.println(s);
        }
}
