class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int st = 0;
        int en = changeIndices.length - 1;
        for (int i = 0; i <= en; i++) {
            changeIndices[i]--;
        }
        int ans = -1;
        while (st <= en) {
            int m = (st + en) / 2;
            if (isVal(nums, changeIndices, m)) {
                ans = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return ans == -1 ? -1 : ans + 1;
    }

    public static boolean isVal(int nums[], int idx[], int k) {
        int last[] = new int[nums.length];
        for (int i = 0; i <= k; i++) {
            last[idx[i]] = i;
        }
        int count = 0;
        int power = 0;
        for(int i=0;i<=k;i++){
            if(i==last[idx[i]]){
                if(nums[idx[i]]>power){
                    return false;
                }
                power-=nums[idx[i]];
                count++;
            }
            else{
                power++;
            }
        }
        return count==nums.length;
    }
}