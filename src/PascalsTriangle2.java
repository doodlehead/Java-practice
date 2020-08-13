import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    //k <= 33

    //Only use O(k) extra space
    //Runtime: 1 ms
    //Memory usage: 37 MB
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) return List.of(1);

        ArrayList<Integer> row = new ArrayList<>(rowIndex+1);

        int lastIndex = 0;

        for (int i = 0; i <= rowIndex; i++) {
            row.add(1);

            //Process the rest of the row
            for (int k = lastIndex - 1; k >= 0; k--) {
                int prevVal = (k - 1 >= 0) ? row.get(k - 1) : 0;
                row.set(k, prevVal + row.get(k));
            }
            lastIndex++;
        }
        return row;
    }

    //Use Binomial theorem
    //Numbers are too big :'(
    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex == 0) return List.of(1);

        List<Integer> row = new ArrayList<>();

        for (int i = 0; i <= rowIndex / 2; i++) {
            row.add(fact(rowIndex - i, rowIndex)/factorial(i));
        }

        //mirror
        for (int i = (rowIndex - 1) / 2; i >= 0; i--) {
            row.add(row.get(i));
        }

        return row;
    }

    //Excludes start
    public static int fact(int start, int end) {
        assert end >= start : "end must be >= than start";

        if (end == start) return 1;

        int res = 1;
        for (int i = start + 1; i <= end; i++) {
            res *= i;
        }
        return res;
    }

    public static int factorial(int num) {
        assert num >= 0 : "Can't do negative factorial";
        int res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }
}
