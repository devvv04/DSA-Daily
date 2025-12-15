package Arrays;

import java.util.ArrayList;

public class isSorted {
     public boolean isSorted1(ArrayList<Integer> nums){
        int k = 0;
        
        while(k<nums.size()-1 && nums.get(k)<=nums.get(k+1)){
            k++;
        }
        if(k!=nums.size()-1) return false;
        else return true;
    }
}
