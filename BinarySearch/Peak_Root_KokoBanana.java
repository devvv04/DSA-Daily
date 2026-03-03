package BinarySearch;

public class Peak_Root_KokoBanana {
      public int findPeakElement(int[] nums) {
        int low = 0;
 int high = nums.length-1;
 while(low<high){
     int mid = low + (high - low)/2;
     if(nums[mid]<nums[mid+1]){
         low = mid+1;
     }
     else{
         high = mid;
     }
 }
 return high;
    }
    
    public int findKRotation(int[] nums) {

    int low = 0;
    int high = nums.length - 1;

    while (low < high) {

        int mid = low + (high - low) / 2;

        if (nums[mid] > nums[high]) {
            low = mid + 1;
        } 
        else {
          
            high = mid;
        }
    }

    return low;  
}

public int floorSqrt(int n) {

    if (n == 0 || n == 1) return n;

    int low = 1;
    int high = n;
    int ans = 0;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (mid <= n / mid) {
            ans = mid;          
            low = mid + 1;    
        } else {
            high = mid - 1;    
        }
    }

    return ans;
}

 public int NthRoot(int n, int m) {
         if (n == 1 || m == 1) return m;

    int low = 1;
    int high = m;
    int ans = -1;

    while (low <= high) {

        int mid = low + (high - low) / 2;
        long power = 1;
        for(int i=0;i<n;i++){
            power = power * mid;
            if(power>m) break;        
        }
        if(power == m){
            ans = mid;
        }
        else if(power>m){
            high = mid-1;
        }
        else{
            low = mid+1;
        }

    }
        return ans;
 }
 
  public int KokoEatBananas(int[] nums, int h) {
      int lar = Integer.MIN_VALUE;
   for(int n : nums){
       if (n>lar){
           lar = n;
       }
   }
   int low = 1;
   int high = lar;
   int ans = 0;
   while(low<=high){
       int mid = low + (high-low)/2;
       int totaltime = 0;
       for(int nu : nums){
           totaltime = totaltime + (nu + (mid-1))/mid;
       }
       if(totaltime<=h){
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
        Peak_Root_KokoBanana m = new Peak_Root_KokoBanana();
        int[]  qst = {3,6,7,11};
        int ans = m.KokoEatBananas(qst,8);
        System.out.println(ans);
    }
}
