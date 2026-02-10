class Solution {
    public int longestBalanced(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            Set<Integer> set = new HashSet<>();
            int odd = 0; int eve = 0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                   if(!set.contains(nums[j])){
                      eve++;
                      set.add(nums[j]);
                   }
                }
                else{
                    if(!set.contains(nums[j])){
                      odd++;
                      set.add(nums[j]);
                   }
                }
                if(odd==eve){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}