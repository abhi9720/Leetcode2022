class Solution {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    if (!canPlace(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    boolean canPlace(char[][] board, int i, int j, char toplace) {
        int x1 = i - i % 3;
        int y1 = j - j % 3;

        for (int x = x1; x <= x1 + 2; x++) {
            for (int y = y1; y <= y1 + 2; y++) {
                if (x != i && y != j) if (board[x][y] == toplace) return false;
            }
        }

        for (int x = 0; x < board.length; x++) {
            if (x != i) if (board[x][j] == toplace) return false;
        }

        for (int y = 0; y < board.length; y++) {
            if (y != j) if (board[i][y] == toplace) return false;
        }
        return true;
    }
}
