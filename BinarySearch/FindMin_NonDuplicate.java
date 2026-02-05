package BinarySearch;
public class FindMin_NonDuplicate {
   public int findMin(int[] nums) { 
       int low = 0;
        int high = nums.length-1;
        int min = nums[low + (high - low)/2];
        while(low<=high){
            int mid = low + (high - low)/2;
            // min = nums[mid];
            //if left is sorted
            if(nums[low]<= nums[mid]){
                min = Math.min(min,nums[low]);
                low = mid+1;
                continue;
            }
            else{
                min = nums[mid];
                min = Math.min(min,nums[mid]);
                high = mid-1;
                continue;
            }
        }
        return min;
   }
   
     public int singleNonDuplicate(int[] nums) {
     int low = 0;
     int high =nums.length-1;
     while(low<high){
         int mid = low + (high-low)/2;
         if(mid % 2 == 1) mid--;
         if(nums[mid]==nums[mid+1]){  //left is ok
             low = mid+2;
         }
         else{  //left has single
             high = mid;
         }
     }
     return nums[low];
     }
    
    public static void main(String[] args) {
        FindMin_NonDuplicate m = new FindMin_NonDuplicate();
int[] qst = {1,1,2,3,3,4,4,8,8};
int ans = m.singleNonDuplicate(qst);
System.out.println(ans);
        // System.out.println(-10%2);
    }
}
// Queue<Integer> q = new LinkedList<>();

        // q.offer(10);
        // q.offer(20);
        // q.offer(30);

        // System.out.println(q);      
        // System.out.println(q.peek()); 

        // q.poll();                    // removes 10
        // System.out.println(q);       // [20, 30]

