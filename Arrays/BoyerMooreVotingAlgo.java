package Arrays;
import java.util.*;


class BoyerMooreVotingAlgo {
    //boyer.s moore voting algo 
    //majority element >n/2
    public int majorityN2(int[] nums){
        int candidate = 0;
        int count = 0;
        for(int n : nums){
            if(n == candidate){
                count++;
            }
            else if(count==0){
                candidate = n;
                count = 1;
            }
            else{
                count--;
            }
        }
        return candidate;
    }
    //majority element >n/3
    public List<Integer> majorityN3(int[] nums){
        int nl = nums.length;
        int c1 = 0;
        int c2 = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int n : nums){
            if(n == c1){
                cnt1++;
                }
            else if(n == c2){
                cnt2++;
            }
            else if(cnt1 == 0){
                c1 = n;
                cnt1 = 1;
            }
            else if(cnt2 == 0){
                c2 = n;
                cnt2 = 1;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int d : nums){
            if(d == c1) cnt1++;
            if(d == c2) cnt2++;
        }
        List<Integer> ls = new ArrayList<>();
        if(cnt1 > nl/3) ls.add(c1);
        if(cnt2 > nl/3) ls.add(c2);
        return ls;
    }
    //majority element >n/k
    public List<Integer> majorityNK(int[] nums,int k){
        int nl = nums.length;
        //edge case
        List<Integer> ls = new ArrayList<>();
        if(k<=1) return ls;
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else if(map.size()<k-1){
                map.put(n,1);
            }
            else{
                Iterator<Map.Entry<Integer,Integer>> it = map.entrySet().iterator();
                while(it.hasNext()){
                    Map.Entry<Integer,Integer> entry = it.next();
                    entry.setValue(entry.getValue() -1);
                    if(entry.getValue() == 0){
                        it.remove();
                    }
                }
            }
        }
            Map<Integer,Integer> freq = new HashMap<>();
            for(int d:nums){
                if(map.containsKey(d)){
                    freq.put(d,freq.getOrDefault(d,0)+1);
                }
            }
            for(int key : freq.keySet()){
                if(freq.get(key)>nl/k){
                    ls.add(key);
                }
            }
        return ls;
    }
    public static void main(String[] args) {
        BoyerMooreVotingAlgo m = new BoyerMooreVotingAlgo();
        int[] arr = {1,1,1,3,3,2,2,2};
        // int ans = m.majorityN2(arr);
        List<Integer> ls = new ArrayList<>();
        ls = m.majorityNK(arr,3);
        System.out.println(ls);
    }
}