class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        int rd[] = {-1,0,1,0};
        int cd[] ={0,-1,0,1};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    res+=4;
                    for(int k=0;k<4;k++){
                        int r = i+rd[k];
                        int c = j+cd[k];
                        if(r>=0&&c>=0&&r<m&&c<n&&grid[r][c]==1){
                            res-=1;
                        }
                    }
                } 
            }
        }
        return res;
    }
}