package Arrays;

public class rotateArray {
     public int[] leftbyone(int[] nums){
      int  temp = nums[0];
        for(int i=0;i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
        nums[nums.length-1] = temp;
        return nums;
    }
    public int[] rightbyone(int[] nums){
        int last = nums[nums.length-1];
        for(int i =nums.length-1;i>0;i--){
           nums[i] = nums[i-1];
        }
        nums[0] = last;
        return  nums;
    }
    public void rightbyk(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }
     public void leftbyk(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
        reverse(nums,0,n-1);
    }
        private void reverse(int[]nums,int start, int end){
            while(start<end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            } 
        }
        
    public boolean check(int[] nums) {
     int count = 0;
     for(int i=0;i<nums.length-1;i++){
if(nums[i]>nums[i+1]){
    count++;
}
}
if(nums[nums.length-1]>nums[0]){
    count++;
}   
return count<=1;
    }
    
    public static void main(String[] args) {
        rotateArray m = new rotateArray();
        int[] arr = {4,7,9,12,15}; 
        m.rightbyone(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("Try programiz.pro");
    }
}
