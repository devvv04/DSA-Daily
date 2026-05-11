package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class seperateDig_CountEve_AliceWin {
    public boolean canAliceWin(int[] nums) {
        int onedigsum = 0;
        int othersum = 0;
        for(int n : nums){
            if(n<10){
                onedigsum += n;
            }
            else othersum += n;
        }
        return onedigsum!=othersum;
    }
    public int countEven(int num) {
        int count = 0;
        for(int i=num;i>0;i--){
            if(fn(i)) count++;
        }
        return count;
    }
    protected boolean fn(int n){
        int sum = 0;
        while(n>0){
            int last = n % 10;
            sum = sum + last;
            n = n/10;
        }
        return sum%2==0;
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int n : nums){
            List<Integer> ls = new ArrayList<>();
            ls = fn1(n);
            ans.addAll(ls);
        }
        int[] res = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    protected List<Integer> fn1(int n){
        List<Integer> ls = new ArrayList<>();
        while(n>0){
            int last = n % 10;
            ls.add(last);
            n = n/10;
        }
        Collections.reverse(ls);
        return ls;
    }
}
