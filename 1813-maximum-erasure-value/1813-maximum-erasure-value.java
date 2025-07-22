class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int l = 0; int sum =0; int max =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            while(set.contains(val)&&l<=i){
                sum-=nums[l];
                set.remove(nums[l++]);
            }
            sum+=nums[i];
            set.add(nums[i]);
            max =Math.max(sum,max);
        }
        return max;
    }
}