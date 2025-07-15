class Solution {
    public long repairCars(int[] ranks, int cars) {
        long st = 1;
        Arrays.sort(ranks);
        long en = (long) 1e14;
        long ans = 0;
        while (st <= en) {
            long m = st + (en - st) / 2;
            if (isPos(m, ranks, cars)) {
                ans = m;
                en = m - 1;
            } else {
                st = m + 1;
            }
        }
        return ans;
    }

    public static boolean isPos(long lim, int ranks[], int cars) {
        long count = 0;
        for (int i : ranks) {
            count += (long) Math.sqrt(lim / i);
        }
        return count >= cars;
    }
}