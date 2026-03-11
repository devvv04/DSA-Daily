package BinarySearch;

public class RowMax1_SearchMatrix {
      public int rowWithMax1s(int[][] mat) {
       int row = mat.length;
       int col = mat[0].length;
       int noOf1inThisRow = 0;
       int ans = -1;
       int ind = -1;
       for(int i=0;i<row;i++){
           int firstone = -1;
           int low = 0;
           int high = col-1;
           while(low<=high){
               int mid = low + (high -low)/2;
               if(mat[i][mid]==1){
                   firstone = mid;
                   high = mid-1;
               }
               else{
                   low = mid+1;
               }
           }
           if(firstone == -1) noOf1inThisRow = -1;
           else{
               noOf1inThisRow = col - firstone;
           }
           if(noOf1inThisRow>ans){
               ind = i;
               ans = noOf1inThisRow;
           }
           
       }
       return ind;
    }
    
     public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = (row * col)-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            int midr = mid / col;
            int midc = mid % col;
            if(matrix[midr][midc]==target) return true;
            if(matrix[midr][midc]>target) high = mid-1;
            else low = mid+1;
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        RowMax1_SearchMatrix m = new RowMax1_SearchMatrix();
        // int[][] qst = {{0,0,0,0},{0,1,1,1},{1,1,1,1},{0,0,1,1}};
        int[][] qst2 = {{0,0,0},{0,0,0},{0,0,0}};
        int ans = m.rowWithMax1s(qst2);
        System.out.println(ans);
    }
}
