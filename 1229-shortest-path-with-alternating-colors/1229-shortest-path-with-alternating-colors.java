class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Pair>> adj = new ArrayList<>();
        int arr[] = new int[n];
        //Array Filling
        adj.add(new ArrayList<>());
        for(int i=1;i<n;i++){
           arr[i] = -1;
           adj.add(new ArrayList<>());
        }
        for( int red [] : redEdges){
            adj.get(red[0]).add(new Pair(red[1],0));
        }
        for(int blue [] : blueEdges){
            adj.get(blue[0]).add(new Pair(blue[1],1));
        }
        bfs(adj,0,0,arr);
        bfs(adj,0,1,arr);
        return arr;
    }
    public void bfs(List<List<Pair>> adj , int node, int col, int res []){
        boolean vis [][] = new boolean[adj.size()][2];
        vis[node][col] = true;
        Queue<Pair> bq =  new LinkedList<>();
        bq.add(new Pair(node,col));
        int dist = 0;
        while(!bq.isEmpty()){
            int en = bq.size();
            for(int i=0;i<en;i++){
                Pair val = bq.poll();
                for(Pair  p :adj.get(val.x)){
                    if(!vis[p.x][p.y]&&p.y!=val.y){
                        bq.add(p);
                        vis[p.x][p.y]=true;
                        if(res[p.x]>=0){
                            res[p.x]=Math.min(res[p.x],dist+1);
                        }
                        else{
                            res[p.x]= dist+1;
                        }
                    }
                }
            }
            dist++;
        }
    }
}