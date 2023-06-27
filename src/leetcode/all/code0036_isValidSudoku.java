package leetcode.all;

/**
 * 有效的数独
 * 1——9在每行里只能出现一次
 * 1——9在每列里只能出现一次
 * 1——9在每个3x3的块里只能出现一次
 *  每一个都用二维数组来存放1——9是否存在
 *
 */
public class code0036_isValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[index][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[index][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
