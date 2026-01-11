package Revision;

import java.util.*;
class afterMCA1endsem{
    public void pat1(int x){
        for(int i=1;i<=x;i++){
            for(int j=i;j>0;j--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public void pat7(int n){
        for(int i=1;i<=n;i++){
            //space
            for(int s = n-i;s>0;s--){
                System.out.print(" ");
            }
            //star
            for(int j = 2*i-1;j>0;j--){
                System.out.print("*");
            }
            //space
            for(int s = n-i;s>0;s--){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    
    public void pat14(int n ){
        for(int i=0;i<n;i++){
            for(char j='A';j<='A'+i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
    
    public void pat21(int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0 || i==n-1 ||j==0 || j==n-1){
                System.out.print("*");
                }
                else{
                   System.out.print(" ");
                   
                }
            }
            System.out.println();
        }
    }
    
    public int countdig(int n){
        int count = 0;
        while(n>0){
            count++;
            n = n/10;
        }
        return count;
    }
    
    public int revnumb(int n){
        int rev = 0;
        int last_digi;
        while (n>0){
            last_digi = n % 10;
            n = n/10;
            rev = 10 * rev + last_digi;
        }
        return rev;
    }
    
    public boolean numpalind(int n){
        int temp = n;
        int rev = 0;
        int last_digi;
        while (n>0){
            last_digi = n % 10;
            n = n/10;
            rev = 10 * rev + last_digi;
        }
        if (rev == temp){
        return true;
        }
        else return false;
    }
    
    public String revstr(String st){
        StringBuilder sb = new StringBuilder();
        for(int i = st.length()-1;i>=0;i--){
            sb.append(st.charAt(i));
        }
        return sb.toString();
    }
    
    public boolean strpalind(String st){
        st = st.toLowerCase();
        String temp = st;
        StringBuilder sb = new StringBuilder();
        for(int i = st.length()-1;i>=0;i--){
            sb.append(st.charAt(i));
        }
        return sb.toString().equals(temp);
    }
    
    public int[] divisors(int n) {
    List<Integer> list = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i ==0){
                list.add(i);
                if(n/i!=i){
                    list.add(n/i);
                }
            }
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    
    public boolean isprime(int n){
        int count = 0;
        for(int i=1;i*i<=n;i++){
            
            if(n%i==0){
                count++;
                if(n/i!=i){
                    count++;
                }
            }
        }
        if(count == 2){
        return true;
        }
        else return false;
    }

public void printnameusingrecursion(String s,int n){
    if (n == 0){
        return;
    }
    System.out.println(s);
    printnameusingrecursion(s,n-1);
}

  public int mostFrequentElement(int[] nums) {
     Map<Integer,Integer> freq = new HashMap<>();
     for(int n : nums){
       freq.put(n,freq.getOrDefault(n,0)+1);
     }
int highest_freq = 0;
int ans = Integer.MAX_VALUE;
int count;
for(int key : freq.keySet()){
    count = freq.get(key);
    if(count > highest_freq || count == highest_freq && key<ans){
        highest_freq = count;
        ans = key;
    }
    
}
return ans;
    }
    
     public int largestElement(int[] nums) {
    int max_v = Integer.MIN_VALUE;
    for(int n : nums){
        if (n>max_v){
            max_v = n;
        }
    }
    return max_v;
    }
    
    public int removeduplicates(int[] nums){
        int l =0;
        int r = 1;
        while(r<nums.length){
            if(nums[l]!= nums[r]){
                nums[l+1] = nums[r];
                l++;
            }
            r++;
        }
        return l+1;
    }
    
public static void main(String[] args){
    afterMCA1endsem m = new afterMCA1endsem();
    // int[] res = m.divisors(30);
    // for(int i=0;i<res.length;i++){
    //     System.out.println(res[i]);
    // }
    // System.out.println(m.isprime(7));
    int[] nums = {1,2,5,3,8,4};
   System.out.println(m.largestElement(nums));
    // set<String> st = new LinkedList<>();
    // st.add("hello");
    // st.add("world");
    // System.out.println(st);
    
}    
}
