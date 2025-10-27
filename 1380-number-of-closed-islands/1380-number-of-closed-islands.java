class Solution {
    static int rd [] = {-1,1,0,0};
    static int cd [] = {0,0,-1,1};
    static boolean vis [] [] ;
    public int closedIsland(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        vis = new boolean [m][n];
        for(int i=0;i<m;i++){
            if(mat[i][0]==0){
                if(!vis[i][0]){
                    fill(mat,i,0);
                }
            }
            if(mat[i][n-1]==0){
                if(!vis[i][n-1]){
                    fill(mat,i,n-1);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(mat[0][i]==0){
                if(!vis[0][i]){
                    fill(mat,0,i);
                }
            }
            if(mat[m-1][i]==0){
                if(!vis[m-1][i]){
                    fill(mat,m-1,i);
                }
            }
        }
        int count =0;
        // all the corner islands are filled clearly
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0&&!vis[i][j]){
                    fill(mat,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public void fill(int [][] grid , int r, int c){
        vis[r][c]=true;
        for(int i=0;i<4;i++){
            int a = r+rd[i];
            int b = c +cd[i];
            if(a<0||b<0||a>=grid.length||b>=grid[0].length||vis[a][b]||grid[a][b]==1){
                continue;
            }
            fill(grid,a,b);
        }
    }
}