class Solution {
    int count = 0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a [] : connections){
           adj.get(a[0]).add(a[1]);
           adj.get(a[1]).add(-a[0]);
        } 
        boolean vis [] = new boolean[n];
        dfs(adj,vis,0);
        return count;
    }
    public void dfs (List<List<Integer>> adj, boolean vis [], int node){
        vis[node]=true;
        for(int i:adj.get(node)){
            if(!vis[Math.abs(i)]){
                if(i>0){
                    count++;
                }
                dfs(adj,vis,Math.abs(i));
            }
        }
    }
}