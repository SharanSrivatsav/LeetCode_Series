class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int p =0;
        ans[p]=map.lastKey();
        p++;
        int l =0;
        for(int i=k;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            map.put(nums[l], map.get(nums[l])-1);
            if(map.get(nums[l])==0){
                map.remove(nums[l]);
            }
            ans[p]=map.lastKey();
            p++;
            l++;
        }
        return ans;
    }
}