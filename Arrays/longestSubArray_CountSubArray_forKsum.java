package Arrays;
import java.util.*;
class longestSubArray_CountSubArray_forKsum {
     public int longestSubarraywithpos_neg(int[] nums, int k) {
       int prefix_sum = 0;
      int  maxlen = 0;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=0;i<nums.length;i++){
           prefix_sum = prefix_sum+nums[i];
           if(!map.containsKey(prefix_sum)){
               map.put(prefix_sum,i);
           }
           if(prefix_sum  == k){
               maxlen = i+1 ;
           }
           if(map.containsKey(prefix_sum-k)){
               maxlen = Math.max(maxlen,i-map.get(prefix_sum-k));
           }
       }
       return maxlen;
    }
    
      public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix_sum = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix_sum += nums[i];
            if(mp.containsKey(prefix_sum-k)){
                count = count + mp.get(prefix_sum-k);
            }
            mp.put(prefix_sum,mp.getOrDefault(prefix_sum,0)+1);
        }
        
return count;
    }
    
     public int longestSubarraywithonlypos(int[] nums, int k) {
         int left =0;
         int sum = 0;
         int maxlen = 0;
         for(int right=0;right<nums.length;right++){
             sum = sum + nums[right];
             while(sum >k){
                 sum = sum - nums[left];
                 left++;
             }
             if(sum == k){
                 maxlen = Math.max(maxlen,right-left+1);
                }
             
         }
         return maxlen;
     }
    public static void main(String[] args) {
        longestSubArray_CountSubArray_forKsum m = new longestSubArray_CountSubArray_forKsum();
        int[] qst = {1, 2, 3, 1, 1, 1};
        System.out.println(m.longestSubarraywithonlypos(qst,5));
    }
}