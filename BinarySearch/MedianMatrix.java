package BinarySearch;

public class MedianMatrix {
     //try1:
    //not working
     public int findMedianTry1(int[][] matrix) {
         int totalrow = matrix.length;
         int totalcol = matrix[0].length;
         if(totalrow==1){
             return matrix[0][totalcol/2];
         }
         else{
         int nums1[] = new int[(totalrow-1)*3];
         int nums2[] = new int[totalcol];
         int k = 0;
         for(int i=0;i<totalrow-1;i++){
             for(int j=0;j<totalcol;j++){
                 nums1[k] = matrix[i][j]; 
                 k++;
             }
         }
         int l=0;
             for(int j1=0;j1<totalcol;j1++){
                 nums2[l] = matrix[totalrow-1][j1]; 
                 l++;
             }
         
         int median = ((totalrow * totalcol) + 1)/2;
         return kthElementof2sortedarrBS(nums1,nums2,median);
         }
      
    }
     private int kthElementof2sortedarrBS(int[] a, int[] b, int k) {
     int low = Integer.max(0, k - b.length);
      int high = Integer.min(k,a.length);
      int l1 = 0;
          int l2 = 0;
          int r1 = 0;
          int r2 = 0;
          int ans = 0;
      while(low<=high){
          int mid = low + (high - low)/2;
          int cut1 = mid;
          int cut2 = k - mid;
          if(cut1 == 0){  
              l1 = Integer.MIN_VALUE;
          }
          else{
              l1 = a[cut1-1];
          }
          if(cut2 == 0){ 
              l2 = Integer.MIN_VALUE;
          }
          else{
              l2 = b[cut2-1];
          }
          if(cut1 == a.length){ 
              r1 = Integer.MAX_VALUE;
          }
          else{
              r1 = a[cut1];
          }
          if(cut2 == b.length){ 
              r2 = Integer.MAX_VALUE;
          }
          else{
              r2 = b[cut2];
          }
          
          if(l1<=r2 && l2<=r1){ //valid
              ans = Integer.max(l1,l2);
              break;
          }
          else if(l1>r2){
              high = mid-1;
          }
          else{
              low = mid+1;
          }
          
      }
      return ans;
    }
    
    //try2:
    //good , but not optimal due to howmany func taking n * m time
    public int findMedianTry2(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int med = ((row * col)+1)/2;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = 0;
        for(int i =0;i<row;i++){
            if(matrix[i][0]<low) low = matrix[i][0];
            if(matrix[i][col-1]>high) high = matrix[i][col-1];
        }
        while(low<=high){
            int mid = low + (high - low)/2;
             if(howmany(matrix,mid)>=med){
                ans = mid;
                high = mid-1;
            }
            else if(howmany(matrix,mid)<med){
                low = mid+1;
            } 
        }
        return ans;
    } 
    private int howmany(int[][] matrix,int val){
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]<=val) count++;
            }
        }
        return count;
    }
    
    //try 3:
    // O(r log c × log(max-min))
     public int findMedianTry3(int[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;
        int med = ((row * col)+1)/2;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = 0;
        for(int i =0;i<row;i++){
            if(matrix[i][0]<low) low = matrix[i][0];
            if(matrix[i][col-1]>high) high = matrix[i][col-1];
        }
        while(low<=high){
            int mid = low + (high - low)/2;
            int count = 0;
            for(int k = 0;k<row;k++){
                count = count + howmanyEachRow(matrix[k],mid);
            }
            if(count>=med){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    } 
    private int howmanyEachRow(int[] row ,int val){
        int low = 0;
        int high = row.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(row[mid]>val){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    
    public static void main(String[] args) {
       MedianMatrix m = new MedianMatrix();
       int qst[][] = { {1,3,8}, {2, 3, 4}, {1,2,5} } ;
       int ans =  m.findMedianTry3(qst);
       System.out.println(ans);
    }
}
