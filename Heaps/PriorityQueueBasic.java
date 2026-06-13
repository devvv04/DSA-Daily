package Heaps;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class PriorityQueueBasic {
     public static void main(String[] args) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            Collections.reverseOrder());
        
        pq.offer(4);
        pq.offer(3);
        pq.offer(1);
        pq.offer(7);
        pq.offer(5);
        System.out.println(pq);
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        
        HashMap<Character,Integer> mp = new HashMap<>();
        mp.put('d',6);
        mp.put('g',9);
        mp.put('h',1);
        mp.put('t',3);
        //acc to values inc to dec key is g d t h
        PriorityQueue<Character> maxfreq = new PriorityQueue<>(
            (a,b)->mp.get(b)-mp.get(a));
        for(char key : mp.keySet()){
            maxfreq.offer(key);
        }
        System.out.println(maxfreq);
         while(!maxfreq.isEmpty()){
            System.out.println(maxfreq.poll());
        }
        
        
        
        
    }
}
