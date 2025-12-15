package sorting;
class Solution {
    private void recursivebs(int[] nums , int i){
        if(i==1) return;
        for(int j = 0;j<=i-2;j++){
            if(nums[j]>nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
        recursivebs(nums,i-1);
    }
    public int[] bubbleSort(int[] nums) {
recursivebs(nums,nums.length);
return nums;
    }

    public int[] insertionSort(int[] nums) {
recursiveIs(nums,0,nums.length);
    return nums;
    }
    private void recursiveIs(int[] nums , int i, int n){
if(i==n-1) return;
for(int j =i+1;j>0;j--){
    if(nums[j]<nums[j-1]){
        int temp = nums[j];
        nums[j] = nums[j-1];
        nums[j-1] = temp;
    }
    else{
        break;
    }
}
recursiveIs(nums,i+1,n);
    }

public static void main(String[] args) {
    Solution sol = new Solution();
    int[] arr = {5,2,9,1,5,6};
    arr = sol.bubbleSort(arr);
    System.out.println("Bubble Sorted: ");
    for(int num : arr){
        System.out.print(num + " ");
    }
    System.out.println();

    int[] arr2 = {3,0,2,5,4,1};
    arr2 = sol.insertionSort(arr2);
    System.out.println("Insertion Sorted: ");
    for(int num : arr2){
        System.out.print(num + " ");
    }
    System.out.println();
}
}

