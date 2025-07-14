class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int st=1;
        int en =0;
        for(int i : quantities) en = Math.max(en,i);
        int ans = 0;
        while(st<=en){
            int m  = st+(en-st)/2;
            if(isPos(n,quantities,m)){
                ans =m;
                en=m-1;
            }
            else{
                st=m+1;
            }
        }
        return ans;
    }
    public static boolean isPos(int req, int arr[], int div){
        int c = 0;
        for(int i:arr){
            c+=i/div;
            if(i%div!=0){
                c++;
            }
        }
        return c<=req;
    }
}