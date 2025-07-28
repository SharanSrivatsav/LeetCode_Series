class Solution {
    TreeMap<Integer, Integer> map;

    public int countMaxOrSubsets(int[] nums) {
        map = new TreeMap<>();
        solver(nums, 0, 0);
        return map.get(map.lastKey());
    }

    public void solver(int nums[], int ind, int OR) {
        map.put(OR,map.getOrDefault(OR,0)+1);
        if (ind == nums.length) {
            return;
        }
        for(int i=ind;i<nums.length;i++){
            solver(nums,i+1,OR|nums[i]);
        }
    }
}