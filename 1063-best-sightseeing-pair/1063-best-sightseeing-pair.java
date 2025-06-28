class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int prev  = values[0];
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<values.length;i++){
            ans  = Math.max(ans,values[i]-i+prev);
            prev = Math.max(prev,values[i]+i);
        }
        return ans;
    }
}