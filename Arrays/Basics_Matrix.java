package Arrays;
class Basics_Matrix {
     public void setZeroesbrute(int[][] matrix){
          int r = matrix.length;
       int c = matrix[0].length;
      for(int i=0;i<r;i++){
           for(int j =0;j<c;j++){
               if(matrix[i][j]==0){
                   changei(matrix,i,c);
                   changej(matrix,j,r);
               }
           }
           
     }
     changeminus(matrix,r,c);
     }
     private void changeminus(int[][] matrix,int r , int c){
          for(int i=0;i<r;i++){
           for(int j =0;j<c;j++){
               if(matrix[i][j]==-1){
                   matrix[i][j] =0;
               }
           }
     }
     }
     private void changei(int[][] matrix ,int i,int c){
         for(int j =0;j<c;j++){
             if(matrix[i][j]!=0){
             matrix[i][j] = -1;
             }
         }
     }
     private void changej(int[][] matrix ,int j,int r){
         for(int i =0;i<r;i++){
             if(matrix[i][j]!=0){
             matrix[i][j] = -1;
             }
         }
     }
     
    public void setZeroesBetter(int[][] matrix){
        int r = matrix.length;
        int c = matrix[0].length;
        int[] colarr = new int[c];
        int[] rowarr = new int[r];
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                if(matrix[i][j]==0){
                    rowarr[i] = 1;
                    colarr[j] = 1;
                }
            }
        }
        for(int i=0;i<r;i++){
            for(int j =0;j<c;j++){
                if(rowarr[i]==1 || colarr[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Basics_Matrix m = new Basics_Matrix();
       int[][] matrix = {{5,6,8,3},{11,0,3,7},{1,5,0,12},{3,0,0,6}};
       int r = matrix.length;
       int c = matrix[0].length;
       m.setZeroesBetter(matrix);
       for(int i=0;i<r;i++){
           for(int j =0;j<c;j++){
               System.out.print(" "+matrix[i][j]);
           }
           System.out.println();
       }
    }
}