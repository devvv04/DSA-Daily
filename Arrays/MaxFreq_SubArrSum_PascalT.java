package Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
class MaxFreq_SubArrSum_PascalT {
     public int maxFrequency(int[] nums, int k){
         int l = 0 ;
         long sum = 0;
         int maxlen = 0;
         for(int r =0 ;r<nums.length;r++){
             sum = sum + nums[r];
             while((long)nums[r]*(r-l+1)>sum+k){
                 sum = sum - nums[l];
                 l++;
             }
             maxlen = Math.max(maxlen,r-l+1);
         }
         return maxlen;
     }
       public int subarraySum(int[] nums, int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i =0;i<nums.length;i++){
            sum = sum + nums[i];
            if(mp.containsKey(sum - k)){
                count = count + mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
       }
       //pascal triangle
        public int pascalTriangleI(int r, int c) {
            return ncr(r-1,c-1);
        }
        private int ncr(int n,int c){
            int fact = 1;
            for(int i=0;i<c;i++){
                fact = fact * (n-i);
                fact = fact / (i+1);
            }
            return fact;
        }
        
        public List<Integer> pascalrow(int r){
            List<Integer> ls = new ArrayList<>();
           long ans = 1;
            ls.add((int)ans);
            for(int col = 1;col<r;col++){
                ans = ans * (r-col)/col;
                ls.add((int)ans);
            }
            return ls;
        }
        
        public List<List<Integer>> generate(int r){
            List<Integer> ls = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<>();
            for(int i=1;i<=r;i++){
                ls = pascalrow(i);
                ans.add(ls);
            }
            return ans;
        }
        
     
    public static void main(String[] args) {
        MaxFreq_SubArrSum_PascalT m = new MaxFreq_SubArrSum_PascalT();
        // int[] arr = {3,1,2,0,4};
        // int ans = m.subarraySum(arr,6);
        // int ans = m.pascalTriangleI(5,3);
        List<List<Integer>> ls = new ArrayList<>();
        ls = m.generate(5);
        System.out.println(ls);
    }
}