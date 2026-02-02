package BinarySearch;
class Iterative_Recursive {
    public int BinarySearchIterative(int[] nums, int target) {
         int low = 0;
         int high = nums.length-1;
        
         while(low<=high){
         int mid = (high+low)/2;
         if(nums[mid] == target) return mid;
         else if(nums[mid]>target){
             high = mid-1;
             continue;
         }
         else if(nums[mid]<target){
             low = mid+1;
             continue;
         }
         }
         return -1;
     }
    
    public int BinarySearchRecursive(int[] nums, int target){
        return recursive(nums,0,nums.length-1,target);
    }
    public int recursive(int[] nums, int low , int high,int target){
        if(low>high) return -1;
        int mid = (high+low)/2;
        if(nums[mid] == target) return mid;
        else if(nums[mid]>target){
            return recursive(nums,low,mid-1,target);
        }
        else{
           return recursive(nums,mid+1,high,target);
        }
    }
    
    public static void main(String[] args) {
        Iterative_Recursive m = new Iterative_Recursive();
        int[] qst = {-1,0,3,5,9,12};
        int ans = m.BinarySearchRecursive(qst,12);
        System.out.println(ans);
    }
}
