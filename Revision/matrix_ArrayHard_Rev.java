package Revision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class matrix_ArrayHard_Rev {
     public void setZeroes(int[][] mat) {
        boolean frow = false;
        boolean fcol = false;
        int row = mat.length;
        int col = mat[0].length;
        for(int j=0;j<col;j++){
            if(mat[0][j]==0) frow = true;
        }
        for(int i=0;i<row;i++){
            if(mat[i][0]==0) fcol = true;
        }
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                    if(mat[i][j]==0){
                        mat[0][j] = 0;
                        mat[i][0] = 0;
                    }
            }
        }
        for(int j=1;j<col;j++){
            if(mat[0][j]==0){
                for(int i=1;i<row;i++){
                    mat[i][j]=0;
                }
            }
        }
        for(int i=1;i<row;i++){
            if(mat[i][0]==0){
                for(int j=1;j<col;j++){
                    mat[i][j]=0;
                }
            }
        }
        if(frow==true){
            for(int j=0;j<col;j++){
                mat[0][j]=0;
            }
        }
        if(fcol==true){
            for(int i=0;i<row;i++){
                mat[i][0]=0;
            }
        } 
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int top = 0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        int left = 0;
        while(top<=bottom && left<=right){
            //left to right
            for(int j=left;j<=right;j++){
                ls.add(matrix[top][j]);
            }
            top++;
            //top to bottom
            for(int i=top;i<=bottom;i++){
                ls.add(matrix[i][right]);
            }
            right--;
            //right to left 
            //recheck boundary bcz top is changed
if(top<=bottom){
            for(int j=right;j>=left;j--){
                ls.add(matrix[bottom][j]);
            }
            bottom--;
}
            //bottom to top
//recheck boundary bcz right is also changed
if(left<=right){
            for(int i=bottom;i>=top;i--){
                ls.add(matrix[i][left]);
            }
            left++;
        }
        }
        return ls;
    }
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefix_sum = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix_sum += nums[i];
            if(mp.containsKey(prefix_sum-k)){
                count = count + mp.get(prefix_sum-k);
            }
            mp.put(prefix_sum,mp.getOrDefault(prefix_sum,0)+1);
        }
        
return count;
    }
    public List<List<Integer>> generate(int r) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=r;i++){
            List<Integer> ls = pascalrow(i);
            ans.add(ls);
        }
        return ans;
    }
    protected List<Integer> pascalrow(int r){
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        long ans = 1;
        for(int i=1;i<r;i++){
            ans = ans * (r-i)/i;
            ls.add((int)ans);
        
        }
        return ls;
    }
}
