class Solution {
    static int rd [] = {-1,1,0,0};
    static int cd [] = {0,0,-1,1};
    private static boolean v [] [];
    public static void dfs (int r , int c, char [][]grid){
        if(r<0||c<0||r>=v.length||c>=v[0].length||v[r][c]||grid[r][c]=='0'){
              return;
        }
        v[r][c]=true;
        for(int i=0;i<4;i++){
            dfs(r+rd[i],c+cd[i],grid);
        }
    }
    public int numIslands(char[][] grid) {
       int m = grid.length;
       int n =grid[0].length;
       int noi=0;
       v= new boolean [m][n];
       for(int i=0;i<m;i++){
         for(int j=0;j<n;j++){
            if(grid[i][j]=='1'&&!v[i][j]){
                dfs(i,j,grid);
                noi++;
            }
         }
       }
      return noi;
    }
}