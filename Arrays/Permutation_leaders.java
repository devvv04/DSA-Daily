package Arrays;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Permutation_leaders {
     public void nextPermutation(int[] nums) {
     int n = nums.length;
     int idx = -1;
     for(int i=n-2;i>=0;i--){
         if(nums[i]<nums[i+1]){
             idx = i;
             break;
         }
     }
     if(idx==-1){
         Arrays.sort(nums);
         return;
     }
     for(int j=n-1;j>idx;j--){
         if(nums[j]>nums[idx]){
             swap(nums,j,idx);
             break;
         }
     }
     reverse(nums,idx+1,n-1);
    }
    private void reverse(int[] nums , int start , int end){
        while(start < end){
           swap(nums,start,end);
        start++;
        end--;
        }
    }
    private void swap(int[] nums, int a , int b){
        int temp1 = nums[a];
        nums[a] = nums[b];
        nums[b] = temp1;
    }
    
     public List<Integer> leaders(int[] nums) {
        
        List<Integer> ls  = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
             boolean isbig = true;
            for(int j =i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    isbig = false;
                    break;
                }
            }
            if(isbig == true){
            ls.add(nums[i]);
            }
        }
        return ls;
    }
    
    public List<Integer> leadersoptimal(int[] nums){
        int max = Integer.MIN_VALUE;
        List<Integer> ls = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]>max){
                ls.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(ls);
        return ls;
    }
    
    public static void main(String[] args) {
        Permutation_leaders m = new Permutation_leaders();
        int[] arr = {-3, 4, 5, 1, -4, -5};
        List<Integer> ls = new ArrayList<>();
        ls = m.leadersoptimal(arr);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
        
        // ls.add(1);
        // ls.add(2);
        System.out.println(ls);
        // ls.add(6);
        // System.out.println(ls);
    }
}
