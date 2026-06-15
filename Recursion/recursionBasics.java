package Recursion;

public class recursionBasics {
     public int myAtoi(String s) {
        int i = 0;
        int  n = s.length();
        while(i<n && s.charAt(i)==' ') i++;
        int sign = 1;
        if(i<n && (s.charAt(i)=='-' || s.charAt(i)=='+')){
            if(s.charAt(i)=='-') sign = -1;
            i++;
        }
        long ans = helper(s,i,0,sign);
        return (int)ans;
    }
    protected int helper(String s,int i,long ans,int sign){
    if(i>=s.length() || !Character.isDigit(s.charAt(i))){
            return (int)ans*sign;
    }
    ans = ans * 10 + s.charAt(i)-'0';
    if(ans*sign>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
    if(ans*sign<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
    return helper(s,i+1,ans,sign);

}

    // infinte loop:
    // public void help(){
    //     System.out.println(1);
    //     help();
    // }
    
    //condition ; base
    // static int count = 0;
    // public void help(){
    //     if(count>4) return;
    //     System.out.println(1);
    //     count++;
    //     help();
    // }
    
    // learning function stack:
    // static int count = 0;
    // public void help(){
    //     if(count>4) return;
    //     System.out.println(count);
    //     count++;
    //     help();
    // }
    
    //backward , after recurion call
    // public void help(int n){
    //     if(n>4) return;
    //     help(n+1);
    //     System.out.println(n);
    // }
    
    // Question for basic recursion knowledge
    // print name 5 times
    public void namef(String name,int n){
        if(n==5) return;
        System.out.println(name);
        namef(name,n+1);
    }
    // print linearly from 1 to n
    public void l1toN(int n , int i){
        if(i>n)return;
        System.out.println(i);
        l1toN(n,i+1);
       
    }
    // print from n to 1
    public void lNto1(int n){
        if(n==0) return;
        System.out.println(n);
        lNto1(n-1);
    }
    // print 1 to n but by backtrack
    public void b1toN(int n){
        if(n==0) return;
        b1toN(n-1);
        System.out.println(n);
    }
    // print from n to 1 by backtrack
    public void bNto1(int n,int i){
        if(i>n) return;
        bNto1(n,i+1);
        System.out.println(i);
    }
    public static void main(String[] args) {
        recursionBasics m = new recursionBasics();
        System.out.println("Start small. Ship something.");
        // m.help(0);
        // m.namef("Dev",0);
        // m.l1toN(5,1);
        // m.lNto1(5);
        // m.b1toN(5);
        m.bNto1(5,1);
    }
}
