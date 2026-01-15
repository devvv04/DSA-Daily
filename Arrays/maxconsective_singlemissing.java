package Arrays;
import java.util.*;
class Main {
    
    // private boolean isunique(int[] arr, int count, int val){
    //       if(count == 0 || arr[count-1]!= val){
    //             return true;
    //         }
    //         else{
    //             return false;
    //         }
    // }
    // public int[] union(int[] a , int[] b){
    //     int f = 0;
    //     int g =0;
    //     int[] uarr = new int[a.length+b.length];
    //     int count = 0;
    //     while(f<a.length && g<b.length){
    //         if(a[f]<b[g]){
    //             if(isunique(uarr,count,a[f]) == true){
    //                 uarr[count++] = a[f];
    //             }
    //             f++;
    //         }
    //         else if(b[g]<a[f]){
    //             if(isunique(uarr,count,b[g]) == true){
    //                 uarr[count++] = b[g];
    //             }
    //             g++;
    //         }
    //         else if(a[f]==b[g]){
    //             if(isunique(uarr,count,a[f]) == true){
    //                 uarr[count++] = a[f];
    //             }
    //             f++;
    //             g++;
    //         }
    //     }
    //     while(f<a.length){
    //          if(isunique(uarr,count,a[f]) == true){
    //                 uarr[count++] = a[f];
    //             }
    //             f++;
    //     }
    //     while(g<b.length){
    //          if(isunique(uarr,count,b[g]) == true){
    //                 uarr[count++] = b[g];
    //             }
    //             g++;
    //     }
    //     int res[] = new int[count];
    //     for(int k=0;k<count;k++){
    //         res[k] = uarr[k];
    //     }
    //     return res;
    // }
    
      public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int sum = 0;
        for(int n : nums){
            if(n == 1){
                count ++;
                if(count > sum){
                    sum = count;
                }
            
            }
            else {
                count = 0;
            }
        }
        return sum;
    }
    
     public int singleNumberusingHashMap(int[] nums) {
       HashMap<Integer,Integer> mp = new HashMap<>();
       for(int n : nums){
               mp.put(n,mp.getOrDefault(n,0)+1);
       }
       for(int key : mp.keySet()){
           if(mp.get(key) == 1){
               return key;
           }
       }
       return -1;
       }
       
      public int singleNumberusingxor(int[] nums) {
       int ans =0;
       for(int n : nums){
           ans = ans ^ n;
       }
       return ans;
    }
       
    //   private int checkk(int k, int ans){
    //         if(k >ans){
    //               ans = k;
    //           }
    //           return ans; 
    //   }
    //     public int longestSubarray(int[] nums, int k) {
    //         int l = 0;
    //         int r =1;
    //         int ans =0;
    //   for(int i=0;i<nums.length;i++){
    //       if (sumbw(nums,l,r)==k){
    //           checkk(k,ans);
    //       }
    //       else if(sumbw(nums,l,r)<k){
    //           sumbw(nums,l,r+1);
    //           checkk(k,ans);
    //       }
    //   }
    //   return r+1;
    // }
    // private int sumbw(int[] arr,int start , int end){
    //     int s =0;
    //     for(int i=start;i<=end;i++){
    //         s = s + arr[i];
    //     }
    //     return s;
    // }
     

       
    
    
    
    public static void main(String[] args) {
        // int[] arr1 = {10, 5, 2, 7, 1, 9};
        // int[] arr2 = {2,3,4,5};
       Main m = new Main();
    //    int ans = m.singleNumberusingxor(arr1,17);
    //    System.out.println(ans);
         int[] qst = {1,1,0,1,1,1};
         int sol = m.findMaxConsecutiveOnes(qst);
         System.out.println(sol);
    //   int[] ans = m.union(arr1,arr2);
    //   for(int i=0;i<ans.length;i++){
    //       System.out.println(ans[i]);
    //   }
    }
}