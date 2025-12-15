package Arrays;

public class remove_duplicates {
      public int removeDuplicates(int[] nums) {
        int l = 0;
        int r = 1;
        while(r<nums.length){
            if(nums[l]!=nums[r]){
                nums[l+1] = nums[r];
                l++;
            }
            r++;
        }
        return l+1;
    }
}
