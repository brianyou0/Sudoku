package sudoku;

public class Board {

    private SudokuPiece[][] board;
    private SudokuPiece[][] solution;

    public Board() {
        board = new SudokuPiece[9][9];
        solution = new SudokuPiece[9][9];
    }

    public void newGame() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                board[x][y] = new SudokuPiece(x, y, null);
            }
        }
    }
    
    public boolean isValid(int row, int column) {
        
    }

}

