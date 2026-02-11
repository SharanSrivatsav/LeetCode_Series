class pair {
    int x;
    int y;

    pair(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    private static boolean v[][];
    static int rd[] = { -1, 1, 0, 0 };
    static int cd[] = { 0, 0, -1, 1 };

    public int[][] findFarmland(int[][] land) {
        v = new boolean[land.length][land[0].length];
        ArrayList<int []> res = new ArrayList<>(); 
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
              if(!v[i][j]&&land[i][j]==1){
                pair p = new pair(0,0);
                dfs(land,i,j,p);
                int arr [] = new int []{i,j,p.x,p.y};
                res.add(arr);
              }       
            }
        }
        int ans [] [] = res.toArray(new int [res.size()][4]);
        return ans;
    }

    public static void dfs(int[][] land, int r, int c, pair p) {
        if (r < 0 || c < 0 || r >= land.length || c >= land[0].length || v[r][c] || land[r][c] == 0) {
            return;
        }
        v[r][c] = true;
        p.x = Math.max(p.x, r);
        p.y = Math.max(p.y, c);
        for (int i = 0; i < 4; i++) {
            dfs(land, r + rd[i], c + cd[i], p);
        }
    }
}