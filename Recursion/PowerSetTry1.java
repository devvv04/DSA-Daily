package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PowerSetTry1 {
    //my personal try
    public List<List<Integer>> powerSet(int[] nums){
        int n = nums.length;
        List<List<Integer>> ls = new ArrayList<>();
        String curr = "";
        return gen(curr,n,nums,ls);
    }
    protected List<List<Integer>> gen(String curr,int n,int[] arr,List<List<Integer>> add){
        if(curr.length()==n){
            
            List<Integer> inner = new ArrayList<>();
        for(int i=0;i<curr.length();i++){
            if(curr.charAt(i)=='1'){
                inner.add(arr[i]);
            }
        }
            if(inner.size()!=0){
            add.add(inner) ;
            }
            return add;
        }
        gen(curr+'0',n,arr,add);
        if(curr.isEmpty() || curr.charAt(curr.length()-1)!=0){
            gen(curr+'1',n,arr,add);
        }
        return add;
    }
}
