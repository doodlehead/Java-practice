import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths {
    // (n, m) are between 1, 100

    //Method 1: 2d array to represent the num of possibilities per square
    //m is x, n is y (for the sake of drawing diagrams)
    //Runtime: 2ms
    //Memory usage: 36.6 MB
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;

        int[][] board = new int[m][n];
        board[0][0] = 1; //Starting position

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        //Unreadable code incoming. I'm sorry. Creating a class-based solution seemed like overkill.
        while (!queue.isEmpty()) {
            int[] currentIndex = queue.poll();

            //Set the current tile's value
            if (currentIndex[0] - 1 >= 0) {
                board[currentIndex[0]][currentIndex[1]] += board[currentIndex[0] - 1][currentIndex[1]];
            }
            if (currentIndex[1] - 1 >= 0) {
                board[currentIndex[0]][currentIndex[1]] += board[currentIndex[0]][currentIndex[1] - 1];
            }

            //Add the next tiles to the queue
            if (currentIndex[1] == 0 && currentIndex[0] + 1 < m) { //to the right
                queue.add(new int[]{currentIndex[0] + 1, currentIndex[1]});
            }
            if (currentIndex[1] + 1 < n) { //to the bottom
                queue.add(new int[]{currentIndex[0], currentIndex[1] + 1});
            }
        }
        return board[m-1][n-1];
    }
}
