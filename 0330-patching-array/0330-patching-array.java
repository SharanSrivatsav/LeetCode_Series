class Solution {
    public int minPatches(int[] nums, int n) {
        long covered = 0;
        int i =0; int c =0;
        while(covered<n){
            if(i<nums.length&&nums[i]<=covered+1){
                covered+=(long)nums[i]*1;
                i++;
            }
            else{
                long newCoin = covered+1;
                covered+= newCoin;
                c++;
            }
        }
        return c;
    }
}