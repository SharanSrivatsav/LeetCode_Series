class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int freq [] = new int [100001];
        int l = 0; int sum =0; int max =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            sum+=val;
            freq[val]++;
            while(freq[val]>1&&l<=i){
                freq[nums[l]]--;
                sum-=nums[l++];
            }
            max =Math.max(sum,max);
        }
        return max;
    }
}