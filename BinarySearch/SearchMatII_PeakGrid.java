package BinarySearch;

import java.util.Arrays;

public class SearchMatII_PeakGrid {
     public boolean searchMatrixIIBS(int[][] matrix, int target) {
        // binary search approach : 
        for(int i =0;i<matrix.length;i++){
             if(target < matrix[i][0] || target > matrix[i][matrix[0].length-1])
            continue;
            int low = 0;
            int high = matrix[0].length-1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(matrix[i][mid]==target) return true;
                else if(matrix[i][mid]>target) high = mid-1;
                else low = mid+1;
            }
        }
        return false;
    }
    
     public boolean searchMatrixIILeftDown(int[][] matrix, int target){
         int left = 0;
         int down = matrix[0].length-1;
         while(down>=0 && left<=matrix.length-1){
             if(matrix[left][down]== target) return true;
             if(matrix[left][down]>target){
                 down--;
                 continue;
             }
             if(matrix[left][down]<target){
                 left++;
                 continue;
             }
         }
         return false;
     }
     
     public int[] findPeakGrid(int[][] mat) {
     int low = 0;
     int high = mat[0].length-1;
     while(low<=high){
         int mid = low + (high-low)/2;
         int largest = Integer.MIN_VALUE;
         int mr = 0;
         for(int i=0;i<mat.length;i++){
             if(mat[i][mid]>largest){
                 largest = mat[i][mid];
                 mr = i;
             }
         }
         int left = (mid>0) ? mat[mr][mid-1] : -1;
         int right = (mid<mat[0].length-1)?mat[mr][mid+1]:-1;
         if(mat[mr][mid]>left && mat[mr][mid]>right){
             return new int[]{mr,mid};
         }
         else if(mat[mr][mid]<left) high = mid-1;
         else low = mid+1;
     }
         return new int[]{-1,-1};
     }
     
    public static void main(String[] args) {
        SearchMatII_PeakGrid m = new SearchMatII_PeakGrid();
        int qst[][] = {{10,20,15},{21,14,30},{7,16,32}};
        int[] ans = m.findPeakGrid(qst);
        System.out.println(Arrays.toString(ans));
    }
}
