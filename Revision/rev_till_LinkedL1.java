package Revision;

public class rev_till_LinkedL1 {
    public int removeDuplicates(int[] nums) {
        int cand = nums[0];
        int l = 1;
        int count = 1;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=cand){
                cand = nums[j];
                nums[l++]=nums[j];
                count++;
            }
        }
        return count;
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length-1;
        k = k % nums.length;
        reverse(nums,0,n);
        reverse(nums,0,(k-1));
        reverse(nums,k,n);

    }
    private void reverse(int[] nums,int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
     public void moveZeroes(int[] nums) {
        int l = 0;
        int r = 1;
        while(r<nums.length){
            if(nums[l]!=0) l++;
            else if(nums[l]==0 && nums[r]!=0){
                nums[l] = nums[r];
                nums[r] = 0;
                l++;
            }
            r++;
        }
    }
}
