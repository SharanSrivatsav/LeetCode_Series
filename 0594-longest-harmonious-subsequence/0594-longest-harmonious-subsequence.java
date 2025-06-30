class Solution {
    public int findLHS(int[] nums) {
       Arrays.sort(nums); int maxLen =0;
       for(int i=0;i<nums.length;i++){
          int val =binSearch(nums,nums[i]+1);
          if(nums[val]==nums[i]+1){
            maxLen = Math.max(maxLen,val-i+1);
          }
       }
       return maxLen;
    }
    public static int binSearch (int nums[],int t){
        int st =0;
        int en = nums.length-1;
        int ans =-1;
        while(st<=en){
            int m = (st+en)/2;
            if(nums[m]<=t){
                ans =m;
                st=m+1;
            }
            else{
               en=m-1;
            }
        }
        return ans;
    }
}