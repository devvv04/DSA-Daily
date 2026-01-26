package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Three_Four_Sum {
    public List<List<Integer>> threeSum(int[] nums,int k){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n-2;i++){
            if(i>1 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == k){
                    res.add(Arrays.asList(nums[i],nums[left], nums[right]));
                    while(left<right &&  nums[left]==nums[left+1]) left++;
                    while(left<right &&  nums[right]==nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if(sum>k){
                    right--;
                }
                else{
                    left++;
                }
                }
        }
        return res;
    }
    public List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1;
                int r=n-1;
                while(l<r){
                    long sum = (long) nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    }
                    else if(sum<target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return res;
    }
    public int maxLen(int[] nums) {
    Map<Integer,Integer> map = new HashMap<>();
    int sum = 0;
    int maxlen = 0;
    for(int i=0;i<nums.length;i++){
        sum = sum + nums[i];
        if(!map.containsKey(sum)){
            map.put(sum,i);
        }
       if(sum ==0){
           maxlen = i+1;
       }
       if(map.containsKey(sum)){
           maxlen = Math.max(maxlen,i-map.get(sum));
       }
    }
    return maxlen;
    }
    
    
    public static void main(String[] args) {
        Three_Four_Sum m = new Three_Four_Sum();
     int[] arr = {1, 0, -4, 3, 1, 0};
    //  List<List<Integer>> ls = new ArrayList<>();
    //  ls = m.fourSum(arr,0);
    int ans = m.maxLen(arr);
    //  System.out.println(ls);
     System.out.println(ans);
     
    }
}
