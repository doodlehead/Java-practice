import java.util.Arrays;

public class RottingOranges {
    //0 - empty
    //1 - fresh
    //2 - rotten
    //Max grid size is (10 x 10)
    //Runtime: 2 ms
    //Memory usage: 39 MB
    public int orangesRotting(int[][] grid) {
        int turnCount = 0;
        boolean changesMade; //Keep track if the grid is changing

        do {
            changesMade = false;
            int[][] newGrid = new int[grid.length][grid[0].length];

            for (int y = 0; y < grid.length; y++) {
                for (int x = 0; x < grid[y].length; x++) {
                    if (grid[y][x] == 1) {
                        if (hasRottenAround(grid, new int[]{ x, y })) {
                            //Orange is now rotten
                            newGrid[y][x] = 2;
                            changesMade = true;
                        } else {
                            newGrid[y][x] = 1;
                        }
                    }
                    //Don't do anything for empty spaces
                }
            }
            grid = newGrid;
            turnCount++;
        } while (changesMade);

        //TODO: check if there are any fresh oranges left
        boolean isFreshLeft = hasFreshOranges(grid);

        if (isFreshLeft) {
            return -1;
        } else {
            return turnCount - 1;
        }
    }

    //Check if the grid has any fresh oranges in it
    public boolean hasFreshOranges(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return true;
            }
        }
        return false;
    }

    //Does this square have any rotten oranges around it?
    public boolean hasRottenAround(int[][] grid, int[] index) {
        int x = index[0];
        int y = index[1];

        if (y - 1 >= 0 && grid[y-1][x] == 2)
            return true;
        if (x + 1 < grid[0].length && grid[y][x+1] == 2)
            return true;
        if (y + 1 < grid.length && grid[y+1][x] == 2)
            return true;
        if (x - 1 >= 0 && grid[y][x-1] == 2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        var ro = new RottingOranges();

        int[][] grid = new int[][]{
                {2,1,1},
                {1,1,0},
                {0,1,1}};

        System.out.println(ro.orangesRotting(grid));
    }
}
