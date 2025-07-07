class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int i : nums) {
            ans += Math.abs(i - mid);
        }
        return ans;
    }
}