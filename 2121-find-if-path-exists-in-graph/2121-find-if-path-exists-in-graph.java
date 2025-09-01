class Solution {
    public boolean validPath(int n, int[][] edges, int source, int dest) {
        if(source==dest){
            return true;
        }
        List<List<Integer>> adj  = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a [] : edges){
            adj.get(a[1]).add(a[0]);
            adj.get(a[0]).add(a[1]);
        }
        boolean vis [] = new boolean [n];
        Queue<Integer> bq  =  new LinkedList<>();
        bq.add(source);
        vis[source]=true;
        while(!bq.isEmpty()){
            int node = bq.poll();
            for(int i:adj.get(node)){
                if(i==dest){
                    return true;
                }
                if(!vis[i]){
                    bq.add(i);
                    vis[i]=true;
                }
            }
        }
        return false;
    }
}