package sudoku;

public class Sudoku {

    private final int[][] finishedBoard;
    private int[][] unfinishedBoard;

    public Sudoku() {
        finishedBoard = new int[9][9];
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                int random = (int) (Math.random() * 9 + 1);
                finishedBoard[x][y] = random;
                if (!pieceIsValid(x, y, finishedBoard))
                    y--;
            }
        }

    }

    private boolean pieceIsValid(int row, int col, int[][] array) {
        for (int x = 0; x < 9; x++) {
            if (x != col && array[row][col] == array[row][x]) {
                return false;
            }
            if (x != row && array[row][col] == array[x][col]) {
                return false;
            }
        }

        if (row < 3) {
            if (col < 3) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            } else if (col < 6) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }

            } else if (col < 9) {
                for (int x = 0; x < 3; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            }
        } else if (row < 6) {
            if (col < 3) {
                for (int x = 3; x < 6; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }

            } else if (col < 6) {
                for (int x = 3; x < 6; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            } else if (col < 9) {
                for (int x = 3; x < 6; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            }
        } else if (row < 9) {
            if (col < 3) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 0; y < 3; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            } else if (col < 6) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 3; y < 6; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            } else if (col < 9) {
                for (int x = 6; x < 9; x++) {
                    for (int y = 6; y < 9; y++) {
                        if (x != row && y != col && array[row][col] == array[x][y]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}
