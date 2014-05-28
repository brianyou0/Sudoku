package sudoku;

/**
 *
 * @author 15liaudavid
 */
public class SudokuMain {
    public static void main(String[] args){
           /*int n = 2;
   int[][] field = new int[n*n][n*n];
    for (int i = 0; i < n*n; i++){
        for (int j = 0; j < n*n; j++){
                field[i][j] = (i*n + i/n + j) % (n*n) + 1;
        System.out.println(field[i][j]);
        }
    }*/
        Board board = new Board();
        board.generateBoard();
    }
}
