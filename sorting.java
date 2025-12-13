public class sorting {
     public int[] SelectionSort(int[] nums){
        int n = nums.length;
        for(int i=0;i<=n-1;i++){
            int min = i;
            for(int j = i+1;j<=n-1;j++){
                if(nums[j]<nums[min]){
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }
    
    public int[] BubbleSort(int[] nums){
        int n = nums.length;
        boolean isswap = false;
        for(int i =n-1;i>=0;i--){
            for(int j =0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isswap = true;
                }
            }
            if (isswap == false) {
                System.out.println("Already sorted . ");
                break;
            }
        }
        return nums;
    }
    
    public int[] InsertionSort(int[] nums){
        int n = nums.length-1;
        for(int i = 1;i<=n;i++){
            int j = i;
            while(j>0 && nums[j-1]>nums[j]){
                int temp = nums[j];
                 nums[j] = nums[j-1];
                 nums[j-1] = temp;
                 j--;
            }
        }
        return nums;
    }
  
  private void merge(int[] nums,int low,int mid , int high){
            int l = low;
            int r = mid+1;
            int[] temp = new int[high-low+1];
            int k = 0;
            while(l<=mid && r<=high){
            if(nums[l]<=nums[r]){
                // temp.add(nums[l]);
                temp[k++] = nums[l];
                l++;
            }
            else{
                // temp.add(nums[r]);
                temp[k++] = nums[r];
                r++;
            }
        }
        while(l<=mid){
            // temp.add(nums[l]);
            temp[k++] = nums[l];
                l++;
        }
        while(r<=high){
        //   temp.add(nums[r]);
        temp[k++] = nums[r];
                r++;  
        }
        for(int i = 0;i<temp.length;i++){
            nums[low + i] = temp[i];
        }
        
        }
    
 private void divide(int[] nums, int low, int high){
            if(low>=high) return;
            int mid = (low+high) / 2;
            divide(nums,low,mid);
            divide(nums,mid+1,high);
            merge(nums,low,mid,high);
        }    
    
    public int[] MergeSort(int[] nums){
         divide(nums,0,nums.length-1);
         return nums;
    }
    
    
    public static void main(String[] args) {
       sorting m = new sorting();
       int[] arr = {7,32,54,12,7,65,36,86,4,1,5,3};
  
       m.MergeSort(arr);
       
       for(int i =0;i<arr.length;i++){
           System.out.println(arr[i]);
       }
    }
}

