package sorting;
public class quick_sort {
    public int[] quicksort(int[] arr){
        qs(arr,0,arr.length-1);
        return arr;
    }
    private void qs(int[] nums,int low,int high){
        if(low<high){
            int pivot_idx = partition(nums,low,high);
            qs(nums,low,pivot_idx-1);
            qs(nums,pivot_idx+1,high);
        }
    }
    private void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    private int partition(int[] arr,int low, int high){
       int pivot = arr[low];
        int l = low;
        int r = high;
        while(l<r){
            //left to right for finding first larger then pivot
            while( l<=high && arr[l]<=pivot){
                l++;
            }
            //right to left for finding first smaller then pivot
            while(arr[r]>pivot){
                r--;
            }if(l<r){
            swap(arr,l,r);
            }
        }
        swap(arr,r,low);
        
        return r;
    }
    
    
    
    
    
    
    public static void main(String[] args) {
       quick_sort m = new quick_sort();
       int[] nums = {4,6,2,5,7,9,1,3};
       m.quicksort(nums);
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}


