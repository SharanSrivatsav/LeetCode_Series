class Solution {
    public int splitArray(int[] nums, int k) {
        int st = 0;
        int en = 0;
        for (int i : nums) {
            st = Math.max(i, st);
            en += i;
        }
        while (st < en) {
            int m = st + (en - st) / 2;
            if (isPos(nums, k, m)) {
                en = m;
            } else {
                st = m + 1;
            }
        }
        return st;

    }
    public static boolean isPos(int[] nums, int k, int v) {
        int c = 1;
        int s = 0;
        for (int i : nums) {
            if (s + i > v) {
                c++;
                s = i;
            } else {
                s += i;
            }
        }
        return c <= k;
    }
}