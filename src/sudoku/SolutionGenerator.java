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
                if (Utility.pieceIsValid(x, y, finishedBoard)) {
                    remains.remove(remains.indexOf(rand));
                    timeOut = 0;
                } else {
                    y--;
                    timeOut++;
                }

            }
        }

        unfinishedBoard = makeUnfinished(finishedBoard, difficulty);

    }

    private int[][] makeUnfinished(int[][] arr, int amount) {
        // Easy: Remove 45
        // Medium: Remove 50
        // Hard: Remove 55

        int[][] temp = new int[9][9];

        for (int x = 0; x < 9; x++) {
            System.arraycopy(arr[x], 0, temp[x], 0, 9);
        }
        for (int x = 0; x < amount; x++) {
            int row = (int) (Math.random() * 9);
            int col = (int) (Math.random() * 9);
            if (temp[row][col] != 0) {
                temp[row][col] = 0;
            } else {
                x--;
            }

        }
        return temp;
    }

    public int getNumber(int row, int column) {
        return unfinishedBoard[row][column];
    }

    public int[][] solve() {
        return finishedBoard;
    }

}
