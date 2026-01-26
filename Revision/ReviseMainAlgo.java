package Revision;

import java.util.HashMap;
import java.util.Map;

public class ReviseMainAlgo {
    public int prefixSum(int[]nums, int k){
        int maxlen = 0;
        int ps = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            ps = ps + nums[i];
            if(!map.containsKey(ps)){
                map.put(ps,i);
            }
            if(ps == k){
                maxlen = i+1;
            }
            if(map.containsKey(ps - k)){
                maxlen = Math.max(maxlen,i-map.get(ps-k));
            }
        }
        return maxlen;
    }
    
    public int slidingWindow(int[] nums, int k){
        int left = 0;
        int sum = 0;
        int maxlen = 0;
        for(int right = 0;right<nums.length;right++){
            sum = sum + nums[right];
            while(sum > k){
                sum = sum - nums[left];
                left++;
            }
            if(sum == k){
                maxlen = Math.max(maxlen,right - left +1);
            }
        }
        return maxlen;
    }
    
    public int kadenesAlgo(int[] nums){
        //to return max sum of sub array
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for(int n : nums){
            cs = cs + n;
            ms = Math.max(ms,cs);
            if(cs<0){
                cs = 0;
            }
        }
        return ms;
    }
    
    public void sort012(int[] nums){
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else if(nums[mid] == 2){
                swap(nums,high,mid);
                high--;
            }
        }
    }
    private void swap(int[] nums,int a , int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int needed = target - nums[i];
            if(map.containsKey(needed)){
                res[0] = map.get(needed);
                res[1] = i;
                return res;
            }
            else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
    
    
    public static void main(String[] args) {
        ReviseMainAlgo m = new ReviseMainAlgo();
        int[] arr = {2,6,5,8,11};
        // int ans = m.slidingWindow(arr,15);
        // m.sort012(arr);
        int[] ans = m.twoSum(arr,14);
        // System.out.println(ans);
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
