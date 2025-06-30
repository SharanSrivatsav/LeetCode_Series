class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums,temp,list,0);
        return list;
    }
    public static void solve(int nums[],List<Integer> temp ,List<List<Integer>> list, int st ){
        list.add(new ArrayList<>(temp));
        if(st==nums.length){
            // base condition
            return;
        }
        for(int i=st;i<nums.length;i++){
            temp.add(nums[i]);
            solve(nums,temp,list,i+1);
            temp.remove(temp.size()-1);
        }
    }
}