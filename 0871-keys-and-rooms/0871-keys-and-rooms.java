class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis [] = new boolean[rooms.size()];
        dfs(rooms,0,vis);
        for(boolean z : vis){
            if(!z){
                return false;
            }
        }
        return true;
    }
    public void dfs(List<List<Integer>> adj, int node , boolean v []){
        v[node] = true;
        for(int i : adj.get(node)){
            if(!v[i])
              dfs(adj,i,v);
        }
    }
}