package Arrays;

public class secondLargest_element {
      public int q2secondLargestElement(int[] nums) {
    if (nums.length == 1) return -1;
    int large = nums[0];
    for(int ar : nums){
        if(ar>large){
            large = ar;
        }
    }
    boolean issecond = false;
    int second_large = Integer.MIN_VALUE;
    for(int ar2 : nums){
        if(ar2>second_large && ar2!=large){
            second_large = ar2;
            issecond = true;
        }
        
    }
    if(issecond == false) return -1;
    return second_large;
    }
    //2.1
    public int q2secondLargestElementoptimal(int[] nums){
        int large = nums[0];
        int secondl = Integer.MIN_VALUE;
        boolean issec = false;
        for(int ar : nums){
            if(ar>large ){
                secondl = large;
                large = ar;
                issec = true;
            }
            else if(ar>secondl && ar<large){
                secondl = ar;
                issec = true;
            }
        }
        
        if(issec == false) return-1;
        else return secondl;
    }
}
