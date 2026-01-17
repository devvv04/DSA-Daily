package Arrays;


import java.util.HashMap;
class MajorityElement_MaxSubArray_stock_rearrangePndN {
     public int majorityElementOnspace(int[] nums) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int half = nums.length/2;
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
            if(mp.get(n)>half){
                return n;
            }
        }
        return -1;
    }
    
    public int majorityElementO1space(int[] nums){
        int candidate = nums[0];
        int count = 1;
        for(int n:nums){
            if(n == candidate){
                count++;
            }
            else{
                count--;
            }
            if(count == 0){
                candidate = n;
                count = 1;
            }
        }
        return candidate;
    }
    
     public int maxSubArray(int[] nums) {
     //kadane'algo: 
     int current_sum = 0;
     int max_sum = nums[0];
     for(int n : nums){
         current_sum += n;
         
         if(current_sum>max_sum){
             max_sum = current_sum;
         }
         if(current_sum<0){
             current_sum = 0;
         }
         
     }
     return max_sum;
    }
    
    public void maxSubArraywithSum_ActualArray(int[] nums){
        int cs =0;
        int ms = nums[0];
        int start = 0; 
        int tempstart = 0;
        int end = 0;
        for(int i =0;i<nums.length;i++){
            cs = cs + nums[i];
            if(cs>ms){
                ms = cs;
                start = tempstart;
                end = i;
            }
            if(cs<0){
                cs = 0;
                tempstart = i+1;
            }
        }
        System.out.println(ms);
        System.out.println(start+" to "+end);
    }
    
    public int stockBuySell(int[] arr) {
       int min = Integer.MAX_VALUE;
       int mp = 0;
       for(int num : arr){
        if(num<min){
            min = num;
        }
        else if(num - min > mp){
            mp = num - min;
        }
       }
       return mp;
    }
    
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for(int n : nums){
            if(n >= 0){
                res[pos] = n;
                pos = pos +2;
            }
            else if(n<0){
                res[neg] = n;
               neg =  neg + 2;
            }
        }
        return res;
    }
    
    
    
    public static void main(String[] args) {
        MajorityElement_MaxSubArray_stock_rearrangePndN m= new MajorityElement_MaxSubArray_stock_rearrangePndN();
        int[] arr = {3,1,-2,-5,2,-4};
        //15 is maxsum , {2,3,5,-2,7} is the array
        // m.maxSubArraywithSum_ActualArray(arr);
        int[] res = m.rearrangeArray(arr);
        for(int i =0;i<res.length;i++){
            System.out.println(res[i]);
        }
    }
}
