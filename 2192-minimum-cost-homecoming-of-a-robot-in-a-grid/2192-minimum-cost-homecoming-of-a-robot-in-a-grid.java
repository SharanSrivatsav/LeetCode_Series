class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
       int res = 0;
       for(int i=startPos[0]+1;i<=homePos[0];i++){
        res+=rowCosts[i];
       }
       for(int i = startPos[1]+1;i<=homePos[1];i++){
        res+=colCosts[i];
       }        
       for(int i=homePos[1];i<=startPos[1]-1;i++){
        res+=colCosts[i];
       }
       for(int i=homePos[0];i<=startPos[0]-1;i++){
        res+=rowCosts[i];
       }
       return res;
    }
}