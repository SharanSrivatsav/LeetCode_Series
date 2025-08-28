class Solution {
    public boolean isBipartite(int[][] graph) {
        int col [] = new int[graph.length];
        for(int i=0;i<graph.length;i++) col[i]=-1;
        for(int i =0;i<graph.length;i++){
            if(col[i]==-1){
                if(bfs(i,graph,col)){
                    return false;
                }
            }
        }
        return true;
    }
    private boolean bfs(int node,int [][] adj, int col []){
        Queue<Integer> bq = new LinkedList<>();
        col[node]=0;
        bq.add(node);
        while(!bq.isEmpty()){
            int val = bq.poll();
            for( int i: adj[val]){
                if(col[i]==-1){
                    col[i]=1-col[val];
                    bq.add(i);
                }
                else{
                    if(col[i]==col[val]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}