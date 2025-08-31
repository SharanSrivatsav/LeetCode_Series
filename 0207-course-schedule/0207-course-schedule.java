class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int a[]:prerequisites){
            adj.get(a[0]).add(a[1]);
        }
        boolean vis[] = new boolean [numCourses];
        boolean pathVis []=  new boolean [numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfsCheck(adj,vis,pathVis,i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfsCheck (List<List<Integer>> adj , boolean vis[],boolean pathVis[],int node){
        vis[node] = true;
        pathVis[node] = true;
        for(int i : adj.get(node)){
            if(!vis[i]){
                if(dfsCheck(adj,vis,pathVis,i)){
                    return true;
                }
            }
            else if(pathVis[i]){
                  return true;
            }
        }
        pathVis[node]=false;
        return false;
    }
}