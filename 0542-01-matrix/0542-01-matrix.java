class place {
    int x;
    int y;
    int z;

    place(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }
}

class Solution {
    static int rd[] = { -1, 1, 0, 0 };
    static int cd[] = { 0, 0, -1, 1 };
    static boolean v [][];    
public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        v = new boolean[m][n];
        int ans[][] = new int[m][n];
        Queue<place> bq = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    v[i][j] = true;
                    ans[i][j] = 0;
                    bq.add(new place(i, j, 0));
                } else {
                    ans[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        bfs(ans, mat, bq);
        return ans;
    }

    public static void bfs(int ans[][], int mat[][], Queue<place> bq) {
        int m = mat.length;
        int n = mat[0].length;
        while (!bq.isEmpty()) {
            place p = bq.poll();
            int x = p.x;
            int y = p.y;
            int dist = p.z;
            for (int i = 0; i < 4; i++) {
                int r = x + rd[i];
                int c = y + cd[i];
                if (r < 0 || c < 0 || r >= m || c >= n || v[r][c]) {
                    continue;
                }
                ans[r][c] = Math.min(ans[r][c], dist + 1);
                v[r][c] = true;
                bq.add(new place(r, c, dist + 1));
            }
        }
    }
}