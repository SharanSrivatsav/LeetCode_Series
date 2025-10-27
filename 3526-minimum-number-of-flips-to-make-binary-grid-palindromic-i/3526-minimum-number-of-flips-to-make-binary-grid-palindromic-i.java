class Solution {
    public int minFlips(int[][] grid) {
      int rc = 0;
      int cc= 0;
      for(int a [] : grid){
        int st = 0;
        int en = a.length-1;
        while(st<en){
            if(a[st]!=a[en]){
                rc++;
            }
            st++;
            en--;
        }
      }
      for(int i=0;i<grid[0].length;i++){
        int st = 0;
        int en = grid.length-1;
        while(st<en){
            if(grid[st][i]!=grid[en][i]){
                cc++;
            }
            st++;
            en--;
        }
      }
      return Math.min(cc,rc);
    }
}