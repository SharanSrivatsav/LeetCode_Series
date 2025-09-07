class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        /*if isPos(){
            reduce the search space
        }*/
        int max = -1;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int st = 1;
        int en = max;
        int ans = -1;
        while (st <= en) {
            int m = st + (en - st) / 2;
            if (isPos(nums, m, maxOperations)) {
                ans = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return ans;
    }

    public boolean isPos(int nums[], int val, int maxCount) {
        int c = 0;
        for (int i : nums) {
            c += (i - 1) / val;
            if (c > maxCount) {
                return false;
            }
        }
        return true;
    }
}