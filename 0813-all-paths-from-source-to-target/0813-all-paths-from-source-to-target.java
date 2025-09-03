class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> res =  new ArrayList<>();
       List<Integer> t = new ArrayList<>();
       boolean vis [] = new boolean [graph.length];
       dfs(res,t,0,graph);
       return res;
    }
    public void dfs(List<List<Integer>> res,List<Integer> t, int val,int[][]adj){
        if(val==adj.length-1){
            t.add(val);
            res.add(new ArrayList<>(t));
            t.remove(t.size()-1);
            return;
        }
        t.add(val);
        for(int i : adj[val]){
            dfs(res,t,i,adj);
        }
        t.remove(t.size()-1);
    }
}