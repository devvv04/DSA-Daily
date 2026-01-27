package Arrays;

import java.util.HashMap;
import java.util.Map;

public class subarraysWithXorK {
     public int subarraysWithXor(int[] nums, int k) {
     int px = 0;
     int count = 0;
     Map<Integer,Integer> map = new HashMap<>();
     map.put(0,1);
     for(int n : nums){
         px = px ^ n;
         int req = px ^ k;
         if(map.containsKey(req)){
             count = count + map.get(req);
         }
         map.put(px,map.getOrDefault(px,0)+1);
     }
     return count;
    }
    
    public static void main(String[] args) {
        subarraysWithXorK m = new subarraysWithXorK();
        int[] nums = {4,2,2,6,4};
        int ans = m.subarraysWithXor(nums,6);
        System.out.println(ans);
    }
}
