class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int ans = 0;
        int max = 0;
        int k = 0;
        for (int a[] : mat) {
            int s = 0;
            for (int i : a) {
                s += i;
            }
            if (s > max) {
                max = s;
                ans = k;
            }
            k++;
        }
        return new int []{ans,max};
    }
}