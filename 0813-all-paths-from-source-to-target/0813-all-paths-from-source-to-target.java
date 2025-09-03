class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> res =  new ArrayList<>();
       List<Integer> t = new ArrayList<>();
       boolean vis [] = new boolean [graph.length];
       dfs(res,t,vis,0,graph);
       return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> t, boolean vis [], int val,int[][]adj){
        if(val==adj.length-1){
            t.add(val);
            res.add(new ArrayList<>(t));
            t.remove(t.size()-1);
            return;
        }
        vis[val]=true;
        t.add(val);
        for(int i : adj[val]){
            if(!vis[i]){
                dfs(res,t,vis,i,adj);
            }
        }
        t.remove(t.size()-1);
        vis[val]=false;
    }
}