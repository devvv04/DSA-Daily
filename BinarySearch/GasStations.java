package BinarySearch;

import java.util.PriorityQueue;

public class GasStations {
     public double minimiseMaxDistancetoGasStationusingqueue(int[] nums, int k) {
        int[] countstat = new int[nums.length-1];
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0], a[0]));
for(int i = 0;i<nums.length-1;i++){
    pq.add(new double[]{nums[i+1]-nums[i],i});
}
//j is gas station
for(int j=1;j<=k;j++){
double[] top = pq.poll();
int indexwithmaxdiff = (int) top[1];
double originaldiff = nums[indexwithmaxdiff+1] - nums[indexwithmaxdiff];
countstat[indexwithmaxdiff]++;
double newdiff = originaldiff/(countstat[indexwithmaxdiff]+1);
pq.add(new double[]{newdiff,indexwithmaxdiff});
}
  return pq.peek()[0];
    }
    
     public double minimiseMaxDistancebinary(int[] nums, int k) {
        double low = 0;
        double high = 0;
        for(int i=0;i<nums.length-1;i++){
            int diff = nums[i+1] - nums[i];
            if(diff > high) high = diff;
        }
        double range = 1e-6;
        while(high-low>range){
            double mid = low + (high - low)/2;
            int count = 0;
             for (int i = 1; i < nums.length; i++) {
            int numberInBetween = (int) ((nums[i] - nums[i - 1]) / mid);
            if ((nums[i] - nums[i - 1]) == (mid * numberInBetween)) {
                numberInBetween--;
            }
            count += numberInBetween; //total number of additional gas stations required
        }
            if(count<=k){
                high = mid;
            }
            else{
               low = mid;
            }
        }
        return high;
    }
    
    public int rowWithMax1sbrute(int[][] mat) {
        int ans = 0;
        int reqind = -1;
       for(int i=0;i<mat.length;i++){
           int count = 0;
           for(int j=0;j<mat[0].length;j++){
               if(mat[i][j]==1) count++;
           }
           if(count>ans){
               ans = count;
               reqind = i;
           } 
       }
       return reqind;
    }
    
    // public int rowWithMax1sbinary(int[][] mat) {
       
    // }
    
    public static void main(String[] args) {
        GasStations m = new GasStations();
        // int[] nums = {1, 2, 3, 4, 5, 6 ,7, 8, 9, 10};
        // double ans = m.minimiseMaxDistancebinary(nums,10);
        int[][] qst = {{0,0,0},{0,0,1},{0,1,1}};
        int ans = m.rowWithMax1sbrute(qst);
        System.out.println(ans);
    }
}
