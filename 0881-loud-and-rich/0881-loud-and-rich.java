class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int max = quiet.length;
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<max;i++){
            adj.add(new ArrayList<>());
        }
        for(int a [] :richer){
            adj.get(a[1]).add(a[0]);
        }
        // adjacency list is created
        int res [] =  new int [quiet.length];
        for(int i=0;i<max;i++){
            res[i]=dfs(adj,new boolean[quiet.length],i,quiet);
        }
        return res;
    }
    public int dfs(List<List<Integer>> adj , boolean vis[], int node , int q []){
        vis[node]=true;
        if(adj.get(node).size()==0){
            return node;
        }
        int val =q[node];
        int min = node;
        for(int i : adj.get(node)){
            if(!vis[i]){
              val = dfs(adj,vis,i,q);
              if(q[val]<q[min]){
                min=val;
              }
              vis[i] =true;
            }
        }
        return min;
    }
}