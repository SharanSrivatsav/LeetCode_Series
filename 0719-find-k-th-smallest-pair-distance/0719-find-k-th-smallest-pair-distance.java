class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int st = 0;
        Arrays.sort(nums);
        int en = nums[nums.length - 1]-nums[0];
        int ans = en - nums[0];
        while (st <= en) {
            int mid = st + (en - st) / 2;
            if (isPos(nums, mid, k)) {
                en = mid - 1;
                ans = mid;
            } else {
                st = mid + 1;
            }
        }
        return ans;
    }

    public boolean isPos(int nums[], int val, int k) {
        int c = 0;
        int l =0;
        for (int i = 0; i < nums.length; i++) {
            while(nums[i]-nums[l]>val){
                l++;
            }
            c+=i-l;
        }
        return c >= k;
    }
}