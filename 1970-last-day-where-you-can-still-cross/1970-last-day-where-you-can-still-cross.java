class Pair{
    int x ;
    int y ;
    Pair(int x , int y){
        this.x=x;
        this.y=y;
    }
}
class Solution {
    static int rd [] = {-1,0,1,0};
    static int cd [] = {0,-1,0,1};
    public int latestDayToCross(int row, int col, int[][] cells) {
        int st = 0;
        int en = cells.length-1;
        int ans = -1;
        while(st<=en){
            int mid = st+(en-st)/2;
            if(isPos(row,col,cells,mid)){
                ans = mid;
                st= mid+1;
            }
            else{
                en = mid-1;
            }
        }
        return ans+1;
    }
    public boolean isPos(int r , int c, int cells[][], int mid){
        int grid [][] = new int[r][c];
        boolean vis [][] = new boolean[r][c];
        for(int a [] : grid){
            Arrays.fill(a,1);
        }
        for(int i=0;i<=mid;i++){
            int a [] = cells[i];
            grid[a[0]-1][a[1]-1]=0;
        }
        // grid is filled with water properly
        Queue<Pair> bq = new LinkedList<>();
        for(int i=0;i<c;i++){
            if(grid[0][i]!=0){
                bq.add(new Pair(0,i));
                vis[0][i] = true;
            }
        }
        while(!bq.isEmpty()){
            Pair t = bq.poll();
            if(t.x==r-1){
                return true;
            } 
            for(int i=0;i<4;i++){
                int nr = t.x+rd[i];
                int nc = t.y+cd[i];
                if(nr>=0&&nc>=0&&nr<r&&nc<c&&!vis[nr][nc]&&grid[nr][nc]!=0){
                    bq.add(new Pair(nr,nc));
                    vis[nr][nc]=true;
                }
            }
        }
        return false;
    }
}