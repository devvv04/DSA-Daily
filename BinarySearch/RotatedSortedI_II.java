package BinarySearch;

public class RotatedSortedI_II {
     public int RotatedSortedI(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
int mid = low  + (high - low)/2;
if(nums[mid]==target) return mid;
else if(nums[low]<=nums[mid]){ //left is sorted
    if(nums[low]<=target && target<nums[mid]){  //target in range of sorted
        high = mid-1;
        continue;
    }
    else{  // target is not in sorted so target is in right
        low = mid+1;
        continue;
    }
}
else{   //right is sorted
if(nums[mid]<=target && target<=nums[high]){  //target in range of sorted
    low = mid+1; 
    continue;
}
else{   //target is not in sorted so in left
    high = mid-1;  
    continue;
}
}
        }
return -1;
    }
    
     public boolean RotatedSortedII(int[] nums, int target){
         int low = 0;
         int high = nums.length-1;
         while(low<=high){
             int mid = (high + low)/2;
             if(nums[mid]==target) return true;
             if(nums[low]==nums[mid]&& nums[mid]==nums[high]){
                 low++;
                 high--;
                 continue;
             }
             else if(nums[low]<=nums[mid]){
                 if(nums[low]<=target && target < nums[mid]){
                     high = mid-1;
                     continue;
                 }
                 else{
                     low = mid+1;
                     continue;
                 }
             }
             else{
                 if(nums[mid]<target && target<=nums[high]){
                     low = mid+1;
                     continue;
                 }
                 else{
                     high = mid-1;
                     continue;
                 }
             }
         }
         return false;
     }
    
    public static void main(String[] args) {
        RotatedSortedI_II m = new RotatedSortedI_II();
        int[] qst = {3,1,2,3,3,3,3};
        // int ans = m.RotatedSortedI(qst,1);
        boolean ans = m.RotatedSortedII(qst,1);
        System.out.println(ans);
    }
}
