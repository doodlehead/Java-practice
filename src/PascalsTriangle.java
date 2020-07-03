import java.util.*;

public class PascalsTriangle {
    //Runtime: 0 ms
    //Memory usage: 37.5 MB
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) return new ArrayList<List<Integer>>();

        ArrayList<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> base = new ArrayList<>();
        base.add(1);
        result.add(base);

        if (numRows == 1) return result;

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i-1);
            ArrayList<Integer> newRow = new ArrayList<>();
            newRow.add(1);

            //Build the row
            for (int p = 1; p < i; p++) {
                newRow.add(prevRow.get(p-1) + prevRow.get(p));
            }

            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}
