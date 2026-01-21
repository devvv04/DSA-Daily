package Arrays;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
class longestConsecutive {
     public List<Integer> leaders(int[] nums){
            List<Integer> ls = new ArrayList<>();
            int max = Integer.MIN_VALUE;
            int n = nums.length;
            for(int i=n-1;i>=0;i--){
                if(nums[i]>max){
                    max = nums[i];
                    ls.add(nums[i]);
                }
            }
            Collections.reverse(ls);
            return ls;
        }
        public void nextperm(int[] nums){
            int idx = -1;
            int n = nums.length;
            for(int i = n-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    idx = i;
                    break;
                }
            }
            if(idx==-1){
                reverse(nums,0,n-1);
            }
            for(int j=n-1;j>idx;j--){
                if(nums[j]>nums[idx]){
                    swap(nums,j,idx);
                    break;
                }
            }
            reverse(nums,idx+1,n-1);
        }
        private void swap(int[] nums,int a , int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
        private void reverse(int[] nums , int start , int end){
            while(start<end){
                swap(nums,start,end);
                start++;
                end--;
            }
        }
        public int[] rearrangeArray(int[] nums){
            int[] res = new int[nums.length];
            int pos = 0;
            int neg = 1;
            for(int n : nums){
                if(n>=0){
                    res[pos] = n;
                    pos = pos+2;
                }
                else{
                    res[neg] = n;
                   neg = neg+2;
                }
            }
            return res;
        }
     public int stockbuySell(int[] prices){
         int mindaytobuy = Integer.MAX_VALUE;
         int maxprofit  = 0;
         for(int n : prices){
             if(n<mindaytobuy){
                 mindaytobuy = n;
             }
                else if(n-mindaytobuy>maxprofit){
                    maxprofit = n-mindaytobuy;
             }
         }
         return maxprofit;
     }
      public int maxSubArray(int[] nums){
          int cs = 0;
          int ms = nums[0];
          for(int n : nums){
              cs = cs + n;
              if(cs>ms){
                  ms = cs;
              }
              if(cs<0){
                  cs = 0;
              }
          }
          return ms;
      }
       public int longestConsecutive1(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int n : nums){
            st.add(n);
        }
        int maxlen = 0;
        for(int n : st){
            if(!st.contains(n-1)){
                int current = n;
                int streak = 1;
            
            while(st.contains(current+1)){
                current++;
                streak++;
            }
            maxlen = Math.max(maxlen,streak);
        }
        }
        return maxlen;
    }
   
    public static void main(String[] args) {
    //   int[][] ans = {{1,1,1},{1,0,1},{1,1,1}};
    //   Main m = new Main();
        // List<Integer> res = new ArrayList<>();
    //   res = m.leaders(arr);
    // m.setZeroes(ans);
// System.out.println(ans);
    // for(int i=0;i<ans.length;i++){
    //     for(int j=0;j<ans[0].length;j++){
    //   System.out.print(ans[i][j]);
    //     }
    //     System.out.println();
    // }
        
    }
}