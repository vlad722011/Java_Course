package TasksAboutEightQueens;

public class EightQueensHashMap {
    private static final int BOARD_SIZE = 8;
    private static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    public static boolean canPlaceQueen(int row, int col) {
        // check row on left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }
        // check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // check lower diagonal on left side
        for (int i = row, j = col; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveQueens(int col) {
        if (col == BOARD_SIZE) {
            // solution found
            return true;
        }
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (canPlaceQueen(i, col)) {
                board[i][col] = 1;
                if (solveQueens(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        if (solveQueens(0)) {
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    if (board[i][j] == 1) {
                        System.out.print("Q ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
        } else {
            System.out.println("Solution is not possible");
        }
    }
}


