class Solution {
    public int smallestEqual(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%10==i%10){
                return i;
            }
        }
        return -1;
    }
}