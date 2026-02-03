package BinarySearch;

public class LowerUpperB_FloorCeil_Range {
    public int lowerBound(int[] nums, int x) {
       int low = 0;
       int high = nums.length-1;
       int ans = nums.length;
       while(low<=high){
           int mid = (high+low)/2;
           if(nums[mid]<x){
               low = mid+1;
           }
           else if(nums[mid]>=x){
               ans = Math.min(ans,mid);
               high = mid -1;
           }
       }
       return ans;
     }
     
     public int upperBound(int[] nums, int x) {
  int low = 0 ;
  int high = nums.length-1;
  int ans = nums.length;
  while(low<=high){
      int mid = (high+low)/2;
      if(nums[mid]>x){
        ans = Math.min(ans,mid);
        high = mid-1;
      }
      else if(nums[mid]<=x){
          low = mid+1;
      }
  }
  return ans;
    }
    
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int ans = nums.length;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]<target){
                low = mid+1;
            }
            else{
                ans = Math.min(ans,mid);
                high = mid-1;
            }

        }
        return ans;
    }
    
    public int[] getFloorAndCeil(int[] nums, int x) {
       int lb = lowerBound(nums,x);
       int n = nums.length;
       int floor = 0;
       int ceil = 0;
       //ceil
       if(lb<n){
           ceil = nums[lb];
       }
       else{
           ceil = -1;
       }
       //floor
       if(lb<n && nums[lb]==x){
           floor = x;
       }
       else if(lb >  0){
           floor = nums[lb-1];
       }
       else{
           floor = -1;
       }
       int[] ans = new int[2];
       ans[0] = floor;
       ans[1] = ceil;
       return ans;
    }
    
     public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
       int lb = lowerBound(nums,target);
       int ub = upperBound(nums,target);
       int first = 0;
       int second = 0;
       if(lb == n || nums[lb]!=target){
        first = -1;
        second = -1;
       }
       else if(nums[lb] == target){
        first = lb;
        second = ub-1;
       }
       int[] ans = new int[2];
       ans[0] = first;
       ans[1] = second;
       return ans;
    }
    
    public int countOccurrences(int[] arr, int target) {
    return upperBound(arr,target) - lowerBound(arr,target);
    }
    
    public static void main(String[] args) {
       LowerUpperB_FloorCeil_Range m = new LowerUpperB_FloorCeil_Range();
       int[] qst = {5,7,7,7,7,7,7,8,8,10};
      int ans = m.upperBound(qst,8);
    System.out.println(ans);
    //   for(int i=0;i<2;i++){
    //   System.out.println(ans[i]);
    // }
    }
}
