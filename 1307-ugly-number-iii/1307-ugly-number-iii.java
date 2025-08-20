class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
         long st=0;
         long en = Long.MAX_VALUE;
         long ans = 0;
         while(st<=en){
            long m = st+(en-st)/2;
            if(isFeasible(a,b,c,m,n)){
                st=m+1;
            }
            else{
                ans=m;
                en=m-1;
            }
         }
         return(int)ans;
    }

    long gcd(long a, long b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
    long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }
    boolean isFeasible(long a, long b, long c,long val,long k){
        long count = (val/a)+(val/b)+(val/c)+(val/lcm(a,lcm(b,c)))-(val/lcm(a,b))-(val/lcm(b,c))-(val/lcm(c,a));
        return count<k;
    }
}