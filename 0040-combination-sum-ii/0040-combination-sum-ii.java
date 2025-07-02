class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp  = new ArrayList<>();
        Arrays.sort(candidates);
        int sum=0;
        int st =0;
        solve(candidates,target,sum,st,temp,ans);
        return ans;
    }
    public void solve(int nums[],  int t, int sum, int st, List<Integer> temp,List<List<Integer>> ans){
        if(sum>t){
            return ;
        }
        if(sum==t){
            // if(!ans.contains(temp)){
            ans.add(new ArrayList(temp));
            // }
            return;
        }
        for(int i=st;i<nums.length;i++){
            if(i>st&&nums[i]==nums[i-1]){
              continue;
            }
            if(sum+nums[i]>t){
                break;
            }
            temp.add(nums[i]);
            solve(nums,t,sum+nums[i],i+1,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}