import java.util.*;
import java.util.Arrays;

class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public static int[] rd = {1, -1, 0, 0};
    public static int[] cd = {0, 0, 1, -1};

    public int maximumMinutes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = distGen(grid);
        
        int st = 0;
        int en = m * n;
        int ans = -1;
        
        while (st <= en) {
            int mid = st + (en - st) / 2;
            if (isPos(grid, mid, dist)) {
                ans = mid;
                st = mid + 1;
            } else {
                en = mid - 1;
            }
        }
        if(ans==m*n){
            return 1000000000;
        }
        return ans;
    }

    public int[][] distGen(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> bq = new LinkedList<>();
        int[][] dist = new int[m][n];
        
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        // Initialize fire sources
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bq.add(new Pair(i, j));
                    vis[i][j] = true;
                    dist[i][j] = 0;
                }
            }
        }
        
        int time = 1;
        while (!bq.isEmpty()) {
            int size = bq.size();
            for (int i = 0; i < size; i++) {
                Pair temp = bq.poll();
                int a = temp.x;
                int b = temp.y;
                
                for (int d = 0; d < 4; d++) {
                    int r = a + rd[d];
                    int c = b + cd[d];
                    
                    if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || grid[r][c] == 2) {
                        continue;
                    }
                    
                    dist[r][c] = time;
                    vis[r][c] = true;
                    bq.add(new Pair(r, c));
                }
            }
            time++;
        }
        
        return dist;
    }

    public boolean isPos(int[][] grid, int mid, int[][] dist) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> bq = new LinkedList<>();
        
        // Check if starting cell is safe after waiting mid minutes
        if (dist[0][0] <= mid) {
            return false;
        }
        
        bq.add(new Pair(0, 0));
        vis[0][0] = true;
        int time = mid + 1; // We've waited mid minutes, now start moving
        
        while (!bq.isEmpty()) {
            int size = bq.size();
            for (int i = 0; i < size; i++) {
                Pair temp = bq.poll();
                int a = temp.x;
                int b = temp.y;
                
                if (a == m - 1 && b == n - 1) {
                    return true;
                }
                
                for (int d = 0; d < 4; d++) {
                    int r = a + rd[d];
                    int c = b + cd[d];
                    
                    if (r < 0 || c < 0 || r >= m || c >= n || vis[r][c] || grid[r][c] == 2) {
                        continue;
                    }
                    
                    // For safehouse, we can arrive at the same time as fire
                    if (r == m - 1 && c == n - 1) {
                        if (dist[r][c] >= time) {
                            vis[r][c] = true;
                            bq.add(new Pair(r, c));
                        }
                    } 
                    // For other cells, fire must arrive after we leave
                    else if (dist[r][c] > time) {
                        vis[r][c] = true;
                        bq.add(new Pair(r, c));
                    }
                }
            }
            time++;
        }
        
        return false;
    }
}