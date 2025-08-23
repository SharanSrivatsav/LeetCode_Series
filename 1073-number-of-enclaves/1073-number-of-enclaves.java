class pair {
    int x;
    int y;

    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int numEnclaves(int[][] grid) {
      // we are writting a bfs solution 
      Queue<pair> bq  = new LinkedList<>();
      boolean v[][] = new boolean [grid.length][grid[0].length];
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1&&(i==0||i==grid.length-1||j==0||j==grid[0].length-1)){
               bq.add( new pair(i,j));
               v[i][j]=true;
            }
        }
      }
      int rd [] = {1,-1,0,0};
      int cd [] = {0,0,1,-1};
      while(!bq.isEmpty()){
        pair p = bq.poll();
        int r= p.x;
        int c= p.y;
        for(int i=0;i<4;i++){
            int nr = r+rd[i];
            int nc = c+cd[i];
            if((nr>=0&&nr<grid.length)&&(nc>=0&&nc<grid[0].length)&&(!v[nr][nc] && grid[nr][nc]==1)){
                bq.add( new pair(nr,nc));
                v[nr][nc] = true;
            }
        }
      } 
      int count =0;
      for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1&&!v[i][j]){
               count++;
            }
        }
      }
      return count;
    }
}