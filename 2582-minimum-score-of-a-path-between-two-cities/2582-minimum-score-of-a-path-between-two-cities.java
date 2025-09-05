class pair{
    int x; 
    int y ;
    pair(int x , int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        int min = Integer.MAX_VALUE;
        List<List<pair>> adj = new ArrayList<>();
        for(int i=0; i<=n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int cit [] : roads){
            int a = cit[0];
            int b = cit[1];
            int dist = cit[2];
            adj.get(b).add( new pair(a,dist));
            adj.get(a).add( new pair(b,dist));
        }
        boolean vis [] = new boolean [n+1];
        int val = dfs(adj,vis,1,Integer.MAX_VALUE);
        min = Math.min(val,min);
        return min;
    }
    public int dfs(List<List<pair>> adj,boolean vis [], int node, int min){
        vis[node]=true;
        for(pair i : adj.get(node)){
            min = Math.min(min,i.y);
            // even though we may have visited a city in a previous call
            // in the new call there may be an another road to that city 
            // so we need to find min of all roads
            //(a->b->c) is done c is visited
            //(a->c) is not done and hence we are working for it by calculating min
            if(!vis[i.x]){
                int val = dfs(adj,vis,i.x,min);
                min = Math.min(val,min);
            }
        }
        return min;
    }
}