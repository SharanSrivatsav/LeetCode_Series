class Solution {
    public int findCenter(int[][] edges) {
        int val = -1;
        int prev[] = edges[0];
        int curr[] = edges[1];
        if(prev[0]==curr[0]||prev[0]==curr[1]){
            return prev[0];
        }
        if(prev[1]==curr[0]||prev[1]==curr[1]){
            return prev[1];
        }
        return -1;
    }
}