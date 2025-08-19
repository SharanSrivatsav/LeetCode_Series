class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;int l=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                l=i-1;
            }
            while(i<nums.length&&nums[i]==0){
                ans+=i-l;
                i++;
            }
        }
        return ans;
    }
}