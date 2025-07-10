class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int st = 1 ;
        int en = nums.length-2;
        int ans = 0;
        while(st<=en){
            int m = (st+en)/2;
            if(nums[m+1]<nums[m]&&nums[m-1]<nums[m]){
                ans = m;
                en--;
            }
            else if (nums[m+1]<nums[m]&&nums[m-1]>nums[m]){
                en = m-1;
            }
            else if(nums[m+1]>nums[m]&&nums[m-1]<nums[m]){
                st=m+1;
            }
            else{
                st++;
                // en--;
            }
        }
        return ans;
    }
}