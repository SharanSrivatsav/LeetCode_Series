class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // finding the number of complete components
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int a[]:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }
        // we can use dfs as well as bfs to solve the Graph Problems
        boolean vis [] = new boolean[n];
        int count[] = new int[2];
        int res = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(i,adj,count,vis);
                int val = (count[0]*(count[0]-1))/2;
                if(val==count[1]/2){
                    res++;
                }
                count = new int[2];
            }
        }
        return res;
    }
    public void bfs(int node ,List<List<Integer>> adj , int count[], boolean vis[]){
         Queue<Integer> bq = new LinkedList<>();
         vis[node]=true;
         bq.add(node);
         count[0]++;
         while(!bq.isEmpty()){
            int tempNode = bq.poll();
            for(int i:adj.get(tempNode)){
                count[1]++;
                if(!vis[i]){
                    count[0]++;
                    bq.add(i);
                    vis[i]=true;
                }
            }
         }
    }
}