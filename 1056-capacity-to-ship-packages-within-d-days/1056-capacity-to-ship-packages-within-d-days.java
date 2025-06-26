class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int st = 0;
        int en = 0;
        for (int i : weights) {
            st = Math.max(st, i);
            en += i;
        }
        int ans = 0;
        while (st <= en) {
            int m = (st + en) / 2;
            if (isVal(weights, m, days)) {
                ans = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return ans;
    }

    public static boolean isVal(int nums[], int m, int k) {
        int s = 0;
        int c = 1;
        for (int i : nums) {
            if (s + i > m) {
                c++;
                s = i;
            } else {
                s += i;
            }
        }
        return c <= k;
    }
}