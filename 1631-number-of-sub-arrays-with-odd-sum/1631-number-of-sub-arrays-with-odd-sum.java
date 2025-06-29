class Solution {
    public int numOfSubarrays(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        map.put(1, 0);
        int s = 0;
        int c = 0;
        int mod = 1_000_000_007;
        for (int i : arr) {
            s += i;
            if ((s % 2) != 0) {
                c += map.get(0);
                map.put(1, map.get(1) + 1);

            } else {
                c += map.get(1);
                map.put(0, map.get(0) + 1);
            }
            c=(c%mod);
        }
        return c;
    }
}