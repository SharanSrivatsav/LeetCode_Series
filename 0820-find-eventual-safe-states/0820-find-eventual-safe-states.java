class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<Integer> res = new ArrayList<>();
        boolean vis[] = new boolean [V];
        boolean pathVis[] = new boolean [V];
        boolean isSafe [] = new boolean [V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfsCheck(graph,i,vis,pathVis,isSafe);
            }
        }
        for(int i=0;i<V;i++){
            if(isSafe[i]){
                res.add(i);
            }
        }
        return res;
    }
    public boolean dfsCheck (int adj[][], int node , boolean vis[], boolean dfsVis[],boolean saf[]){
        vis[node] = true;
        dfsVis[node] = true;
        for(int i: adj [node]){
            if(!vis[i]){
                if(dfsCheck(adj,i,vis,dfsVis,saf)){
                    return true;
                }
            }
            else if(dfsVis[i]){
                return true;
            }
        }
        saf[node]=true;
        dfsVis[node]=false;
        return false;
    }
}