package Recursion;

public class MyPow_CountGoodNo {
     public double myPow(double x, int n) {
        // double ans = 1;
        // long nn = n;
        // if(n<0) nn = -1 * nn;
        // while(nn>0){
        //     if(nn%2==0){
        //         x = x*x;
        //         nn = nn/2;
        //     }
        //     else{
        //         ans = ans * x;
        //         nn = nn - 1;
        //     }
        // }
        // if(n<0) ans = (double)1/(double)ans;
        // return ans;

        long nn = n;
        if(nn<0){
            return 1.0 / power(x,-nn);
        }
        return power(x,nn);
    }
    private double power(double x , long n){
        // long ans = 1;
        if(n==0) return 1;
        if(n%2==0){
            return power(x*x,n/2);
        }
        return x * power(x,n-1);
    }
      public int countGoodNumbers(long n) {
        int MOD = 1000000007;
        long evenno = (n+1)/2;
        long oddno = n/2;
        return (int)((myPowG(5,evenno) * myPowG(4,oddno)) % MOD);

    }


// public long myPow(long x, long n) {
//      int MOD = 1000000007;
//         if(n==0) return 1;
//         if(n%2==0){
//             return (myPow((x*x)%MOD,n/2))%MOD;
//         }
//         return (x * myPow(x,n-1))%MOD;
//     }

protected long myPowG(long x , long n){
    int mod = 1000000007;
    if(n == 0) return 1;
    long half = myPowG(x,n/2);
    long ans = (half * half)%mod;
    if(n%2==1){
        ans = (x * ans)%mod;
    }
    return ans;
}
}
