class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '1'; 
                int mask = 1 << num; 
                int boxIndex = (i / 3) * 3 + j / 3;
                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }
}