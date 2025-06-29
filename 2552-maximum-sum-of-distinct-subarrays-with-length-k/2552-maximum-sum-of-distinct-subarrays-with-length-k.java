class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set =  new HashSet<>();
        long sum =0;
        long max =0;
        int l =0;
        for(int i=0;i<nums.length;i++){
            while(set.contains(nums[i])){
                sum-=nums[l];
                set.remove(nums[l]);
                l++;
            }
            sum+=nums[i];
            set.add(nums[i]);
            if(i-l+1==k){
                max=Math.max(max,sum);
                sum-=nums[l];
                set.remove(nums[l++]);
            }
        }
        return max;
    }
}