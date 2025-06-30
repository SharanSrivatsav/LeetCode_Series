class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int maxLen =0;  int l=0;
        for(int i=0;i<nums.length;i++){
            while(nums[i]-nums[l]>1){
                l++;
            }
            if(nums[i]-nums[l]==1){
                maxLen=Math.max(maxLen,i-l+1);
            }
        }
        return maxLen;
    }
}