class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int st = 0;
        int en = nums.length - 1;
        int count = 0;
        while (st < en) {
            if (nums[st] + nums[en] == k) {
                count++;
                st++;
                en--;
                continue;
            }
            if (nums[st] + nums[en] < k) {
                st++;
            } else {
                en--;
            }
        }
        return count;
    }
}