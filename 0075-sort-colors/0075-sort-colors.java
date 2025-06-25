class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int e = nums.length - 1;
        int m = 0;
        while (m <= e) {
            if (nums[m] == 0) {
                swap(nums, s, m);
                s++;
                m++;
            } else if (nums[m] == 2) {
                swap(nums, e, m);
                e--;
            } else {
                // this is the condition to skip 1's(s stops for "0" next pos)
                //(if no 1 appears "s" stops and "m" moves)
                // s stops here to indicate the next pos of no 0
                // if ind m encounters no 0 the swap occurs between s and m value and thus sorted
                m++;
            }
        }
    }

    public static void swap(int nums[], int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}