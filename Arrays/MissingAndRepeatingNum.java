package Arrays;

import java.util.Arrays;

public class MissingAndRepeatingNum {
     public int[] findMissingRepeatingNumbersBrute(int[] nums) {
         Arrays.sort(nums);
int n = nums.length;
int l = 0;
int r=1;
while(r<n&&nums[l]!=nums[r]){
    l++;
    r++;
}
int[] ans = new int[2];
ans[0] = nums[r];
int currentsum = 0;
for(int i=0;i<nums.length;i++){
    currentsum = currentsum + nums[i];
}
int actualsum = n * (n+1) /2;
ans[1] = actualsum - (currentsum - nums[r]);
return ans;
    }
    
    public int[] findMissingRepeatingNumbersOptimal(int[] nums){
        int n = nums.length;
        int actualsum = n * (n+1) / 2;
        int actualsumofsq = n * (n+1) * (2*n+1) / 6;
        int csum = 0;
        int csumofsq = 0;
        for(int num : nums){
            csum += num;
            csumofsq += num * num;
        }
        int diffofsum = actualsum - csum;
        int diffofsumofsq = actualsumofsq - csumofsq;
        int A_B = diffofsumofsq / diffofsum ;
        int[] ans = new int[2];
        int A = (A_B + diffofsum) / 2; // A =  duplicate
        int B = A_B - A; // B = missing
        ans[0] = B;
        ans[1] = A;
        return ans;
    }
    
    public static void main(String[] args) {
        MissingAndRepeatingNum m = new MissingAndRepeatingNum();
      int[] qst= { 1, 2, 3, 6, 7, 5, 7};
      int[] ans = m.findMissingRepeatingNumbersOptimal(qst);
      for(int i=0;i<ans.length;i++){
          System.out.println(ans[i]);
      }
    // System.out.println(ans);
    // System.out.println(1^2^3^6^7^5^7);
    }
}
