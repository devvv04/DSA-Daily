package Arrays;

public class largest_element {
     public int q1largestElement(int[] nums) {
    int large = nums[0];
    for(int ar : nums){
        if (ar>large){
        large = ar;
        }
    }
    return large;
    }
}
