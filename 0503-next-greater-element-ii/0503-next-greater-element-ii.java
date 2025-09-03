class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        int n = nums.length;
        int res [] = new int [nums.length];
        for(int i=0;i<res.length;i++){
            res[i]=-1;
        }
        for(int i=0;i<nums.length*2;i++){
            if(stk.isEmpty()){
                stk.push(i%n);
                continue;
            }
            while(!stk.isEmpty()&&nums[stk.peek()]<nums[i%n]){
                res[stk.pop()]=nums[i%n];
            }
            stk.add(i%n);
        }
        return res;
    }
}