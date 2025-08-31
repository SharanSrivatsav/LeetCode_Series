class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res [] = new int [numCourses];
        List<List<Integer>> adj =  new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add( new ArrayList<>());
        int inDegree [] = new int[numCourses];
        for(int a [] : prerequisites ){
            adj.get(a[1]).add(a[0]);
            inDegree[a[0]]++;
        }
        Queue<Integer> tq = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                tq.add(i);
            }
        }
        int pointer =0;
        while(!tq.isEmpty()){
            int node = tq.poll();
            res[pointer++]=node;
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    tq.add(i);
                }
            }
        }
        for(int i:inDegree){
            if(i!=0){
                return new int []{};
            }
        }
        return res;
    }
}