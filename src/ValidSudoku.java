import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    //Do a regular, brute-force check
    //Runtime: 3 ms
    //Memory usage: 39.8 MB
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row = new HashSet<>();
        Set<Character> col = new HashSet<>();

        //Vertical and horizontal rows
        for (int i = 0; i < board.length; i++) {
            row.clear();
            col.clear();
            for (int p = 0; p < board.length; p++) {
                if (row.contains(board[i][p])) return false;
                else if (board[i][p] != '.') {
                    row.add(board[i][p]);
                }

                if (col.contains(board[p][i])) return false;
                else if (board[p][i] != '.') {
                    col.add(board[p][i]);
                }
            }
        }

        //3 x 3 squares
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                row.clear();
                for (int y2 = 0; y2 < 3; y2++) {
                    for (int x2 = 0; x2 < 3; x2++) {
                        if (row.contains(board[y*3 + y2][x*3 + x2])) return false;
                        else if (board[y*3 + y2][x*3 + x2] != '.') {
                            row.add(board[y*3 + y2][x*3 + x2]);
                        }
                    }
                }
            }
        }

        return true;
    }
}
