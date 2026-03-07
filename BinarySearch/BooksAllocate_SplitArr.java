package BinarySearch;

public class BooksAllocate_SplitArr {
     public int bookAllocation(int[] nums, int m) {
   int largest = Integer.MIN_VALUE;
   int sum = 0;
   for(int n : nums){
       sum = sum + n;
       if(n>largest) largest = n;
   }
   int low = largest;
   int high = sum;
   int ans = 0;
   while(low<=high){
       int mid = low + (high - low)/2;
       int countstud = 1;
       int pagesum = nums[0];
       for(int i =1;i<nums.length;i++){
           pagesum = pagesum + nums[i];
           if(pagesum<=mid) continue;
           else if(pagesum>mid){
               pagesum = nums[i];
               countstud++;
           }
       }
       if(countstud<=m){
           ans = mid;
           high = mid-1;;
       }
       else{
           low = mid+1;
       }
   }
    return ans;
         
     }
    
      public int splitArray(int[] nums, int k) {
        if(nums.length<k) return -1;
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        int ans = 0;
        for(int n : nums){
            sum = sum + n;
            if(n>largest) largest = n;
        }
        int low = largest;
        int high = sum;
        while(low<=high){
            int mid = low + (high - low)/2;
            int count = 1;
            int subsum = nums[0];
            for(int i = 1;i<nums.length;i++){
                subsum = subsum + nums[i];
                if(subsum<=mid) continue;
                else{
                    subsum = nums[i];
                    count++;
                }
            }
            if(count<=k){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        BooksAllocate_SplitArr m = new BooksAllocate_SplitArr();
        int[] qst = {12, 34, 67, 90};
        int ans = m.bookAllocation(qst,2);
        System.out.println(ans);
    }
}
