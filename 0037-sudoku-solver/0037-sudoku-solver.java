class Solution {
    public void solveSudoku(char[][] board) {
        int m = 9, n = 9;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    if (solve(board, i, j)) {
                        return;
                    }
                }
            }
        }
    }

    public static boolean solve(char grid[][], int r, int c) {
        if (r == 9) {
            return true;
        }
        if (c == 9) {
            return solve(grid, r + 1, 0);
        }
        if(grid[r][c]!='.'){
            return solve(grid,r,c+1);
        }
        for(char ch ='1';ch<='9';ch++){
            if(isValid(ch,grid,r,c)){
                grid[r][c]=ch;
                if(solve(grid,r,c+1)){
                    return true;
                }
                else{
                    grid[r][c]='.';
                }
            }
        }
        return false;
    }

    public static boolean isValid(char c, char grid[][], int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (grid[k][j] == c) {
                return false;
            }
        }
        for(int k =0;k<9;k++){
            if(grid[i][k]==c){
                return false;
            }
        }
        int row = (i/3)*3;
        int col = (j/3)*3;
        for(int k = row;k<row+3;k++){
            for(int p=col;p<col+3;p++){
                if(grid[k][p]==c){
                    return false;
                }
            }
        }
        return true;
    }
}