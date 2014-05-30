package sudoku;

import java.util.ArrayList;

public class SolutionGenerator {

    private int timeOut;
    private int masterTimeOut;
    private int[][] finishedBoard;
    private int[][] unfinishedBoard;

    public SolutionGenerator(int difficulty) {
        timeOut = 0;
        masterTimeOut = 0;
        finishedBoard = new int[9][9];
        unfinishedBoard = new int[9][9];
        for (int x = 0; x < 9; x++) {

            ArrayList<Integer> remains = new ArrayList<>();
            for (int p = 1; p <= 9; p++) {
                remains.add(p);
            }
            for (int y = 0; y < 9; y++) {
                if (masterTimeOut == 10) {
                    finishedBoard = new int[9][9];
                    y = 0;
                    x = 0;
                    remains = new ArrayList<>();
                    for (int p = 1; p <= 9; p++) {
                        remains.add(p);
                    }
                    masterTimeOut = 0;
                }
                if (timeOut == 100) {
                    for (int z = 0; z < 9; z++) {
                        finishedBoard[x][z] = 0;
                        y = 0;
                        remains = new ArrayList<>();
                        for (int p = 1; p <= 9; p++) {
                            remains.add(p);
                        }
                    }
                    masterTimeOut++;
                }
                int random = (int) (Math.random() * remains.size());
                int rand = remains.get(random);
                finishedBoard[x][y] = rand;
                if (!pieceIsValid(x, y, finishedBoard)) {
                    y--;
                    timeOut++;
                } else {
                    remains.remove(remains.indexOf(rand));
                    timeOut = 0;
                }

            }
        }
        unfinishedBoard = makeUnfinished(finishedBoard, difficulty);

    }

    private boolean pieceIsValid(int row, int col, int[][] array) {
        for (int x = 0; x < 9; x++) {
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

    private int[][] makeUnfinished(int[][] arr, int amount) {
        // Easy: Remove 45
        // Medium: Remove 50
        // Hard: Remove 55

        for (int x = 0; x < amount; x++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (arr[row][col] != 0) {
                arr[row][col] = 0;
            } else {
                x--;
            }
        }
        return arr;
    }

    public int getNumber(int row, int column) {
        return unfinishedBoard[row][column];
    }
    
    public int [][] solve() {
        return finishedBoard;
    }

}
