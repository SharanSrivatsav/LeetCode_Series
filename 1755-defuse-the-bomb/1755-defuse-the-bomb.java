class Solution {
    public int[] decrypt(int[] code, int k) {
        int ans [] = new int [code.length]; int n = ans.length;
        if(k==0){
            return ans;
        }
        // next elemnt -> (i+n)%n and prev element -> (i+n-1)%n
        int st = 1; int en = k;
        if(k<0){
            st=n-Math.abs(k); en =n-1;
        }
        int s =0;
        for(int i=st;i<=en;i++){
            s+=code[i%n];
        }
        for(int i=0;i<n;i++){
            ans[i]=s;
            s-=code[(st+i)%n];
            s+=code[(en+i+1)%n];
        }
        return ans;
    }
}