class Solution {
    static int count;

    public int totalNQueens(int n) {
        count = 0;
        char b[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = '.';
            }
        }
        solver(b, 0);
        return count;
    }

    public static void solver(char b[][], int r) {
        int m = b.length;
        if (r == m) {
            count++;
            return;
        }
        for (int i = 0; i < m; i++) {
            if (isValid(b, r, i)) {
                b[r][i] = 'Q';
                solver(b, r + 1);
                b[r][i] = '.';
            }
        }
    }

    public static boolean isValid(char b[][], int r, int c) {
        int m = b.length;
        // checking - the row 
        for (int i = c - 1; i >= 0; i--) {
            if (b[r][i] == 'Q') {
                return false;
            }
        }
        for (int i = 0; i < r; i++) {
            if (b[i][c] == 'Q')
                return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < b.length; i--, j++) {
            if (b[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}