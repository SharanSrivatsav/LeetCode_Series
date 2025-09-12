class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val]<0){
                res.add(val+1);
            }
            nums[val]*=-1;
        }
        return res;
    }
}