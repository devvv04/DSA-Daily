package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class revisionTillBS1_2 {
      public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for(int n : nums){
            if(count == 0){
                candidate = n;
                count = 1;
            }
            else if(n == candidate){
                count++;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
    
    public int maxSubArray(int[] nums) {
     int cs = 0;
     int ms = Integer.MIN_VALUE;
     for(int n : nums){
         cs = cs + n;
         ms = Math.max(ms,cs);
         if(cs < 0){
             cs = 0;
         }
     }
     return ms;
    }
    
    public int[] maxSubArrayExtend(int[] nums){
        int cs = 0;
        int start = 0;
        int end = 0;
        int tempst = 0;
     int ms = Integer.MIN_VALUE;
     for(int i=0; i<nums.length;i++){
         cs = cs + nums[i];
         if(cs>ms){
             ms = cs;
             start = tempst;
             end = i;
         }
         if(cs < 0){
             cs = 0;
             tempst = i+1;
         }
     }
     int[] res = Arrays.copyOfRange(nums, start, end + 1);
     return res;
    }
    
    public int maxProfit(int[] prices) {
       int min = Integer.MAX_VALUE;
       int profit = 0;
       for(int n : prices){
            if(n < min){
                min = n;
            }
            else if(n - min > profit){
                profit = n - min;
            }
       }
       return profit; 
    }
    
    public int[] rearrangeArray(int[] nums) {
        int even = 0;
        int odd = 1;
        int[] ans = new int[nums.length];
        for(int n : nums){
            if(n>=0){
                ans[even] = n;
                even = even+2;
            }
            else{
                ans[odd] = n;
                odd = odd+2;
            }
        }
        return ans;
    }
    
     public void nextPermutation(int[] nums) {
        int idx = -1;
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        //edge case if no idx found i.e last permut
            if(idx==-1)  {
                Arrays.sort(nums);
                return;
            }
        for(int j = nums.length-1;j>idx;j--){
            if(nums[j]>nums[idx]){
                int temp = nums[j];
                nums[j] = nums[idx];
                nums[idx] = temp;
                break;
            }
        }
        reverse(nums,idx+1,nums.length-1);
    }
    private void reverse(int[] nums, int start , int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
     public List<Integer> leaders(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int max = nums[nums.length-1];
        ls.add(max);
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]>max){
                max = nums[i];
                ls.add(max);
            }
        }
        Collections.reverse(ls);
        return ls;
    }
    
      public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int streak = 0;
        int maxlen = 0;
        for(int n : nums){
            set.add(n);
        }
            for(int d : set){
            if(!set.contains(d-1)){
                int curr = d;
                streak = 1;
                while(set.contains(curr+1)){
                    streak++;
                    curr=curr+1;
                }
                 maxlen = Math.max(maxlen,streak);
            }
        }
        return maxlen;
    }

     public void setZeroes(int[][] matrix) {
        boolean frow = false;
        boolean fcol = false;
        //check frow initially have zero?
        for(int j = 0;j<matrix[0].length;j++){
            if(matrix[0][j]==0) {
                frow = true;
                break;
            }
        }
        //check fcol initialy have zero?
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                fcol = true;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j = 1;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    //set first row of that index to 0 
                    matrix[0][j] = 0;
                    //set first col of that index to 0
                    matrix[i][0] = 0;
                }
            }
        }
        //make zero in middle based on frow
        for(int j=1;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=1;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        //make zero in middle based on fcol
        for(int i=1;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        //make first row and col zero based on boolean
        if(frow==true){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }
        if(fcol == true){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }
    }
    
    public void rotate(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j = i+1;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
        int start = 0;
        int end = matrix[0].length-1;
        while(start<end){
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
        }
        }
    }
    
    public List<Integer> spiralorder(int[][] matrix){
        List<Integer> ls = new ArrayList<>();
        int top = 0;
        int right = matrix[0].length-1;
        int left = 0;
        int bottom = matrix.length-1;
        while(top<=bottom && left<=right){
            //left to right
            for(int j = left;j<=right;j++){
                ls.add(matrix[top][j]);
            }
            top++;
            //top to bottom
            for(int i = top;i<=bottom;i++){
                ls.add(matrix[i][right]);
            }
            right--;
            //right to left
            if(top<=bottom){
            for(int j = right;j>=left;j--){
                ls.add(matrix[bottom][j]);
            }
            }
            bottom--;
            //bottom to top
            if(left<=right){
            for(int i = bottom;i>=top;i--){
                ls.add(matrix[i][left]);
            }
             }
            left++;
        }
        return ls;
    }
    
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];  
        int top = 0;
        int right = matrix[0].length-1;
        int left = 0;
        int bottom = matrix.length-1;
        int k = 1;
             while(top<=bottom && left<=right){
            //left to right
            for(int j = left;j<=right;j++){
                matrix[top][j] = k;
                k++;
            }
            top++;
            //top to bottom
            for(int i = top;i<=bottom;i++){
                matrix[i][right]=k;
                k++;
            }
            right--;
            //right to left
            if(top<=bottom){
            for(int j = right;j>=left;j--){
                matrix[bottom][j]=k;
                k++;
            }
            }
            bottom--;
            //bottom to top
            if(left<=right){
            for(int i = bottom;i>=top;i--){
             matrix[i][left]=k;
             k++;
            }
             }
            left++;
        }
        return matrix;
        }
        
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int ps = 0;
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            ps = ps + nums[i];
            if(ps-k==0) count++;
            // if(ps+k==k) count++;
            if(mp.containsKey(ps-k)) count++;
            mp.put(ps,i);
        }
        return count;
    }
    
    public static void main(String[] args) {
        revisionTillBS1_2 m = new revisionTillBS1_2();
        int[] qst = {1,2,3};
        int ans = m.subarraySum(qst,3);
        // int[] ans = m.rearrangeArray(qst);
        // System.out.println(Arrays.toString(qst));
        // int[][] qst = {{1,2,3},{4,5,6},{7,8,9}};
        // int[][] qst = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        // int[][] qst = m.generateMatrix(3);
        // List<Integer> ls = new ArrayList<>();
        // ls = m.spiralorder(qst);
        System.out.println(ans);
        
        // m.rotate(qst);
        // for(int i=0;i<qst.length;i++){
        //     for(int j=0;j<qst[0].length;j++){
        //      System.out.print(qst[i][j]+" ");   
        //     }
        //     System.out.println();
        // }
    }
}
