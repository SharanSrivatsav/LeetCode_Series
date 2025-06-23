class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n= nums.length;
        Map <Integer,Integer> x = new HashMap <>();
        for(int i=0;i<n;i++){
            int c = target-nums[i];
            if(x.containsKey(c)){
                return new int [] {i,x.get(c)};
            }
            x.put(nums[i],i);
        }
        return null;
    }
}