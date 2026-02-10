class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length;
        long[] pre = new long[n];
        pre[0] = chalk[0];
        for (int i = 1; i < chalk.length; i++) {
            pre[i] += pre[i - 1] + chalk[i];
        }
        int ans = -1;
        long rem = k % pre[n - 1];
        int st = 0;
        int en = chalk.length - 1;
        while (st <= en) {
            int mid = st + (en - st) / 2;
            if (pre[mid] <= rem) {
                st = mid + 1;
            } else {
                ans = mid;
                en = mid - 1;
            }
        }
        return ans;
    }
}