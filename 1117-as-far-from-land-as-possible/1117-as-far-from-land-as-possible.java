class pair{
    int x;
    int y;
    pair(int x, int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][]= new boolean [m][n];
        Queue<pair>  bq = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    bq.add(new pair(i,j));
                    vis[i][j]=true;
                }
            }
        }
        int dist =0;
        int rd [] ={-1,1,0,0};
        int cd [] = {0,0,-1,1};
        while(!bq.isEmpty()){
            int en = bq.size();
            //polling count
            for(int j=0;j<en;j++){
                pair t =  bq.poll();
                int a =t.x;
                int b =t.y;
                for(int i=0;i<4;i++){
                    int r=a+rd[i];
                    int c=b+cd[i];
                    if(r<0||c<0||r>=m||c>=n||vis[r][c]||grid[r][c]==1){
                        continue;
                    }
                    bq.add(new pair(r,c));
                    vis[r][c]=true;
                }
            }
            // after every polling the distance increases 
            dist++;
        }
        if(dist==1){
            return -1;
        }
        return dist-1;
    }
}