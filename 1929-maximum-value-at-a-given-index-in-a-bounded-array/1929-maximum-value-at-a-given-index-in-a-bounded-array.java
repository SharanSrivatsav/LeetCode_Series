class Solution {
    public int maxValue(int n, int index, int maxSum) {
        long st = 1;
        long en = maxSum;
        int ans = -1;
        while (st <= en) {
            long m = st + (en - st) / 2;
            if (isPos(m, maxSum, n, index)) {
                ans =(int)m;
                st = m + 1;
            } else {
                en = m - 1;
            }
        }
        return ans;
    }

    public boolean isPos(long m, int maxSum, int n, int ind) {
        long val = m-1;
        int l=ind;
        int r = n-ind-1;
        long leftSum=0;
        long rightSum=0;
        //leftSum
        // there are 2 possibilties for left and as well as right
        if(val<=l){
             //  greater length
             // adding sum of n natural numbers
            leftSum+=(val*(val+1))/2;
            // for rem area adding simply ones
            leftSum+=(l-val);
        }
        else{
            //smaller length
            leftSum+=(val*(val+1))/2;
            long sub = val-l;
            // if smaller then we need to reduce the sum length to a certain area
            leftSum-=(sub*(sub+1))/2;

        }
        if(val<=r){
            rightSum+=(val*(val+1))/2;
            rightSum+=(r-val);
        }
        else{
            rightSum+=(val*(val+1))/2;
            long sub = val-r;
            rightSum-=(sub*(sub+1))/2;
        }
        long sum = m+rightSum+leftSum;
        return sum<=maxSum;
    }
}