class Solution { 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> ans = new ArrayList<>();
       List<Integer> temp  = new ArrayList<>();
       Arrays.sort(candidates);
       solve(temp,candidates,target,0,0,ans);
       return ans;
    }
    public static void solve(List<Integer> x, int nums [], int t ,int st, int sum,List<List<Integer>> ans){
        // if(sum>t){
        //     return;
        // }
        if(sum==t){
            ans.add(new ArrayList(x));
            return;
        }
        for(int i=st;i<nums.length;i++){
            if(sum+nums[i]>t){
                break;
            }
            x.add(nums[i]);
            solve(x,nums,t,i,sum+nums[i],ans);
            x.remove(x.size()-1);
        }
    } 
}