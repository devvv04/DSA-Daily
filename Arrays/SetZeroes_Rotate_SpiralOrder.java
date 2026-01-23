package Arrays; 
import java.util.List;
import java.util.ArrayList;
//Matrix qstns
class SetZeroes_Rotate_SpiralOrder {
    //brute
   public void setZeroesBrute(int[][] matrix){
       int row = matrix.length;
       int col = matrix[0].length;
       int min = Integer.MIN_VALUE;
       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               if(matrix[i][j]==0){
                   changerow(matrix,i,col,min);
                   changecol(matrix,j,row,min);
               }
           }
       }
       changeminus(matrix,row,col,min);
   }
   public void changeminus(int[][]matrix,int row,int col,int min){
       for(int i=0;i<row;i++){
           for(int j=0;j<col;j++){
               if(matrix[i][j]==min){
                   matrix[i][j] =0;
               }
           }
       }
   }
   public void changerow(int[][]matrix,int i, int col,int min){
       for(int a=0;a<col;a++){
           if(matrix[i][a]!=0){
           matrix[i][a] = min;
           }
       }
   }
   public void changecol(int[][]matrix,int j, int row,int min){
       for(int b=0;b<row;b++){
           if(matrix[b][j]!=0){
           matrix[b][j] = min;
           }
       }
   }
   //better
   public void setZeroesBetter(int[][] matrix){
       int row = matrix.length;
       int col = matrix[0].length;
       int[] rowarr = new int[row];
       int[] colarr = new int[col];
       for(int i=0;i<row;i++){
           for(int j =0;j<col;j++){
               if(matrix[i][j]==0){
                   rowarr[i]=1;
                   colarr[j]=1;
               }
           }
       }
       for(int i=0;i<row;i++){
           for(int j =0;j<col;j++){
               if(rowarr[i]==1||colarr[j]==1){
                   matrix[i][j]=0;
               }
           }
       }
       
   }
   //optimal
   public void setZeroesOptimal(int[][]matrix){
     int  row = matrix.length;
       int col = matrix[0].length;
       boolean rowarrcontainzero = false;
       boolean colarrcontainzero = false;
       for(int i=0;i<row;i++){
           if(matrix[i][0]==0){
                   rowarrcontainzero = true;
                   break;
           }
       }
        for(int j=0;j<col;j++){
               if(matrix[0][j]==0){
                   colarrcontainzero = true;
                   break;
           }
           
       }
   
   for(int i=1;i<row;i++){
       for(int j=1;j<col;j++){
           if(matrix[i][j]==0){
               matrix[0][j]=0;
               matrix[i][0]=0;
           }
       }
   }
   for(int i=1;i<row;i++){
       for(int j=1;j<col;j++){
           if(matrix[i][0] ==0||matrix[0][j]==0){
               matrix[i][j]=0;
           }
       }
   }
   if(rowarrcontainzero == true){
       for(int a=0;a<row;a++){
           matrix[a][0] =0;
       }
   }
    if(colarrcontainzero == true){
       for(int b=0;b<col;b++){
           matrix[0][b] =0;
       }
   }
   
       
   }
   
    public void rotate(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    // transpose
    for(int i=0;i<row;i++){
        for(int j =i+1;j<col;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    //reverse row
    for(int i=0;i<row;i++){
        int start = 0;
        int end = col-1;
        while(start<end){
            int temp = matrix[i][start];
            matrix[i][start] = matrix[i][end];
            matrix[i][end] = temp;
            start++;
            end--;
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
            for(int j = left;j<=right;j++){
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
            //recheck boundary bcz right is changed
            if(left<=right){
            for(int i=bottom;i>=top;i--){
                ls.add(matrix[i][left]);
            }
            left++;
            }
        }
        
        
        return ls;
    }
    
    public static void main(String[] args) {
        SetZeroes_Rotate_SpiralOrder m = new SetZeroes_Rotate_SpiralOrder();
       int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
    //   int r = matrix.length;
    //   int c = matrix[0].length;
    //   m.rotate(matrix);
    //   for(int i=0;i<r;i++){
    //       for(int j =0;j<c;j++){
    //           System.out.print(" "+matrix[i][j]);
    //       }
    //       System.out.println();
    //   }
    List<Integer> ls = new ArrayList<>();
    ls = m.spiralOrder(matrix);
    System.out.println(ls);
    }
}