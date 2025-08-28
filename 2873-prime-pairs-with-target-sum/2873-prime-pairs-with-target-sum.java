class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 3) {
            return res;
        }
        boolean sieve[] = new boolean[n + 1];
        sieve[1] = true;
        sieve[0] = true;
        for (int i = 2; i <= n; i++) {
            if (!sieve[i]) {
                for (long j = (long) i * i; j <= n; j += i) {
                    sieve[(int) j] = true;
                }
            }
        }
        for (int i = 2; i <= n / 2; i++) {
            int comp = n - i;
            if (!sieve[i] && !sieve[comp]) {
                res.add(Arrays.asList(i, comp));
            }
        }
        return res;
    }
}