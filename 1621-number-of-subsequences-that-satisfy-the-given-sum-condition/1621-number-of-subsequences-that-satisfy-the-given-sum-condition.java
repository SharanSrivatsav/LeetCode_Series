class Solution {
    static final int mod = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        // since we have 2 bounds upper and lower there are possibilities of 2^(j-i) subsequences
        int pow[] = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < nums.length; i++)
            pow[i] = (pow[i - 1] * 2) % mod;
        for (int i = 0; i < nums.length; i++) {
            int serVal = target - nums[i];
            if (serVal < nums[i]) {
                continue;
            }
            int val = binSearch(nums, serVal);
            if (val >= i) {
                ans = (ans + pow[val - i]) % mod;
            }
        }
        return ans;
    }

    public static int binSearch(int nums[], int t) {
        int st = 0;
        int en = nums.length - 1;
        int ans = -1;
        while (st <= en) {
            int m = st + (en - st) / 2;
            if (nums[m] <= t) {
                ans = m;
                st = m + 1;
            } else {
                en = m - 1;
            }
        }
        return ans;
    }
}