class Solution {
    static boolean v[][];
    static int rd[] = { -1, 1, 0, 0 };
    static int cd[] = { 0, 0, -1, 1 };

    public boolean exist(char[][] board, String word) {
        boolean paii = false;
        v = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // if the character is 1st character of the string we are starting the search
                if (board[i][j] == word.charAt(0) && !v[i][j]) {
                    paii = dfs(i, j, board, word, 0);
                    // if the search result is true we are returing it
                    // (bcos after this the next search will return false which will change the
                    // result)
                    if (paii) {
                        return paii;
                    }
                }
            }
        }
        // final call
        return paii;
    }

    public static boolean dfs(int r, int c, char[][] board, String word, int wi) {
        // if word index equals to length means the word is present hence returning true
        if (wi == word.length()) {
            return true;
        }
        // if index limit exceeds or the char is not at string the particular false
        // becomes false
        if (r >= board.length || c >= board[0].length || r < 0 || c < 0 || board[r][c] != word.charAt(wi) || v[r][c]) {
            return false;
        }
        // if above two con fail (we are making v grid true) bcos it is char at string
        // in somewhere of the middle
        v[r][c] = true;
        // after that the wordindex is incremented
        wi = wi + 1;
        // a return variable is created
        boolean z = false;
        for (int i = 0; i < 4; i++) {
            // recursive call of dfs is done with same word index for all 4 directions
            z = dfs(r + rd[i], c + cd[i], board, word, wi);
            /*
             * if any call has the value it backs and return true
             * ex 1st call = false (then i is incremented)
             * 2nd call = true (then z becomes true)
             */
            // if z is true we are backtracking the value
            if (z) {
                // this value is bactracked to the previous call
                return z;
            }
        }
        // (undo call) if everything happens and no true is found
        // and hence
        v[r][c] = false;
        return false;
    }
}