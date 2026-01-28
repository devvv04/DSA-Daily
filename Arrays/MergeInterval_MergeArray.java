package Arrays;
import java.util.*;
public class MergeInterval_MergeArray {
    public int[][] mergeMatrix(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]!=b[0]){
                return Integer.compare(a[0],b[0]);
            }
            else{
                return Integer.compare(a[1],b[1]);
            }
        });
        List<int[]> ls = new ArrayList<>();
        int[] current = intervals[0];
        ls.add(current);
        for(int i =0;i<intervals.length;i++){
            int[] next = intervals[i];
            if(current[1]>=next[0]){
                current[1] = Math.max(current[1],next[1]);
            }
            else{
                current = next;
                ls.add(current);
            }
        }
        int[][] matrix = new int[ls.size()][];
        for(int i=0;i<ls.size();i++){
            matrix[i] = ls.get(i);
        }
        return matrix;
    }
    
    public List<List<Integer>> mergeList(List<List<Integer>> intervals){
        intervals.sort((a, b) -> {
    if (!a.get(0).equals(b.get(0)))
        return Integer.compare(a.get(0), b.get(0));
    return Integer.compare(a.get(1), b.get(1));
});

List<List<Integer>> ls = new ArrayList<>();
List<Integer> current = intervals.get(0);
ls.add(current);
for(int i=1;i<intervals.size();i++){
    List<Integer> next = intervals.get(i);
    if(next.get(0)<=current.get(1)){
        //list.set(index,value)
        current.set(1,Math.max(current.get(1),next.get(1)));
    }
    else{
        current = next;
        ls.add(current);
    }
}
return ls;
    } 
    
     public void mergesortedarray(int[] nums1, int m, int[] nums2, int n) {
     int i = m-1;
     int j = n-1;
     int k = m+n-1;
     while(i>=0&&j>=0){
         if(nums1[i]>nums2[j]){
             nums1[k] = nums1[i];
             i--;
         }
         else{
             nums1[k] = nums2[j];
             j--;
         }
         k--;
     }
     while(j>=0){
         nums1[k] = nums2[j];
         j--;
         k--;
     }
     }

    
    public static void main(String[] args) {
        MergeInterval_MergeArray m = new MergeInterval_MergeArray();
    //   int[][] matrix = {{1,3},{15,18},{8,10},{2,6}};
    //   int[][] ans = m.mergeMatrix(matrix);
    //   for(int i=0;i<ans.length;i++){
    //       for(int j=0;j<ans[0].length;j++){
    //           System.out.print(ans[i][j]+" ");
    //       }
    //       System.out.println();
    //   }
    // 5,7],[1,3],[4,6],[8,10]
//     List<List<Integer>> ls = new ArrayList<>();
//   ls.add(new ArrayList<>(Arrays.asList(5, 7)));
// ls.add(new ArrayList<>(Arrays.asList(1,3)));
//   ls.add(new ArrayList<>(Arrays.asList(4,6)));
// ls.add(new ArrayList<>(Arrays.asList(8,10)));
// List<List<Integer>> ans = new ArrayList<>();
// ans = m.mergeList(ls);
//     System.out.println(ans);
int[] nums1 = {-5, -2, 4, 5,0,0,0};
int[] nums2 = {-3, 1, 8};
m.mergesortedarray(nums1,4,nums2,3);
for(int i=0;i<nums1.length;i++){
    System.out.println(nums1[i]);
}
    }
}
