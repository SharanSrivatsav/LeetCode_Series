// flood fill algorithm
class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// pair is created
class Solution {
    static boolean vis[][];
    static int rd[] = { -1, 1, 0, 0 };
    static int cd[] = { 0, 0, -1, 1 };

    public int shortestBridge(int[][] grid) {
        // we need to group the islands first
        int m = grid.length;
        int n = grid[0].length;
        int doiii = 0;
        vis = new boolean [m][n];
        Queue <Pair> bq =  new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    bq = floodFill(grid,new Pair(i,j));
                    doiii = 1;
                    break;
                }
            }
            if(doiii==1){
                break;
            }
        }
        int bridge = 0;
        while(!bq.isEmpty()){
            int s = bq.size();
            for(int i=0;i<s;i++){
                Pair t = bq.poll();
                int a = t.x;
                int b = t.y;
                for(int j=0;j<4;j++){
                    int r = a+rd[j];
                    int c = b+cd[j];
                    if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c]) {
                        continue;
                    }
                    if(grid[r][c]==1){
                        return bridge;
                    }
                    bq.add(new Pair(r,c));
                    vis[r][c]=true;
                }
            } 
            bridge++;     
         }
         return bridge;
    }

    public Queue floodFill(int grid[][], Pair p) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> bq = new LinkedList<>();
        Queue<Pair> res = new LinkedList<>();
        bq.add(p);
        res.add(p);
        vis[p.x][p.y] = true;
        while (!bq.isEmpty()) {
            int s = bq.size();
            for (int i = 0; i < s; i++) {
                Pair t = bq.poll();
                int a = t.x;
                int b = t.y;
                for (int j = 0; j < 4; j++) {
                    int r = a + rd[j];
                    int c = b + cd[j];
                    if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || grid[r][c] == 0) {
                        continue;
                    }
                    vis[r][c] = true;
                    bq.add(new Pair(r, c));
                    res.add(new Pair(r,c));
                }
            }
        }
        return res;
    }
}