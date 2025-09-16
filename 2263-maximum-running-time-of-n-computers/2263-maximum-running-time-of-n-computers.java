class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long st = 0;
        long en = 0;
        for( int i : batteries){
            en+=i;
        }
        long ans = -1;
        while(st<=en){
            long mid = st+(en-st)/2;
            if(isPos(batteries,n,mid)){
                ans = mid;
                st = mid+1;
            }
            else{
                en=mid-1;
            }
        }
        return ans;
    }
    public boolean isPos(int arr [] , int n , long val){
        long t= val*n;
        long sum=0;
        for( int i : arr){
            if(i<val){
                sum+=i;
            }
            else{
                sum+=val;
            }
            if(sum>=t){
                return true;
            }
        }
        return false;
    }
}