class Solution {
    public int maximumCandies(int[] candies, long k) {
        int st = 1;
        int en = 0;
        for (int i : candies) {
            en = Math.max(en, i);
        }
        int ans = 0;
        while (st <= en) {
            int m = (st + en) / 2;
            if (isVal(m, candies, k)) {
                ans = m;
                st = m + 1;
            } else {
                en = m - 1;
            }
        }
        return ans;
    }

    public static boolean isVal(int div, int nums[], long k) {
        long c = 0;
        for (int i = 0; i < nums.length; i++) {
            c += (nums[i]) / div;
        }
        return c >= k;
    }
}