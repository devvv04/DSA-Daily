package BinarySearch;

public class Min_DaybouquetDivShipweight {
    public int minDaysBouquets(int[] nums, int m, int k) {
          if(nums.length<(long)m*k) return -1;
        int small = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        int ans = 0;
        for(int n : nums){
            if(n<small) small = n;
            if(n>largest) largest = n;
        }
        int low = small;
        int high = largest;
        while(low<=high){
            int mid = low + (high - low)/2;
             int count = 0;
int groups = 0;
            for(int nu : nums){
                if(nu<=mid){
                    count++;
                }
                else{
                    count = 0;
                }
                if (count == k) {
                groups++;
                count = 0;

                if(groups>m) break;
            }
            }
if(groups >=m){
    ans = mid;
    high = mid-1;
}
else{
    low = mid+1;
}
        }
        return ans;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int largest = Integer.MIN_VALUE;
        int ans = 0;
        for(int n : nums){
            if (n > largest) largest = n;
        }
        int low = 1;
        int high = largest;
        while(low<=high){
            int mid = low + (high - low)/2;
            int divsum = 0;
            for(int nu: nums){
                divsum = divsum + (nu+(mid-1))/mid;
            }
            if(divsum <= threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    
     public int shipWithinDays(int[] nums, int days) {
         int totalpackwei = 0;
        int ans =0;
        int lar = Integer.MIN_VALUE;
        for(int n : nums){
            if(n > lar) lar = n;
            totalpackwei = totalpackwei + n;
        }
        if(days == 1) return totalpackwei;
        int low = lar;
        int high = totalpackwei;
        while(low<=high){
            int mid = low + (high - low)/2;
            int tt = mid;
            int count = 0;
            for(int nu : nums){
                if(tt>=nu){
                tt = tt - nu;
                }
                else{
                    count++;
                    tt = mid-nu;
                  }
        }
        count++;
        if(count<=days){
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
      Min_DaybouquetDivShipweight m = new Min_DaybouquetDivShipweight();
      int[] qst = {1,2,3,4,5,6,7,8,9,10};
      int ans = m.shipWithinDays(qst,5);
      System.out.println(ans);
    }
}
