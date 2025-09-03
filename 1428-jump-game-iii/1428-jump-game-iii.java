class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr,start, new boolean[arr.length]);
    }
    public boolean dfs(int [] arr, int val, boolean vis[]){
        if(val<0||val>=arr.length||vis[val]){
            return false;
        }
        if(arr[val]==0){
            return true;
        }
        vis[val]=true;
        if(dfs(arr,val-arr[val],vis)){
            return true;
        }
        return dfs(arr,val+arr[val],vis);
    }
}