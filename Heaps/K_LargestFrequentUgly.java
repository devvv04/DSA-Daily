package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class K_LargestFrequentUgly {
     public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int n : nums){
        //     pq.offer(n);
        // }
        // for(int i=0;i<k-1;i++){
        //     pq.poll();
        // }
        // return pq.peek();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

for(int n : nums){
    pq.offer(n);

    if(pq.size() > k){
        pq.poll();
    }
}

return pq.peek();
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b)-> mp.get(a) - mp.get(b)
        );
        for(int key : mp.keySet()){
            pq.offer(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int val = pq.poll();
            ans[i] = val;
        }
        return ans;
    }
    public int nthUglyNumber(int n) {
        if(n==1) return 1;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> hs = new HashSet<>();
        pq.offer(1L);
        hs.add(1L);
        long val = 1L;
        for(int i=0;i<n;i++){
            val = pq.poll();
            if(!hs.contains(val*2)){
                hs.add(val*2);
                pq.offer(val*2);
            }
            if(!hs.contains(val*3)){
                hs.add(val*3);
                pq.offer(val*3);
            }
            if(!hs.contains(val*5)){
                hs.add(val*5);
                pq.offer(val*5);
            }
        }
        return (int)(val);
        // while(pq.size()<n){
        //     int val = pq.poll();
        //     if(!hs.contains(val*2)){
        //         hs.add(val*2);
        //         pq.offer(val*2);
        //     }
        //     if(!hs.contains(val*3)){
        //         hs.add(val*3);
        //         pq.offer(val*3);
        //     }
        //     if(!hs.contains(val*5)){
        //         hs.add(val*5);
        //         pq.offer(val*5);
        //     }
        // }
        // return pq.peek();
    }
    public List<String> topKFrequentWord(String[] words, int k) {
        HashMap<String,Integer> mp = new HashMap<>();
        for(String s : words){
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b)->{
                if(mp.get(a).equals(mp.get(b))){
                return a.compareTo(b);
                }
                return mp.get(b) - mp.get(a);
            }
        );
        for(String st : mp.keySet()){
            pq.offer(st);
        }
        List<String> ls = new ArrayList<>();
        for(int i=0;i<k;i++){
            ls.add(pq.poll());
        }
        return ls;
    }
}
