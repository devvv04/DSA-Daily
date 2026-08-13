package Revision;

import java.util.HashMap;

public class BootCampMCA1 {
    public int ques1(int n,int x){
        return ((n-1)*10)-((n-1)*x);
    }
    public int romantoit(String s){
        HashMap<Character,Integer> mp = new HashMap<>();
        mp.put('I',1);
        mp.put('V',5);
        mp.put('X',10);
        mp.put('L',50);
        mp.put('C',100);
        mp.put('D',500);
        mp.put('M',1000);
        int ans = 0;
        for(int i=0;i<s.length()-1;i++){
            if(mp.get(s.charAt(i))<mp.get(s.charAt(i+1))){
                ans = ans - mp.get(s.charAt(i));
            }else{
                ans = ans + mp.get(s.charAt(i));
            }
        }
        ans = ans + mp.get(s.charAt(s.length()-1));
        return ans;
    }

    public static void main(String[] args) {
        BootCampMCA1 m = new BootCampMCA1();
        // int ans = m.ques1(4,5);
        int ans = m.romantoit("MCMXCIV");
        System.out.println(ans);
    }
}
