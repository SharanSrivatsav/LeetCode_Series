class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int st = 1;
        int en = 10000000;
        int ans = -1;
        while (st <= en) {
            int m = st + (en - st) / 2;
            if (isPos(m, dist, hour)) {
                ans = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return ans;
    }

    public static boolean isPos(int div, int arr[], double hr) {
        double divi = div;
        double tot = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            tot += Math.ceil((double) arr[i] / divi);
        }
        tot += (double) arr[arr.length - 1] / divi;
        return tot <= hr;
    }
}