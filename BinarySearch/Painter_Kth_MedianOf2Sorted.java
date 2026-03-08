package BinarySearch;

public class Painter_Kth_MedianOf2Sorted {
     public int paintBoard(int A, int B, int[] C) {
    int largest = Integer.MIN_VALUE;
    int sum = 0;
    int ans = 0;
    for(int n : C){
        if(n > largest) largest = n;
        sum = sum + n;
    }
    if(A>=C.length) return (largest * B) % 10000003 ;
    int low = largest * B;
    int high = sum * B;
    while(low<=high){
        int mid = low + (high- low )/2;
        int paintercount = 1;
        int timesum = 0;
        for(int nu : C){
            timesum = timesum + (nu * B);
            if(timesum <= mid) continue;
            else{
                timesum = nu * B;
                paintercount++;
            }
        }
        if(paintercount <= A){
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
    }
    return ans % 10000003 ;
    }
    
    
    public int kthElementof2sortedarrBS(int[] a, int[] b, int k) {
     int low = Integer.max(0, k - b.length);
      int high = Integer.min(k,a.length);
      int l1 = 0;
          int l2 = 0;
          int r1 = 0;
          int r2 = 0;
          int ans = 0;
      while(low<=high){
          int mid = low + (high - low)/2;
          int cut1 = mid;
          int cut2 = k - mid;
          if(cut1 == 0){  
              l1 = Integer.MIN_VALUE;
          }
          else{
              l1 = a[cut1-1];
          }
          if(cut2 == 0){ 
              l2 = Integer.MIN_VALUE;
          }
          else{
              l2 = b[cut2-1];
          }
          if(cut1 == a.length){ 
              r1 = Integer.MAX_VALUE;
          }
          else{
              r1 = a[cut1];
          }
          if(cut2 == b.length){ 
              r2 = Integer.MAX_VALUE;
          }
          else{
              r2 = b[cut2];
          }
          
          if(l1<=r2 && l2<=r1){ //valid
              ans = Integer.max(l1,l2);
              break;
          }
          else if(l1>r2){
              high = mid-1;
          }
          else{
              low = mid+1;
          }
          
      }
      return ans;
    }

    
    //brute
     public double findMedianSortedArraysBRUTE(int[] nums1, int[] nums2) {
        // brute force without log(n+m):
        int[] nums = new int[nums1.length+nums2.length];
        int k = 0;
        int l = 0;
        int r = 0;
        double ans = 0;
        while(l<=nums1.length-1 && r<=nums2.length-1){
            if(nums1[l]<=nums2[r]){
                nums[k++] = nums1[l];
                l++;
            }
            else{
                nums[k++] = nums2[r];
                r++;
            }
        }
        while(l<=nums1.length-1){
            nums[k++] = nums1[l];
            l++;
        }
        while(r<=nums2.length-1){
 nums[k++] = nums2[r];
                r++;
        }

if(nums.length % 2 == 0){ //even
 ans = (double)(nums[nums.length/2] + nums[(nums.length/2) - 1]) /2;
}
else{
     ans = nums[nums.length/2];
}
return ans;
}
//optimal
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length)
    return findMedianSortedArrays(nums2, nums1);
double ans = 0; 
int total = nums1.length+nums2.length;
if(total % 2 == 0){ //even
ans = (double) (kthElementof2sortedarrBS(nums1,nums2,total/2) + kthElementof2sortedarrBS(nums1,nums2,(total/2)+1))/2;
}
else{
    ans = (double) kthElementof2sortedarrBS(nums1,nums2,(total/2)+1);
}
return ans;
    }
    
    public static void main(String[] args) {
        Painter_Kth_MedianOf2Sorted m = new Painter_Kth_MedianOf2Sorted();
        int qst[] = {2, 3, 6, 7, 9,11};
        int[] qst2 = {1, 4, 8, 10};
        double ans = m.findMedianSortedArrays(qst,qst2);
        System.out.println(ans);
    }
}
