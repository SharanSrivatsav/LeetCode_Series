class Solution {
    static int rd[] = { -1, 1, 0, 0 };
    static int cd[] = { 0, 0, -1, 1 };
    boolean vis[][];

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfsCheck(grid, i, j, i, j, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfsCheck(char[][] grid, int r, int c, int pr, int pc, char t) {
        vis[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int a = r + rd[i];
            int b = c + cd[i];
            if (a < 0 || b < 0 || a >= grid.length || b >= grid[0].length || grid[a][b] != t) {
                continue;
            }
            if (vis[a][b] && (a != pr || b != pc)) {
                return true;
            }
            if (!vis[a][b]) {
                if (dfsCheck(grid, a, b, r, c, t)) {
                    return true;
                }
            }
        }
        return false;
    }
}