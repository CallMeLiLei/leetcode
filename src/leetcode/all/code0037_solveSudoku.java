package leetcode.all;

/**
 * 解数独
 */
public class code0037_solveSudoku {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    row[i][index] = true;
                    col[j][index] = true;
                    block[blockIndex][index] = true;
                }
            }
        }

        backTrace(board, row, col, block, 0, 0); // 回溯算法去填写棋盘
    }

    private boolean backTrace(char[][] board, boolean[][] row, boolean[][] col, boolean[][] block, int i, int j) {

        while (board[i][j] != '.') {
            if (++j > 9) {
                i++;
                j = 0;
            }

            if (i >= 9) {
                return true; // 最后一行也已经填写完成，说明整个棋盘都已经填写完成
            }
        }

        for (int k = 0; k < 9; k++) {
            int index = i / 3 * 3 + j / 3;
            if (!row[i][k] || !col[j][k] || !block[index][k]) {
                board[i][j] = (char) ('1' + k); //试着填写上一个数
                row[i][k] = true;
                col[j][k] = true;
                block[index][k] = true;

                if (backTrace(board, row, col, block, i, j)) {  // 继续去填写棋盘
                    return true;
                } else {  // 上一个阶段失败
                    row[i][k] = false;
                    col[j][k] = false;
                    block[index][k] = false;
                    board[i][j] = '.';
                }
            }
        }
        return false;
    }
}
